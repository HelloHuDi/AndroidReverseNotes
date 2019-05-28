package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class i implements t {
    public static boolean vbc = false;
    private static i vbd;
    public a vbe;

    public interface a {
        void a(l lVar);
    }

    public static class b {
        public String vbf;
    }

    private i() {
    }

    public static i dgZ() {
        AppMethodBeat.i(27296);
        if (vbd == null) {
            vbd = new i();
        }
        i iVar = vbd;
        AppMethodBeat.o(27296);
        return iVar;
    }

    public final void dha() {
        AppMethodBeat.i(27297);
        if (aw.RK()) {
            am.bYM().a(14, (t) this);
            vbc = true;
            AppMethodBeat.o(27297);
            return;
        }
        AppMethodBeat.o(27297);
    }

    public final void a(int i, int i2, String str, x xVar) {
        AppMethodBeat.i(27298);
        if (aw.RK()) {
            ab.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (xVar == null) {
                ab.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
                AppMethodBeat.o(27298);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (xVar.getType()) {
                    case 14:
                        if (ah.getContext() != null && com.tencent.mm.plugin.s.a.a.a.bYQ() != null) {
                            ab.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", Integer.valueOf(i), Integer.valueOf(i2));
                            l lVar = (l) xVar;
                            if (this.vbe != null) {
                                this.vbe.a(lVar);
                                break;
                            }
                        }
                        ab.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
                        AppMethodBeat.o(27298);
                        return;
                        break;
                }
            }
            AppMethodBeat.o(27298);
            return;
        }
        AppMethodBeat.o(27298);
    }

    public static b aiA(String str) {
        AppMethodBeat.i(27299);
        if (str == null) {
            AppMethodBeat.o(27299);
            return null;
        }
        Map z = br.z(str, "PersonalAppSetting");
        if (z == null) {
            AppMethodBeat.o(27299);
            return null;
        }
        String str2 = (String) z.get(".PersonalAppSetting.OpenID");
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(27299);
            return null;
        }
        b bVar = new b();
        bVar.vbf = str2;
        AppMethodBeat.o(27299);
        return bVar;
    }
}
