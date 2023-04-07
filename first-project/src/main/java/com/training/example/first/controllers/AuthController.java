package com.training.example.first.controllers;

import com.training.example.first.dao.UsuarioDao;
import com.training.example.first.models.Usuario;
import com.training.example.first.utils.JWTUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/auth/")
@AllArgsConstructor
public class AuthController {
    // @Autowired
    private UsuarioDao usuarioDao;
    private JWTUtils jwtUtils;

    @PostMapping(value = "login")
    public String login(@RequestBody Usuario user) {
        Usuario result = usuarioDao.obtenerUsuarioCredenciales(user);
        if (Objects.nonNull(result)) {
            String token = this.jwtUtils.create(String.valueOf(result.getId()), result.getEmail());
            return token;
        }
        return "FAIL";
    }
}
