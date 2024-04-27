package kg.itSphere.CTF.mapper;

import kg.itSphere.CTF.dto.image.ImageResponse;
import kg.itSphere.CTF.entities.Image;

import java.util.List;

public interface ImageMapper {
    ImageResponse toDto(Image image);

    List<ImageResponse> toDtoS(List<Image> all);

    Image toDtoImage(Image image, String name);

}
