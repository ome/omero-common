/*
 *   $Id$
 *
 *   Copyright 2008 Glencoe Software, Inc. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */
package ome.system.utests;

import java.util.Properties;

import ome.system.PreferenceContext;

import org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Ignore;

@Test(groups = "ticket:800")
public class PrefsTest {

    public final static String testDefault = "test_default";

    PreferenceContext ctx;
    String oldDefault;

    @Test
    public void testSimple() {
        ctx = new PreferenceContext();
        System.setProperty("test", "ok"); // ticket:2214
        Assert.assertEquals(ctx.getProperty("test"), "ok");
    }

    // Locals

    @Test
    public void testSystemOverridesLocals() {

        String key = "localsOverrideSystem";

        System.setProperty(key, "false");

        Properties p = new Properties();
        p.setProperty(key, "true");

        ctx = new PreferenceContext();
        ctx.setProperties(p);

        Assert.assertEquals(ctx.getProperty(key), "false");
    }

    @Test
    public void testLocalsOverrideFiles() {

        String key = "localsOverridesFiles";

        Properties p = new Properties();
        p.setProperty(key, "true");

        ctx = new PreferenceContext();
        ctx.setProperties(p);
        ctx.setIgnoreResourceNotFound(false);
        ctx.setLocations(new Resource[] { new ClassPathResource(
                "ome/system/utests/Prefs.properties") });

        Assert.assertEquals(ctx.getProperty(key), "true");

    }

    // System

    /**
     * Currently the {@link PreferencesPlaceholderConfigurer} does not use the
     * {@link System#getProperties()} to as
     * {@link PropertyPlaceholderConfigurer} does. We may need to modify
     * {@link PreferenceContext} to do so.
     */
    @Test(groups = "broken")
    public void testSystemOverridesFiles() {

        String key = "systemOverridesFiles";

        System.setProperty(key, "true");

        ctx = new PreferenceContext();
        ctx.setIgnoreResourceNotFound(false);
        ctx.setLocations(new Resource[] { new ClassPathResource(
                "ome/system/utests/Prefs.properties") });

        Assert.assertEquals(ctx.getProperty(key), "true");

    }

    @Test
    public void testMissingFilesOk() {
        ctx = new PreferenceContext();
        ctx.setLocations(new Resource[] { new ClassPathResource(
                "DOES_NOT_EXIST") });
        ctx.getProperty("test");
    }

    @Ignore("To re-enable when we sort out version handling")
    @Test
    public void testOmeroVersion() {
        ctx = new PreferenceContext();
        ctx.setLocation(new ClassPathResource("omero.properties"));
        String v = ctx.getProperty("omero.version");
        Assert.assertNotNull(v);
        Assert.assertTrue(v.length() > 0);
    }

}
