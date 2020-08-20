// Luan Raithz Machado
package furb.viagem;

import furb.passageiro.Passageiro;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Intermunicipal extends Viagem implements Serializable {
    public static int LIMIT = 20;

    public int getLimit() {
        return LIMIT;
    }

    @Override
    public String toCSVRow() {
        StringBuilder builder = new StringBuilder();
        builder.append("Intermunicipal");
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

    public Intermunicipal(String placaOnibus, String nomeMotorista, LocalDate dataViagem, LocalTime horaViagem) {
        super(placaOnibus, nomeMotorista, dataViagem, horaViagem);
    }

    public void addPassageiro(Passageiro passageiro) throws LimiteAtingidoException {
        if (getPassageiros().size() >= getLimit()) {
            throw new LimiteAtingidoException(getLimit());
        } else {
            super.addPassageiro(passageiro);
        }
    }

    public float getValorTotal() {
        float fee = getPassageiros().size() * 3.15f;
        return super.getValorTotal() + fee;
    }
}
