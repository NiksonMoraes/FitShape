package Ecomerce.FitShape.Categoria.Dto;

public class CategoriaDto {
    public Long id;
    public String nome;

    public CategoriaDto (){
    }

    //GETTERS e SETTERS
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //CONTRUTORES
    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
