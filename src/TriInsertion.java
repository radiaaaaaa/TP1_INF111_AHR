import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TriInsertion implements TriAlgorithm {
    private int[] tableau;
    private int debut;
    private int fin;
    private JPanel panelVisualisation;
    private int currentIndex = -1;

    public TriInsertion(JPanel panelVisualisation) {
        this.panelVisualisation = panelVisualisation;
    }

    @Override
    public void sort(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
        for (int i = debut + 1; i <= fin; i++) {
            int key = tableau[i];
            int j = i - 1;
            while (j >= debut && tableau[j] > key) {
                setCurrentIndex(j);
                tableau[j + 1] = tableau[j];
                j--;
                miseAJour();
            }
            tableau[j + 1] = key;
            miseAJour();
        }
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

    private void miseAJour() {
        SwingUtilities.invokeLater(panelVisualisation::repaint);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
