/*
 *
 * Copyright (c) 2004, 2005, 2006, 2007 void.fm
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name void.fm nor the names of its contributors may be
 * used to endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package test.etm.contrib.rrd.rrd4j;

import etm.contrib.rrd.rrd4j.Rrd4jUtil;
import junit.framework.TestCase;
import org.rrd4j.core.RrdDb;

import java.io.File;
import java.net.URL;

/**
 * Tests the rrd4j util methods.
 *
 * @author void.fm
 * @version $Revision$
 */
public class Rrd4jUtilTest extends TestCase {


  public void testCreate() throws Exception {
    URL resource = Thread.currentThread().getContextClassLoader().getResource("test/etm/contrib/rrd/rrd4j/resources/basic_db_template.xml");

    Rrd4jUtil util = new Rrd4jUtil();
    File path = File.createTempFile("test", ".rrd");

    try {
      util.createDb(path, resource);
      assertTrue(path.exists());


      RrdDb db = new RrdDb(path.getAbsolutePath(), true);
      assertEquals(4, db.getDsCount());
      db.close();

    } finally {
      if (path.exists()) {
        path.delete();
      }
    }

  }
}
