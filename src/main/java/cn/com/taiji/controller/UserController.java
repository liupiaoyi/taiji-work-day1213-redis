/**   
 *       
 * 名称：UserController   
 * 描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午4:00:52 
 * @version       
 */ 

package cn.com.taiji.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.taiji.cache.User;
import cn.com.taiji.redisservice.RedisService;
import net.minidev.json.JSONArray;



/**        
 * 类名称：UserController   
 * 类描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午4:00:52 
 * @version      
 */
@Controller
public class UserController {
	
	@Autowired
	RedisService redisService;
	
	@RequestMapping("toAddUser")
	public String toAddUser() {
		return "addUser";
	}
	
	@RequestMapping("/addUser11")
	public String addUser(User user,Model model) {
		redisService.addUser(user);
		
		List<User> list = new ArrayList<>();
		list.add(user);
		
		model.addAttribute("list",list);
		model.addAttribute("msg","new data");
		//return "showUser";
		return "addUser";
	}
	
	
	@RequestMapping("/showUsers")
	@ResponseBody
	public Object showUsers() {
		List<User> list = redisService.showUser();
		list.forEach(System.out::println);
		
		//model.addAttribute("list", list);
		//String json = JSONArray.toJSONString(list);
		//return "showUser";
		//String json = JSONArray.fromObject(list);
		
		return list;
	}

}
