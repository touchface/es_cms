package top.touchface.es_cms.common.util;

import java.util.Base64;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 * JWT工具类
 * 
 * @author Jason
 *
 */
public class JwtUtil {
	private static final String SECRET="1234";
	
    /**
     * 使用Base64加密Key
     *
     * @return 加密后的的Key
     */
	private static SecretKey generalKey(){
		
		byte[] encodeKey=Base64.getDecoder().decode(SECRET);
		SecretKey key=new SecretKeySpec(encodeKey, 0,encodeKey.length,"AES");
		return key;
	}
	/**
	 * 创建JWT
	 * 
	 * @param claims 载荷
	 * @param expiresMillis 过期时间
	 * @return 加密生成的JWT
	 */
	public static String createJWT(Map<String,Object> claims,long expiresMillis){
		
		JwtBuilder builder=Jwts.builder();
		//设置JWT头
		builder.setHeaderParam("typ", "JWT");
		builder.setHeaderParam("alg", "HS256");
		//设置JWT的有效载荷
		claims.forEach(builder::claim);
		//设置签发时间
		long nowMillis=System.currentTimeMillis();
		builder.setIssuedAt(new Date(nowMillis));
		//设置过期时间
		if(expiresMillis>0){
			 long expMillis = nowMillis + expiresMillis;
			 builder.setExpiration(new Date(expMillis));
		}
		//设置加密算法
		builder.signWith(SignatureAlgorithm.HS256,generalKey());
		return builder.compact();
	}
	/**
	 * 解析JWT
	 * @param JWT 需要进行验证的JWT
	 * @return 有效载荷
	 */
	public static Claims parseJWT(String JWT) throws Exception{
		JwtParser parser=Jwts.parser();
		parser.setSigningKey(generalKey());
		return parser.parseClaimsJws(JWT).getBody();
	}
}
