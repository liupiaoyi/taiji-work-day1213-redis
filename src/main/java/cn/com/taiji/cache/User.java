/**   
 *       
 * 名称：User   
 * 描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午3:40:41 
 * @version       
 */ 

package cn.com.taiji.cache;

import java.io.Serializable;

/**        
 * 类名称：User   
 * 类描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月13日 下午3:40:41 
 * @version      
 */

public class User implements Serializable{

	/**
	 * Description:
	 * @author Administrator
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(int id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
	}

}
