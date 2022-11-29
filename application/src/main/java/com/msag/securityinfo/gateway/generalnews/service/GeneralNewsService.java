package com.msag.securityinfo.gateway.generalnews.service;

import com.msag.securityinfo.common.exception.GeneralNewsException;
import com.msag.securityinfo.controller.data.internal.SecurityInfoNews;

import java.util.List;

/**
 * Service to fetch general security informations
 */
@FunctionalInterface
public interface GeneralNewsService {

    /**
     * Get list of general news
     *
     * @return List of SecurityInfoNews {@link SecurityInfoNews} Result containing security info and details
     * @throws GeneralNewsException {@link GeneralNewsException} Exception during fetch of general data
     */
    List<SecurityInfoNews> getGeneralNews() throws GeneralNewsException;

}
