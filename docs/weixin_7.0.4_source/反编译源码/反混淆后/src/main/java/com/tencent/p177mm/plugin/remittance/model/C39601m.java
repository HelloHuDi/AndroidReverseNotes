package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23425ot;
import com.tencent.p177mm.protocal.protobuf.C30211ou;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;
import java.net.URLDecoder;

/* renamed from: com.tencent.mm.plugin.remittance.model.m */
public final class C39601m extends C44428p {
    private final String TAG = "MicroMsg.NetSceneF2fDynamicCode";
    public C30211ou pPb;

    public C39601m(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.m2504i(44750);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23425ot();
        c1196a.fsK = new C30211ou();
        c1196a.fsI = 2736;
        c1196a.uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23425ot c23425ot = (C23425ot) this.ehh.fsG.fsP;
        c23425ot.nUf = i;
        c23425ot.kfT = str;
        c23425ot.pPZ = str2;
        c23425ot.vVT = URLDecoder.decode(str3);
        c23425ot.pPH = str4;
        c23425ot.pPI = str5;
        c23425ot.pQc = str6;
        c23425ot.nickname = str7;
        c23425ot.pPw = str8;
        C4990ab.m7417i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", Integer.valueOf(i), str, URLDecoder.decode(str3));
        AppMethodBeat.m2505o(44750);
    }

    public final int getType() {
        return 2736;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44751);
        C4990ab.m7417i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pPb = (C30211ou) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.pPb.kCl), this.pPb.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44751);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C30211ou c30211ou = (C30211ou) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c30211ou.kCl;
        this.AfD = c30211ou.kCm;
    }
}
