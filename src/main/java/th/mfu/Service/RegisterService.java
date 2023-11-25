package th.mfu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.Domain.User;
import th.mfu.Model.RegisModel;
import th.mfu.Repository.UserRepository;

@Service
public class RegisterService {
    @Autowired
    UserRepository userRepository;
    public RegisModel register(String username,String password,String name){
        RegisModel result = new RegisModel();
        try {
            User regisUser = new User();
            regisUser.setUsername(username);
            regisUser.setPassword(password);
            regisUser.setName(name);
            userRepository.save(regisUser);
            result.setName(username);
            result.setPassword(password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
