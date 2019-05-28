package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class m extends com.tencent.mm.ai.m implements k, e {
    private b ehh;
    private f ehi;
    private boolean lSP = false;
    public String lSQ = null;
    public boolean lSR = false;
    private String lSS = "";

    public m(long j, String str, String str2, String str3, String str4, int i, float f, int i2) {
        AppMethodBeat.i(82);
        a aVar = new a();
        aVar.fsJ = new aah();
        aVar.fsK = new aai();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        aah aah = (aah) this.ehh.fsG.fsP;
        aah.csB = str;
        aah.wfw = j;
        aah.wfo = str2;
        aah.wfy = str3;
        aah.wfx = str4;
        aah.lSN = i;
        aah.wfA = f;
        aah.wfB = i2;
        ab.i("MicroMsg.NetSceneFaceVerifyFace", "create NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d", Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2));
        AppMethodBeat.o(82);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(83);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(83);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(84);
        ab.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        aai aai = (aai) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", aai.wfC);
        this.lSQ = aai.wfC;
        this.lSR = aai.wfD;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(84);
    }

    public final String bsh() {
        return this.lSQ;
    }

    public final boolean bsg() {
        return this.lSR;
    }
}
