package com.tencent.p177mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.akj;
import com.tencent.p177mm.protocal.protobuf.akk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.location.model.g */
public final class C28359g extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;
    private byte[] nJF;
    String nJG;

    public C28359g(float f, float f2, int i, int i2, int i3, String str, String str2) {
        AppMethodBeat.m2504i(113312);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akj();
        c1196a.fsK = new akk();
        c1196a.uri = "/cgi-bin/micromsg-bin/getlocimg";
        this.ehh = c1196a.acD();
        akj akj = (akj) this.ehh.fsG.fsP;
        akj.luQ = str2;
        if (C5046bo.m7558gT(C4996ah.getContext())) {
            akj.wqd = 1;
        } else {
            akj.wqd = 0;
        }
        akj.vRq = f;
        akj.vRp = f2;
        akj.wqe = i;
        C4990ab.m7417i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", Integer.valueOf(i2), Integer.valueOf(i3));
        while (i2 * i3 > 270000) {
            i2 = (int) (((double) i2) / 1.2d);
            i3 = (int) (((double) i3) / 1.2d);
        }
        C4990ab.m7417i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), akj.luQ);
        akj.Height = i3;
        akj.Width = i2;
        this.nJG = str;
        AppMethodBeat.m2505o(113312);
    }

    public final int getType() {
        return 648;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(113313);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(113313);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(113314);
        C4990ab.m7411d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        try {
            this.nJF = ((akk) ((C7472b) c1929q).fsH.fsP).vEF.getBuffer().f1226wR;
            C5730e.m8624b(this.nJG, this.nJF, this.nJF.length);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetLocImg", e, "", new Object[0]);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(113314);
    }
}
