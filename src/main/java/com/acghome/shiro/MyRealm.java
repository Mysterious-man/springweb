package com.acghome.shiro;

import com.acghome.entity.db1.Product;
import com.acghome.entity.db1.User;
import com.acghome.service.IProductService;
import com.acghome.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm{
	@Autowired
	private IUserService userService;


/*

	@Autowired
	private PermissionService permissionService;
*/

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		UsernamePasswordToken upt=(UsernamePasswordToken)arg0;
		String username = upt.getUsername();
        User user = userService.getUser(username);
		if(user==null){
			throw new UnknownAccountException("用户名错误");
		}
		Object principal=user;
		Object hashedCredentials=user.getPassWord();
//		ByteSource credentialsSalt=ByteSource.Util.bytes(MD5Utils.KEY);
		String realmName=getName();
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal, hashedCredentials, realmName);
//		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
/*//	完成授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		得到当前登陆的用户
		User loginUser = (User)principals.getPrimaryPrincipal();
		List<Permission> list = permissionService.getPermissionByLonginUserId(loginUser.getId());
//		System.out.println(list.size());
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		for (Permission permission : list) {
			System.out.println(permission);
			info.addStringPermission(permission.getSn());
		}
		return info;
	}*/

}
