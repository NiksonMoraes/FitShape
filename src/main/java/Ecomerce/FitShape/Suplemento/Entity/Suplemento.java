package Ecomerce.FitShape.Suplemento.Entity;

import Ecomerce.FitShape.Categoria.Entity.Categoria;
import Ecomerce.FitShape.Ingrediente.Entity.Ingrediente;
import Ecomerce.FitShape.Marca.Entity.Marca;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Suplemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Float precoDeCusto;

    private Categoria categoria;

    private Marca marca;

    private List<Ingrediente> ingredientes;

    //Getters e Setters
    public Long getId() {
        return id;
    }

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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    //Construtores
    public Suplemento(){
    }

    public Suplemento(Long id, String nome, String descricao, Float precoDeCusto, Categoria categoria, Marca marca, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoDeCusto = precoDeCusto;
        this.categoria = categoria;
        this.marca = marca;
        this.ingredientes = ingredientes;
    }

}
