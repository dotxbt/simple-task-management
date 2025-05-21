package com.testcode.task_apps.service.impl;
import com.testcode.task_apps.components.JwtUtils;
import com.testcode.task_apps.configuration.ErrorHandlerException;
import com.testcode.task_apps.helper.EnvResource;
import com.testcode.task_apps.model.ErrorMessage;
import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.UserDao;
import com.testcode.task_apps.model.dto.UserDto;
import com.testcode.task_apps.repository.intfc.UserRepository;
import com.testcode.task_apps.service.intfc.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtil;

    @Override
    public ResponseData<UserDto> login(UserDao account) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            account.getEmail(), account.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            long maxAge = Long.parseLong(new EnvResource().get("env.max.age.token"));
            String token = jwtUtil.generateToken(account.getEmail(), maxAge);
            String refreshToken = jwtUtil.generateToken(account.getEmail(), maxAge * 30L);
            return ResponseData.<UserDto>builder().data(UserDto.builder()
                            .email(account.getEmail())
                            .token(token)
                            .refreshToken(refreshToken)
                    .build()).build();
        } catch (Exception e) {
           throw new ErrorHandlerException(ErrorMessage.builder()
                   .status(HttpStatus.FORBIDDEN)
                   .message("Invalid Username or password")
                   .build());
        }
    }

    @Override
    public ResponseData<UserDao> register(UserDao account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        UserDao res = userRepository.create(account);
        res.setPassword(null);
        return ResponseData.<UserDao>builder()
                .data(res)
                .build();
    }
}
