/*
 *   $Id$
 *
 *   Copyright 2006 University of Dundee. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */
package ome.system.utests;

import org.testng.annotations.*;
import java.util.Properties;
import ome.conditions.ApiUsageException;
import ome.system.Server;

import junit.framework.TestCase;

public class ServerTest extends TestCase {

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
        assertNotNull(p.getProperty(Server.OMERO_HOST));
        assertNotNull(p.getProperty(Server.OMERO_PORT));
        assertEquals(p.getProperty(Server.OMERO_HOST), "a");
        assertEquals(p.getProperty(Server.OMERO_PORT), "1099");
    }

    @Test
    public void test_asProperties_ext() {
        Server l = new Server("a", 999);
        Properties p = l.asProperties();
        assertNotNull(p.getProperty(Server.OMERO_HOST));
        assertNotNull(p.getProperty(Server.OMERO_PORT));

        assertEquals(p.getProperty(Server.OMERO_HOST), "a");
        assertEquals(p.getProperty(Server.OMERO_PORT), "999");
    }

    @Test
    public void test_getters() {
        Server s = new Server("a");

        assertNotNull(s.getHost());
        assertEquals(s.getHost(), "a");
        assertEquals(s.getPort(), 1099);

    }

    @Test
    public void test_getters_ext() {
        Server s = new Server("a", 999);

        assertNotNull(s.getHost());
        assertEquals(s.getHost(), "a");
        assertEquals(s.getPort(), 999);

    }

}
