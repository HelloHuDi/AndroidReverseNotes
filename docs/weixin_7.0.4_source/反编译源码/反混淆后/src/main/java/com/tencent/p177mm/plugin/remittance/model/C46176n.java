package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44155pk;
import com.tencent.p177mm.protocal.protobuf.C44156pl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.model.n */
public final class C46176n extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private C44155pk pPc;

    public C46176n(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.m2504i(44752);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44155pk();
        c1196a.fsK = new C44156pl();
        c1196a.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.pPc = (C44155pk) this.gme.fsG.fsP;
        this.pPc.vFb = str;
        this.pPc.vFc = str2;
        this.pPc.vWF = str3;
        this.pPc.vWG = str4;
        this.pPc.nUf = i;
        C4990ab.m7411d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", str, str2, str3, Integer.valueOf(i));
        AppMethodBeat.m2505o(44752);
    }

    public final int getType() {
        return 1273;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44753);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44753);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44754);
        C4990ab.m7417i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(44754);
    }
}
