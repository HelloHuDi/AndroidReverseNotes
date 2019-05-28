package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.i;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class l extends d {
    public int nCF;
    public String neq;
    public long sZg;

    public l(String str, int i, long j, int i2) {
        AppMethodBeat.i(128028);
        c.d("MicroMsg.Voip", this.TAG2, "NetSceneSwitchVideoGroup");
        i iVar = new i();
        try {
            iVar.groupId = str;
            this.neq = str;
            iVar.nwu = i;
            this.nCF = i;
            iVar.nwv = j;
            this.sZg = j;
            iVar.action = i2;
            iVar.timestamp = System.currentTimeMillis();
            this.AlQ = 3;
            this.AlR = com.tencent.wecall.talkroom.model.c.dTg().auH(str);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneSwitchVideoGroup constructor", e);
        }
        c(243, iVar);
        AppMethodBeat.o(128028);
    }

    public final int getType() {
        return 214;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128029);
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (af) e.a(new af(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128029);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
    }
}
