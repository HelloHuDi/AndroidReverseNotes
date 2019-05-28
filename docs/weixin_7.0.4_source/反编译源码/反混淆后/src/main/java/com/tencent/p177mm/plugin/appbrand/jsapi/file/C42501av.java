package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C33103u;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42366k;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.av */
final class C42501av extends C38299d {
    C42501av() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102834);
        boolean optBoolean = jSONObject.optBoolean("recursive", false);
        C42366k c42366k = new C42366k();
        C45518j a = c2241c.asE().mo5836a(str, c42366k);
        C10396a y;
        switch (a) {
            case OK:
                int i;
                if ((c42366k.st_mode & 61440) == 16384) {
                    i = 1;
                } else {
                    boolean i2 = false;
                }
                if (i2 == 0 || !optBoolean) {
                    y = new C10396a("ok", new Object[0]).mo21869y(C42501av.m75276a(c42366k, new HashMap()));
                    AppMethodBeat.m2505o(102834);
                    return y;
                }
                y = C42501av.m75277h(c2241c, str);
                AppMethodBeat.m2505o(102834);
                return y;
            case RET_NOT_EXISTS:
            case ERR_PARENT_DIR_NOT_EXISTS:
                y = new C10396a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.m2505o(102834);
                return y;
            case ERR_PERMISSION_DENIED:
                y = new C10396a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.m2505o(102834);
                return y;
            default:
                y = new C10396a("fail " + a.name(), new Object[0]);
                AppMethodBeat.m2505o(102834);
                return y;
        }
    }

    /* renamed from: h */
    private static C10396a m75277h(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(102835);
        LinkedList<C33103u> linkedList = new LinkedList();
        C45518j g = c2241c.asE().mo5846g(str, linkedList);
        switch (g) {
            case OK:
                C10396a c10396a = new C10396a("ok", new Object[0]);
                for (C33103u c33103u : linkedList) {
                    c10396a.mo21867o(c33103u.gYf, C42501av.m75276a(c33103u, new HashMap()));
                }
                AppMethodBeat.m2505o(102835);
                return c10396a;
            default:
                C10396a c10396a2 = new C10396a("fail " + g.name(), new Object[0]);
                AppMethodBeat.m2505o(102835);
                return c10396a2;
        }
    }

    /* renamed from: a */
    private static Map<String, Object> m75276a(C42366k c42366k, Map<String, Object> map) {
        AppMethodBeat.m2504i(102836);
        map.put("mode", Integer.valueOf(c42366k.st_mode));
        map.put("size", Long.valueOf(c42366k.st_size));
        map.put("lastAccessedTime", Long.valueOf(c42366k.st_atime));
        map.put("lastModifiedTime", Long.valueOf(c42366k.st_mtime));
        AppMethodBeat.m2505o(102836);
        return map;
    }
}
