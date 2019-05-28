package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.LinkedList;

public final class z extends m implements k {
    private final b ehh;
    private f ehi;

    public z(String str, int i, LinkedList<df> linkedList) {
        AppMethodBeat.i(78609);
        ab.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + str + "; scene = " + i);
        a aVar = new a();
        aVar.fsJ = new cip();
        aVar.fsK = new ciq();
        aVar.uri = "/cgi-bin/mmbiz-bin/translatelink";
        aVar.fsI = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
        this.ehh = aVar.acD();
        cip cip = (cip) this.ehh.fsG.fsP;
        cip.link = str;
        cip.scene = i;
        cip.xhw = linkedList;
        AppMethodBeat.o(78609);
    }

    public final int getType() {
        return TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78610);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78610);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78611);
        ab.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78611);
    }

    public final String ajD() {
        ciq ciq = (ciq) this.ehh.fsH.fsP;
        if (ciq == null) {
            return null;
        }
        return ciq.xhx;
    }

    public final ciq ajE() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (ciq) this.ehh.fsH.fsP;
    }
}
