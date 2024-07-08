import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TriCocktail implements TriAlgorithm {
    private int[] tableau;
    private int debut;
    private int fin;
    private JPanel panelVisualisation;
    private int currentIndex = -1;

    public TriCocktail(JPanel panelVisualisation) {
        this.panelVisualisation = panelVisualisation;
    }

    @Override
    public void sort(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
        boolean echange;
        do {
            echange = false;
            for (int i = debut; i < fin; i++) {
                setCurrentIndex(i);
                if (tableau[i] > tableau[i + 1]) {
                    echanger(i, i + 1);
                    echange = true;
                }
            }
            miseAJour();
            if (!echange) {
                break;
            }
            echange = false;
            for (int i = fin - 1; i > debut; i--) {
                setCurrentIndex(i);
                if (tableau[i - 1] > tableau[i]) {
                    echanger(i - 1, i);
                    echange = true;
                }
            }
            miseAJour();
        } while (echange);
        setCurrentIndex(-1);
    }

    @Override
    public int getCurrentIndex() {
        return currentIndex;
    }

    private void setCurrentIndex(int index) {
        this.currentIndex = index;
        miseAJour();
    }

    private void echanger(int i, int j) {
        int temp = tableau[i];
        tableau[i] = tableau[j];
        tableau[j] = temp;
        miseAJour();
    }

    private void miseAJour() {
        SwingUtilities.invokeLater(panelVisualisation::repaint);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
