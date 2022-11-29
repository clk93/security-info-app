package com.msag.securityinfo.gateway.generalnews.service;

import com.msag.securityinfo.common.exception.GeneralNewsException;
import com.msag.securityinfo.controller.data.internal.SecurityInfoData;
import com.msag.securityinfo.controller.data.internal.SecurityInfoNews;
import com.msag.securityinfo.gateway.generalnews.GeneralNewsMapper;
import com.msag.securityinfo.gateway.generalnews.data.GeneralNewsResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeneralNewsServiceImpl implements GeneralNewsService{

    @Value("${com.msag.securityInfo.gateway.generalNews.url}")
    private String generalNewsUrl;

    private final RestTemplate restTemplate;

    @Override
    public List<SecurityInfoNews> getGeneralNews() throws GeneralNewsException {
        log.debug("[GeneralNewsServiceImpl:getGeneralNews] Start to fetch general news");

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<?> entity = new HttpEntity<>(headers);

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

        return generalNews.stream()
                .map(GeneralNewsMapper::mapToSecurityInfoNews)
                .collect(Collectors.toList());

    }
}
