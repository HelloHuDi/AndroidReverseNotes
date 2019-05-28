package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.b;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.common.b.d;

public final class c extends d {
    public c(String str, int i, int i2) {
        AppMethodBeat.i(128011);
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", this.TAG2, "NetSceneCancelCreateVoiceGroup");
        b bVar = new b();
        try {
            bVar.Amx = str;
            bVar.boZ = i;
            this.AlQ = 3;
            this.AlR = i2;
        } catch (Exception e) {
            com.tencent.pb.common.c.c.w(this.TAG2, "NetSceneCancelCreateVoiceGroup constructor", e);
        }
        c(183, bVar);
        AppMethodBeat.o(128011);
    }

    public final int getType() {
        return 208;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128012);
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (y) e.a(new y(), bArr, bArr.length);
            } catch (Exception e) {
                com.tencent.pb.common.c.c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128012);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
    }
}
