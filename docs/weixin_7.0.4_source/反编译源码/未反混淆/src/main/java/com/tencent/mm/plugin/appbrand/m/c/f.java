package com.tencent.mm.plugin.appbrand.m.c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends b {
    public final int aIT() {
        return 4;
    }

    public final void a(i iVar, c cVar) {
        AppMethodBeat.i(102197);
        try {
            int i = iVar.getInt("level");
            String optString = iVar.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            switch (i) {
                case 2:
                    ab.i("MicroMsg.NodeJs", optString);
                    AppMethodBeat.o(102197);
                    return;
                case 3:
                    ab.w("MicroMsg.NodeJs", optString);
                    AppMethodBeat.o(102197);
                    return;
                case 4:
                    ab.e("MicroMsg.NodeJs", optString);
                    AppMethodBeat.o(102197);
                    return;
                default:
                    ab.d("MicroMsg.NodeJs", optString);
                    AppMethodBeat.o(102197);
                    return;
            }
        } catch (g e) {
            ab.e("MicroMsg.NodeToXLog", "execute exception : %s", e);
            cVar.aIU();
            AppMethodBeat.o(102197);
        }
        ab.e("MicroMsg.NodeToXLog", "execute exception : %s", e);
        cVar.aIU();
        AppMethodBeat.o(102197);
    }
}
