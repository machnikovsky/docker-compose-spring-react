package pl.machnikovsky.fullstacktest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.machnikovsky.fullstacktest.model.Blog;
import pl.machnikovsky.fullstacktest.service.BlogService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/blog")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(path = "getAll")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping(path = "getBlog/{blogid}")
    public Blog getBlog(@PathVariable(name = "blogid") Long blogid) {
        return blogService.getBlog(blogid);
    }

    @PostMapping(path = "post")
    public void postBlog(@RequestBody Blog blog) {
        blogService.postBlog(blog);
    }

    @DeleteMapping(path = "deleteBlog/{blogid}")
    public void deleteBlog(@PathVariable(name = "blogid") Long blogid) {
        blogService.deleteBlog(blogid);
    }
}
