package com.msag.securityinfo.controller.utils;

import com.msag.securityinfo.controller.data.CategoryInfoDTO;
import com.msag.securityinfo.controller.data.SecurityInfoDetailDTO;
import com.msag.securityinfo.controller.data.SecurityInfoNewsDTO;
import com.msag.securityinfo.controller.data.SecurityInfoResponseDTO;
import com.msag.securityinfo.generalnews.data.SecurityInfoData;
import com.msag.securityinfo.generalnews.data.SecurityInfoNews;

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
                .detailInfo(SecurityInfoDetailDTO.builder()
                        .title(source.getInfoDetail().getTitle())
                        .date(source.getInfoDetail().getDate())
                        .shortDescription(source.getInfoDetail().getShortDescription())
                        .text(source.getInfoDetail().getText())
                        .build())
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
                .build();
    }
}
