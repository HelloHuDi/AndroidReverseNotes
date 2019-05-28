package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40544lx;
import com.tencent.p177mm.protocal.protobuf.C44144lw;
import com.tencent.p177mm.protocal.protobuf.C46532cz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.model.j */
public final class C21646j extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    public C40544lx pOW;

    public C21646j(C46532cz c46532cz, String str) {
        AppMethodBeat.m2504i(44741);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44144lw();
        c1196a.fsK = new C40544lx();
        c1196a.uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        C44144lw c44144lw = (C44144lw) this.gme.fsG.fsP;
        c44144lw.vPn = c46532cz;
        c44144lw.vPC = str;
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s", str, C28868a.m45886a(c46532cz));
        AppMethodBeat.m2505o(44741);
    }

    public final int getType() {
        return 2504;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44742);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44742);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44743);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOW = (C40544lx) ((C7472b) c1929q).fsH.fsP;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.pOW.tBw != null) {
            stringBuffer.append("response: " + this.pOW.vPQ);
            stringBuffer.append("is_show_btn: " + this.pOW.tBw.wex);
            if (this.pOW.tBw.wew != null) {
                stringBuffer.append("single_exposure_info_list " + this.pOW.tBw.wew.size());
            }
        }
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", Integer.valueOf(this.pOW.kdT), this.pOW.kdU, stringBuffer.toString());
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(44743);
    }
}
