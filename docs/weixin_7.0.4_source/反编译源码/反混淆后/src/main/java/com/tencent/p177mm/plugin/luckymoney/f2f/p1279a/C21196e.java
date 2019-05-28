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
import com.tencent.p177mm.protocal.protobuf.C23472zz;
import com.tencent.p177mm.protocal.protobuf.aaa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a.e */
public final class C21196e extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    public String lvz;
    public String nSX;
    private C23472zz nUp;
    private aaa nUq;
    public String nUr;
    public String nUs;
    public int nUt;

    public C21196e() {
        AppMethodBeat.m2504i(42157);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23472zz();
        c1196a.fsK = new aaa();
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
        this.gme = c1196a.acD();
        this.nUp = (C23472zz) this.gme.fsG.fsP;
        this.nUp.timestamp = System.currentTimeMillis() / 1000;
        C15319aw cPy = C22594k.cPy();
        if (cPy != null) {
            this.nUp.latitude = cPy.latitude;
            this.nUp.longitude = cPy.longitude;
        }
        AppMethodBeat.m2505o(42157);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(42158);
        C4990ab.m7417i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.nUq = (aaa) ((C7472b) c1929q).fsH.fsP;
        this.nSX = this.nUq.nSX;
        this.lvz = this.nUq.lvz;
        this.nUt = this.nUq.wfi;
        this.nUr = this.nUq.nUr;
        this.nUs = this.nUq.nUs;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, this.nUq.kCl, this.nUq.kCm, this);
        }
        AppMethodBeat.m2505o(42158);
    }

    public final int getType() {
        return 1990;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(42159);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(42159);
        return a;
    }
}
