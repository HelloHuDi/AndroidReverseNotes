package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42991a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.d.a.a.e */
public final class C11459e {
    private final C45822g jEN = new C45822g();
    public final C41263h jEO = new C41263h();

    public C11459e() {
        AppMethodBeat.m2504i(18331);
        AppMethodBeat.m2505o(18331);
    }

    /* renamed from: ar */
    public final boolean mo23190ar(byte[] bArr) {
        AppMethodBeat.m2504i(18332);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
            AppMethodBeat.m2505o(18332);
            return false;
        }
        C42991a c42991a = new C42991a(bArr.length);
        c42991a.mo68526R(bArr, bArr.length);
        boolean a = this.jEN.mo61707a(c42991a);
        if (a) {
            a = this.jEO.mo61707a(c42991a);
            if (a) {
                AppMethodBeat.m2505o(18332);
                return a;
            }
            C4990ab.m7410d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
            AppMethodBeat.m2505o(18332);
            return a;
        }
        C4990ab.m7410d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
        AppMethodBeat.m2505o(18332);
        return a;
    }
}
