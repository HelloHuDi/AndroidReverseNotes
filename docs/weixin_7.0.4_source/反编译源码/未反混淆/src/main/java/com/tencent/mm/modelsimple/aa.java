package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.FaceMoveUtil;

public final class aa extends m implements k {
    public b ehh;
    private f ehi;
    public long fPN;

    public aa(String str, String str2, String str3, String str4) {
        this(1, str, str2, str3, str4, false, 0);
    }

    public aa(int i, String str, String str2, String str3, String str4, boolean z, int i2) {
        this(i, str, str2, str3, str4, z, i2, true);
    }

    public aa(int i, String str, String str2, String str3, String str4, boolean z, int i2, boolean z2) {
        AppMethodBeat.i(60000);
        this.fPN = 0;
        a aVar = new a();
        aVar.fsJ = new cmz();
        aVar.fsK = new cna();
        aVar.uri = "/cgi-bin/micromsg-bin/newverifypasswd";
        aVar.fsI = 384;
        aVar.fsL = FaceMoveUtil.TRIANGLE_COUNT;
        aVar.fsM = 1000000182;
        this.ehh = aVar.acD();
        cmz cmz = (cmz) this.ehh.fsG.fsP;
        cmz.OpCode = i;
        cmz.wXN = i2;
        cmz.xkw = bo.ane(str);
        cmz.vLW = bo.and(str);
        cmz.wtZ = new bts().alV(str2);
        cmz.xkx = new bts().alV(str3);
        cmz.vMa = new bts().alV(str4);
        if (i == 5 || i == 2) {
            byte[] d;
            this.fPN = new p(r.Yy()).longValue();
            if (z) {
                d = g.RN().QR().d(this.fPN, str3);
            } else {
                d = g.RN().QR().a(this.fPN, bo.ane(str), z2);
            }
            cmz.vJT = new SKBuiltinBuffer_t().setBuffer(d);
        }
        cmz.vMb = new SKBuiltinBuffer_t().setBuffer(bo.anf(bo.nullAsNil((String) g.RP().Ry().get(47, null))));
        String str5 = "MicroMsg.NetSceneVerifyPswd";
        String str6 = "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(cmz.OpCode);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Integer.valueOf(cmz.vJT == null ? -1 : cmz.vJT.getILen());
        objArr[4] = cmz.vJT == null ? BuildConfig.COMMAND : bo.anv(bo.ca(cmz.vJT.getBufferToBytes()));
        ab.i(str5, str6, objArr);
        AppMethodBeat.o(60000);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(60001);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(60001);
        return a;
    }

    public final int getType() {
        return 384;
    }

    public final String agg() {
        AppMethodBeat.i(60002);
        try {
            String str = ((cna) this.ehh.fsH.fsP).wdB;
            AppMethodBeat.o(60002);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", e, "", new Object[0]);
            AppMethodBeat.o(60002);
            return null;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(60003);
        cmz cmz = (cmz) this.ehh.fsG.fsP;
        cna cna = (cna) this.ehh.fsH.fsP;
        if (cna.vHJ != null && cna.vHJ.getILen() > 0) {
            boolean a = g.RN().QR().a(this.fPN, com.tencent.mm.platformtools.aa.a(cna.vHJ));
            ab.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", Boolean.valueOf(a), Integer.valueOf(cna.vHJ.getILen()));
        }
        if (i2 == 0 && i3 == 0) {
            g.RP().Ry().set(77830, cna.wdB);
            g.RP().Ry().set(32, cmz.xkw);
            g.RP().Ry().set(33, cmz.vLW);
            g.RP().Ry().set(46, bo.cd(com.tencent.mm.platformtools.aa.a(cna.vHP)));
            Object cd = bo.cd(com.tencent.mm.platformtools.aa.a(cmz.vMb));
            g.RP().Ry().set(47, cd);
            g.RP().eJH.set(18, cd);
            g.RP().Ry().set(-1535680990, cna.vHO);
            int iLen = cna.vHP == null ? 0 : cna.vHP.getILen();
            int length = cna.vHO == null ? 0 : cna.vHO.length();
            int length2 = cna.wdB == null ? 0 : cna.wdB.length();
            ab.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", Integer.valueOf(iLen), Integer.valueOf(length), Integer.valueOf(length2));
        } else if (i2 == 4) {
            g.RP().Ry().set(32, (Object) "");
            g.RP().Ry().set(33, (Object) "");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(60003);
    }
}
