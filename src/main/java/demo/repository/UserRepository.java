package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.domain.User;
/**
 * UserRepository 类
 * @author Changsheng
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * 根据姓名进行模糊查询
	 * @param username
	 * @return
	 */
	User findByNameLike(String username);
}
