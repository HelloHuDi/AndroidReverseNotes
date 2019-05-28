package com.tencent.wecall.talkroom.p1114a;

import com.google.p1368a.p1369a.C25510e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;
import com.tencent.p659pb.common.p660b.C24239d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24191at;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24203al;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24205ba;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24209z;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24217d;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24228ay;
import com.tencent.p659pb.p1514a.p1515a.C36407a;
import com.tencent.wecall.talkroom.model.C41114k;

/* renamed from: com.tencent.wecall.talkroom.a.d */
public final class C16377d extends C24239d {
    public String AJu;
    public boolean ALr = true;
    public int mType;

    public C16377d(String str, String[] strArr, byte[] bArr, String str2, C24228ay c24228ay, int i, int i2, long j, String str3, boolean z, String str4) {
        AppMethodBeat.m2504i(128013);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "create");
        C24217d c24217d = new C24217d();
        try {
            c24217d.Amx = str;
            this.AJu = str;
            c24217d.AmC = i;
            this.AlR = i;
            if (c24228ay != null) {
                c24217d.AmE = c24228ay;
            }
            C24191at c24191at = new C24191at();
            c24191at.name = str2;
            c24191at.AoT = str4;
            c24191at.AoS = C36407a.dPM();
            c24191at.cAO = i2;
            this.mType = i2;
            this.ALr = z;
            c24191at.AoL = j;
            c24217d.Amz = c24191at;
            c24217d.AmG = strArr;
            if (str3 == null) {
                str3 = "";
            }
            c24217d.AmF = str3;
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
            c24217d.AmB = c24205ba;
            this.AlQ = 3;
            c24217d.AmD = 2;
            c24217d.netType = C41114k.m71547ju(C46729d.sZj);
        } catch (Exception e) {
            C44443c.m80392w(this.TAG2, "NetSceneCreateVoiceGroup constructor", e);
        }
        mo40009c(C33333a.CTRL_INDEX, c24217d);
        AppMethodBeat.m2505o(128013);
    }

    public final int getType() {
        return 201;
    }

    /* renamed from: ch */
    public final Object mo30087ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.m2504i(128014);
        C44443c.m80389d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (C24209z) C25510e.m40292a(new C24209z(), bArr, bArr.length);
            } catch (Exception e) {
                C44443c.m80392w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.m2505o(128014);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
    }
}
