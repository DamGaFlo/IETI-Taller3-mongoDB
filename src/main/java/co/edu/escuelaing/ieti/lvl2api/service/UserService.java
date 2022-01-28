package co.edu.escuelaing.ieti.lvl2api.service;

import co.edu.escuelaing.ieti.lvl2api.data.User;

import java.util.List;

public interface UserService {
    User create(User user );

    User findById( String id );

    List<User> getAll();

    boolean deleteById( String id );

    User update( User user, String userId );
}
