package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24231k;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24237aj;
import com.tencent.wecall.talkroom.model.C41114k;
import com.tencent.wecall.talkroom.model.C6001c;

/* renamed from: com.tencent.wecall.talkroom.a.h */
public final class C46824h extends C24239d {
    public String groupId;
    public int nwu;
    public long nwv;

    public C46824h(String str, int i, long j, int i2) {
        AppMethodBeat.m2504i(128021);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "NetSceneRejectVoiceGroup");
        C24231k c24231k = new C24231k();
        try {
            c24231k.groupId = str;
            c24231k.sQS = i;
            c24231k.sQT = j;
            c24231k.kyZ = i2;
            c24231k.AmD = 2;
            c24231k.netType = C41114k.m71547ju(C46729d.sZj);
            this.AlQ = 3;
            this.AlR = C6001c.dTg().auH(str);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneRedirect constructor", e);
        }
        mo40009c(211, c24231k);
        AppMethodBeat.m2505o(128021);
    }

    public final int getType() {
        return 211;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128022);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (C24237aj) C25510e.m40292a(new C24237aj(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128022);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSVoiceRedirectReq";
    }
}
