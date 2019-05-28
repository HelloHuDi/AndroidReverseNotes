package org.p1128b.p1134g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: org.b.g.b */
public final class C36643b {
    /* renamed from: x */
    public static <K, V> String m60743x(Map<K, V> map) {
        AppMethodBeat.m2504i(77305);
        String str;
        if (map == null) {
            str = "";
            AppMethodBeat.m2505o(77305);
            return str;
        } else if (map.isEmpty()) {
            str = "{}";
            AppMethodBeat.m2505o(77305);
            return str;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(String.format(", %s -> %s ", new Object[]{entry.getKey().toString(), entry.getValue().toString()}));
            }
            str = "{" + stringBuilder.substring(1) + "}";
            AppMethodBeat.m2505o(77305);
            return str;
        }
    }
}
