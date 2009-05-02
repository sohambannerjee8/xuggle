/*
 * Copyright (c) 2008-2009 by Xuggle Inc. All rights reserved.
 *
 * It is REQUESTED BUT NOT REQUIRED if you use this library, that you let 
 * us know by sending e-mail to info@xuggle.com telling us briefly how you're
 * using the library and what you like or don't like about it.
 *
 * This library is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation; either version 2.1 of the License, or (at your option) any later
 * version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package com.xuggle.xuggler;

import org.junit.*;

import com.xuggle.xuggler.IContainerFormat;

import junit.framework.TestCase;

public class ContainerFormatTest extends TestCase
{
  private final String sampleFile = "fixtures/testfile.flv";

  @Test
  public void testSetOutputFmt()
  {
    IContainerFormat fmt = IContainerFormat.make();
    
    fmt.setOutputFormat("flv", null, null);
    fmt.setOutputFormat("flv", sampleFile, null);
    fmt.setOutputFormat("flv", "file:"+sampleFile, null);

    
    fmt.setOutputFormat("NotAShortName", null, null);
    fmt.setOutputFormat("NotAShortName", "NotAURL", null);
    fmt.setOutputFormat("NotAShortName", "file:"+"NotAURL", null);
    fmt.setOutputFormat("NotAShortName", "NotAProtocol:"+"NotAURL", null);

    
    assertTrue("got to end of test without coredump.  woo hoo", true);
  }
  
  @Test
  public void testSetInputFmt()
  {
    IContainerFormat fmt = IContainerFormat.make();
    
    fmt.setInputFormat("flv");
    fmt.setInputFormat("mov");
    fmt.setInputFormat("NotAShortName");
    assertTrue("got to end of test without coredump.  woo hoo", true);
  }
}