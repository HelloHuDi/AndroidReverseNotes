package com.tencent.p177mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C42913e;
import com.tencent.p177mm.plugin.downloader_app.p944d.C33936c;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.downloader_app.c */
public final class C44730c implements C18523a, C26346d, C42913e {
    private C33936c kNX;

    /* renamed from: com.tencent.mm.plugin.downloader_app.c$1 */
    class C429221 implements C1366d {
        C429221() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C33936c.fnj;
        }
    }

    public final C33936c biA() {
        return this.kNX;
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(136025);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("DOWNLOADTASKITEM_TABLE".hashCode()), new C429221());
        AppMethodBeat.m2505o(136025);
        return hashMap;
    }

    public final void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(136026);
        this.kNX = new C33936c(c7480h);
        AppMethodBeat.m2505o(136026);
    }

    public final void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }
}
