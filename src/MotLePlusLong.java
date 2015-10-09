import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MotLePlusLong extends JFrame {

    protected JList<String> jList;

    public MotLePlusLong() {
        super( "Mot le plus long" );

        JPanel haut = new JPanel();

        JTextField jTextField = new JTextField( "tes" );
        jTextField.setToolTipText( "Veuillez indiquer les lettres du tirage " );
        jTextField.setPreferredSize( new Dimension( 300, 100 ) );
        haut.add( new JLabel( "Tirage : " ), BorderLayout.WEST );
        haut.add( jTextField, BorderLayout.NORTH );
        this.add( haut, BorderLayout.NORTH );

        this.jList = new JList<String>();
        jList.setLayoutOrientation( JList.VERTICAL );

        this.motRealisable( "tes" );

        jTextField.addKeyListener( new KeyAdapter() {
            public void keyReleased( KeyEvent event ) {

                String content = jTextField.getText();
                motRealisable( content );
            }
        } );

        JScrollPane sp = new JScrollPane( jList );
        this.add( sp, BorderLayout.CENTER );

    }

    public void motRealisable( String begin ) {
        final String word = begin.toLowerCase().trim();
        this.jList.removeAll();
        DefaultListModel<String> jList1Model = new DefaultListModel<>();
        final Path path = Paths.get( "dico2a5.txt" );
        try ( Stream<String> lines = Files.lines( path ) ) {
            lines.forEach( line -> {
                //On check si notre mot est plus grand que 2
                if ( (word.length() >= 2) )
                {
                    boolean found = true;
                    char[] stringArray = line.toLowerCase().toCharArray();
                    int increment = 0;
                    System.out.println(stringArray);
                    while(found && increment < stringArray.length )
                    {
                        if ( word.indexOf( stringArray[increment] ) < 0 )
                        {
                            found = false;
                        }
                        increment++;
                    }

                    if( found )
                    {
                        jList1Model.addElement( line );
                    }
                }
            } );
            jList.setModel( jList1Model );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        } catch ( Exception e ) {
            System.out.println( e );
        }

        MotLePlusLong j = new MotLePlusLong();
        j.pack();
        j.setVisible( true );

    }
}
