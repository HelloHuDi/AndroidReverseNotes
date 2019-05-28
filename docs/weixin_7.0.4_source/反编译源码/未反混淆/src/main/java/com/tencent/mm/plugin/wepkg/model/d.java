package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.o;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private Map<String, f> uWM = new HashMap();
    private int uWN = 1;

    public d() {
        AppMethodBeat.i(63520);
        AppMethodBeat.o(63520);
    }

    public final void ahR(String str) {
        AppMethodBeat.i(63521);
        if (this.uWN > 3) {
            ab.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
            AppMethodBeat.o(63521);
            return;
        }
        String aid = com.tencent.mm.plugin.wepkg.utils.d.aid(str);
        if (!(bo.isNullOrNil(aid) || this.uWM.get(aid) != null || b.ahw(aid))) {
            this.uWN++;
            f bN = b.bN(str, true);
            if (!(bN == null || bN.uWY == null)) {
                this.uWM.put(aid, bN);
                a.b("EnterWeb", str, bN.uWY.eBS, bN.uWY.version, 1, 0, null);
                ab.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", aid);
            }
        }
        AppMethodBeat.o(63521);
    }

    public final o ahS(String str) {
        AppMethodBeat.i(63522);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(63522);
            return null;
        }
        for (f ahS : this.uWM.values()) {
            o ahS2 = ahS.ahS(str);
            if (ahS2 != null) {
                ab.i("MicroMsg.Wepkg.SupportIframe", "hit rid: %s", str);
                AppMethodBeat.o(63522);
                return ahS2;
            }
        }
        AppMethodBeat.o(63522);
        return null;
    }
}
