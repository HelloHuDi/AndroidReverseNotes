package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.regex.Pattern;

public class e extends f {
    public int duration = -1;
    public int ffZ = -1;
    public int fga = -1;
    public int fgb = 1;
    public int fgc = 0;
    public String fgd = "";
    public int videoHeight = -1;
    public int videoWidth = -1;

    public final f Xz() {
        AppMethodBeat.i(11207);
        if (this.ffZ == -1) {
            AppMethodBeat.o(11207);
            return null;
        }
        f eVar = new e();
        eVar.ffZ = this.ffZ;
        eVar.fga = this.fga;
        eVar.duration = this.duration;
        eVar.videoWidth = this.videoWidth;
        eVar.videoHeight = this.videoHeight;
        eVar.fgb = this.fgb;
        eVar.fgd = this.fgd;
        eVar.fgc = this.fgc;
        AppMethodBeat.o(11207);
        return eVar;
    }

    public final void a(StringBuilder stringBuilder, b bVar, String str, d dVar, int i, int i2) {
        AppMethodBeat.i(11208);
        if (this.ffZ != -1) {
            stringBuilder.append("<mmreadershare><itemshowtype>").append(this.ffZ).append("</itemshowtype>");
            if (this.ffZ == 5) {
                stringBuilder.append("<pubtime>").append(this.fga).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.fgb).append("</nativepage><funcflag>").append(this.fgc).append("</funcflag><vid>").append(bo.ani(this.fgd)).append("</vid>");
            }
            stringBuilder.append("</mmreadershare>");
        }
        AppMethodBeat.o(11208);
    }

    public final void a(Map<String, String> map, b bVar) {
        AppMethodBeat.i(11209);
        String str = (String) map.get(".msg.appmsg.mmreadershare.itemshowtype");
        if (str != null && Pattern.compile("\\d").matcher(str).matches()) {
            this.ffZ = Integer.valueOf(str).intValue();
        }
        if (this.ffZ == 5) {
            this.fga = bo.getInt((String) map.get(".msg.appmsg.mmreadershare.pubtime"), 0);
            this.duration = bo.getInt((String) map.get(".msg.appmsg.mmreadershare.duration"), 0);
            this.videoWidth = bo.getInt((String) map.get(".msg.appmsg.mmreadershare.width"), 0);
            this.videoHeight = bo.getInt((String) map.get(".msg.appmsg.mmreadershare.height"), 0);
            this.fgb = bo.getInt((String) map.get(".msg.appmsg.mmreadershare.nativepage"), 0);
            this.fgc = bo.getInt((String) map.get(".msg.appmsg.mmreadershare.funcflag"), 0);
            this.fgd = (String) map.get(".msg.appmsg.mmreadershare.vid");
        }
        AppMethodBeat.o(11209);
    }
}
