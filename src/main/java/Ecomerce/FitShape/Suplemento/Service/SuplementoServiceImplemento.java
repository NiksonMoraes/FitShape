package Ecomerce.FitShape.Suplemento.Service;

import Ecomerce.FitShape.Suplemento.Dto.SuplementoDto;
import Ecomerce.FitShape.Suplemento.Entity.Suplemento;
import Ecomerce.FitShape.Suplemento.Exception.SuplementoNaoEncontradoException;
import Ecomerce.FitShape.Suplemento.Mapper.SuplementoMapper;
import Ecomerce.FitShape.Suplemento.Repository.SuplementoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuplementoServiceImplemento implements SuplementoService{
    private final SuplementoRepository repository;
    private final SuplementoMapper mapper;

    public SuplementoServiceImplemento(SuplementoRepository repository, SuplementoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SuplementoDto salvar(SuplementoDto dto){
        Suplemento suplemento = mapper.toEntity(dto);
        return mapper.toDto(repository.save(suplemento));
    }

    @Override
    public SuplementoDto buscarPorId(Long id){
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new SuplementoNaoEncontradoException(id));
    }

    @Override
    public List<SuplementoDto> listarTodos(){
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public void deletar(Long id){
        if (!repository.existsById(id)){
            throw new SuplementoNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }

}
