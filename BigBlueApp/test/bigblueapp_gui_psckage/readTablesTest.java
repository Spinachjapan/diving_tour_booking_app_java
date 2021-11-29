/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigblueapp_gui_psckage;

import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kipposhi
 */
public class readTablesTest {
    
 
    private final  String sql1 = "SELECT Date, DiveSiteID, DiveBoatID, Skipper, Divemaster, BaseCost, GearHire FROM divecharters WHERE DiveCharter_ID IN ('DC001');";
    private final  String type1 = "divecharters";
    private final  String sql2 = "SELECT Customer_ID, CONCAT(FName, ' ', LName) AS Name, CertificationLevel, Phone, GearHireRequired FROM customers INNER JOIN bookings on customers.Customer_ID = bookings.CustomerID WHERE DiveCharterID IN ('DC001') ;";
    private final  String type2 = "bookingCustomers"; 
    private final  String sql3 = "SELECT Counter FROM bookings ORDER BY Counter DESC LIMIT 1;";
    private final  String type3 = "bookings";
 
 @BeforeClass
    public static void setUpClass(){
   
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getRecordCount method, of class readTables.
     */
    @Test
    public void testGetRecordCount() {
        System.out.println("getRecordCount");
        assertEquals(3, new readTables(type2, sql2).getRecordCount());
    }

    /**
     * Test of getErrorMessage method, of class readTables.
     */
   @Test  
    public void testGetErrorMessage(){
        System.out.println("getErrorMessage");     
        assertEquals("",new readTables(type2, sql2).getErrorMessage());
        
    } 

    /**
     * Test of getObjDataSet method, of class readTables.
     */
    @Test
    public void testGetObjDataSet() {
        System.out.println("getObjDataSet");
        assertNotNull(new readTables(type2, sql2).getObjDataSet());
    }

    /**
     * Test of getResult method, of class readTables.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Map<String, String> test_returned_data = new HashMap<>();
        test_returned_data.put("DiveBoatID", "DB001");
        test_returned_data.put("GearHire","125" );
        test_returned_data.put("DiveSiteID","DS001" );
        test_returned_data.put("Divemaster","E002" );
        test_returned_data.put("BaseCost","140" );
        test_returned_data.put("Skipper", "E001");
        test_returned_data.put("Date", "2021-06-22");
        
        assertEquals(test_returned_data , new readTables(type1, sql1).getResult());
    }

    /**
     * Test of getBookingCount method, of class readTables.
     */
    @Test
    public void testGetBookingCount() {
        System.out.println("getBookingCount");
        assertEquals(26, new readTables(type3, sql3).getBookingCount());
        
    }

    /**
     * Test of getCountData method, of class readTables.
     */
   
}
