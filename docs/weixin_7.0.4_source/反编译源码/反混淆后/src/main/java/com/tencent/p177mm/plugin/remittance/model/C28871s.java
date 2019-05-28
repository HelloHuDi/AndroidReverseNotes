package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15373py;
import com.tencent.p177mm.protocal.protobuf.C30216pz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.model.s */
public final class C28871s extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    public C30216pz pPj;

    public C28871s(String str, String str2, String str3, String str4, long j, String str5) {
        AppMethodBeat.m2504i(44764);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15373py();
        c1196a.fsK = new C30216pz();
        c1196a.uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        C15373py c15373py = (C15373py) this.gme.fsG.fsP;
        c15373py.cBT = str;
        c15373py.vWY = str2;
        c15373py.pQe = str3;
        c15373py.pPZ = str4;
        c15373py.pSg = j;
        c15373py.vWF = str5;
        C4990ab.m7417i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", str, str2, Long.valueOf(j));
        AppMethodBeat.m2505o(44764);
    }

    public final int getType() {
        return 1779;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44765);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44765);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44766);
        C4990ab.m7417i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pPj = (C30216pz) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pPj.kCl), this.pPj.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(44766);
    }
}
