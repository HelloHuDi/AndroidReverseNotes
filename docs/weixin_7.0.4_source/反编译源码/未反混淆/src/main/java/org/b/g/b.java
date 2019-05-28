package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Map.Entry;

public final class b {
    public static <K, V> String x(Map<K, V> map) {
        AppMethodBeat.i(77305);
        String str;
        if (map == null) {
            str = "";
            AppMethodBeat.o(77305);
            return str;
        } else if (map.isEmpty()) {
            str = "{}";
            AppMethodBeat.o(77305);
            return str;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(String.format(", %s -> %s ", new Object[]{entry.getKey().toString(), entry.getValue().toString()}));
            }
            str = "{" + stringBuilder.substring(1) + "}";
            AppMethodBeat.o(77305);
            return str;
        }
    }
}
