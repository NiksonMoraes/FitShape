package Ecomerce.FitShape.Suplemento.Controller;

import Ecomerce.FitShape.Suplemento.Dto.SuplementoSalvarDto;
import Ecomerce.FitShape.Suplemento.Service.SuplementoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suplementos")
public class SuplementoController {
    private final SuplementoService service;

    //CONSTRUTOR
    public SuplementoController(SuplementoService service) {
        this.service = service;
    }

    //REQUISIÇÕES
    @PostMapping
    public SuplementoSalvarDto salvar(@RequestBody SuplementoSalvarDto dto){
        return service.salvar(dto);
    }

    @GetMapping
    public List<SuplementoSalvarDto> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public SuplementoSalvarDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public SuplementoSalvarDto atualizar(@PathVariable Long id, @RequestBody SuplementoSalvarDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }


}
