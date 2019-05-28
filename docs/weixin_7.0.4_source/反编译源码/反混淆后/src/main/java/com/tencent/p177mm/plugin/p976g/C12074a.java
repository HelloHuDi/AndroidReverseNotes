package com.tencent.p177mm.plugin.p976g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.protocal.protobuf.C7273mw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.g.a */
public final class C12074a extends C7485q implements C19933a {
    private static C12074a ksU;

    private C12074a() {
        super(C37461f.class);
    }

    public static synchronized C12074a beP() {
        C12074a c12074a;
        synchronized (C12074a.class) {
            AppMethodBeat.m2504i(79085);
            if (ksU == null) {
                ksU = new C12074a();
            }
            c12074a = ksU;
            AppMethodBeat.m2505o(79085);
        }
        return c12074a;
    }

    /* renamed from: a */
    public final void mo5415a(C4825f c4825f, C4826g c4826g, boolean z) {
    }

    /* renamed from: a */
    public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(79086);
        if (c4844b.vyJ.luF != 0) {
            final C7273mw c7273mw = c4844b.vyJ.vMl;
            final C7273mw c7273mw2 = c4844b.vyJ.vMm;
            final C7273mw c7273mw3 = c4844b.vyJ.vMn;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(79084);
                    C1446a c1446a = new C1446a();
                    long j = -1;
                    C37461f.afu();
                    if (!(C37461f.afw() == null || c7273mw == null)) {
                        C37461f.afu();
                        C37461f.afw().mo4512a(c7273mw, c7273mw2, c7273mw3);
                        j = c1446a.mo4908Mr();
                    }
                    C4990ab.m7411d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", Long.valueOf(c1446a.mo4908Mr()), Long.valueOf(j));
                    AppMethodBeat.m2505o(79084);
                }
            });
        }
        AppMethodBeat.m2505o(79086);
    }
}
