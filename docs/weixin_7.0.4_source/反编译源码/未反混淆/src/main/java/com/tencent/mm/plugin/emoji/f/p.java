package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.amk;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

public final class p extends m implements k {
    private final b ehh;
    private f ehi;
    private int gOW;
    public byte[] kWS;
    private int kXd;

    public p(int i, byte[] bArr) {
        this(i, bArr, (byte) 0);
    }

    private p(int i, byte[] bArr, byte b) {
        AppMethodBeat.i(53143);
        this.kWS = null;
        a aVar = new a();
        aVar.fsJ = new amk();
        aVar.fsK = new aml();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
        aVar.fsI = 720;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.kXd = i;
        this.kWS = bArr;
        this.gOW = 0;
        AppMethodBeat.o(53143);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53144);
        ab.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        aml aml = (aml) ((b) qVar).fsH.fsP;
        if (aml.ReqBuf != null) {
            this.kWS = aa.a(aml.ReqBuf);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53144);
    }

    public final int getType() {
        return 720;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53145);
        this.ehi = fVar;
        amk amk = (amk) this.ehh.fsG.fsP;
        amk.DesignerUin = this.kXd;
        if (this.kWS != null) {
            amk.ReqBuf = aa.ad(this.kWS);
        } else {
            amk.ReqBuf = new SKBuiltinBuffer_t();
        }
        amk.Scene = this.gOW;
        ab.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", amk.ReqBuf == null ? "Buf is NULL" : amk.ReqBuf.toString());
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53145);
        return a;
    }

    public final aml bkE() {
        if (this.ehh == null) {
            return null;
        }
        return (aml) this.ehh.fsH.fsP;
    }

    public static com.tencent.mm.plugin.emoji.model.f a(aml aml) {
        AppMethodBeat.i(53146);
        ab.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
        if (aml == null) {
            AppMethodBeat.o(53146);
            return null;
        }
        com.tencent.mm.plugin.emoji.model.f fVar = new com.tencent.mm.plugin.emoji.model.f();
        if (!(aml == null || aml.EmotionList == null)) {
            fVar.kVp = aml.EmotionList.size();
            ArrayList arrayList = new ArrayList();
            Iterator it = aml.EmotionList.iterator();
            while (it.hasNext()) {
                EmotionSummary emotionSummary = (EmotionSummary) it.next();
                if (emotionSummary.ProductID != null) {
                    arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(emotionSummary));
                }
            }
            fVar.kVq = arrayList;
        }
        AppMethodBeat.o(53146);
        return fVar;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 100;
    }
}
