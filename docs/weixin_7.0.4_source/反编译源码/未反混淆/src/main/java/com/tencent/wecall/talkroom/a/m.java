package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.l;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class m extends d {
    public int nCF;
    public String neq;
    public long sZg;

    public m(String str, int i, long j, int i2, int i3) {
        AppMethodBeat.i(128030);
        c.d("MicroMsg.Voip", this.TAG2, "hello", str, Integer.valueOf(i), Long.valueOf(j));
        l lVar = new l();
        lVar.AmO = i3;
        lVar.sQS = i;
        this.nCF = i;
        lVar.sQT = j;
        this.sZg = j;
        lVar.groupId = str;
        this.neq = str;
        lVar.kyZ = i2;
        try {
            this.AlR = com.tencent.wecall.talkroom.model.c.dTg().auH(str);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneVoiceRoomHello constructor", e);
        }
        c(ErrorCode.NEEDDOWNLOAD_8, lVar);
        AppMethodBeat.o(128030);
    }

    public final int getType() {
        return 205;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128031);
        if (bArr != null) {
            try {
                obj = (ak) e.a(new ak(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128031);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
    }
}
