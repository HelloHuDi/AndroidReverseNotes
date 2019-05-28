package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.sdk.platformtools.ab;

public final class v extends p implements k, b {
    private final q ftU = new h();
    private long lTa = -1;
    private byte[] lTb = null;

    public final long bse() {
        return this.lTa;
    }

    public final byte[] bsf() {
        return this.lTb;
    }

    public v(int i, int i2) {
        AppMethodBeat.i(112);
        a aVar = (a) this.ftU.acF();
        aVar.lSz.wmM = p.lSV;
        aVar.lSz.jCt = 1;
        aVar.lSz.Scene = i;
        aVar.lSz.wmN = i2;
        AppMethodBeat.o(112);
    }

    /* Access modifiers changed, original: final */
    public final int g(e eVar) {
        AppMethodBeat.i(113);
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(113);
        return a;
    }

    public final int acn() {
        return 3;
    }

    public final b b(q qVar) {
        return b.EOk;
    }

    public final void a(m.a aVar) {
    }

    public final int getType() {
        return 733;
    }

    public final void c(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(114);
        ab.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        if (i == 0 && i2 == 0) {
            i.b bVar = (i.b) qVar.ZS();
            this.lTa = bVar.lSA.wmO;
            if (bVar.lSA.wmP != null) {
                this.lTb = bVar.lSA.wmP.wR;
            }
            if (bVar.lSA.wmR != null) {
                byte[] bArr;
                byte[] bArr2;
                if (bVar.lSA.wmR.vMo == null || bVar.lSA.wmR.vMo.getILen() <= 0) {
                    bArr = null;
                } else {
                    ab.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(bVar.lSA.wmR.vMo.getILen()));
                    bArr = aa.a(bVar.lSA.wmR.vMo);
                }
                if (bVar.lSA.wmR.vMp == null || bVar.lSA.wmR.vMp.getILen() <= 0) {
                    bArr2 = null;
                } else {
                    ab.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(bVar.lSA.wmR.vMp.getILen()));
                    bArr2 = aa.a(bVar.lSA.wmR.vMp);
                }
                f.afy().a(bVar.lSA.wmR.vMl, bVar.lSA.wmR.vMm, bVar.lSA.wmR.vMn, bArr, bArr2, bVar.lSA.wmR.vMq);
            }
            String str2 = "MicroMsg.NetSceneGetBioConfigRsa";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.lTa);
            objArr[1] = Integer.valueOf(this.lTb == null ? 0 : this.lTb.length);
            ab.i(str2, str3, objArr);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(114);
    }

    /* Access modifiers changed, original: final */
    public final void Lo(String str) {
        AppMethodBeat.i(115);
        ((a) this.ftU.acF()).lSz.wmM = str;
        AppMethodBeat.o(115);
    }

    /* Access modifiers changed, original: protected|final */
    public final bdv g(q qVar) {
        AppMethodBeat.i(116);
        bdv bdv = ((i.b) qVar.ZS()).lSA.wmQ;
        AppMethodBeat.o(116);
        return bdv;
    }
}
