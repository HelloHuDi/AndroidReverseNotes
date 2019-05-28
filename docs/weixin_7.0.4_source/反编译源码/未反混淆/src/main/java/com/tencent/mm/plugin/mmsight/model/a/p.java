package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;

public class p implements f {
    int eTi;
    int eTj;
    volatile int frameCount = 0;
    long miD = 0;
    boolean ouL;
    long ovu = 0;
    int owR = -1;
    int owS = -1;
    int owT = -1;
    int owU = -1;
    int owV = -1;

    public p(boolean z, int i, int i2, int i3) {
        AppMethodBeat.i(76663);
        this.ouL = z;
        this.owS = i;
        this.eTi = i2;
        this.eTj = i3;
        ab.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", Boolean.valueOf(z), Integer.valueOf(this.owS), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(76663);
    }

    public final int yU(int i) {
        AppMethodBeat.i(76664);
        if (i < 0) {
            ab.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
            AppMethodBeat.o(76664);
            return -1;
        }
        this.owR = i;
        synchronized (p.class) {
            try {
                this.frameCount = 0;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(76664);
            }
        }
        this.miD = 0;
        return 0;
    }

    public final void stop() {
        synchronized (p.class) {
            this.frameCount = 0;
        }
        this.miD = 0;
    }

    public final long UQ() {
        AppMethodBeat.i(76665);
        if (0 == this.miD) {
            ab.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
            AppMethodBeat.o(76665);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.miD;
        AppMethodBeat.o(76665);
        return currentTimeMillis;
    }

    public final void clear() {
        AppMethodBeat.i(76666);
        SightVideoJNI.releaseBigSightDataBuffer(this.owR);
        this.owR = -1;
        synchronized (p.class) {
            try {
                this.frameCount = 0;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(76666);
            }
        }
        this.miD = 0;
    }
}
