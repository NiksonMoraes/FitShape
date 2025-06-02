package Ecomerce.FitShape.Ingrediente.Exception;

public class IngredienteNaoEncontradoException extends RuntimeException {
    public IngredienteNaoEncontradoException(Long id) {
        super("Ingrediente com ID: " + id + " não encontrado.");
    }
}
