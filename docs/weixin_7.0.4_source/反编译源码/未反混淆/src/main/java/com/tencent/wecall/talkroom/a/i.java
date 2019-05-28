package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ad;
import com.tencent.pb.common.b.a.a.g;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class i extends d {
    public i(String str, int i, long j, int i2) {
        AppMethodBeat.i(128023);
        c.d("MicroMsg.Voip", this.TAG2, "NetSceneRejectVoiceGroup");
        g gVar = new g();
        try {
            gVar.groupId = str;
            gVar.sQS = i;
            gVar.sQT = j;
            gVar.boZ = i2;
            this.AlQ = 3;
            this.AlR = com.tencent.wecall.talkroom.model.c.dTg().auH(str);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneRejectVoiceGroup constructor", e);
        }
        c(181, gVar);
        AppMethodBeat.o(128023);
    }

    public final int getType() {
        return 207;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128024);
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (ad) e.a(new ad(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128024);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
    }
}
