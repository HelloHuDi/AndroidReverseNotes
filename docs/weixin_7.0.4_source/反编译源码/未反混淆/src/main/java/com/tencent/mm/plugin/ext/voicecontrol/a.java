package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    public int JJ;
    public String appId;
    public int coc;
    public int czE = 1;
    b ehh;
    private f ehi;
    public int frO;
    public fh lRA;
    public fb lRB;
    int lRC = 5000;
    long lRD = 0;
    public int lRx;
    public com.tencent.mm.bt.b lRy;
    public String lRz;

    public a(int i, String str, int i2, String str2, fh fhVar) {
        boolean z = true;
        AppMethodBeat.i(20457);
        this.appId = str;
        this.lRx = i;
        this.JJ = 1;
        this.frO = i2;
        this.lRA = fhVar;
        this.lRB = null;
        this.lRz = str2;
        String str3 = "MicroMsg.ext.NetSceneAppVoiceControl";
        String str4 = "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(1);
        if (fhVar == null) {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        objArr[6] = Boolean.FALSE;
        ab.i(str3, str4, objArr);
        AppMethodBeat.o(20457);
    }

    public a(int i, String str, fb fbVar, long j) {
        AppMethodBeat.i(20458);
        this.appId = str;
        this.lRx = i;
        this.JJ = 1;
        this.lRA = null;
        this.lRB = fbVar;
        this.lRD = j;
        ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", Integer.valueOf(2), str, Integer.valueOf(i), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE);
        AppMethodBeat.o(20458);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(20459);
        if (i2 == 0 && i3 == 0 && qVar != null) {
            ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        } else {
            ab.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(20459);
            return;
        }
        ab.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
        AppMethodBeat.o(20459);
    }

    public final int getType() {
        return 985;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(20460);
        this.ehi = fVar;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 985;
        aVar.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
        aVar.fsJ = new fc();
        aVar.fsK = new fd();
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        fc fcVar = (fc) this.ehh.fsG.fsP;
        fcVar.OpCode = this.czE;
        fcVar.fKh = this.appId;
        fcVar.vHa = this.lRx;
        fcVar.vHb = this.JJ;
        fcVar.vHc = this.lRA;
        fcVar.vHd = this.lRB;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(20460);
        return a;
    }
}
