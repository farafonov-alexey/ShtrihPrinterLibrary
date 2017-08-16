/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shtrih.jpos.cashdrawer;

/**
 * @author V.Kravtsov
 */
public interface ShtrihCashDrawerConst {

    /** Get driver parameter **/
    int SMCASH_DIO_GET_DRIVER_PARAMETER = 0x01;

    /** Set driver parameter **/
    int SMCASH_DIO_SET_DRIVER_PARAMETER = 0x02;

    /** Open cash drawer **/
    int SMCASH_DIO_OPEN_DRAWER = 0x03;

    /** Read cash drawer state **/
    int SMCASH_DIO_READ_DRAWER_STATE = 0x04;

    // ///////////////////////////////////////////////////////////////////
    // Parameter constants for directIO commands:
    // SMCASH_DIO_GET_DRIVER_PARAMETER,
    // SMCASH_DIO_SET_DRIVER_PARAMETER
    // ///////////////////////////////////////////////////////////////////

    /** Drawer number **/
    int SMCASH_PARAM_DRAWER_NUMBER = 0;
}
