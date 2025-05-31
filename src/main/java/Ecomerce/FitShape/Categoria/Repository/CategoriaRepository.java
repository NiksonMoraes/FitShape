package Ecomerce.FitShape.Categoria.Repository;

import Ecomerce.FitShape.Categoria.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
}
