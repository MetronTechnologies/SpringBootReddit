package Socials.SpringBootReddit.Controller;


import Socials.SpringBootReddit.DataTransferObject.Requests.PostRequest;
import Socials.SpringBootReddit.DataTransferObject.Responses.PostResponse;
import Socials.SpringBootReddit.Services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
//@RequestMapping("/api/posts")
@Tag(name = "Posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    //    @PostMapping
    @RequestMapping(method = RequestMethod.POST, path = "/api/posts")
    @Operation(summary = "Create a post")
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return new ResponseEntity<>(CREATED);
    }

    //    @GetMapping
    @RequestMapping(method = RequestMethod.GET, path = "/api/posts")
    @Operation(summary = "Get all posts")
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return status(HttpStatus.OK).body(postService.getAllPosts());
    }

    //    @GetMapping("/{id}")
    @RequestMapping(method = RequestMethod.GET, path = "/api/posts/{id}")
    @Operation(summary = "Get posts by id")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        return status(HttpStatus.OK).body(postService.getPost(id));
    }

    //    @GetMapping("by-subreddit/{id}")
    @RequestMapping(method = RequestMethod.GET, path = "/api/posts/by-subreddit/{id}")
    @Operation(summary = "Get a post under a subreddit")
    public ResponseEntity<List<PostResponse>> getPostsBySubreddit(Long id) {
        return status(HttpStatus.OK).body(postService.getPostsBySubreddit(id));
    }

    //    @GetMapping("by-user/{name}")
    @RequestMapping(method = RequestMethod.GET, path = "/api/posts/by-user/{name}")
    @Operation(summary = "Get all the post for a user")
    public ResponseEntity<List<PostResponse>> getPostsByUsername(String username) {
        return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
    }

}
