package Ecomerce.FitShape.Suplemento.Mapper;

import Ecomerce.FitShape.Categoria.Entity.Categoria;
import Ecomerce.FitShape.Categoria.Exception.CategoriaNaoEncontradaException;
import Ecomerce.FitShape.Categoria.Repository.CategoriaRepository;
import Ecomerce.FitShape.Ingrediente.Entity.Ingrediente;
import Ecomerce.FitShape.Ingrediente.Exception.IngredienteNaoEncontradoException;
import Ecomerce.FitShape.Ingrediente.Repository.IngredienteRepository;
import Ecomerce.FitShape.Marca.Entity.Marca;
import Ecomerce.FitShape.Marca.Exception.MarcaNaoEncontradaException;
import Ecomerce.FitShape.Marca.Repository.MarcaRepository;
import Ecomerce.FitShape.Suplemento.Dto.SuplementoDto;
import Ecomerce.FitShape.Suplemento.Entity.Suplemento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SuplementoMapper {
    private final CategoriaRepository categoriaRepository;
    private final MarcaRepository marcaRepository;
    private final IngredienteRepository ingredienteRepository;

    //CONSTRUTOR
    public SuplementoMapper(CategoriaRepository categoriaRepository, MarcaRepository marcaRepository, IngredienteRepository ingredienteRepository) {
        this.categoriaRepository = categoriaRepository;
        this.marcaRepository = marcaRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    //CONVERSÃO DOS DADOS DA ENTIDADE PARA O DTO
    public Suplemento toEntity(SuplementoDto dto){
        Suplemento suplemento = new Suplemento();

        suplemento.setNome(dto.nome);
        suplemento.setDescricao(dto.descricao);
        suplemento.setPrecoDeCusto(dto.precoDeCusto);

        if (dto.categoriaId != null) {
            Categoria categoria = categoriaRepository.findById(dto.categoriaId)
                    .orElseThrow(() -> new CategoriaNaoEncontradaException(dto.categoriaId));
            suplemento.setCategoria(categoria);
        }

        if (dto.marcaId != null) {
            Marca marca = marcaRepository.findById(dto.marcaId)
                    .orElseThrow(() -> new MarcaNaoEncontradaException(dto.marcaId));
            suplemento.setMarca(marca);
        }

        if (dto.ingredientesIds != null){
            List<Ingrediente> ingredientes = dto.ingredientesIds.stream()
                .map(id -> ingredienteRepository.findById(id)
                    .orElseThrow(() -> new IngredienteNaoEncontradoException(id)))
                .collect(Collectors.toList());
            suplemento.setIngredientes(ingredientes);
        }
        return suplemento;
    }

    //CONVERSÃO DOS DADOS DO DTO PARA A ENTIDADE
    public SuplementoDto toDto(Suplemento suplemento){
        SuplementoDto dto = new SuplementoDto();

        dto.id = suplemento.getId();
        dto.nome = suplemento.getNome();
        dto.descricao = suplemento.getDescricao();
        dto.precoDeCusto = suplemento.getPrecoDeCusto();
        dto.categoriaId = suplemento.getCategoria() != null ? suplemento.getCategoria().getId() : null;
        dto.marcaId = suplemento.getMarca() != null ? suplemento.getMarca().getId() : null;
        dto.ingredientesIds = suplemento.getIngredientes() != null ?
            suplemento.getIngredientes().stream()
                .map(Ingrediente::getId)
                .collect(Collectors.toList())
            :List.of();
        return dto;
    }

}
