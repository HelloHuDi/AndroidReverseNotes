package com.tencent.p177mm.plugin.cdndownloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.cdndownloader.p1543b.C38782a;
import com.tencent.p177mm.plugin.cdndownloader.p935f.C11368c;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.cdndownloader.a */
public final class C42877a implements C18523a, C26346d, C38782a {
    private C11368c ksY;

    /* renamed from: com.tencent.mm.plugin.cdndownloader.a$1 */
    class C338071 implements C1366d {
        C338071() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C11368c.fnj;
        }
    }

    public final C11368c beQ() {
        return this.ksY;
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(859);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("CdnDownloadInfo".hashCode()), new C338071());
        AppMethodBeat.m2505o(859);
        return hashMap;
    }

    public final void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(860);
        this.ksY = new C11368c(c7480h);
        AppMethodBeat.m2505o(860);
    }

    public final void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }
}
