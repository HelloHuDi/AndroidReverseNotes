package com.tencent.p177mm.p201az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.bcr;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

@Deprecated
/* renamed from: com.tencent.mm.az.k */
public final class C6335k extends C3463b {
    private bcr fLF = new bcr();

    public C6335k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10) {
        super(1);
        AppMethodBeat.m2504i(59999);
        this.fLF.wcB = new bts().alV(C5046bo.nullAsNil(str));
        this.fLF.wyX = new bts().alV(C5046bo.nullAsNil(str2));
        this.fLF.vCf = 0;
        this.fLF.wGX = new bts().alV(C5046bo.nullAsNil(str3));
        this.fLF.wGY = new bts().alV(C5046bo.nullAsNil(str4));
        this.fLF.jBT = 0;
        byte[] e = C5730e.m8632e(C5046bo.nullAsNil(str5), 0, -1);
        this.fLF.wGU = new C1332b(e == null ? new byte[0] : e);
        this.fLF.wGT = e == null ? 0 : e.length;
        this.fLF.guN = 0;
        this.fLF.guR = 0;
        this.fLF.guQ = C5046bo.nullAsNil(str6);
        this.fLF.guP = C5046bo.nullAsNil(str7);
        this.fLF.guO = C5046bo.nullAsNil(str8);
        this.fLF.vCi = i;
        this.fLF.wBV = C5046bo.nullAsNil(str9);
        this.fLF.wHd = 0;
        this.fLF.guS = C5046bo.nullAsNil(str10);
        this.fLF.wBX = 0;
        this.fLF.wBW = "";
        this.oqT = this.fLF;
        AppMethodBeat.m2505o(59999);
    }
}
