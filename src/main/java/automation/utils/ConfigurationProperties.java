package automation.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

    @Value("${browser}")
    private String browser;

    @Value("${nomeutente}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${titolohomepage}")
    private String titolohomepage;

    @Value("${errormessage}")
    private String errormessage;

    @Value("${errorlocked}")
    private String errorlocked;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitolohomepage() {
        return titolohomepage;
    }

    public void setTitolohomepage(String titolohomepage) {
        this.titolohomepage = titolohomepage;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getErrorlocked() {
        return errorlocked;
    }

    public void setErrorlocked(String errorlocked) {
        this.errorlocked = errorlocked;
    }
}
