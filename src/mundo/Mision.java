package mundo;

import java.util.Comparator;

public class Mision implements Comparable<Mision>
{
	
	private String name;
	
	private String monster;
	
	private String place;
	
	private int dificulty;
	
	private String organization;
	
	private String objetive;
	
	private String game;
	
	private String imageMonster;
	
	private String imageLocation;
	
	public Mision(String name, String monster, String place, int dificulty, String organization, String objetive, String game,
			String locImg, String monImg)
	{
		this.name = name;
		this.monster = monster;
		this.place = place;
		this.dificulty = dificulty;
		this.organization = organization;
		this.objetive = objetive;
		this.game = game;
		this.imageLocation = locImg;
		this.imageMonster = monImg;
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

	public int getDificulty() {
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

	public void setDificulty(int dificulty) {
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
	
	public String getImageMonster() {
		return imageMonster;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageMonster(String imageMonster) {
		this.imageMonster = imageMonster;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
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
	
	
	public static Comparator<Mision> placeComparator = new Comparator<Mision>()
	{

		@Override
		public int compare(Mision o1, Mision o2)
		{
			return o1.getPlace().compareTo(o2.getPlace());
		}
		
	};
	
}
