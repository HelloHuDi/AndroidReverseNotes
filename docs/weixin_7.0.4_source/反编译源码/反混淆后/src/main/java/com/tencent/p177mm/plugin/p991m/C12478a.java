package com.tencent.p177mm.plugin.p991m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.storage.C7571bh;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.m.a */
public final class C12478a implements C18523a, C26346d, C34506a {
    private C7571bh opq;

    /* renamed from: com.tencent.mm.plugin.m.a$1 */
    class C124791 implements C1366d {
        C124791() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7571bh.fnj;
        }
    }

    /* renamed from: XT */
    public final C7571bh mo24388XT() {
        AppMethodBeat.m2504i(79102);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7571bh c7571bh = this.opq;
        AppMethodBeat.m2505o(79102);
        return c7571bh;
    }

    public final void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(79103);
        this.opq = new C7571bh(c7480h);
        AppMethodBeat.m2505o(79103);
    }

    public final void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(79104);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new C124791());
        AppMethodBeat.m2505o(79104);
        return hashMap;
    }
}
