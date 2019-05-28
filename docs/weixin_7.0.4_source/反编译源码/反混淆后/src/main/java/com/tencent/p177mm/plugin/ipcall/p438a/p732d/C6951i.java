package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.protocal.protobuf.bma;
import com.tencent.p177mm.protocal.protobuf.bmb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.i */
public final class C6951i extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;
    public bma nyw = null;
    public bmb nyx = null;

    public C6951i(String str, String str2, int i, int i2, int i3) {
        AppMethodBeat.m2504i(21860);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bma();
        c1196a.fsK = new bmb();
        c1196a.fsI = 991;
        c1196a.uri = "/cgi-bin/micromsg-bin/pstninvite";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        long currentTimeMillis = System.currentTimeMillis();
        int bIP = C34382c.bIP();
        bma bma = (bma) this.ehh.fsG.fsP;
        bma.ndG = C1853r.m3846Yz();
        bma.wOR = str2;
        bma.ndF = str;
        bma.wOQ = i;
        bma.vZF = bIP;
        bma.wOZ = 1;
        bma.wOP = currentTimeMillis;
        bma.wOY = i2;
        bma.wPa = i3;
        this.nyw = bma;
        C4990ab.m7417i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", str, str2, Integer.valueOf(i), Integer.valueOf(bIP), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.m2505o(21860);
    }

    public final int getType() {
        return 991;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21861);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21861);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21862);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyx = (bmb) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.m2505o(21862);
            return;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21862);
    }
}
