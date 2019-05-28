package com.tencent.p177mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C43499b;
import com.tencent.p177mm.protocal.protobuf.C35952su;
import com.tencent.p177mm.protocal.protobuf.C7283st;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.charset.Charset;

/* renamed from: com.tencent.mm.plugin.secinforeport.a */
public enum C3774a implements C43499b {
    ;

    private C3774a(String str) {
    }

    static {
        AppMethodBeat.m2505o(57474);
    }

    /* renamed from: a */
    public final void mo8445a(int i, String str, int i2, byte[] bArr) {
        AppMethodBeat.m2504i(57473);
        if (str == null) {
            C4990ab.m7420w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
            AppMethodBeat.m2505o(57473);
        } else if (C1720g.m3531RK()) {
            C7283st c7283st = new C7283st();
            c7283st.wah = i;
            c7283st.waj = i2;
            c7283st.wai = new SKBuiltinBuffer_t().setBuffer(str.getBytes(Charset.forName("UTF-8")));
            if (!C5046bo.m7540cb(bArr)) {
                c7283st.wak = new SKBuiltinBuffer_t().setBuffer(bArr);
            }
            C35952su c35952su = new C35952su();
            c35952su.wam.add(c7283st);
            c35952su.wal = c35952su.wam.size();
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(211, c35952su));
            AppMethodBeat.m2505o(57473);
        } else {
            AppMethodBeat.m2505o(57473);
        }
    }
}
