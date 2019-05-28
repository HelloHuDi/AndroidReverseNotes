package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.DecimalFormat;

public final class b extends m implements k {
    public static int kWi = 6;
    public static int kWj = 7;
    public static int kWk = 10;
    private f eIc;
    private final com.tencent.mm.ai.b ehh;
    private String kWl;
    private EmotionPrice kWm;

    public b(String str, EmotionPrice emotionPrice) {
        AppMethodBeat.i(53093);
        a aVar = new a();
        aVar.fsJ = new fs();
        aVar.fsK = new ft();
        aVar.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
        this.ehh = aVar.acD();
        this.kWl = str;
        this.kWm = emotionPrice;
        AppMethodBeat.o(53093);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53094);
        ab.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53094);
    }

    public final int getType() {
        return 830;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53095);
        this.eIc = fVar;
        fs fsVar = (fs) this.ehh.fsG.fsP;
        fsVar.ProductID = this.kWl;
        EmotionPrice emotionPrice = new EmotionPrice();
        emotionPrice.Label = this.kWm.Label;
        emotionPrice.Type = this.kWm.Type;
        emotionPrice.Number = new DecimalFormat("0.00").format(Float.valueOf(this.kWm.Number));
        fsVar.vHC = emotionPrice;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53095);
        return a;
    }

    public final ft bkt() {
        return (ft) this.ehh.fsH.fsP;
    }
}
