import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class Proprietes extends JFrame {

    public Proprietes() {
        super( "Propriétés" );
        this.creePartieGauche();
        this.creePartieDroite();
    }

    public void creePartieGauche() {
        JPanel panelGauche = new JPanel( new BorderLayout(  ) );
        JPanel panelCouleur = new JPanel( new BorderLayout(  ) );


        JLabel couleur = new JLabel( "Couleur : " );
        panelCouleur.add( couleur, BorderLayout.WEST );


        JSlider slider = new JSlider( JSlider.HORIZONTAL, 0, 100, 50  );
        slider.setMajorTickSpacing( 50 );
        Hashtable etiquettes = new Hashtable();
        etiquettes.put( new Integer( 0 ), new JLabel( "Blanc" ));
        etiquettes.put( new Integer( 50 ), new JLabel( "Gris" ));
        etiquettes.put( new Integer( 100 ), new JLabel( "Noir" ));
        slider.setLabelTable( etiquettes );
        slider.setPaintLabels( true );
        slider.setPaintTicks( true );
        panelCouleur.add( slider, BorderLayout.CENTER );

        panelGauche.add(panelCouleur, BorderLayout.NORTH);


        JPanel panelTaille = new JPanel( new BorderLayout(  ) );
        panelTaille.add( new JLabel( "Taille : " ), BorderLayout.WEST );

        String[] sizes = {"Petit", "Moyen", "Grand"};
        JComboBox<String> comboSize = new JComboBox<String>( sizes );
        panelTaille.add( comboSize, BorderLayout.CENTER );

        panelGauche.add( panelTaille, BorderLayout.WEST );

        this.add( panelGauche, BorderLayout.WEST );

    }

    public void creePartieDroite() {

        JPanel panelDroite = new JPanel(  );
        panelDroite.setLayout( new BoxLayout( panelDroite, BoxLayout.Y_AXIS ) );

        JLabel matiere = new JLabel( "Matières " );
        panelDroite.add( matiere );

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton bois = new JRadioButton( "Bois" );
        JRadioButton metal = new JRadioButton( "Metal" );
        JRadioButton plastique = new JRadioButton( "plastique" );
        buttonGroup.add( bois );
        buttonGroup.add(metal);
        buttonGroup.add( plastique );
        buttonGroup.setSelected( metal.getModel(), true );

        panelDroite.add( bois );
        panelDroite.add( metal );
        panelDroite.add( plastique );
        this.add( panelDroite, BorderLayout.EAST );


    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( Exception e ) {
            System.out.println( e );
        }

        Proprietes j = new Proprietes();
        j.pack();
        j.setVisible( true );
    }
}
