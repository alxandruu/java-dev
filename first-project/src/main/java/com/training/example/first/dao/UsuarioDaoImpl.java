package com.training.example.first.dao;

import com.training.example.first.models.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext // hace referencia a un contexto de la bd (no saber)
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsers() {
        log.debug("Getting Users");
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario getUserById(Long id) {
        log.debug("Getting User with ID => " + id);
        String query = "FROM Usuario WHERE id = :id";
        List<Usuario> result = entityManager.createQuery(query).setParameter("id", id).getResultList();
        return result.isEmpty()?null: result.get(0);
    }

    @Override
    public void deleteUser(Long id) {
        log.debug("Deleting User");
        Usuario user = entityManager.find(Usuario.class, id);
        entityManager.remove(user);
    }

    @Override
    public void addUser(Usuario user) {
        log.debug("Creating or Updating User");
        entityManager.merge(user); // actualizar y crear nuevas entidades
    }

    @Override
    public Usuario obtenerUsuarioCredenciales(Usuario user) {
        String query = "FROM Usuario WHERE email = :email AND password = :password";

        List<Usuario> usersList = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();

        return usersList.isEmpty() ? null : usersList.get(0);
    }
}
