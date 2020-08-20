// Luan Raithz Machado
package furb.viagem;

import furb.DateUtils;
import furb.passageiro.Passageiro;

import java.time.LocalDate;
import java.time.LocalTime;

public class Municipal extends Viagem {
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
        builder.append(getDataViagem().format(DateUtils.DATA_FORMAT));
        builder.append(',');
        builder.append(getHoraViagem().format(DateUtils.HORA_FORMAT));
        builder.append(',');
        builder.append(getPlacaOnibus());
        builder.append(',');
        builder.append(getNomeMotorista());
        builder.append('\n');
        return builder.toString();
    }

}
