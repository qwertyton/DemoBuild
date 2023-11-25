package th.mfu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import th.mfu.Model.RegisModel;
import th.mfu.Service.RegisterService;


@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @PostMapping(value = "/regis", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisModel regis(@Validated @RequestBody RegisModel regisModel) {
         return registerService.register(regisModel.getUsername(),regisModel.getPassword(),regisModel.getName());
    }
}
