import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TriShell implements TriAlgorithm {
    private int[] tableau;
    private int debut;
    private int fin;
    private JPanel panelVisualisation;
    private int currentIndex = -1;

    public TriShell(JPanel panelVisualisation) {
        this.panelVisualisation = panelVisualisation;
    }

    @Override
    public void sort(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
        int n = fin - debut + 1;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap + debut; i <= fin; i++) {
                int temp = tableau[i];
                int j;
                for (j = i; j >= gap + debut && tableau[j - gap] > temp; j -= gap) {
                    setCurrentIndex(j);
                    tableau[j] = tableau[j - gap];
                    miseAJour();
                }
                tableau[j] = temp;
                miseAJour();
            }
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
