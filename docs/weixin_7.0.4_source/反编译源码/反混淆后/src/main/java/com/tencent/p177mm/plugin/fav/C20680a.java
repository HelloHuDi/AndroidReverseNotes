package com.tencent.p177mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fav.a */
public final class C20680a implements C3472n {
    /* renamed from: a */
    public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
        AppMethodBeat.m2504i(5281);
        C4990ab.m7417i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", str, map.toString());
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
                C4883b c37721gh = new C37721gh();
                c37721gh.cAH.type = 38;
                c37721gh.cAH.cAQ = (String) map.get(".sysmsg.favids");
                C4879a.xxA.mo10048a(c37721gh, Looper.getMainLooper());
                C27968h.m44533vv(1);
                break;
            case 1:
                C4883b c37721gh2 = new C37721gh();
                c37721gh2.cAH.type = 39;
                c37721gh2.cAH.cAQ = (String) map.get(".sysmsg.favitem.favid");
                c37721gh2.cAH.cAR = (String) map.get(".sysmsg.favitem.dataidlist");
                C4879a.xxA.mo10048a(c37721gh2, Looper.getMainLooper());
                C27968h.m44533vv(0);
                break;
        }
        AppMethodBeat.m2505o(5281);
        return null;
    }
}
