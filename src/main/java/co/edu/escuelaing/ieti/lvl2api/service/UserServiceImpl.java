package co.edu.escuelaing.ieti.lvl2api.service;

import co.edu.escuelaing.ieti.lvl2api.data.User;
import co.edu.escuelaing.ieti.lvl2api.dto.UserDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService{
    private HashMap<String,User> users = new HashMap<>();

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return null;
    }

    @Override
    public User create(UserDto user) {
        User ans= new User(users.size()+"",user.getName(),user.getEmail(),user.getLastName(),LocalDateTime.now().toString());
        users.put(ans.getId(),ans);
        return ans;
    }

    @Override
    public User findById(String id) {
        User ans=null;
        if (users.containsKey(id)){
            ans= users.get(id);
        }
        return ans;
    }

    @Override
    public List<User> getAll() {
        List<User> usersAns = new ArrayList<User>();
        for(User u:users.values()){
            usersAns.add(u);
        }
        return usersAns;
    }

    @Override
    public boolean deleteById(String id) {
        boolean ans = false;
        if (users.containsKey(id)){
            users.remove(id);
            ans= true;
        }
        return ans;
    }

    @Override
    public User update(UserDto user, String userId) {
        User ans=null;
        if (!users.containsKey(userId)){
            ans = new User(userId,user.getName(),user.getEmail(),user.getLastName(), LocalDateTime.now().toString());
            users.replace(userId,ans);

        }
        return ans;
    }
}
