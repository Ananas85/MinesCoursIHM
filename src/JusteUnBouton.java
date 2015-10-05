import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JusteUnBouton extends JFrame {

    public JusteUnBouton()
    {
        super("Juste un bouton");
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        JButton clickMe = new JButton(new ImageIcon( "images"+ File.separator+"unpressed.jpg" ) );
        this.getContentPane().add( clickMe );
        clickMe.setMargin( new Insets( 0, 100, 0, 100 ) );
        clickMe.setPreferredSize( new Dimension( 400, 100 ) );
        clickMe.setBorderPainted( true );
        clickMe.setContentAreaFilled( true );
        clickMe.setBackground( Color.CYAN );
        clickMe.setForeground( Color.blue );
        clickMe.setEnabled( true );
        clickMe.setPressedIcon( new ImageIcon( "images"+File.separator+"pressed.jpg" ) );
    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        JusteUnBouton j = new JusteUnBouton();
        j.pack();
        j.setVisible( true );

    }
}
