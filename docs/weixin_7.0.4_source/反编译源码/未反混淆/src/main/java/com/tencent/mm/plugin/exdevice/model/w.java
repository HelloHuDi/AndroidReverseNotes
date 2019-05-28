package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.sdk.platformtools.ab;

public final class w extends m implements k {
    private f eIc = null;
    String ltH;
    public b lty = null;

    public w(long j, String str, String str2, long j2, long j3, byte[] bArr, int i) {
        AppMethodBeat.i(19347);
        ab.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", str, str2, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(bArr.length), Integer.valueOf(i));
        this.ltH = str2;
        a aVar = new a();
        aVar.fsJ = new bwh();
        aVar.fsK = new bwi();
        aVar.fsI = 538;
        aVar.uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.lty = aVar.acD();
        bwh bwh = (bwh) this.lty.fsG.fsP;
        asq asq = new asq();
        asq.vIk = str;
        asq.jBE = str2;
        bwh.vLi = asq;
        asu asu = new asu();
        asu.wwE = j2;
        asu.pcX = (int) j3;
        asu.vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
        asu.jCt = i;
        bwh.wWW = asu;
        if (j != 0) {
            bwh.wwz = new SKBuiltinBuffer_t().setBuffer(u.bpx().o(j, 2));
            AppMethodBeat.o(19347);
            return;
        }
        com.tencent.mm.plugin.exdevice.h.b Kv = ad.boW().Kv(str2);
        if (Kv != null) {
            bwh.wwz = new SKBuiltinBuffer_t().setBuffer(Kv.field_sessionBuf);
        }
        AppMethodBeat.o(19347);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19348);
        ab.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19348);
    }

    public final int getType() {
        return 538;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19349);
        this.eIc = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(19349);
        return a;
    }
}
