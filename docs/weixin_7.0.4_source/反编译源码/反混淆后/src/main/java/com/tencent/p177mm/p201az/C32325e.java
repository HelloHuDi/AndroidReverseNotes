package com.tencent.p177mm.p201az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.C23454vv;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.az.e */
public final class C32325e extends C3463b {
    private C23454vv fLz = new C23454vv();

    public C32325e(String str, long j) {
        super(9);
        AppMethodBeat.m2504i(16519);
        this.fLz.wcB = new bts().alV(C5046bo.nullAsNil(str));
        this.fLz.wcH.add(Integer.valueOf((int) j));
        this.fLz.jBv = 1;
        this.oqT = this.fLz;
        AppMethodBeat.m2505o(16519);
    }
}
