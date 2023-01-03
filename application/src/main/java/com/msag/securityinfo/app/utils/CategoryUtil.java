package com.msag.securityinfo.app.utils;

import java.util.EnumMap;
import java.util.Map;

import static com.msag.securityinfo.app.utils.Category.*;


public final class CategoryUtil {

    private CategoryUtil() {
        // not used
    }

    /**
     * Map containing name of category and url of it's icon
     */
    public static Map<Category, String> getStaticCategoryNameIconMap() {
        final EnumMap<Category, String> enumMap = new EnumMap<>(Category.class);
        enumMap.put(MOBILE_DEVICES, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Mobile-Geraete.png");
        enumMap.put(PHISHING, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/phishing.png");
        enumMap.put(GENERAL, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Allgemein.png");
        enumMap.put(PASSWORDS, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Password.png");
        enumMap.put(CLOUD, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Cloud.png");
        enumMap.put(RANSOMWARE, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Ransomware_Viren.png");
        enumMap.put(PRESIDENT_SCAM, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Social-Engineering_President-Scam.png");
        enumMap.put(VIDEO, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Video.png");
        enumMap.put(PRIVATE_IT, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Allgemein.png");
        enumMap.put(EMERGENCY, "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Alarm.png");
        return enumMap;
    }
}
