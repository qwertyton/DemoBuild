package th.mfu.Controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.mfu.Model.LoginModel;
import th.mfu.Service.LoginService;



@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginModel login(@Validated @RequestBody LoginModel loginModel) {
        System.out.println(loginModel.getUsername());
        System.out.println(loginModel.getPassword());
        return loginService.login(loginModel.getUsername(), loginModel.getPassword());
    }

    @GetMapping("/station")
    public String showAdminForm() {
        return "station";
    }
}
