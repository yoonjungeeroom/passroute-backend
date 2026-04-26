package passroutebackend.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import passroutebackend.user.dto.SignUpRequest;
import passroutebackend.user.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        Long userId = userService.signUp(
                request.getEmail(),
                request.getPassword(),
                request.getName()
        );

        return ResponseEntity.ok("회원가입 성공! ID: " + userId);
    }
}