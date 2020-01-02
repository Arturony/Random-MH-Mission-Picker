package interfaz;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mundo.Mision;

public class PanelAddMision extends JPanel
{
	private JLabel labelGame;
	
	private JComboBox<String> txtGame;
	
	private JLabel labelName;
	
	private JTextField txtName;
	
	private JLabel labelPlace;
	
	private JTextField txtPlace;
	
	private JLabel labelDif;
	
	private JComboBox<String> txtDif;
	
	private JLabel labelOrg;
	
	private JComboBox<String> txtOrg;
	
	private JLabel labelMonster;
	
	private JTextField txtMonster;
	
	private JLabel labelObj;
	
	private JComboBox<String> txtObj;
	
	public PanelAddMision() 
	{
		setLayout(new GridLayout(7, 2, 10,10));
		
		labelGame = new JLabel( "Game: ", SwingConstants.CENTER);
        labelGame.setFont( labelGame.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelGame );
        
        txtGame = new JComboBox<String>(Mision.games);
        add( txtGame );
        
		labelName = new JLabel( "Name: ", SwingConstants.CENTER );
		labelName.setFont( labelName.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelName );
        
        txtName = new JTextField( 2 );
        add( txtName );
        
		labelPlace = new JLabel( "Place: ", SwingConstants.CENTER );
		labelPlace.setFont( labelPlace.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelPlace );
        
        txtPlace = new JTextField( 2 );
        add( txtPlace );
        
		labelDif = new JLabel( "Dificulty: ", SwingConstants.CENTER );
		labelDif.setFont( labelDif.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelDif );
        
        txtDif = new JComboBox<String>(Mision.difics);
        add( txtDif );
        
		labelOrg = new JLabel( "Organization: ", SwingConstants.CENTER );
		labelOrg.setFont( labelOrg.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelOrg );
        
        txtOrg = new JComboBox<String>(Mision.org);
        add( txtOrg );
        
		labelMonster = new JLabel( "Monster: ", SwingConstants.CENTER );
		labelMonster.setFont( labelMonster.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelMonster );
        
        txtMonster = new JTextField( 2 );
        add( txtMonster );
        
		labelObj = new JLabel( "Objetive: ", SwingConstants.CENTER );
		labelObj.setFont( labelObj.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelObj );
        
        txtObj = new JComboBox<String>(Mision.obj);
        add( txtObj );
        
	}
	
	public String getGame()
	{
		return (String) txtGame.getSelectedItem();
	}
	
	public String getName()
	{
		return txtName.getText();
	}
	
	public String getPlace()
	{
		return txtPlace.getText();
	}
	
	public String getDificulty()
	{
		return (String) txtDif.getSelectedItem();
	}
	
	public String getOrg()
	{
		return (String) txtOrg.getSelectedItem();
	}
	
	public String getMonster()
	{
		return txtMonster.getText();
	}
	
	public String getObj()
	{
		return (String) txtObj.getSelectedItem();
	}
}
