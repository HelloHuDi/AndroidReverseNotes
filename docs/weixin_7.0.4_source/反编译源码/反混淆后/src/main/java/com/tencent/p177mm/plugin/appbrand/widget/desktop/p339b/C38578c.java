package com.tencent.p177mm.plugin.appbrand.widget.desktop.p339b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.b.c */
public enum C38578c implements FrameCallback {
    ;
    
    public Choreographer bsZ;
    public int eCJ;
    double eCK;
    private int eCL;
    public boolean eCM;
    public long frameStartTime;

    static {
        AppMethodBeat.m2505o(134243);
    }

    private C38578c(String str) {
        AppMethodBeat.m2504i(134241);
        this.frameStartTime = 0;
        this.eCJ = 0;
        this.eCK = 0.0d;
        this.eCL = 500;
        this.eCM = false;
        this.bsZ = Choreographer.getInstance();
        AppMethodBeat.m2505o(134241);
    }

    public final void doFrame(long j) {
        AppMethodBeat.m2504i(134242);
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
        AppMethodBeat.m2505o(134242);
    }
}
