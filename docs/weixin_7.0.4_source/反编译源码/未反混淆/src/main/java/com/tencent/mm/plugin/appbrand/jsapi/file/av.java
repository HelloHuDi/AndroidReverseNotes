package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.u;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

final class av extends d {
    av() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(102834);
        boolean optBoolean = jSONObject.optBoolean("recursive", false);
        k kVar = new k();
        j a = cVar.asE().a(str, kVar);
        a y;
        switch (a) {
            case OK:
                int i;
                if ((kVar.st_mode & 61440) == 16384) {
                    i = 1;
                } else {
                    boolean i2 = false;
                }
                if (i2 == 0 || !optBoolean) {
                    y = new a("ok", new Object[0]).y(a(kVar, new HashMap()));
                    AppMethodBeat.o(102834);
                    return y;
                }
                y = h(cVar, str);
                AppMethodBeat.o(102834);
                return y;
            case RET_NOT_EXISTS:
            case ERR_PARENT_DIR_NOT_EXISTS:
                y = new a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(102834);
                return y;
            case ERR_PERMISSION_DENIED:
                y = new a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(102834);
                return y;
            default:
                y = new a("fail " + a.name(), new Object[0]);
                AppMethodBeat.o(102834);
                return y;
        }
    }

    private static a h(c cVar, String str) {
        AppMethodBeat.i(102835);
        LinkedList<u> linkedList = new LinkedList();
        j g = cVar.asE().g(str, linkedList);
        switch (g) {
            case OK:
                a aVar = new a("ok", new Object[0]);
                for (u uVar : linkedList) {
                    aVar.o(uVar.gYf, a(uVar, new HashMap()));
                }
                AppMethodBeat.o(102835);
                return aVar;
            default:
                a aVar2 = new a("fail " + g.name(), new Object[0]);
                AppMethodBeat.o(102835);
                return aVar2;
        }
    }

    private static Map<String, Object> a(k kVar, Map<String, Object> map) {
        AppMethodBeat.i(102836);
        map.put("mode", Integer.valueOf(kVar.st_mode));
        map.put("size", Long.valueOf(kVar.st_size));
        map.put("lastAccessedTime", Long.valueOf(kVar.st_atime));
        map.put("lastModifiedTime", Long.valueOf(kVar.st_mtime));
        AppMethodBeat.o(102836);
        return map;
    }
}
