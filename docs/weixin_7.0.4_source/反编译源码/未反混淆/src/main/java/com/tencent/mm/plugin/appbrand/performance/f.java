package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@TargetApi(16)
public final class f implements FrameCallback {
    private boolean OH = true;
    public a ivJ;
    private Choreographer ivZ = Choreographer.getInstance();
    private long iwa = 0;
    private int iwb = 0;
    public volatile double iwc = 0.0d;
    public long mInterval = 200;

    public interface a {
        void v(double d);
    }

    public f() {
        AppMethodBeat.i(114391);
        AppMethodBeat.o(114391);
    }

    public final void start() {
        AppMethodBeat.i(114392);
        if (this.OH) {
            AppMethodBeat.o(114392);
            return;
        }
        this.OH = true;
        ab.i("FPSMetronome", "[start] stack:%s", bo.dpG());
        this.ivZ.postFrameCallback(this);
        AppMethodBeat.o(114392);
    }

    public final void stop() {
        AppMethodBeat.i(114393);
        if (this.OH) {
            this.OH = false;
            this.iwa = 0;
            this.iwb = 0;
            ab.i("FPSMetronome", "[stop] stack:%s", bo.dpG());
            this.ivZ.removeFrameCallback(this);
            AppMethodBeat.o(114393);
            return;
        }
        AppMethodBeat.o(114393);
    }

    public final void doFrame(long j) {
        double d = 60.0d;
        AppMethodBeat.i(114394);
        if (this.OH) {
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
                        this.ivJ.v(d);
                    }
                }
            } else {
                this.iwa = j2;
            }
        }
        if (this.OH) {
            this.ivZ.postFrameCallback(this);
        }
        AppMethodBeat.o(114394);
    }
}
