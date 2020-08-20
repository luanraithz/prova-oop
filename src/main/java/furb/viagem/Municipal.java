// Luan Raithz Machado
package furb.viagem;

import furb.passageiro.Passageiro;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Municipal extends Viagem implements Serializable {
    public int LIMIT = 55;

    public Municipal(String placaOnibus, String nomeMotorista, LocalDate dataViagem, LocalTime horaViagem) {
        super(placaOnibus, nomeMotorista, dataViagem, horaViagem);
    }

    public void addPassageiro(Passageiro passageiro) throws LimiteAtingidoException {
        if (getPassageiros().size() >= getLimit()) {
            throw new LimiteAtingidoException(getLimit());
        } else {
            super.addPassageiro(passageiro);
        }
    }

    public int getLimit() {
        return LIMIT;
    }

    @Override
    public String toCSVRow() {
        StringBuilder builder = new StringBuilder();
        builder.append("Municipal");
        builder.append(',');
        builder.append(getDataViagem().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        builder.append(',');
        builder.append(getHoraViagem().format(DateTimeFormatter.ofPattern("H:m")));
        builder.append(',');
        builder.append(getPlacaOnibus());
        builder.append(',');
        builder.append(getNomeMotorista());
        return builder.toString();
    }

}
