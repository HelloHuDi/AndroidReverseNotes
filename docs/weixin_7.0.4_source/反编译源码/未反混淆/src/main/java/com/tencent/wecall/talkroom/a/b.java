package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class b extends d {
    public int nCF;
    public String neq;
    public long sZg;

    public b(String str, int i, long j, String[] strArr) {
        AppMethodBeat.i(128009);
        c.d("MicroMsg.Voip", this.TAG2, "addmember", str);
        a aVar = new a();
        try {
            aVar.groupId = str;
            this.neq = str;
            aVar.sQS = i;
            this.nCF = i;
            aVar.sQT = j;
            this.sZg = j;
            aVar.Amw = strArr;
            aVar.sQS = i;
            this.AlQ = 3;
            this.AlR = com.tencent.wecall.talkroom.model.c.dTg().auH(str);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneAddVoiceGroupMember constructor", e);
        }
        c(145, aVar);
        AppMethodBeat.o(128009);
    }

    public final int getType() {
        return 204;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128010);
        if (bArr != null) {
            try {
                obj = (x) e.a(new x(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128010);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
    }
}
