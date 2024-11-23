package spring.integration.repository;

import com.sun.source.tree.AssertTree;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import spring.database.entity.Role;
import spring.database.repository.UserRepository;
import spring.integration.annotation.IT;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkPageable(){
        var pageable = PageRequest.of(0, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pageable);
        slice.forEach(user -> System.out.println(user.getId()));

        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(user -> System.out.println(user.getId()));
        }
    }

    @Test
    void findFirst3By(){
        var users = userRepository.findFirst3By(Sort.by("id").descending());
        assertTrue(!users.isEmpty());
        assertThat(users).hasSize(3);
    }

    @Test
    void checkProjections(){
        var users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(2);
    }

    @Test
    void updateRoleTest(){
        var entitiy1 = userRepository.findById(1L);
        assertEquals(Role.ADMIN, entitiy1.get().getRole());
        var result = userRepository.updateRole(Role.USER,1L,5L);
        assertEquals(2,result);
        var entitiy2 = userRepository.findById(1L);
        assertEquals(Role.USER, entitiy2.get().getRole());
    }


    @Test
    void findAllByFirstnameContainingAndLastnameContaining(){
        var user = userRepository.findAllByFirstnameContainingAndLastnameContaining("a","a");
        assertTrue(!user.isEmpty());
        assertThat(user).hasSize(3);
    }



}
