package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24201y;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24214b;

/* renamed from: com.tencent.wecall.talkroom.a.c */
public final class C31131c extends C24239d {
    public C31131c(String str, int i, int i2) {
        AppMethodBeat.m2504i(128011);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "NetSceneCancelCreateVoiceGroup");
        C24214b c24214b = new C24214b();
        try {
            c24214b.Amx = str;
            c24214b.boZ = i;
            this.AlQ = 3;
            this.AlR = i2;
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneCancelCreateVoiceGroup constructor", e);
        }
        mo40009c(183, c24214b);
        AppMethodBeat.m2505o(128011);
    }

    public final int getType() {
        return 208;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128012);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (C24201y) C25510e.m40292a(new C24201y(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128012);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
    }
}
