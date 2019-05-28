package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.btd;

public abstract class e extends m implements k {
    protected boolean qtI = false;
    long qtJ = 0;

    public abstract btd ckw();

    public e(long j) {
        this.qtJ = j;
    }

    public final boolean ckv() {
        return this.qtI;
    }
}
