package com.edu.collect0323;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		// Map: {key:value}, {key1:value1} key와 key에 해당되는 value값이 같이 묶여서 값 저장
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("전민욱"/*key*/, 80/*value*/);
		map.put("김형민", 82);
		map.put("김영민", 85);
		map.put("김영민", 88);
		// 컬렉션 : 여러값을 저장 => 여러요소 접근
		
		Integer val = map.get("김영민");
		System.out.println(val); // key를 출력하면 value를 리턴해줄것임
		
		Set<String> keySet = map.keySet(); // map컬렉션에 저장된 요소들의 모든 key를 반환한다.
		// 1)
		Iterator<String> iter = keySet.iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.printf("key: %3s, value: %3d \n", key, value);
		}
		
		// 2) for( : ) 확장for
		for(String key : keySet) {
			Integer value = map.get(key);
			System.out.printf("key: %3s, value: %3d \n", key, value);
		}
		
		System.out.println("end of prog");
	}

}
