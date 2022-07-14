package Socials.SpringBootReddit.Repositories;


import Socials.SpringBootReddit.Models.Post;
import Socials.SpringBootReddit.Models.User;
import Socials.SpringBootReddit.Models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
