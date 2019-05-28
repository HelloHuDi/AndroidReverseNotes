package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24203al;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24205ba;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24222j;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24236ag;

/* renamed from: com.tencent.wecall.talkroom.a.a */
public final class C31130a extends C24239d {
    public int ALq;
    public int AlR;
    public int nCF = 0;
    public String neq = null;
    public long sZg = 0;

    public C31130a(String str, int i, long j, int i2, int i3) {
        AppMethodBeat.m2504i(128007);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "NetSceneAckVoiceGroup");
        C24222j c24222j = new C24222j();
        try {
            c24222j.groupId = str;
            this.neq = str;
            c24222j.sQS = i;
            this.nCF = i;
            c24222j.sQT = j;
            this.sZg = j;
            this.ALq = i3;
            this.AlR = i2;
            C24203al c24203al = new C24203al();
            c24203al.iLen = 0;
            C24205ba c24205ba = new C24205ba();
            c24205ba.type = 3;
            c24205ba.ApN = c24203al;
            c24222j.AmB = c24205ba;
            this.AlQ = 3;
            this.AlR = i2;
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneAckVoiceGroup constructor", e);
        }
        mo40009c(189, c24222j);
        AppMethodBeat.m2505o(128007);
    }

    public final int getType() {
        return 206;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128008);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (C24236ag) C25510e.m40292a(new C24236ag(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128008);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSVoiceAckReq";
    }
}
