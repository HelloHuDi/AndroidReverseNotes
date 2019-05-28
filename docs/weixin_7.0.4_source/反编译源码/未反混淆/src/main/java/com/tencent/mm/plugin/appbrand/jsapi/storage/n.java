package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class n extends com.tencent.mm.plugin.appbrand.jsapi.a<h> {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorage";
    private a hXr = new a() {
        public final void a(String str, h hVar, int i) {
            AppMethodBeat.i(102072);
            hVar.M(i, n.this.j(str, null));
            AppMethodBeat.o(102072);
        }
    };

    interface a {
        void a(String str, h hVar, int i);
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102079);
        h hVar = (h) cVar;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        int optInt = jSONObject.optInt("storageId", 0);
        if (bo.isNullOrNil(optString)) {
            hVar.M(i, j("fail:key is empty", null));
            AppMethodBeat.o(102079);
        } else if (r.nw(optInt)) {
            hVar.M(i, j("fail:nonexistent storage space", null));
            AppMethodBeat.o(102079);
        } else {
            String c = c(hVar);
            if (bo.isNullOrNil(c)) {
                hVar.M(i, j("fail:appID is empty", null));
                AppMethodBeat.o(102079);
                return;
            }
            if ((optString2 == null ? 0 : optString2.length()) + optString.length() > ((b) hVar.getRuntime()).xZ().bQO.hfL) {
                hVar.M(i, j("fail:entry size limit reached", null));
                AppMethodBeat.o(102079);
                return;
            }
            int i2 = hVar.getRuntime().ye().hhe;
            if (i2 == 2) {
                a(hVar, i, optInt, optString, optString2, optString3, c, this.hXr);
                AppMethodBeat.o(102079);
            } else if (i2 == 3) {
                a(hVar, i, optInt, optString, optString2, optString3, c, this.hXr);
                b(hVar, i, optInt, optString, optString2, optString3, c, null);
                AppMethodBeat.o(102079);
            } else {
                b(hVar, i, optInt, optString, optString2, optString3, c, this.hXr);
                AppMethodBeat.o(102079);
            }
        }
    }

    public n() {
        AppMethodBeat.i(102075);
        AppMethodBeat.o(102075);
    }

    private void a(h hVar, int i, int i2, String str, String str2, String str3, String str4, a aVar) {
        AppMethodBeat.i(102076);
        final long currentTimeMillis = System.currentTimeMillis();
        final int i3 = i2;
        final String str5 = str4;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final a aVar2 = aVar;
        final h hVar2 = hVar;
        final int i4 = i;
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102073);
                f fVar = f.gXv;
                String a = p.a(f.b(i3, str5, str6, str7, str8));
                if (aVar2 != null) {
                    aVar2.a(a, hVar2, i4);
                }
                n.b(2, r.by(str6, str7), currentTimeMillis, hVar2);
                AppMethodBeat.o(102073);
            }
        }, "JsApiSetStorage");
        AppMethodBeat.o(102076);
    }

    private void b(h hVar, int i, int i2, String str, String str2, String str3, String str4, a aVar) {
        AppMethodBeat.i(102077);
        final long currentTimeMillis = System.currentTimeMillis();
        final MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = str4;
        jsApiSetStorageTask.hXg = i2;
        jsApiSetStorageTask.C(str, str2, str3);
        final a aVar2 = aVar;
        final h hVar2 = hVar;
        final int i3 = i;
        final String str5 = str;
        final String str6 = str2;
        jsApiSetStorageTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(102074);
                if (aVar2 != null) {
                    aVar2.a(jsApiSetStorageTask.result, hVar2, i3);
                }
                n.b(1, r.by(str5, str6), currentTimeMillis, hVar2);
                jsApiSetStorageTask.aBW();
                AppMethodBeat.o(102074);
            }
        };
        jsApiSetStorageTask.aBV();
        AppBrandMainProcessService.a(jsApiSetStorageTask);
        AppMethodBeat.o(102077);
    }

    /* Access modifiers changed, original: protected */
    public String c(h hVar) {
        AppMethodBeat.i(102078);
        String str = hVar.getRuntime().mAppId;
        AppMethodBeat.o(102078);
        return str;
    }

    static /* synthetic */ void b(int i, int i2, long j, h hVar) {
        AppMethodBeat.i(102080);
        q.a(i, 1, i2, 1, System.currentTimeMillis() - j, hVar);
        AppMethodBeat.o(102080);
    }
}
