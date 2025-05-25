package com.orange.hrm.application.pages;

import com.orange.hrm.application.pageComponent.LoginPageComponent;
import com.orange.hrm.framework.WaitType;

import static com.orange.hrm.framework.web.commons.SeleniumUtils.*;

public final class LoginPage extends LoginPageComponent {

    public void setUserName(String username) {
        waitAndSendKeys(InputUserName, username);
    }

    public void setPassword(String password) {
        waitAndSendKeys(InputPassword, password);
    }

    public void clickLoginButton() {
        waitAndClick(ButtonLogin, WaitType.CLICKABLE);
    }

    public void clickForgotPassword() {
        waitAndClick(LinkForgotPassword,WaitType.CLICKABLE);
    }

}
