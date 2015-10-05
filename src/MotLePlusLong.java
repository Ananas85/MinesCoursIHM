import javax.swing.*;
import java.awt.*;

public class MotLePlusLong extends JFrame {
    public MotLePlusLong()
    {
        super("Mot le plus long");

        JPanel haut = new JPanel();

        JTextField jTextField = new JTextField( "tes" );
        jTextField.setToolTipText( "Veuillez indiquer les lettres du tirage " );
        haut.add( new JLabel( "Tirage : " ), BorderLayout.WEST );
        haut.add( jTextField, BorderLayout.NORTH );
        this.add( haut, BorderLayout.NORTH );

        String[] list = {"est", "set", "tes"};
        JList<String> jList = new JList<String>( list );
        jList.setLayoutOrientation( JList.VERTICAL );
        JScrollPane sp = new JScrollPane( jList );
        this.add( sp, BorderLayout.CENTER );

    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        MotLePlusLong j = new MotLePlusLong();
        j.pack();
        j.setVisible( true );

    }
}
