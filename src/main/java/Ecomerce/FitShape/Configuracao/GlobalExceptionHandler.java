package Ecomerce.FitShape.Configuracao;

import Ecomerce.FitShape.Categoria.Exception.CategoriaNaoEncontradaException;
import Ecomerce.FitShape.Ingrediente.Exception.IngredienteNaoEncontradoException;
import Ecomerce.FitShape.Marca.Exception.MarcaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity<String> handleCategoriaNaoEncontrada(CategoriaNaoEncontradaException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(MarcaNaoEncontradaException.class)
    public ResponseEntity<String> handleMarcaNaoEncontrada(MarcaNaoEncontradaException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(IngredienteNaoEncontradoException.class)
    public ResponseEntity<String> handleIngredienteNaoEncontrado(IngredienteNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


}
