/*
 * Copyright (C) 2013 University of Dundee & Open Microscopy Environment.
 * All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package ome.util.checksum;

import java.util.EnumMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class SHA1ChecksumProviderImplTest
    extends AbstractChecksumProviderAlgorithmTest {

    private static EnumMap<ChecksumTestVector, String> map =
            new EnumMap<ChecksumTestVector, String>(ChecksumTestVector.class);

    @BeforeClass
    public void setUp() {
        map.put(ChecksumTestVector.ABC, "a9993e364706816aba3e25717850c26c9cd0d89d");
        map.put(ChecksumTestVector.EMPTYARRAY, "da39a3ee5e6b4b0d3255bfef95601890afd80709");
        map.put(ChecksumTestVector.SMALLFILE, "af35647108cada855e1ca08472c2a831cce91a29");
        map.put(ChecksumTestVector.MEDIUMFILE, "a61d742dba0a4cd423de603e6c3890e0f856bb9c");
        map.put(ChecksumTestVector.BIGFILE, "b3987d3ffac6ad41fee258e8cc99fc89e29ae98f");
    }

    public SHA1ChecksumProviderImplTest() {
        super(new SHA1ChecksumProviderImpl(), map);
    }

    @AfterMethod
    public void resetChecksum() {
        super.checksumProvider = new SHA1ChecksumProviderImpl();
    }

}
