package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24191at;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24203al;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24205ba;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24206e;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24219aa;
import com.tencent.wecall.talkroom.model.C41114k;

/* renamed from: com.tencent.wecall.talkroom.a.e */
public final class C16378e extends C24239d {
    public String AJt = null;
    public int ALs = 0;
    public int nCF = 0;
    public String neq = null;
    public long sZg = 0;

    public C16378e(C16378e c16378e) {
        AppMethodBeat.m2504i(128015);
        this.neq = c16378e.neq;
        this.nCF = c16378e.nCF;
        this.sZg = c16378e.sZg;
        this.ALs = c16378e.ALs;
        this.AJt = c16378e.AJt;
        this.AlN = c16378e.AlN;
        this.AlP = c16378e.AlP;
        this.AlR = c16378e.AlR;
        this.AlQ = 1;
        AppMethodBeat.m2505o(128015);
    }

    public C16378e(String str, int i, long j, byte[] bArr, int i2, int i3, String str2) {
        AppMethodBeat.m2504i(128016);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "enter2", str, Integer.valueOf(i), Long.valueOf(j), str2);
        C24206e c24206e = new C24206e();
        try {
            c24206e.groupId = str;
            this.neq = str;
            c24206e.sQS = i;
            this.nCF = i;
            c24206e.sQT = j;
            this.sZg = j;
            c24206e.AmJ = i3;
            this.ALs = i3;
            C24191at c24191at = new C24191at();
            c24191at.AoT = str2;
            c24206e.Amz = c24191at;
            this.AJt = str2;
            C44443c.m80389d("MicroMsg.Voip", this.TAG2, "wXgroupId", c24206e.Amz.AoT);
            C24203al c24203al = new C24203al();
            if (bArr != null) {
                c24203al.buffer = bArr;
                c24203al.iLen = bArr.length;
            } else {
                c24203al.iLen = 0;
            }
            C24205ba c24205ba = new C24205ba();
            c24205ba.type = 3;
            c24205ba.ApN = c24203al;
            c24206e.AmB = c24205ba;
            this.AlQ = 2;
            this.AlR = i2;
            c24206e.AmD = 2;
            c24206e.netType = C41114k.m71547ju(C46729d.sZj);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneEnterVoiceRoom constructor", e);
        }
        mo40009c(141, c24206e);
        AppMethodBeat.m2505o(128016);
    }

    public final int getType() {
        return 202;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128017);
        if (bArr != null) {
            try {
                obj = (C24219aa) C25510e.m40292a(new C24219aa(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128017);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
    }
}
