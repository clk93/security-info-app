package com.msag.securityinfo.gateway.videonews;

import com.msag.securityinfo.data.CategoryInfo;
import com.msag.securityinfo.data.SecurityVideoInfoData;
import com.msag.securityinfo.data.VideoData;
import com.msag.securityinfo.gateway.videonews.data.VideoDataResponseDTO;
import com.msag.securityinfo.gateway.videonews.data.VideoEntryDTO;
import com.msag.securityinfo.utils.Category;

import java.util.Map;
import java.util.stream.Collectors;

public final class VideoDataMapper {

    private VideoDataMapper() {
        //not used
    }

    public static SecurityVideoInfoData mapToSecurityVideoInfoData(final VideoDataResponseDTO source,
                                                                   final Map<Category, String> categoryNameIconMap){
        return SecurityVideoInfoData.builder()
                .icon(source.getIcon())
                .videoData(source.getEntries().stream()
                        .map(currentVideoData -> VideoDataMapper.mapVideoData(currentVideoData, categoryNameIconMap))
                        .collect(Collectors.toList()))
                .build();
    }

    private static VideoData mapVideoData(final VideoEntryDTO source, final Map<Category, String> categoryNameIconMap){
        return VideoData.builder()
                .id(source.getId())
                .title(source.getTitle())
                .subTitle(source.getSubTitle())
                .videoURL(source.getVideoURL())
                .releaseDate(source.getReleaseDate())
                .description(source.getDescription())
                .category(CategoryInfo.builder()
                        .name(Category.VIDEO)
                        .iconUrl(categoryNameIconMap.get(Category.VIDEO))
                        .build())
                .build();
    }
}
