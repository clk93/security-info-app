package com.msag.securityinfo.gateway.generalnews.service;

import com.msag.securityinfo.common.exception.GeneralNewsException;
import com.msag.securityinfo.app.data.SecurityInfoNews;
import com.msag.securityinfo.gateway.common.HttpConnectionProvider;
import com.msag.securityinfo.gateway.generalnews.GeneralNewsMapper;
import com.msag.securityinfo.gateway.generalnews.data.GeneralNewsResponseDTO;
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

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeneralNewsServiceImpl extends HttpConnectionProvider implements GeneralNewsService{

    @Value("${com.msag.securityInfo.gateway.generalNews.url}")
    private String generalNewsUrl;

    private final RestTemplate restTemplate;

    @Override
    public List<SecurityInfoNews> getGeneralNews() throws GeneralNewsException {
        log.debug("[GeneralNewsServiceImpl:getGeneralNews] Start to fetch general news");

        final HttpEntity<?> entity = new HttpEntity<>(this.getHttpApplicationJsonHeader());
        final ResponseEntity<List<GeneralNewsResponseDTO>> response;
        try{
            response = this.restTemplate.exchange(this.generalNewsUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<>(){});
        } catch (Exception e){
            log.error("[GeneralNewsServiceImpl:getGeneralNews] Error during fetching Data from general news: {}: {}", e.getMessage(), e);
            throw new GeneralNewsException("Error during fetch general news: " + e.getMessage(), e);
        }

        if(!response.hasBody()){
            throw new GeneralNewsException("Body was empty during request general news");
        }

        final List<GeneralNewsResponseDTO> generalNews = response.getBody();

        final Map<Category, String> staticCategoryNameIconMap = CategoryUtil.getStaticCategoryNameIconMap();
        return Objects.requireNonNull(generalNews).stream()
                .map(currentNews -> GeneralNewsMapper.mapToSecurityInfoNews(currentNews, staticCategoryNameIconMap))
                .collect(Collectors.toList());

    }
}
