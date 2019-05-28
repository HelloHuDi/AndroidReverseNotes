package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.ckm;
import com.tencent.p177mm.protocal.protobuf.ckn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.aa */
final class C33106aa extends C37440a<ckn> {
    private final String bQd;
    private final ckm haE;
    private final C7472b haF;
    private volatile C1224a haG;

    /* renamed from: a */
    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
        AppMethodBeat.m2504i(129709);
        ckn ckn = (ckn) btd;
        C4990ab.m7417i("MicroMsg.AppBrand.CgiUpdateWxaUsageRecord", "onCgiBack, req [scene %d, background %b, versionType %d, recordType %d, op %d, username %s]resp [errType %d, errCode %d, errMsg %s, resp %s]", Integer.valueOf(this.haE.scene), Integer.valueOf(this.haE.xiq), Integer.valueOf(this.haE.vOO), Integer.valueOf(this.haE.xir), Integer.valueOf(this.haE.xis), this.haE.username, Integer.valueOf(i), Integer.valueOf(i2), str, ckn);
        if (this.haG != null) {
            this.haG.mo4496a(i, i2, str, this.haF, c1207m);
        }
        AppMethodBeat.m2505o(129709);
    }

    C33106aa(int i, boolean z, int i2, int i3, String str, int i4, String str2) {
        AppMethodBeat.m2504i(129707);
        this.bQd = str2;
        C1196a c1196a = new C1196a();
        ckm ckm = new ckm();
        if (i == 0) {
            i = 1000;
        }
        ckm.scene = i;
        ckm.xiq = z ? 1 : 0;
        ckm.vOO = i2;
        ckm.xir = 2;
        ckm.xis = i3;
        ckm.username = str;
        ckm.boZ = i4;
        ckm.session_id = str2;
        this.haE = ckm;
        c1196a.fsJ = ckm;
        c1196a.fsK = new ckn();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
        c1196a.fsI = 1149;
        C7472b acD = c1196a.acD();
        this.haF = acD;
        this.ehh = acD;
        AppMethodBeat.m2505o(129707);
    }

    /* renamed from: aN */
    static C33106aa m54120aN(String str, int i) {
        AppMethodBeat.m2504i(129708);
        C33106aa c33106aa = new C33106aa(1001, false, i, 2, str, 1, null);
        AppMethodBeat.m2505o(129708);
        return c33106aa;
    }
}
