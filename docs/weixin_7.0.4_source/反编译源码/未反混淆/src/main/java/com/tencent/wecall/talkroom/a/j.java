package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class j extends d {
    public String neq;

    public final int getType() {
        return 213;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128025);
        if (bArr != null) {
            try {
                obj = (ai) e.a(new ai(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e);
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128025);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
    }
}
