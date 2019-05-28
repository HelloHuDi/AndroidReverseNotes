package com.tencent.p177mm.chatroom.p1596e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.bbt;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.chatroom.e.b */
public final class C41925b extends C3463b {
    private bbt ehG = new bbt();

    public C41925b(String str, int i) {
        super(20);
        AppMethodBeat.m2504i(103958);
        this.ehG.vEi = new bts().alV(C5046bo.nullAsNil(str));
        this.ehG.jBT = i;
        this.oqT = this.ehG;
        AppMethodBeat.m2505o(103958);
    }
}
