import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
  
public class TestList extends JFrame
{ 
    public TestList()
    {
        super( "Test List" );
        String[] data = { "Frodo",
                          "Sam",
                          "Merry",
                          "Pippin",
                          "Gandalf",
                          "Legolas",
                          "Gimli",
                          "Aragorn",
                          "Boromir" };
        JList list = new JList( data );
        list.setCellRenderer( new MyListRenderer() );
        JPanel p = new JPanel();
        JScrollPane sp = new JScrollPane( list );
        p.add( sp );
        getContentPane().add( p );
        addWindowListener( new ExitHandler() );
        setSize( 300, 300 );
        setVisible( true );
    }
  
    public static void main( String[] arg )
    {
        new TestList();
    }
  
    private class MyListRenderer extends DefaultListCellRenderer
    {
        private HashMap theChosen = new HashMap();
  
        public Component getListCellRendererComponent( JList list,
                Object value, int index, boolean isSelected,
                boolean cellHasFocus )
        {
            super.getListCellRendererComponent( list, value, index,
                    isSelected, cellHasFocus );
  
            if( isSelected )
            {
                theChosen.put( value, "chosen" );
            }
  
            if( theChosen.containsKey( value ) )
            {
                setForeground( Color.red );
            }
            else
            {
                setForeground( Color.black );
            }
  
            return( this );
        }
    }
  
    private class ExitHandler extends WindowAdapter
    {
        public void windowClosing( WindowEvent e )
        {
            System.exit( 0 );
        }
    }
}