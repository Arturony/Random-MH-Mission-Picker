package persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mundo.Mision;

public class SQLiteDBManager 
{
	private static String className = "org.sqlite.JDBC";
	
	private static String jdbc = "jdbc:sqlite:";
	
	private static String path = "./data/DB/";
	
	private static String defaultDB = "mhManagment.db";
	
	Connection c = null;
	Statement stmt = null;
	
	public SQLiteDBManager() 
	{
		try
		{
			Class.forName(className);
			c = DriverManager.getConnection(jdbc + path + defaultDB);
			System.out.println("connected to " + defaultDB);
		} catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<String> getGames()
	{
		ArrayList<String> ans = new ArrayList<String>();
		try 
		{		
			this.stmt = c.createStatement();
			String q = "SELECT name from games order by _id";
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next())
			{
				ans.add(rs.getString("name"));
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	public ArrayList<String> getDificulties()
	{
		ArrayList<String> ans = new ArrayList<String>();
		try 
		{		
			this.stmt = c.createStatement();
			String q = "SELECT name from dificulties order by _id";
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next())
			{
				ans.add(rs.getString("name"));
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	public List<String> getMonsters()
	{
		List<String> ans = new ArrayList<String>();
		try 
		{		
			this.stmt = c.createStatement();
			String q = "SELECT name from monsters";
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next())
			{
				ans.add(rs.getString("name"));
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	public List<String> getLocations()
	{
		List<String> ans = new ArrayList<String>();
		try 
		{		
			this.stmt = c.createStatement();
			String q = "SELECT name from locations";
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next())
			{
				ans.add(rs.getString("name"));
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	public Mision getRandomMission(String game, String monster, String dif, String place)
	{
		Mision ans = null;
		try 
		{	
			boolean gameB = isAny(game);
			boolean difB = isAny(dif);
			int stars = 0;
			if(!difB)
			{
				stars = getStars(dif);
			}
			if(gameB)
			{
				String name = getRandDBName();
				switchDB(name);
			}
			else
			{
				String name = getDBName(game);
				switchDB(name);
			}
			String queryM = "select _id as mID from monsters where name like '%" + monster + "%'";
			String queryJM = "select quest_id from (" + queryM + ") a inner join monster_to_quest m on a.mID = m.monster_id";
			String queryL = "select _id as lID from locations where name like '%" + place + "%'";
			String queryD = "select _id as qID from quests where location_id = (" + queryL + ") ";
			String queryQ = "";
			String queryE ="";
			if(difB == false && place.equals(""))
			{
				queryD = "select _id as qID from quests where stars = '" + stars + "'";
			}
			else if(difB == false && !place.equals(""))
			{
				String queryS = "select _id as qID from quests where stars = '" + stars + "'";
				queryE = "select qD.qID from (" + queryS + ") qE inner join (" + queryD + ") qD on qE.qID = qD.qID"; 
				queryD = queryE;
			}
			if(monster.equals("") && !place.equals(""))
			{
				queryQ = queryD + " order by random() limit 1";
			}
			else if(place.equals("") && !monster.equals("")) 
			{
				queryQ = queryJM + " order by random() limit 1";
			}
			else
			{
				queryQ = "select qL.qID as qID from (" + queryJM + ") qM inner join (" + queryD + ") qL on qM.quest_id = qL.qID order by random() limit 1";
			}
			
			String fullQ = "select * from quests where _id = (" + queryQ + ")"; 
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(fullQ);
			ans = new Mision(rs.getString("name"), rs.getInt("_id")+"", rs.getInt("location_id")+"", rs.getInt("stars")+"", rs.getString("hub"), " " , game);
			String mon = getMonster(ans.getMonster());
			String pla = getPlace(ans.getPlace());
			ans.setMonster(mon);
			ans.setPlace(pla);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchDefaultDB();
		return ans;
	}
	
	private String getDBName(String name)
	{
		String ans = "";
		try 
		{		
			this.stmt = c.createStatement();
			String q = "SELECT db_name from games WHERE name = '" + name + "'";
			ResultSet rs = stmt.executeQuery(q);
			ans = rs.getString("db_name");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	private String getRandDBName()
	{
		String ans = "";
		try 
		{		
			this.stmt = c.createStatement();
			String q = "SELECT db_name from games where _id > 1 order by random() limit 1";
			ResultSet rs = stmt.executeQuery(q);
			ans = rs.getString("db_name");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	private boolean isAny(String s)
	{
		boolean rta = false;
		try 
		{		
			this.stmt = c.createStatement();
			String q = "select _id from games where name = '" + s +"'";
			ResultSet rs = stmt.executeQuery(q);
			if(rs.getInt("_id") == 1)
			{
				rta = true;
			}
			else
			{
				rta = false;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return rta;
	}
	
	public void switchDB(String name)
	{
		try
		{
			Class.forName(className);
			c = DriverManager.getConnection(jdbc + path + name);
			System.out.println("connected to " + name);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void switchDefaultDB()
	{
		try
		{
			Class.forName(className);
			c = DriverManager.getConnection(jdbc + path + defaultDB);
			System.out.println("connected to " + defaultDB);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public String getDif(String stars)
	{
		String ans = "";
		try 
		{		
			this.stmt = c.createStatement();
			String q = "select name from dificulties where stars = '" + stars + "'";
			ResultSet rs = stmt.executeQuery(q);
			ans = rs.getString("name");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	public int getStars(String name)
	{
		int ans = 0;
		try 
		{		
			this.stmt = c.createStatement();
			String q = "select stars from dificulties where name = '" + name + "'";
			ResultSet rs = stmt.executeQuery(q);
			ans = rs.getInt("stars");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	private String getMonster(String idQuest)
	{
		String ans = "";
		try 
		{		
			this.stmt = c.createStatement();
			String j = "select monster_id from monster_to_quest where quest_id = '" + idQuest + "'";
			String q = "select name from monsters where _id = (" + j + ")";
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next())
			{
				ans += rs.getString("name") + "  ";
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	private String getPlace(String id)
	{
		String ans = "";
		try 
		{		
			this.stmt = c.createStatement();
			String q = "SELECT name from locations where _id = '" + id + "'";
			ResultSet rs = stmt.executeQuery(q);
			ans = rs.getString("name");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return ans;
	}
	
	public void close() throws SQLException
	{
		c.close();
		c = null;
	}
}
