package Ecomerce.FitShape.Ingrediente.Controller;

import Ecomerce.FitShape.Ingrediente.Dto.IngredienteDto;
import Ecomerce.FitShape.Ingrediente.Service.IngredienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {
    private final IngredienteService service;

    //CONSTRUTOR

    public IngredienteController(IngredienteService service) {
        this.service = service;
    }

    //METODOS
    @GetMapping
    public List<IngredienteDto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public IngredienteDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public IngredienteDto salvar(@RequestBody IngredienteDto dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public IngredienteDto atualizar(@PathVariable Long id, @RequestBody IngredienteDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
