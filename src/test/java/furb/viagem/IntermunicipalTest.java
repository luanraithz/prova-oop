package furb.viagem;// Luan Raithz Machado
import furb.passageiro.Estudante;
import furb.passageiro.Idoso;
import furb.passageiro.Passageiro;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(JUnit4.class)
public class IntermunicipalTest extends TestCase {

    @Test
    public void getValorTotal() throws Exception {
        Intermunicipal viagem = new Intermunicipal("Placa", "Marcel", LocalDate.now(), LocalTime.MIDNIGHT);
        Estudante estudante = new Estudante("João da escola", "120312", 14, "Escola");
        viagem.addPassageiro(estudante);
        Idoso idoso = new Idoso("Idoso massa", "120312", 61, "RG");
        viagem.addPassageiro(idoso);
        Passageiro passageiro = new Passageiro("Passageiro comum", "120312", 70);
        viagem.addPassageiro(passageiro);

        float expected = idoso.getTarifa() + passageiro.getTarifa() + estudante.getTarifa();
        Assert.assertEquals(expected + (3 * 3.15), viagem.getValorTotal(), 0.1);
    }

    @Test
    public void exceptionOnMaxSizeReached() throws Exception {
        Intermunicipal viagem = new Intermunicipal("Placa", "Marcel", LocalDate.now(), LocalTime.MIDNIGHT);
        for (int i = 0; i < 20; i++) {
            viagem.addPassageiro(new Estudante("João da escola", "120312", 14, "Escola"));
        }
        assertEquals(20, viagem.getPassageiros().size());
        try {
            viagem.addPassageiro(new Estudante("João q da erro", "120312", 14, "Escola"));
            fail();
        } catch (Exception ignored) { }
    }
}