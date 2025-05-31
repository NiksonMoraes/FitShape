package Ecomerce.FitShape.Marca.Mapper;

import Ecomerce.FitShape.Marca.Dto.MarcaDto;
import Ecomerce.FitShape.Marca.Entity.Marca;
import org.springframework.stereotype.Component;

@Component
public class MarcaMapper {
    public Marca toEntity(MarcaDto dto) {
        Marca marca = new Marca();
        marca.setNome(dto.nome);
        return marca;
    }

    public MarcaDto toDto(Marca marca) {
        MarcaDto dto = new MarcaDto();
        dto.id = marca.getId();
        dto.nome = marca.getNome();
        return dto;
    }
}
