package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.p147g.C37400c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C26753h;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.ar */
final class C10386ar extends C38299d {
    C10386ar() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102825);
        LinkedList<C26753h> linkedList = new LinkedList();
        C19681j c19681j = new C19681j();
        C45518j a = c2241c.asE().mo5837a(str, c19681j);
        C37400c.m63005c(linkedList, (List) c19681j.value);
        C10396a c10396a;
        switch (a) {
            case ERR_PARENT_DIR_NOT_EXISTS:
            case RET_NOT_EXISTS:
                c10396a = new C10396a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.m2505o(102825);
                return c10396a;
            case ERR_IS_FILE:
                c10396a = new C10396a("fail not a directory \"%s\"", str);
                AppMethodBeat.m2505o(102825);
                return c10396a;
            case ERR_PERMISSION_DENIED:
                c10396a = new C10396a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.m2505o(102825);
                return c10396a;
            case ERR_SYMLINK:
                c10396a = new C10396a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.m2505o(102825);
                return c10396a;
            case OK:
                JSONArray jSONArray = new JSONArray();
                for (C26753h c26753h : linkedList) {
                    jSONArray.put(c26753h.fileName);
                }
                c10396a = new C10396a("ok", new Object[0]).mo21867o("files", jSONArray);
                AppMethodBeat.m2505o(102825);
                return c10396a;
            default:
                c10396a = new C10396a("fail " + a.name(), new Object[0]);
                AppMethodBeat.m2505o(102825);
                return c10396a;
        }
    }
}
