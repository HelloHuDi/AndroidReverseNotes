package com.tencent.mm.plugin.expt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class PluginExpt extends f implements c, a {
    private static HashMap<Integer, d> jZD;
    private a jZF;

    static {
        AppMethodBeat.i(73322);
        HashMap hashMap = new HashMap();
        jZD = hashMap;
        hashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.expt.e.d.fnj;
            }
        });
        jZD.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        jZD.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.expt.roomexpt.b.fnj;
            }
        });
        AppMethodBeat.o(73322);
    }

    public void installed() {
        AppMethodBeat.i(73315);
        alias(a.class);
        AppMethodBeat.o(73315);
    }

    public void dependency() {
        AppMethodBeat.i(73316);
        dependsOn(p.class);
        AppMethodBeat.o(73316);
    }

    public void execute(g gVar) {
        boolean z = false;
        AppMethodBeat.i(73317);
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.expt.a.a.class, com.tencent.mm.plugin.expt.b.a.bqR());
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.expt.roomexpt.d.class, com.tencent.mm.plugin.expt.roomexpt.a.brg());
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.expt.a.c.class, com.tencent.mm.plugin.expt.c.d.brb());
        if (!(gVar == null || gVar.cc == null)) {
            com.tencent.mm.plugin.expt.e.c.bru();
            if (bo.getInt(com.tencent.mm.plugin.expt.e.c.a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_register_mm_life_call, "", false), 0) > 0) {
                z = true;
            }
            if (z) {
                gVar.cc.registerActivityLifecycleCallbacks(com.tencent.mm.plugin.expt.c.d.brb());
            }
        }
        com.tencent.mm.plugin.expt.hellhound.b.d(gVar);
        AppMethodBeat.o(73317);
    }

    public String toString() {
        return "plugin-expt";
    }

    public void onAccountInitialized(e.c cVar) {
        boolean z = false;
        AppMethodBeat.i(73318);
        ab.i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.b.a.bqR().hashCode()));
        initDB();
        com.tencent.mm.plugin.expt.b.a bqR = com.tencent.mm.plugin.expt.b.a.bqR();
        a aVar = this.jZF;
        String str = "MicroMsg.ExptService";
        String str2 = "reset DB [%d] dataDB[%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bqR.hashCode());
        if (aVar != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (aVar != null) {
            bqR.lNF = new com.tencent.mm.plugin.expt.e.d(aVar);
            bqR.lNG = new b(aVar);
        }
        com.tencent.mm.plugin.expt.roomexpt.a.brg().lOt = new com.tencent.mm.plugin.expt.roomexpt.b(this.jZF);
        AppMethodBeat.o(73318);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(73319);
        ab.i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", Integer.valueOf(hashCode()), Integer.valueOf(com.tencent.mm.plugin.expt.b.a.bqR().hashCode()));
        closeDB();
        AppMethodBeat.o(73319);
    }

    private void initDB() {
        AppMethodBeat.i(73320);
        if (this.jZF != null) {
            closeDB();
        }
        this.jZF = t.a(hashCode(), com.tencent.mm.kernel.g.RP().cachePath + "WxExpt.db", jZD, true);
        AppMethodBeat.o(73320);
    }

    private void closeDB() {
        AppMethodBeat.i(73321);
        if (this.jZF != null) {
            this.jZF.mJ(hashCode());
        }
        this.jZF = null;
        com.tencent.mm.plugin.expt.b.a bqR = com.tencent.mm.plugin.expt.b.a.bqR();
        bqR.lNF = null;
        bqR.lNG = null;
        AppMethodBeat.o(73321);
    }
}
