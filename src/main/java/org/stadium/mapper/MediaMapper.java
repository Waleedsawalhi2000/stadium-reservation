package org.stadium.mapper;

import org.stadium.dto.MediaDto;
import org.stadium.entity.Media;

public class MediaMapper extends AbstractMapper<Media, MediaDto> {
    @Override
    public Media toEntity(final MediaDto mediaDto) {
        return mediaDto == null ? null : Media
                .builder()
                .id(mediaDto.getId())
                .image(mediaDto.getImage())
                .name(mediaDto.getName())
                .uri(mediaDto.getUri())
                .build();
    }

    @Override
    public MediaDto toDto(final Media media) {
        return media == null ? null : MediaDto
                .builder()
                .id(media.getId())
                .image(media.getImage())
                .name(media.getName())
                .uri(media.getUri())
                .build();
    }
}
