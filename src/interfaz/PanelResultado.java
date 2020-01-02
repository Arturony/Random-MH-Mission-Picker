package interfaz;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import mundo.Mision;

public class PanelResultado extends JPanel
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazMH principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel con los datos para crear el nuevo disco
     */
    private PanelMostrarResult panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesResult panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public PanelResultado( InterfazMH id, Mision m )
    {
        principal = id;

        panelDatos = new PanelMostrarResult(m);
        panelBotones = new PanelBotonesResult(this);
        
        setLayout(new BorderLayout());
        add( panelDatos, BorderLayout.CENTER );
        add( panelBotones, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Guarda el disco
     */
    public void restart( )
    {
    	principal.showSearch();
    }
    
}
