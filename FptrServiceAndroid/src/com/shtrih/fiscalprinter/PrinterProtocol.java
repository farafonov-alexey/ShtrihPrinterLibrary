/*
 * SmPrinterDeviceInterface.java
 *
 * Created on 14 October 2010 пїЅ., 19:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.shtrih.fiscalprinter;

/**
 *
 * @author V.Kravtsov
 */

import com.shtrih.fiscalprinter.command.PrinterCommand;

public interface PrinterProtocol {
	void connect() throws Exception;
	void send(PrinterCommand command) throws Exception;
}
