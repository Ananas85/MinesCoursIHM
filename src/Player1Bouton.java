import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Player1Bouton extends JFrame {
    public Player1Bouton()
    {
        super( "YOYOYOYYO" );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        JButton playButton = new JButton( new ImageIcon( "images"+ File.separator+"play.jpg" ) );
        playButton.setPressedIcon( new ImageIcon( "images"+File.separator+"play_pressed.jpg" ) );

        playButton.addActionListener( new PlayListener() );
        this.add( playButton, BorderLayout.WEST );


    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( Exception e ) {
            System.out.println( e );
        }

        Player1Bouton j = new Player1Bouton();
        j.pack();
        j.setVisible( true );
    }

    private class PlayListener implements ActionListener{

        @Override
        public void actionPerformed( ActionEvent e ) {
            JButton concerned = (JButton)e.getSource();
            if(concerned.getIcon().toString().contains( "pressed" ))
            {
                concerned.setIcon( new ImageIcon( "images"+ File.separator+"play.jpg" ) );
            }else{
                concerned.setIcon( new ImageIcon( "images"+ File.separator+"play_pressed.jpg" ) );
            }
        }
    }
}
