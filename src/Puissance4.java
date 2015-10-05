import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Puissance4 extends JFrame {

    public static final int NB_COL = 7;
    public static final int NB_LIG = 6;

    public Puissance4() {
        JPanel haut = new JPanel( new GridLayout( 1, this.NB_COL ) );
        JButton[] jButtons = new JButton[this.NB_COL];

        for ( int i = 0; i < this.NB_COL; i++ ) {
            JButton plop = new JButton( new ImageIcon( "images" + File.separator + "blanc.jpg" ) );
            plop.setRolloverIcon( new ImageIcon( "images" + File.separator + "drop.jpg" ) );
            plop.setBorder( null );
            jButtons[i] = plop;
            haut.add(plop);
        }
        this.add( haut, BorderLayout.NORTH );
        JPanel bas = new JPanel( new GridLayout( this.NB_LIG, this.NB_COL ) );

        JLabel[][] jLabels = new JLabel[NB_LIG][NB_COL];
        for ( int i = 0; i < this.NB_LIG; i++ ) {
            for ( int j = 0; j < this.NB_COL; j++ ) {
                if ( (i == 5 && j == 3) || (i == 4 && j == 3) ) {
                    jLabels[i][j] = new JLabel( new ImageIcon( "images" + File.separator + "rouge.jpg" ) );
                } else if ( (i == 5 && j == 2) || (i == 3 && j == 3) ) {
                    jLabels[i][j] = new JLabel( new ImageIcon( "images" + File.separator + "jaune.jpg" ) );
                } else {
                    jLabels[i][j] = new JLabel( new ImageIcon( "images" + File.separator + "vide.jpg" ) );

                }
                bas.add(jLabels[i][j]);

            }
        }
        this.add(bas, BorderLayout.SOUTH);
    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( Exception e ) {
            System.out.println( e );
        }

        Puissance4 j = new Puissance4();
        j.pack();
        j.setResizable( false );
        j.setVisible( true );
    }
}
