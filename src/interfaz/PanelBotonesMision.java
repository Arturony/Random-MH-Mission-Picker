package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesMision extends JPanel implements ActionListener
{
	 // -----------------------------------------------------------------
   // Constantes
   // -----------------------------------------------------------------

   /**
    * El comando para crear un disco
    */
   private static final String VOLVER = "Volver";

   /**
    * El comando para cancelar la creación de un disco
    */
   private static final String AGREGAR = "Agregar";

   // -----------------------------------------------------------------
   // Atributos
   // -----------------------------------------------------------------

   /**
    * Es una referencia al dialogo al que pertenece este panel
    */
   private PanelMission ventana;

   // -----------------------------------------------------------------
   // Atributos de la Interfaz
   // -----------------------------------------------------------------
   private JButton botonVolver;

   /**
    * Es el botón que sirve para cerrar el diálogo sin guardar los cambios
    */
   private JButton botonAgregar;

   // -----------------------------------------------------------------
   // Constructores
   // -----------------------------------------------------------------

   /**
    * Construye el panel e inicializa sus componentes
    * @param dcs es una referencia al dialogo que contiene a este panel
    */
   public PanelBotonesMision( PanelMission dcs )
   {

       ventana = dcs;

       botonVolver = new JButton( "Back" );
       botonVolver.setActionCommand( VOLVER );
       botonVolver.addActionListener( this );
       add( botonVolver );
       
       botonAgregar = new JButton( "Add" );
       botonAgregar.setActionCommand( AGREGAR );
       botonAgregar.addActionListener( this );
       add( botonAgregar );
       

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

       if( VOLVER.equals( comando ) )
       {
           ventana.volver();
       }
       else if(AGREGAR.equals(comando))
       {
       		ventana.crearMision();
       }

   }
}
