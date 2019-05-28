package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ae;
import com.tencent.pb.common.b.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class k extends d {
    public int nCF;
    public String neq;
    public long sZg;

    public k(String str, int i, long j, String str2) {
        AppMethodBeat.i(128026);
        c.d("MicroMsg.Voip", this.TAG2, "NetSceneSubscribeLargeVideo");
        h hVar = new h();
        try {
            hVar.groupId = str;
            this.neq = str;
            hVar.nwu = i;
            this.nCF = i;
            hVar.nwv = j;
            this.sZg = j;
            hVar.emc = str2;
            hVar.timestamp = System.currentTimeMillis();
            c.i("MicroMsg.Voip", "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(hVar.nwu), Long.valueOf(hVar.nwv), hVar.groupId, hVar.emc, Long.valueOf(hVar.timestamp));
            this.AlQ = 3;
            this.AlR = com.tencent.wecall.talkroom.model.c.dTg().auH(str);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneSwitchVideoGroup constructor", e);
        }
        c(com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE, hVar);
        AppMethodBeat.o(128026);
    }

    public final int getType() {
        return 800;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128027);
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (ae) e.a(new ae(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128027);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
    }
}
