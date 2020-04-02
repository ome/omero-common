/*
 *   $Id$
 *
 *   Copyright 2006 University of Dundee. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */
package ome.system.utests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ome.model.meta.Experimenter;
import ome.model.meta.ExperimenterGroup;
import ome.system.Roles;


public class RolesTest {
    Roles r = new Roles();

    @Test
    public void testRoot() throws Exception {
        Assert.assertTrue(r.isRootUser(new Experimenter(0L, false)));
    }

    @Test
    public void testSystem() throws Exception {
        Assert.assertTrue(r.isSystemGroup(new ExperimenterGroup(0L, false)));
    }

    @Test
    public void testUser() throws Exception {
        Assert.assertTrue(r.isUserGroup(new ExperimenterGroup(1L, false)));
    }

}
