/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DineshkumarP
 */
public class BaseClass {
    
        public static String getSysdate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }
    //TO mail details
    public static final String OA_TO_ADDRESS = DbPackageCall.getAddressFromLookup("OA_INVOICE_TO");
    public static final String OA_CC_ADDRESS = DbPackageCall.getAddressFromLookup("OA_INVOICE_CC");
    public static final String OC_TO_ADDRESS = DbPackageCall.getAddressFromLookup("OC_INVOICE_TO");
    public static final String OC_CC_ADDRESS = DbPackageCall.getAddressFromLookup("OC_INVOICE_CC");
    public static final String LEASE_TO_ADDRESS = DbPackageCall.getAddressFromLookup("LEASE_INVOICE_TO");
    public static final String LEASE_CC_ADDRESS = DbPackageCall.getAddressFromLookup("LEASE_INVOICE_CC");
        
    //From mail details 
    public static final String FromMailId ="prismalerts@omniyat.com"; 
    public static final String password ="Or@cl3alert"; 
    public static final String hostName ="smtp.office365.com";  
    
    public static final String LEASE_AUTO_INVOICE_SUB ="Tenant - Auto Invoice Integration"; 
    public static final String OA_AUTO_INVOICE_SUB ="Owner Asscocation - Auto Invoice Integration"; 
    public static final String OC_AUTO_INVOICE_SUB ="Other Charge - Auto Invoice Integration";
    
    public static final String ICS_BASE64 = DbPackageCall.getLookupByTypeAndValue("ICS_CREDENTIAL","ICS_AUTH");
    public static final String SUPPLIER_URL = DbPackageCall.getLookupByTypeAndValue("ICS_CREDENTIAL","SUPPLIER_URL");
    
    public static String getErrorMailSubject(String tab) {
        
        if("XXPL_BOOKING_MILESTONES".equals(tab)){
            return "Lease - Integration Error Report";
        }
        if("XXPL_OA_CONTRACT_HDR".equals(tab)){
            return "AP Owner Invoice - Integration Error Report";
        }
        if("XXPL_OWNER_INVOICE".equals(tab)){
            return "Owner Invoice - Integration Error Report";
        }
        if("XXPL_OTHER_CHARGE_HDR".equals(tab)){
            return "Other Charge - Integration Error Report";
        }
        
        return "Integration Error Report";
    }
    
}