package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h {
    long bZI;
    long beginTime;
    boolean cRY;
    long endTime;
    long fSW;
    long fSX;
    int rtType;

    public h(int i, boolean z, long j) {
        this.rtType = i;
        this.cRY = z;
        this.fSW = j;
        this.fSX = 0;
    }

    public final void akj() {
        AppMethodBeat.i(78735);
        if (this.fSX == 0) {
            this.beginTime = bo.anU();
            this.bZI = bo.yz();
        }
        this.fSX++;
        AppMethodBeat.o(78735);
    }

    public final void fS(long j) {
        AppMethodBeat.i(78736);
        if (this.fSW == 0) {
            this.fSW = j;
        }
        this.bZI = bo.yz() - this.bZI;
        this.endTime = bo.anU();
        ab.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.fSW + " Count:" + this.fSX + " type:" + this.rtType);
        WatchDogPushReceiver.a(this);
        AppMethodBeat.o(78736);
    }
}
