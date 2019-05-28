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
import com.tencent.p177mm.protocal.protobuf.C44201zv;
import com.tencent.p177mm.protocal.protobuf.C44202zw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a.b */
public final class C39311b extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    public int kCl;
    public String kCm;
    private C44201zv nTZ;
    private C44202zw nUa;

    public C39311b(String str) {
        AppMethodBeat.m2504i(42148);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44201zv();
        c1196a.fsK = new C44202zw();
        c1196a.fsI = 1971;
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
        this.gme = c1196a.acD();
        this.nTZ = (C44201zv) this.gme.fsG.fsP;
        C15319aw cPy = C22594k.cPy();
        if (cPy != null) {
            this.nTZ.latitude = cPy.latitude;
            this.nTZ.longitude = cPy.longitude;
        }
        this.nTZ.wfc = str;
        AppMethodBeat.m2505o(42148);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(42149);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(42149);
        return a;
    }

    public final int getType() {
        return 1971;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(42150);
        C4990ab.m7417i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.nUa = (C44202zw) ((C7472b) c1929q).fsH.fsP;
        this.kCl = this.nUa.kCl;
        this.kCm = this.nUa.kCm;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, this.nUa.kCl, this.nUa.kCm, this);
        }
        AppMethodBeat.m2505o(42150);
    }
}
