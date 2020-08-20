package furb.viagem;

import furb.passageiro.Estudante;
import furb.passageiro.Idoso;
import furb.passageiro.Passageiro;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class EmpresaTest extends TestCase {

    @Test
    public void testGetPassageirosMaisVelhos() throws Exception {
        Empresa empresa = new Empresa();
        Municipal municipal = new Municipal("123-ASDASD", "João", LocalDate.now(), LocalTime.MIDNIGHT);
        Intermunicipal intermunicipal = new Intermunicipal("123-BLA", "Juninho", LocalDate.now(), LocalTime.NOON);
        empresa.addViagem(municipal);
        empresa.addViagem(intermunicipal);
        municipal.addPassageiro(new Passageiro("nome 1", "102", 10));
        municipal.addPassageiro(new Estudante("nome 2", "102", 2,"FURB"));
        municipal.addPassageiro(new Idoso("nome 3", "102", 60, "RG-massa"));
        intermunicipal.addPassageiro(new Passageiro("Ap", "102", 32));
        intermunicipal.addPassageiro(new Estudante("Bp", "102", 32,"FURB"));
        intermunicipal.addPassageiro(new Idoso("nome 6", "123", 60, "RG-massa1"));

        List<String> nomes = empresa.getPassageirosMaisVelhos().stream()
                .map(Passageiro::getNome)
                .collect(Collectors.toList());

        List<String> expected = Arrays.asList("nome 3", "nome 6", "Ap", "Bp", "nome 1", "nome 2");
        Assert.assertEquals(expected, nomes);
    }

    @Test
    public void testProcuraViagem() {
        Empresa empresa = new Empresa();
        empresa.addViagem(new Municipal("123-ASDASD", "João", LocalDate.now(), LocalTime.MIDNIGHT));
        empresa.addViagem(new Intermunicipal("123-BLA", "Juninho", LocalDate.now(), LocalTime.NOON));
        empresa.addViagem(new Intermunicipal("123-BLA1", "ASK", LocalDate.of(1990, 10, 10), LocalTime.NOON));
        empresa.addViagem(new Intermunicipal("123-BLA3", "SKS", LocalDate.of(2000, 10, 12), LocalTime.NOON));
        empresa.addViagem(new Intermunicipal("123-BLA4", "KSD", LocalDate.of(2001, 12, 23), LocalTime.of(10, 10)));

        Optional<Viagem> encontrada = empresa.procuraViagem(
                LocalDate.of(2001, 12, 23),
                LocalTime.of(10, 10),
                "123-BLA4");
        Assert.assertTrue(encontrada.isPresent());
        Assert.assertEquals("KSD", encontrada.get().getNomeMotorista());

        encontrada = empresa.procuraViagem(
                LocalDate.of(2001, 12, 23),
                LocalTime.of(10, 10),
                "123-BLA4293123");

        Assert.assertFalse(encontrada.isPresent());

    }

}