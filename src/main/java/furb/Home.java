// Luan Raithz Machado
package furb;

import furb.viagem.Empresa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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

        salvarButton.addActionListener(x -> {
            try {
                FileOutputStream fileOut = new FileOutputStream("save");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                Empresa e = empresa;
                objectOut.writeObject(empresa);
                objectOut.close();
                fileOut.close();
                JOptionPane.showMessageDialog(null, "Dados salvos");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}