package com.tencent.p177mm.plugin.expt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.platformtools.C1952t;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.expt.hellhound.C11756b;
import com.tencent.p177mm.plugin.expt.p1257e.C20596b;
import com.tencent.p177mm.plugin.expt.p1257e.C27892c;
import com.tencent.p177mm.plugin.expt.p1257e.C34072d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.expt.p394a.C43014c;
import com.tencent.p177mm.plugin.expt.p395c.C11747d;
import com.tencent.p177mm.plugin.expt.p729b.C45898a;
import com.tencent.p177mm.plugin.expt.roomexpt.C11763b;
import com.tencent.p177mm.plugin.expt.roomexpt.C27899a;
import com.tencent.p177mm.plugin.expt.roomexpt.C38991d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.expt.PluginExpt */
public class PluginExpt extends C7597f implements C1671c, C34070a {
    private static HashMap<Integer, C1366d> jZD;
    private C1953a jZF;

    /* renamed from: com.tencent.mm.plugin.expt.PluginExpt$2 */
    static class C117432 implements C1366d {
        C117432() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C20596b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.PluginExpt$3 */
    static class C117443 implements C1366d {
        C117443() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C11763b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.PluginExpt$1 */
    static class C278881 implements C1366d {
        C278881() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C34072d.fnj;
        }
    }

    static {
        AppMethodBeat.m2504i(73322);
        HashMap hashMap = new HashMap();
        jZD = hashMap;
        hashMap.put(Integer.valueOf("EXPT_TABLE".hashCode()), new C278881());
        jZD.put(Integer.valueOf("EXPT_KEY_MAP_ID_TABLE".hashCode()), new C117432());
        jZD.put(Integer.valueOf("CHATROOM_MUTE_EXPT_TABLE".hashCode()), new C117443());
        AppMethodBeat.m2505o(73322);
    }

    public void installed() {
        AppMethodBeat.m2504i(73315);
        alias(C34070a.class);
        AppMethodBeat.m2505o(73315);
    }

    public void dependency() {
        AppMethodBeat.m2504i(73316);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(73316);
    }

    public void execute(C1681g c1681g) {
        boolean z = false;
        AppMethodBeat.m2504i(73317);
        C1720g.m3542a(C34069a.class, C45898a.bqR());
        C1720g.m3542a(C38991d.class, C27899a.brg());
        C1720g.m3542a(C43014c.class, C11747d.brb());
        if (!(c1681g == null || c1681g.f1233cc == null)) {
            C27892c.bru();
            if (C5046bo.getInt(C27892c.m44337a(C11745a.clicfg_weixin_register_mm_life_call, "", false), 0) > 0) {
                z = true;
            }
            if (z) {
                c1681g.f1233cc.registerActivityLifecycleCallbacks(C11747d.brb());
            }
        }
        C11756b.m19564d(c1681g);
        AppMethodBeat.m2505o(73317);
    }

    public String toString() {
        return "plugin-expt";
    }

    public void onAccountInitialized(C1705c c1705c) {
        boolean z = false;
        AppMethodBeat.m2504i(73318);
        C4990ab.m7417i("MicroMsg.PluginExpt", "Plugin expt onAccountInitialized [%d] [%d]", Integer.valueOf(hashCode()), Integer.valueOf(C45898a.bqR().hashCode()));
        initDB();
        C45898a bqR = C45898a.bqR();
        C1953a c1953a = this.jZF;
        String str = "MicroMsg.ExptService";
        String str2 = "reset DB [%d] dataDB[%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bqR.hashCode());
        if (c1953a != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (c1953a != null) {
            bqR.lNF = new C34072d(c1953a);
            bqR.lNG = new C20596b(c1953a);
        }
        C27899a.brg().lOt = new C11763b(this.jZF);
        AppMethodBeat.m2505o(73318);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(73319);
        C4990ab.m7417i("MicroMsg.PluginExpt", "Plugin expt onAccountRelease [%d] [%d]", Integer.valueOf(hashCode()), Integer.valueOf(C45898a.bqR().hashCode()));
        closeDB();
        AppMethodBeat.m2505o(73319);
    }

    private void initDB() {
        AppMethodBeat.m2504i(73320);
        if (this.jZF != null) {
            closeDB();
        }
        this.jZF = C1952t.m4171a(hashCode(), C1720g.m3536RP().cachePath + "WxExpt.db", jZD, true);
        AppMethodBeat.m2505o(73320);
    }

    private void closeDB() {
        AppMethodBeat.m2504i(73321);
        if (this.jZF != null) {
            this.jZF.mo5709mJ(hashCode());
        }
        this.jZF = null;
        C45898a bqR = C45898a.bqR();
        bqR.lNF = null;
        bqR.lNG = null;
        AppMethodBeat.m2505o(73321);
    }
}
