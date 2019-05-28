package com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p652z.p1101b.C40953b;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.p652z.p653c.C36406b;
import com.tencent.p177mm.p652z.p654d.C5759a;
import com.tencent.p177mm.plugin.appbrand.collector.C2107c;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1221i.C26868b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1221i.C33163a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.C10204a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26863d;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.a.c */
public final class C19177c implements C36406b {
    private Handler bOB;
    public String eIq;
    public C33163a hnl;
    private C4993ae<String, JSONObject> hnm = new C102011();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.a.c$1 */
    class C102011 extends C4993ae<String, JSONObject> {
        C102011() {
            super(10);
        }

        public final /* synthetic */ Object create(Object obj) {
            AppMethodBeat.m2504i(10869);
            JSONObject Ag = C102011.m17835Ag((String) obj);
            AppMethodBeat.m2505o(10869);
            return Ag;
        }

        /* renamed from: Ag */
        private static JSONObject m17835Ag(String str) {
            AppMethodBeat.m2504i(10868);
            try {
                if (C5046bo.isNullOrNil(str)) {
                    str = "{}";
                }
                long nanoTime = System.nanoTime();
                JSONObject lw = C41725h.m73457lw(str);
                C26868b.m42802f(System.nanoTime() - nanoTime, str.length());
                AppMethodBeat.m2505o(10868);
                return lw;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.DefaultJsApiExecutor", Log.getStackTraceString(e));
                AppMethodBeat.m2505o(10868);
                return null;
            }
        }
    }

    public C19177c() {
        AppMethodBeat.m2504i(10871);
        HandlerThread handlerThread = new HandlerThread("JsApiExecutor-Thread:" + hashCode());
        handlerThread.start();
        this.bOB = new Handler(handlerThread.getLooper());
        AppMethodBeat.m2505o(10871);
    }

    /* renamed from: lp */
    public final String mo34414lp(String str) {
        AppMethodBeat.m2504i(10872);
        C4990ab.m7417i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", str);
        String Q = mo34412Q(str, "fail:not supported");
        AppMethodBeat.m2505o(10872);
        return Q;
    }

    /* renamed from: a */
    public final String mo34413a(C36405a c36405a, C5759a c5759a, C40953b c40953b, String str, C16115a c16115a) {
        AppMethodBeat.m2504i(10873);
        String str2 = "";
        final String str3 = c40953b.name;
        String Q;
        if (c5759a.mo11735jB(c40953b.index)) {
            final String gv = C38496n.m65149gv(System.nanoTime());
            final boolean yN = C26863d.m42789yN(str3);
            C2107c.m4315d("jsapi_draw_canvas", gv, "start_jsapi_invoke", yN);
            C2107c.m4313bE(gv, "after_draw_actions");
            if (c40953b instanceof C26859b) {
                JSONObject Af = mo34411Af(str);
                if (Af == null) {
                    Q = mo34412Q(str3, "fail:invalid data");
                    AppMethodBeat.m2505o(10873);
                    return Q;
                }
                Q = c40953b.mo21609a(c36405a, Af, c16115a);
            } else {
                final String str4 = str;
                final C16115a c16115a2 = c16115a;
                final C40953b c40953b2 = c40953b;
                final C36405a c36405a2 = c36405a;
                this.bOB.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(10870);
                        C2107c.m4317l(gv, "parse_json_start", yN);
                        JSONObject Af = C19177c.this.mo34411Af(str4);
                        if (Af == null) {
                            c16115a2.mo11732au(C19177c.this.mo34412Q(str3, "fail:invalid data"));
                            AppMethodBeat.m2505o(10870);
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("rawJsapiData", str4);
                        C2107c.m4317l(gv, "parse_json_end", yN);
                        C26863d.m42787a(gv, str4, Af);
                        c40953b2.mo21610a(c36405a2, Af, bundle, c16115a2);
                        AppMethodBeat.m2505o(10870);
                    }
                });
                Q = str2;
            }
            if (this.hnl != null) {
                this.hnl.mo34424Al(str3);
            }
            AppMethodBeat.m2505o(10873);
            return Q;
        }
        C18652u.m29151i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", str3);
        Q = mo34412Q(str3, "fail:access denied");
        AppMethodBeat.m2505o(10873);
        return Q;
    }

    public final void quit() {
        AppMethodBeat.m2504i(10874);
        this.bOB.getLooper().quit();
        if (this.hnl != null) {
            this.hnl.mo34425IF();
        }
        C10204a.m17842Ah(this.eIq);
        C18652u.m29157v("MicroMsg.DefaultJsApiExecutor", "cache perf hit %d, miss %d, hit rate  " + ((float) ((((double) this.hnm.hitCount()) * 1.0d) / ((double) (this.hnm.hitCount() + this.hnm.missCount())))), Integer.valueOf(this.hnm.hitCount()), Integer.valueOf(this.hnm.missCount()));
        AppMethodBeat.m2505o(10874);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Af */
    public final JSONObject mo34411Af(String str) {
        AppMethodBeat.m2504i(10875);
        JSONObject jSONObject = (JSONObject) this.hnm.get(str);
        AppMethodBeat.m2505o(10875);
        return jSONObject;
    }

    /* renamed from: Q */
    public final String mo34412Q(String str, String str2) {
        AppMethodBeat.m2504i(10876);
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
        String jSONObject = new JSONObject(hashMap).toString();
        AppMethodBeat.m2505o(10876);
        return jSONObject;
    }
}
