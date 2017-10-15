package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demo.domain.User;
import demo.service.UserService;
import demo.vo.Response;

/**
 * 用户控制器
 * @author Changsheng
 *
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping
	public ModelAndView userList(@RequestParam(value="async", required=false) boolean async,
			Model model) {
		List<User> list = userService.listUsers();
		System.out.println("async:"+async);
		model.addAttribute("userList", list);
		System.out.println(list);
		return new ModelAndView(async==true?"users/list::userModel":"users/list","userModel",model);
	}
	/**
	 * 获取编辑页面
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value="/edit/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return new ModelAndView("users/edit", "userModel", model);
	}
	/**
	 * 返回添加用户的视图
	 * @param model
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null, null, null));
		return new ModelAndView("users/add","userModel", model);
	}
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@PostMapping
	public ModelAndView add(User user) {
		System.out.println("使用了Post方法"+"user:"+user);
		userService.savaUser(user);
		return new ModelAndView("redirect:/users");
	}
	/**
	 * 删除用户
	 * ResponseEntity<T> 返回T封装的数据，等于@ResponseStatus与@ResponseBody
	 * @param id
	 * @param model
	 * @return
	 */
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Response> delete(@PathVariable("id") Long id,
			Model model) {
		System.out.println("Delete方法");
		try {
			userService.removeUser(id);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.ok(new Response(false, e.getMessage()));
		}
		return ResponseEntity.ok().body(new Response(true, "处理成功"));
	}
}
