package com.tencent.p177mm.openim.room.p266a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;

/* renamed from: com.tencent.mm.openim.room.a.c */
public final class C18743c {
    private int ehu = 0;
    public int ehv;

    /* renamed from: mG */
    public final void mo34002mG(int i) {
        this.ehu |= i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mH */
    public final void mo34003mH(int i) {
        AppMethodBeat.m2504i(78980);
        this.ehu &= i ^ -1;
        if (this.ehu == 0) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.ehv);
            this.ehv = 0;
        }
        AppMethodBeat.m2505o(78980);
    }
}
