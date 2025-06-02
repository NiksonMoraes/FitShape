package Ecomerce.FitShape.Suplemento.Service;

import Ecomerce.FitShape.Suplemento.Dto.SuplementoAtualizarDto;
import Ecomerce.FitShape.Suplemento.Dto.SuplementoDto;
import Ecomerce.FitShape.Suplemento.Dto.SuplementoSalvarDto;

import java.util.List;

public interface SuplementoService {
    SuplementoDto salvar(SuplementoSalvarDto dto);
    SuplementoDto buscarPorId(Long id);
    List<SuplementoDto> listarTodos();
    void deletar(Long id);
    SuplementoDto atualizar(Long id, SuplementoAtualizarDto dto);

}
