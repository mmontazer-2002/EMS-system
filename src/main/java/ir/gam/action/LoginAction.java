package ir.gam.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    @Override
    public String execute() {
        if ("admin".equals(username) && "admin".equals(password)) {
            return SUCCESS;
        }
        return ERROR;
    }
}
