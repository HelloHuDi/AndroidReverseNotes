package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class b extends f {
    public String cJF;
    public String ffA;
    public String ffB;
    public String ffC;
    public String ffD;
    public String ffE;
    public String ffF;
    public String ffG;
    public String ffH;
    public String ffI;
    public String ffJ;
    public String ffK;
    public String ffL;
    public String ffM;
    public String ffq;
    public String ffr;
    public String ffs;
    public String fft;
    public String ffu;
    public String ffv;
    public String ffw;
    public String ffx;
    public String ffy;
    public String ffz;

    public final f Xz() {
        AppMethodBeat.i(16184);
        b bVar = new b();
        AppMethodBeat.o(16184);
        return bVar;
    }

    public final void a(StringBuilder stringBuilder, com.tencent.mm.af.j.b bVar, String str, d dVar, int i, int i2) {
    }

    public final void a(Map<String, String> map, com.tencent.mm.af.j.b bVar) {
        AppMethodBeat.i(16185);
        if (bVar.type == 2002) {
            this.ffq = d(map, "templateid");
            this.ffr = d(map, "senderurl");
            this.ffs = d(map, "sendernativeurl");
            this.fft = d(map, "receiverurl");
            this.ffu = d(map, "receivernativeurl");
            this.ffv = d(map, "iconurl");
            this.ffw = d(map, "miniiconurl");
            this.ffx = d(map, "backgroundurl");
            this.ffy = d(map, "backgroundname");
            this.ffz = d(map, "backgroundcolor");
            this.ffA = d(map, "receivertitle");
            this.ffB = d(map, "sendertitle");
            this.ffC = d(map, "titlecolor");
            this.ffD = d(map, "senderscenetext");
            this.ffE = d(map, "receiverscenetext");
            this.ffF = d(map, "senderdes");
            this.ffG = d(map, "receiverdes");
            this.ffH = d(map, "descolor");
            this.ffI = d(map, "sceneid");
            this.cJF = d(map, "paymsgid");
            this.ffJ = d(map, "senderbackgroundname");
            this.ffK = d(map, "senderbackgroundurl");
            this.ffL = d(map, "receiverbackgroundname");
            this.ffM = d(map, "receiverbackgroundurl");
        }
        AppMethodBeat.o(16185);
    }

    private static String d(Map<String, String> map, String str) {
        AppMethodBeat.i(16186);
        String nullAsNil = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(str))));
        AppMethodBeat.o(16186);
        return nullAsNil;
    }
}
