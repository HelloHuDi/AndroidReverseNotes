package com.tencent.p177mm.plugin.luckymoney.f2f.p1279a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.C15319aw;
import com.tencent.p177mm.protocal.protobuf.aab;
import com.tencent.p177mm.protocal.protobuf.aac;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44426i;

/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a.d */
public final class C21195d extends C1207m implements C1918k, C44426i {
    public String czZ;
    private C1202f ehi;
    private C7472b gme;
    public String nSX;
    private aab nUm;
    private aac nUn;
    public String nUo;

    public C21195d(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(42154);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aab();
        c1196a.fsK = new aac();
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
        this.gme = c1196a.acD();
        this.nUm = (aab) this.gme.fsG.fsP;
        this.nUm.kCd = i;
        this.nUm.pjg = i2;
        this.nUm.cRT = i3;
        this.nUm.wfj = i4;
        C15319aw cPy = C22594k.cPy();
        if (cPy != null) {
            this.nUm.latitude = cPy.latitude;
            this.nUm.longitude = cPy.longitude;
        }
        AppMethodBeat.m2505o(42154);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(42155);
        C4990ab.m7417i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.nUn = (aac) ((C7472b) c1929q).fsH.fsP;
        this.czZ = this.nUn.nYX;
        this.nSX = this.nUn.nSX;
        this.nUo = this.nUn.nZe;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(42155);
    }

    public final int getType() {
        return 1970;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(42156);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(42156);
        return a;
    }
}
