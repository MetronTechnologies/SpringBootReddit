package Socials.SpringBootReddit.DataTransferObject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private Long id;
    private String text;
    private Instant createdDate;
    private Long postId;
    private String userName;
}
