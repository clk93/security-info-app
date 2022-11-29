package com.msag.securityinfo.generalnews.service;

import com.msag.securityinfo.generalnews.data.SecurityInfoData;
import com.msag.securityinfo.generalnews.exception.SecurityInfoException;

/**
 * Service to get General Informations for Security news
 */
@FunctionalInterface
public interface GeneralNewsService {

    SecurityInfoData getSecurityInfoNews() throws SecurityInfoException;

}
