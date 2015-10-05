import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompteursCIA extends JFrame {

    public CompteursCIA() {
        super( "YOYOYOYYO" );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        final JButton clickMeLeft = new JButton( "0" );
        clickMeLeft.addActionListener(
                new ActionListener() {
                    public void actionPerformed( ActionEvent e ) {
                        Integer value = Integer.parseInt( clickMeLeft.getText() );
                        clickMeLeft.setText( Integer.toString( ++value ) );
                    }

                } );

        this.add( clickMeLeft, BorderLayout.WEST );

        final JButton clickMeCenter = new JButton( "0" );
        clickMeCenter.addActionListener(
                new ActionListener() {
                    public void actionPerformed( ActionEvent e ) {
                        Integer value = Integer.parseInt( clickMeCenter.getText() );
                        clickMeCenter.setText( Integer.toString( ++value ) );
                    }

                }
        );
        this.add( clickMeCenter, BorderLayout.CENTER );


        final JButton clickMeRight = new JButton( "0" );
        clickMeRight.addActionListener(
                new ActionListener() {
                    public void actionPerformed( ActionEvent e ) {
                        Integer value = Integer.parseInt( clickMeRight.getText() );
                        clickMeRight.setText( Integer.toString( ++value ) );
                    }

                }
        );
        this.add( clickMeRight, BorderLayout.EAST );


    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( Exception e ) {
            System.out.println( e );
        }

        CompteursCIA j = new CompteursCIA();
        j.pack();
        j.setVisible( true );
    }
}
