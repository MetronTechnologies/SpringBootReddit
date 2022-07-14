package Socials.SpringBootReddit.Controller;


import Socials.SpringBootReddit.DataTransferObject.DTOs.CommentsDto;
import Socials.SpringBootReddit.Services.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping("/api/comments")
@Tag(name = "Comments")
@AllArgsConstructor
public class CommentsController {
    private final CommentService commentService;

    //    @PostMapping
    @RequestMapping(method = RequestMethod.POST, path = "/api/comments")
    @Operation(summary = "Comment creation")
    public ResponseEntity<Void> createComment(@RequestBody CommentsDto commentsDto) {
        commentService.save(commentsDto);
        return new ResponseEntity<>(CREATED);
    }

    //    @GetMapping("/by-post/{postId}")
    @RequestMapping(method = RequestMethod.GET, path = "/api/comments/by-post/{postId}")
    @Operation(summary = "Get comments under a post")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@PathVariable Long postId) {
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForPost(postId));
    }

    //    @GetMapping("/by-user/{userName}")
    @RequestMapping(method = RequestMethod.GET, path = "/api/comments/by-user/{username}")
    @Operation(summary = "Get all the comments made by a user")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForUser(@PathVariable String userName) {
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForUser(userName));
    }

}
