package Ecomerce.FitShape.Marca.Service;

import Ecomerce.FitShape.Marca.Dto.MarcaDto;

import java.util.List;

public interface MarcaService {
    MarcaDto salvar(MarcaDto dto);
    MarcaDto buscarPorId(Long id);
    List<MarcaDto> listarTodas();
    void deletar(Long id);
    MarcaDto atualizar(Long id, MarcaDto dto);
}
