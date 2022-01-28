package co.edu.escuelaing.ieti.lvl2api.service;

import co.edu.escuelaing.ieti.lvl2api.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private HashMap<String,User> users = new HashMap<>();

    @Override
    public User create(User user) {
        User ans=null;
        if (!users.containsKey(user.getId())){
            users.put(user.getId(),user);
            ans= user;
        }
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
    public User update(User user, String userId) {
        User ans=null;
        if (!users.containsKey(userId)){
            users.replace(userId,user);
            ans= user;
        }
        return ans;
    }
}
