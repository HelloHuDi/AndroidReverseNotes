package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static <K, V> K getKeyFromMap(Map<K, V> map, K k) {
        AppMethodBeat.i(90250);
        if (map.containsKey(k)) {
            for (Object next : map.keySet()) {
                if (next.equals(k)) {
                    AppMethodBeat.o(90250);
                    return next;
                }
            }
        }
        AppMethodBeat.o(90250);
        return null;
    }

    public static void writeStringMapToJson(StringBuilder stringBuilder, HashMap<String, String> hashMap) {
        AppMethodBeat.i(90249);
        stringBuilder.append("{");
        Object obj = 1;
        for (String str : hashMap.keySet()) {
            Object obj2;
            if (obj == null) {
                stringBuilder.append(",");
                obj2 = obj;
            } else {
                obj2 = null;
            }
            String str2 = (String) hashMap.get(str);
            stringBuilder.append("\"").append(str).append("\":");
            if (str2 == null) {
                stringBuilder.append(BuildConfig.COMMAND);
                obj = obj2;
            } else {
                stringBuilder.append("\"").append(str2).append("\"");
                obj = obj2;
            }
        }
        stringBuilder.append("}");
        AppMethodBeat.o(90249);
    }
}
