package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class g extends d {
    public String neq;

    public final int getType() {
        return 209;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128020);
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (ac) e.a(new ac(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128020);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
    }
}
