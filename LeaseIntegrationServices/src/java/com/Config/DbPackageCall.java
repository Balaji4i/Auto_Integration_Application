/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author DineshkumarP
 */
public class DbPackageCall {

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static PreparedStatement ps;

        public static Connection getConnectionDS(String datasource) throws SQLException,
            NamingException {
        Connection con = null;
        DataSource data = null;
        Context initialContext = new InitialContext();
        if (initialContext == null) {

        }
        data = (DataSource) initialContext.lookup(datasource);
        if (data != null) {
            con = data.getConnection();
        } else {
            System.out.println("Failed to Find JDBC DataSource.");
        }
        return con;
    }
    
    public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.21.67.79:1533/omnipdb1.606532292.oraclecloud.internal", "xxpl_march", "Xxpl_Mar_30");
         } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return con;
    }
    
    /*
    * DB Initializer
    */
    
    public static void dbInitialization() throws SQLException, NamingException, ClassNotFoundException {
        connection = getConnectionDS("PRISM_PL");
//        connection=getDBConnection();     
    }

    
    
       public static void dbDestroy() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
 
       
    public static ArrayList IntegrationDailyLeaseInvoice(String p_date) {
        ArrayList <String> returnList = new ArrayList<String>();
        try {
            dbInitialization();
            System.err.println("P_DATE==>"+p_date);
            String pkgName="XXPL_DAILY_INVOICE_PKG.XXPL_DAILY_LEASE_INVOICE";
            CallableStatement cst= connection.prepareCall("{call "+pkgName+"(?,?,?,?)}");    
            cst.setString(1, p_date);
            cst.registerOutParameter(2, Types.NUMERIC);
            cst.registerOutParameter(3, Types.VARCHAR);
            cst.registerOutParameter(4, Types.VARCHAR);
            cst.execute();
            returnList.add(cst.getString(2));
            returnList.add(cst.getString(3));
            returnList.add(cst.getString(4));
            System.out.println("COUNT==>"+cst.getString(2));
            System.out.println("CODE==>"+cst.getString(3));
            System.out.println("MESSAGE==>"+cst.getString(4));
            dbDestroy();

        } catch (SQLException ex) {
            returnList.add("0");
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return returnList;
        }
    }
     public static ArrayList IntegrationDailyOAInvoice(String p_date) {
        ArrayList <String> returnList = new ArrayList<String>();
        try {
            dbInitialization();
            System.err.println("P_DATE==>"+p_date);
            String pkgName="XXPL_DAILY_INVOICE_PKG.XXPL_DAILY_OA_INVOICE";
            CallableStatement cst= connection.prepareCall("{call "+pkgName+"(?,?,?,?)}");    
            cst.setString(1, p_date);
            cst.registerOutParameter(2, Types.NUMERIC);
            cst.registerOutParameter(3, Types.VARCHAR);
            cst.registerOutParameter(4, Types.VARCHAR);
            cst.execute();
            returnList.add(cst.getString(2));
            returnList.add(cst.getString(3));
            returnList.add(cst.getString(4));
            System.out.println("COUNT==>"+cst.getString(2));
            System.out.println("CODE==>"+cst.getString(3));
            System.out.println("MESSAGE==>"+cst.getString(4));
            dbDestroy();

        } catch (SQLException ex) {
            returnList.add("0");
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return returnList;
        }
    }
      public static ArrayList IntegrationDailyOtherChargeInvoice(String p_date) {
        ArrayList <String> returnList = new ArrayList<String>();
        try {
            dbInitialization();
            System.err.println("P_DATE==>"+p_date);
            String pkgName="XXPL_DAILY_INVOICE_PKG.XXPL_DAILY_OTHERCHARGE_INVOICE";
            CallableStatement cst= connection.prepareCall("{call "+pkgName+"(?,?,?,?)}");    
            cst.setString(1, p_date);
            cst.registerOutParameter(2, Types.NUMERIC);
            cst.registerOutParameter(3, Types.VARCHAR);
            cst.registerOutParameter(4, Types.VARCHAR);
            cst.execute();
            returnList.add(cst.getString(2));
            returnList.add(cst.getString(3));
            returnList.add(cst.getString(4));
            System.out.println("COUNT==>"+cst.getString(2));
            System.out.println("CODE==>"+cst.getString(3));
            System.out.println("MESSAGE==>"+cst.getString(4));
            dbDestroy();

        } catch (SQLException ex) {
            returnList.add("0");
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return returnList;
        }
    }
    
    

    public static String IntegrationDailyLeaseInvoiceReport(String p_date) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxlease_report_pkg.XXPL_DAILY_INV_REPORT('"+ p_date +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }
        } catch (SQLException ex) {
            xmlString=ex.toString();
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                xmlString=ex.toString();
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    
    public static String IntegrationDailyOAInvoiceReport(String p_date) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxlease_report_pkg.XXPL_OA_DAILY_INV('"+ p_date +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }
        } catch (SQLException ex) {
            xmlString=ex.toString();
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                xmlString=ex.toString();
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    public static String IntegrationDailyOtherChargeInvoiceReport(String p_date) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select xxlease_report_pkg.XXPL_OC_DAILY_INV('"+ p_date +"') xml from dual";
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
                System.out.println(xmlString);
            }
        } catch (SQLException ex) {
            xmlString=ex.toString();
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                xmlString=ex.toString();
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
    
    

    public static String integrationErrorStatus(String P_TABLE) {
        String xmlString = null;
        try {
            dbInitialization();
            String sql = "select XXLEASE_REPORT_PKG.XXPL_ERROR_STATUS('"+ P_TABLE +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    }
     
     /**
     * Method to get mail address TO,CC,BCC from lookup
     * @param addressType 
     * @return mail address
     */
    public static String getAddressFromLookup(String addressType) { 
        String toAddress = null;
        try {
            dbInitialization();
            String sql = null;
            sql = "SELECT LOOKUP_VALUE_NAME_DISP AS MAIl_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = '" + addressType +"'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    toAddress = resultSet.getString("MAIl_ADDRESS") == null ? "" : resultSet.getString("MAIl_ADDRESS");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return toAddress;
        }
    }
    /**
     * Method to get lookup by passing type value code.
     * @param lookType ,lookValue
     * @return Lookup value name display
     */
    public static String getLookupByTypeAndValue(String lookType, String lookValue) { 
        String toAddress = null;
        try {
            dbInitialization();
            String sql = null;
            sql = "SELECT LOOKUP_VALUE_NAME_DISP AS DISP_VALUE FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = '" + lookType +"' and LOOKUP_VALUE_NAME = '" + lookValue +"'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    toAddress = resultSet.getString("DISP_VALUE") == null ? "" : resultSet.getString("DISP_VALUE");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy();
            } catch (SQLException ex) {
                Logger.getLogger(DbPackageCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            return toAddress;
        }
    }

}

