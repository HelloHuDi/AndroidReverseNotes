package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class e {
    private static Map<String, c> ASJ = new HashMap();

    static {
        AppMethodBeat.i(4182);
        AppMethodBeat.o(4182);
    }

    public static boolean dVP() {
        AppMethodBeat.i(4178);
        if (ASJ.size() == 0) {
            Log.i("XWalkPluginMgr", "initPlugins");
            ASJ.put(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, new b());
            ASJ.put(XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER, new a());
        }
        AppMethodBeat.o(4178);
        return true;
    }

    public static c avu(String str) {
        AppMethodBeat.i(4179);
        if (str.isEmpty()) {
            AppMethodBeat.o(4179);
            return null;
        }
        c cVar = (c) ASJ.get(str);
        AppMethodBeat.o(4179);
        return cVar;
    }

    public static List<c> dVQ() {
        AppMethodBeat.i(4180);
        ArrayList arrayList = new ArrayList();
        for (Entry value : ASJ.entrySet()) {
            arrayList.add(value.getValue());
        }
        AppMethodBeat.o(4180);
        return arrayList;
    }

    public static String dVR() {
        AppMethodBeat.i(4181);
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry value : ASJ.entrySet()) {
            c cVar = (c) value.getValue();
            if (cVar != null) {
                stringBuilder.append(cVar.dVM()).append(" = ").append(cVar.ASG).append(", ");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(4181);
        return stringBuilder2;
    }
}
