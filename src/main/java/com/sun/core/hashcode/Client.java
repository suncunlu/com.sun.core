package com.sun.core.hashcode;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author :suncunlu
 * @date :2019-03-18 14:25:15
 * @description :重写equals，必须重写hashcode的原因。
 * 				hashSet，添加对象时，根据equals和hashcode判断是否已经存在这对象。
 * 				相同的id，可以有不同的名称。此时要求只要id相同，就视为相同。因此重写equals方法。
 * 				而两个对象的hashcode却不同，因此 id相同，名称不同的对象，仍然视为两个不同的对象被存入hashset中。
 * 				实际上只需存入一个即可。
 * 				
 * 				再如以对象为key的hashmap，原理也是如此。
 */
@Slf4j
public class Client {
@Test
public void testHashEquals() {
	UserInfo info = new UserInfo(123, "晓明", "北京");
	UserInfo info2 = new UserInfo(123, "大明", "北京");
	int hashCode = info.hashCode();
	int hashCode2 = info2.hashCode();
	
	
	//equals相等 hashcode不相等
	log.info(hashCode+"");
	log.info(hashCode2+"");
	log.info(info.equals(info2)+"");
	HashSet<UserInfo> set = new HashSet<UserInfo>();
	set.add(info);
	set.add(info2);
	for (UserInfo userInfo : set) {
		System.out.println(userInfo.toString());
	}
}
}
