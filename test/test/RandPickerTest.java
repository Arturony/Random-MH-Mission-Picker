package test;

import junit.framework.TestCase;
import mundo.Mision;
import mundo.RandPicker;

public class RandPickerTest extends TestCase
{
	private RandPicker mundo;
	
	private void setupEscenario1()
	{
		try {
			mundo = new RandPicker();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public void testAgregarMisiones()
	{
		setupEscenario1();
		mundo.agregarMision("m1", "m1", "p1", "1", "aldea", "slay", Mision.Game.FOUR_ULTIMATE);
		mundo.serialize();
	}*/
	/*
	public void testGetRandMonsterHeap()
	{
		
		long startTime;
		long endTime;
		long duration;
		
		startTime = System.currentTimeMillis();
		mundo.getRandByMonsterHeap("Barioth");
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("Obteniendo monstruo random con Heap");
		System.out.println("Tiempo: " + duration + " milisegundos");
	}
	
	public void testGetRandMonster()
	{
		long startTime;
		long endTime;
		long duration;
		
		startTime = System.currentTimeMillis();
		mundo.getRandByMonster("Zinogre");
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("Obteniendo monstruo random");
		System.out.println("Tiempo: " + duration + " milisegundos");
	}*/
	
}
