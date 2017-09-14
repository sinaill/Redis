package redisdao;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired  
    protected RedisTemplate<String,String> redisTemplate;
    
    public void test(){
    	Map<Object, Object> m = redisTemplate.opsForHash().entries("aa");
    	
    	for(Entry<Object, Object> entry:m.entrySet()){
    		System.out.println(entry.getKey()+ " " + entry.getValue());
    	}
//    	System.out.println(redisTemplate == null);
//    	System.out.println(redisTemplate);
//    	System.out.println(redisTemplate.getExpire("aa"));
    
    }
}
