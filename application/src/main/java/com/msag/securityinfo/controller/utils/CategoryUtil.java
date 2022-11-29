package com.msag.securityinfo.controller.utils;

import java.util.HashMap;
import java.util.Map;

public final class CategoryUtil {

    // ToDO: use Enum for name instead of String
    /**
     * Map containing name of category and url of it's icon
     */
    public static Map<String, String> getStaticCategoryNameIconMap() {
        Map<String, String> enumMap = new HashMap<>();
        enumMap.put("Mobile Geräte", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Mobile-Geraete.png");
        enumMap.put("Phishing", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/phishing.png");
        enumMap.put("Allgemein", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Allgemein.png");
        enumMap.put("Passwörter", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Password.png");
        enumMap.put("Cloud", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Cloud.png");
        enumMap.put("Ransomware", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Ransomware_Viren.png");
        enumMap.put("President Scam", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Social-Engineering_President-Scam.png");
        enumMap.put("Video", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Video.png");
        enumMap.put("Private IT", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Allgemein.png");
        enumMap.put("Notfall", "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Alarm.png");
        return enumMap;
    }
}
