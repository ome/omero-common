/*
 *   Copyright 2007 Glencoe Software, Inc. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */
package ome.system.utests;

import ome.system.UpgradeCheck;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Josh Moore, josh at glencoesoftware.com
 * @since 3.0-Beta2.3
 */
public class UpgradeCheckTest {

    String version =  "1.2.3";
    ome.system.UpgradeCheck check;

    @Test
    public void testNoActionOnNull() {
        check = new UpgradeCheck(null, version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertFalse(check.isExceptionThrown());
    }

    @Test
    public void testNoActionOnEmpty() {
        check = new UpgradeCheck("", version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertFalse(check.isExceptionThrown());

    }

    @Test
    public void testSlowResponse() {
        check = new UpgradeCheck("http://127.0.0.1:8000", version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertTrue(check.isExceptionThrown());

    }

    @Test
    public void testSlowResponse2() {
        check = new UpgradeCheck("http://127.0.0.1:9998", version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertTrue(check.isExceptionThrown());
    }

    @Test
    public void testBadIp() {
        check = new UpgradeCheck("200.200.200.200", version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertTrue(check.isExceptionThrown());

    }

    @Test
    public void testWrongVersion() {
        check = new UpgradeCheck("200.200.200.200", "XYZ" + version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertTrue(check.isExceptionThrown());

    }

    @Test(enabled = false)
    public void testBadUrl1() {
        check = new UpgradeCheck("http://foo", "XYZ" + version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertTrue(check.isExceptionThrown());

    }

    @Test
    public void testBadUrl2() {
        check = new UpgradeCheck("file://dev/null", "XYZ" + version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertTrue(check.isExceptionThrown());

    }

    @Test
    public void testBadUrl3() {
        check = new UpgradeCheck("abcp", "XYZ" + version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertTrue(check.isExceptionThrown());

    }

    @Test
    public void testBadUrl4() {
        check = new UpgradeCheck("abc://bar", "XYZ" + version, "test");
        check.run();
        Assert.assertFalse(check.isUpgradeNeeded());
        Assert.assertTrue(check.isExceptionThrown());

    }

}
