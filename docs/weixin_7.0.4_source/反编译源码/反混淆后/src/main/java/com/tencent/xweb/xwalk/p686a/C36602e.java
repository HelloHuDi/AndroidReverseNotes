package com.tencent.xweb.xwalk.p686a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.xwalk.a.e */
public final class C36602e {
    private static Map<String, C24550c> ASJ = new HashMap();

    static {
        AppMethodBeat.m2504i(4182);
        AppMethodBeat.m2505o(4182);
    }

    public static boolean dVP() {
        AppMethodBeat.m2504i(4178);
        if (ASJ.size() == 0) {
            Log.m81049i("XWalkPluginMgr", "initPlugins");
            ASJ.put(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, new C36601b());
            ASJ.put(XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER, new C6050a());
        }
        AppMethodBeat.m2505o(4178);
        return true;
    }

    public static C24550c avu(String str) {
        AppMethodBeat.m2504i(4179);
        if (str.isEmpty()) {
            AppMethodBeat.m2505o(4179);
            return null;
        }
        C24550c c24550c = (C24550c) ASJ.get(str);
        AppMethodBeat.m2505o(4179);
        return c24550c;
    }

    public static List<C24550c> dVQ() {
        AppMethodBeat.m2504i(4180);
        ArrayList arrayList = new ArrayList();
        for (Entry value : ASJ.entrySet()) {
            arrayList.add(value.getValue());
        }
        AppMethodBeat.m2505o(4180);
        return arrayList;
    }

    public static String dVR() {
        AppMethodBeat.m2504i(4181);
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry value : ASJ.entrySet()) {
            C24550c c24550c = (C24550c) value.getValue();
            if (c24550c != null) {
                stringBuilder.append(c24550c.dVM()).append(" = ").append(c24550c.ASG).append(", ");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(4181);
        return stringBuilder2;
    }
}
