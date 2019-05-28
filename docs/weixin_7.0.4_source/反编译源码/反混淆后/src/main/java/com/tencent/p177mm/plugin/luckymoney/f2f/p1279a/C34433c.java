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
import com.tencent.p177mm.protocal.protobuf.C23470zx;
import com.tencent.p177mm.protocal.protobuf.C23471zy;
import com.tencent.p177mm.protocal.protobuf.bpt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a.c */
public final class C34433c extends C1207m implements C1918k {
    public int cRU;
    public int cvG;
    private C1202f ehi;
    private C7472b gme;
    public String nSX;
    private C23470zx nUb;
    private C23471zy nUc;
    public int nUd;
    public String nUe;
    public int nUf;
    public bpt nUg;
    public int nUh;
    public String nUi;
    public String nUj;
    public String nUk;
    public int nUl;

    public C34433c(String str) {
        AppMethodBeat.m2504i(42151);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23470zx();
        c1196a.fsK = new C23471zy();
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
        this.gme = c1196a.acD();
        this.nUb = (C23470zx) this.gme.fsG.fsP;
        this.nUb.lvz = str;
        C15319aw cPy = C22594k.cPy();
        if (cPy != null) {
            this.nUb.dud = cPy.dud;
            this.nUb.duc = cPy.duc;
            this.nUb.wfd = cPy.vCF;
            this.nUb.wfe = cPy.vCG;
            this.nUb.wff = cPy.vCE;
            this.nUb.wfg = cPy.latitude;
            this.nUb.wfh = cPy.longitude;
        }
        AppMethodBeat.m2505o(42151);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(42152);
        this.nUc = (C23471zy) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", Integer.valueOf(i2), Integer.valueOf(this.nUc.kCl), this.nUc.kCm);
        this.nSX = this.nUc.nSX;
        this.cRU = this.nUc.cRU;
        this.nUd = this.nUc.cRV;
        this.cvG = this.nUc.cvG;
        this.nUe = this.nUc.nXl;
        this.nUf = this.nUc.nUf;
        this.nUg = this.nUc.vWf;
        this.nUh = this.nUc.nUh;
        this.nUi = this.nUc.nUi;
        this.nUj = this.nUc.nUj;
        this.nUk = this.nUc.nUk;
        this.nUl = this.nUc.nUl;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, this.nUc.kCl, this.nUc.kCm, this);
        }
        AppMethodBeat.m2505o(42152);
    }

    public final int getType() {
        return 1997;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(42153);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(42153);
        return a;
    }
}
