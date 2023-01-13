package org.example;

import lombok.experimental.UtilityClass;

@UtilityClass

public class URLUtils {
    @Deprecated
    public static String urlConverter(String url) {
        StringBuilder res = new StringBuilder();
        if (url.contains("target")) {
            for (int i = 0; i < url.length(); i++) {
                if (url.charAt(i) == 't' && url.charAt(i + 1) == 'a' && url.charAt(i + 2) == 'r' && url.charAt(i + 3) == 'g' && url.charAt(i + 4) == 'e' && url.charAt(i + 5) == 't') {
                    if (url.length() > i + 14) {
                        String local = url.substring(i, i + 14);
                        if (local.equalsIgnoreCase("target/classes")) {
                            res.append("src/main/resources/");
                            i += 14;
                        }
                    }
                } else {
                    res.append(url.charAt(i));
                }
            }
            return res.toString();
        }
        return url;
    }
}
