package com.msag.securityinfo.controller.utils;

import com.msag.securityinfo.controller.data.internal.SecurityInfoData;
import com.msag.securityinfo.controller.data.internal.SecurityInfoNews;
import com.msag.securityinfo.controller.data.response.CategoryInfoDTO;
import com.msag.securityinfo.controller.data.response.SecurityInfoDetailDTO;
import com.msag.securityinfo.controller.data.response.SecurityInfoNewsDTO;
import com.msag.securityinfo.controller.data.response.SecurityInfoResponseDTO;

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
                .build();
    }

    private static SecurityInfoNewsDTO mapInfoNewsDTO(final SecurityInfoNews source) {
        return SecurityInfoNewsDTO.builder()
                .title(source.getTitle())
                .date(source.getDate())
                .shortDescription(source.getShortDescription())
                .category(CategoryInfoDTO.builder()
                        .category(source.getCategory().getCategory())
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
