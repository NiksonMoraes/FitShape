package Ecomerce.FitShape.Suplemento.Controller;

import Ecomerce.FitShape.Suplemento.Dto.SuplementoDto;
import Ecomerce.FitShape.Suplemento.Service.SuplementoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suplementos")
public class SuplementoController {
    private final SuplementoService service;

    public SuplementoController(SuplementoService service) {
        this.service = service;
    }

    @PostMapping
    public SuplementoDto salvar(@RequestBody SuplementoDto dto){
        return service.salvar(dto);
    }

    @GetMapping
    public List<SuplementoDto> listarTodos(){
        return service.listarTodos();
    }

    public SuplementoDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public SuplementoDto atualizar(@PathVariable Long id, @RequestBody SuplementoDto dto) {
        return service.atualizar(id, dto);
    }

    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }


}
