package Socials.SpringBootReddit.Controller;


import Socials.SpringBootReddit.DataTransferObject.DTOs.VoteDto;
import Socials.SpringBootReddit.Services.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/votes")
@Tag(name = "Votes")
@AllArgsConstructor
public class VoteController {

    private final VoteService voteService;

    //    @PostMapping
    @RequestMapping(method = RequestMethod.POST, path = "/api/votes")
    @Operation(summary = "Make a vote")
    public ResponseEntity<Void> vote(@RequestBody VoteDto voteDto) {
        voteService.vote(voteDto);
        return new ResponseEntity<>(OK);
    }
}