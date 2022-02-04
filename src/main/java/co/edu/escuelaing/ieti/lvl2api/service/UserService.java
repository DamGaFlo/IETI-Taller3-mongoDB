package co.edu.escuelaing.ieti.lvl2api.service;

import co.edu.escuelaing.ieti.lvl2api.data.User;
import co.edu.escuelaing.ieti.lvl2api.dto.UserDto;

import java.util.List;

public interface UserService {
    User create(UserDto user );

    User findById( String id );

    List<User> getAll();

    boolean deleteById( String id );

    User update( UserDto user, String userId );
}
