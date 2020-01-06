package mundo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import persistence.SQLiteDBManager;


public class RandPicker {
	
	private SQLiteDBManager manager;
	
	public RandPicker() throws Exception 
	{
		manager = new SQLiteDBManager();
	}
	
	public Mision getRand()
	{
		return null;
	}
	
	public ArrayList<String> getGames()
	{
		return manager.getGames();
	}
	
	public ArrayList<String> getDificulties()
	{
		return manager.getDificulties();
	}
	
	public List<String> getMonsters()
	{
		return manager.getMonsters();
	}
	
	public List<String> getLocations()
	{
		return manager.getLocations();
	}
	
	public String getDificulty(String stars)
	{
		return this.manager.getDif(stars);
	}
		
	public void close() throws SQLException
	{
		this.manager.close();
	}
	
	public Mision getRandParams(String game, String monster, String dif, String place)
	{
		return this.manager.getRandomMission(game, monster, dif, place);
	}
}
