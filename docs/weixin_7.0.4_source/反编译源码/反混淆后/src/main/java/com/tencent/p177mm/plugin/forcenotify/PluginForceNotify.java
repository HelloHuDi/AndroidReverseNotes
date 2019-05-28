package com.tencent.p177mm.plugin.forcenotify;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C20772b;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C28062a;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C28063c;
import com.tencent.p177mm.plugin.forcenotify.p1263b.C20774b;
import com.tencent.p177mm.plugin.forcenotify.p1263b.C43100c;
import com.tencent.p177mm.plugin.forcenotify.p1613c.C43101b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.forcenotify.PluginForceNotify */
public class PluginForceNotify extends C7597f implements C1669a, C9562c, C28063c {
    public static HashMap<Integer, C1366d> eaA = new HashMap();

    public void installed() {
        AppMethodBeat.m2504i(51010);
        alias(C28063c.class);
        AppMethodBeat.m2505o(51010);
    }

    public void dependency() {
        AppMethodBeat.m2504i(51011);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(51011);
    }

    static {
        AppMethodBeat.m2504i(51014);
        final String[] strArr = new String[]{C7563j.m13217a(C43101b.ccO, "ForceNotifyInfo")};
        eaA.put(Integer.valueOf("SPORTSTEP_TABLE".hashCode()), new C1366d() {
            /* renamed from: Af */
            public final String[] mo4750Af() {
                return strArr;
            }
        });
        AppMethodBeat.m2505o(51014);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        return eaA;
    }

    public void configure(C1681g c1681g) {
    }

    public void execute(C1681g c1681g) {
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(51012);
        C43100c.mtf.start();
        C1720g.m3542a(C20772b.class, C43100c.mtf);
        C1720g.m3542a(C28062a.class, C20774b.mtb);
        AppMethodBeat.m2505o(51012);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(51013);
        C43100c.mtf.release();
        C1720g.m3529L(C20772b.class);
        AppMethodBeat.m2505o(51013);
    }
}
