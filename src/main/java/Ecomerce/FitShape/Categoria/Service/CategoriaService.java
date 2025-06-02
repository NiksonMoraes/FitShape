package Ecomerce.FitShape.Categoria.Service;

import Ecomerce.FitShape.Categoria.Dto.CategoriaDto;
import java.util.List;

public interface CategoriaService {
    CategoriaDto salvar(CategoriaDto dto);
    CategoriaDto buscarPorId(Long id);
    List<CategoriaDto> listarTodos();
    void deletar(Long id);

}
