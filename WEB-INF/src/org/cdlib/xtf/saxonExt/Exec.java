package org.cdlib.xtf.saxonExt;


/*
 * Copyright (c) 2004, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the University of California nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * Acknowledgements:
 *
 * A significant amount of new and/or modified code in this module
 * was made possible by a grant from the Andrew W. Mellon Foundation,
 * as part of the Melvyl Recommender Project.
 */
import org.cdlib.xtf.saxonExt.exec.ArgElement;
import org.cdlib.xtf.saxonExt.exec.InputElement;
import org.cdlib.xtf.saxonExt.exec.PipeImageElement;
import org.cdlib.xtf.saxonExt.exec.RunElement;

import net.sf.saxon.style.ExtensionElementFactory;

/**
 * Front-end to the "Exec" Saxon extension, which allows stylesheets to call
 * command-line programs, with proper error handling, timeouts, and format
 * conversion.
 *
 * @author Martin Haye
 */
public class Exec implements ExtensionElementFactory 
{
  /**
  * Identify the class to be used for stylesheet elements with a given local name.
  * The returned class must extend net.sf.saxon.style.StyleElement
  * @return null if the local name is not a recognised element type in this
  * namespace.
  */
  public Class getExtensionClass(String localname) 
  {
    if (localname.equals("run"))
      return RunElement.class;
    
    if (localname.equals("pipeImage"))
      return PipeImageElement.class;

    if (localname.equals("arg") || localname.equals("argument"))
      return ArgElement.class;

    if (localname.equals("input"))
      return InputElement.class;

    return null;
  }
}
