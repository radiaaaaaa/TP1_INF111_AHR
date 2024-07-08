import javax.swing.*;
import java.awt.*;

public class SousCadre2 extends JPanel {
    private int[] tableau;
    private int debut;
    private int fin;
    private TriAlgorithm triAlgorithm;

    public SousCadre2() {
        // Initialiser l'interface utilisateur
        initUI();
    }

    private void initUI() {
        setPreferredSize(new Dimension(800, 400)); // Ajuster la hauteur du sous-cadre

        // Définir la couleur de fond du panneau en utilisant la référence RGB fournie
        setBackground(new Color(137, 207, 240)); // Code couleur RGB pour bleu ciel
    }

    public void setTableau(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
        repaint();
    }

    public void setTriAlgorithm(TriAlgorithm triAlgorithm) {
        this.triAlgorithm = triAlgorithm;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tableau != null) {
            int width = getWidth();
            int height = getHeight();
            int cadreWidth = width / (fin - debut + 1); // Ajuster la largeur des cadres en fonction de l'intervalle
            int cadreHeight = height / 10; // Ajuster la hauteur des cadres

            for (int i = debut; i <= fin; i++) {
                int x = (i - debut) * cadreWidth;
                int y = 0; // Placer les cadres en haut

                // Surbrillance jaune pour l'indice actuel
                if (triAlgorithm != null && i == triAlgorithm.getCurrentIndex()) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x, y, cadreWidth, cadreHeight);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cadreWidth, cadreHeight);

                // Afficher les valeurs dans les cadres
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(tableau[i]), x + cadreWidth / 2 - 10, y + cadreHeight / 2 + 5);
            }
        }
    }
}
