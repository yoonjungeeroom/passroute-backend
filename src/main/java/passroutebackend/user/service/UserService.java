package passroutebackend.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import passroutebackend.user.entity.User;
import passroutebackend.user.entity.AuthProvider;
import passroutebackend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long signUp(String email, String password, String name) {
        // 1. 이미 가입된 이메일인지 확인
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        // 2. 비밀번호 암호화 및 유저 생성
        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password)) // 암호화!
                .name(name)
                .provider(AuthProvider.LOCAL)
                .emailVerified(false)
                .build();

        // 3. DB 저장
        return userRepository.save(user).getId();
    }
}
