// Luan Raithz Machado
package furb.passageiro;

public class Idoso extends Passageiro {
	private String rg; 
	
	public Idoso(String nome, String telefone, int idade, String rg) throws Exception {
		super(nome, telefone, idade);
		if (idade < 60) {
	    	throw new Exception("Idoso precisa ter 60 anos");
		}
		this.rg = rg;
	}

	public float getTarifa() {
		return 0f;
	}
	@Override
	public String toString() {
		return "Idoso " +
				"nome: " + getNome() + ", " +
				"telefone: " + getTelefone() + ", " +
				"rg: " + rg + ", " +
				"idade: " + getIdade() + " " +
				"";
	}

	public String toCSVRow() {
		StringBuilder content = new StringBuilder();
		content.append("I");
		content.append(',');
		content.append(getNome());
		content.append(',');
		content.append(getTelefone());
		content.append(',');
		content.append(getIdade());
		content.append(',');
		content.append(rg);
		return content.toString();
	}
}
