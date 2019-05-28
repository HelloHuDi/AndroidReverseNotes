package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C5792ac;

/* renamed from: com.tencent.wecall.talkroom.a.g */
public final class C41110g extends C24239d {
    public String neq;

    public final int getType() {
        return 209;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128020);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (C5792ac) C25510e.m40292a(new C5792ac(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128020);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
    }
}
