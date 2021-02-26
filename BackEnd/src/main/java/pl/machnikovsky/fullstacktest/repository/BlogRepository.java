package pl.machnikovsky.fullstacktest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.machnikovsky.fullstacktest.model.Blog;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository <Blog, Long> {

    Optional<Blog> findById(Long blogid);
}
