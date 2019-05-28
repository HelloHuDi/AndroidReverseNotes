package com.tencent.mm.d.a;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class x {
    private static final String TAG = ("MicroMsg.V8MemoryPressureMonitor" + ah.getProcessName().replace("com.tencent.mm", ""));
    private final MultiContextV8 chm;
    private final int ciO = 1000;
    private Integer ciP = null;
    private boolean ciQ;
    private int ciR = 0;
    private final Runnable ciS = new Runnable() {
        public final void run() {
            AppMethodBeat.i(113919);
            x.a(x.this);
            AppMethodBeat.o(113919);
        }
    };
    private final ComponentCallbacks2 ciT;

    static {
        AppMethodBeat.i(113928);
        AppMethodBeat.o(113928);
    }

    public x(MultiContextV8 multiContextV8) {
        AppMethodBeat.i(113922);
        this.chm = multiContextV8;
        this.ciT = new ComponentCallbacks2() {
            public final void onTrimMemory(int i) {
                AppMethodBeat.i(113920);
                ab.i(x.TAG, "onTrimMemory level = [%d]", Integer.valueOf(i));
                Integer gt = x.gt(i);
                if (gt != null) {
                    x.this.gr(gt.intValue());
                }
                AppMethodBeat.o(113920);
            }

            public final void onConfigurationChanged(Configuration configuration) {
            }

            public final void onLowMemory() {
                AppMethodBeat.i(113921);
                ab.i(x.TAG, "onLowMemory");
                x.this.gr(2);
                ab.i(x.TAG, "onLowMemory notification with CRITICAL end");
                AppMethodBeat.o(113921);
            }
        };
        AppMethodBeat.o(113922);
    }

    public final void gr(int i) {
        AppMethodBeat.i(113923);
        if (this.ciQ) {
            ab.i(TAG, "notifyPressure but throttle");
            this.ciP = Integer.valueOf(i);
            AppMethodBeat.o(113923);
            return;
        }
        gs(i);
        AppMethodBeat.o(113923);
    }

    private void gs(int i) {
        String str;
        AppMethodBeat.i(113924);
        CF();
        this.ciR = i;
        if (i == 2) {
            str = "CRITICAL";
        } else if (i == 1) {
            str = "MODERATE";
        } else {
            str = "NONE";
        }
        ab.i(TAG, "reportPressure [%s]", str);
        this.chm.memoryPressureNotification(i);
        AppMethodBeat.o(113924);
    }

    private static void CF() {
        AppMethodBeat.i(113925);
        ab.i(TAG, "startThrottlingInterval");
        AppMethodBeat.o(113925);
    }

    static /* synthetic */ void a(x xVar) {
        AppMethodBeat.i(113926);
        ab.i(TAG, "onThrottlingIntervalFinished");
        xVar.ciQ = false;
        if (!(xVar.ciP == null || xVar.ciR == xVar.ciP.intValue())) {
            int intValue = xVar.ciP.intValue();
            xVar.ciP = null;
            xVar.gs(intValue);
        }
        AppMethodBeat.o(113926);
    }

    static /* synthetic */ Integer gt(int i) {
        AppMethodBeat.i(113927);
        Integer valueOf;
        if (i >= 80 || i == 15) {
            valueOf = Integer.valueOf(2);
            AppMethodBeat.o(113927);
            return valueOf;
        } else if (i >= 40) {
            valueOf = Integer.valueOf(1);
            AppMethodBeat.o(113927);
            return valueOf;
        } else {
            AppMethodBeat.o(113927);
            return null;
        }
    }
}
