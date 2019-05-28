package com.tencent.p177mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.network.ae */
public final class C32859ae {
    private static C32859ae gep = null;
    private HashMap<Integer, C32860a> geq = new HashMap();

    /* renamed from: com.tencent.mm.network.ae$a */
    public interface C32860a {
        int anv();
    }

    public C32859ae() {
        AppMethodBeat.m2504i(58693);
        AppMethodBeat.m2505o(58693);
    }

    public static synchronized C32859ae anu() {
        C32859ae c32859ae;
        synchronized (C32859ae.class) {
            AppMethodBeat.m2504i(58694);
            if (gep == null) {
                gep = new C32859ae();
            }
            c32859ae = gep;
            AppMethodBeat.m2505o(58694);
        }
        return c32859ae;
    }

    /* renamed from: h */
    public final synchronized int mo53428h(int i, byte[] bArr) {
        int i2;
        AppMethodBeat.m2504i(58695);
        C32860a c32860a = (C32860a) this.geq.get(Integer.valueOf(i));
        String str = "MicroMsg.PostPushEventHandler";
        String str2 = "postEvent event:%s cb:%s data:%s [%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = c32860a;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[3] = C5046bo.dpG();
        C4990ab.m7417i(str, str2, objArr);
        if (c32860a == null) {
            String str3 = "MicroMsg.PostPushEventHandler";
            str = "postEvent cb == null  event:%s cb:%s data:%s [%s]";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(i);
            objArr2[1] = c32860a;
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr2[3] = C5046bo.dpG();
            C4990ab.m7413e(str3, str, objArr2);
            i2 = -3;
            AppMethodBeat.m2505o(58695);
        } else {
            i2 = c32860a.anv();
            AppMethodBeat.m2505o(58695);
        }
        return i2;
    }
}
