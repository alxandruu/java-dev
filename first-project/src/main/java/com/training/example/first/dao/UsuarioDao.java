package com.training.example.first.dao;

import com.training.example.first.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsers();

    void deleteUser(Long id);

    void addUser(Usuario user);

    Usuario obtenerUsuarioCredenciales(Usuario user);
    Usuario getUserById(Long id);
}
