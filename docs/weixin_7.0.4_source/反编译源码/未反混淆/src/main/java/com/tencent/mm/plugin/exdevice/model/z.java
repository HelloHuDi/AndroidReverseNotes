package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class z extends m implements k {
    private f eIc = null;
    private String ltK = "";
    b lty = null;

    public z(LinkedList<ajn> linkedList, String str, String str2) {
        AppMethodBeat.i(19355);
        this.ltK = str2;
        a aVar = new a();
        aVar.fsJ = new ajo();
        aVar.fsK = new ajp();
        aVar.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
        aVar.fsI = 543;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.lty = aVar.acD();
        ajo ajo = (ajo) this.lty.fsG.fsP;
        if (!bo.isNullOrNil(str)) {
            ajm ajm = new ajm();
            ajm.vKE = str;
            ajo.wpn = ajm;
        }
        ajo.wpm = linkedList;
        AppMethodBeat.o(19355);
    }

    public final int getType() {
        return 543;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19356);
        this.eIc = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(19356);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19357);
        ab.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(19357);
    }
}
