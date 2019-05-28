package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35946rk;
import com.tencent.p177mm.protocal.protobuf.C46582rj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.model.bj */
public final class C6667bj extends C1207m implements C1918k {
    private C1202f ehi;
    private final C7472b fmP;
    public int fmQ = 0;
    public int fmR = 0;
    public int fmS = 0;
    public int type = 0;

    public C6667bj(int i, String str, String str2, String str3) {
        AppMethodBeat.m2504i(50498);
        C46582rj c46582rj = new C46582rj();
        c46582rj.Scene = i;
        c46582rj.vYA = str;
        c46582rj.nqc = str2;
        c46582rj.vYB = str3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c46582rj;
        c1196a.fsK = new C35946rk();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
        c1196a.fsI = 813;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fmP = c1196a.acD();
        this.fmP.cQh = 1;
        C4990ab.m7417i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s]", Integer.valueOf(i), c46582rj.vYA, c46582rj.nqc, c46582rj.vYB);
        AppMethodBeat.m2505o(50498);
    }

    public final int getType() {
        return 813;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(50499);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fmP, this);
        AppMethodBeat.m2505o(50499);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(50500);
        C4990ab.m7417i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C35946rk c35946rk = (C35946rk) this.fmP.fsH.fsP;
            this.fmQ = c35946rk.vYG;
            this.fmR = c35946rk.vYF;
            this.type = c35946rk.jCt;
            this.fmS = c35946rk.vYE;
            C4990ab.m7417i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", Integer.valueOf(c35946rk.vYF), Integer.valueOf(c35946rk.vYE), Integer.valueOf(c35946rk.vYG));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(50500);
    }
}
