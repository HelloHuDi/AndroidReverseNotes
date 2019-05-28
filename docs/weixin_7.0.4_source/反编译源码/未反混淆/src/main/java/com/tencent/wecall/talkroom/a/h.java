package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.k;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class h extends d {
    public String groupId;
    public int nwu;
    public long nwv;

    public h(String str, int i, long j, int i2) {
        AppMethodBeat.i(128021);
        c.d("MicroMsg.Voip", this.TAG2, "NetSceneRejectVoiceGroup");
        k kVar = new k();
        try {
            kVar.groupId = str;
            kVar.sQS = i;
            kVar.sQT = j;
            kVar.kyZ = i2;
            kVar.AmD = 2;
            kVar.netType = com.tencent.wecall.talkroom.model.k.ju(com.tencent.pb.common.c.d.sZj);
            this.AlQ = 3;
            this.AlR = com.tencent.wecall.talkroom.model.c.dTg().auH(str);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneRedirect constructor", e);
        }
        c(211, kVar);
        AppMethodBeat.o(128021);
    }

    public final int getType() {
        return 211;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128022);
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (aj) e.a(new aj(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128022);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSVoiceRedirectReq";
    }
}
