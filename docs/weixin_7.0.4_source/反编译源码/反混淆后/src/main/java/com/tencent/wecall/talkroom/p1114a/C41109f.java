package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24196f;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24211ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.wecall.talkroom.model.C6001c;

/* renamed from: com.tencent.wecall.talkroom.a.f */
public final class C41109f extends C24239d {
    public C41109f(String str, int i, long j, int i2) {
        AppMethodBeat.m2504i(128018);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "eixt", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        C24196f c24196f = new C24196f();
        try {
            c24196f.groupId = str;
            c24196f.sQS = i;
            c24196f.sQT = j;
            c24196f.boZ = i2;
            this.AlQ = 2;
            this.AlR = C6001c.dTg().auH(str);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneExitVoiceRoom constructor", e);
        }
        mo40009c(ErrorCode.NEEDDOWNLOAD_4, c24196f);
        AppMethodBeat.m2505o(128018);
    }

    public final int getType() {
        return 203;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128019);
        if (bArr != null) {
            try {
                obj = (C24211ab) C25510e.m40292a(new C24211ab(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128019);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
    }
}
