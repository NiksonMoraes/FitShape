package Ecomerce.FitShape.Suplemento.Dto;

import java.util.List;

public class SuplementoAtualizarDto {
    private String nome;
    private String descricao;
    private Float precoDeCusto;
    private Long categoriaId;
    private Long marcaId;
    private List<Long> ingredientesIds;

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(Float precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    public List<Long> getIngredientesIds() {
        return ingredientesIds;
    }

    public void setIngredientesIds(List<Long> ingredientesIds) {
        this.ingredientesIds = ingredientesIds;
    }

    //CONSTRUTOR
    public SuplementoAtualizarDto(){
    }

    public SuplementoAtualizarDto(String nome, String descricao, Float precoDeCusto, Long categoriaId, Long marcaId, List<Long> ingredientesIds) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoDeCusto = precoDeCusto;
        this.categoriaId = categoriaId;
        this.marcaId = marcaId;
        this.ingredientesIds = ingredientesIds;
    }
}
