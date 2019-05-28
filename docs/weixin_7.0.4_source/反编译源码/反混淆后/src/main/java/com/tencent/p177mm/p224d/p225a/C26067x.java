package com.tencent.p177mm.p224d.p225a;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.p097v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.d.a.x */
public final class C26067x {
    private static final String TAG = ("MicroMsg.V8MemoryPressureMonitor" + C4996ah.getProcessName().replace("com.tencent.mm", ""));
    private final MultiContextV8 chm;
    private final int ciO = 1000;
    private Integer ciP = null;
    private boolean ciQ;
    private int ciR = 0;
    private final Runnable ciS = new C260691();
    private final ComponentCallbacks2 ciT;

    /* renamed from: com.tencent.mm.d.a.x$2 */
    class C260682 implements ComponentCallbacks2 {
        C260682() {
        }

        public final void onTrimMemory(int i) {
            AppMethodBeat.m2504i(113920);
            C4990ab.m7417i(C26067x.TAG, "onTrimMemory level = [%d]", Integer.valueOf(i));
            Integer gt = C26067x.m41612gt(i);
            if (gt != null) {
                C26067x.this.mo43935gr(gt.intValue());
            }
            AppMethodBeat.m2505o(113920);
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
            AppMethodBeat.m2504i(113921);
            C4990ab.m7416i(C26067x.TAG, "onLowMemory");
            C26067x.this.mo43935gr(2);
            C4990ab.m7416i(C26067x.TAG, "onLowMemory notification with CRITICAL end");
            AppMethodBeat.m2505o(113921);
        }
    }

    /* renamed from: com.tencent.mm.d.a.x$1 */
    class C260691 implements Runnable {
        C260691() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113919);
            C26067x.m41610a(C26067x.this);
            AppMethodBeat.m2505o(113919);
        }
    }

    static {
        AppMethodBeat.m2504i(113928);
        AppMethodBeat.m2505o(113928);
    }

    public C26067x(MultiContextV8 multiContextV8) {
        AppMethodBeat.m2504i(113922);
        this.chm = multiContextV8;
        this.ciT = new C260682();
        AppMethodBeat.m2505o(113922);
    }

    /* renamed from: gr */
    public final void mo43935gr(int i) {
        AppMethodBeat.m2504i(113923);
        if (this.ciQ) {
            C4990ab.m7416i(TAG, "notifyPressure but throttle");
            this.ciP = Integer.valueOf(i);
            AppMethodBeat.m2505o(113923);
            return;
        }
        m41611gs(i);
        AppMethodBeat.m2505o(113923);
    }

    /* renamed from: gs */
    private void m41611gs(int i) {
        String str;
        AppMethodBeat.m2504i(113924);
        C26067x.m41609CF();
        this.ciR = i;
        if (i == 2) {
            str = "CRITICAL";
        } else if (i == 1) {
            str = "MODERATE";
        } else {
            str = "NONE";
        }
        C4990ab.m7417i(TAG, "reportPressure [%s]", str);
        this.chm.memoryPressureNotification(i);
        AppMethodBeat.m2505o(113924);
    }

    /* renamed from: CF */
    private static void m41609CF() {
        AppMethodBeat.m2504i(113925);
        C4990ab.m7416i(TAG, "startThrottlingInterval");
        AppMethodBeat.m2505o(113925);
    }

    /* renamed from: a */
    static /* synthetic */ void m41610a(C26067x c26067x) {
        AppMethodBeat.m2504i(113926);
        C4990ab.m7416i(TAG, "onThrottlingIntervalFinished");
        c26067x.ciQ = false;
        if (!(c26067x.ciP == null || c26067x.ciR == c26067x.ciP.intValue())) {
            int intValue = c26067x.ciP.intValue();
            c26067x.ciP = null;
            c26067x.m41611gs(intValue);
        }
        AppMethodBeat.m2505o(113926);
    }

    /* renamed from: gt */
    static /* synthetic */ Integer m41612gt(int i) {
        AppMethodBeat.m2504i(113927);
        Integer valueOf;
        if (i >= 80 || i == 15) {
            valueOf = Integer.valueOf(2);
            AppMethodBeat.m2505o(113927);
            return valueOf;
        } else if (i >= 40) {
            valueOf = Integer.valueOf(1);
            AppMethodBeat.m2505o(113927);
            return valueOf;
        } else {
            AppMethodBeat.m2505o(113927);
            return null;
        }
    }
}
