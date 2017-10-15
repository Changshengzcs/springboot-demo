package demo.service;

import java.util.List;

import demo.domain.User;

/**
 * User 实体类
 * @author Changsheng
 *
 */
public interface UserService {
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	User savaUser(User user);
	/**
	 * 删除用户
	 * @param id
	 */
	void removeUser(Long id);
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	User updateUser(User user);
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	User getUserById(Long id);
	/**
	 * 根据姓名查询用户
	 * @param name
	 * @return
	 */
	User getUserByName(String name);
	/**
	 * 获取全部用户
	 * @return
	 */
	List<User> listUsers();
}
