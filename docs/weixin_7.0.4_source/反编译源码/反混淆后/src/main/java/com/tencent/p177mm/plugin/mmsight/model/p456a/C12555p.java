package com.tencent.p177mm.plugin.mmsight.model.p456a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.p */
public class C12555p implements C21292f {
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

    public C12555p(boolean z, int i, int i2, int i3) {
        AppMethodBeat.m2504i(76663);
        this.ouL = z;
        this.owS = i;
        this.eTi = i2;
        this.eTj = i3;
        C4990ab.m7417i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", Boolean.valueOf(z), Integer.valueOf(this.owS), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.m2505o(76663);
    }

    /* renamed from: yU */
    public final int mo24478yU(int i) {
        AppMethodBeat.m2504i(76664);
        if (i < 0) {
            C4990ab.m7412e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
            AppMethodBeat.m2505o(76664);
            return -1;
        }
        this.owR = i;
        synchronized (C12555p.class) {
            try {
                this.frameCount = 0;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(76664);
            }
        }
        this.miD = 0;
        return 0;
    }

    public final void stop() {
        synchronized (C12555p.class) {
            this.frameCount = 0;
        }
        this.miD = 0;
    }

    /* renamed from: UQ */
    public final long mo24475UQ() {
        AppMethodBeat.m2504i(76665);
        if (0 == this.miD) {
            C4990ab.m7420w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
            AppMethodBeat.m2505o(76665);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.miD;
        AppMethodBeat.m2505o(76665);
        return currentTimeMillis;
    }

    public final void clear() {
        AppMethodBeat.m2504i(76666);
        SightVideoJNI.releaseBigSightDataBuffer(this.owR);
        this.owR = -1;
        synchronized (C12555p.class) {
            try {
                this.frameCount = 0;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(76666);
            }
        }
        this.miD = 0;
    }
}
