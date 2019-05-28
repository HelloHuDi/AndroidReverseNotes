package com.tencent.p177mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelstat.h */
public final class C42220h {
    long bZI;
    long beginTime;
    boolean cRY;
    long endTime;
    long fSW;
    long fSX;
    int rtType;

    public C42220h(int i, boolean z, long j) {
        this.rtType = i;
        this.cRY = z;
        this.fSW = j;
        this.fSX = 0;
    }

    public final void akj() {
        AppMethodBeat.m2504i(78735);
        if (this.fSX == 0) {
            this.beginTime = C5046bo.anU();
            this.bZI = C5046bo.m7588yz();
        }
        this.fSX++;
        AppMethodBeat.m2505o(78735);
    }

    /* renamed from: fS */
    public final void mo67750fS(long j) {
        AppMethodBeat.m2504i(78736);
        if (this.fSW == 0) {
            this.fSW = j;
        }
        this.bZI = C5046bo.m7588yz() - this.bZI;
        this.endTime = C5046bo.anU();
        C4990ab.m7410d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.fSW + " Count:" + this.fSX + " type:" + this.rtType);
        WatchDogPushReceiver.m29199a(this);
        AppMethodBeat.m2505o(78736);
    }
}
