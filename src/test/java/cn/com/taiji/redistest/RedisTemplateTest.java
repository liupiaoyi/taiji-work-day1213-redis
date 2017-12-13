/**   
 *       
 * 名称：RedisTemplateTest   
 * 描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午3:02:09 
 * @version       
 */ 

package cn.com.taiji.redistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.redisservice.RedisService;

/**        
 * 类名称：RedisTemplateTest   
 * 类描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午3:02:09 
 * @version      
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {
	
	@Autowired
	RedisService redisService;
	
	@Test
	public void test1() {
		//redisService.test();
		
		redisService.getTest();
		
	}
	
	

}
