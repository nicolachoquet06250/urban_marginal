package fr.nicolas.choquet.urban_marginal.mvc.vue;

import fr.nicolas.choquet.urban_marginal.mvc.controller.Controle;
import fr.nicolas.choquet.urban_marginal.mvc.controller.Global;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ChoixJoueur extends JFrame implements Global {

    private JPanel contentPane;
    private JTextField txtPseudo;
    private JLabel lblFond;
    private JLabel lblPrecedent;
    private JLabel lblSuivant;
    private JLabel lblGo;
    private JLabel lblPersonnage;


    /**
     * Create the frame.
     */
    public ChoixJoueur(Controle controle) {
        init_components();
    }

    private void init_components() {
        setTitle("Choice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 415, 325);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setLayout(null);


        lblPrecedent = new JLabel("");
        lblPrecedent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                lblPrecedent_clic();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                souris_doigt();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                souris_normale();
            }
        });
        lblPrecedent.setBounds(51, 139, 72, 57);
        contentPane.add(lblPrecedent);

        lblSuivant = new JLabel("");
        lblSuivant.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblSuivant_clic();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                souris_doigt();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                souris_normale();
            }
        });
        lblSuivant.setBounds(295, 139, 45, 48);
        contentPane.add(lblSuivant);

        lblGo = new JLabel("");
        lblGo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblGo_clic();
            }
            @Override
            public void mouseEntered(MouseEvent arg0) {
                souris_doigt();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                souris_normale();
            }
        });
        lblGo.setBounds(305, 194, 79, 71);
        contentPane.add(lblGo);

        txtPseudo = new JTextField();
        txtPseudo.setColumns(10);
        txtPseudo.setBounds(137, 243, 128, 22);
        contentPane.add(txtPseudo);

        lblPersonnage = new JLabel("");
        lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
        lblPersonnage.setBounds(137, 119, 128, 111);
        contentPane.add(lblPersonnage);


        lblFond = new JLabel();
        lblFond.setBounds(0, 0, 400, 275);

        lblFond.setIcon(new ImageIcon(FONDCHOIX));
        contentPane.add(lblFond);

        txtPseudo.requestFocus();
    }

    protected void lblPrecedent_clic() {
        System.out.println("Clique sur précédent !");
    }

    protected void lblSuivant_clic() {
        System.out.println("Clique sur suivant !");
    }

    protected void lblGo_clic() {
        System.out.println("Clique sur GO !");
    }

    private void souris_normale() {
        contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void souris_doigt() {
        contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
