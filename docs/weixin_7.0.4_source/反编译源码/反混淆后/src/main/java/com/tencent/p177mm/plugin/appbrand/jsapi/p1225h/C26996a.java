package com.tencent.p177mm.plugin.appbrand.jsapi.p1225h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C10433b;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C10278d;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C42456a;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C42457b;
import com.tencent.p177mm.plugin.appbrand.p298j.C45569d;
import com.tencent.p177mm.plugin.appbrand.p321l.C10567c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h.a */
public final class C26996a extends C10433b {
    public static final int CTRL_INDEX = 467;
    public static final String NAME = "createLoadSubPackageTask";
    String hRm = "";
    String hvr = "";
    long mTotalSize = -1;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h.a$3 */
    static /* synthetic */ class C269973 {
        static final /* synthetic */ int[] hRo = new int[C10278d.values().length];

        static {
            AppMethodBeat.m2504i(114376);
            try {
                hRo[C10278d.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hRo[C10278d.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hRo[C10278d.CANCEL.ordinal()] = 3;
                AppMethodBeat.m2505o(114376);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.m2505o(114376);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h.a$a */
    public static class C26998a extends C38369p {
        public static final int CTRL_INDEX = 468;
        public static final String NAME = "onLoadSubPackageTaskStateChange";

        /* renamed from: a */
        static void m42940a(C2241c c2241c, String str, String str2, String str3) {
            AppMethodBeat.m2504i(114377);
            C26998a.m42941a(c2241c, str, str2, str3, -1, -1, -1);
            AppMethodBeat.m2505o(114377);
        }

        /* renamed from: a */
        static void m42941a(C2241c c2241c, String str, String str2, String str3, int i, long j, long j2) {
            AppMethodBeat.m2504i(114378);
            C4990ab.m7417i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", str, str2, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2));
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
            new C26998a().mo61031i(c2241c).mo61027AL(new JSONObject(hashMap).toString()).aCj();
            AppMethodBeat.m2505o(114378);
        }
    }

    public final String aBA() {
        AppMethodBeat.m2504i(114379);
        if (C5046bo.isNullOrNil(this.hvr)) {
            StringBuilder stringBuilder = new StringBuilder();
            C10567c.aIB();
            this.hvr = stringBuilder.append(C10567c.aIA()).toString();
        }
        String str = this.hvr;
        AppMethodBeat.m2505o(114379);
        return str;
    }

    /* renamed from: OA */
    public final String mo21946OA() {
        return "loadTaskId";
    }

    /* renamed from: a */
    public final void mo21947a(C2241c c2241c, JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(114380);
        final C33327h c33327h = (C33327h) c2241c;
        this.hRm = jSONObject.optString("moduleName");
        if (C5046bo.isNullOrNil(this.hRm)) {
            C4990ab.m7412e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
            m42937q(c33327h);
            AppMethodBeat.m2505o(114380);
            return;
        }
        C6750i runtime = c33327h.getRuntime();
        if (runtime == null || runtime.mFinished) {
            C4990ab.m7412e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
            m42937q(c33327h);
            AppMethodBeat.m2505o(114380);
            return;
        }
        C42458a c42458a = runtime.gNO;
        if (c42458a == null) {
            C4990ab.m7412e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
            m42937q(c33327h);
            AppMethodBeat.m2505o(114380);
        } else if (c42458a.aIy()) {
            c42458a.mo44657a(this.hRm, false, new C42457b() {
                /* renamed from: a */
                public final void mo44661a(C10278d c10278d) {
                    AppMethodBeat.m2504i(114374);
                    C4990ab.m7417i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s", c10278d.toString());
                    switch (C269973.hRo[c10278d.ordinal()]) {
                        case 1:
                            C26998a.m42940a(c33327h, C26996a.this.hvr, "success", C26996a.this.hRm);
                            AppMethodBeat.m2505o(114374);
                            return;
                        case 2:
                            C26998a.m42940a(c33327h, C26996a.this.hvr, "fail", C26996a.this.hRm);
                            AppMethodBeat.m2505o(114374);
                            return;
                        case 3:
                            C4990ab.m7420w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
                            C26998a.m42940a(c33327h, C26996a.this.hvr, "fail", C26996a.this.hRm);
                            break;
                    }
                    AppMethodBeat.m2505o(114374);
                }
            }, new C42456a() {
                /* renamed from: b */
                public final void mo34550b(C45569d c45569d) {
                    AppMethodBeat.m2504i(114375);
                    C4990ab.m7417i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", C26996a.this.hRm, c45569d.toString());
                    C26996a.this.mTotalSize = c45569d.awl();
                    C26998a.m42941a(c33327h, C26996a.this.hvr, "progressUpdate", C26996a.this.hRm, c45569d.getProgress(), c45569d.awk(), c45569d.awl());
                    AppMethodBeat.m2505o(114375);
                }
            });
            AppMethodBeat.m2505o(114380);
        } else {
            C4990ab.m7420w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
            m42937q(c33327h);
            AppMethodBeat.m2505o(114380);
        }
    }

    /* renamed from: q */
    private void m42937q(C2241c c2241c) {
        AppMethodBeat.m2504i(114381);
        C26998a.m42940a(c2241c, this.hvr, "fail", this.hRm);
        AppMethodBeat.m2505o(114381);
    }
}
