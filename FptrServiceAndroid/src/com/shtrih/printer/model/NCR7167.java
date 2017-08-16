/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shtrih.printer.model;

/**
 * @author V.Kravtsov
 */
public interface NCR7167 {
    // ///////////////////////////////////////////////////////////////////
    // Barcode types
    // ///////////////////////////////////////////////////////////////////

    int NCR7167_BARCODE_UPCA = 0;
    int NCR7167_BARCODE_UPCE = 1;
    int NCR7167_BARCODE_EAN13 = 2;
    int NCR7167_BARCODE_EAN8 = 3;
    int NCR7167_BARCODE_CODE39 = 4;
    int NCR7167_BARCODE_ITF = 5;
    int NCR7167_BARCODE_CODABAR = 6;
    int NCR7167_BARCODE_CODE93 = 7;
    int NCR7167_BARCODE_CODE128 = 8;
    int NCR7167_BARCODE_PDF417 = 10;
    int NCR7167_BARCODE_GS1_OMNI = 11;
    int NCR7167_BARCODE_GS1_TRUNC = 12;
    int NCR7167_BARCODE_GS1_LIMIT = 13;
    int NCR7167_BARCODE_GS1_EXP = 14;
    int NCR7167_BARCODE_GS1_STK = 15;
    int NCR7167_BARCODE_GS1_STK_OMNI = 16;
    int NCR7167_BARCODE_GS1_EXP_STK = 17;

    // ///////////////////////////////////////////////////////////////////
    // HRI position constants
    // ///////////////////////////////////////////////////////////////////

    int NCR7167_HRI_NOTPRINTED = 0;
    int NCR7167_HRI_ABOVE = 1;
    int NCR7167_HRI_BELOW = 2;
    int NCR7167_HRI_ABOVE_BELOW = 3;

    // ///////////////////////////////////////////////////////////////////
    // HRI pitch constants
    // ///////////////////////////////////////////////////////////////////

    int NCR7167_HRI_PITCH_STANDARD = 0;
    int NCR7167_HRI_PITCH_COMPRESSED = 1;

}
