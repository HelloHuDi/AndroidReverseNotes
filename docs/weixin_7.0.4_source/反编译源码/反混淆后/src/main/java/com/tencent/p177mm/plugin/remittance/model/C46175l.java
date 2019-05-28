package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44145mb;
import com.tencent.p177mm.protocal.protobuf.C46532cz;
import com.tencent.p177mm.protocal.protobuf.C46563ma;
import com.tencent.p177mm.protocal.protobuf.chl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.p760d.C24157d;

/* renamed from: com.tencent.mm.plugin.remittance.model.l */
public final class C46175l extends C1207m implements C1918k, C44426i, C24157d {
    public String czZ;
    private C1202f ehi;
    private C7472b gme;
    public boolean lSR = false;
    public C44145mb pOY;
    public boolean pOZ = false;
    private C46563ma pPa;

    public C46175l(chl chl, C46532cz c46532cz, String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(44747);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46563ma();
        c1196a.fsK = new C44145mb();
        c1196a.fsI = 2682;
        c1196a.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.pPa = (C46563ma) this.gme.fsG.fsP;
        this.pPa.vPn = c46532cz;
        this.pPa.vPH = chl;
        this.pPa.vPI = str;
        this.pPa.vPV = i;
        this.pPa.token = str2;
        this.czZ = str3;
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", str2, C28868a.m45886a(c46532cz), str);
        AppMethodBeat.m2505o(44747);
    }

    public final int getType() {
        return 2682;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44748);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44748);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44749);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOY = (C44145mb) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOY.kdT), this.pOY.kdU);
        if (this.ehi != null) {
            boolean z;
            if (this.pOY.vPW == 1) {
                z = true;
            } else {
                z = false;
            }
            this.lSR = z;
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(44749);
    }

    public final boolean cfp() {
        return this.pOZ;
    }
}
