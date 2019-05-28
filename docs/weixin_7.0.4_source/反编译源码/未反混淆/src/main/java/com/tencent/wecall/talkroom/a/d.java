package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d extends com.tencent.pb.common.b.d {
    public String AJu;
    public boolean ALr = true;
    public int mType;

    public d(String str, String[] strArr, byte[] bArr, String str2, ay ayVar, int i, int i2, long j, String str3, boolean z, String str4) {
        AppMethodBeat.i(128013);
        c.d("MicroMsg.Voip", this.TAG2, "create");
        com.tencent.pb.common.b.a.a.d dVar = new com.tencent.pb.common.b.a.a.d();
        try {
            dVar.Amx = str;
            this.AJu = str;
            dVar.AmC = i;
            this.AlR = i;
            if (ayVar != null) {
                dVar.AmE = ayVar;
            }
            at atVar = new at();
            atVar.name = str2;
            atVar.AoT = str4;
            atVar.AoS = a.dPM();
            atVar.cAO = i2;
            this.mType = i2;
            this.ALr = z;
            atVar.AoL = j;
            dVar.Amz = atVar;
            dVar.AmG = strArr;
            if (str3 == null) {
                str3 = "";
            }
            dVar.AmF = str3;
            al alVar = new al();
            if (bArr != null) {
                alVar.buffer = bArr;
                alVar.iLen = bArr.length;
            } else {
                alVar.iLen = 0;
            }
            ba baVar = new ba();
            baVar.type = 3;
            baVar.ApN = alVar;
            dVar.AmB = baVar;
            this.AlQ = 3;
            dVar.AmD = 2;
            dVar.netType = k.ju(com.tencent.pb.common.c.d.sZj);
        } catch (Exception e) {
            c.w(this.TAG2, "NetSceneCreateVoiceGroup constructor", e);
        }
        c(com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, dVar);
        AppMethodBeat.o(128013);
    }

    public final int getType() {
        return 201;
    }

    public final Object ch(byte[] bArr) {
        Object obj;
        AppMethodBeat.i(128014);
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                obj = (z) e.a(new z(), bArr, bArr.length);
            } catch (Exception e) {
                c.w(this.TAG2, "data2Resp", e.getMessage());
                obj = null;
            }
        } else {
            obj = null;
        }
        AppMethodBeat.o(128014);
        return obj;
    }

    public final String dPt() {
        return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
    }
}
