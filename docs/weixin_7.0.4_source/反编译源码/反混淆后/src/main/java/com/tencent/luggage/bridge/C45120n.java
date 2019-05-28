package com.tencent.luggage.bridge;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.n */
final class C45120n {
    private C37392o bOA;
    private Handler bOB;

    C45120n(C37392o c37392o) {
        AppMethodBeat.m2504i(90732);
        this.bOA = c37392o;
        HandlerThread handlerThread = new HandlerThread("AsyncJSThread");
        handlerThread.start();
        this.bOB = new Handler(handlerThread.getLooper());
        AppMethodBeat.m2505o(90732);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: h */
    public final String mo72930h(final String str, boolean z) {
        AppMethodBeat.m2504i(90733);
        String i;
        if (z) {
            i = mo72931i(str, true);
            AppMethodBeat.m2505o(90733);
            return i;
        }
        this.bOB.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90730);
                C45120n.this.mo72931i(str, false);
                AppMethodBeat.m2505o(90730);
            }
        });
        i = "";
        AppMethodBeat.m2505o(90733);
        return i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: i */
    public final String mo72931i(String str, boolean z) {
        AppMethodBeat.m2504i(90734);
        C37390m bv = C45120n.m82913bv(str);
        String str2;
        if (bv == null) {
            str2 = "";
            AppMethodBeat.m2505o(90734);
            return str2;
        }
        C45124d.m82930i("Js2JavaMessageQueue", "processImpl, jsMsg.type = %s", bv.mo20028wJ().name());
        C45118e c45118e = null;
        switch (bv.mo20028wJ()) {
            case READY:
                this.bOA.bOH.mo52821wL();
                break;
            case INVOKE:
                c45118e = this.bOA.mo60227a(bv, z);
                break;
            case EVENT:
                this.bOA.mo60228a(bv);
                break;
            case CALLBACK:
                this.bOA.mo60229b(bv);
                break;
        }
        String str3 = "Js2JavaMessageQueue";
        String str4 = "processImpl, javaMsg.type = %s";
        Object[] objArr = new Object[1];
        objArr[0] = c45118e == null ? BuildConfig.COMMAND : c45118e.mo20028wJ().name();
        C45124d.m82932v(str3, str4, objArr);
        if (c45118e == null) {
            str2 = "";
            AppMethodBeat.m2505o(90734);
            return str2;
        }
        str2 = c45118e.toString();
        AppMethodBeat.m2505o(90734);
        return str2;
    }

    /* renamed from: bv */
    private static C37390m m82913bv(String str) {
        AppMethodBeat.m2504i(90735);
        try {
            C37390m c37390m = new C37390m(new JSONObject(str));
            AppMethodBeat.m2505o(90735);
            return c37390m;
        } catch (Exception e) {
            C45124d.m82928e("Js2JavaMessageQueue", "Message parse failed, ex = %s", e.getMessage());
            AppMethodBeat.m2505o(90735);
            return null;
        }
    }
}
