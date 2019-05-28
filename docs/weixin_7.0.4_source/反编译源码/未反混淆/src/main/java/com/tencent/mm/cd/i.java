package com.tencent.mm.cd;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i {
    private ap che = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(59130);
            if (i.this.ybK.isOpen()) {
                i.this.dvy();
                AppMethodBeat.o(59130);
            } else {
                AppMethodBeat.o(59130);
            }
            return false;
        }
    }, false);
    private BlockingQueue<a> queue = new LinkedBlockingQueue();
    private String table = null;
    h ybK;

    public static class a {
        public String sql;
        public ContentValues values;
        public int xBj;
        public String xDc;
        public String ycf;
        public String[] ycg;

        public final void T(String[] strArr) {
            AppMethodBeat.i(59131);
            if (strArr == null || strArr.length <= 0) {
                AppMethodBeat.o(59131);
                return;
            }
            this.ycg = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                this.ycg[i] = new String(strArr[i]);
            }
            AppMethodBeat.o(59131);
        }
    }

    public i(h hVar, String str) {
        AppMethodBeat.i(59132);
        this.ybK = hVar;
        this.table = str;
        AppMethodBeat.o(59132);
    }

    private int a(a aVar) {
        AppMethodBeat.i(59133);
        if (aVar == null) {
            ab.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", this.table);
            AppMethodBeat.o(59133);
            return -2;
        } else if (this.ybK == null || !this.ybK.isOpen()) {
            ab.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", this.table);
            AppMethodBeat.o(59133);
            return -3;
        } else {
            if (aVar.xBj == 2) {
                this.ybK.insert(this.table, aVar.xDc, aVar.values);
            } else if (aVar.xBj == 5) {
                this.ybK.delete(this.table, aVar.ycf, aVar.ycg);
            } else if (aVar.xBj == 1) {
                this.ybK.hY(this.table, aVar.sql);
            } else if (aVar.xBj == 4) {
                this.ybK.replace(this.table, aVar.xDc, aVar.values);
            } else if (aVar.xBj == 3) {
                this.ybK.update(this.table, aVar.values, aVar.ycf, aVar.ycg);
            } else {
                AppMethodBeat.o(59133);
                return -1;
            }
            AppMethodBeat.o(59133);
            return 0;
        }
    }

    public final int dvy() {
        AppMethodBeat.i(59134);
        ab.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", this.table, Boolean.valueOf(this.ybK.inTransaction()), Integer.valueOf(this.queue.size()));
        if (this.queue.isEmpty()) {
            AppMethodBeat.o(59134);
        } else {
            long j;
            if (this.ybK.inTransaction()) {
                j = 0;
            } else {
                j = this.ybK.iV(Thread.currentThread().getId());
            }
            while (!this.queue.isEmpty()) {
                a((a) this.queue.poll());
            }
            if (j > 0) {
                this.ybK.mB(j);
            }
            AppMethodBeat.o(59134);
        }
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final int b(a aVar) {
        AppMethodBeat.i(59135);
        this.queue.add(aVar);
        if (this.queue.size() >= 40) {
            dvy();
        }
        if (this.che.doT()) {
            this.che.ae(60000, 60000);
        }
        AppMethodBeat.o(59135);
        return 0;
    }
}
