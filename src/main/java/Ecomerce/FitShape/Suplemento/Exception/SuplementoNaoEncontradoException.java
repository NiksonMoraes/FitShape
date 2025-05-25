package Ecomerce.FitShape.Suplemento.Exception;

public class SuplementoNaoEncontradoException extends RuntimeException {
    public SuplementoNaoEncontradoException(Long id) {

        super("Suplemento com ID" + id + " não encontrado.");
    }
}
