package com.orange.hrm.application.pages;

import com.orange.hrm.application.pageComponent.DashboardPageComponent;
import com.orange.hrm.framework.web.commons.SeleniumUtils;

import static com.orange.hrm.framework.web.commons.SeleniumUtils.*;

public final class DashBoardPage extends DashboardPageComponent {

    public String IsDashBoardPageDisplayed() {
        String dashboardname = "";
       if(isDisplayed(TEXT_DASHBOARD))
           dashboardname= getText(TEXT_DASHBOARD);
        return dashboardname;
    }
}
