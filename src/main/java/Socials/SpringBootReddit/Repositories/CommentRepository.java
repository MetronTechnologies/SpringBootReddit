package Socials.SpringBootReddit.Repositories;


import Socials.SpringBootReddit.Models.Comment;
import Socials.SpringBootReddit.Models.Post;
import Socials.SpringBootReddit.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
