package com.tencent.p177mm.graphics.p234b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.graphics.b.c */
public enum C37861c implements FrameCallback {
    ;
    
    public Choreographer bsZ;
    private int eCJ;
    double eCK;
    private int eCL;
    public boolean eCM;
    private long frameStartTime;

    static {
        AppMethodBeat.m2505o(57085);
    }

    private C37861c(String str) {
        AppMethodBeat.m2504i(57082);
        this.frameStartTime = 0;
        this.eCJ = 0;
        this.eCK = 0.0d;
        this.eCL = 500;
        this.eCM = false;
        this.bsZ = Choreographer.getInstance();
        AppMethodBeat.m2505o(57082);
    }

    public final void stop() {
        AppMethodBeat.m2504i(57083);
        this.frameStartTime = 0;
        this.eCJ = 0;
        this.eCM = false;
        C4990ab.m7417i("MicroMsg.Metronome", "[stop] stack:%s", C5046bo.dpG());
        this.bsZ.removeFrameCallback(this);
        AppMethodBeat.m2505o(57083);
    }

    public final void doFrame(long j) {
        AppMethodBeat.m2504i(57084);
        long toMillis = TimeUnit.NANOSECONDS.toMillis(j);
        if (this.frameStartTime > 0) {
            long j2 = toMillis - this.frameStartTime;
            this.eCJ++;
            if (j2 > ((long) this.eCL)) {
                this.eCK = ((double) (this.eCJ * 1000)) / ((double) j2);
                this.frameStartTime = toMillis;
                this.eCJ = 0;
            }
        } else {
            this.frameStartTime = toMillis;
        }
        this.bsZ.postFrameCallback(this);
        AppMethodBeat.m2505o(57084);
    }
}
