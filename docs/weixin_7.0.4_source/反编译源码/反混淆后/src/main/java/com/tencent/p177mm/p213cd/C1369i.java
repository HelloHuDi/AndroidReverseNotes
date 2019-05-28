package com.tencent.p177mm.p213cd;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.tencent.mm.cd.i */
public final class C1369i {
    private C7564ap che = new C7564ap(Looper.getMainLooper(), new C13701(), false);
    private BlockingQueue<C1368a> queue = new LinkedBlockingQueue();
    private String table = null;
    C7480h ybK;

    /* renamed from: com.tencent.mm.cd.i$a */
    public static class C1368a {
        public String sql;
        public ContentValues values;
        public int xBj;
        public String xDc;
        public String ycf;
        public String[] ycg;

        /* renamed from: T */
        public final void mo4752T(String[] strArr) {
            AppMethodBeat.m2504i(59131);
            if (strArr == null || strArr.length <= 0) {
                AppMethodBeat.m2505o(59131);
                return;
            }
            this.ycg = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                this.ycg[i] = new String(strArr[i]);
            }
            AppMethodBeat.m2505o(59131);
        }
    }

    /* renamed from: com.tencent.mm.cd.i$1 */
    class C13701 implements C5015a {
        C13701() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(59130);
            if (C1369i.this.ybK.isOpen()) {
                C1369i.this.dvy();
                AppMethodBeat.m2505o(59130);
            } else {
                AppMethodBeat.m2505o(59130);
            }
            return false;
        }
    }

    public C1369i(C7480h c7480h, String str) {
        AppMethodBeat.m2504i(59132);
        this.ybK = c7480h;
        this.table = str;
        AppMethodBeat.m2505o(59132);
    }

    /* renamed from: a */
    private int m2923a(C1368a c1368a) {
        AppMethodBeat.m2504i(59133);
        if (c1368a == null) {
            C4990ab.m7421w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", this.table);
            AppMethodBeat.m2505o(59133);
            return -2;
        } else if (this.ybK == null || !this.ybK.isOpen()) {
            C4990ab.m7413e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", this.table);
            AppMethodBeat.m2505o(59133);
            return -3;
        } else {
            if (c1368a.xBj == 2) {
                this.ybK.insert(this.table, c1368a.xDc, c1368a.values);
            } else if (c1368a.xBj == 5) {
                this.ybK.delete(this.table, c1368a.ycf, c1368a.ycg);
            } else if (c1368a.xBj == 1) {
                this.ybK.mo10108hY(this.table, c1368a.sql);
            } else if (c1368a.xBj == 4) {
                this.ybK.replace(this.table, c1368a.xDc, c1368a.values);
            } else if (c1368a.xBj == 3) {
                this.ybK.update(this.table, c1368a.values, c1368a.ycf, c1368a.ycg);
            } else {
                AppMethodBeat.m2505o(59133);
                return -1;
            }
            AppMethodBeat.m2505o(59133);
            return 0;
        }
    }

    public final int dvy() {
        AppMethodBeat.m2504i(59134);
        C4990ab.m7411d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", this.table, Boolean.valueOf(this.ybK.inTransaction()), Integer.valueOf(this.queue.size()));
        if (this.queue.isEmpty()) {
            AppMethodBeat.m2505o(59134);
        } else {
            long j;
            if (this.ybK.inTransaction()) {
                j = 0;
            } else {
                j = this.ybK.mo15639iV(Thread.currentThread().getId());
            }
            while (!this.queue.isEmpty()) {
                m2923a((C1368a) this.queue.poll());
            }
            if (j > 0) {
                this.ybK.mo15640mB(j);
            }
            AppMethodBeat.m2505o(59134);
        }
        return 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final int mo4753b(C1368a c1368a) {
        AppMethodBeat.m2504i(59135);
        this.queue.add(c1368a);
        if (this.queue.size() >= 40) {
            dvy();
        }
        if (this.che.doT()) {
            this.che.mo16770ae(60000, 60000);
        }
        AppMethodBeat.m2505o(59135);
        return 0;
    }
}
