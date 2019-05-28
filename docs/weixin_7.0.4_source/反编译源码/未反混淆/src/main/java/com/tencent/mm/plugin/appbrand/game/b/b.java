package com.tencent.mm.plugin.appbrand.game.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    a hqX;
    private com.tencent.mm.sdk.e.k.a hqY = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(130065);
            ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame storage change: event=%s | eventData=%s", str, mVar);
            ArrayList arrayList;
            switch (mVar.hsh) {
                case 2:
                case 3:
                    if (!"batch".equals(str)) {
                        arrayList = new ArrayList();
                        arrayList.add(mVar.obj.toString());
                        b.this.eAX.a(65601, new b(arrayList));
                        AppMethodBeat.o(130065);
                        return;
                    } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                        b.this.eAX.a(65601, new b((List) mVar.obj));
                        AppMethodBeat.o(130065);
                        return;
                    }
                case 5:
                    if (!"batch".equals(str)) {
                        arrayList = new ArrayList();
                        arrayList.add(mVar.obj.toString());
                        b.this.eAX.a(65601, new a(arrayList));
                        break;
                    } else if (mVar.obj != null && (mVar.obj instanceof List)) {
                        b.this.eAX.a(65601, new a((List) mVar.obj));
                        AppMethodBeat.o(130065);
                        return;
                    }
            }
            AppMethodBeat.o(130065);
        }
    };

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int hra;
        private List<String> idList;

        public a(List list) {
            this.idList = list;
        }

        public final boolean execute() {
            AppMethodBeat.i(130066);
            if (bo.ek(this.idList)) {
                AppMethodBeat.o(130066);
                return false;
            }
            this.hra = this.idList.size();
            ab.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "delete MiniGame info id listSize:%d", Integer.valueOf(this.hra));
            for (String b : this.idList) {
                b.this.hqX.b(com.tencent.mm.plugin.fts.a.c.mCh, b);
            }
            AppMethodBeat.o(130066);
            return true;
        }

        public final String getName() {
            return "DeleteMiniGameTask";
        }

        public final String aAo() {
            AppMethodBeat.i(130067);
            String format = String.format("{deleteSize: %d}", new Object[]{Integer.valueOf(this.hra)});
            AppMethodBeat.o(130067);
            return format;
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private int hrb;
        private List<String> idList;

        public b(List list) {
            this.idList = list;
        }

        public final boolean execute() {
            AppMethodBeat.i(130068);
            if (bo.ek(this.idList)) {
                AppMethodBeat.o(130068);
                return false;
            }
            this.hrb = this.idList.size();
            ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id listSize:%d", Integer.valueOf(this.hrb));
            b.this.hqX.beginTransaction();
            for (String str : this.idList) {
                b.this.hqX.b(com.tencent.mm.plugin.fts.a.c.mCh, str);
                com.tencent.mm.plugin.appbrand.game.b.a.b As = i.As(str);
                if (As == null || bo.isNullOrNil(As.field_AppName)) {
                    ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted miniGame info is null. id:%s", str);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    String nullAsNil = bo.nullAsNil(As.field_RecordId);
                    int hashCode = nullAsNil.hashCode();
                    b.this.hqX.a(458752, 1, (long) hashCode, nullAsNil, currentTimeMillis, As.field_AppName);
                    b.this.hqX.a(458752, 2, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.aL(As.field_AppName, false));
                    b.this.hqX.a(458752, 3, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.aL(As.field_AppName, true));
                    ab.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id = %s, name = %s", nullAsNil, As.field_AppName);
                }
            }
            b.this.hqX.commit();
            AppMethodBeat.o(130068);
            return true;
        }

        public final String getName() {
            return "InsertMiniGameTask";
        }

        public final String aAo() {
            AppMethodBeat.i(130069);
            String format = String.format("{insertSize: %d}", new Object[]{Integer.valueOf(this.hrb)});
            AppMethodBeat.o(130069);
            return format;
        }
    }

    class c extends h {
        c(i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchMiniGameTask";
        }

        public final int getId() {
            return 30;
        }

        public final void a(j jVar) {
            AppMethodBeat.i(130070);
            jVar.mDz = g.aO(this.mEl.query, true);
            jVar.mEy = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a = b.this.hqX.a(jVar.mDz, com.tencent.mm.plugin.fts.a.c.mCh, this.mEl.mEs, true, true);
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
                    AppMethodBeat.o(130070);
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(130070);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            AppMethodBeat.o(130070);
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private int hpR;

        d() {
        }

        public final boolean execute() {
            AppMethodBeat.i(130071);
            List<com.tencent.mm.plugin.appbrand.game.b.a.b> aAG = i.aAG();
            if (aAG == null || aAG.isEmpty()) {
                ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame search list is nil.");
                AppMethodBeat.o(130071);
                return true;
            }
            this.hpR = aAG.size();
            b.this.hqX.beginTransaction();
            b.this.hqX.s(com.tencent.mm.plugin.fts.a.c.mCh);
            for (com.tencent.mm.plugin.appbrand.game.b.a.b bVar : aAG) {
                if (bVar == null || bo.isNullOrNil(bVar.field_AppName)) {
                    ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "UpdateMiniGameIndexTask appname is null");
                    this.hpR--;
                } else {
                    String nullAsNil = bo.nullAsNil(bVar.field_RecordId);
                    int hashCode = nullAsNil.hashCode();
                    long currentTimeMillis = System.currentTimeMillis();
                    b.this.hqX.a(458752, 1, (long) hashCode, nullAsNil, currentTimeMillis, bVar.field_AppName);
                    b.this.hqX.a(458752, 2, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.aL(bVar.field_AppName, false));
                    b.this.hqX.a(458752, 3, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.aL(bVar.field_AppName, true));
                }
            }
            b.this.hqX.commit();
            ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "update MiniGame info id listSize:%d", Integer.valueOf(this.hpR));
            AppMethodBeat.o(130071);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(130072);
            String format = String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.hpR)});
            AppMethodBeat.o(130072);
            return format;
        }

        public final String getName() {
            return "UpdateMiniGameIndexTask";
        }
    }

    public b() {
        AppMethodBeat.i(130073);
        AppMethodBeat.o(130073);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        AppMethodBeat.i(130074);
        com.tencent.mm.plugin.fts.a.a.a a = this.eAX.a(-65536, new c(iVar));
        AppMethodBeat.o(130074);
        return a;
    }

    public final boolean onCreate() {
        AppMethodBeat.i(130075);
        if (((n) com.tencent.mm.kernel.g.M(n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Success!");
            this.hqX = (a) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(8);
            this.eAX = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSTaskDaemon();
            this.eAX.a(65601, new d());
            i.onCreate();
            i.e(this.hqY);
            AppMethodBeat.o(130075);
            return true;
        }
        ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Fail!");
        AppMethodBeat.o(130075);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(130076);
        i.onDestroy();
        i.f(this.hqY);
        this.hqX = null;
        this.eAX = null;
        AppMethodBeat.o(130076);
        return true;
    }

    public final String getName() {
        return "FTS5SearchMiniGameLogic";
    }
}
