package fr.nicolas.choquet.urban_marginal.mvc.vue;

import fr.nicolas.choquet.urban_marginal.mvc.controller.Controle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Arene extends JFrame {
    private JPanel contentPane;
    public Arene(Controle controle) {
        setTitle("Arena");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }
}
