package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.User;
import demo.repository.UserRepository;
/**
 * User 接口
 * @author Changsheng
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional  // 实物管理
	@Override
	public User savaUser(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	@Override
	public void removeUser(Long id) {
		userRepository.delete(id);
	}
	
	@Transactional
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.findByNameLike(name);
	}

}
