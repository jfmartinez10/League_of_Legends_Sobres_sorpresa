package JUEGO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//la clase interfaz hereda de la clase JFrame, obteniendo todas las propiedades y métodos de la clase. 
public class ventanaPrincipal extends JFrame{ 

    private JPanel panelCentral;
    private Baraja baraja;
    private JLabel contadorSobres;
    private int numSobres = 0;

    public ventanaPrincipal() {
        // Configuración de la ventana
        setTitle("Juego de Abrir Sobres");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo = new JLabel("¡Bienvenido al Juego de Abrir Sobres!");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        JButton botonAbrirSobre = new JButton("Abrir Sobre");
        contadorSobres = new JLabel("Sobres abiertos: " + numSobres);
        panelSuperior.add(titulo);
        panelSuperior.add(botonAbrirSobre);
        panelSuperior.add(contadorSobres);

        // Panel central (grid para las cartas)
        panelCentral = new JPanel(new GridLayout(3, 5, 10, 10)); // Ajusta filas y columnas
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Añadir paneles a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);

        // Crear baraja y añadir ActionListener al botón
        baraja = new Baraja();
        botonAbrirSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSobre();
            }
        });

        setVisible(true);
    }

    private void abrirSobre() {
        if (baraja.getCartas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No quedan cartas en la baraja!");
            return;
        }

        numSobres++;
        contadorSobres.setText("Sobres abiertos: " + numSobres);

        ArrayList<Carta> sobre = baraja.abrirSobre(5); // Abre 5 cartas
        for (Carta carta : sobre) {
            JLabel etiquetaCarta = new JLabel(carta.getNombre());
            etiquetaCarta.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde a la carta
            panelCentral.add(etiquetaCarta);
        }

        panelCentral.revalidate();
        panelCentral.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
