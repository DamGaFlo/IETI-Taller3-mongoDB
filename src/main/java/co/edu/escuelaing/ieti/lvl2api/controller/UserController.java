package co.edu.escuelaing.ieti.lvl2api.controller;


import co.edu.escuelaing.ieti.lvl2api.data.User;
import co.edu.escuelaing.ieti.lvl2api.dto.UserDto;
import co.edu.escuelaing.ieti.lvl2api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {
    private final UserService userService;


    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {

        return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);

    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById(@PathVariable String id ) {
        User user = userService.findById(id);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/filter/{like}")
    public ResponseEntity<List<User>> findByStringQuery(@PathVariable String like ) {
        return new  ResponseEntity<>(userService.findUsersWithNameOrLastNameLike(like), HttpStatus.ACCEPTED);
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ) {

        User user = userService.create(userDto);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        User user = userService.update(userDto,id);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        boolean state = userService.deleteById(id);
        if(state==false){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }
}


