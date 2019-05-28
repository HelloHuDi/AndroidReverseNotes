package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.su;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.charset.Charset;

public enum a implements b {
    ;

    private a(String str) {
    }

    static {
        AppMethodBeat.o(57474);
    }

    public final void a(int i, String str, int i2, byte[] bArr) {
        AppMethodBeat.i(57473);
        if (str == null) {
            ab.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
            AppMethodBeat.o(57473);
        } else if (g.RK()) {
            st stVar = new st();
            stVar.wah = i;
            stVar.waj = i2;
            stVar.wai = new SKBuiltinBuffer_t().setBuffer(str.getBytes(Charset.forName("UTF-8")));
            if (!bo.cb(bArr)) {
                stVar.wak = new SKBuiltinBuffer_t().setBuffer(bArr);
            }
            su suVar = new su();
            suVar.wam.add(stVar);
            suVar.wal = suVar.wam.size();
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(211, suVar));
            AppMethodBeat.o(57473);
        } else {
            AppMethodBeat.o(57473);
        }
    }
}
