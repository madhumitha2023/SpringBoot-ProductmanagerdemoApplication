package co.pragra.learning.productmanagerdemo.service;

import co.pragra.learning.productmanagerdemo.entity.User;
import co.pragra.learning.productmanagerdemo.exception.InvalidUserDataException;
import co.pragra.learning.productmanagerdemo.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User createUser(User user)
    {
        if(user == null)
        {
            throw new InvalidUserDataException("User cannot be null");
        }
        if(user.getFirstName() == null || user.getFirstName().isEmpty())
        {
            throw new InvalidUserDataException("First name cannot be null or empty");
        }

        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        return repo.save(user);
    }

    public User updateUser (User user)
    {
        if(user == null)
        {
            throw new InvalidUserDataException("User cannot be null");
        }
        Optional<User> userOptional = repo.findById(user.getId());
        userOptional.orElseThrow(()->new InvalidUserDataException("User not found"));
        User dbUser = userOptional.get();
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        dbUser.setUpdateDate(new Date());
        return repo.save(dbUser);
    }

    public List<User> findAllByFilters(Optional<String> firstName, Optional<String> lastName)
    {
        if(firstName.isPresent() && lastName.isPresent())
        {
            return repo.findAllByFirstNameAndLastName(firstName.get(), lastName.get());
        }
        if(firstName.isPresent())
        {
            return repo.findAllByFirstName(firstName.get());
        }
        if(lastName.isPresent())
        {
            return repo.findAllByLastName(lastName.get());
        }
        return repo.findAll();
    }

    public Optional<User> findById(Long id){
        return repo.findById(id);
    }
}
