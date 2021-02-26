package pl.machnikovsky.fullstacktest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.machnikovsky.fullstacktest.model.Blog;
import pl.machnikovsky.fullstacktest.model.BlogUser;
import pl.machnikovsky.fullstacktest.service.BlogService;
import pl.machnikovsky.fullstacktest.service.BlogUserService;

import java.util.List;

@RestController
@RequestMapping("admin/api")
public class AdminApiController {

    private final BlogUserService blogUserService;
    private final BlogService blogService;

    @Autowired
    public AdminApiController(BlogUserService blogUserService, BlogService blogService) {
        this.blogUserService = blogUserService;
        this.blogService = blogService;
    }

    @GetMapping(path = "getUsers")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<BlogUser> getAllUsers() {
        return blogUserService.getAllUsers();
    }

    @PostMapping(path = "addUser")
    @PreAuthorize("hasAuthority('blog:write')")
    public void addUser(@RequestBody BlogUser blogUser) {
        blogUserService.addUser(blogUser);
    }


    @GetMapping(path = "getBlogs")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @PostMapping(path = "addBlog")
    @PreAuthorize("hasAuthority('blog:write')")
    public void addBlog(@RequestBody Blog blog) {
        blogService.postBlog(blog);
    }

}
