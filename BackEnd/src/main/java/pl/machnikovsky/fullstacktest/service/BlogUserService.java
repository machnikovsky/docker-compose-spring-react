package pl.machnikovsky.fullstacktest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.machnikovsky.fullstacktest.model.BlogUser;
import pl.machnikovsky.fullstacktest.repository.BlogUserRepository;

import java.util.List;

@Service
public class BlogUserService {

    private final BlogUserRepository blogUserRepository;

    @Autowired
    public BlogUserService(BlogUserRepository blogUserRepository) {
        this.blogUserRepository = blogUserRepository;
    }

    public List<BlogUser> getAllUsers() {
        return blogUserRepository.findAll();
    }

    public void addUser(BlogUser blogUser) {
        blogUserRepository.save(blogUser);
    }

    public BlogUser getUser(Long userid) {
        return blogUserRepository.findById(userid).orElseThrow(() -> new IllegalStateException("User not found"));
    }
}
