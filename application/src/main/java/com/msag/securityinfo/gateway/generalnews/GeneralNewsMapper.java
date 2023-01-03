package com.msag.securityinfo.gateway.generalnews;

import com.msag.securityinfo.common.exception.UnknownCategoryException;
import com.msag.securityinfo.app.data.CategoryInfo;
import com.msag.securityinfo.app.data.SecurityInfoDetail;
import com.msag.securityinfo.app.data.SecurityInfoNews;
import com.msag.securityinfo.gateway.generalnews.data.GeneralNewsResponseDTO;
import com.msag.securityinfo.gateway.generalnews.data.ImageDTO;
import com.msag.securityinfo.app.utils.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public final class GeneralNewsMapper {

    private GeneralNewsMapper() {
        // not used
    }

    public static SecurityInfoNews mapToSecurityInfoNews(final GeneralNewsResponseDTO source,
                                                         final Map<Category, String> categoryUrlMap) {
        Category category;
        try {
            category = Category.getCategory(source.getCategory());
        } catch (UnknownCategoryException e) {
            log.error("[GeneralNewsMapper:mapToSecurityInfoNews] Unknown category {}", e.getMessage());
            category = null;
        }
        return SecurityInfoNews.builder()
                .title(source.getHeader())
                .date(source.getPubDate())
                .category(Objects.nonNull(category) ? CategoryInfo.builder()
                        .name(category)
                        .iconUrl(categoryUrlMap.get(category))
                        .build() : null)
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
