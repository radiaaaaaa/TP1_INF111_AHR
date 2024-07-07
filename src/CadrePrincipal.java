import javax.swing.*;
import java.awt.*;

public class CadrePrincipal extends JFrame {

    private SousCadre2 sousCadre2;

    public CadrePrincipal() {
        // Initialiser l'interface utilisateur
        initUI();
    }

    private void initUI() {
        setTitle("Cadre Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Définir la couleur de fond du cadre principal en utilisant la référence RGB fournie
        getContentPane().setBackground(new Color(224, 198, 250)); // Code couleur RGB

        // Créer une instance de SousCadre2
        sousCadre2 = new SousCadre2();
        // Créer une instance de SousCadre1 en passant la référence de sousCadre2 pour l'accès au JPanel
        SousCadre1 sousCadre1 = new SousCadre1(sousCadre2);

        // Ajouter les sous-cadres au cadre principal
        add(sousCadre1, BorderLayout.NORTH);
        add(sousCadre2, BorderLayout.CENTER);
    }
}
