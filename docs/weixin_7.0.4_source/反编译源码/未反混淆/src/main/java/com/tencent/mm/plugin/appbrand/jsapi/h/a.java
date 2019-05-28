package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.j.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends b {
    public static final int CTRL_INDEX = 467;
    public static final String NAME = "createLoadSubPackageTask";
    String hRm = "";
    String hvr = "";
    long mTotalSize = -1;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h.a$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] hRo = new int[d.values().length];

        static {
            AppMethodBeat.i(114376);
            try {
                hRo[d.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hRo[d.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hRo[d.CANCEL.ordinal()] = 3;
                AppMethodBeat.o(114376);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(114376);
            }
        }
    }

    public static class a extends p {
        public static final int CTRL_INDEX = 468;
        public static final String NAME = "onLoadSubPackageTaskStateChange";

        static void a(c cVar, String str, String str2, String str3) {
            AppMethodBeat.i(114377);
            a(cVar, str, str2, str3, -1, -1, -1);
            AppMethodBeat.o(114377);
        }

        static void a(c cVar, String str, String str2, String str3, int i, long j, long j2) {
            AppMethodBeat.i(114378);
            ab.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", str, str2, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2));
            HashMap hashMap = new HashMap();
            hashMap.put("taskId", str);
            hashMap.put("state", str2);
            hashMap.put("moduleName", str3);
            if (i >= 0) {
                hashMap.put("progress", Integer.valueOf(i));
            }
            if (j >= 0) {
                hashMap.put("totalBytesWritten", Long.valueOf(j));
            }
            if (j2 >= 0) {
                hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j2));
            }
            new a().i(cVar).AL(new JSONObject(hashMap).toString()).aCj();
            AppMethodBeat.o(114378);
        }
    }

    public final String aBA() {
        AppMethodBeat.i(114379);
        if (bo.isNullOrNil(this.hvr)) {
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.plugin.appbrand.l.c.aIB();
            this.hvr = stringBuilder.append(com.tencent.mm.plugin.appbrand.l.c.aIA()).toString();
        }
        String str = this.hvr;
        AppMethodBeat.o(114379);
        return str;
    }

    public final String OA() {
        return "loadTaskId";
    }

    public final void a(c cVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(114380);
        final h hVar = (h) cVar;
        this.hRm = jSONObject.optString("moduleName");
        if (bo.isNullOrNil(this.hRm)) {
            ab.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
            q(hVar);
            AppMethodBeat.o(114380);
            return;
        }
        i runtime = hVar.getRuntime();
        if (runtime == null || runtime.mFinished) {
            ab.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
            q(hVar);
            AppMethodBeat.o(114380);
            return;
        }
        com.tencent.mm.plugin.appbrand.j.a aVar = runtime.gNO;
        if (aVar == null) {
            ab.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
            q(hVar);
            AppMethodBeat.o(114380);
        } else if (aVar.aIy()) {
            aVar.a(this.hRm, false, new com.tencent.mm.plugin.appbrand.j.a.b() {
                public final void a(d dVar) {
                    AppMethodBeat.i(114374);
                    ab.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s", dVar.toString());
                    switch (AnonymousClass3.hRo[dVar.ordinal()]) {
                        case 1:
                            a.a(hVar, a.this.hvr, "success", a.this.hRm);
                            AppMethodBeat.o(114374);
                            return;
                        case 2:
                            a.a(hVar, a.this.hvr, "fail", a.this.hRm);
                            AppMethodBeat.o(114374);
                            return;
                        case 3:
                            ab.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
                            a.a(hVar, a.this.hvr, "fail", a.this.hRm);
                            break;
                    }
                    AppMethodBeat.o(114374);
                }
            }, new com.tencent.mm.plugin.appbrand.j.a.a() {
                public final void b(com.tencent.mm.plugin.appbrand.j.d dVar) {
                    AppMethodBeat.i(114375);
                    ab.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", a.this.hRm, dVar.toString());
                    a.this.mTotalSize = dVar.awl();
                    a.a(hVar, a.this.hvr, "progressUpdate", a.this.hRm, dVar.getProgress(), dVar.awk(), dVar.awl());
                    AppMethodBeat.o(114375);
                }
            });
            AppMethodBeat.o(114380);
        } else {
            ab.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
            q(hVar);
            AppMethodBeat.o(114380);
        }
    }

    private void q(c cVar) {
        AppMethodBeat.i(114381);
        a.a(cVar, this.hvr, "fail", this.hRm);
        AppMethodBeat.o(114381);
    }
}
