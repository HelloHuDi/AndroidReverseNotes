package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cmz;
import com.tencent.p177mm.protocal.protobuf.cna;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.FaceMoveUtil;

/* renamed from: com.tencent.mm.modelsimple.aa */
public final class C9703aa extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    public long fPN;

    public C9703aa(String str, String str2, String str3, String str4) {
        this(1, str, str2, str3, str4, false, 0);
    }

    public C9703aa(int i, String str, String str2, String str3, String str4, boolean z, int i2) {
        this(i, str, str2, str3, str4, z, i2, true);
    }

    public C9703aa(int i, String str, String str2, String str3, String str4, boolean z, int i2, boolean z2) {
        AppMethodBeat.m2504i(60000);
        this.fPN = 0;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cmz();
        c1196a.fsK = new cna();
        c1196a.uri = "/cgi-bin/micromsg-bin/newverifypasswd";
        c1196a.fsI = 384;
        c1196a.fsL = FaceMoveUtil.TRIANGLE_COUNT;
        c1196a.fsM = 1000000182;
        this.ehh = c1196a.acD();
        cmz cmz = (cmz) this.ehh.fsG.fsP;
        cmz.OpCode = i;
        cmz.wXN = i2;
        cmz.xkw = C5046bo.ane(str);
        cmz.vLW = C5046bo.and(str);
        cmz.wtZ = new bts().alV(str2);
        cmz.xkx = new bts().alV(str3);
        cmz.vMa = new bts().alV(str4);
        if (i == 5 || i == 2) {
            byte[] d;
            this.fPN = new C1183p(C1853r.m3845Yy()).longValue();
            if (z) {
                d = C1720g.m3534RN().mo5158QR().mo4504d(this.fPN, str3);
            } else {
                d = C1720g.m3534RN().mo5158QR().mo4503a(this.fPN, C5046bo.ane(str), z2);
            }
            cmz.vJT = new SKBuiltinBuffer_t().setBuffer(d);
        }
        cmz.vMb = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(47, null))));
        String str5 = "MicroMsg.NetSceneVerifyPswd";
        String str6 = "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(cmz.OpCode);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Integer.valueOf(cmz.vJT == null ? -1 : cmz.vJT.getILen());
        objArr[4] = cmz.vJT == null ? BuildConfig.COMMAND : C5046bo.anv(C5046bo.m7539ca(cmz.vJT.getBufferToBytes()));
        C4990ab.m7417i(str5, str6, objArr);
        AppMethodBeat.m2505o(60000);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(60001);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(60001);
        return a;
    }

    public final int getType() {
        return 384;
    }

    public final String agg() {
        AppMethodBeat.m2504i(60002);
        try {
            String str = ((cna) this.ehh.fsH.fsP).wdB;
            AppMethodBeat.m2505o(60002);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", e, "", new Object[0]);
            AppMethodBeat.m2505o(60002);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(60003);
        cmz cmz = (cmz) this.ehh.fsG.fsP;
        cna cna = (cna) this.ehh.fsH.fsP;
        if (cna.vHJ != null && cna.vHJ.getILen() > 0) {
            boolean a = C1720g.m3534RN().mo5158QR().mo4502a(this.fPN, C1946aa.m4150a(cna.vHJ));
            C4990ab.m7417i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", Boolean.valueOf(a), Integer.valueOf(cna.vHJ.getILen()));
        }
        if (i2 == 0 && i3 == 0) {
            C1720g.m3536RP().mo5239Ry().set(77830, cna.wdB);
            C1720g.m3536RP().mo5239Ry().set(32, cmz.xkw);
            C1720g.m3536RP().mo5239Ry().set(33, cmz.vLW);
            C1720g.m3536RP().mo5239Ry().set(46, C5046bo.m7543cd(C1946aa.m4150a(cna.vHP)));
            Object cd = C5046bo.m7543cd(C1946aa.m4150a(cmz.vMb));
            C1720g.m3536RP().mo5239Ry().set(47, cd);
            C1720g.m3536RP().eJH.set(18, cd);
            C1720g.m3536RP().mo5239Ry().set(-1535680990, cna.vHO);
            int iLen = cna.vHP == null ? 0 : cna.vHP.getILen();
            int length = cna.vHO == null ? 0 : cna.vHO.length();
            int length2 = cna.wdB == null ? 0 : cna.wdB.length();
            C4990ab.m7417i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", Integer.valueOf(iLen), Integer.valueOf(length), Integer.valueOf(length2));
        } else if (i2 == 4) {
            C1720g.m3536RP().mo5239Ry().set(32, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(33, (Object) "");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(60003);
    }
}
