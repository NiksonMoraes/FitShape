package Ecomerce.FitShape.Marca.Controller;

import Ecomerce.FitShape.Marca.Dto.MarcaDto;
import Ecomerce.FitShape.Marca.Service.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }

    @GetMapping
    public List<MarcaDto> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public MarcaDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public MarcaDto salvar(@RequestBody MarcaDto dto) {
        return service.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
