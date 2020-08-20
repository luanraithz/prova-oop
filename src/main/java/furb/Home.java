package furb;

import furb.passageiro.Passageiro;
import furb.viagem.Empresa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Home extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JButton novaViagemButton;
    private JButton procurarViagemButton;
    private JButton salvarButton;
    private JList passageiros;
    private JButton listarPassageiros;
    private JButton consultarViagemButton;
    private final Empresa empresa;

    public Home(Empresa empresa){
        this.empresa = empresa == null ? new Empresa(): empresa;
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        passageiros.setListData(empresa.getPassageirosMaisVelhos().toArray());
        panel.setPreferredSize(new Dimension(640, 480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        novaViagemButton.addActionListener(x -> {
            NovaViagem novaViagem = new NovaViagem(this.empresa);
            novaViagem.setLocationRelativeTo(null);
            novaViagem.setVisible(true);
            this.dispose();
        });

        procurarViagemButton.addActionListener(x -> {
            ProcuraViagem procuraViagem = new ProcuraViagem(this.empresa);
            procuraViagem.setLocationRelativeTo(null);
            procuraViagem.setVisible(true);
            this.dispose();

        });
    }
}