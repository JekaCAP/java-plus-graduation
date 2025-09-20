package practicum.user.service;

import org.springframework.data.domain.Pageable;
import practicum.exception.ConflictException;
import practicum.exception.NotFoundException;
import practicum.user.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto newUserDto) throws ConflictException;

    UserDto getUserById(Long userId) throws NotFoundException;

    List<UserDto> getUsersByIdList(List<Long> ids, Pageable page);

    void deleteUser(Long userId);
}
