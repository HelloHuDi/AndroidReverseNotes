package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23426ov;
import com.tencent.p177mm.protocal.protobuf.C7549ow;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.model.o */
public final class C13048o extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private C23426ov pPd;
    public C7549ow pPe;

    public C13048o(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6) {
        AppMethodBeat.m2504i(44755);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23426ov();
        c1196a.fsK = new C7549ow();
        c1196a.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.pPd = (C23426ov) this.gme.fsG.fsP;
        this.pPd.vFb = str;
        this.pPd.vFc = str2;
        this.pPd.nUf = i;
        this.pPd.pPT = str3;
        this.pPd.pPS = str4;
        this.pPd.cIb = i2;
        this.pPd.pOA = i3;
        this.pPd.vVW = str5;
        this.pPd.vVX = str6;
        AppMethodBeat.m2505o(44755);
    }

    public final int getType() {
        return 2773;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44756);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44756);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44757);
        C4990ab.m7417i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pPe = (C7549ow) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pPe.kCl), this.pPe.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(44757);
    }
}
