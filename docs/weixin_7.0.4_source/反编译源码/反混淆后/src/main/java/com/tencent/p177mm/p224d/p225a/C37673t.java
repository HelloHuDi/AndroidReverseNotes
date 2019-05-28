package com.tencent.p177mm.p224d.p225a;

import android.util.Log;
import com.eclipsesource.p097v8.JavaVoidCallback;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Function;
import com.eclipsesource.p097v8.V8Object;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C32488l.C324899;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.d.a.t */
public class C37673t {
    private final AtomicInteger ciE = new AtomicInteger(0);
    public final HashMap<Integer, C32488l> ciF = new HashMap();
    C26065u ciG;
    private C9256f ciH = new C181884();

    /* renamed from: com.tencent.mm.d.a.t$a */
    public static class C1492a {
        public String filePath;
        public String script;

        public C1492a(String str, String str2) {
            this.filePath = str;
            this.script = str2;
        }
    }

    /* renamed from: com.tencent.mm.d.a.t$4 */
    class C181884 implements C9256f {
        C181884() {
        }

        /* renamed from: Cv */
        public final int mo20675Cv() {
            AppMethodBeat.m2504i(113894);
            int CC = C37673t.this.ciG.mo6449CC();
            AppMethodBeat.m2505o(113894);
            return CC;
        }

        /* renamed from: gq */
        public final ByteBuffer mo20677gq(int i) {
            AppMethodBeat.m2504i(113895);
            ByteBuffer gq = C37673t.this.ciG.mo6451gq(i);
            AppMethodBeat.m2505o(113895);
            return gq;
        }

        /* renamed from: a */
        public final void mo20676a(int i, ByteBuffer byteBuffer) {
            AppMethodBeat.m2504i(113896);
            C37673t.this.ciG.mo6450a(i, byteBuffer);
            AppMethodBeat.m2505o(113896);
        }
    }

    /* renamed from: com.tencent.mm.d.a.t$3 */
    public class C376753 implements Runnable {
        final /* synthetic */ String bOC;
        final /* synthetic */ C32488l ciI;

        public C376753(C32488l c32488l, String str) {
            this.ciI = c32488l;
            this.bOC = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(113893);
            C32488l c32488l = this.ciI;
            String str = this.bOC;
            if (c32488l.mo53119CB().getType("onmessage") == 7) {
                V8Function v8Function = (V8Function) c32488l.mo53119CB().get("onmessage");
                V8Array newV8Array = c32488l.mo53119CB().newV8Array();
                newV8Array.push(str);
                v8Function.call(c32488l.mo53119CB().getGlobalObject(), newV8Array);
                v8Function.release();
                newV8Array.release();
            }
            AppMethodBeat.m2505o(113893);
        }
    }

    public C37673t(C26065u c26065u) {
        AppMethodBeat.m2504i(113897);
        this.ciG = c26065u;
        AppMethodBeat.m2505o(113897);
    }

    /* renamed from: e */
    public final int mo60499e(ArrayList<C1492a> arrayList) {
        AppMethodBeat.m2504i(113898);
        final int addAndGet = this.ciE.addAndGet(1);
        C26066v CD = C26066v.m41604CD();
        CD.chr = this.ciH;
        final C32488l gm = CD.mo73186gm(1);
        gm.chO.mo73187k(new C324899(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.m2504i(113892);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 4) {
                    AppMethodBeat.m2505o(113892);
                    return;
                }
                C37673t.this.ciG.mo6452h(addAndGet, v8Array.getString(0));
                AppMethodBeat.m2505o(113892);
            }
        }, "postMessage"));
        gm.mo53120a(1, new C33211h() {
            /* renamed from: C */
            public final void mo5989C(String str, String str2) {
                AppMethodBeat.m2504i(113891);
                C4990ab.m7413e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", str, str2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
                    jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, str2);
                } catch (JSONException e) {
                    C4990ab.m7412e("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(e));
                }
                gm.mo53121a(String.format("WeixinWorker.errorHandler(%s)", new Object[]{jSONObject}), null);
                AppMethodBeat.m2505o(113891);
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1492a c1492a = (C1492a) it.next();
            if (c1492a != null) {
                int i;
                if (C5046bo.isNullOrNil(c1492a.script) && C5046bo.isNullOrNil(c1492a.filePath)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    mo60498a(gm, c1492a);
                }
            }
        }
        this.ciF.put(Integer.valueOf(addAndGet), gm);
        AppMethodBeat.m2505o(113898);
        return addAndGet;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo60498a(C32488l c32488l, C1492a c1492a) {
        AppMethodBeat.m2504i(113899);
        C4990ab.m7417i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", c1492a.filePath);
        c32488l.mo53122a(c1492a.filePath, c1492a.script, null);
        AppMethodBeat.m2505o(113899);
    }
}
