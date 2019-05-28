package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class f extends d {
    public f(String str, int i, long j, int i2) {
        AppMethodBeat.i(128018);
        c.d("MicroMsg.Voip", this.TAG2, "eixt", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        com.tencent.pb.common.b.a.a.f fVar = new com.tencent.pb.common.b.a.a.f();
        try {
            fVar.groupId = str;
            fVar.sQS = i;
            fVar.sQT = j;
            fVar.boZ = i2;
            this.AlQ = 2;
            this.AlR = com.tencent.wecall.talkroom.model.c.dTg().auH(str);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneExitVoiceRoom constructor", e);
        }
        c(ErrorCode.NEEDDOWNLOAD_4, fVar);
        AppMethodBeat.o(128018);
    }

    public final int getType() {
        return 203;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128019);
        if (bArr != null) {
            try {
                obj = (ab) e.a(new ab(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128019);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
    }
}
