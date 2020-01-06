package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import mundo.Mision;
import mundo.RandPicker;


public class InterfazMH extends JFrame 
{
	private RandPicker mundo;
	
	private PanelBusqueda busqueda;
	
	private PanelResultado resultado;
	
	public InterfazMH() 
	{
		try 
		{
			mundo = new RandPicker();
			busqueda = new PanelBusqueda(this);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this, "Se ha presentado un error al cargar los datos");
			return;
		}
		
		setLayout (new BorderLayout());          
        add( busqueda, BorderLayout.CENTER );
        
        setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE);
        setLocation (50,50);
        setResizable( false );
        setBackground( Color.WHITE );

        setTitle( "Random Picker" );
		setSize ( 400, 350); 
	}
	
	public void showRandMision(String game, String monster, String dificulty, String place)
	{
		Mision m = mundo.getRandParams(game, monster, dificulty, place);
		if(m == null)
		{
			JOptionPane.showMessageDialog(this, "Could not find a mission. Please retry");
		}
		else
		{
			m.setDificulty(this.mundo.getDificulty(m.getDificulty()));
			resultado = new PanelResultado(this, m);
			this.remove(busqueda);
			this.add(resultado, BorderLayout.CENTER);
			this.revalidate();
		}
	}
	
	public void showSearch()
	{
		busqueda = new PanelBusqueda(this);
		this.remove(resultado);
		this.add(busqueda, BorderLayout.CENTER);
		this.revalidate();
	}
	
	public String[] getGames()
	{
		ArrayList<String> a = mundo.getGames();
		String[] rta = new String[a.size()];
		for(int i = 0; i < a.size(); i++)
		{
			rta[i] = a.get(i);
		}
		return rta;
	}
	
	public String[] getDificuties()
	{
		ArrayList<String> a = mundo.getDificulties();
		String[] rta = new String[a.size()];
		for(int i = 0; i < a.size(); i++)
		{
			rta[i] = a.get(i);
		}
		return rta;
	}
	
	public List<String> getMonsters()
	{
		return this.mundo.getMonsters();
	}
	
	public List<String> getLocations()
	{
		return this.mundo.getLocations();
	}
	
	public static void main( String[] args )
    {
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazMH interfaz = new InterfazMH( );
            interfaz.setVisible( true );
            interfaz.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) {
                    try {
						interfaz.mundo.close();
						System.out.println("The database was closed");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    ((JFrame)(e.getComponent())).dispose();
                }
            });
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
