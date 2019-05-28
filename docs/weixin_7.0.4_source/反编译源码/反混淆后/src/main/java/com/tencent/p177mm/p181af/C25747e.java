package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.af.e */
public class C25747e extends C37435f {
    public int duration = -1;
    public int ffZ = -1;
    public int fga = -1;
    public int fgb = 1;
    public int fgc = 0;
    public String fgd = "";
    public int videoHeight = -1;
    public int videoWidth = -1;

    /* renamed from: Xz */
    public final C37435f mo20330Xz() {
        AppMethodBeat.m2504i(11207);
        if (this.ffZ == -1) {
            AppMethodBeat.m2505o(11207);
            return null;
        }
        C37435f c25747e = new C25747e();
        c25747e.ffZ = this.ffZ;
        c25747e.fga = this.fga;
        c25747e.duration = this.duration;
        c25747e.videoWidth = this.videoWidth;
        c25747e.videoHeight = this.videoHeight;
        c25747e.fgb = this.fgb;
        c25747e.fgd = this.fgd;
        c25747e.fgc = this.fgc;
        AppMethodBeat.m2505o(11207);
        return c25747e;
    }

    /* renamed from: a */
    public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
        AppMethodBeat.m2504i(11208);
        if (this.ffZ != -1) {
            stringBuilder.append("<mmreadershare><itemshowtype>").append(this.ffZ).append("</itemshowtype>");
            if (this.ffZ == 5) {
                stringBuilder.append("<pubtime>").append(this.fga).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.fgb).append("</nativepage><funcflag>").append(this.fgc).append("</funcflag><vid>").append(C5046bo.ani(this.fgd)).append("</vid>");
            }
            stringBuilder.append("</mmreadershare>");
        }
        AppMethodBeat.m2505o(11208);
    }

    /* renamed from: a */
    public final void mo20332a(Map<String, String> map, C8910b c8910b) {
        AppMethodBeat.m2504i(11209);
        String str = (String) map.get(".msg.appmsg.mmreadershare.itemshowtype");
        if (str != null && Pattern.compile("\\d").matcher(str).matches()) {
            this.ffZ = Integer.valueOf(str).intValue();
        }
        if (this.ffZ == 5) {
            this.fga = C5046bo.getInt((String) map.get(".msg.appmsg.mmreadershare.pubtime"), 0);
            this.duration = C5046bo.getInt((String) map.get(".msg.appmsg.mmreadershare.duration"), 0);
            this.videoWidth = C5046bo.getInt((String) map.get(".msg.appmsg.mmreadershare.width"), 0);
            this.videoHeight = C5046bo.getInt((String) map.get(".msg.appmsg.mmreadershare.height"), 0);
            this.fgb = C5046bo.getInt((String) map.get(".msg.appmsg.mmreadershare.nativepage"), 0);
            this.fgc = C5046bo.getInt((String) map.get(".msg.appmsg.mmreadershare.funcflag"), 0);
            this.fgd = (String) map.get(".msg.appmsg.mmreadershare.vid");
        }
        AppMethodBeat.m2505o(11209);
    }
}
