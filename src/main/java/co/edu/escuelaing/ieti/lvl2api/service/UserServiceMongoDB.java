package co.edu.escuelaing.ieti.lvl2api.service;

import co.edu.escuelaing.ieti.lvl2api.data.User;
import co.edu.escuelaing.ieti.lvl2api.dto.UserDto;
import co.edu.escuelaing.ieti.lvl2api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService
{

    private final UserRepository userRepository;


    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {

        List<User> user = userRepository.findByNameLikeOrLastNameLike(queryText,queryText);
        
        return user;
    }

    @Override
    public User create(UserDto user )
    {
        User userCreated = userRepository.findByEmail(user.getEmail()).orElse(null);
        User ans = null;
        if (userCreated==null){
            ans = new User(user.getName(),user.getEmail(),user.getLastName(), LocalDateTime.now().toString());
            ans = userRepository.save(ans);
        }

        return ans;
    }

    @Override
    public User findById( String id )
    {
        Optional<User> optional= userRepository.findById(id);
        User user = optional.orElse(null);
        return user;
    }

    @Override
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById( String id )
    {
        boolean ans = false;
        ans = userRepository.existsById(id);
        if(ans){
            userRepository.deleteById(id);
        }
        return ans;
    }

    @Override
    public User update(UserDto user, String id )
    {
        boolean ans = userRepository.existsById(id);
        User userUpdated = null;
        if(ans){
            userRepository.save(new User(id,user.getName(),user.getEmail(),user.getLastName(), LocalDateTime.now().toString()));
        }
        return userUpdated;
    }
}
