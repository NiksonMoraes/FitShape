package Ecomerce.FitShape.Categoria.Controller;

import Ecomerce.FitShape.Categoria.Dto.CategoriaDto;
import Ecomerce.FitShape.Categoria.Service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoriaDto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CategoriaDto salvar(@RequestBody CategoriaDto dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public CategoriaDto atualizar(@PathVariable Long id, @RequestBody CategoriaDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
