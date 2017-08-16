package com.shtrih.jpos.fiscalprinter;

public interface PrinterHeader {

	void initDevice() throws Exception;

	int getNumHeaderLines() throws Exception;

	int getNumTrailerLines() throws Exception;

	void setNumHeaderLines(int numHeaderLines) throws Exception;

	void setNumTrailerLines(int numHeaderLines) throws Exception;

	void setHeaderLine(int number, String text, boolean doubleWidth)
			throws Exception;

	void setTrailerLine(int number, String text, boolean doubleWidth)
			throws Exception;

	HeaderLine getHeaderLine(int number) throws Exception;

	HeaderLine getTrailerLine(int number) throws Exception;

	void beginDocument(String additionalHeader, String additionalTrailer)
			throws Exception;

	void endDocument(String additionalHeader, String additionalTrailer)
			throws Exception;

}
