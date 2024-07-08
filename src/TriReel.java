public class TriReel implements Runnable {
    private int[] tableau;
    private int debut;
    private int fin;
    private String algorithme;
    private SousCadre2 sousCadre2;

    public TriReel(int[] tableau, int debut, int fin, String algorithme, SousCadre2 sousCadre2) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
        this.algorithme = algorithme;
        this.sousCadre2 = sousCadre2;
    }

    @Override
    public void run() {
        TriAlgorithm triAlgorithm = null;
        switch (algorithme) {
            case "Bubble Sort":
                triAlgorithm = new TriBulles(sousCadre2);
                break;
            case "Selection Sort":
                triAlgorithm = new TriSelection(sousCadre2);
                break;
            case "Insertion Sort":
                triAlgorithm = new TriInsertion(sousCadre2);
                break;
            case "Cocktail Shaker Sort":
                triAlgorithm = new TriCocktail(sousCadre2);
                break;
            case "Shell Sort":
                triAlgorithm = new TriShell(sousCadre2);
                break;
        }

        sousCadre2.setTriAlgorithm(triAlgorithm);
        sousCadre2.setTableau(tableau, debut, fin);

        if (triAlgorithm != null) {
            triAlgorithm.sort(tableau, debut, fin);
        }
    }
}
