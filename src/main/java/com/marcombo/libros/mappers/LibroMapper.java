package com.marcombo.libros.mappers;

import com.marcombo.libros.dto.LibroDTO;
import org.mapstruct.Mapper;
import com.marcombo.libros.entity.Libro;
import java.util.List;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface LibroMapper {

    @Mappings({
        @Mapping(source = "entity.libroId", target = "id"),
        @Mapping(source = "entity.isbn", target = "ISBN"),})
    LibroDTO toDTO(Libro entity);

    Libro toEntity(LibroDTO dto);

    List<LibroDTO> toListDTO(List<Libro> list);
}
