import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Player3Boutons extends JFrame {

    protected int soundState = 0;

    protected JButton playButton;
    protected JButton pauseButton;
    protected JButton stopButton;

    protected Son son;

    public Player3Boutons()
    {
        super( "YOYOYOYYO" );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        final ImageIcon playIcon = new ImageIcon( "images"+ File.separator+"play.jpg" );
        final ImageIcon playPressed = new ImageIcon( "images"+ File.separator+"play_pressed.jpg" );
        ImageIcon playDisabled = new ImageIcon( "images"+ File.separator+"play_disabled.jpg" );

        final ImageIcon stopIcon = new ImageIcon( "images"+ File.separator+"stop.jpg" );
        final ImageIcon stopPressed = new ImageIcon( "images"+ File.separator+"stop_pressed.jpg" );
        ImageIcon stopDisabled = new ImageIcon( "images"+ File.separator+"stop_disabled.jpg" );

        final ImageIcon pauseIcon = new ImageIcon( "images"+ File.separator+"pause.jpg" );
        final ImageIcon pausePressed = new ImageIcon( "images"+ File.separator+"pause_pressed.jpg" );
        final ImageIcon pauseDisabled = new ImageIcon( "images"+ File.separator+"pause_disabled.jpg" );

        this.playButton = new JButton( playIcon );

        playButton.setPressedIcon( playPressed );

        playButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if(playButton.getIcon().toString().contains( "pressed" ))
                {
                    son.stop();
                    stopButton.setEnabled( false );
                    playButton.setEnabled( false );
                    playButton.setIcon( playIcon );
                }else{
                    if (soundState == 0 )
                    {
                        son = new Son( "sons"+File.separator+"son.wav" );
                        son.start();
                    } else {
                        son.resume();
                    }
                    soundState = 1;
                    stopButton.setEnabled( true );
                    stopButton.setIcon( stopIcon );
                    pauseButton.setEnabled( true );
                    pauseButton.setIcon( pauseIcon );
                    playButton.setIcon( playPressed );
                    playButton.setEnabled( false );
                }
            }
        } );

        this.add( playButton, BorderLayout.WEST );

        this.pauseButton = new JButton( pauseDisabled );
        pauseButton.setEnabled( false );
        pauseButton.setPressedIcon( pausePressed );

        pauseButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if(pauseButton.getIcon().toString().contains( "pressed" ))
                {
                    pauseButton.setIcon( pauseDisabled );
                }else{
                    son.suspend();
                    stopButton.setEnabled( true );
                    stopButton.setIcon( stopIcon );
                    playButton.setEnabled( true );
                    playButton.setIcon( playIcon );
                    pauseButton.setEnabled( false );
                    pauseButton.setIcon( pausePressed );
                }
            }
        } );
        this.add( pauseButton, BorderLayout.CENTER );

        this.stopButton = new JButton( new ImageIcon( "images"+ File.separator+"stop_disabled.jpg" ) );
        stopButton.setEnabled( false );
        stopButton.setPressedIcon( new ImageIcon( "images"+File.separator+"stop_pressed.jpg" ) );

        stopButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if(stopButton.getIcon().toString().contains( "pressed" ))
                {
                    stopButton.setIcon( new ImageIcon( "images"+ File.separator+"stop.jpg" ) );
                }else{
                    son.stop();
                    soundState = 0;
                    pauseButton.setIcon( pauseDisabled );
                    pauseButton.setEnabled( false );

                    playButton.setEnabled( true );
                    playButton.setIcon( playIcon );
                    stopButton.setIcon( stopPressed );
                    stopButton.setEnabled( false );
                }
            }
        } );
        this.add( stopButton, BorderLayout.EAST );


    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( Exception e ) {
            System.out.println( e );
        }

        Player3Boutons j = new Player3Boutons();
        j.pack();
        j.setVisible( true );
    }
}
