package Ecomerce.FitShape.Ingrediente.Service;

import Ecomerce.FitShape.Ingrediente.Dto.IngredienteDto;

import java.util.List;

public interface IngredienteService {
    IngredienteDto salvar(IngredienteDto dto);
    IngredienteDto buscarPorId(Long id);
    List<IngredienteDto> listarTodos();
    void deletar(Long id);
}
