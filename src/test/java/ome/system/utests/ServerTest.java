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
import ome.system.Server;

public class ServerTest {

    @Test(expectedExceptions = ApiUsageException.class)
    public void test_null_host()  {
        new Server(null);
    }

    @Test(expectedExceptions = ApiUsageException.class)
    public void test_bad_port() {
        new Server("", -100);
    }

    @Test
    public void test_asProperties() {
        Server s = new Server("a");
        Properties p = s.asProperties();
        Assert.assertNotNull(p.getProperty(Server.OMERO_HOST));
        Assert.assertNotNull(p.getProperty(Server.OMERO_PORT));
        Assert.assertEquals(p.getProperty(Server.OMERO_HOST), "a");
        Assert.assertEquals(p.getProperty(Server.OMERO_PORT), "1099");
    }

    @Test
    public void test_asProperties_ext() {
        Server l = new Server("a", 999);
        Properties p = l.asProperties();
        Assert.assertNotNull(p.getProperty(Server.OMERO_HOST));
        Assert.assertNotNull(p.getProperty(Server.OMERO_PORT));

        Assert.assertEquals(p.getProperty(Server.OMERO_HOST), "a");
        Assert.assertEquals(p.getProperty(Server.OMERO_PORT), "999");
    }

    @Test
    public void test_getters() {
        Server s = new Server("a");

        Assert.assertNotNull(s.getHost());
        Assert.assertEquals(s.getHost(), "a");
        Assert.assertEquals(s.getPort(), 1099);

    }

    @Test
    public void test_getters_ext() {
        Server s = new Server("a", 999);

        Assert.assertNotNull(s.getHost());
        Assert.assertEquals(s.getHost(), "a");
        Assert.assertEquals(s.getPort(), 999);

    }

}
