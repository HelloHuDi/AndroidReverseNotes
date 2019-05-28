package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;

final class t {
    static LinkedList<String> l(JSONArray jSONArray) {
        AppMethodBeat.i(96178);
        if (jSONArray == null) {
            AppMethodBeat.o(96178);
            return null;
        }
        LinkedList<String> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        AppMethodBeat.o(96178);
        return linkedList;
    }
}
