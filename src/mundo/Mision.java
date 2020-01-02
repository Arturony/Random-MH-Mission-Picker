package mundo;

import java.util.Comparator;

public class Mision implements Comparable<Mision>
{
	
	public static String[] games = {"Cualquiera","Freedom", "Freedom Unite", "Portable 3rd", "Tri", "4 Ultimate", "Generations", "Generations Ultimate", "World", "Iceborne"};
	
	public static String[] difics = {"Cualquiera","1*","2*","3*","4*", "5*", "6*", "7*", "8*", "9*", "10*", "G1", "G2", "G3", "G4"};
	
	public static String[] places = {};
	
	private String name;
	
	private String monster;
	
	private String place;
	
	private String dificulty;
	
	private String organization;
	
	private String objetive;
	
	private String game;
	
	public Mision(String name, String monster, String place, String dificulty, String organization, String objetive, String game)
	{
		this.name = name;
		this.monster = monster;
		this.place = place;
		this.dificulty = dificulty;
		this.organization = organization;
		this.objetive = objetive;
		this.game = game;
	}

	public String getName() {
		return name;
	}

	public String getMonster() {
		return monster;
	}

	public String getPlace() {
		return place;
	}

	public String getDificulty() {
		return dificulty;
	}

	public String getOrganization() {
		return organization;
	}

	public String getObjetive() {
		return objetive;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMonster(String monster) {
		this.monster = monster;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setDificulty(String dificulty) {
		this.dificulty = dificulty;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setObjetive(String objetive) {
		this.objetive = objetive;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	@Override
	public int compareTo(Mision o) {
		return 0;
	}
	
	public static Comparator<Mision> monsterComparator = new Comparator<Mision>()
	{

		@Override
		public int compare(Mision o1, Mision o2)
		{
			return o1.getMonster().compareTo(o2.getMonster());
		}
		
	};
	
	public static Comparator<Mision> gameComparator = new Comparator<Mision>()
	{

		@Override
		public int compare(Mision o1, Mision o2)
		{
			return o1.getGame().compareTo(o2.getGame());
		}
		
	};
	
	public static Comparator<Mision> difComparator = new Comparator<Mision>()
	{

		@Override
		public int compare(Mision o1, Mision o2)
		{
			return o1.getDificulty().compareTo(o2.getDificulty());
		}
		
	};
	
	public static Comparator<Mision> placeComparator = new Comparator<Mision>()
	{

		@Override
		public int compare(Mision o1, Mision o2)
		{
			return o1.getPlace().compareTo(o2.getPlace());
		}
		
	};
	
}
