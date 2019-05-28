package com.tencent.p177mm.plugin.appbrand.p894f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39129m;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.f.b */
public final class C45552b extends C24765b {
    C12028m eAX;
    C38211c hpO;
    private C4931a hpP = new C424341();

    /* renamed from: com.tencent.mm.plugin.appbrand.f.b$a */
    class C33178a extends C28106a {
        /* renamed from: id */
        private String f15031id;

        public C33178a(String str) {
            this.f15031id = str;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(129957);
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", this.f15031id);
            C45552b.this.hpO.mo73840b(C34202c.mCg, this.f15031id);
            AppMethodBeat.m2505o(129957);
            return true;
        }

        public final String getName() {
            return "DeleteWeAppTask";
        }

        public final String aAo() {
            AppMethodBeat.m2504i(129958);
            String format = String.format("{id: %s}", new Object[]{this.f15031id});
            AppMethodBeat.m2505o(129958);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.f.b$b */
    class C33179b extends C28106a {
        /* renamed from: id */
        private String f15032id;
        private String name;

        public C33179b(String str) {
            this.f15032id = str;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(129959);
            C45552b.this.hpO.beginTransaction();
            C45552b.this.hpO.mo73840b(C34202c.mCg, this.f15032id);
            AppBrandRecentTaskInfo An = C45553i.m84010An(this.f15032id);
            if (An != null) {
                long currentTimeMillis = System.currentTimeMillis();
                String nullAsNil = C5046bo.nullAsNil(An.euD);
                int hashCode = nullAsNil.hashCode();
                C45552b.this.hpO.mo73839a(393216, 1, (long) hashCode, nullAsNil, currentTimeMillis, An.appName);
                C45552b.this.hpO.mo73839a(393216, 2, (long) hashCode, nullAsNil, currentTimeMillis, C3161d.m5410aL(An.appName, false));
                C45552b.this.hpO.mo73839a(393216, 3, (long) hashCode, nullAsNil, currentTimeMillis, C3161d.m5410aL(An.appName, true));
                this.name = An.appName;
                C4990ab.m7417i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", nullAsNil);
            }
            C45552b.this.hpO.commit();
            AppMethodBeat.m2505o(129959);
            return true;
        }

        public final String getName() {
            return "InsertWeAppTask";
        }

        public final String aAo() {
            AppMethodBeat.m2504i(129960);
            String format = String.format("{name: %s id: %s}", new Object[]{this.name, this.f15032id});
            AppMethodBeat.m2505o(129960);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.f.b$c */
    class C33180c extends C20844h {
        C33180c(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchWeAppTask";
        }

        public final int getId() {
            return 21;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(129961);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            c28109j.mEy = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a = C45552b.this.hpO.mo73837a(c28109j.mDz, C34202c.mCg, this.mEl.mEs, true, true);
            while (a.moveToNext()) {
                try {
                    C39129m c39129m = new C39129m();
                    c39129m.mo62032k(a);
                    if (!(hashSet.contains(Long.valueOf(c39129m.mEB)) || this.mEl.mEu.contains(c39129m.mDx))) {
                        c39129m.bAo();
                        c28109j.mEy.add(c39129m);
                        hashSet.add(Long.valueOf(c39129m.mEB));
                    }
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(129961);
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(129961);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            AppMethodBeat.m2505o(129961);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.f.b$d */
    class C33181d extends C28106a {
        private int hpR;

        C33181d() {
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(129962);
            List<AppBrandRecentTaskInfo> aAr = C45553i.aAr();
            if (aAr.isEmpty()) {
                C4990ab.m7416i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
                AppMethodBeat.m2505o(129962);
                return true;
            }
            this.hpR = aAr.size();
            C45552b.this.hpO.beginTransaction();
            C45552b.this.hpO.mo73853s(C34202c.mCg);
            for (AppBrandRecentTaskInfo appBrandRecentTaskInfo : aAr) {
                String nullAsNil = C5046bo.nullAsNil(appBrandRecentTaskInfo.euD);
                int hashCode = nullAsNil.hashCode();
                long currentTimeMillis = System.currentTimeMillis();
                C45552b.this.hpO.mo73839a(393216, 1, (long) hashCode, nullAsNil, currentTimeMillis, appBrandRecentTaskInfo.appName);
                C45552b.this.hpO.mo73839a(393216, 2, (long) hashCode, nullAsNil, currentTimeMillis, C3161d.m5410aL(appBrandRecentTaskInfo.appName, false));
                C45552b.this.hpO.mo73839a(393216, 3, (long) hashCode, nullAsNil, currentTimeMillis, C3161d.m5410aL(appBrandRecentTaskInfo.appName, true));
            }
            C45552b.this.hpO.commit();
            AppMethodBeat.m2505o(129962);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(129963);
            String format = String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.hpR)});
            AppMethodBeat.m2505o(129963);
            return format;
        }

        public final String getName() {
            return "UpdateWeAppIndexTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.f.b$1 */
    class C424341 implements C4931a {
        C424341() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(129956);
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", str, c4935m);
            switch (c4935m.hsh) {
                case 2:
                case 3:
                    if (!"batch".equals(str)) {
                        C45552b.this.eAX.mo23853a(65616, new C33179b(c4935m.obj.toString()));
                        AppMethodBeat.m2505o(129956);
                        return;
                    } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                        for (String c33179b : (List) c4935m.obj) {
                            C45552b.this.eAX.mo23853a(65616, new C33179b(c33179b));
                        }
                        AppMethodBeat.m2505o(129956);
                        return;
                    }
                case 5:
                    if (!"batch".equals(str)) {
                        C45552b.this.eAX.mo23853a(65616, new C33178a(c4935m.obj.toString()));
                        break;
                    } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                        for (String c33179b2 : (List) c4935m.obj) {
                            C45552b.this.eAX.mo23853a(65616, new C33178a(c33179b2));
                        }
                        AppMethodBeat.m2505o(129956);
                        return;
                    }
            }
            AppMethodBeat.m2505o(129956);
        }
    }

    public C45552b() {
        AppMethodBeat.m2504i(129964);
        AppMethodBeat.m2505o(129964);
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        AppMethodBeat.m2504i(129965);
        C28106a a = this.eAX.mo23853a(-65536, new C33180c(c20846i));
        AppMethodBeat.m2505o(129965);
        return a;
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(129966);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
            this.hpO = (C38211c) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(512);
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.eAX.mo23853a(65616, new C33181d());
            C45553i.onCreate();
            C45553i.m84011e(this.hpP);
            AppMethodBeat.m2505o(129966);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
        AppMethodBeat.m2505o(129966);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(129967);
        C45553i.onDestroy();
        C45553i.m84012f(this.hpP);
        this.hpO = null;
        this.eAX = null;
        AppMethodBeat.m2505o(129967);
        return true;
    }

    public final String getName() {
        return "FTS5SearchWeAppLogic";
    }
}
