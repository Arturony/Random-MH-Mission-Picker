package interfaz;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mundo.Mision;

public class PanelMission extends JPanel
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
    private PanelAddMision panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesMision panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public PanelMission( InterfazMH id )
    {
        principal = id;

        panelDatos = new PanelAddMision();
        panelBotones = new PanelBotonesMision(this);
        
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
    public void crearMision( )
    {

        String game = panelDatos.getGame();
        String monster = panelDatos.getMonster();
        String dificulty = panelDatos.getDificulty();
        String place = panelDatos.getPlace();
        String name = panelDatos.getName();
        String org = panelDatos.getOrg();
        String obj = panelDatos.getObj();

        if(principal.addMission(name, monster, place, dificulty, org, obj, game) == true)
        {
        	JOptionPane.showMessageDialog(this.principal, "Mission added succesfully");
        }
        principal.revalidate();
    }
    
    public void volver()
    {
    	principal.showSearchFromAdd();
    }
    
	
}
