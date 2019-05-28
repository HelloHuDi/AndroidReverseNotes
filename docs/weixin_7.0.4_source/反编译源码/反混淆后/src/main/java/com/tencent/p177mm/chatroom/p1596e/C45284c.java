package com.tencent.p177mm.chatroom.p1596e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.bor;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.chatroom.e.c */
public final class C45284c extends C3463b {
    private bor ehH = new bor();

    public C45284c(String str, String str2) {
        super(16);
        AppMethodBeat.m2504i(103959);
        this.ehH.wcB = new bts().alV(C5046bo.nullAsNil(str));
        this.ehH.vEi = new bts().alV(C5046bo.nullAsNil(str2));
        this.oqT = this.ehH;
        AppMethodBeat.m2505o(103959);
    }
}
