package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesBusqueda extends JPanel implements ActionListener{
	 // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para crear un disco
     */
    private static final String CREAR_BUSQUEDA = "CrearBusqueda";

    /**
     * El comando para cancelar la creación de un disco
     */
    private static final String REINICIAR = "Reiniciar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al dialogo al que pertenece este panel
     */
    private PanelBusqueda ventana;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    private JButton botonCrearBusqueda;

    /**
     * Es el botón que sirve para cerrar el diálogo sin guardar los cambios
     */
    private JButton botonReiniciar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param dcs es una referencia al dialogo que contiene a este panel
     */
    public PanelBotonesBusqueda( PanelBusqueda dcs )
    {

        ventana = dcs;

        botonCrearBusqueda = new JButton( "Search" );
        botonCrearBusqueda.setActionCommand( CREAR_BUSQUEDA );
        botonCrearBusqueda.addActionListener( this );
        add( botonCrearBusqueda );
        /*
        botonReiniciar = new JButton( "Cancelar" );
        botonReiniciar.setActionCommand( REINICIAR );
        botonReiniciar.addActionListener( this );
        add( botonReiniciar );
        */

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones asociadas a los eventos
     * @param evento es el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CREAR_BUSQUEDA.equals( comando ) )
        {
            ventana.crearBusqueda( );
        }

    }

}
