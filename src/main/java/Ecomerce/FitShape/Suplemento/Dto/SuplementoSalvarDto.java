package Ecomerce.FitShape.Suplemento.Dto;

import java.util.List;

public class SuplementoSalvarDto {
    public String nome;
    public String descricao;
    public Float precoDeCusto;
    public Long categoriaId;
    public Long marcaId;
    public List<Long> ingredientesIds;

    //GETTERS e SETTERS

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

    //CONTRUTORES
    public SuplementoSalvarDto(){
    }

    public SuplementoSalvarDto(String nome, String descricao, Float precoDeCusto, Long categoriaId, Long marcaId, List<Long> ingredientesIds) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoDeCusto = precoDeCusto;
        this.categoriaId = categoriaId;
        this.marcaId = marcaId;
        this.ingredientesIds = ingredientesIds;
    }
}
