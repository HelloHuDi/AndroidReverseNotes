package com.tencent.p177mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.appbrand.performance.f */
public final class C27258f implements FrameCallback {
    /* renamed from: OH */
    private boolean f13679OH = true;
    public C27259a ivJ;
    private Choreographer ivZ = Choreographer.getInstance();
    private long iwa = 0;
    private int iwb = 0;
    public volatile double iwc = 0.0d;
    public long mInterval = 200;

    /* renamed from: com.tencent.mm.plugin.appbrand.performance.f$a */
    public interface C27259a {
        /* renamed from: v */
        void mo44934v(double d);
    }

    public C27258f() {
        AppMethodBeat.m2504i(114391);
        AppMethodBeat.m2505o(114391);
    }

    public final void start() {
        AppMethodBeat.m2504i(114392);
        if (this.f13679OH) {
            AppMethodBeat.m2505o(114392);
            return;
        }
        this.f13679OH = true;
        C4990ab.m7417i("FPSMetronome", "[start] stack:%s", C5046bo.dpG());
        this.ivZ.postFrameCallback(this);
        AppMethodBeat.m2505o(114392);
    }

    public final void stop() {
        AppMethodBeat.m2504i(114393);
        if (this.f13679OH) {
            this.f13679OH = false;
            this.iwa = 0;
            this.iwb = 0;
            C4990ab.m7417i("FPSMetronome", "[stop] stack:%s", C5046bo.dpG());
            this.ivZ.removeFrameCallback(this);
            AppMethodBeat.m2505o(114393);
            return;
        }
        AppMethodBeat.m2505o(114393);
    }

    public final void doFrame(long j) {
        double d = 60.0d;
        AppMethodBeat.m2504i(114394);
        if (this.f13679OH) {
            long j2 = j / 1000000;
            if (this.iwa > 0) {
                long j3 = j2 - this.iwa;
                this.iwb++;
                if (j3 > this.mInterval) {
                    double d2 = ((double) (this.iwb * 1000)) / ((double) j3);
                    if (d2 < 60.0d) {
                        d = d2;
                    }
                    this.iwa = j2;
                    this.iwb = 0;
                    this.iwc = d;
                    if (this.ivJ != null) {
                        this.ivJ.mo44934v(d);
                    }
                }
            } else {
                this.iwa = j2;
            }
        }
        if (this.f13679OH) {
            this.ivZ.postFrameCallback(this);
        }
        AppMethodBeat.m2505o(114394);
    }
}
