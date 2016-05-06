package es.cursillo.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrameWithLayout {

	public static void main(String args[]) {
		List<String> arrayList = new ArrayList<String>();
		//arrayList.add(1);
		arrayList.add("sadsf");
		//arrayList.add(2);
		//arrayList.add(new JPanel());
		//arrayList.add('f');
		System.out.println(arrayList);
		Collections.sort(arrayList);
		System.out.println(arrayList);
		
		Set set = new HashSet();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(2);
		set.add(1);
		System.out.println(set);

		Map map = new HashMap();
		map.put("alberto", 23);
		map.put("juan", 13);
		map.put("sofia", 65);
		map.put("paula", 36);
		System.out.println(map.get("juan"));
		
		LinkedList linkedList = new LinkedList();
		
	}
}