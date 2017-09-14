package redis;

import java.util.ArrayList;
import java.util.List;

import entity.User;
import redis.clients.jedis.Jedis;
import util.RedisUtils;
import util.SerializeUtils;

public class RedisTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException{
		Jedis jedis = RedisUtils.getJedis();
		jedis.select(1);
//		User user = new User("11",33,"男");
//		User user1 = new User("22",44,"女");
//		User user2 = new User("33",55,"男");
		List<User> users = new ArrayList<User>();
//		jedis.set("rec1".getBytes(), SerializeUtils.serialize(user));
//		jedis.set("rec2".getBytes(), SerializeUtils.serialize(user1));
//		jedis.set("rec3".getBytes(), SerializeUtils.serialize(user2));
		List<byte[]> bytes = jedis.mget("rec1".getBytes(),"rec2".getBytes(),"rec3".getBytes());
		
		byte a[] = new byte[bytes.size()];
		for(int i = 0;i < bytes.size();i++){
			users.add((User) SerializeUtils.deSerialize(bytes.get(i)));
		}
		//		byte b[] = jedis.get("user".getBytes());
//		user = (User) SerializeUtils.deSerialize(b);
//		users = (List<User>) SerializeUtils.unserializeList(b);
		
		System.out.println(users);
		RedisUtils.returnResource(jedis);
	}
}
