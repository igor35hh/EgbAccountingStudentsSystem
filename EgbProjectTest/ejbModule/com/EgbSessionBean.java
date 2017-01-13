package com;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Session Bean implementation class EgbSessionBean
 */
@Stateless
@LocalBean
public class EgbSessionBean {

    public String ejbSessionBeanMethod() {
		return "ejbSessionBeanMethod executed...";
    	
    }
    

}
