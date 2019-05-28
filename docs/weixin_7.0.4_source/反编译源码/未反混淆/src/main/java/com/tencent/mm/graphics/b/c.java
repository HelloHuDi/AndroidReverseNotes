package com.tencent.mm.graphics.b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

public enum c implements FrameCallback {
    ;
    
    public Choreographer bsZ;
    private int eCJ;
    double eCK;
    private int eCL;
    public boolean eCM;
    private long frameStartTime;

    static {
        AppMethodBeat.o(57085);
    }

    private c(String str) {
        AppMethodBeat.i(57082);
        this.frameStartTime = 0;
        this.eCJ = 0;
        this.eCK = 0.0d;
        this.eCL = 500;
        this.eCM = false;
        this.bsZ = Choreographer.getInstance();
        AppMethodBeat.o(57082);
    }

    public final void stop() {
        AppMethodBeat.i(57083);
        this.frameStartTime = 0;
        this.eCJ = 0;
        this.eCM = false;
        ab.i("MicroMsg.Metronome", "[stop] stack:%s", bo.dpG());
        this.bsZ.removeFrameCallback(this);
        AppMethodBeat.o(57083);
    }

    public final void doFrame(long j) {
        AppMethodBeat.i(57084);
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
        AppMethodBeat.o(57084);
    }
}
