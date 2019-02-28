package com.sun.core.dr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayClient {
	private Logger log = LoggerFactory.getLogger(getClass());
	private int[] a3y0 = { -1, 1, 33, 0, -1, 9 };// array0

	/**
	 * 一维数组 排序 最值 插入 删除 查找 翻转
	 * 
	 * @description:
	 */
	@Test
	public void TArray() {
		// 数组的命名和赋值
		int[] arr1 = new int[5];// 方式一
		String[] arr2 = new String[] { "1", "32", "///" };// 方式二
		Object[] arr3 = { 1, 1.22, "asas", new Object() };// 方式三
		
		Object[] arr4 = null;
		
		arr4[0]=3;
		arr4[1]=4;
		arr4[5]=1;
		
		// 数组的取值
		int i2 = arr1[2];
		log.info("i2={}", i2);
		// 数组的赋值
		arr1[3] = 333;
		log.info("i2={}", arr1[3]);

	}

	/**
	 * 
	 * 冒泡排序 n个数据比较n-1轮
	 * 
	 * 每一个数据与在它之后的数据，逐一进行比较 。形象的称之为：冒泡
	 * 
	 * @description:
	 */
	@Test
	public void TArray1() {

		for (int i = 0; i < a3y0.length - 1; i++) {

			for (int j = i + 1; j < a3y0.length; j++) {
				int temp = a3y0[i];
				if (temp > a3y0[j]) {
					a3y0[i] = a3y0[j];
					a3y0[j] = temp;
				}
			}
		}

		for (int i = 0; i < a3y0.length; i++) {
			log.info("a3y0[{}]={}", i, a3y0[i]);
		}

	}

	/**
	 * 
	 * 选择排序 先找出最大或者最小元素下标 然后再和第一位置的元素交换。
	 * 
	 * @description:
	 */
	@Test
	public void TArray2() {

		for (int i = 0; i < a3y0.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a3y0.length; j++) {
				if (a3y0[min] > a3y0[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = a3y0[i];
				a3y0[i] = a3y0[min];
				a3y0[min] = temp;
			}

		}

		for (int i = 0; i < a3y0.length; i++) {
			log.info("a3y0[{}]={}", i, a3y0[i]);
		}

	}

	/**
	 * 
	 * 插入排序
	 * 
	 * @description: https://www.cnblogs.com/xiaoming0601/p/5862793.html
	 */
	@Test
	public void TArray3() {
		int i, j;
		int n = a3y0.length;
		int target;

		for (i = 1; i < n; i++) {

			j = i;
			target = a3y0[i];
			log.info("j={}", j);
			while (j > 0 && target < a3y0[j - 1]) {
				a3y0[j] = a3y0[j - 1];
				j--;
			}
			//j值经过while循环后不一定等于i。可能是小于i的某个值
			log.info("j={}", j);
			a3y0[j] = target;
			log.info("=========");
		}

		for (i = 0; i < a3y0.length; i++) {
			log.info("a3y0[{}]={}", i, a3y0[i]);
		}

	}
	@Test
	public void tMaps() {
		Map<Object,Object> m = new HashMap<>();
		
		m.put("n", "jk");
		m.put("m", "qk");
		
		Collection<Object> values = m.values();
		System.out.println(values);
		
	}
}
