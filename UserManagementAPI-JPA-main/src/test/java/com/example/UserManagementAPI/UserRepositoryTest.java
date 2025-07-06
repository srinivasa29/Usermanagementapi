package com.example.UserManagementAPI;

import com.example.UserManagementAPI.Model.User;
import com.example.UserManagementAPI.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        userRepository.deleteAllInBatch();
        user1 = new User("Alice Wonderland", "alice@gmail.com");
        user2 = new User("Bob gens", "Bob@gmail.com");
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    void testFindByEmailFound() {
        Optional<User> foundUser = userRepository.findByEmail(user1.getEmail());
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo(user1.getName());
        assertThat(foundUser.get().getEmail()).isEqualTo(user1.getEmail());
        assertThat(foundUser.get().getId()).isEqualTo(user1.getId());
    }
    @Test
    void testFindByEmailNotFound() {
        String NonExistingEmail="abfj@gmail.com";
        Optional<User> foundUser = userRepository.findByEmail(NonExistingEmail);
        assertThat(foundUser).isNotPresent();
    }
    @Test
    void testSaveUser(){
        User newUser=new User("charlie chaplin","Charlie@example.com");
        User saveduser=userRepository.save(newUser);
        assertThat(saveduser).isNotNull();
        assertThat(saveduser.getId()).isNotNull();
        assertThat(saveduser.getName()).isEqualTo("charlie chaplin");
        assertThat(saveduser.getEmail()).isEqualTo("charlie@example.com");
    }
    @Test
    void testUpdateUser(){
        String newName="Mannepula Srinivasa";
        String newEmail="Srinivasa@gmail.com";

        User user3=new User("Seenu","seenu@example.com");
        user3.setName(newName);
        user3.setEmail(newEmail);

        User updatedUser=userRepository.save(user3);

        assertThat(updatedUser.getId()).isNotNull();
        assertThat(updatedUser.getName()).isEqualTo(newName);
        assertThat(updatedUser.getEmail()).isEqualTo(newEmail);

    }
}
