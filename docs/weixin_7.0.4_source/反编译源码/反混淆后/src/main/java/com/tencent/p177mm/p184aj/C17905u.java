package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.awt;
import com.tencent.p177mm.protocal.protobuf.awu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.u */
public final class C17905u extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    public String fwO;

    public C17905u(String str, String str2) {
        AppMethodBeat.m2504i(11450);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new awt();
        c1196a.fsK = new awu();
        c1196a.uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
        this.ehh = c1196a.acD();
        awt awt = (awt) this.ehh.fsG.fsP;
        awt.wAZ = str;
        awt.wBa = str2;
        this.fwO = str;
        AppMethodBeat.m2505o(11450);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11451);
        C4990ab.m7417i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11451);
    }

    public final int getType() {
        return 674;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11452);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneKFGetBindList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11452);
        return a;
    }

    public final awu aeM() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (awu) this.ehh.fsH.fsP;
    }
}
