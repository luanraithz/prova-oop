// Luan Raithz Machado
package furb.viagem;

public class LimiteAtingidoException extends Exception {
    private final int limit;

    LimiteAtingidoException(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return this.limit;
    }
}
