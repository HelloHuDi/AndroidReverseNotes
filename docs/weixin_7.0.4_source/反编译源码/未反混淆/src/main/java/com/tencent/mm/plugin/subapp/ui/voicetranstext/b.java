package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class b extends m implements k {
    private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    private com.tencent.mm.ai.b fsB;
    private f oRe;
    private String svJ;
    public cof svR;
    public int svV = -1;

    public b(String str) {
        boolean z;
        AppMethodBeat.i(25580);
        if (bo.isNullOrNil(str)) {
            z = false;
        } else {
            z = true;
        }
        Assert.assertTrue(z);
        this.svJ = str;
        a aVar = new a();
        aVar.fsJ = new aqd();
        aVar.fsK = new aqe();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
        aVar.fsI = 548;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fsB = aVar.acD();
        AppMethodBeat.o(25580);
    }

    public final int getType() {
        return 548;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25581);
        this.oRe = fVar;
        ((aqd) this.fsB.fsG.fsP).vZx = this.svJ;
        int a = a(eVar, this.fsB, this);
        AppMethodBeat.o(25581);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25582);
        if (i2 == 0 && i3 == 0) {
            aqe aqe = (aqe) this.fsB.fsH.fsP;
            if (aqe.vZB != null) {
                this.svV = aqe.vZB.wRe;
            }
            this.svR = aqe.vZz;
        } else {
            ab.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.oRe.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25582);
    }

    public final boolean isComplete() {
        return this.svR != null && this.svR.fJT == 1;
    }

    public final boolean cDR() {
        AppMethodBeat.i(25583);
        if (this.svR == null || bo.isNullOrNil(this.svR.xlH)) {
            AppMethodBeat.o(25583);
            return false;
        }
        AppMethodBeat.o(25583);
        return true;
    }
}
