package com.tencent.p177mm.p201az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.C40580vo;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.az.d */
public final class C45177d extends C3463b {
    private C40580vo fLy = new C40580vo();

    public C45177d(String str, long j) {
        super(8);
        AppMethodBeat.m2504i(16518);
        this.fLy.wcB = new bts().alV(C5046bo.nullAsNil(str));
        this.fLy.ptF = j;
        this.oqT = this.fLy;
        AppMethodBeat.m2505o(16518);
    }
}
