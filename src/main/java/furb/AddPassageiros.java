package furb;

import furb.passageiro.Estudante;
import furb.passageiro.Idoso;
import furb.passageiro.Passageiro;
import furb.viagem.Empresa;
import furb.viagem.LimiteAtingidoException;
import furb.viagem.Viagem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddPassageiros extends JFrame {
    private final Empresa empresa;
    private final Viagem viagem;
    private JPanel panel;
    private JTextField nome;
    private JTextField telefone;
    private JTextField idade;
    private JTextField rg;
    private JTextField escola;
    private JButton addPassageiro;
    private JButton addEstudante;
    private JButton addIdoso;
    private JButton salvarButton;
    private JList list1;

    public AddPassageiros(Empresa empresa, Viagem viagem) {
        this.viagem = viagem;
        this.empresa = empresa;
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setPreferredSize(new Dimension(640, 480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        addPassageiro.addActionListener(x -> {
            try {
                Passageiro passageiro = new Passageiro(nome.getText(), telefone.getText(), Integer.parseInt(idade.getText()));
                this.add(passageiro);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        });

        addEstudante.addActionListener(x -> {
            try {
                Estudante estudante = new Estudante(nome.getText(), telefone.getText(), Integer.parseInt(idade.getText()), escola.getText());
                this.add(estudante);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        });

        addIdoso.addActionListener(x -> {
            try {
                this.add(new Idoso(nome.getText(), telefone.getText(), Integer.parseInt(idade.getText()), rg.getText()));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        });

        salvarButton.addActionListener(x -> {
            empresa.addViagem(viagem);
            Home home = new Home(empresa);
            home.setLocationRelativeTo(null);
            home.setVisible(true);
            this.dispose();
        });

    }

    void clearFields() {
        nome.setText("");
        telefone.setText("");
        idade.setText("");
        rg.setText("");
        escola.setText("");
    }

    void add(Passageiro passageiro) {
        try {
            viagem.addPassageiro(passageiro);
            this.clearFields();
            list1.setListData(viagem.getPassageiros().toArray());
        } catch (LimiteAtingidoException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Limite de " + e.getLimit() + " passageiros atingidos");
        }
    }

}
