package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import mundo.Mision;


public class PanelBusqueda extends JPanel
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
    private PanelCrearBusqueda panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesBusqueda panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public PanelBusqueda( InterfazMH id )
    {
        principal = id;

        panelDatos = new PanelCrearBusqueda(principal.getGames(), principal.getDificuties(), principal.getMonsters(), principal.getLocations());
        panelBotones = new PanelBotonesBusqueda(this);
        
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
    public void crearBusqueda( )
    {
        boolean parametersOk = true;
        String game = panelDatos.getGame();
        String monster = panelDatos.getMonster();
        String dificulty = panelDatos.getDificulty();
        String place = panelDatos.getPlace();
        
        
        principal.showRandMision(game, monster, dificulty, place);
    }

}
