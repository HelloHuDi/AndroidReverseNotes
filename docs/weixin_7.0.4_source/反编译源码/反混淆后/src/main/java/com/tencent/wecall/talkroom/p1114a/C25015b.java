package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24200x;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24210a;
import com.tencent.wecall.talkroom.model.C6001c;

/* renamed from: com.tencent.wecall.talkroom.a.b */
public final class C25015b extends C24239d {
    public int nCF;
    public String neq;
    public long sZg;

    public C25015b(String str, int i, long j, String[] strArr) {
        AppMethodBeat.m2504i(128009);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "addmember", str);
        C24210a c24210a = new C24210a();
        try {
            c24210a.groupId = str;
            this.neq = str;
            c24210a.sQS = i;
            this.nCF = i;
            c24210a.sQT = j;
            this.sZg = j;
            c24210a.Amw = strArr;
            c24210a.sQS = i;
            this.AlQ = 3;
            this.AlR = C6001c.dTg().auH(str);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneAddVoiceGroupMember constructor", e);
        }
        mo40009c(145, c24210a);
        AppMethodBeat.m2505o(128009);
    }

    public final int getType() {
        return 204;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128010);
        if (bArr != null) {
            try {
                obj = (C24200x) C25510e.m40292a(new C24200x(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128010);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
    }
}
