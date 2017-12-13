/**   
 *       
 * 名称：RedisService   
 * 描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午2:50:48 
 * @version       
 */ 

package cn.com.taiji.redisservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import cn.com.taiji.cache.User;

/**        
 * 类名称：RedisService   
 * 类描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午2:50:48 
 * @version      
 */
@Service
public class RedisService {
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate; 
	
	public String test() {
		String uuid = UUID.randomUUID().toString();
		stringRedisTemplate.opsForValue().set("string1", "s1");;
//		redisTemplate.opsForValue().set(uuid, "调试", 1000);
//		redisTemplate.opsForValue().set("ttt", "t123");
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "zhangsan");
		map.put("age", "13");
		redisTemplate.opsForHash().putAll("user1:003", map);
		stringRedisTemplate.opsForHash().putAll("user1:004", map);
		
		System.out.println("this's a test=="+redisTemplate.opsForValue().get("ttt") );
		
		return "aaa";
	}
	
	
	public void getTest() {
		//User user = new User(1,"yi","163");
//		String uuid = UUID.randomUUID().toString();
//		redisTemplate.opsForValue().set(uuid, "调试", 1000);
//		System.out.println(redisTemplate.opsForValue().get(uuid));
	}
	
	
	/**
	 * 
	 * @Description: 向redis中存储对象数据
	 * @param user void  
	 * @throws
	 * @author Administrator
	 * @date 2017年12月13日
	 */
	public void addUser(User user) {
//		Map<String, String> map = new HashMap<>();
//		map.put("id", user.getId()+"");
//		map.put("name", user.getUsername());
//		map.put("email", user.getEmail());
//		stringRedisTemplate.opsForHash().putAll("user:007"+user.getId(), map);
		
		redisTemplate.opsForValue().set("user:"+user.getId(), user);
	}
	
	
	public List<User> showUser() {
		List<User> userList = new ArrayList<>();
		User user = new User();
		for(int i=0; i<20; i++ ) {
			String key = "user:"+i;
				//if(redisTemplate.persist(key)) {
			user = (User)redisTemplate.opsForValue().get(key);
			if( user!=null ) {
				userList.add(user);	
			}
				//}
		}		
		return userList;
	}

	
	
}
