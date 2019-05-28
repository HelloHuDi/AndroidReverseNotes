package com.tencent.p177mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.config.t */
final class C38171t {
    /* renamed from: l */
    static LinkedList<String> m64608l(JSONArray jSONArray) {
        AppMethodBeat.m2504i(96178);
        if (jSONArray == null) {
            AppMethodBeat.m2505o(96178);
            return null;
        }
        LinkedList<String> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        AppMethodBeat.m2505o(96178);
        return linkedList;
    }
}
