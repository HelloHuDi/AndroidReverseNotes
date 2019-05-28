package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public final class a implements n {
    public final b a(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(5281);
        ab.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", str, map.toString());
        int i = -1;
        switch (str.hashCode()) {
            case -1938535405:
                if (str.equals("resendfavitem")) {
                    i = 1;
                    break;
                }
                break;
            case -1648140403:
                if (str.equals("uploadfavitem")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                com.tencent.mm.sdk.b.b ghVar = new gh();
                ghVar.cAH.type = 38;
                ghVar.cAH.cAQ = (String) map.get(".sysmsg.favids");
                com.tencent.mm.sdk.b.a.xxA.a(ghVar, Looper.getMainLooper());
                h.vv(1);
                break;
            case 1:
                com.tencent.mm.sdk.b.b ghVar2 = new gh();
                ghVar2.cAH.type = 39;
                ghVar2.cAH.cAQ = (String) map.get(".sysmsg.favitem.favid");
                ghVar2.cAH.cAR = (String) map.get(".sysmsg.favitem.dataidlist");
                com.tencent.mm.sdk.b.a.xxA.a(ghVar2, Looper.getMainLooper());
                h.vv(0);
                break;
        }
        AppMethodBeat.o(5281);
        return null;
    }
}
