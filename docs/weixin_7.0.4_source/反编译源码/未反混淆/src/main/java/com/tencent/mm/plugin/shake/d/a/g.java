package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.byu;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;

public final class g extends e {
    private final b ehh;
    private f ehi;

    public g(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        float f2;
        int i4 = 1;
        int i5 = 0;
        super(j);
        AppMethodBeat.i(24616);
        a aVar = new a();
        aVar.fsJ = new byt();
        aVar.fsK = new byu();
        aVar.uri = "/cgi-bin/micromsg-bin/shaketv";
        aVar.fsL = i5;
        aVar.fsM = i5;
        this.ehh = aVar.acD();
        byt byt = (byt) this.ehh.fsG.fsP;
        byt.ptz = new SKBuiltinBuffer_t().setBuffer(bArr);
        byt.wXO = i2;
        byt.fJT = z ? 1 : i5;
        byt.wXP = (float) i;
        if (!ab.ch(ah.getContext())) {
            i4 = 2;
        }
        byt.vZF = i4;
        byt.vFE = i3;
        try {
            aw.ZK();
            f = bo.getFloat((String) c.Ry().get(ac.a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            try {
                aw.ZK();
                float f3 = bo.getFloat((String) c.Ry().get(ac.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
                try {
                    aw.ZK();
                    i5 = bo.ank((String) c.Ry().get(ac.a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
                    f2 = f3;
                } catch (Exception e) {
                    f2 = f3;
                }
            } catch (Exception e2) {
                f2 = 0.0f;
            }
        } catch (Exception e3) {
            f2 = 0.0f;
            f = 0.0f;
        }
        byt.vRq = f;
        byt.wXQ = f2;
        o.a(2009, byt.wXQ, byt.vRq, i5);
        AppMethodBeat.o(24616);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24617);
        byt byt = (byt) this.ehh.fsG.fsP;
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(byt.wXO), Integer.valueOf(byt.ptz.getILen()), Integer.valueOf(byt.fJT), Float.valueOf(byt.wXP), Integer.valueOf(byt.vZF), Integer.valueOf(byt.vFE));
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24617);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24618);
        byt byt = (byt) this.ehh.fsG.fsP;
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(byt.wXO), Integer.valueOf(((byu) this.ehh.fsH.fsP).fJT));
        if (i2 == 0 && i3 == 0 && r1.fJT == 1) {
            this.qtI = true;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24618);
    }

    public final btd ckw() {
        return (byu) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return 408;
    }
}
