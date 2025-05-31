package Ecomerce.FitShape.Categoria.Service;

import Ecomerce.FitShape.Categoria.Dto.CategoriaDto;
import Ecomerce.FitShape.Categoria.Entity.Categoria;
import Ecomerce.FitShape.Categoria.Exception.CategoriaNaoEncontradaException;
import Ecomerce.FitShape.Categoria.Mapper.CategoriaMapper;
import Ecomerce.FitShape.Categoria.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImplemento implements CategoriaService {
    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaServiceImplemento(CategoriaRepository repository, CategoriaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoriaDto salvar(CategoriaDto dto) {
        Categoria categoria = mapper.toEntity(dto);
        return mapper.toDto(repository.save(categoria));
    }

    @Override
    public List<CategoriaDto> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
    }

    @Override
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new CategoriaNaoEncontradaException(id);
        }
        repository.deleteById(id);
    }

    @Override
    public CategoriaDto atualizar(Long id, CategoriaDto dto) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
        categoria.setNome(dto.nome);
        return mapper.toDto(repository.save(categoria));
    }

}