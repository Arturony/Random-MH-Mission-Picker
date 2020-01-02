package mundo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import data_stuctures.Heap;
import data_stuctures.ResizingArrayBag;

public class RandPicker {
	
	private static String datas = "./data/json/missions.json";
	
	private ResizingArrayBag<Mision> misions;
	
	public RandPicker() throws Exception 
	{
		misions = new ResizingArrayBag<Mision>();
		
		deserialize();
	}
	
	public Mision getRandByMonsterHeap(String monster)
	{
		
		Heap.sort(misions.get(), misions.get(0).monsterComparator);
		
		ArrayList<Mision> rand = new ArrayList<Mision>();
		
		for (Mision m : misions) 
		{
			if(monster.compareTo(m.getMonster()) < 0)
			{
				break;
			}
			else if(monster.compareToIgnoreCase(m.getMonster()) == 0)
			{
				rand.add(m);
			}		
		}
		
		LocalDateTime now = LocalDateTime.now();
		Random r = new Random(now.getLong(ChronoField.NANO_OF_DAY));
		
		return rand.get((r.nextInt(rand.size())));
	}
	
	public Mision getRand()
	{
		LocalDateTime now = LocalDateTime.now();
		Random r = new Random(now.getLong(ChronoField.NANO_OF_DAY));
		
		return misions.get((r.nextInt(misions.size())));
	}
	
	public Mision getRandByMonster(String monster)
	{
		ArrayList<Mision> rand = new ArrayList<Mision>();
		
		for (Mision m : misions) 
		{
			if(monster.equalsIgnoreCase(m.getMonster()))
			{
				rand.add(m);
			}
		}
		
		LocalDateTime now = LocalDateTime.now();
		Random r = new Random(now.getLong(ChronoField.NANO_OF_DAY));
		
		return rand.get((r.nextInt(rand.size())));
	}
	
	public Mision getRandByGame(String game)
	{
		ArrayList<Mision> rand = new ArrayList<Mision>();
		
		for (Mision m : misions) 
		{
			if(game.compareTo(m.getGame()) == 0)
			{
				rand.add(m);
			}
		}
		
		LocalDateTime now = LocalDateTime.now();
		Random r = new Random(now.getLong(ChronoField.NANO_OF_DAY));
		
		return rand.get((r.nextInt(rand.size())));
	}
	
	public Mision getRandByDif(String dif)
	{
		ArrayList<Mision> rand = new ArrayList<Mision>();
		
		for (Mision m : misions) 
		{
			if(dif.equalsIgnoreCase(m.getDificulty()))
			{
				rand.add(m);
			}
		}
		
		LocalDateTime now = LocalDateTime.now();
		Random r = new Random(now.getLong(ChronoField.NANO_OF_DAY));
		
		return rand.get((r.nextInt(rand.size())));
	}
	
	public Mision getRandByPlace(String place)
	{
		ArrayList<Mision> rand = new ArrayList<Mision>();
		
		for (Mision m : misions) 
		{
			if(place.equalsIgnoreCase(m.getPlace()))
			{
				rand.add(m);
			}
		}
		
		LocalDateTime now = LocalDateTime.now();
		Random r = new Random(now.getLong(ChronoField.NANO_OF_DAY));
		
		return rand.get((r.nextInt(rand.size())));
	}
	
	public Mision getRandParams(String game, String monster, String dif, String place)
	{
		ArrayList<Mision> rand = new ArrayList<Mision>();
		
		for (Mision m : misions) 
		{
			if(game.equalsIgnoreCase(m.getGame()) || monster.equalsIgnoreCase(m.getMonster()) || dif.equalsIgnoreCase(m.getDificulty()) || place.equalsIgnoreCase(m.getPlace()))
			{
				rand.add(m);
			}
		}
		
		if(rand.size() != 0)
		{
			LocalDateTime now = LocalDateTime.now();
			Random r = new Random(now.getLong(ChronoField.NANO_OF_DAY));
			
			return rand.get((r.nextInt(rand.size())));
		}
		else
			return getRand();
	}

	public void agregarMision(String name, String monster, String place, String dificulty, String organization, String objetive, String game)
	{
		misions.add(new Mision(name, monster, place, dificulty, organization, objetive, game));
	}

	public void deserialize() throws Exception
	{
		Path data = FileSystems.getDefault().getPath(datas);
		BufferedReader reader;
		Gson gson = new Gson();
		try
		{
			reader = Files.newBufferedReader(data);
			misions = gson.fromJson(reader, new TypeToken<ResizingArrayBag<Mision>>(){}.getType());
		}
		catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public void serialize()
	{
		try(Writer writerEdges = new FileWriter(datas))
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		    gson.toJson(misions, writerEdges);
		    System.out.println("Arcos serializados correctamente al archivo missions.json");
		}		
		catch (JsonIOException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}