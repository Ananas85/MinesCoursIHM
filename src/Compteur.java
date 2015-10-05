import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compteur extends JFrame {
    public Compteur()
    {
        super("YOYOYOYYO");
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        final JButton clickMe = new JButton("0" );
        this.getContentPane().add( clickMe );
        clickMe.setMargin( new Insets( 0, 100, 0, 100 ) );
        clickMe.setPreferredSize( new Dimension( 400, 100 ) );
        clickMe.setEnabled( true );
        clickMe.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer value = Integer.parseInt( clickMe.getText() );
                clickMe.setText( Integer.toString( ++value) );
            }
        });
    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( Exception e ) {
            System.out.println( e );
        }

        Compteur j = new Compteur();
        j.pack();
        j.setVisible( true );
    }
}
