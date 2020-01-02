package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

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
	
	private PanelMission addMission;
	
	public InterfazMH() 
	{
		try 
		{
			mundo = new RandPicker();
			busqueda = new PanelBusqueda(this);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this, "There has been an error reading the data file");
			return;
		}
		
		setLayout (new BorderLayout());          
        add( busqueda, BorderLayout.CENTER );
        
        setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE);
        setLocation (50,50);
        setResizable( false );
        setBackground( Color.WHITE );

        setTitle( "Random Picker" );
		setSize ( 350, 300); 
	}
	
	public void showRandMision(String game, String monster, String dificulty, String place)
	{
		Mision m = mundo.getRandParams(game, monster, dificulty, place);
		if(m == null)
		{
			JOptionPane.showMessageDialog(this, "The data is not valid");
		}
		else
		{
			resultado = new PanelResultado(this, m);
			this.remove(busqueda);
			this.add(resultado, BorderLayout.CENTER);
			this.revalidate();
		}
	}
	
	public void showAddMission()
	{
		addMission = new PanelMission(this);
		this.remove(busqueda);
		this.add(addMission, BorderLayout.CENTER);
		this.revalidate();
	}
	
	public boolean addMission(String name, String monster, String place, String dificulty, String organization, String objetive, String game)
	{
		return this.mundo.agregarMision(name, monster, place, dificulty, organization, objetive, game);
	}
	
	public void showSearch()
	{
		busqueda = new PanelBusqueda(this);
		this.remove(resultado);
		this.add(busqueda, BorderLayout.CENTER);
		this.revalidate();
	}
	
	public void showSearchFromAdd()
	{
		busqueda = new PanelBusqueda(this);
		this.remove(addMission);
		this.add(busqueda, BorderLayout.CENTER);
		this.revalidate();
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
                    interfaz.mundo.serialize();
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
