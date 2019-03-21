package com.sun.core.hash;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


import com.google.common.base.Strings;

public class VirtualHashNode {
	
	private static String[] servers= {"192.168.0.0:111","192.168.0.1:111","192.168.0.2:111","192.168.0.3:111","192.168.0.4:111","192.168.0.5:111","192.168.0.6:111"};
	
	private static List<String> realNodes = new LinkedList<String>();
	
	private static SortedMap<Integer,String> virtualNodes = new TreeMap<Integer,String>();
	
	private static final int VIRTUAL_NODES = 5;
	
	static {
		for (int i = 0; i < servers.length; i++) {
			realNodes.add(servers[i]);
		}
		for(String str:realNodes) {
			for(int i=0;i<VIRTUAL_NODES;i++) {
				String virtualName= str + "&&VN" + String.valueOf(i);
				int hash = getHash(virtualName);
				virtualNodes.put(hash, virtualName);
				
			}
		}
	}

	private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
	}
	private static String getServer(String key) {
		int hash = getHash(key);
		SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
		String virtualNode;
		if(subMap.isEmpty()) {
			Integer i = virtualNodes.firstKey();
			virtualNode = virtualNodes.get(i);
		}else {
			Integer i = subMap.firstKey();
			
			virtualNode = subMap.get(i);
		}
		
		if(!Strings.isNullOrEmpty(virtualNode)) {
			return virtualNode.substring(0, virtualNode.indexOf("&&"));
		}
		return null;
	}
	public static void main(String[] args) {
		String[] keys = {"太阳","月亮","星星","dasdasd","fewfwefwe","dasdasdqwqwweq","rerwrqwewqeqweqwe","tyyyyyyyyyyyyyj","r23rr32r"};
		for (int i = 0; i < keys.length; i++) {
            System.out.println("[" + keys[i] + "]的hash值为" +
                    getHash(keys[i]) + ", 被路由到结点[" + getServer(keys[i]) + "]");
		}
	}
	
}
