import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompteursCI extends JFrame {

    public CompteursCI() {
        super( "YOYOYOYYO" );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        final JButton clickMeLeft = new JButton( "0" );
        clickMeLeft.addActionListener(
                new Incrementor() );

        this.add( clickMeLeft, BorderLayout.WEST );

        final JButton clickMeCenter = new JButton( "0" );
        clickMeCenter.addActionListener(
                new Incrementor()
        );
        this.add( clickMeCenter, BorderLayout.CENTER );


        final JButton clickMeRight = new JButton( "0" );
        clickMeRight.addActionListener(
                new Incrementor()
        );
        this.add( clickMeRight, BorderLayout.EAST );
    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( Exception e ) {
            System.out.println( e );
        }

        CompteursCI j = new CompteursCI();
        j.pack();
        j.setVisible( true );
    }

    private class Incrementor implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            JButton concerned = (JButton)e.getSource();
            Integer value = Integer.parseInt( concerned.getText() );
            concerned.setText( Integer.toString( ++value ) );
        }
    }
}
