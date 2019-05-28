package com.tencent.p177mm.compatible.p221e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.compatible.e.x */
public final class C1432x {
    public boolean etU;
    public int etV;
    public int etW;
    public int etX;
    public int etY;
    public int etZ;
    public int eua;
    public int eub;
    public int euc;
    public int mVideoHeight;
    public int mVideoWidth;

    public C1432x() {
        AppMethodBeat.m2504i(93017);
        reset();
        AppMethodBeat.m2505o(93017);
    }

    public final void reset() {
        this.etU = false;
        this.mVideoHeight = 224;
        this.mVideoWidth = C31128d.MIC_PTU_YOUJIALI;
        this.etV = 10;
        this.etW = 3000000;
        this.etX = 1;
        this.etY = 1;
        this.etZ = 1;
        this.eua = 0;
        this.eub = 1;
        this.euc = 0;
    }
}
