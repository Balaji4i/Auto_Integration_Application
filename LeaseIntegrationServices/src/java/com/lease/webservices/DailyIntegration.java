/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lease.webservices;

import com.Config.BaseClass;
import com.Config.DbPackageCall;
import java.text.ParseException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author DineshkumarP
 */


@Path("/autointegration")
public class DailyIntegration {

DbPackageCall dbPackageCall = new DbPackageCall();
    

@Path("/LeaseInvoice")
@GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
 public Response dailyLeaseInvoice(
                        @QueryParam(value = "P_TDATE")      String P_TDATE
        )  throws ParseException{
        
       String message=WebservicesProcess.LeaseInvoice(P_TDATE);
       return Response.ok().entity(message).build();  
        
    };
 
    @Path("/OAInvoice")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response dailyOAInvoice(
                        @QueryParam(value = "P_TDATE")      String P_TDATE
        )  throws ParseException{
        
       String message=WebservicesProcess.oAInvoice(P_TDATE);
       return Response.ok().entity(message).build();  
        
    };
 
    @Path("/OCInvoice")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response dailyOCInvoice(
                        @QueryParam(value = "P_TDATE")      String P_TDATE
        )  throws ParseException{
        
       String message=WebservicesProcess.otherChargeInvoice(P_TDATE);
       return Response.ok().entity(message).build();  
        
    }; 

 
@Path("/LeaseError")
@GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
 public Response IntegrationLeaseError(
            @QueryParam(value = "P_TABLE") String P_TABLE)  throws ParseException{
        
       String message=WebservicesProcess.IntegrationErrorReport(P_TABLE);
       return Response.ok().entity(message).build();  
        
    };
 
 
@Path("/LeaseErrorstatus")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response errorStatus(
            @QueryParam(value = "P_TABLE") String P_TABLE)  throws ParseException{
        
        String fileName = BaseClass.getSysdate()+"-Integration Error Report.xlsx";
        String P_File_Type = "xlsx";
        String xmlData =DbPackageCall.integrationErrorStatus(P_TABLE);
        String filePath = "/u01/data/reports/lease/ErrorStatus.rtf";
        Response.ResponseBuilder builder = Response.ok(RTFReportProcess.rtfReport(xmlData, filePath));
        builder.header("Content-Disposition", "attachment; filename=" + fileName);
        return builder.build();
    }
 
 
 
    
}
