package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.af.b */
public class C25746b extends C37435f {
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

    /* renamed from: Xz */
    public final C37435f mo20330Xz() {
        AppMethodBeat.m2504i(16184);
        C25746b c25746b = new C25746b();
        AppMethodBeat.m2505o(16184);
        return c25746b;
    }

    /* renamed from: a */
    public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
    }

    /* renamed from: a */
    public final void mo20332a(Map<String, String> map, C8910b c8910b) {
        AppMethodBeat.m2504i(16185);
        if (c8910b.type == 2002) {
            this.ffq = C25746b.m40873d(map, "templateid");
            this.ffr = C25746b.m40873d(map, "senderurl");
            this.ffs = C25746b.m40873d(map, "sendernativeurl");
            this.fft = C25746b.m40873d(map, "receiverurl");
            this.ffu = C25746b.m40873d(map, "receivernativeurl");
            this.ffv = C25746b.m40873d(map, "iconurl");
            this.ffw = C25746b.m40873d(map, "miniiconurl");
            this.ffx = C25746b.m40873d(map, "backgroundurl");
            this.ffy = C25746b.m40873d(map, "backgroundname");
            this.ffz = C25746b.m40873d(map, "backgroundcolor");
            this.ffA = C25746b.m40873d(map, "receivertitle");
            this.ffB = C25746b.m40873d(map, "sendertitle");
            this.ffC = C25746b.m40873d(map, "titlecolor");
            this.ffD = C25746b.m40873d(map, "senderscenetext");
            this.ffE = C25746b.m40873d(map, "receiverscenetext");
            this.ffF = C25746b.m40873d(map, "senderdes");
            this.ffG = C25746b.m40873d(map, "receiverdes");
            this.ffH = C25746b.m40873d(map, "descolor");
            this.ffI = C25746b.m40873d(map, "sceneid");
            this.cJF = C25746b.m40873d(map, "paymsgid");
            this.ffJ = C25746b.m40873d(map, "senderbackgroundname");
            this.ffK = C25746b.m40873d(map, "senderbackgroundurl");
            this.ffL = C25746b.m40873d(map, "receiverbackgroundname");
            this.ffM = C25746b.m40873d(map, "receiverbackgroundurl");
        }
        AppMethodBeat.m2505o(16185);
    }

    /* renamed from: d */
    private static String m40873d(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(16186);
        String nullAsNil = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(str))));
        AppMethodBeat.m2505o(16186);
        return nullAsNil;
    }
}
