import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TriSelection implements TriAlgorithm {
    private int[] tableau;
    private int debut;
    private int fin;
    private JPanel panelVisualisation;
    private int currentIndex = -1;

    public TriSelection(JPanel panelVisualisation) {
        this.panelVisualisation = panelVisualisation;
    }

    @Override
    public void sort(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
        for (int i = debut; i <= fin; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= fin; j++) {
                setCurrentIndex(j);
                if (tableau[j] < tableau[minIndex]) {
                    minIndex = j;
                }
            }
            echanger(i, minIndex);
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
