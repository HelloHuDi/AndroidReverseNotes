package com.tencent.p177mm.plugin.wallet_ecard.p1315a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C30195je;
import com.tencent.p177mm.protocal.protobuf.C40533jf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.a.c */
public final class C22677c extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public C40533jf tQh;

    public C22677c(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.m2504i(48055);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30195je();
        c1196a.fsK = new C40533jf();
        c1196a.uri = "/cgi-bin/mmpay-bin/bindecard";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C30195je c30195je = (C30195je) this.ehh.fsG.fsP;
        c30195je.vKZ = str;
        c30195je.vLa = str2;
        c30195je.tCi = str3;
        c30195je.vLb = str4;
        c30195je.cHF = i;
        C4990ab.m7417i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", str, str2, Integer.valueOf(i), str3, str4);
        AppMethodBeat.m2505o(48055);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(48056);
        C4990ab.m7417i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tQh = (C40533jf) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tQh.kdT), this.tQh.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(48056);
    }

    public final int getType() {
        return 1986;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48057);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48057);
        return a;
    }
}
