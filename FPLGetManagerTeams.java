
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import utils.Constants;
import utils.FPLUtils;

import com.google.api.client.json.JsonFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.mortbay.util.ajax.JSON;
import java.sql.*;  

public class FPLGetManagerTeams {

	private static final int BATCH_SIZE = 100;
	//private static final int NUM_TEAMS = 10000;
	//private static final int START_FROM = 1; //the last id we have already (start with zero to get from beginning)
	
	public static void main(String[] args) throws Exception {

		int startFrom = Integer.parseInt(args[0]);
		int maxTeam = Integer.parseInt(args[1]);

		java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(Constants.dbUrl,
					Constants.dbUser, Constants.dbPwd);

			Statement stmt = con.createStatement();		

			stmt.addBatch("SET NAMES utf8mb4;");
			
			for (int p = startFrom; p < maxTeam; p++) {
				try {
					String responseManager = FPLUtils.sendGet(
							"https://fantasy.premierleague.com/drf/entry/" + p + "/event/20/picks");

					HashMap dataManager = (HashMap) JSON.parse(responseManager);
	
					try {
						Object[] dataPicks = (Object[]) dataManager.get("picks");
						
						Long totalPoints = (Long)((HashMap) dataManager.get("entry_history")).get("total_points");;
						
						Long p1 = (Long)((HashMap) dataPicks[0]).get("element");
						Long p2 = (Long)((HashMap) dataPicks[1]).get("element");	
						Long p3 = (Long)((HashMap) dataPicks[2]).get("element");	
						Long p4 = (Long)((HashMap) dataPicks[3]).get("element");	
						Long p5 = (Long)((HashMap) dataPicks[4]).get("element");	
						Long p6 = (Long)((HashMap) dataPicks[5]).get("element");	
						Long p7 = (Long)((HashMap) dataPicks[6]).get("element");	
						Long p8 = (Long)((HashMap) dataPicks[7]).get("element");	
						Long p9 = (Long)((HashMap) dataPicks[8]).get("element");	
						Long p10 = (Long)((HashMap) dataPicks[9]).get("element");	
						Long p11 = (Long)((HashMap) dataPicks[10]).get("element");	
						Long p12 = (Long)((HashMap) dataPicks[11]).get("element");	
						Long p13 = (Long)((HashMap) dataPicks[12]).get("element");	
						Long p14 = (Long)((HashMap) dataPicks[13]).get("element");	
						Long p15 = (Long)((HashMap) dataPicks[14]).get("element");				

						Boolean p1c = (Boolean) ((HashMap) dataPicks[0]).get("is_captain");
						Boolean p2c = (Boolean) ((HashMap) dataPicks[1]).get("is_captain");
						Boolean p3c = (Boolean) ((HashMap) dataPicks[2]).get("is_captain");
						Boolean p4c = (Boolean) ((HashMap) dataPicks[3]).get("is_captain");
						Boolean p5c = (Boolean) ((HashMap) dataPicks[4]).get("is_captain");
						Boolean p6c = (Boolean) ((HashMap) dataPicks[5]).get("is_captain");
						Boolean p7c = (Boolean) ((HashMap) dataPicks[6]).get("is_captain");
						Boolean p8c = (Boolean) ((HashMap) dataPicks[7]).get("is_captain");
						Boolean p9c = (Boolean) ((HashMap) dataPicks[8]).get("is_captain");
						Boolean p10c = (Boolean) ((HashMap) dataPicks[9]).get("is_captain");
						Boolean p11c = (Boolean) ((HashMap) dataPicks[10]).get("is_captain");
						Boolean p12c = (Boolean) ((HashMap) dataPicks[11]).get("is_captain");
						Boolean p13c = (Boolean) ((HashMap) dataPicks[12]).get("is_captain");
						Boolean p14c = (Boolean) ((HashMap) dataPicks[13]).get("is_captain");
						Boolean p15c = (Boolean) ((HashMap) dataPicks[14]).get("is_captain");						
						
						Boolean p1vc = (Boolean) ((HashMap) dataPicks[0]).get("is_vice_captain");
						Boolean p2vc = (Boolean) ((HashMap) dataPicks[1]).get("is_vice_captain");
						Boolean p3vc = (Boolean) ((HashMap) dataPicks[2]).get("is_vice_captain");
						Boolean p4vc = (Boolean) ((HashMap) dataPicks[3]).get("is_vice_captain");
						Boolean p5vc = (Boolean) ((HashMap) dataPicks[4]).get("is_vice_captain");
						Boolean p6vc = (Boolean) ((HashMap) dataPicks[5]).get("is_vice_captain");
						Boolean p7vc = (Boolean) ((HashMap) dataPicks[6]).get("is_vice_captain");
						Boolean p8vc = (Boolean) ((HashMap) dataPicks[7]).get("is_vice_captain");
						Boolean p9vc = (Boolean) ((HashMap) dataPicks[8]).get("is_vice_captain");
						Boolean p10vc = (Boolean) ((HashMap) dataPicks[9]).get("is_vice_captain");
						Boolean p11vc = (Boolean) ((HashMap) dataPicks[10]).get("is_vice_captain");
						Boolean p12vc = (Boolean) ((HashMap) dataPicks[11]).get("is_vice_captain");
						Boolean p13vc = (Boolean) ((HashMap) dataPicks[12]).get("is_vice_captain");
						Boolean p14vc = (Boolean) ((HashMap) dataPicks[13]).get("is_vice_captain");
						Boolean p15vc = (Boolean) ((HashMap) dataPicks[14]).get("is_vice_captain");						
						
						Long p1mult = (Long)((HashMap) dataPicks[0]).get("multiplier");		
						Long p2mult = (Long)((HashMap) dataPicks[1]).get("multiplier");		
						Long p3mult = (Long)((HashMap) dataPicks[2]).get("multiplier");		
						Long p4mult = (Long)((HashMap) dataPicks[3]).get("multiplier");		
						Long p5mult = (Long)((HashMap) dataPicks[4]).get("multiplier");	
						Long p6mult = (Long)((HashMap) dataPicks[5]).get("multiplier");		
						Long p7mult = (Long)((HashMap) dataPicks[6]).get("multiplier");		
						Long p8mult = (Long)((HashMap) dataPicks[7]).get("multiplier");		
						Long p9mult = (Long)((HashMap) dataPicks[8]).get("multiplier");		
						Long p10mult = (Long)((HashMap) dataPicks[9]).get("multiplier");	
						Long p11mult = (Long)((HashMap) dataPicks[10]).get("multiplier");		
						Long p12mult = (Long)((HashMap) dataPicks[11]).get("multiplier");		
						Long p13mult = (Long)((HashMap) dataPicks[12]).get("multiplier");		
						Long p14mult = (Long)((HashMap) dataPicks[13]).get("multiplier");		
						Long p15mult = (Long)((HashMap) dataPicks[14]).get("multiplier");							
						
						String updateQuery = "insert into live_teams "
								+ "(id, total_points_last, "
								+ "p1, p1_c, p1_vc, p1_mult,"
								+ "p2, p2_c, p2_vc, p2_mult,"
								+ "p3, p3_c, p3_vc, p3_mult,"
								+ "p4, p4_c, p4_vc, p4_mult,"
								+ "p5, p5_c, p5_vc, p5_mult,"
								+ "p6, p6_c, p6_vc, p6_mult,"
								+ "p7, p7_c, p7_vc, p7_mult,"
								+ "p8, p8_c, p8_vc, p8_mult,"
								+ "p9, p9_c, p9_vc, p9_mult,"
								+ "p10, p10_c, p10_vc, p10_mult,"
								+ "p11, p11_c, p11_vc, p11_mult,"
								+ "p12, p12_c, p12_vc, p12_mult,"
								+ "p13, p13_c, p13_vc, p13_mult,"
								+ "p14, p14_c, p14_vc, p14_mult,"
								+ "p15, p15_c, p15_vc, p15_mult"
								+ ") "
								+ "VALUES "
								+ "(" + p + ", " + totalPoints + ", "
								+ p1 + ", " + p1c + ", " + p1vc + ", " + p1mult + ", "
								+ p2 + ", " + p2c + ", " + p2vc + ", " + p2mult + ", "
								+ p3 + ", " + p3c + ", " + p3vc + ", " + p3mult + ", "
								+ p4 + ", " + p4c + ", " + p4vc + ", " + p4mult + ", "		
								+ p5 + ", " + p5c + ", " + p5vc + ", " + p5mult + ", "
								+ p6 + ", " + p6c + ", " + p6vc + ", " + p6mult + ", "
								+ p7 + ", " + p7c + ", " + p7vc + ", " + p7mult + ", "
								+ p8 + ", " + p8c + ", " + p8vc + ", " + p8mult + ", "		
								+ p9 + ", " + p9c + ", " + p9vc + ", " + p9mult + ", "
								+ p10 + ", " + p10c + ", " + p10vc + ", " + p10mult + ", "
								+ p11 + ", " + p11c + ", " + p11vc + ", " + p11mult + ", "
								+ p12 + ", " + p12c + ", " + p12vc + ", " + p12mult + ", "		
								+ p13 + ", " + p13c + ", " + p13vc + ", " + p13mult + ", "
								+ p14 + ", " + p14c + ", " + p14vc + ", " + p14mult + ", "
								+ p15 + ", " + p15c + ", " + p15vc + ", " + p15mult								
								+ ")";
						
						stmt.addBatch(updateQuery);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if((p % BATCH_SIZE) == 0)
					{
						System.out.println("start save batch up to: " + p);
						stmt.addBatch("SET NAMES utf8mb4;");
						stmt.executeBatch();
						System.out.println("done save batch up to: " + p);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			stmt.executeBatch();//any leftovers
			stmt.close();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}



}