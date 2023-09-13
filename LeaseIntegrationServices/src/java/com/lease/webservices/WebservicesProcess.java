/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.webservices;

import com.Config.BaseClass;
import com.Config.DbPackageCall;
import htmlBodyContent.LeaseInvoiceHTML;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author DineshkumarP
 */
public class WebservicesProcess {
 
    
    public static String LeaseInvoice (String p_date){
        String returnval=null;
        ArrayList <String> list = new ArrayList<String>();
        String fileName = p_date+"-Daily Invoice Integration.xlsx";
        String fileType = "xlsx";
        // Data base
        list =DbPackageCall.IntegrationDailyLeaseInvoice(p_date);
        String Count=list.get(0).toString();
        String msgCode=list.get(1).toString();
        String msg=list.get(2).toString();
        // RTF File
        String xmlData =DbPackageCall.IntegrationDailyLeaseInvoiceReport(p_date);
        String filePath = "/u01/data/reports/lease/Daily_Invoice.rtf";
        //Mail Attachment    
        byte[] bytes =RTFReportProcess.rtfReport(xmlData, filePath);
        System.out.println("bytes==>"+bytes);
        
        String bodyMsg=LeaseInvoiceHTML.LeaseInvoiceHtmlMsgbody(p_date, Count,msg);
        //send mail
        returnval=MailServices.mailNotificationWithAttachment(
                BaseClass.FromMailId, 
                BaseClass.password, 
                bytes, 
                BaseClass.LEASE_TO_ADDRESS,
                BaseClass.LEASE_CC_ADDRESS,
                BaseClass.LEASE_AUTO_INVOICE_SUB, 
                bodyMsg, 
                fileName);
                
       return returnval; 
    }
    
    public static String otherChargeInvoice (String p_date){
        String returnval=null;
        ArrayList <String> list = new ArrayList<String>();
        String fileName = p_date+"-Daily Invoice Integration.xlsx";
        String fileType = "xlsx";
        // Data base
        list =DbPackageCall.IntegrationDailyOtherChargeInvoice(p_date);
        String Count=list.get(0).toString();
        String msgCode=list.get(1).toString();
        String msg=list.get(2).toString();
        // RTF File
        String xmlData =DbPackageCall.IntegrationDailyOtherChargeInvoiceReport(p_date);
        String filePath = "/u01/data/reports/lease/OC_Daily_Inv.rtf";
        //Mail Attachment    
        byte[] bytes =RTFReportProcess.rtfReport(xmlData, filePath);
        System.out.println("bytes==>"+bytes);
        
        String bodyMsg=LeaseInvoiceHTML.otherChargeInvoiceHtmlMsgbody(p_date, Count,msg);
        //send mail
        returnval=MailServices.mailNotificationWithAttachment(
                BaseClass.FromMailId, 
                BaseClass.password, 
                bytes, 
                BaseClass.OC_TO_ADDRESS, 
                BaseClass.OC_CC_ADDRESS,
                BaseClass.OC_AUTO_INVOICE_SUB, 
                bodyMsg, 
                fileName);
                
       return returnval; 
    }
    
    public static String oAInvoice (String p_date){
        String returnval=null;
        ArrayList <String> list = new ArrayList<String>();
        String fileName = p_date+"-Daily Invoice Integration.xlsx";
        String fileType = "xlsx";
        // Data base
        list =DbPackageCall.IntegrationDailyOAInvoice(p_date);
        String Count=list.get(0).toString();
        String msgCode=list.get(1).toString();
        String msg=list.get(2).toString();
        // RTF File
        String xmlData =DbPackageCall.IntegrationDailyOAInvoiceReport(p_date);
        String filePath = "/u01/data/reports/lease/OA_Daily_Inv.rtf";
        //Mail Attachment    
        byte[] bytes =RTFReportProcess.rtfReport(xmlData, filePath);
        System.out.println("bytes==>"+bytes);
        
        String bodyMsg=LeaseInvoiceHTML.oAInvoiceHtmlMsgbody(p_date, Count,msg);
        //send mail
        returnval=MailServices.mailNotificationWithAttachment(
                BaseClass.FromMailId, 
                BaseClass.password, 
                bytes, 
                BaseClass.OA_TO_ADDRESS, 
                BaseClass.OA_CC_ADDRESS, 
                BaseClass.OA_AUTO_INVOICE_SUB, 
                bodyMsg, 
                fileName);
                
       return returnval; 
    }

   public static String IntegrationErrorReport(String P_TABLE){
      String returnval=null;
      String fileName = BaseClass.getSysdate()+"-Integration Error Report.xlsx";
      String fileType = "xlsx";      
      // RTF File
      String xmlData =DbPackageCall.integrationErrorStatus(P_TABLE);
      String filePath = "/u01/data/reports/lease/ErrorStatus.rtf";
      //Mail Attachment    
      byte[] bytes =RTFReportProcess.rtfReport(xmlData, filePath);  
      System.out.println("bytes==>"+bytes);
      // body
      String bodyMsg=LeaseInvoiceHTML.IntegrationErrorReport();
      
     //send mail
        returnval=MailServices.mailNotificationWithAttachment(
                BaseClass.FromMailId, 
                BaseClass.password, 
                bytes, 
                BaseClass.LEASE_TO_ADDRESS, 
                BaseClass.LEASE_CC_ADDRESS, 
                BaseClass.getErrorMailSubject(P_TABLE),
                bodyMsg, 
                fileName); 
      
      return returnval;
   }
    
    
    
}
