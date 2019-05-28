package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C16119h;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24212ae;
import com.tencent.view.C31128d;
import com.tencent.wecall.talkroom.model.C6001c;

/* renamed from: com.tencent.wecall.talkroom.a.k */
public final class C25016k extends C24239d {
    public int nCF;
    public String neq;
    public long sZg;

    public C25016k(String str, int i, long j, String str2) {
        AppMethodBeat.m2504i(128026);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "NetSceneSubscribeLargeVideo");
        C16119h c16119h = new C16119h();
        try {
            c16119h.groupId = str;
            this.neq = str;
            c16119h.nwu = i;
            this.nCF = i;
            c16119h.nwv = j;
            this.sZg = j;
            c16119h.emc = str2;
            c16119h.timestamp = System.currentTimeMillis();
            C44443c.m80391i("MicroMsg.Voip", "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(c16119h.nwu), Long.valueOf(c16119h.nwv), c16119h.groupId, c16119h.emc, Long.valueOf(c16119h.timestamp));
            this.AlQ = 3;
            this.AlR = C6001c.dTg().auH(str);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneSwitchVideoGroup constructor", e);
        }
        mo40009c(C31128d.MIC_PTU_ZIPAI_LIGHTWHITE, c16119h);
        AppMethodBeat.m2505o(128026);
    }

    public final int getType() {
        return 800;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128027);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (C24212ae) C25510e.m40292a(new C24212ae(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128027);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
    }
}
