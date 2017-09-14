package redis;

import java.util.ArrayList;
import java.util.List;

import entity.User;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;
import util.RedisUtils;

public class RedisTest2 {
	public static void main(String[] args) {
		Jedis jedis = RedisUtils.getJedis();
//		User user = new User("11",33,"男");
//		User user1 = new User("22",44,"女");
//		User user2 = new User("33",55,"男");
		List<User> users = new ArrayList<User>();
//		users.add(user);
//		users.add(user1);
//		users.add(user2);
//		JSONArray ja = JSONArray.fromObject(users);
//		System.out.println(ja.toString());
//		jedis.set("json", ja.toString());
		String str = jedis.get("json");
		System.out.println(str);
		JSONArray ja = JSONArray.fromObject(str);
		
		users = (List<User>) JSONArray.toCollection(ja, User.class);
		System.out.println("1");
	}
}
