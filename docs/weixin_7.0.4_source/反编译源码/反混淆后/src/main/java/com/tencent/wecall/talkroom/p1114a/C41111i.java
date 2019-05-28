package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24188ad;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24207g;
import com.tencent.wecall.talkroom.model.C6001c;

/* renamed from: com.tencent.wecall.talkroom.a.i */
public final class C41111i extends C24239d {
    public C41111i(String str, int i, long j, int i2) {
        AppMethodBeat.m2504i(128023);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "NetSceneRejectVoiceGroup");
        C24207g c24207g = new C24207g();
        try {
            c24207g.groupId = str;
            c24207g.sQS = i;
            c24207g.sQT = j;
            c24207g.boZ = i2;
            this.AlQ = 3;
            this.AlR = C6001c.dTg().auH(str);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneRejectVoiceGroup constructor", e);
        }
        mo40009c(181, c24207g);
        AppMethodBeat.m2505o(128023);
    }

    public final int getType() {
        return 207;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128024);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (C24188ad) C25510e.m40292a(new C24188ad(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128024);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
    }
}
