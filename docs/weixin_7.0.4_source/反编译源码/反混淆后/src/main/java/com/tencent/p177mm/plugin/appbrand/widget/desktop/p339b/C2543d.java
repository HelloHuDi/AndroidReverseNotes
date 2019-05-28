package com.tencent.p177mm.plugin.appbrand.widget.desktop.p339b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.b.d */
public enum C2543d {
    ;
    
    private WeakReference<Context> eCP;
    public HashMap<Integer, C33603b> eCQ;
    public final Object eCR;
    public boolean isRunning;
    public Timer mTimer;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.b.d$1 */
    public class C25441 extends TimerTask {
        public final void run() {
            AppMethodBeat.m2504i(134244);
            synchronized (C2543d.this.eCR) {
                try {
                    if (C2543d.this.isRunning) {
                        for (C33603b Px : C2543d.this.eCQ.values()) {
                            Px.mo54170Px();
                        }
                    } else {
                        C4990ab.m7420w("MicroMsg.PerformanceMonitor", "hy: already stopped");
                        cancel();
                    }
                } finally {
                    AppMethodBeat.m2505o(134244);
                }
            }
        }
    }

    private C2543d(String str) {
        AppMethodBeat.m2504i(134247);
        this.eCP = null;
        this.eCQ = new HashMap();
        this.isRunning = false;
        this.mTimer = null;
        this.eCR = new Object();
        AppMethodBeat.m2505o(134247);
    }

    static {
        AppMethodBeat.m2505o(134250);
    }

    /* renamed from: Pz */
    public final void mo6510Pz() {
        AppMethodBeat.m2504i(134248);
        synchronized (this.eCR) {
            try {
                if (this.isRunning) {
                    if (this.mTimer != null) {
                        this.mTimer.cancel();
                    }
                    this.isRunning = false;
                    AppMethodBeat.m2505o(134248);
                    return;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(134248);
            }
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(134249);
        C4990ab.m7416i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
        if (this.eCQ != null) {
            this.eCQ.clear();
        }
        AppMethodBeat.m2505o(134249);
    }
}
