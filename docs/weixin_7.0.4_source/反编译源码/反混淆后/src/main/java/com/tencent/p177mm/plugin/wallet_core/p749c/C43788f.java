package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.amg;
import com.tencent.p177mm.protocal.protobuf.amh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.f */
public final class C43788f extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String ttP = "";
    public boolean ttQ = false;

    public C43788f() {
        AppMethodBeat.m2504i(46503);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new amg();
        c1196a.fsK = new amh();
        c1196a.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
        c1196a.fsI = 2541;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(46503);
    }

    public final int getType() {
        return 2541;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46504);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46504);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46505);
        C4990ab.m7410d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            amh amh = (amh) ((C7472b) c1929q).fsH.fsP;
            this.ttP = amh.ttP;
            this.ttQ = amh.ttQ;
            C4990ab.m7417i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", this.ttP, Boolean.valueOf(this.ttQ));
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(46505);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(46505);
    }
}
