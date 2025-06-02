package Ecomerce.FitShape.Marca.Exception;

public class MarcaNaoEncontradaException extends RuntimeException {
    public MarcaNaoEncontradaException(Long id) {
        super("Marca com ID: " + id + " não encontrada.");
    }
}
