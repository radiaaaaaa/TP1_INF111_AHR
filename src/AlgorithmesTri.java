import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AlgorithmesTri {

    private int[] tableau;
    private int debut;
    private int fin;
    private JPanel panelVisualisation;
    private int currentIndex = -1;  // Variable pour suivre l'indice actuel

    public AlgorithmesTri(int[] tableau, int debut, int fin, JPanel panelVisualisation) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
        this.panelVisualisation = panelVisualisation;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    private void setCurrentIndex(int index) {
        this.currentIndex = index;
        miseAJour();
    }

    public void triBulles() {
        for (int i = debut; i <= fin; i++) {
            for (int j = debut; j < fin - i + debut; j++) {
                setCurrentIndex(j);
                if (tableau[j] > tableau[j + 1]) {
                    echanger(j, j + 1);
                }
            }
            miseAJour();
        }
        setCurrentIndex(-1);  // Réinitialiser après le tri
    }

    public void triSelection() {
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
        setCurrentIndex(-1);  // Réinitialiser après le tri
    }

    public void triInsertion() {
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
        setCurrentIndex(-1);  // Réinitialiser après le tri
    }

    public void triCocktail() {
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
        setCurrentIndex(-1);  // Réinitialiser après le tri
    }

    public void triShell() {
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
        setCurrentIndex(-1);  // Réinitialiser après le tri
    }

    private void echanger(int i, int j) {
        int temp = tableau[i];
        tableau[i] = tableau[j];
        tableau[j] = temp;
        miseAJour();
    }

    private void miseAJour() {
        // Utiliser SwingUtilities.invokeLater pour s'assurer que la mise à jour se fait sur l'EDT
        SwingUtilities.invokeLater(panelVisualisation::repaint);
        try {
            Thread.sleep(50); // Attendre pour visualisation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
