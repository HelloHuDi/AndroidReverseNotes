package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.ajr;
import com.tencent.p177mm.protocal.protobuf.ajs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.e */
public final class C28287e extends C44428p {
    private final String TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    public ajs nqB;

    public C28287e(String str) {
        AppMethodBeat.m2504i(41725);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ajr();
        c1196a.fsK = new ajs();
        c1196a.fsI = Exif.PARSE_EXIF_ERROR_NO_EXIF;
        c1196a.uri = "/cgi-bin/mmpay-bin/gethpcard";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ajr ajr = (ajr) this.ehh.fsG.fsP;
        ajr.wpp = str;
        ajr.woh = C22594k.bQO();
        C4990ab.m7417i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", str);
        AppMethodBeat.m2505o(41725);
    }

    public final int getType() {
        return Exif.PARSE_EXIF_ERROR_NO_EXIF;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41726);
        C4990ab.m7417i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqB = (ajs) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqB.kdT), this.nqB.kdU);
        if (this.nqB.wpq != null) {
            C28289c.m44879U(this.nqB.wpq.cJF, this.nqB.wpq.vQO, this.nqB.wpq.ubv);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41726);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        ajs ajs = (ajs) ((C7472b) c1929q).fsH.fsP;
        this.AfC = ajs.kdT;
        this.AfD = ajs.kdU;
    }
}
