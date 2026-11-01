package com.user.repository.user;

import com.user.model.User;
import com.user.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryimpl implements UserRepository {
    private static String USER_TABLE_NAME = "com.user/user";

    @Autowired
     private JdbcTemplate jdbcTemplate;

    @Override
    public Long createUser(User user) throws Exception {
        String sql = "INSERT INTO users " +
                "(first_name, last_name, email, age, address) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(
                    sql,
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getAge(),
                    user.getAddress()
            );
            return user.getId();
        } catch (Exception e) {
            throw new Exception("Something went wrong",e);
        }
    }
    @Override
    public void updateUser(User user) throws Exception {
        String sql = "UPDATE users SET " +
                " first_name = ?, last_name = ?, email = ?, age = ?,address = ?,registered = ? WHERE id =?";
        try {
            jdbcTemplate.update(
                    sql,
                   user.getFirstName(),
                    user.getLastName(),
                   user.getEmail(),
                    user.getAge(),
                    user.getAddress(),
                    user.isRegistered(),
                    user.getId()

            );

        } catch (Exception e) {
            throw new Exception("Something went wrong",e);
        }
    }
    @Override
    public void deleteUserById(Long id) throws Exception {
        String sql = "DELETE FROM users" +
                " WHERE id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    id
            );
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
    }
    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM users "  +
                " WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new UserMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Not found");
            return null;
        }
    }
    @Override
    public void registerUser(Long id) throws Exception {
        String sql = "UPDATE users SET registered = ? WHERE id = ?";

        try {
            jdbcTemplate.update(sql, true, id);
        } catch (Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }
}
