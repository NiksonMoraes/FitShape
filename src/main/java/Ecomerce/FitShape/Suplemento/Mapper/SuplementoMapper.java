package Ecomerce.FitShape.Suplemento.Mapper;

import Ecomerce.FitShape.Categoria.Entity.Categoria;
import Ecomerce.FitShape.Ingrediente.Entity.Ingrediente;
import Ecomerce.FitShape.Marca.Entity.Marca;
import Ecomerce.FitShape.Suplemento.Dto.SuplementoAtualizarDto;
import Ecomerce.FitShape.Suplemento.Dto.SuplementoDto;
import Ecomerce.FitShape.Suplemento.Dto.SuplementoSalvarDto;
import Ecomerce.FitShape.Suplemento.Entity.Suplemento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SuplementoMapper {


    //CONVERSÃO DOS DADOS DA ENTIDADE PARA O DTO
    public Suplemento toEntity(SuplementoSalvarDto dto) {
        Suplemento suplemento = new Suplemento();
        suplemento.setNome(dto.getNome());
        suplemento.setDescricao(dto.getDescricao());
        suplemento.setPrecoDeCusto(dto.getPrecoDeCusto());

        Categoria categoria = new Categoria();
        categoria.setId(dto.getCategoriaId());
        suplemento.setCategoria(categoria);

        Marca marca = new Marca();
        marca.setId(dto.getMarcaId());
        suplemento.setMarca(marca);

        List<Ingrediente> ingredientes = dto.getIngredientesIds().stream().map(id -> {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setId(id);
            return ingrediente;
        }).collect(Collectors.toList());
        suplemento.setIngredientes(ingredientes);

        return suplemento;
    }

    public void atualizarEntidade(Suplemento suplemento, SuplementoAtualizarDto dto) {
        suplemento.setNome(dto.getNome());
        suplemento.setDescricao(dto.getDescricao());
        suplemento.setPrecoDeCusto(dto.getPrecoDeCusto());

        Categoria categoria = new Categoria();
        categoria.setId(dto.getCategoriaId());
        suplemento.setCategoria(categoria);

        Marca marca = new Marca();
        marca.setId(dto.getMarcaId());
        suplemento.setMarca(marca);

        List<Ingrediente> ingredientes = dto.getIngredientesIds().stream().map(id -> {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setId(id);
            return ingrediente;
        }).collect(Collectors.toList());
        suplemento.setIngredientes(ingredientes);
    }

    public SuplementoDto toDto(Suplemento entity) {
        SuplementoDto dto = new SuplementoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setPrecoDeCusto(entity.getPrecoDeCusto());
        dto.setCategoriaId(entity.getCategoria().getId());
        dto.setMarcaId(entity.getMarca().getId());

        List<Long> ingredientesIds = entity.getIngredientes().stream()
                .map(Ingrediente::getId)
                .collect(Collectors.toList());
        dto.setIngredientesIds(ingredientesIds);

        return dto;
    }

}
