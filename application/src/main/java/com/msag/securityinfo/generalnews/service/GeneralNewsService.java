package com.msag.securityinfo.generalnews.service;

import com.msag.securityinfo.generalnews.data.SecurityInfoData;
import com.msag.securityinfo.generalnews.exception.SecurityInfoException;

/**
 * Service to get General Informations for Security news
 */
@FunctionalInterface
public interface GeneralNewsService {

    /**
     * Get Security info news
     *
     * @return SecurityInfoData {@link SecurityInfoData} Result containing details of security info
     * @throws SecurityInfoException {@link SecurityInfoException} Exception during fetch of Security Info data
     */
    SecurityInfoData getSecurityInfoNews() throws SecurityInfoException;

}
