package com.mdr.utils;

import java.io.File;

public class ExtentReportGenerator {

    public static String getReportConfigPath()
    {
        return new File("./caps/extent-config.xml").getAbsolutePath();
    }
}
