package com.tencent.p177mm.graphics.p234b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.graphics.b.d */
public enum C42123d {
    ;
    
    public WeakReference<Context> eCP;
    public HashMap<Integer, C18492a> eCQ;
    public final Object eCR;
    public boolean isRunning;
    public Timer mTimer;

    /* renamed from: com.tencent.mm.graphics.b.d$1 */
    public class C16021 extends TimerTask {
        public final void run() {
            AppMethodBeat.m2504i(57086);
            synchronized (C42123d.this.eCR) {
                try {
                    if (C42123d.this.isRunning) {
                        for (C18492a Px : C42123d.this.eCQ.values()) {
                            Px.mo33732Px();
                        }
                    } else {
                        C4990ab.m7420w("MicroMsg.PerformanceMonitor", "hy: already stopped");
                        cancel();
                    }
                } finally {
                    AppMethodBeat.m2505o(57086);
                }
            }
        }
    }

    private C42123d(String str) {
        AppMethodBeat.m2504i(57089);
        this.eCP = null;
        this.eCQ = new HashMap();
        this.isRunning = false;
        this.mTimer = null;
        this.eCR = new Object();
        AppMethodBeat.m2505o(57089);
    }

    static {
        AppMethodBeat.m2505o(57092);
    }

    /* renamed from: Py */
    public final C45408b mo67666Py() {
        C45408b c45408b;
        AppMethodBeat.m2504i(57090);
        synchronized (this.eCR) {
            try {
                if (this.eCQ != null) {
                    C18492a c18492a = (C18492a) this.eCQ.get(Integer.valueOf(2));
                    if (c18492a != null && (c18492a instanceof C45408b)) {
                        c18492a.mo33731Pw();
                        c45408b = (C45408b) c18492a;
                    }
                }
                c45408b = null;
                AppMethodBeat.m2505o(57090);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57090);
            }
        }
        return c45408b;
    }

    /* JADX WARNING: Missing block: B:14:0x0028, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(57091);
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Pz */
    public final void mo67667Pz() {
        AppMethodBeat.m2504i(57091);
        synchronized (this.eCR) {
            try {
                if (this.isRunning) {
                    if (this.mTimer != null) {
                        this.mTimer.cancel();
                    }
                    this.isRunning = false;
                    if (this.eCQ != null) {
                        this.eCQ.clear();
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57091);
            }
        }
    }
}
