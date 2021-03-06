package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mundo.Mision;

public class PanelCrearBusqueda extends JPanel 
{
	
	private JLabel labelGame;
	
	private JComboBox<String> comboGame;
	
	private JLabel labelMonster;
	
	private Java2sAutoTextField txtMonster;
	
	private JLabel labelDif;
	
	private JComboBox<String> comboDif;
	
	private JLabel labelPlace;
	
	private Java2sAutoTextField txtPlace;
	
	public PanelCrearBusqueda(String[] games, String[] dif, List<String> mon, List<String> loc) 
	{
		setLayout(new GridLayout(4, 2, 10, 10));
		
		labelGame = new JLabel( "Game: ", SwingConstants.CENTER);
        labelGame.setFont( labelGame.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelGame );
        
        comboGame = new JComboBox<String>(games);
        add(comboGame);
        
        labelMonster = new JLabel( "Monster: ", SwingConstants.CENTER );
        labelMonster.setFont( labelMonster.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelMonster );
        
        txtMonster = new Java2sAutoTextField(mon);
        add( txtMonster );
        
        labelDif = new JLabel( "Dificulty: ", SwingConstants.CENTER);
        labelDif.setFont( labelDif.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelDif );
        
        comboDif = new JComboBox<String>(dif);
        add(comboDif);
        
        labelPlace = new JLabel( "Place: ", SwingConstants.CENTER);
        labelPlace.setFont( labelPlace.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelPlace );
        
        txtPlace = new Java2sAutoTextField(loc);
        add( txtPlace );
    
	}
	
	public String getGame()
	{
		return (String) comboGame.getSelectedItem();
	}
	
	public String getMonster()
	{
		return txtMonster.getText();
	}
	
	public String getDificulty()
	{
		return (String) comboDif.getSelectedItem();
	}

	public String getPlace()
	{
		return txtPlace.getText();
	}
}
