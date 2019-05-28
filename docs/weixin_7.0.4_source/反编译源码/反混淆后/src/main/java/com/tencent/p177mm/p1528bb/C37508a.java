package com.tencent.p177mm.p1528bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.ana;
import com.tencent.p177mm.protocal.protobuf.anb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.bb.a */
public final class C37508a extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String fMC;
    public String fMD;
    public byte[] fME;

    public C37508a() {
        this(C1853r.m3846Yz(), C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(66561, null)), 0);
        AppMethodBeat.m2504i(78520);
        AppMethodBeat.m2505o(78520);
    }

    public C37508a(String str, int i) {
        this(str, i, 0);
    }

    public C37508a(String str, int i, int i2) {
        AppMethodBeat.m2504i(78521);
        this.ehi = null;
        this.fMC = null;
        this.fMD = null;
        this.fME = null;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ana();
        c1196a.fsK = new anb();
        c1196a.uri = "/cgi-bin/micromsg-bin/getqrcode";
        c1196a.fsI = 168;
        c1196a.fsL = 67;
        c1196a.fsM = 1000000067;
        this.ehh = c1196a.acD();
        ana ana = (ana) this.ehh.fsG.fsP;
        ana.wcB = C1946aa.m4154vy(str);
        ana.wrF = i;
        ana.OpCode = i2;
        C4990ab.m7417i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(78521);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78522);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78522);
        return a;
    }

    public final int getType() {
        return 168;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78523);
        C4990ab.m7410d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + i2 + " errCode" + i3);
        if (i2 == 0 && i3 == 0) {
            anb anb = (anb) this.ehh.fsH.fsP;
            String a = C1946aa.m4148a(((ana) this.ehh.fsG.fsP).wcB);
            this.fME = C1946aa.m4151a(anb.wrG, new byte[0]);
            this.fMC = anb.wrH;
            C4990ab.m7417i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", this.fMC, anb.wrI, anb.wrJ);
            if (C1853r.m3846Yz().equals(a)) {
                Object obj = anb.wrI;
                a = (String) C1720g.m3536RP().mo5239Ry().get(66563, (Object) "");
                if (!(obj == null || a.equals(obj))) {
                    C1720g.m3536RP().mo5239Ry().set(66563, obj);
                    this.fMD = anb.wrJ;
                }
                C1720g.m3536RP().mo5239Ry().set(66561, Integer.valueOf(anb.wrF));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78523);
    }
}
