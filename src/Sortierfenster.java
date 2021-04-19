import com.curryp0mmes.sortingalgorithms.algorithms.*;
import com.curryp0mmes.sortingalgorithms.algorithms.template.Algorithm;
import com.curryp0mmes.sortingalgorithms.algorithms.template.SortingResult;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sortierfenster extends JFrame{
    private JPanel mainPanel;
    private JComboBox jComboBox1;
    private JTable jTable1;
    private JButton bubbleButton;
    private JButton insertionButton;
    private JButton selectionButton;
    private JButton mergeButton;


    char[] eingabe;
    char[] ausgabe;


    public Sortierfenster(String title) {
        /**
         * Layout-Kleinigkeiten
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
        /**
         * ENDE Layout-Kleinigkeiten
         */

        //generiere ein neues Objekt der Klasse Sorter, in der die Sortieralgos implementiert sein sollen
        //sorter = new Sortierer();


        /**
         * ActionListener für die drei Buttons
         */
        bubbleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callbackButton(0, new BubbleSort());
            }
        });
        insertionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callbackButton(1, new InsertionSort());
            }
        });
        selectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callbackButton(2, new SelectionSort());
            }
        });
        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callbackButton(3, new MergeSort());
            }
        });
    }

    public static void main (String[] args){
        JFrame meinFrame = new Sortierfenster("Sortierverfahren auswerten");
        meinFrame.setVisible(true);
    }

    public void callbackButton(int row, Algorithm sortieralgorithmus) {
        eingabe = jComboBox1.getSelectedItem().toString().toCharArray();

        String a = new String(eingabe);
        jTable1.setValueAt(a, row, 0);

        SortingResult result = sortieralgorithmus.sort(eingabe);
        ausgabe = result.getArray();

        String b = new String(ausgabe); //konvertiert charArray zum String zurück
        System.out.println(ausgabe);
        jTable1.setValueAt(b, row, 1);

        jTable1.setValueAt(result.getSchleifendurchlaeufe(), row, 2);
        jTable1.setValueAt(result.getVergleiche(), row, 3);
        jTable1.setValueAt(result.getTauschaufwand(), row, 4);
        jTable1.setValueAt(a.length(), row, 5);
    }

}
