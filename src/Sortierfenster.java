import com.curryp0mmes.sortingalgorithms.algorithms.*;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sortierfenster extends JFrame{
    private JPanel mainPanel;
    private JComboBox jComboBox1;
    private JTable jTable1;
    private JScrollPane jScrollPane1;
    private JButton bubbleButton;
    private JButton insertionButton;
    private JButton selectionButton;


    char[] eingabe;
    char[] ausgabe;


    public Sortierfenster(String title) {
        /**
         * Layout-Kleinigkeiten
         */
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Eingabe", "Ausgabe", "Aufwand 1 (...)", "Aufwand 2 (...)", "Tauschaufwand", "Eingabelänge"
                }
        ));
        jScrollPane1.setViewportView(jTable1);
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
                bubbleAction();
            }
        });
        insertionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertionAction();
            }
        });
        selectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionAction();
            }
        });
    }

    public static void main (String[] args){
        JFrame meinFrame = new Sortierfenster("Sortierverfahren auswerten");
        meinFrame.setVisible(true);
    }

    /**
     * Liest die Eingabe ein, gibt sie in die Tabelle und
     * sortiert sie anschließend im Sortierer sorter mit der zugehörigen Methode.
     * Dort wird auch der jeweilige Aufwand gezählt.
     * Anschließend wird die zurückgegebene sortierte Eingabe als Ausgabe
     * zusammen mit dem Aufwand in der Tabelle ergänzt.
     */
    public void bubbleAction(){
        eingabe = jComboBox1.getSelectedItem().toString().toCharArray();

        String a = new String(eingabe);
        jTable1.setValueAt(a, 0, 0);

        Algorithm sorter = new BubbleSort();

        SortingResult result = sorter.sort(eingabe);
        ausgabe = result.getArray();

        String b = new String(ausgabe); //konvertiert charArray zum String zurück
        System.out.println(ausgabe);
        jTable1.setValueAt(b, 0, 1);

        jTable1.setValueAt(result.getSchleifendurchläufe(), 0, 2);
        jTable1.setValueAt(result.getVergleiche(), 0, 3);
        jTable1.setValueAt(result.getTauschaufwand(), 0, 4);
        jTable1.setValueAt(a.length(), 0, 5);
    }

    public void insertionAction(){
        eingabe = jComboBox1.getSelectedItem().toString().toCharArray();

        String a = new String(eingabe);
        jTable1.setValueAt(a, 1, 0);

        Algorithm sorter = new InsertionSort();

        SortingResult result = sorter.sort(eingabe);
        ausgabe = result.getArray();

        String b = new String(ausgabe); //konvertiert charArray zum String zurück
        System.out.println(ausgabe);
        jTable1.setValueAt(b, 1, 1);

        jTable1.setValueAt(result.getSchleifendurchläufe(), 1, 2);
        jTable1.setValueAt(result.getVergleiche(), 1, 3);
        jTable1.setValueAt(result.getTauschaufwand(), 1, 4);
        jTable1.setValueAt(a.length(), 1, 5);
    }

    public void selectionAction(){
        eingabe = jComboBox1.getSelectedItem().toString().toCharArray();

        String a = new String(eingabe);
        jTable1.setValueAt(a, 2, 0);

        Algorithm sorter = new SelectionSort();

        SortingResult result = sorter.sort(eingabe);
        ausgabe = result.getArray();

        String b = new String(ausgabe); //konvertiert charArray zum String zurück
        System.out.println(ausgabe);
        jTable1.setValueAt(b, 2, 1);

        jTable1.setValueAt(result.getSchleifendurchläufe(), 2, 2);
        jTable1.setValueAt(result.getVergleiche(), 2, 3);
        jTable1.setValueAt(result.getTauschaufwand(), 2, 4);
        jTable1.setValueAt(a.length(), 2, 5);
    }
}
