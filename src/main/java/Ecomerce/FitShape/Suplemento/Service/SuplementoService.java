package Ecomerce.FitShape.Suplemento.Service;

import Ecomerce.FitShape.Suplemento.Dto.SuplementoDto;

import java.util.List;

public interface SuplementoService {
    SuplementoDto salvar(SuplementoDto dto);
    SuplementoDto buscarPorId(Long id);
    List<SuplementoDto> listarTodos();
    void deletar(Long id);

}
