package Ecomerce.FitShape.Ingrediente.Service;

import Ecomerce.FitShape.Ingrediente.Dto.IngredienteDto;
import Ecomerce.FitShape.Ingrediente.Entity.Ingrediente;
import Ecomerce.FitShape.Ingrediente.Exception.IngredienteNaoEncontradoException;
import Ecomerce.FitShape.Ingrediente.Mapper.IngredienteMapper;
import Ecomerce.FitShape.Ingrediente.Repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteServiceImplemento implements IngredienteService{
    private final IngredienteRepository repository;
    private final IngredienteMapper mapper;

    //CONSTRUTOR
    public IngredienteServiceImplemento(IngredienteRepository repository, IngredienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //METODOS
    @Override
    public IngredienteDto salvar(IngredienteDto dto) {
        Ingrediente ingrediente = mapper.toEntity(dto);
        return mapper.toDto(repository.save(ingrediente));
    }

    @Override
    public IngredienteDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IngredienteNaoEncontradoException(id));
    }

    @Override
    public List<IngredienteDto> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new IngredienteNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }

    @Override
    public IngredienteDto atualizar(Long id, IngredienteDto dto) {
        Ingrediente ingrediente = repository.findById(id)
                .orElseThrow(() -> new IngredienteNaoEncontradoException(id));
        ingrediente.setNome(dto.nome);
        ingrediente.setQuantidade(dto.quantidade);
        return mapper.toDto(repository.save(ingrediente));
    }
}
