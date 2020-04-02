/*
 *   $Id$
 *
 *   Copyright 2006 University of Dundee. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */
package ome.system.utests;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Properties;
import ome.conditions.ApiUsageException;
import ome.system.Login;


public class LoginTest {

    @Test(expectedExceptions = ApiUsageException.class)
    public void test_null_user() throws Exception {
        new Login(null, "");
    }

    @Test(expectedExceptions = ApiUsageException.class)
    public void test_null_password() throws Exception {
        new Login("", null);
    }

    @Test(expectedExceptions = ApiUsageException.class)
    public void test_null_user_ext() throws Exception {
        new Login(null, "", null, null);
    }

    @Test(expectedExceptions = ApiUsageException.class)
    public void test_null_password_ext() throws Exception {
        new Login("", null, null, null);
    }

    @Test
    public void test_asProperties() throws Exception {
        Login l = new Login("a", "b");
        Properties p = l.asProperties();
        Assert.assertNotNull(p.getProperty(Login.OMERO_USER));
        Assert.assertNotNull(p.getProperty(Login.OMERO_PASS));
        Assert.assertNull(p.getProperty(Login.OMERO_GROUP));
        Assert.assertNull(p.getProperty(Login.OMERO_EVENT));

        Assert.assertEquals(p.getProperty(Login.OMERO_USER), "a");
        Assert.assertEquals(p.getProperty(Login.OMERO_PASS), "b");
    }

    @Test
    public void test_asProperties_extNulls() throws Exception {
        Login l = new Login("a", "b", null, null);
        Properties p = l.asProperties();
        Assert.assertNotNull(p.getProperty(Login.OMERO_USER));
        Assert.assertNotNull(p.getProperty(Login.OMERO_PASS));
        Assert.assertNull(p.getProperty(Login.OMERO_GROUP));
        Assert.assertNull(p.getProperty(Login.OMERO_EVENT));

        Assert.assertEquals(p.getProperty(Login.OMERO_USER), "a");
        Assert.assertEquals(p.getProperty(Login.OMERO_PASS), "b");
    }

    @Test
    public void test_asProperties_ext() throws Exception {
        Login l = new Login("a", "b", "c", "d");
        Properties p = l.asProperties();
        Assert.assertNotNull(p.getProperty(Login.OMERO_USER));
        Assert.assertNotNull(p.getProperty(Login.OMERO_PASS));
        Assert.assertNotNull(p.getProperty(Login.OMERO_GROUP));
        Assert.assertNotNull(p.getProperty(Login.OMERO_EVENT));

        Assert.assertEquals(p.getProperty(Login.OMERO_USER), "a");
        Assert.assertEquals(p.getProperty(Login.OMERO_PASS), "b");
        Assert.assertEquals(p.getProperty(Login.OMERO_GROUP), "c");
        Assert.assertEquals(p.getProperty(Login.OMERO_EVENT), "d");
    }

    @Test
    public void test_getters() throws Exception {
        Login l = new Login("a", "b");

        Assert.assertNotNull(l.getName());
        Assert.assertEquals(l.getName(), "a");

        Assert.assertNotNull(l.getPassword());
        Assert.assertEquals(l.getPassword(), "b");

        Assert.assertNull(l.getGroup());
        Assert.assertNull(l.getEvent());

    }

    @Test
    public void test_getters_extNulls() throws Exception {
        Login l = new Login("a", "b", null, null);

        Assert.assertNotNull(l.getName());
        Assert.assertEquals(l.getName(), "a");

        Assert.assertNotNull(l.getPassword());
        Assert.assertEquals(l.getPassword(), "b");

        Assert.assertNull(l.getGroup());
        Assert.assertNull(l.getEvent());
    }

    @Test
    public void test_getters_ext() throws Exception {
        Login l = new Login("a", "b", "c", "d");

        Assert.assertNotNull(l.getName());
        Assert.assertEquals(l.getName(), "a");

        Assert.assertNotNull(l.getPassword());
        Assert.assertEquals(l.getPassword(), "b");

        Assert.assertNotNull(l.getGroup());
        Assert.assertEquals(l.getGroup(), "c");

        Assert.assertNotNull(l.getEvent());
        Assert.assertEquals(l.getEvent(), "d");

    }

}
