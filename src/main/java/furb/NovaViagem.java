package furb;

import furb.viagem.Empresa;
import furb.viagem.Intermunicipal;
import furb.viagem.Municipal;
import furb.viagem.Viagem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class NovaViagem extends JFrame {
    private JPanel panel;
    private JButton criarViagemButton;
    private JTextField placa;
    private JTextField nome;
    private JRadioButton municipalRadioButton;
    private JRadioButton intermunicipalRadioButton;
    private JFormattedTextField dataTextField;
    private JFormattedTextField horaTextField;
    private ButtonGroup radioGroup;
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateFormat horaFormat = new SimpleDateFormat("hh:mm");

    public NovaViagem(Empresa empresa) {
        radioGroup = new ButtonGroup();
        municipalRadioButton.setSelected(true);
        radioGroup.add(intermunicipalRadioButton);
        radioGroup.add(municipalRadioButton);

        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setPreferredSize(new Dimension(640, 480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();

        criarViagemButton.addActionListener(x -> {
            Viagem viagem;
            LocalDate date = LocalDate.parse(dataTextField.getText(), DateUtils.DATA_FORMAT);
            LocalTime hora = LocalTime.parse(horaTextField.getText(), DateUtils.HORA_FORMAT);
            if (municipalRadioButton.isSelected()) {
                viagem = new Municipal(placa.getText(), nome.getText(), date, hora);
            } else {
                viagem = new Intermunicipal(placa.getText(), nome.getText(), date, hora);
            }
            AddPassageiros addPassageiros = new AddPassageiros(empresa, viagem);
            addPassageiros.setLocationRelativeTo(null);
            addPassageiros.setVisible(true);
            this.dispose();
        });

    }

    private void createUIComponents() {
        dataTextField = new JFormattedTextField(dateFormat);
        horaTextField = new JFormattedTextField(horaFormat);
        DateUtils.DATA_MASK.install(dataTextField);
        DateUtils.HORA_MASK.install(horaTextField);
    }
}
