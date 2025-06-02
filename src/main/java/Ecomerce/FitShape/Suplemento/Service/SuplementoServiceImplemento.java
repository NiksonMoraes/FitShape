package Ecomerce.FitShape.Suplemento.Service;

import Ecomerce.FitShape.Suplemento.Dto.SuplementoAtualizarDto;
import Ecomerce.FitShape.Suplemento.Dto.SuplementoDto;
import Ecomerce.FitShape.Suplemento.Dto.SuplementoSalvarDto;
import Ecomerce.FitShape.Suplemento.Entity.Suplemento;
import Ecomerce.FitShape.Suplemento.Exception.SuplementoNaoEncontradoException;
import Ecomerce.FitShape.Suplemento.Mapper.SuplementoMapper;
import Ecomerce.FitShape.Suplemento.Repository.SuplementoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuplementoServiceImplemento implements SuplementoService{
    private final SuplementoRepository repository;
    private final SuplementoMapper mapper;

    //CONSTRUTOR
    public SuplementoServiceImplemento(SuplementoRepository repository, SuplementoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //METODOS
    @Override
    @Transactional
    public SuplementoDto salvar(SuplementoSalvarDto dto){
        Suplemento entity = mapper.toEntity(dto);
        Suplemento salvo = repository.save(entity);
        return mapper.toDto(salvo);
    }

    @Override
    public SuplementoDto buscarPorId(Long id){
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new SuplementoNaoEncontradoException(id));
    }

    @Override
    public List<SuplementoDto> listarTodos(){
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public void deletar(Long id){
        if (!repository.existsById(id)){
            throw new SuplementoNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public SuplementoDto atualizar(Long id, SuplementoAtualizarDto dto) {
        Suplemento existente = repository.findById(id)
            .orElseThrow(() -> new SuplementoNaoEncontradoException(id));
        mapper.atualizarEntidade(existente, dto);
        Suplemento atualizado = repository.save(existente);
        return mapper.toDto(atualizado);
    }
}
