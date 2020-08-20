// Luan Raithz Machado
package furb.viagem;


import com.sun.org.apache.xpath.internal.objects.XString;
import furb.passageiro.Passageiro;

import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Viagem implements Serializable {
    private String placaOnibus;
    private String nomeMotorista;
    private LocalDate dataViagem;

    private LocalTime horaViagem;
    private List<Passageiro> passageiros = new ArrayList<>();

    protected Viagem() {}

    public Viagem(String placaOnibus, String nomeMotorista, LocalDate dataViagem, LocalTime horaViagem) {
        this.placaOnibus = placaOnibus;
        this.nomeMotorista = nomeMotorista;
        this.dataViagem = dataViagem;
        this.horaViagem = horaViagem;
    }

    public void addPassageiro(Passageiro passageiro) throws LimiteAtingidoException {
        passageiros.add(passageiro);
    }

    public float getValorTotal()
    {
        return passageiros.stream()
                .map(p -> p.getTarifa())
                .reduce(0f, (total, current) -> current + total);
    }

    public void gerarArquivoCSV() {
        String header = this.toCSVRow();
        File csvOutputFile = new File("export-viagem.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println(header);
            this.passageiros.stream()
                    .map(Passageiro::toCSVRow)
                    .forEach(pw::println);
            JOptionPane.showMessageDialog(null, "Arquivo gerado em " + csvOutputFile.getAbsolutePath());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public boolean isViagemProcurada(LocalDate data, LocalTime time, String placa) {
        return this.dataViagem.compareTo(data) == 0 &&
                this.horaViagem.compareTo(time) == 0 &&
                this.placaOnibus.equalsIgnoreCase(placa);
    }

    public List<Passageiro> getPassageiros() {
        return this.passageiros;
    }

    public abstract int getLimit();
    public abstract String toCSVRow();

    public String getNomeMotorista() {
        return this.nomeMotorista;
    }

    public String getPlacaOnibus() {
        return placaOnibus;
    }

    public LocalDate getDataViagem() {
        return dataViagem;
    }

    public LocalTime getHoraViagem() {
        return horaViagem;
    }

}
