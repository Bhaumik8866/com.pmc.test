package org.example;

import org.apache.commons.lang.StringUtils;
import org.jsoup.internal.StringUtil;
import org.testng.annotations.Test;

public class ApacheUtilsTest {

    @Test
    public void apacheUtils()
    {
        String browser="Teststring " ;
        boolean flag=browser.isEmpty();
        System.out.println(flag);
        System.out.println(StringUtils.containsAny(browser,"//"));
        System.out.println(StringUtils.containsAny(browser,"//.#$% "));
        System.out.println(StringUtils.startsWith(StringUtils.trim(browser),"e"));
        System.out.println(StringUtils.startsWithAny(" abcxyz", new String[] {null, "a", ""}));
//      System.out.println(StringUtils.indexOfAny("zzabyycdxx", ['b', 'y']));

    }
}
