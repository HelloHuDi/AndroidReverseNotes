package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24221ak;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24238l;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.wecall.talkroom.model.C6001c;

/* renamed from: com.tencent.wecall.talkroom.a.m */
public final class C31134m extends C24239d {
    public int nCF;
    public String neq;
    public long sZg;

    public C31134m(String str, int i, long j, int i2, int i3) {
        AppMethodBeat.m2504i(128030);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "hello", str, Integer.valueOf(i), Long.valueOf(j));
        C24238l c24238l = new C24238l();
        c24238l.AmO = i3;
        c24238l.sQS = i;
        this.nCF = i;
        c24238l.sQT = j;
        this.sZg = j;
        c24238l.groupId = str;
        this.neq = str;
        c24238l.kyZ = i2;
        try {
            this.AlR = C6001c.dTg().auH(str);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneVoiceRoomHello constructor", e);
        }
        mo40009c(ErrorCode.NEEDDOWNLOAD_8, c24238l);
        AppMethodBeat.m2505o(128030);
    }

    public final int getType() {
        return 205;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128031);
        if (bArr != null) {
            try {
                obj = (C24221ak) C25510e.m40292a(new C24221ak(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128031);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
    }
}
