// Luan Raithz Machado
package furb.passageiro;

public class Estudante extends Passageiro {
    private String escola;

    public Estudante(String nome, String telefone, int idade, String escola)
    {
        super(nome, telefone, idade);
        this.escola = escola;
    }

    public float getTarifa() {
        return super.getTarifa() * 0.5f;
    }

    @Override
    public String toString() {
        return "Estudante " +
                "nome: " + getNome() + ", " +
                "telefone: " + getTelefone() + ", " +
                "escola: " + escola + ", " +
                "idade: " + getIdade() + " " +
                "";
    }

    public String toCSVRow() {
        StringBuilder content = new StringBuilder();
        content.append("E");
        content.append(',');
        content.append(getNome());
        content.append(',');
        content.append(getTelefone());
        content.append(',');
        content.append(getIdade());
        content.append(',');
        content.append(escola);
        return content.toString();
    }
}
