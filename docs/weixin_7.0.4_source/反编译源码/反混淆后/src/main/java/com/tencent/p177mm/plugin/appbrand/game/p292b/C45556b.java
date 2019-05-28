package com.tencent.p177mm.plugin.appbrand.game.p292b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.game.p292b.p1222a.C19224b;
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

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.b */
public final class C45556b extends C24765b {
    C12028m eAX;
    C38215a hqX;
    private C4931a hqY = new C424381();

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.b$a */
    class C10231a extends C28106a {
        private int hra;
        private List<String> idList;

        public C10231a(List list) {
            this.idList = list;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(130066);
            if (C5046bo.m7548ek(this.idList)) {
                AppMethodBeat.m2505o(130066);
                return false;
            }
            this.hra = this.idList.size();
            C4990ab.m7419v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "delete MiniGame info id listSize:%d", Integer.valueOf(this.hra));
            for (String b : this.idList) {
                C45556b.this.hqX.mo73840b(C34202c.mCh, b);
            }
            AppMethodBeat.m2505o(130066);
            return true;
        }

        public final String getName() {
            return "DeleteMiniGameTask";
        }

        public final String aAo() {
            AppMethodBeat.m2504i(130067);
            String format = String.format("{deleteSize: %d}", new Object[]{Integer.valueOf(this.hra)});
            AppMethodBeat.m2505o(130067);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.b$b */
    class C10232b extends C28106a {
        private int hrb;
        private List<String> idList;

        public C10232b(List list) {
            this.idList = list;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(130068);
            if (C5046bo.m7548ek(this.idList)) {
                AppMethodBeat.m2505o(130068);
                return false;
            }
            this.hrb = this.idList.size();
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id listSize:%d", Integer.valueOf(this.hrb));
            C45556b.this.hqX.beginTransaction();
            for (String str : this.idList) {
                C45556b.this.hqX.mo73840b(C34202c.mCh, str);
                C19224b As = C45557i.m84025As(str);
                if (As == null || C5046bo.isNullOrNil(As.field_AppName)) {
                    C4990ab.m7417i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted miniGame info is null. id:%s", str);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    String nullAsNil = C5046bo.nullAsNil(As.field_RecordId);
                    int hashCode = nullAsNil.hashCode();
                    C45556b.this.hqX.mo73839a(458752, 1, (long) hashCode, nullAsNil, currentTimeMillis, As.field_AppName);
                    C45556b.this.hqX.mo73839a(458752, 2, (long) hashCode, nullAsNil, currentTimeMillis, C3161d.m5410aL(As.field_AppName, false));
                    C45556b.this.hqX.mo73839a(458752, 3, (long) hashCode, nullAsNil, currentTimeMillis, C3161d.m5410aL(As.field_AppName, true));
                    C4990ab.m7419v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id = %s, name = %s", nullAsNil, As.field_AppName);
                }
            }
            C45556b.this.hqX.commit();
            AppMethodBeat.m2505o(130068);
            return true;
        }

        public final String getName() {
            return "InsertMiniGameTask";
        }

        public final String aAo() {
            AppMethodBeat.m2504i(130069);
            String format = String.format("{insertSize: %d}", new Object[]{Integer.valueOf(this.hrb)});
            AppMethodBeat.m2505o(130069);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.b$c */
    class C10233c extends C20844h {
        C10233c(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchMiniGameTask";
        }

        public final int getId() {
            return 30;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(130070);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            c28109j.mEy = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a = C45556b.this.hqX.mo73837a(c28109j.mDz, C34202c.mCh, this.mEl.mEs, true, true);
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
                    AppMethodBeat.m2505o(130070);
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(130070);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            AppMethodBeat.m2505o(130070);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.b$d */
    class C31293d extends C28106a {
        private int hpR;

        C31293d() {
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(130071);
            List<C19224b> aAG = C45557i.aAG();
            if (aAG == null || aAG.isEmpty()) {
                C4990ab.m7416i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame search list is nil.");
                AppMethodBeat.m2505o(130071);
                return true;
            }
            this.hpR = aAG.size();
            C45556b.this.hqX.beginTransaction();
            C45556b.this.hqX.mo73853s(C34202c.mCh);
            for (C19224b c19224b : aAG) {
                if (c19224b == null || C5046bo.isNullOrNil(c19224b.field_AppName)) {
                    C4990ab.m7416i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "UpdateMiniGameIndexTask appname is null");
                    this.hpR--;
                } else {
                    String nullAsNil = C5046bo.nullAsNil(c19224b.field_RecordId);
                    int hashCode = nullAsNil.hashCode();
                    long currentTimeMillis = System.currentTimeMillis();
                    C45556b.this.hqX.mo73839a(458752, 1, (long) hashCode, nullAsNil, currentTimeMillis, c19224b.field_AppName);
                    C45556b.this.hqX.mo73839a(458752, 2, (long) hashCode, nullAsNil, currentTimeMillis, C3161d.m5410aL(c19224b.field_AppName, false));
                    C45556b.this.hqX.mo73839a(458752, 3, (long) hashCode, nullAsNil, currentTimeMillis, C3161d.m5410aL(c19224b.field_AppName, true));
                }
            }
            C45556b.this.hqX.commit();
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "update MiniGame info id listSize:%d", Integer.valueOf(this.hpR));
            AppMethodBeat.m2505o(130071);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(130072);
            String format = String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.hpR)});
            AppMethodBeat.m2505o(130072);
            return format;
        }

        public final String getName() {
            return "UpdateMiniGameIndexTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b.b$1 */
    class C424381 implements C4931a {
        C424381() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(130065);
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame storage change: event=%s | eventData=%s", str, c4935m);
            ArrayList arrayList;
            switch (c4935m.hsh) {
                case 2:
                case 3:
                    if (!"batch".equals(str)) {
                        arrayList = new ArrayList();
                        arrayList.add(c4935m.obj.toString());
                        C45556b.this.eAX.mo23853a(65601, new C10232b(arrayList));
                        AppMethodBeat.m2505o(130065);
                        return;
                    } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                        C45556b.this.eAX.mo23853a(65601, new C10232b((List) c4935m.obj));
                        AppMethodBeat.m2505o(130065);
                        return;
                    }
                case 5:
                    if (!"batch".equals(str)) {
                        arrayList = new ArrayList();
                        arrayList.add(c4935m.obj.toString());
                        C45556b.this.eAX.mo23853a(65601, new C10231a(arrayList));
                        break;
                    } else if (c4935m.obj != null && (c4935m.obj instanceof List)) {
                        C45556b.this.eAX.mo23853a(65601, new C10231a((List) c4935m.obj));
                        AppMethodBeat.m2505o(130065);
                        return;
                    }
            }
            AppMethodBeat.m2505o(130065);
        }
    }

    public C45556b() {
        AppMethodBeat.m2504i(130073);
        AppMethodBeat.m2505o(130073);
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        AppMethodBeat.m2504i(130074);
        C28106a a = this.eAX.mo23853a(-65536, new C10233c(c20846i));
        AppMethodBeat.m2505o(130074);
        return a;
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(130075);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Success!");
            this.hqX = (C38215a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(8);
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.eAX.mo23853a(65601, new C31293d());
            C45557i.onCreate();
            C45557i.m84030e(this.hqY);
            AppMethodBeat.m2505o(130075);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Fail!");
        AppMethodBeat.m2505o(130075);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(130076);
        C45557i.onDestroy();
        C45557i.m84031f(this.hqY);
        this.hqX = null;
        this.eAX = null;
        AppMethodBeat.m2505o(130076);
        return true;
    }

    public final String getName() {
        return "FTS5SearchMiniGameLogic";
    }
}
