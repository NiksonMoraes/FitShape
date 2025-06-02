package Ecomerce.FitShape.Configuracao;

import Ecomerce.FitShape.Categoria.Exception.CategoriaNaoEncontradaException;
import Ecomerce.FitShape.Ingrediente.Exception.IngredienteNaoEncontradoException;
import Ecomerce.FitShape.Marca.Exception.MarcaNaoEncontradaException;
import Ecomerce.FitShape.Suplemento.Exception.SuplementoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity<Object> handleCategoriaNaoEncontrada(CategoriaNaoEncontradaException exception){
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MarcaNaoEncontradaException.class)
    public ResponseEntity<Object> handleMarcaNaoEncontrada(MarcaNaoEncontradaException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IngredienteNaoEncontradoException.class)
    public ResponseEntity<Object> handleIngredienteNaoEncontrado(IngredienteNaoEncontradoException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SuplementoNaoEncontradoException.class)
    public ResponseEntity<Object> handleSuplementoNaoEncontrado(SuplementoNaoEncontradoException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        return buildResponse("Erro interno no servidor: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> buildResponse(String message, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }
}
