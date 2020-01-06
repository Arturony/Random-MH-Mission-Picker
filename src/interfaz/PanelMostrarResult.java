package interfaz;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mundo.Mision;

public class PanelMostrarResult extends JPanel
{
	private JLabel labelGame;
	
	private JTextField txtGame;
	
	private JLabel labelName;
	
	private JTextField txtName;
	
	private JLabel labelPlace;
	
	private JTextField txtPlace;
	
	private JLabel labelDif;
	
	private JTextField txtDif;
	
	private JLabel labelOrg;
	
	private JTextField txtOrg;
	
	private JLabel labelMonster;
	
	private JTextField txtMonster;
	
	public PanelMostrarResult(Mision m) 
	{
		setLayout(new GridLayout(7, 2, 10,10));
		
		labelGame = new JLabel( "Game: ", SwingConstants.CENTER);
        labelGame.setFont( labelGame.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelGame );
        
        txtGame = new JTextField( 2 );
        txtGame.setEditable(false);
        txtGame.setText(m.getGame());
        add( txtGame );
        
		labelName = new JLabel( "Name: ", SwingConstants.CENTER );
		labelName.setFont( labelName.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelName );
        
        txtName = new JTextField( 2 );
        txtName.setEditable(false);
        txtName.setText(m.getName());
        add( txtName );
        
		labelPlace = new JLabel( "Location: ", SwingConstants.CENTER );
		labelPlace.setFont( labelPlace.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelPlace );
        
        txtPlace = new JTextField( 2 );
        txtPlace.setEditable(false);
        txtPlace.setText(m.getPlace());
        add( txtPlace );
        
		labelDif = new JLabel( "Rank: ", SwingConstants.CENTER );
		labelDif.setFont( labelDif.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelDif );
        
        txtDif = new JTextField( 2 );
        txtDif.setEditable(false);
        txtDif.setText(m.getDificulty());
        add( txtDif );
        
		labelOrg = new JLabel( "Hub: ", SwingConstants.CENTER );
		labelOrg.setFont( labelOrg.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelOrg );
        
        txtOrg = new JTextField( 2 );
        txtOrg.setEditable(false);
        txtOrg.setText(m.getOrganization());
        add( txtOrg );
        
		labelMonster = new JLabel( "Monster: ", SwingConstants.CENTER );
		labelMonster.setFont( labelMonster.getFont( ).deriveFont( Font.PLAIN ) );
        add( labelMonster );
        
        txtMonster = new JTextField( 2 );
        txtMonster.setEditable(false);
        txtMonster.setText(m.getMonster());
        add( txtMonster );
        
        
	}
	
}
