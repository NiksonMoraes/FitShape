package Ecomerce.FitShape.Suplemento.Mapper;

import Ecomerce.FitShape.Suplemento.Dto.SuplementoDto;
import Ecomerce.FitShape.Suplemento.Entity.Suplemento;
import org.springframework.stereotype.Component;

@Component
public class SuplementoMapper {
    public Suplemento toEntity(SuplementoDto dto){
        Suplemento suplemento = new Suplemento();
        suplemento.setNome(dto.nome);
        suplemento.setDescricao(dto.descricao);
        suplemento.setPrecoDeCusto(dto.precoDeCusto);
        return suplemento;
    }

    public SuplementoDto toDto(Suplemento suplemento){
        SuplementoDto dto = new SuplementoDto();
        dto.id = suplemento.getId();
        dto.nome = suplemento.getNome();
        dto.descricao = suplemento.getDescricao();
        dto.precoDeCusto = suplemento.getPrecoDeCusto();
        return dto;
    }

}
