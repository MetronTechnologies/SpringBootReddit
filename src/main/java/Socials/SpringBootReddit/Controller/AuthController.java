package Socials.SpringBootReddit.Controller;


import Socials.SpringBootReddit.DataTransferObject.Requests.LoginRequest;
import Socials.SpringBootReddit.DataTransferObject.Requests.RefreshTokenRequest;
import Socials.SpringBootReddit.DataTransferObject.Requests.RegisterRequest;
import Socials.SpringBootReddit.DataTransferObject.Responses.AuthenticationResponse;
import Socials.SpringBootReddit.Services.AuthService;
import Socials.SpringBootReddit.Services.RefreshTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    @Operation(summary = "User sign up or registration")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful", OK);
    }


    @GetMapping("accountVerification/{token}")
    @Operation(summary = "Verify and activate a user's account after sign up")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", OK);
    }


    @PostMapping("/login")
    @Operation(summary = "User Login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


    @PostMapping("/refresh/token")
    @Operation(summary = "Refresh a user's expired token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }


    @PostMapping("/logout")
    @Operation(summary = "User logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }

}
