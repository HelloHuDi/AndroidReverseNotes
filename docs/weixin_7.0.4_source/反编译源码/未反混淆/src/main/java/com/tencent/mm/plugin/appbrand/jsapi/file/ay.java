package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONObject;

class ay extends d {
    ay() {
    }

    /* Access modifiers changed, original: 0000 */
    public a a(c cVar, String str, JSONObject jSONObject) {
        a aVar;
        InputStream aVar2;
        AppMethodBeat.i(102843);
        boolean optBoolean = jSONObject.optBoolean("append", false);
        String optString = jSONObject.optString("encoding");
        q.a(cVar.aBx(), jSONObject, (q.a) cVar.aa(q.a.class));
        Object opt = jSONObject.opt("data");
        if (opt instanceof String) {
            e eVar;
            if (bo.isNullOrNil(optString)) {
                eVar = (e) e.a.hJH.get("utf8");
            } else {
                e eVar2 = (e) e.a.hJH.get(optString.toLowerCase());
                if (eVar2 == null) {
                    aVar = new a("fail invalid encoding", new Object[0]);
                    AppMethodBeat.o(102843);
                    return aVar;
                }
                eVar = eVar2;
            }
            try {
                aVar2 = new com.tencent.luggage.g.a(eVar.AY((String) opt));
            } catch (Exception e) {
                aVar = new a("fail " + e.getMessage(), new Object[0]);
                AppMethodBeat.o(102843);
                return aVar;
            }
        } else if (opt instanceof ByteBuffer) {
            aVar2 = new com.tencent.luggage.g.a((ByteBuffer) opt);
        } else if (opt != null) {
            aVar = new a("fail invalid data", new Object[0]);
            AppMethodBeat.o(102843);
            return aVar;
        } else if (optBoolean) {
            aVar = new a("ok", new Object[0]);
            AppMethodBeat.o(102843);
            return aVar;
        } else {
            aVar2 = new ByteArrayInputStream(new byte[0]);
        }
        j a = cVar.asE().a(str, aVar2, optBoolean);
        switch (a) {
            case ERR_PARENT_DIR_NOT_EXISTS:
                aVar = new a("fail no such file or directory, open \"%s\"", str);
                AppMethodBeat.o(102843);
                return aVar;
            case RET_NOT_EXISTS:
                aVar = new a("fail no such file \"%s\"", str);
                AppMethodBeat.o(102843);
                return aVar;
            case RET_ALREADY_EXISTS:
                aVar = new a("fail illegal operation on a directory, open \"%s\"", str);
                AppMethodBeat.o(102843);
                return aVar;
            case ERR_PERMISSION_DENIED:
                aVar = new a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(102843);
                return aVar;
            case ERR_SYMLINK:
                aVar = new a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.o(102843);
                return aVar;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                aVar = new a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                AppMethodBeat.o(102843);
                return aVar;
            case OK:
                aVar = new a("ok", new Object[0]);
                AppMethodBeat.o(102843);
                return aVar;
            default:
                aVar = new a("fail " + a.name(), new Object[0]);
                AppMethodBeat.o(102843);
                return aVar;
        }
    }
}
