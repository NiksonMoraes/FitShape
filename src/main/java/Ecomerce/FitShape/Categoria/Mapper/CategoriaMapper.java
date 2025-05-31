package Ecomerce.FitShape.Categoria.Mapper;

import Ecomerce.FitShape.Categoria.Dto.CategoriaDto;
import Ecomerce.FitShape.Categoria.Entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
    public Categoria toEntity(CategoriaDto dto){
        Categoria entity = new Categoria();
        entity.setNome(dto.nome);
        return entity;
    }

    public CategoriaDto toDto(Categoria entity){
        CategoriaDto dto = new CategoriaDto();
        dto.id = entity.getId();
        dto.nome = entity.getNome();
        return dto;
    }


}
