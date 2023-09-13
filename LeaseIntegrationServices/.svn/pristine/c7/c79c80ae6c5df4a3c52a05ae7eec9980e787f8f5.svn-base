/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.webservices;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.xdo.XDOException;
import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;

/**
 *
 * @author DineshkumarP
 */
public class RTFReportProcess {
 

public static byte[] rtfReport(String xmlData, String filePath) {
        
        
        InputStream fiS = null;
        ByteArrayInputStream xslInStream = null;
        ByteArrayInputStream dataStream = null;
        ByteArrayOutputStream pdfOutStream = null;

        byte[] dataBytes ="No Data found".getBytes(); 
//                Byte.valueOf("No Data found");

        byte outFileTypeByte = 0;
        try {
            fiS = new FileInputStream(new File(filePath));
            outFileTypeByte = FOProcessor.FORMAT_XLSX;
//                 outFileTypeByte = FOProcessor.FORMAT_PDF;
            RTFProcessor rtfP = new RTFProcessor(fiS); 
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfP.setOutput(xslOutStream);
            rtfP.process();
            xslInStream = new ByteArrayInputStream(xslOutStream.toByteArray());

            FOProcessor processor = new FOProcessor();
            processor.setConfig("/u01/data/font/xdo.cfg");
            dataStream = new ByteArrayInputStream(xmlData.getBytes());

            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);

            processor.setOutputFormat(outFileTypeByte);
            processor.generate();
            dataBytes = pdfOutStream.toByteArray();
            
        } catch (XDOException | FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("ex==>"+ex);
        }
        return dataBytes;
    }
 
        
//        String formatDate(String p_date)  throws ParseException{
//            SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
//            java.util.Date date = parser.parse(p_date); 
//            SimpleDateFormat pkgFormatter = new SimpleDateFormat("dd-MMM-yyyy");
//            String dateFormat = pkgFormatter.format(date); 
//        return dateFormat;
//    }    

        
}
