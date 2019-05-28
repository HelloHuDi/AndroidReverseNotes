package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.r.j;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class ar extends d {
    ar() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(102825);
        LinkedList<h> linkedList = new LinkedList();
        j jVar = new j();
        com.tencent.mm.plugin.appbrand.appstorage.j a = cVar.asE().a(str, jVar);
        com.tencent.luggage.g.c.c(linkedList, (List) jVar.value);
        a aVar;
        switch (a) {
            case ERR_PARENT_DIR_NOT_EXISTS:
            case RET_NOT_EXISTS:
                aVar = new a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(102825);
                return aVar;
            case ERR_IS_FILE:
                aVar = new a("fail not a directory \"%s\"", str);
                AppMethodBeat.o(102825);
                return aVar;
            case ERR_PERMISSION_DENIED:
                aVar = new a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(102825);
                return aVar;
            case ERR_SYMLINK:
                aVar = new a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.o(102825);
                return aVar;
            case OK:
                JSONArray jSONArray = new JSONArray();
                for (h hVar : linkedList) {
                    jSONArray.put(hVar.fileName);
                }
                aVar = new a("ok", new Object[0]).o("files", jSONArray);
                AppMethodBeat.o(102825);
                return aVar;
            default:
                aVar = new a("fail " + a.name(), new Object[0]);
                AppMethodBeat.o(102825);
                return aVar;
        }
    }
}
