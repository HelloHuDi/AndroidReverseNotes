package com.tencent.p177mm.p201az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.C7286vl;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.az.c */
public final class C37498c extends C3463b {
    private C7286vl fLx;
    public String username;

    public C37498c(String str) {
        this(str, 0);
        this.username = str;
    }

    public C37498c(String str, int i) {
        super(4);
        AppMethodBeat.m2504i(988);
        this.fLx = new C7286vl();
        this.fLx.wcB = new bts().alV(C5046bo.nullAsNil(str));
        this.fLx.wcC = i;
        this.oqT = this.fLx;
        AppMethodBeat.m2505o(988);
    }
}
