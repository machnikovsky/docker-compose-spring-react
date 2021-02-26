package pl.machnikovsky.fullstacktest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.machnikovsky.fullstacktest.model.BlogUser;
import pl.machnikovsky.fullstacktest.service.BlogUserService;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class BlogUserController {

    private final BlogUserService blogUserService;

    @Autowired
    public BlogUserController(BlogUserService blogUserService) {
        this.blogUserService = blogUserService;
    }

    @GetMapping(path = "getAll")
    public List<BlogUser> getAllUsers() {
        return blogUserService.getAllUsers();
    }

    @GetMapping(path = "getUser/{userid}")
    public BlogUser getUser(@PathVariable(name = "userid") Long userid) {
        return blogUserService.getUser(userid);
    }

    @PostMapping(path = "post")
    public void addUser(@RequestBody BlogUser blogUser) {
        blogUserService.addUser(blogUser);
    }
}
