package com.tencent.p177mm.plugin.record.p492b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.record.p1016a.C21593b;
import com.tencent.p177mm.plugin.record.p1016a.C21594c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.record.b.h */
public abstract class C24816h<T extends C21594c> implements C21593b {
    private SparseArray<C21602a> pJA = new SparseArray();
    private LinkedList<T> pJB = new LinkedList();
    private long pJC = 0;
    private boolean pJx = false;
    final int pJy = 3;
    private final int pJz = 300000;

    /* renamed from: com.tencent.mm.plugin.record.b.h$a */
    final class C21602a {
        int ghB;
        long pJE;

        private C21602a() {
            AppMethodBeat.m2504i(135668);
            this.pJE = SystemClock.elapsedRealtime();
            this.ghB = C24816h.this.pJy;
            AppMethodBeat.m2505o(135668);
        }

        /* synthetic */ C21602a(C24816h c24816h, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.h$1 */
    class C248171 implements Runnable {
        C248171() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135666);
            C24816h.m38758a(C24816h.this);
            AppMethodBeat.m2505o(135666);
        }

        public final String toString() {
            AppMethodBeat.m2504i(135667);
            String str = super.toString() + "|tryDoJob";
            AppMethodBeat.m2505o(135667);
            return str;
        }
    }

    public abstract List<T> ceF();

    /* JADX WARNING: Removed duplicated region for block: B:39:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m38758a(C24816h c24816h) {
        if (!c24816h.pJx || System.currentTimeMillis() - c24816h.pJC >= 60000) {
            C21602a c21602a;
            C21594c c21594c;
            c24816h.pJC = System.currentTimeMillis();
            if (c24816h.pJB.isEmpty()) {
                for (C21594c c21594c2 : c24816h.ceF()) {
                    c21602a = (C21602a) c24816h.pJA.get(c21594c2.cez());
                    if (c21602a == null) {
                        c24816h.pJA.put(c21594c2.cez(), new C21602a(c24816h, (byte) 0));
                    } else if (c21602a.ghB >= 0 || SystemClock.elapsedRealtime() - c21602a.pJE >= ((long) c24816h.pJz)) {
                        if (c21602a.ghB < 0) {
                            c21602a.ghB = c24816h.pJy;
                        }
                    }
                    C4990ab.m7411d("MicroMsg.RecordMsgBaseService", "do add job from db, localId %d", Integer.valueOf(c21594c2.cez()));
                    if (!c24816h.pJB.contains(c21594c2)) {
                        c24816h.pJB.add(c21594c2);
                    }
                }
                C4990ab.m7417i("MicroMsg.RecordMsgBaseService", "jobs list size is 0, new jobs list size[%d]", Integer.valueOf(c24816h.pJB.size()));
            }
            if (c24816h.pJB.isEmpty()) {
                C4990ab.m7416i("MicroMsg.RecordMsgBaseService", "try to do job, but job list size is empty, return");
                c24816h.finish();
                return;
            }
            int i;
            c21594c2 = (C21594c) c24816h.pJB.removeFirst();
            c21602a = (C21602a) c24816h.pJA.get(c21594c2.cez());
            if (c21602a == null) {
                c21602a = new C21602a(c24816h, (byte) 0);
                c24816h.pJA.put(c21594c2.cez(), c21602a);
            }
            c21602a.ghB--;
            if (c21602a.ghB < 0) {
                if (((long) c24816h.pJz) > SystemClock.elapsedRealtime() - c21602a.pJE) {
                    i = 0;
                    if (i == 0) {
                        c24816h.mo37074a(c21594c2);
                        c24816h.pJx = true;
                        return;
                    }
                    c24816h.run();
                    return;
                }
                c21602a.ghB = c24816h.pJy - 1;
            }
            c21602a.pJE = SystemClock.elapsedRealtime();
            i = 1;
            if (i == 0) {
            }
        } else {
            C4990ab.m7416i("MicroMsg.RecordMsgBaseService", "is working, return");
        }
    }

    public final void run() {
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C248171());
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceG() {
        this.pJx = false;
        run();
    }

    public final void finish() {
        this.pJB.clear();
        this.pJA.clear();
        this.pJx = false;
    }
}
