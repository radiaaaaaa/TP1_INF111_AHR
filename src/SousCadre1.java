import javax.swing.*;
import java.awt.*;

public class SousCadre1 extends JPanel {
    private JComboBox<String> comboBoxAlgorithmes;
    private JSpinner spinnerDebut;
    private JSpinner spinnerFin;
    private JButton boutonTrier;
    private JButton boutonReinitialiser;
    private SousCadre2 sousCadre2;
    private int[] tableau;
    private static final int TAILLE_TABLEAU = 15;

    public SousCadre1(SousCadre2 sousCadre2) {
        this.sousCadre2 = sousCadre2;
        // Initialiser l'interface utilisateur
        initUI();
        tableau = genererTableau();
        sousCadre2.setTableau(tableau, 0, TAILLE_TABLEAU - 1);
    }

    private void initUI() {
        setPreferredSize(new Dimension(800, 100)); // Ajuster la hauteur du sous-cadre

        setLayout(new GridLayout(1, 5, 10, 10)); // 1 ligne, 5 colonnes, espace de 10 pixels

        // Définir la couleur de fond du panneau en rose bébé
        setBackground(new Color(251, 204, 231)); // Code couleur RGB pour un rose bébé

        // Composant pour sélectionner l'algorithme de tri
        String[] algorithmes = {"Tri à Bulles", "Tri par Séléction", "Tri par Insertion", "Tri Cocktail", "Tri de Shell"};
        comboBoxAlgorithmes = new JComboBox<>(algorithmes);
        comboBoxAlgorithmes.setPreferredSize(new Dimension(150, 30));
        add(comboBoxAlgorithmes);

        // Spinner pour définir les indices de début
        SpinnerModel modelDebut = new SpinnerNumberModel(0, 0, 14, 1);
        spinnerDebut = new JSpinner(modelDebut);
        add(spinnerDebut);

        // Spinner pour définir les indices de fin
        SpinnerModel modelFin = new SpinnerNumberModel(14, 0, 14, 1);
        spinnerFin = new JSpinner(modelFin);
        add(spinnerFin);

        // Bouton pour lancer le tri
        boutonTrier = new JButton("Trier");
        add(boutonTrier);

        // Bouton pour réinitialiser le tableau
        boutonReinitialiser = new JButton("Réinitialiser");
        add(boutonReinitialiser);

        // Action listener pour le bouton Trier
        boutonTrier.addActionListener(e -> lancerTri());

        // Action listener pour le bouton Réinitialiser
        boutonReinitialiser.addActionListener(e -> {
            tableau = genererTableau();
            int debut = (int) spinnerDebut.getValue();
            int fin = (int) spinnerFin.getValue();
            sousCadre2.setTableau(tableau, debut, fin);
            sousCadre2.repaint();
        });
    }

    private void lancerTri() {
        int debut = (int) spinnerDebut.getValue();
        int fin = (int) spinnerFin.getValue();
        String algorithme = (String) comboBoxAlgorithmes.getSelectedItem();

        TriReel triReel = new TriReel(tableau, debut, fin, algorithme, sousCadre2);
        Thread triThread = new Thread(triReel);
        triThread.start();
    }

    private int[] genererTableau() {
        int[] tableau = new int[TAILLE_TABLEAU];
        for (int i = 0; i < TAILLE_TABLEAU; i++) {
            tableau[i] = (int) (Math.random() * 15); // Générer des valeurs entre 0 et 14
        }
        return tableau;
    }
}
