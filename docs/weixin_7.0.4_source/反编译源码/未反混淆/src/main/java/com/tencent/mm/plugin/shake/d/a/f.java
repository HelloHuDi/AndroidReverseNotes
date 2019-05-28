package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.aw.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class f extends e {
    private final b ehh;
    private com.tencent.mm.ai.f ehi;

    public f(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        int ank;
        super(j);
        AppMethodBeat.i(24613);
        a aVar = new a();
        aVar.fsJ = new byp();
        aVar.fsK = new byq();
        aVar.uri = "/cgi-bin/micromsg-bin/shakemusic";
        aVar.fsL = ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
        aVar.fsM = 1000000177;
        this.ehh = aVar.acD();
        byp byp = (byp) this.ehh.fsG.fsP;
        byp.ptz = new SKBuiltinBuffer_t().setBuffer(bArr);
        byp.wXO = i2;
        byp.fJT = z ? 1 : 0;
        byp.wXP = (float) i;
        byp.vZF = ab.ch(ah.getContext()) ? 1 : 2;
        byp.vFE = i3;
        float f = 0.0f;
        float f2 = 0.0f;
        try {
            aw.ZK();
            f = bo.getFloat((String) c.Ry().get(ac.a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            aw.ZK();
            f2 = bo.getFloat((String) c.Ry().get(ac.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
            aw.ZK();
            ank = bo.ank((String) c.Ry().get(ac.a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
        } catch (Exception e) {
            ank = 0;
        }
        byp.vRq = f;
        byp.wXQ = f2;
        byp.wrA = d.aio() ? 0 : 1;
        byp.wrB = d.ain() ? 1 : 0;
        o.a(2014, byp.wXQ, byp.vRq, ank);
        AppMethodBeat.o(24613);
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(24614);
        byp byp = (byp) this.ehh.fsG.fsP;
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(byp.wXO), Integer.valueOf(byp.ptz.getILen()), Integer.valueOf(byp.fJT), Float.valueOf(byp.wXP), Integer.valueOf(byp.vZF), Integer.valueOf(byp.vFE));
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24614);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24615);
        byp byp = (byp) this.ehh.fsG.fsP;
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(byp.wXO), Integer.valueOf(((byq) this.ehh.fsH.fsP).fJT));
        if (i2 == 0 && i3 == 0 && r1.fJT == 1) {
            this.qtI = true;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24615);
    }

    public final btd ckw() {
        return (byq) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return 367;
    }
}
