package Ecomerce.FitShape.Marca.Service;

import Ecomerce.FitShape.Marca.Dto.MarcaDto;
import Ecomerce.FitShape.Marca.Entity.Marca;
import Ecomerce.FitShape.Marca.Exception.MarcaNaoEncontradaException;
import Ecomerce.FitShape.Marca.Mapper.MarcaMapper;
import Ecomerce.FitShape.Marca.Repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaServiceImplemento implements MarcaService {
        private final MarcaRepository repository;
        private final MarcaMapper mapper;

        public MarcaServiceImplemento(MarcaRepository repository, MarcaMapper mapper) {
            this.repository = repository;
            this.mapper = mapper;
        }

        @Override
        public MarcaDto salvar(MarcaDto dto) {
            Marca marca = mapper.toEntity(dto);
            return mapper.toDto(repository.save(marca));
        }

        @Override
        public MarcaDto buscarPorId(Long id) {
            return repository.findById(id)
                    .map(mapper::toDto)
                    .orElseThrow(() -> new MarcaNaoEncontradaException(id));
        }

        @Override
        public List<MarcaDto> listarTodas() {
            return repository.findAll().stream()
                    .map(mapper::toDto)
                    .collect(Collectors.toList());
        }

        @Override
        public void deletar(Long id) {
            if (!repository.existsById(id)) {
                throw new MarcaNaoEncontradaException(id);
            }
            repository.deleteById(id);
        }

}
