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
        AlgorithmesTri tri = new AlgorithmesTri(tableau, debut, fin, sousCadre2);
        sousCadre2.setAlgorithmesTri(tri);

        // Mettre à jour le tableau dans SousCadre2 avant de lancer le tri
        sousCadre2.setTableau(tableau, debut, fin);

        switch (algorithme) {
            case "Bubble Sort":
                tri.triBulles();
                break;
            case "Selection Sort":
                tri.triSelection();
                break;
            case "Insertion Sort":
                tri.triInsertion();
                break;
            case "Cocktail Shaker Sort":
                tri.triCocktail();
                break;
            case "Shell Sort":
                tri.triShell();
                break;
        }
    }
}
