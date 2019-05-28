package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

@Deprecated
public final class k extends b {
    private bcr fLF = new bcr();

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10) {
        super(1);
        AppMethodBeat.i(59999);
        this.fLF.wcB = new bts().alV(bo.nullAsNil(str));
        this.fLF.wyX = new bts().alV(bo.nullAsNil(str2));
        this.fLF.vCf = 0;
        this.fLF.wGX = new bts().alV(bo.nullAsNil(str3));
        this.fLF.wGY = new bts().alV(bo.nullAsNil(str4));
        this.fLF.jBT = 0;
        byte[] e = e.e(bo.nullAsNil(str5), 0, -1);
        this.fLF.wGU = new com.tencent.mm.bt.b(e == null ? new byte[0] : e);
        this.fLF.wGT = e == null ? 0 : e.length;
        this.fLF.guN = 0;
        this.fLF.guR = 0;
        this.fLF.guQ = bo.nullAsNil(str6);
        this.fLF.guP = bo.nullAsNil(str7);
        this.fLF.guO = bo.nullAsNil(str8);
        this.fLF.vCi = i;
        this.fLF.wBV = bo.nullAsNil(str9);
        this.fLF.wHd = 0;
        this.fLF.guS = bo.nullAsNil(str10);
        this.fLF.wBX = 0;
        this.fLF.wBW = "";
        this.oqT = this.fLF;
        AppMethodBeat.o(59999);
    }
}
