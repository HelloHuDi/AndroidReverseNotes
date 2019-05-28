package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.dynamic.i.a;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.c.b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class c implements b {
    private Handler bOB;
    public String eIq;
    public a hnl;
    private ae<String, JSONObject> hnm = new ae<String, JSONObject>() {
        public final /* synthetic */ Object create(Object obj) {
            AppMethodBeat.i(10869);
            JSONObject Ag = AnonymousClass1.Ag((String) obj);
            AppMethodBeat.o(10869);
            return Ag;
        }

        private static JSONObject Ag(String str) {
            AppMethodBeat.i(10868);
            try {
                if (bo.isNullOrNil(str)) {
                    str = "{}";
                }
                long nanoTime = System.nanoTime();
                JSONObject lw = h.lw(str);
                com.tencent.mm.plugin.appbrand.dynamic.i.b.f(System.nanoTime() - nanoTime, str.length());
                AppMethodBeat.o(10868);
                return lw;
            } catch (Exception e) {
                ab.e("MicroMsg.DefaultJsApiExecutor", Log.getStackTraceString(e));
                AppMethodBeat.o(10868);
                return null;
            }
        }
    };

    public c() {
        AppMethodBeat.i(10871);
        HandlerThread handlerThread = new HandlerThread("JsApiExecutor-Thread:" + hashCode());
        handlerThread.start();
        this.bOB = new Handler(handlerThread.getLooper());
        AppMethodBeat.o(10871);
    }

    public final String lp(String str) {
        AppMethodBeat.i(10872);
        ab.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", str);
        String Q = Q(str, "fail:not supported");
        AppMethodBeat.o(10872);
        return Q;
    }

    public final String a(com.tencent.mm.z.c.a aVar, com.tencent.mm.z.d.a aVar2, com.tencent.mm.z.b.b bVar, String str, com.tencent.mm.z.b.b.a aVar3) {
        AppMethodBeat.i(10873);
        String str2 = "";
        final String str3 = bVar.name;
        String Q;
        if (aVar2.jB(bVar.index)) {
            final String gv = n.gv(System.nanoTime());
            final boolean yN = d.yN(str3);
            com.tencent.mm.plugin.appbrand.collector.c.d("jsapi_draw_canvas", gv, "start_jsapi_invoke", yN);
            com.tencent.mm.plugin.appbrand.collector.c.bE(gv, "after_draw_actions");
            if (bVar instanceof b) {
                JSONObject Af = Af(str);
                if (Af == null) {
                    Q = Q(str3, "fail:invalid data");
                    AppMethodBeat.o(10873);
                    return Q;
                }
                Q = bVar.a(aVar, Af, aVar3);
            } else {
                final String str4 = str;
                final com.tencent.mm.z.b.b.a aVar4 = aVar3;
                final com.tencent.mm.z.b.b bVar2 = bVar;
                final com.tencent.mm.z.c.a aVar5 = aVar;
                this.bOB.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(10870);
                        com.tencent.mm.plugin.appbrand.collector.c.l(gv, "parse_json_start", yN);
                        JSONObject Af = c.this.Af(str4);
                        if (Af == null) {
                            aVar4.au(c.this.Q(str3, "fail:invalid data"));
                            AppMethodBeat.o(10870);
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("rawJsapiData", str4);
                        com.tencent.mm.plugin.appbrand.collector.c.l(gv, "parse_json_end", yN);
                        d.a(gv, str4, Af);
                        bVar2.a(aVar5, Af, bundle, aVar4);
                        AppMethodBeat.o(10870);
                    }
                });
                Q = str2;
            }
            if (this.hnl != null) {
                this.hnl.Al(str3);
            }
            AppMethodBeat.o(10873);
            return Q;
        }
        u.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", str3);
        Q = Q(str3, "fail:access denied");
        AppMethodBeat.o(10873);
        return Q;
    }

    public final void quit() {
        AppMethodBeat.i(10874);
        this.bOB.getLooper().quit();
        if (this.hnl != null) {
            this.hnl.IF();
        }
        com.tencent.mm.plugin.appbrand.dynamic.d.b.a.Ah(this.eIq);
        u.v("MicroMsg.DefaultJsApiExecutor", "cache perf hit %d, miss %d, hit rate  " + ((float) ((((double) this.hnm.hitCount()) * 1.0d) / ((double) (this.hnm.hitCount() + this.hnm.missCount())))), Integer.valueOf(this.hnm.hitCount()), Integer.valueOf(this.hnm.missCount()));
        AppMethodBeat.o(10874);
    }

    /* Access modifiers changed, original: final */
    public final JSONObject Af(String str) {
        AppMethodBeat.i(10875);
        JSONObject jSONObject = (JSONObject) this.hnm.get(str);
        AppMethodBeat.o(10875);
        return jSONObject;
    }

    public final String Q(String str, String str2) {
        AppMethodBeat.i(10876);
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
        String jSONObject = new JSONObject(hashMap).toString();
        AppMethodBeat.o(10876);
        return jSONObject;
    }
}
