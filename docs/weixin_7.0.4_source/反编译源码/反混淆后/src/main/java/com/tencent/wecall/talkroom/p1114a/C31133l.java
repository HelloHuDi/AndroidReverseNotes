package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24189af;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24230i;
import com.tencent.wecall.talkroom.model.C6001c;

/* renamed from: com.tencent.wecall.talkroom.a.l */
public final class C31133l extends C24239d {
    public int nCF;
    public String neq;
    public long sZg;

    public C31133l(String str, int i, long j, int i2) {
        AppMethodBeat.m2504i(128028);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "NetSceneSwitchVideoGroup");
        C24230i c24230i = new C24230i();
        try {
            c24230i.groupId = str;
            this.neq = str;
            c24230i.nwu = i;
            this.nCF = i;
            c24230i.nwv = j;
            this.sZg = j;
            c24230i.action = i2;
            c24230i.timestamp = System.currentTimeMillis();
            this.AlQ = 3;
            this.AlR = C6001c.dTg().auH(str);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneSwitchVideoGroup constructor", e);
        }
        mo40009c(243, c24230i);
        AppMethodBeat.m2505o(128028);
    }

    public final int getType() {
        return 214;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128029);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (C24189af) C25510e.m40292a(new C24189af(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128029);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
    }
}
