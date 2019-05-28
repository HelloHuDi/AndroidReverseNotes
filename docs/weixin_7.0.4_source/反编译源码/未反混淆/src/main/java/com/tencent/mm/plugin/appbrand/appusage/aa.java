package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;

final class aa extends a<ckn> {
    private final String bQd;
    private final ckm haE;
    private final b haF;
    private volatile w.a haG;

    public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
        AppMethodBeat.i(129709);
        ckn ckn = (ckn) btd;
        ab.i("MicroMsg.AppBrand.CgiUpdateWxaUsageRecord", "onCgiBack, req [scene %d, background %b, versionType %d, recordType %d, op %d, username %s]resp [errType %d, errCode %d, errMsg %s, resp %s]", Integer.valueOf(this.haE.scene), Integer.valueOf(this.haE.xiq), Integer.valueOf(this.haE.vOO), Integer.valueOf(this.haE.xir), Integer.valueOf(this.haE.xis), this.haE.username, Integer.valueOf(i), Integer.valueOf(i2), str, ckn);
        if (this.haG != null) {
            this.haG.a(i, i2, str, this.haF, mVar);
        }
        AppMethodBeat.o(129709);
    }

    aa(int i, boolean z, int i2, int i3, String str, int i4, String str2) {
        AppMethodBeat.i(129707);
        this.bQd = str2;
        b.a aVar = new b.a();
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
        aVar.fsJ = ckm;
        aVar.fsK = new ckn();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
        aVar.fsI = 1149;
        b acD = aVar.acD();
        this.haF = acD;
        this.ehh = acD;
        AppMethodBeat.o(129707);
    }

    static aa aN(String str, int i) {
        AppMethodBeat.i(129708);
        aa aaVar = new aa(1001, false, i, 2, str, 1, null);
        AppMethodBeat.o(129708);
        return aaVar;
    }
}
