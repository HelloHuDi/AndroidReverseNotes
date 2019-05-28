package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ag;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class a extends d {
    public int ALq;
    public int AlR;
    public int nCF = 0;
    public String neq = null;
    public long sZg = 0;

    public a(String str, int i, long j, int i2, int i3) {
        AppMethodBeat.i(128007);
        c.d("MicroMsg.Voip", this.TAG2, "NetSceneAckVoiceGroup");
        j jVar = new j();
        try {
            jVar.groupId = str;
            this.neq = str;
            jVar.sQS = i;
            this.nCF = i;
            jVar.sQT = j;
            this.sZg = j;
            this.ALq = i3;
            this.AlR = i2;
            al alVar = new al();
            alVar.iLen = 0;
            ba baVar = new ba();
            baVar.type = 3;
            baVar.ApN = alVar;
            jVar.AmB = baVar;
            this.AlQ = 3;
            this.AlR = i2;
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneAckVoiceGroup constructor", e);
        }
        c(189, jVar);
        AppMethodBeat.o(128007);
    }

    public final int getType() {
        return 206;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128008);
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (ag) e.a(new ag(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128008);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSVoiceAckReq";
    }
}
