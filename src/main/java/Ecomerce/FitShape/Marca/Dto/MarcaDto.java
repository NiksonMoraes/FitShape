package Ecomerce.FitShape.Marca.Dto;

public class MarcaDto {
    public Long id;
    public String nome;

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

    //CONSTRUTORES
    public MarcaDto (){
    }

    public MarcaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
