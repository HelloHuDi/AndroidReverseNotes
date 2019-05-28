package com.tencent.wecall.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e extends d {
    public String AJt = null;
    public int ALs = 0;
    public int nCF = 0;
    public String neq = null;
    public long sZg = 0;

    public e(e eVar) {
        AppMethodBeat.i(128015);
        this.neq = eVar.neq;
        this.nCF = eVar.nCF;
        this.sZg = eVar.sZg;
        this.ALs = eVar.ALs;
        this.AJt = eVar.AJt;
        this.AlN = eVar.AlN;
        this.AlP = eVar.AlP;
        this.AlR = eVar.AlR;
        this.AlQ = 1;
        AppMethodBeat.o(128015);
    }

    public e(String str, int i, long j, byte[] bArr, int i2, int i3, String str2) {
        AppMethodBeat.i(128016);
        c.d("MicroMsg.Voip", this.TAG2, "enter2", str, Integer.valueOf(i), Long.valueOf(j), str2);
        com.tencent.pb.common.b.a.a.e eVar = new com.tencent.pb.common.b.a.a.e();
        try {
            eVar.groupId = str;
            this.neq = str;
            eVar.sQS = i;
            this.nCF = i;
            eVar.sQT = j;
            this.sZg = j;
            eVar.AmJ = i3;
            this.ALs = i3;
            at atVar = new at();
            atVar.AoT = str2;
            eVar.Amz = atVar;
            this.AJt = str2;
            c.d("MicroMsg.Voip", this.TAG2, "wXgroupId", eVar.Amz.AoT);
            al alVar = new al();
            if (bArr != null) {
                alVar.buffer = bArr;
                alVar.iLen = bArr.length;
            } else {
                alVar.iLen = 0;
            }
            ba baVar = new ba();
            baVar.type = 3;
            baVar.ApN = alVar;
            eVar.AmB = baVar;
            this.AlQ = 2;
            this.AlR = i2;
            eVar.AmD = 2;
            eVar.netType = k.ju(com.tencent.pb.common.c.d.sZj);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneEnterVoiceRoom constructor", e);
        }
        c(141, eVar);
        AppMethodBeat.o(128016);
    }

    public final int getType() {
        return 202;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128017);
        if (bArr != null) {
            try {
                obj = (aa) com.google.a.a.e.a(new aa(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128017);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
    }
}
