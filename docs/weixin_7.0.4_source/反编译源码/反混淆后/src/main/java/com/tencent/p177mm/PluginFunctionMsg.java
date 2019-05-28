package com.tencent.p177mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C25783q;
import com.tencent.p177mm.api.C32248f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p1088u.C23524a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C39366h;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.HashMap;

/* renamed from: com.tencent.mm.PluginFunctionMsg */
public class PluginFunctionMsg extends C7597f implements C25783q, C1669a {
    private static HashMap<Integer, C1366d> cbO = new HashMap();

    public C23524a getReceiver() {
        return C23524a.eAA;
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(35442);
        super.configure(c1681g);
        C1720g.m3542a(C39366h.class, getReceiver());
        AppMethodBeat.m2505o(35442);
    }

    public void execute(C1681g c1681g) {
    }

    static {
        AppMethodBeat.m2504i(35444);
        final String[] strArr = new String[]{C7563j.m13217a(C32248f.ccO, "FunctionMsgItem")};
        cbO.put(Integer.valueOf("FunctionMsgItem".hashCode()), new C1366d() {
            /* renamed from: Af */
            public final String[] mo4750Af() {
                return strArr;
            }
        });
        AppMethodBeat.m2505o(35444);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        return cbO;
    }
}
