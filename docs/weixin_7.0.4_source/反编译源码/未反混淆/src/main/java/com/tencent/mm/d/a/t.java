package com.tencent.mm.d.a;

import android.util.Log;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.l.AnonymousClass9;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class t {
    private final AtomicInteger ciE = new AtomicInteger(0);
    public final HashMap<Integer, l> ciF = new HashMap();
    u ciG;
    private f ciH = new f() {
        public final int Cv() {
            AppMethodBeat.i(113894);
            int CC = t.this.ciG.CC();
            AppMethodBeat.o(113894);
            return CC;
        }

        public final ByteBuffer gq(int i) {
            AppMethodBeat.i(113895);
            ByteBuffer gq = t.this.ciG.gq(i);
            AppMethodBeat.o(113895);
            return gq;
        }

        public final void a(int i, ByteBuffer byteBuffer) {
            AppMethodBeat.i(113896);
            t.this.ciG.a(i, byteBuffer);
            AppMethodBeat.o(113896);
        }
    };

    public static class a {
        public String filePath;
        public String script;

        public a(String str, String str2) {
            this.filePath = str;
            this.script = str2;
        }
    }

    /* renamed from: com.tencent.mm.d.a.t$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String bOC;
        final /* synthetic */ l ciI;

        public AnonymousClass3(l lVar, String str) {
            this.ciI = lVar;
            this.bOC = str;
        }

        public final void run() {
            AppMethodBeat.i(113893);
            l lVar = this.ciI;
            String str = this.bOC;
            if (lVar.CB().getType("onmessage") == 7) {
                V8Function v8Function = (V8Function) lVar.CB().get("onmessage");
                V8Array newV8Array = lVar.CB().newV8Array();
                newV8Array.push(str);
                v8Function.call(lVar.CB().getGlobalObject(), newV8Array);
                v8Function.release();
                newV8Array.release();
            }
            AppMethodBeat.o(113893);
        }
    }

    public t(u uVar) {
        AppMethodBeat.i(113897);
        this.ciG = uVar;
        AppMethodBeat.o(113897);
    }

    public final int e(ArrayList<a> arrayList) {
        AppMethodBeat.i(113898);
        final int addAndGet = this.ciE.addAndGet(1);
        v CD = v.CD();
        CD.chr = this.ciH;
        final l gm = CD.gm(1);
        gm.chO.k(new AnonymousClass9(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113892);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 4) {
                    AppMethodBeat.o(113892);
                    return;
                }
                t.this.ciG.h(addAndGet, v8Array.getString(0));
                AppMethodBeat.o(113892);
            }
        }, "postMessage"));
        gm.a(1, new h() {
            public final void C(String str, String str2) {
                AppMethodBeat.i(113891);
                ab.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", str, str2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
                    jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, str2);
                } catch (JSONException e) {
                    ab.e("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(e));
                }
                gm.a(String.format("WeixinWorker.errorHandler(%s)", new Object[]{jSONObject}), null);
                AppMethodBeat.o(113891);
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                int i;
                if (bo.isNullOrNil(aVar.script) && bo.isNullOrNil(aVar.filePath)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    a(gm, aVar);
                }
            }
        }
        this.ciF.put(Integer.valueOf(addAndGet), gm);
        AppMethodBeat.o(113898);
        return addAndGet;
    }

    /* Access modifiers changed, original: protected */
    public void a(l lVar, a aVar) {
        AppMethodBeat.i(113899);
        ab.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", aVar.filePath);
        lVar.a(aVar.filePath, aVar.script, null);
        AppMethodBeat.o(113899);
    }
}
