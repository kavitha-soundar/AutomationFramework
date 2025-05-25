package com.orange.hrm.framework.web.constants;

public final class FrameworkConstants {
    private static final String PROPERTY_FILE_LOCATION = System.getProperty("user.dir") + "//Properties//";
    private static final String EXCEL_FILE_LOCATION = System.getProperty("user.dir") + "//TestData//";
    private static final String SCREENSHOT_LOCATION = System.getProperty("user.dir") + "//Screenshots//";
    private static final String FILES_LOCATION = System.getProperty("user.dir") + "//Files";
    private static final String REPORTS_LOCATION = System.getProperty("user.dir") + "//Reports//";
    private static final String REPORT_NAME = "//AutomationTestResults.html";
    private static final int WAIT_TIME = 30;
    private static final String USER_NAME = System.getProperty("user.name");


    public static String getPropertyLocation() {
        return PROPERTY_FILE_LOCATION;
    }

    public static String getExcelFileLocation() {
        return EXCEL_FILE_LOCATION;
    }

    public static String getScreenshotLocation() {
        return SCREENSHOT_LOCATION;
    }

    public static String getFilesLocation() {
        return FILES_LOCATION;
    }

    public static String getReportsLocation() {
        return REPORTS_LOCATION;
    }

    public static String getReportName() {
        return REPORT_NAME;
    }

    public static int getWaitTime() {
        return WAIT_TIME;
    }

    public static String getUserName() {
        return USER_NAME;
    }
}
