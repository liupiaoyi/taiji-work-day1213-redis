/**   
 *       
 * 名称：RedisConfiguration   
 * 描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午2:14:07 
 * @version       
 */ 

package cn.com.taiji.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;







/**        
 * 类名称：RedisConfiguration   
 * 类描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午2:14:07 
 * @version      
 */
@Configuration
@EnableCaching
@PropertySource("classpath:/redis.properties")
public class RedisConfiguration extends CachingConfigurerSupport {
	
	Logger log = LoggerFactory.getLogger(RedisConfiguration.class);
	
	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.prot}")
	private int port;
	
	@Value("${spring.redis.timeout}")
	private int timeout;
	
	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;
	
	@Value("${spring.redis.pool.max-wait}")
	private long maxWaitMillis;
	
	@Value("${spring.redis.password}")
	private String password;

	
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		System.out.println("host===="+host);
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

		redisConnectionFactory.setHostName(host);
		redisConnectionFactory.setPort(port);
		//redisConnectionFactory.setPassword(password);
		redisConnectionFactory.setPoolConfig(jedisPoolConfig);
		
		return redisConnectionFactory;
	}
	
	
	
	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setKeySerializer( new StringRedisSerializer() );
		
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	
	
	/**
	 * 缓存管理器
	 */
	@Bean
	public CacheManager cacheManager() {
		RedisCacheManager cacheManager = new RedisCacheManager( redisTemplate() );
		
		cacheManager.setDefaultExpiration(timeout); //缓存默认时间
		cacheManager.setLoadRemoteCachesOnStartup(true); //是否开启时加载缓存
		cacheManager.setUsePrefix(true); //默认加载前缀
		
		return cacheManager;
	}
	
	
}
