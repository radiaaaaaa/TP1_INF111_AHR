import javax.swing.*;
import java.awt.*;

public class CadrePrincipal extends JFrame {
    public CadrePrincipal() {
        initUI();
    }

    private void initUI() {
        setTitle("Cadre Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Créer les sous-cadres
        SousCadre2 sousCadre2 = new SousCadre2();
        SousCadre1 sousCadre1 = new SousCadre1(sousCadre2);

        panelPrincipal.add(sousCadre1, BorderLayout.NORTH);
        panelPrincipal.add(sousCadre2, BorderLayout.CENTER);

        add(panelPrincipal);
        getContentPane().setBackground(new Color(224, 198, 250)); // Couleur de fond du cadre principal
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadrePrincipal cadre = new CadrePrincipal();
            cadre.setVisible(true);
        });
    }
}
