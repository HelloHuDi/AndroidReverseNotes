package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import org.json.JSONObject;

final class as extends d {
    as() {
    }

    /* Access modifiers changed, original: final */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        e eVar;
        a aVar;
        AppMethodBeat.i(102827);
        String optString = jSONObject.optString("encoding");
        ab.i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", str, optString);
        if (bo.isNullOrNil(optString)) {
            eVar = null;
        } else {
            e eVar2 = (e) e.a.hJH.get(optString.toLowerCase());
            if (eVar2 == null) {
                aVar = new a("fail invalid encoding", new Object[0]);
                AppMethodBeat.o(102827);
                return aVar;
            }
            eVar = eVar2;
        }
        j jVar = new j();
        com.tencent.mm.plugin.appbrand.appstorage.j b = cVar.asE().b(str, jVar);
        if (b == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
            Object obj;
            if (eVar == null) {
                obj = (Comparable) jVar.value;
            } else {
                String obj2 = eVar.o((ByteBuffer) jVar.value);
            }
            if (!(obj2 instanceof ByteBuffer)) {
                com.tencent.luggage.g.a.j((ByteBuffer) jVar.value);
            }
            aVar = new a("ok", new Object[0]).o("data", obj2);
            AppMethodBeat.o(102827);
            return aVar;
        }
        switch (b) {
            case RET_NOT_EXISTS:
                aVar = new a("fail no such file \"%s\"", str);
                AppMethodBeat.o(102827);
                return aVar;
            case ERR_PERMISSION_DENIED:
                aVar = new a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(102827);
                return aVar;
            case ERR_SYMLINK:
                aVar = new a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.o(102827);
                return aVar;
            default:
                aVar = new a("fail " + b.name(), new Object[0]);
                AppMethodBeat.o(102827);
                return aVar;
        }
    }
}
