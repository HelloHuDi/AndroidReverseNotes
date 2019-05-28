package com.tencent.mm.plugin.appbrand.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m eAX;
    c hpO;
    private com.tencent.mm.sdk.e.k.a hpP = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(129956);
            ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", str, mVar);
            switch (mVar.hsh) {
                case 2:
                case 3:
                    if (!"batch".equals(str)) {
                        b.this.eAX.a(65616, new b(mVar.obj.toString()));
                        AppMethodBeat.o(129956);
                        return;
                    } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                        for (String bVar : (List) mVar.obj) {
                            b.this.eAX.a(65616, new b(bVar));
                        }
                        AppMethodBeat.o(129956);
                        return;
                    }
                case 5:
                    if (!"batch".equals(str)) {
                        b.this.eAX.a(65616, new a(mVar.obj.toString()));
                        break;
                    } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                        for (String bVar2 : (List) mVar.obj) {
                            b.this.eAX.a(65616, new a(bVar2));
                        }
                        AppMethodBeat.o(129956);
                        return;
                    }
            }
            AppMethodBeat.o(129956);
        }
    };

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private String id;

        public a(String str) {
            this.id = str;
        }

        public final boolean execute() {
            AppMethodBeat.i(129957);
            ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", this.id);
            b.this.hpO.b(com.tencent.mm.plugin.fts.a.c.mCg, this.id);
            AppMethodBeat.o(129957);
            return true;
        }

        public final String getName() {
            return "DeleteWeAppTask";
        }

        public final String aAo() {
            AppMethodBeat.i(129958);
            String format = String.format("{id: %s}", new Object[]{this.id});
            AppMethodBeat.o(129958);
            return format;
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private String id;
        private String name;

        public b(String str) {
            this.id = str;
        }

        public final boolean execute() {
            AppMethodBeat.i(129959);
            b.this.hpO.beginTransaction();
            b.this.hpO.b(com.tencent.mm.plugin.fts.a.c.mCg, this.id);
            AppBrandRecentTaskInfo An = i.An(this.id);
            if (An != null) {
                long currentTimeMillis = System.currentTimeMillis();
                String nullAsNil = bo.nullAsNil(An.euD);
                int hashCode = nullAsNil.hashCode();
                b.this.hpO.a(393216, 1, (long) hashCode, nullAsNil, currentTimeMillis, An.appName);
                b.this.hpO.a(393216, 2, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.aL(An.appName, false));
                b.this.hpO.a(393216, 3, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.aL(An.appName, true));
                this.name = An.appName;
                ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", nullAsNil);
            }
            b.this.hpO.commit();
            AppMethodBeat.o(129959);
            return true;
        }

        public final String getName() {
            return "InsertWeAppTask";
        }

        public final String aAo() {
            AppMethodBeat.i(129960);
            String format = String.format("{name: %s id: %s}", new Object[]{this.name, this.id});
            AppMethodBeat.o(129960);
            return format;
        }
    }

    class c extends h {
        c(i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchWeAppTask";
        }

        public final int getId() {
            return 21;
        }

        public final void a(j jVar) {
            AppMethodBeat.i(129961);
            jVar.mDz = g.aO(this.mEl.query, true);
            jVar.mEy = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a = b.this.hpO.a(jVar.mDz, com.tencent.mm.plugin.fts.a.c.mCg, this.mEl.mEs, true, true);
            while (a.moveToNext()) {
                try {
                    com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                    mVar.k(a);
                    if (!(hashSet.contains(Long.valueOf(mVar.mEB)) || this.mEl.mEu.contains(mVar.mDx))) {
                        mVar.bAo();
                        jVar.mEy.add(mVar);
                        hashSet.add(Long.valueOf(mVar.mEB));
                    }
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(129961);
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(129961);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            AppMethodBeat.o(129961);
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private int hpR;

        d() {
        }

        public final boolean execute() {
            AppMethodBeat.i(129962);
            List<AppBrandRecentTaskInfo> aAr = i.aAr();
            if (aAr.isEmpty()) {
                ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
                AppMethodBeat.o(129962);
                return true;
            }
            this.hpR = aAr.size();
            b.this.hpO.beginTransaction();
            b.this.hpO.s(com.tencent.mm.plugin.fts.a.c.mCg);
            for (AppBrandRecentTaskInfo appBrandRecentTaskInfo : aAr) {
                String nullAsNil = bo.nullAsNil(appBrandRecentTaskInfo.euD);
                int hashCode = nullAsNil.hashCode();
                long currentTimeMillis = System.currentTimeMillis();
                b.this.hpO.a(393216, 1, (long) hashCode, nullAsNil, currentTimeMillis, appBrandRecentTaskInfo.appName);
                b.this.hpO.a(393216, 2, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.aL(appBrandRecentTaskInfo.appName, false));
                b.this.hpO.a(393216, 3, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.aL(appBrandRecentTaskInfo.appName, true));
            }
            b.this.hpO.commit();
            AppMethodBeat.o(129962);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(129963);
            String format = String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.hpR)});
            AppMethodBeat.o(129963);
            return format;
        }

        public final String getName() {
            return "UpdateWeAppIndexTask";
        }
    }

    public b() {
        AppMethodBeat.i(129964);
        AppMethodBeat.o(129964);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        AppMethodBeat.i(129965);
        com.tencent.mm.plugin.fts.a.a.a a = this.eAX.a(-65536, new c(iVar));
        AppMethodBeat.o(129965);
        return a;
    }

    public final boolean onCreate() {
        AppMethodBeat.i(129966);
        if (((n) com.tencent.mm.kernel.g.M(n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
            this.hpO = (c) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(512);
            this.eAX = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSTaskDaemon();
            this.eAX.a(65616, new d());
            i.onCreate();
            i.e(this.hpP);
            AppMethodBeat.o(129966);
            return true;
        }
        ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
        AppMethodBeat.o(129966);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(129967);
        i.onDestroy();
        i.f(this.hpP);
        this.hpO = null;
        this.eAX = null;
        AppMethodBeat.o(129967);
        return true;
    }

    public final String getName() {
        return "FTS5SearchWeAppLogic";
    }
}
