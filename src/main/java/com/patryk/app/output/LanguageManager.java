package com.patryk.app.output;

import java.util.Locale;
import java.util.ResourceBundle;

/**<p>
 * Service to provide different language versions of application
 * which uses .properties files to load given string from resources
 * default language is set to English
 *
 * @author Patryk Kucharski
 */
class LanguageManager {

    private ResourceBundle resourceBundleInstance = ResourceBundle.getBundle("OX", new Locale("eng",
            "Eng"));

    void setLanguageVersion(String languageCode, String countryCode) {
        resourceBundleInstance = ResourceBundle.getBundle("OX", new Locale(languageCode, countryCode));
    }

//    ResourceBundle getResourceBundleInstance() {
//        return resourceBundleInstance;
//    }
}
