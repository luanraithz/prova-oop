package furb;

import furb.viagem.Empresa;
import furb.viagem.Viagem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class ProcuraViagem extends JFrame {
    private JTextField placaTextfield;
    private JButton procurarButton;
    private JButton gerarCSVButton;
    private JButton voltarButton;
    private JPanel panel;
    private JPanel dadosViagem;
    private JLabel valorTotal;
    private JLabel valorPassageiros;
    private JLabel valorOciosidade;
    private JFormattedTextField dataTextField;
    private JFormattedTextField horaTextField;
    private Viagem viagem;

    public ProcuraViagem(Empresa empresa) {
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setPreferredSize(new Dimension(640, 480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        dadosViagem.setVisible(false);

        procurarButton.addActionListener(x -> {
            LocalDate date = LocalDate.parse(dataTextField.getText(), DateUtils.DATA_FORMAT);
            LocalTime hora = LocalTime.parse(horaTextField.getText(), DateUtils.HORA_FORMAT);
            Optional<Viagem> viagemEncontrada = empresa.procuraViagem(date, hora, placaTextfield.getText());
            if (viagemEncontrada.isPresent()) {
                this.viagem = viagemEncontrada.get();
                valorTotal.setText(String.valueOf(viagem.getValorTotal()));
                int passageiros = viagem.getPassageiros().size();
                valorOciosidade.setText(String.valueOf(viagem.getLimit() - passageiros));
                valorPassageiros.setText(String.valueOf(passageiros));
                dadosViagem.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Viagem não encontrada");
            }
        });

        voltarButton.addActionListener(x -> {
            Home home = new Home(empresa);
            home.setLocationRelativeTo(null);
            home.setVisible(true);
            this.dispose();
        });

        gerarCSVButton.addActionListener(x -> {
            viagem.gerarArquivoCSV();
        });
    }

    private void createUIComponents() {
        dataTextField = new JFormattedTextField(DateUtils.DATA_FORMAT);
        horaTextField = new JFormattedTextField(DateUtils.HORA_FORMAT);
        DateUtils.DATA_MASK.install(dataTextField);
        DateUtils.HORA_MASK.install(horaTextField);
    }
}
