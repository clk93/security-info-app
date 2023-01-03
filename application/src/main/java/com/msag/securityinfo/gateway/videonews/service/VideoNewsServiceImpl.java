package com.msag.securityinfo.gateway.videonews.service;

import com.msag.securityinfo.common.exception.VideoNewsException;
import com.msag.securityinfo.app.data.SecurityVideoInfoData;
import com.msag.securityinfo.gateway.common.HttpConnectionProvider;
import com.msag.securityinfo.gateway.videonews.VideoDataMapper;
import com.msag.securityinfo.gateway.videonews.data.VideoDataResponseDTO;
import com.msag.securityinfo.app.utils.Category;
import com.msag.securityinfo.app.utils.CategoryUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class VideoNewsServiceImpl extends HttpConnectionProvider implements VideoNewsService {

    @Value("${com.msag.securityInfo.gateway.videoNews.url}")
    private String videoNewsUrl;

    private final RestTemplate restTemplate;

    @Override
    public SecurityVideoInfoData getVideoData() throws VideoNewsException {
        log.debug("[VideoNewsServiceImpl:getVideoNews] Start to fetch video news");
        final HttpEntity<?> entity = new HttpEntity<>(this.getHttpApplicationJsonHeader());
        final ResponseEntity<VideoDataResponseDTO> response;
        try{
            response = this.restTemplate.exchange(this.videoNewsUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<>(){});
        } catch (Exception e){
            log.error("[VideoNewsServiceImpl:getVideoNews] Error during fetching video news: {}: {}", e.getMessage(), e);
            throw new VideoNewsException("Error during fetch video news: " + e.getMessage(), e);
        }

        if(!response.hasBody()){
            throw new VideoNewsException("Body was empty during request video news");
        }

        final Map<Category, String> staticCategoryNameIconMap = CategoryUtil.getStaticCategoryNameIconMap();
        return VideoDataMapper.mapToSecurityVideoInfoData(Objects.requireNonNull(response.getBody()), staticCategoryNameIconMap);
    }
}
