/*
 * JposDeviceStatistics.java
 *
 * Created on April 6 2008, 15:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.shtrih.jpos;

/**
 *
 * @author V.Kravtsov
 */

import jpos.JposException;
import jpos.JposStatisticsConst;

public interface JposStatistics extends JposStatisticsConst {
    void reset(String statisticsBuffer) throws JposException;

    void update(String statisticsBuffer) throws JposException;

    void retrieve(String[] statisticsBuffer) throws JposException;
}
