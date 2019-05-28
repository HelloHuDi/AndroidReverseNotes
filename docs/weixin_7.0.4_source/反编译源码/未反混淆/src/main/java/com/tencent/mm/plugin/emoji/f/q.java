package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q extends m implements k {
    private f eIc;
    private final b ehh;
    public String kWz;
    private int kXc;

    public q(String str, int i) {
        AppMethodBeat.i(53147);
        this.kWz = str;
        if (!bo.isNullOrNil(str) && str.equals(String.valueOf(EmojiGroupInfo.yar))) {
            this.kWz = "com.tencent.xin.emoticon.tusiji";
        }
        this.kXc = i;
        a aVar = new a();
        aVar.fsJ = new bby();
        aVar.fsK = new bbz();
        aVar.uri = "/cgi-bin/micromsg-bin/modemotionpack";
        aVar.fsI = 413;
        aVar.fsL = 212;
        aVar.fsM = 1000000212;
        this.ehh = aVar.acD();
        AppMethodBeat.o(53147);
    }

    public final int getType() {
        return 413;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53148);
        this.eIc = fVar;
        bby bby = (bby) this.ehh.fsG.fsP;
        bby.ProductID = this.kWz;
        bby.OpCode = this.kXc;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53148);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(53149);
        ab.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (this.kXc == 1) {
                h.pYm.a(165, 2, 1, false);
            } else {
                h.pYm.a(165, 4, 1, false);
            }
            this.eIc.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(53149);
            return;
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        if (this.kXc == 1) {
            h.pYm.a(165, 3, 1, false);
            ab.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
            AppMethodBeat.o(53149);
            return;
        }
        h.pYm.a(165, 5, 1, false);
        ab.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", this.kWz);
        AppMethodBeat.o(53149);
    }
}
