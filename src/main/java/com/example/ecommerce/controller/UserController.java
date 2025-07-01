package com.example.ecommerce.controller;

import com.example.ecommerce.dto.AuthDTO;
import com.example.ecommerce.dto.LoginResponseDTO;
import com.example.ecommerce.dto.NovaSenhaDTO;
import com.example.ecommerce.dto.UserDTO;
import com.example.ecommerce.model.User;
import com.example.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO dto) {
        User user = userService.register(dto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthDTO dto) {
        LoginResponseDTO response = userService.login(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/nova-senha")
    public ResponseEntity<String> resetPassword(@RequestBody NovaSenhaDTO request) {
        System.out.println("Token: " + request.token());
        System.out.println("NovaSenha: " + request.novaSenha());

        boolean success = userService.resetPassword(request.token(), request.novaSenha());

        if (success) {
            return ResponseEntity.ok("Senha atualizada com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Token inválido ou expirado.");
        }
    }
}
