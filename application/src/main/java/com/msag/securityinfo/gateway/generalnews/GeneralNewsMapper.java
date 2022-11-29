package com.msag.securityinfo.gateway.generalnews;

import com.msag.securityinfo.controller.data.internal.CategoryInfo;
import com.msag.securityinfo.controller.data.internal.SecurityInfoDetail;
import com.msag.securityinfo.controller.data.internal.SecurityInfoNews;
import com.msag.securityinfo.gateway.generalnews.data.GeneralNewsResponseDTO;
import com.msag.securityinfo.gateway.generalnews.data.ImageDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class GeneralNewsMapper {

    private GeneralNewsMapper() {
        // not used
    }

    public static SecurityInfoNews mapToSecurityInfoNews(final GeneralNewsResponseDTO source){
        return SecurityInfoNews.builder()
                .title(source.getHeader())
                .date(source.getPubDate())
                .category(CategoryInfo.builder().name(source.getCategory()).build())
                .shortDescription(source.getSubheader())
                .imageUrl(GeneralNewsMapper.getImageUrl(source.getImages()))
                .infoDetail(GeneralNewsMapper.getGeneralNews(source))
                .build();
    }
    private static SecurityInfoDetail getGeneralNews(GeneralNewsResponseDTO source) {
        final List<String> images = new ArrayList<>();
        if(source.getImages().size() > 1){
            images.addAll(source.getImages().stream()
                    .map(ImageDTO::getImageURL)
                    .collect(Collectors.toList()));
        }

        return SecurityInfoDetail.builder()
                .text(source.getContent())
                .imageUrls(images)
                .build();
    }

    private static String getImageUrl(List<ImageDTO> images) {
        if(CollectionUtils.isEmpty(images)){
            return null;
        }
        //ToDO: currently first image is used: discuss if there is a criteria which image should actually be used
        return images.get(0).getImageURL();
    }
}
