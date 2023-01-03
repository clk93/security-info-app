package com.msag.securityinfo.app.utils;

import com.msag.securityinfo.controller.data.*;
import com.msag.securityinfo.app.data.SecurityInfoData;
import com.msag.securityinfo.app.data.SecurityInfoNews;
import com.msag.securityinfo.app.data.SecurityVideoInfoData;

import java.util.stream.Collectors;

public final class SecurityInfoMapper {
    private SecurityInfoMapper() {
        // not used
    }

    public static SecurityInfoResponseDTO mapDTO(final SecurityInfoData source){
        return SecurityInfoResponseDTO.builder()
                .infoNews(source.getInfoNews().stream()
                        .map(SecurityInfoMapper::mapInfoNewsDTO)
                        .collect(Collectors.toList()))
                .videoData(mapVideoData(source.getVideoInfoData()))
                .build();
    }

    private static SecurityVideoDataDTO mapVideoData(final SecurityVideoInfoData source) {
        return SecurityVideoDataDTO.builder()
                .icon(source.getIcon())
                .data(source.getVideoData().stream()
                        .map(currentData ->
                                VideoDataDTO.builder()
                                        .title(currentData.getTitle())
                                        .subtitle(currentData.getSubTitle())
                                        .url(currentData.getVideoURL())
                                        .date(currentData.getReleaseDate())
                                        .description(currentData.getDescription())
                                        .category(CategoryInfoDTO.builder()
                                                .category(currentData.getCategory().getName().label)
                                                .iconUrl(currentData.getCategory().getIconUrl())
                                                .build())
                                        .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private static SecurityInfoNewsDTO mapInfoNewsDTO(final SecurityInfoNews source) {
        return SecurityInfoNewsDTO.builder()
                .title(source.getTitle())
                .date(source.getDate())
                .shortDescription(source.getShortDescription())
                .category(CategoryInfoDTO.builder()
                        .category(source.getCategory().getName().label)
                        .iconUrl(source.getCategory().getIconUrl())
                        .build())
                .imageUrl(source.getImageUrl())
                .detailInfo(SecurityInfoDetailDTO.builder()
                        .text(source.getInfoDetail().getText())
                        .imageUrls(source.getInfoDetail().getImageUrls())
                        .build())
                .build();
    }
}
