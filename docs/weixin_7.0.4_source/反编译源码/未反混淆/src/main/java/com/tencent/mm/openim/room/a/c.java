package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c {
    private int ehu = 0;
    public int ehv;

    public final void mG(int i) {
        this.ehu |= i;
    }

    /* Access modifiers changed, original: final */
    public final void mH(int i) {
        AppMethodBeat.i(78980);
        this.ehu &= i ^ -1;
        if (this.ehu == 0) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.ehv);
            this.ehv = 0;
        }
        AppMethodBeat.o(78980);
    }
}
