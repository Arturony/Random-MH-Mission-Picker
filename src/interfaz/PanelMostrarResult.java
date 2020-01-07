package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mundo.Mision;

public class PanelMostrarResult extends JPanel
{
	private static String pathLocations = "./data/images/location_icons/";
	
	private static String pathMonsters = "./data/images/monsters_icons/";
	
	private static String pathStars = "./data/images/misc/star.png";
	
	private JLabel labelGame;
	
	private JLabel txtGame;
	
	private JLabel labelName;
	
	private JLabel txtName;
	
	private JLabel labelPlace;
	
	private JLabel txtPlace;
	
	private JLabel labelDif;
	
	private JLabel txtDif;
	
	private JLabel labelOrg;
	
	private JLabel txtOrg;
	
	private JLabel labelMonster;
	
	private JLabel txtMonster;
	
	public PanelMostrarResult(Mision m) 
	{
		setLayout(new BorderLayout());
		
		JPanel pc1 = new JPanel();
		pc1.setLayout(new BorderLayout());
		
		JPanel pc2 = new JPanel();
		pc2.setLayout(new BorderLayout());
		
		JPanel pc3 = new JPanel();
		pc3.setLayout(new BorderLayout());
		
		JPanel pc4 = new JPanel();
		pc4.setLayout(new BorderLayout());
		
		JPanel pc5 = new JPanel();
		pc5.setLayout(new BorderLayout());
		
		JPanel aux1 = new JPanel();
		aux1.setLayout(new GridLayout(1, 2));
		
		//panel c 1
		labelGame = new JLabel( "Game: " );
        labelGame.setFont( labelGame.getFont( ).deriveFont( Font.PLAIN ) );
        labelGame.setBorder(new EmptyBorder(10,20,0,0));
        aux1.add( labelGame );
        
        txtGame = new JLabel(m.getGame());
        txtGame.setFont( txtGame.getFont( ).deriveFont( Font.PLAIN ) );
        txtGame.setBorder(new EmptyBorder(10,20,0,0));
        aux1.add( txtGame );
        
        pc1.add(aux1, BorderLayout.NORTH);
        
        JPanel aux2 = new JPanel();
        aux2.setLayout(new GridLayout(2,1));
        
		labelName = new JLabel( "Name: ");
		labelName.setFont( labelName.getFont( ).deriveFont( Font.PLAIN ) );
		labelName.setBorder(new EmptyBorder(10,20,0,0));
        aux2.add( labelName );
        
        txtName = new JLabel(m.getName());
        txtName.setFont( txtName.getFont( ).deriveFont( Font.PLAIN ) );
        txtName.setBorder(new EmptyBorder(10,20,0,0));
        aux2.add( txtName );
        
        //pc2
        
        pc2.add(aux2, BorderLayout.NORTH);
        
        JPanel aux8 = new JPanel();
        aux8.setLayout(new BorderLayout());
        
        JPanel aux3 = new JPanel();
        aux3.setLayout(new GridLayout(2,1));
		labelPlace = new JLabel( "Location: " );
		labelPlace.setFont( labelPlace.getFont( ).deriveFont( Font.PLAIN ) );
		labelPlace.setBorder(new EmptyBorder(10,20,0,0));
        aux3.add( labelPlace );
        
        txtPlace = new JLabel(m.getPlace());
        txtPlace.setFont( txtPlace.getFont( ).deriveFont( Font.PLAIN ) );
        txtPlace.setBorder(new EmptyBorder(10,20,0,0));
        aux3.add( txtPlace );
        
        pc2.add(aux3, BorderLayout.SOUTH);			
        
        //pc3
        pc3.add(pc2, BorderLayout.NORTH);
        
        JPanel aux4 = new JPanel();
        aux4.setLayout(new GridLayout(2,1));
        
		labelDif = new JLabel( "Rank: " );
		labelDif.setFont( labelDif.getFont( ).deriveFont( Font.PLAIN ) );
		labelDif.setBorder(new EmptyBorder(10,20,0,0));
        aux4.add( labelDif );
        
        JPanel auxS = new JPanel();
        auxS.setLayout(new GridLayout(1,0));
        
        if(m.getDificulty() < 10)
        {
        	String s = "";
        	for(int i = 0; i < m.getDificulty(); i++)
            {
            	s+= "☆";
            }
        	JLabel labelG = new JLabel( s);
        	labelG.setFont( labelG.getFont( ).deriveFont( Font.PLAIN, 15.0f ) );
    		labelG.setBorder(new EmptyBorder(0,20,0,0));
    		auxS.add(labelG);
        }
        else
        {
        	JLabel labelG = new JLabel( "G"+ (m.getDificulty()%10) + "☆");
        	labelG.setFont( labelG.getFont( ).deriveFont( Font.PLAIN, 15.0f ) );
    		labelG.setBorder(new EmptyBorder(0,20,0,0));
    		auxS.add(labelG);
        }
        aux4.add(auxS);
        pc3.add(aux4, BorderLayout.SOUTH);
        
        try {
			BufferedImage wPic1 = ImageIO.read(new File(pathLocations + m.getImageLocation()));
			JLabel wIcon1 = new JLabel(new ImageIcon(wPic1.getScaledInstance(150, 150, Image.SCALE_FAST)));
	    	wIcon1.setBorder(new EmptyBorder(10,0,0,30));
			aux8.add(wIcon1, BorderLayout.EAST);
	    	aux8.add(pc3, BorderLayout.WEST);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        pc1.add(aux8, BorderLayout.SOUTH);
        
        // pc4
        
        pc4.add(pc1, BorderLayout.NORTH);
        
        JPanel aux5 = new JPanel();
        aux5.setLayout(new GridLayout(2,1));
        
		labelOrg = new JLabel( "Hub: " );
		labelOrg.setFont( labelOrg.getFont( ).deriveFont( Font.PLAIN ) );
		labelOrg.setBorder(new EmptyBorder(10,20,0,0));
        aux5.add( labelOrg );
        
        txtOrg = new JLabel( m.getOrganization());
        txtOrg.setFont( txtOrg.getFont( ).deriveFont( Font.PLAIN ) );
        txtOrg.setBorder(new EmptyBorder(10,20,0,0));
        aux5.add( txtOrg );
        
        pc4.add(aux5, BorderLayout.SOUTH);
        
        //pc5
        
        pc5.add(pc4, BorderLayout.NORTH);
        
        JPanel aux6 = new JPanel();
        aux6.setLayout(new GridLayout(2,1));
        
		labelMonster = new JLabel( "Monster: " );
		labelMonster.setFont( labelMonster.getFont( ).deriveFont( Font.PLAIN ) );
		labelMonster.setBorder(new EmptyBorder(10,20,0,0));
        aux6.add( labelMonster );
        
        txtMonster = new JLabel(m.getMonster());
        txtMonster.setFont( txtMonster.getFont( ).deriveFont( Font.PLAIN ) );
        txtMonster.setBorder(new EmptyBorder(10,20,0,0));
        aux6.add( txtMonster );
        
        pc5.add(aux6, BorderLayout.SOUTH);
        
        add(pc5, BorderLayout.NORTH);
        
        JPanel aux7 = new JPanel();
        aux7.setLayout(new GridLayout(1, 0));
        
        String[] imgs = m.getImageMonster().split(",");
        for(int i = 0; i < imgs.length; i++)
        {
			try {
				BufferedImage wPic = ImageIO.read(new File(pathMonsters+imgs[i]));			
				JLabel wIcon = new JLabel(new ImageIcon(wPic.getScaledInstance(50, 50, Image.SCALE_FAST)));
	        	aux7.add(wIcon);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	
        }
        add(aux7, BorderLayout.SOUTH);
            
	}
	
}
