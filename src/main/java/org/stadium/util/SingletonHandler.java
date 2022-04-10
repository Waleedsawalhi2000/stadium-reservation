package org.stadium.util;

import java.util.HashMap;
import java.util.Map;

public class SingletonHandler {
    private static final Map<Class, Object> map = new HashMap<>();


    public static Object getInstance(final Class clazz) {
        if (map.get(clazz) == null) {
            try {
                map.put(clazz, clazz.newInstance());
            } catch(final Exception ignore) {}
        }
        return map.get(clazz);
    }
}
