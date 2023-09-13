/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlBodyContent;

/**
 *
 * @author DineshkumarP
 */
public class LeaseInvoiceHTML {
 
    public static String LeaseInvoiceHtmlMsgbody(String p_Date, String invoiceCount, String msg){
        String html=
            "<p>Dear Team,</p>\n" +
            "<p>Good Day..!</p>\n" +
            "<p>Please find the attachment of the Daily Lease Invoice Report.&nbsp;</p>\n" +
            "<p>Daily Invoice Details&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<table style=\"height: 84px; width: 396.414px; border-color: blue; float: left;\" border=\"1\">\n" +
            "<tbody>\n" +
            "<tr style=\"height: 34.6016px;\">\n" +
            "<td style=\"width: 139px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Date</strong></span></td>\n" +
            "<td style=\"width: 83.4141px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Total No of Invoice Count</strong></span></td>\n" +
            "<td style=\"width: 83.4141px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Status</strong></span></td>\n" +
            "</tr>\n" +
            "<tr style=\"height: 25px;\">\n" +
            "<td style=\"width: 139px; height: 25px;\"><strong>"+p_Date+"</strong></td>\n" +
            "<td style=\"width: 83.4141px; height: 25px;\"><strong>"+invoiceCount+"</strong></td>\n" +
            "<td style=\"width: 83.4141px; height: 25px;\"><strong>"+msg+"</strong></td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>Regards</p>\n" +
            "<p>Lease Alert Message</p>\n" +
            "<p><span style=\"color: #ff0000;\">Note: This is a system generated mail so please do not reply to this mail</span></p>";

    return html;
    }
    
     public static String oAInvoiceHtmlMsgbody(String p_Date, String invoiceCount, String msg){
        String html=
            "<p>Dear Team,</p>\n" +
            "<p>Good Day..!</p>\n" +
            "<p>Please find the attachment of the Daily Owner Invoice Report.&nbsp;</p>\n" +
            "<p>Daily Invoice Details&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<table style=\"height: 84px; width: 396.414px; border-color: blue; float: left;\" border=\"1\">\n" +
            "<tbody>\n" +
            "<tr style=\"height: 34.6016px;\">\n" +
            "<td style=\"width: 139px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Date</strong></span></td>\n" +
            "<td style=\"width: 83.4141px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Total No of Invoice Count</strong></span></td>\n" +
            "<td style=\"width: 83.4141px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Status</strong></span></td>\n" +
            "</tr>\n" +
            "<tr style=\"height: 25px;\">\n" +
            "<td style=\"width: 139px; height: 25px;\"><strong>"+p_Date+"</strong></td>\n" +
            "<td style=\"width: 83.4141px; height: 25px;\"><strong>"+invoiceCount+"</strong></td>\n" +
            "<td style=\"width: 83.4141px; height: 25px;\"><strong>"+msg+"</strong></td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>Regards</p>\n" +
            "<p>Lease Alert Message</p>\n" +
            "<p><span style=\"color: #ff0000;\">Note: This is a system generated mail so please do not reply to this mail</span></p>";

    return html;
    }
     
      public static String otherChargeInvoiceHtmlMsgbody(String p_Date, String invoiceCount, String msg){
        String html=
            "<p>Dear Team,</p>\n" +
            "<p>Good Day..!</p>\n" +
            "<p>Please find the attachment of the Daily Other Charge Invoice Report.&nbsp;</p>\n" +
            "<p>Daily Invoice Details&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<table style=\"height: 84px; width: 396.414px; border-color: blue; float: left;\" border=\"1\">\n" +
            "<tbody>\n" +
            "<tr style=\"height: 34.6016px;\">\n" +
            "<td style=\"width: 139px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Date</strong></span></td>\n" +
            "<td style=\"width: 83.4141px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Total No of Invoice Count</strong></span></td>\n" +
            "<td style=\"width: 83.4141px; text-align: center; height: 34.6016px;\"><span style=\"color: #0000ff;\"><strong>Status</strong></span></td>\n" +
            "</tr>\n" +
            "<tr style=\"height: 25px;\">\n" +
            "<td style=\"width: 139px; height: 25px;\"><strong>"+p_Date+"</strong></td>\n" +
            "<td style=\"width: 83.4141px; height: 25px;\"><strong>"+invoiceCount+"</strong></td>\n" +
            "<td style=\"width: 83.4141px; height: 25px;\"><strong>"+msg+"</strong></td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>&nbsp;</p>\n" +
            "<p>Regards</p>\n" +
            "<p>Lease Alert Message</p>\n" +
            "<p><span style=\"color: #ff0000;\">Note: This is a system generated mail so please do not reply to this mail</span></p>";

    return html;
    }
    
    
    
        public static String IntegrationErrorReport(){
        String html="<h4>Dear All,</h4>\n" +
                    "<p>Please find the attachment of PaaS to SaaS Interface Error Report.</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>&nbsp;Regards,</p>\n" +
                    "<p>Lease Administrator Team.</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>Note: This is a system generated mail so please do not reply to this mail</p>";

        return html;
        }
    
   
        
        
}


//<h4>Dear All,</h4>
//<p>Please find the attachment of PaaS to SaaS Interface Error Report.</p>
//<h2>&nbsp;</h2>
//<p>&nbsp;Regards,</p>
//<p>Lease Administrator Team.</p>
//<p><span style="color: #ff0000;">&nbsp;Note: This is a system generated mail so please do not reply to this mail</span></p>

