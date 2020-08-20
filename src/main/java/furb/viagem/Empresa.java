// Luan Raithz Machado
package furb.viagem;

import furb.passageiro.Passageiro;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Empresa implements Serializable {
    private List<Viagem> viagens = new ArrayList<>();

    public Empresa() {}
    public List<Passageiro> getPassageirosMaisVelhos()
    {
        return viagens.stream()
                .map(Viagem::getPassageiros)
                .flatMap(Collection::stream)
                .sorted(Comparator
                        .comparing(Passageiro::getIdade)
                        .reversed()
                        .thenComparing(Passageiro::getNome))
                .collect(Collectors.toList());
    }

    public void addViagem(Viagem viagem) {
        viagens.add(viagem);
    }

    public Optional<Viagem> procuraViagem(LocalDate data, LocalTime hora, String placa) {
        return this.viagens.stream()
                .filter(x -> x.isViagemProcurada(data, hora, placa))
                .findFirst();

    }
}
