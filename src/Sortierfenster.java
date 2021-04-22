import com.curryp0mmes.sortingalgorithms.algorithms.*;
import com.curryp0mmes.sortingalgorithms.algorithms.template.*;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class Sortierfenster extends JFrame{
    private JPanel mainPanel;
    private JComboBox jComboBox1;
    private JTable jTable1;
    private JButton bubbleButton;
    private JButton insertionButton;
    private JButton selectionButton;
    private JButton mergeButton;

    public Sortierfenster(String title) {
        /*
          Layout-Kleinigkeiten
         */
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [4][6],
                new String [] {
                        "Eingabe", "Ausgabe", "Aufwand 1 (...)", "Aufwand 2 (...)", "Tauschaufwand", "Eingabelänge"
                }
        ));

        //passe einzelne Spaltenbreiten an
        TableColumnModel columnModel = jTable1.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(250);
        this.setContentPane(mainPanel);
        this.pack();
        //ENDE Layout-Kleinigkeiten
        /*
          ActionListener für die drei Buttons
         */
        bubbleButton.addActionListener(e -> callbackButton(0, new BubbleSort()));
        insertionButton.addActionListener(e -> callbackButton(1, new InsertionSort()));
        selectionButton.addActionListener(e -> callbackButton(2, new SelectionSort()));
        mergeButton.addActionListener(e -> callbackButton(3, new MergeSort()));
    }

    public static void main (String[] args){
        JFrame meinFrame = new Sortierfenster("Sortierverfahren auswerten");
        meinFrame.setVisible(true);
    }

    public void callbackButton(int row, Algorithm sortieralgorithmus) {
        String eingabe = jComboBox1.getSelectedItem().toString();

        jTable1.setValueAt(eingabe, row, 0);

        SortingResult result = sortieralgorithmus.sort(eingabe.toCharArray());
        char[] ausgabe = result.getArray();

        String ausgabeString = new String(ausgabe); //konvertiert charArray zum String zurück
        System.out.println(ausgabe);
        jTable1.setValueAt( ausgabeString,                    row, 1);
        jTable1.setValueAt( result.getSchleifendurchlaeufe(), row, 2);
        jTable1.setValueAt( result.getVergleiche(),           row, 3);
        jTable1.setValueAt( result.getTauschaufwand(),        row, 4);
        jTable1.setValueAt( eingabe.length(),                 row, 5);
    }

}
