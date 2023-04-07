package com.training.example.first.controllers;

import com.training.example.first.dao.UsuarioDao;
import com.training.example.first.models.Usuario;
import com.training.example.first.utils.JWTUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@AllArgsConstructor
public class UsuariosController {
    // @Autowired
    private UsuarioDao usuarioDao;

    private JWTUtils jwtUtils;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<Usuario> getUsers(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String token) {
        String userId = this.jwtUtils.getKey(token);
        if (!checkToken(token)) {
            return null;
        }
        return this.usuarioDao.getUsers();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void addUser(@RequestBody Usuario user, @RequestHeader(value = HttpHeaders.AUTHORIZATION) String token) {
        if (!checkToken(token)) {
            usuarioDao.addUser(user);
        }
    }

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.GET)
    public Usuario getUser(@PathVariable Long id, @RequestHeader(value = HttpHeaders.AUTHORIZATION) String token) throws Exception {
        if (checkToken(token)) {
            Usuario result = this.usuarioDao.getUserById(id);
            if(Objects.nonNull(result)) {
                return result;
            }else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id, @RequestHeader(value = HttpHeaders.AUTHORIZATION) String token) {
        if (!checkToken(token)) {
            log.info("Deleting user with id -> " + id);
            usuarioDao.deleteUser(id);
        }
    }

    private boolean checkToken(String token) {
        String userId = jwtUtils.getKey(token);
        return Objects.nonNull(userId);
    }
}
