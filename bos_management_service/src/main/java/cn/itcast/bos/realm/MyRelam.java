package cn.itcast.bos.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.bos.dao.system.PermissionDao;
import cn.itcast.bos.dao.system.RoleDao;
import cn.itcast.bos.dao.system.UserDao;
import cn.itcast.bos.domain.system.Permission;
import cn.itcast.bos.domain.system.Role;
import cn.itcast.bos.domain.system.User;

@Service("myRealm")
public class MyRelam extends AuthorizingRealm{
	
	@Autowired
	private UserDao ud;
	
	/*@Autowired
	private RoleDao rs;*/
	
	@Autowired
	private PermissionDao pd;
	
	@Override
	//授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection paramPrincipalCollection) {
		//获得user对象    源码内部就是iterator.next()方法迭代出第一个对象   因为只存了一个user对象  可以直接用user对象接收
		User user = (User) paramPrincipalCollection.getPrimaryPrincipal();
		//调用dao查询user对象的权限信息  和角色信息
		//List<Role>roles = rs.findByUser(user.getId());
		//创建授权信息对象  将user对象的权限  添加到授权信息对象中  
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		/*if(roles!=null&&roles.size()>0){
			for (Role role : roles) {
				info.addRole(role.getKeyword());
			}
		}*/
		
		List<Permission>permissions = pd.findByUser(user.getId());
		if(permissions!=null&&permissions.size()>0){
			for (Permission permission : permissions) {
				info.addStringPermission(permission.getKeyword());
			}
		}
		
		//info.addStringPermission("courier");
		
		//info.addStringPermission("hehe");
		//info.addStringPermissions(permissions);   授予多权限的时候用的   传的是个集合
		//返回授权信息对象
		return info;
	}

	@Override
	//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken paramAuthenticationToken) throws AuthenticationException {
		//取出用户名和密码
		UsernamePasswordToken token = (UsernamePasswordToken) paramAuthenticationToken;
		String username = token.getUsername();
		User user = ud.findByUsername(username);
		//根据用户名从数据查出用户对象
		if(user!=null){
			//查到了=》比较查到用户的密码和输入的密码(只需要传递参数，框架会校验)
			//参数1：登陆的标识(登陆的对象，因为一般都是把登陆的对象存到session中) 参数2：是正确的密码(从数据库查到的密码) 参数三:随便写  给当前的relam返回的认证对象起个名字  
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
			return info;
		}else{
			//没查到=》返回一个null
			System.out.println("没查到");
			return null;
		}
	}

}
