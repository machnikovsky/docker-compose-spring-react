package pl.machnikovsky.fullstacktest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.machnikovsky.fullstacktest.model.BlogUser;

import java.util.Optional;

@Repository
public interface BlogUserRepository extends JpaRepository <BlogUser, Long> {

    Optional<BlogUser> findById(Long userid);


}
