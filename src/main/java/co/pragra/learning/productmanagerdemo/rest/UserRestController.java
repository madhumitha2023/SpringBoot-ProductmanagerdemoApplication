//package co.pragra.learning.productmanagerdemo.rest;
//
//import co.pragra.learning.productmanagerdemo.entity.User;
//import co.pragra.learning.productmanagerdemo.repo.UserRepo;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.List;
//
//@RestController
//public class UserRestController {
//    private UserRepo repo;
//
//    public UserRestController(UserRepo repo) {
//        this.repo = repo;
//    }
//
//    @PostMapping("/api/user")
//    public User createUser(@RequestBody User user)
//    {
//        user.setCreateDate(new Date());
//        user.setUpdateDate(new Date());
//        return this.repo.save(user);
//    }
//
//    @GetMapping("/api/user")
//    public List<User> getUsers()
//    {
//        return this.repo.findAll();
//
//    }
//
//}
