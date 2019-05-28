package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class c implements at {
    private static HashMap<Integer, d> eaA = new HashMap();
    private volatile a pkw;
    private o pkx = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, e.a aVar) {
            AppMethodBeat.i(23243);
            if (bo.nullAsNil(str).equals("NewXmlOpenIMFriReqAcceptedInWxWork")) {
                new com.tencent.mm.plugin.profile.b.e(map).aip();
            }
            AppMethodBeat.o(23243);
        }
    };

    public c() {
        AppMethodBeat.i(23244);
        AppMethodBeat.o(23244);
    }

    static {
        AppMethodBeat.i(23250);
        b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), "//usenewprofile");
        eaA.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return a.fjY;
            }
        });
        AppMethodBeat.o(23250);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public static a cap() {
        AppMethodBeat.i(23245);
        g.RN().QU();
        if (caq().pkw == null) {
            c caq = caq();
            aw.ZK();
            caq.pkw = new a(com.tencent.mm.model.c.Ru());
        }
        a aVar = caq().pkw;
        AppMethodBeat.o(23245);
        return aVar;
    }

    private static c caq() {
        AppMethodBeat.i(23246);
        aw.ZE();
        c cVar = (c) bw.oJ("plugin.profile");
        if (cVar == null) {
            ab.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
            cVar = new c();
            aw.ZE().a("plugin.freewifi", cVar);
        }
        AppMethodBeat.o(23246);
        return cVar;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(23247);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("NewXmlOpenIMFriReqAcceptedInWxWork", this.pkx);
        AppMethodBeat.o(23247);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(23248);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("NewXmlOpenIMFriReqAcceptedInWxWork", this.pkx);
        AppMethodBeat.o(23248);
    }

    public static int am(Intent intent) {
        AppMethodBeat.i(23249);
        if (intent != null) {
            int intExtra = intent.getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
            ab.d("MicroMsg.SubCoreProfile", "[getPrefixAddScene] source:".concat(String.valueOf(intExtra)));
            AppMethodBeat.o(23249);
            return intExtra;
        }
        AppMethodBeat.o(23249);
        return 0;
    }
}
