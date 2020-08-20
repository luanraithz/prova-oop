// Luan Raithz Machado
package furb.passageiro;

import java.io.Serializable;

public class Passageiro implements Serializable {
	private String nome;
	private String telefone;
	private int idade;
	private final float tarifaInteira = 5.0f;

	public Passageiro(String nome, String telefone, int idade) {
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getIdade() {
		return idade;
	}

	public float getTarifa()
	{
		return tarifaInteira;
	}

	@Override
	public String toString() {
		return "Passageiro: " +
				"nome: " + nome + ", " +
				"telefone: " + telefone + ", " +
				"idade: " + idade + "";
	}

	public String toCSVRow() {
		StringBuilder content = new StringBuilder();
		content.append("P");
		content.append(',');
		content.append(getNome());
		content.append(',');
		content.append(getTelefone());
		content.append(',');
		content.append(getIdade());
		return content.toString();
	}
}
