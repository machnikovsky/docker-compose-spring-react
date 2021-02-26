package pl.machnikovsky.fullstacktest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.machnikovsky.fullstacktest.model.Blog;
import pl.machnikovsky.fullstacktest.repository.BlogRepository;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public void postBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public Blog getBlog(Long blogid) {
        return blogRepository.findById(blogid).orElseThrow(() -> new IllegalStateException("Blog not found"));
    }


    public void deleteBlog(Long blogid) {
        blogRepository.deleteById(blogid);
    }
}
