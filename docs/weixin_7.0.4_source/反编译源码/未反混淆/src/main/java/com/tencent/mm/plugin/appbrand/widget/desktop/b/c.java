package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public enum c implements FrameCallback {
    ;
    
    public Choreographer bsZ;
    public int eCJ;
    double eCK;
    private int eCL;
    public boolean eCM;
    public long frameStartTime;

    static {
        AppMethodBeat.o(134243);
    }

    private c(String str) {
        AppMethodBeat.i(134241);
        this.frameStartTime = 0;
        this.eCJ = 0;
        this.eCK = 0.0d;
        this.eCL = 500;
        this.eCM = false;
        this.bsZ = Choreographer.getInstance();
        AppMethodBeat.o(134241);
    }

    public final void doFrame(long j) {
        AppMethodBeat.i(134242);
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
        AppMethodBeat.o(134242);
    }
}
