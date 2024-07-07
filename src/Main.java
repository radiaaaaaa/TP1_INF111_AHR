import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Utiliser SwingUtilities.invokeLater pour s'assurer que la création de l'interface utilisateur
        // se fait sur le thread de l'Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            // Créer une nouvelle instance de CadrePrincipal
            CadrePrincipal cadre = new CadrePrincipal();
            // Rendre le cadre visible
            cadre.setVisible(true);
        });
    }
}
