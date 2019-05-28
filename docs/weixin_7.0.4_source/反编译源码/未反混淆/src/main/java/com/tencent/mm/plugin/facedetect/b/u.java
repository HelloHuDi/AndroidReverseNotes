package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class u extends m implements k, b {
    private b ehh;
    private f ehi;
    private long lTa = -1;
    private byte[] lTb = null;

    public final long bse() {
        return this.lTa;
    }

    public final byte[] bsf() {
        return this.lTb;
    }

    public u(int i, int i2) {
        AppMethodBeat.i(109);
        a aVar = new a();
        aVar.fsJ = new afj();
        aVar.fsK = new afk();
        aVar.uri = "/cgi-bin/micromsg-bin/getbioconfig";
        aVar.fsI = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        afj afj = (afj) this.ehh.fsG.fsP;
        afj.jCt = 1;
        afj.Scene = i;
        afj.wmN = i2;
        ab.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
        ab.i("MicroMsg.NetSceneGetBioConfig", "mChechLiveFlag is ".concat(String.valueOf(i2)));
        AppMethodBeat.o(109);
    }

    public final int getType() {
        return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(110);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(110);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111);
        afk afk = (afk) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            this.lTa = afk.wmO;
            this.lTb = afk.wmP.wR;
            ab.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
            ab.i("MicroMsg.NetSceneGetBioConfig", "Config is " + this.lTb);
            String str2 = "MicroMsg.NetSceneGetBioConfig";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.lTa);
            objArr[1] = Integer.valueOf(this.lTb == null ? 0 : this.lTb.length);
            ab.i(str2, str3, objArr);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(111);
    }
}
