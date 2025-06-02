package Ecomerce.FitShape.Ingrediente.Mapper;

import Ecomerce.FitShape.Ingrediente.Dto.IngredienteDto;
import Ecomerce.FitShape.Ingrediente.Entity.Ingrediente;
import org.springframework.stereotype.Component;

@Component
public class IngredienteMapper {
    public Ingrediente toEntity(IngredienteDto dto){
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(dto.nome);
        ingrediente.setQuantidade(dto.quantidade);
        return ingrediente;
    }

    public IngredienteDto toDto(Ingrediente ingrediente){
        IngredienteDto dto = new IngredienteDto();
        dto.id = ingrediente.getId();
        dto.nome = ingrediente.getNome();
        dto.quantidade = ingrediente.getQuantidade();
        return dto;
    }
}
