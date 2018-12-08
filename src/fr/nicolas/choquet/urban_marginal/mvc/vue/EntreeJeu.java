package fr.nicolas.choquet.urban_marginal.mvc.vue;



import fr.nicolas.choquet.urban_marginal.mvc.controller.Controle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntreeJeu extends JFrame {

    private JPanel contentPane;
    private Controle control;
    private JTextPane ipAddress;

    /**
     * click sur start button pour lancer le serveur
     */
    private void btnStart_clic()
    {
        this.control.evenementVue(this, "serveur");
    }
    /**
     * pour quitter la fenêtre
     */
    private void btnExit_clic()
    {
        System.exit(0);
    }

    /**
     * pour se connecter au serveur
     */
    private void btnConnect_clic()
    {
        this.control.evenementVue(this, ipAddress.getText());
    }

    public JTextPane getIpAddress() {
        return ipAddress;
    }

    public EntreeJeu(Controle controle) {
        setTitle("Urban Marginal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("");
        label.setBounds(39, 36, 0, 0);
        contentPane.add(label);

        JLabel lblStartNewServer = new JLabel("Start new server");
        lblStartNewServer.setBounds(12, 13, 129, 31);
        contentPane.add(lblStartNewServer);

        JLabel lblConnectAnExisting = new JLabel("Connect an existing server");
        lblConnectAnExisting.setBounds(22, 65, 173, 31);
        contentPane.add(lblConnectAnExisting);

        JLabel lblIpServer = new JLabel("IP Server :");
        lblIpServer.setBounds(56, 140, 96, 31);
        contentPane.add(lblIpServer);

        ipAddress = new JTextPane();
        ipAddress.setText("127.0.0.1");
        ipAddress.setBounds(146, 154, 96, 17);
        contentPane.add(ipAddress);

        JButton btnStart = new JButton("Start");
        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                btnStart_clic();
            }
        });
        btnStart.setBounds(271, 36, 97, 25);
        contentPane.add(btnStart);

        JButton btnConnect = new JButton("Connect");
        btnConnect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnConnect_clic();
            }
        });
        btnConnect.setBounds(271, 97, 97, 25);
        contentPane.add(btnConnect);

        JButton btnExit = new JButton("Exit");
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnExit_clic();
            }
        });
        btnExit.setBounds(271, 143, 97, 25);
        contentPane.add(btnExit);
        control = controle;
    }
}
