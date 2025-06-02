package Ecomerce.FitShape.Ingrediente.Dto;

public class IngredienteDto {
    public Long id;
    public String nome;
    public String quantidade;

    //GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    //CONSTRUTORES
    public IngredienteDto(){
    }

    public IngredienteDto(Long id, String nome, String quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }
}
