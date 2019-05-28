package com.tencent.p177mm.plugin.appbrand.jsapi.auth;

import android.os.Looper;
import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.p329s.C27292h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.c */
class C6769c extends C27292h<C2226a> implements C2225b, C2227d {
    private static final Map<String, C6769c> hBH = new C6197a();
    private static final C6769c hBI = new C67701();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.c$a */
    interface C2226a {
        void aqU();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.c$1 */
    static class C67701 extends C6769c {
        C67701() {
        }

        /* renamed from: bu */
        public final /* synthetic */ void mo15053bu(Object obj) {
            AppMethodBeat.m2504i(130816);
            super.mo15050a((C2226a) obj);
            AppMethodBeat.m2505o(130816);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean aCC() {
            return true;
        }

        public final /* bridge */ /* synthetic */ boolean aCD() {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.c$2 */
    class C67722 implements C10137a {
        C67722() {
        }

        /* renamed from: a */
        public final void mo6006a(String str, C45524b c45524b) {
            AppMethodBeat.m2504i(130817);
            if (c45524b == C45524b.DESTROYED) {
                C6769c.m11207a(C6769c.this);
                synchronized (C6769c.hBH) {
                    try {
                        C6769c.hBH.remove(str);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(130817);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(130817);
        }
    }

    /* synthetic */ C6769c() {
        this(null);
    }

    public /* synthetic */ boolean aCD() {
        AppMethodBeat.m2504i(130826);
        boolean aCC = aCC();
        AppMethodBeat.m2505o(130826);
        return aCC;
    }

    /* renamed from: bu */
    public /* synthetic */ void mo15053bu(Object obj) {
        AppMethodBeat.m2504i(130825);
        mo15050a((C2226a) obj);
        AppMethodBeat.m2505o(130825);
    }

    static {
        AppMethodBeat.m2504i(130828);
        AppMethodBeat.m2505o(130828);
    }

    /* renamed from: v */
    public static C6769c m11208v(C6750i c6750i) {
        AppMethodBeat.m2504i(130820);
        C6769c c6769c;
        if (c6750i == null || c6750i.mFinished) {
            c6769c = hBI;
            AppMethodBeat.m2505o(130820);
            return c6769c;
        }
        synchronized (hBH) {
            try {
                c6769c = (C6769c) hBH.get(c6750i.mAppId);
                if (c6769c == null) {
                    c6769c = new C6769c(c6750i);
                    hBH.put(c6750i.mAppId, c6769c);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130820);
            }
        }
        return c6769c;
    }

    private C6769c(C6750i c6750i) {
        String str;
        StringBuilder stringBuilder = new StringBuilder("MicroMsg.AppBrandAuthJsApiQueue");
        if (c6750i == null) {
            str = "|DUMMY";
        } else {
            str = "|" + c6750i.mAppId;
        }
        super(stringBuilder.append(str).toString(), Looper.getMainLooper());
        AppMethodBeat.m2504i(130821);
        if (c6750i == null) {
            AppMethodBeat.m2505o(130821);
            return;
        }
        c6750i.gNN.mo21486a(new C67722());
        AppMethodBeat.m2505o(130821);
    }

    /* Access modifiers changed, original: protected */
    public boolean aCC() {
        return false;
    }

    /* renamed from: a */
    public final void mo6091a(C33245f c33245f, C33327h c33327h, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130824);
        C4990ab.m7417i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", c33245f.getName(), Integer.valueOf(i), c33327h.getAppId());
        final C33327h c33327h2 = c33327h;
        final C33245f c33245f2 = c33245f;
        final JSONObject jSONObject2 = jSONObject;
        final int i2 = i;
        super.mo44978bF(new C2226a() {
            public final void aqU() {
                AppMethodBeat.m2504i(130818);
                C4990ab.m7417i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", C6769c.this.mName);
                if (c33327h2.isRunning()) {
                    c33245f2.mo21765a(c33327h2, jSONObject2, i2, this);
                    AppMethodBeat.m2505o(130818);
                    return;
                }
                C4990ab.m7413e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", c33245f2.getName());
                this.sendMessage(2);
                AppMethodBeat.m2505o(130818);
            }

            public final String toString() {
                AppMethodBeat.m2504i(130819);
                String str = hashCode() + "|" + c33245f2.getName();
                AppMethodBeat.m2505o(130819);
                return str;
            }
        });
        AppMethodBeat.m2505o(130824);
    }

    public final void aCB() {
        AppMethodBeat.m2504i(130822);
        sendMessage(2);
        AppMethodBeat.m2505o(130822);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo15050a(C2226a c2226a) {
        AppMethodBeat.m2504i(130823);
        C4990ab.m7411d(this.mName, "about to executeTask %s", c2226a.toString());
        c2226a.aqU();
        AppMethodBeat.m2505o(130823);
    }
}
