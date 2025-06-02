package Ecomerce.FitShape.Suplemento.Service;

import Ecomerce.FitShape.Suplemento.Dto.SuplementoSalvarDto;
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

    //CONSTRUTOR
    public SuplementoServiceImplemento(SuplementoRepository repository, SuplementoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //METODOS
    @Override
    public SuplementoSalvarDto salvar(SuplementoSalvarDto dto){
        Suplemento suplemento = mapper.toEntity(dto);
        return mapper.tosalvarDto(repository.save(suplemento));
    }

    @Override
    public SuplementoSalvarDto buscarPorId(Long id){
        return repository.findById(id)
                .map(mapper::tosalvarDto)
                .orElseThrow(() -> new SuplementoNaoEncontradoException(id));
    }

    @Override
    public List<SuplementoSalvarDto> listarTodos(){
        return repository.findAll().stream()
                .map(mapper::tosalvarDto)
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
    public SuplementoSalvarDto atualizar(Long id, SuplementoSalvarDto dto) {
        if (!repository.existsById(id)) {
            throw new SuplementoNaoEncontradoException(id);
        }
        atualizarDto.id = id;
        Suplemento atualizado = repository.save(mapper.toEntity(atualizarDto));
        return mapper.toatualizarDto(atualizado);
    }
}
