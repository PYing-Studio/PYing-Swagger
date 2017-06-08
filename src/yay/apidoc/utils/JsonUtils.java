package yay.apidoc.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JsonUtils {
	public static  List<Map<String, Object>> changeListToMap(List<?> list, String[] ignoreKey) {
		List<Map<String, Object>> ordersList = new LinkedList<Map<String, Object>>();
		
		for (Object order : list) {
			Map<String, Object> map = BeansUtils.transBean2Map(order);
			if (ignoreKey != null) {
				for (int i = 0; i < ignoreKey.length; i++) {
					map.remove(ignoreKey[i]);
				}
			}
			ordersList.add(map);
		}
		return ordersList;
	}
}
