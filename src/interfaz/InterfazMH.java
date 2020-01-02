package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

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
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
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
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son validos");
		}
		else
		{
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
	
	public static void main( String[] args )
    {
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazMH interfaz = new InterfazMH( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
