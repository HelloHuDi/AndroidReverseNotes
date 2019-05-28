package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public abstract class h<T extends c> implements b {
    private SparseArray<a> pJA = new SparseArray();
    private LinkedList<T> pJB = new LinkedList();
    private long pJC = 0;
    private boolean pJx = false;
    final int pJy = 3;
    private final int pJz = 300000;

    final class a {
        int ghB;
        long pJE;

        private a() {
            AppMethodBeat.i(135668);
            this.pJE = SystemClock.elapsedRealtime();
            this.ghB = h.this.pJy;
            AppMethodBeat.o(135668);
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }
    }

    public abstract List<T> ceF();

    /* JADX WARNING: Removed duplicated region for block: B:39:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(h hVar) {
        if (!hVar.pJx || System.currentTimeMillis() - hVar.pJC >= 60000) {
            a aVar;
            c cVar;
            hVar.pJC = System.currentTimeMillis();
            if (hVar.pJB.isEmpty()) {
                for (c cVar2 : hVar.ceF()) {
                    aVar = (a) hVar.pJA.get(cVar2.cez());
                    if (aVar == null) {
                        hVar.pJA.put(cVar2.cez(), new a(hVar, (byte) 0));
                    } else if (aVar.ghB >= 0 || SystemClock.elapsedRealtime() - aVar.pJE >= ((long) hVar.pJz)) {
                        if (aVar.ghB < 0) {
                            aVar.ghB = hVar.pJy;
                        }
                    }
                    ab.d("MicroMsg.RecordMsgBaseService", "do add job from db, localId %d", Integer.valueOf(cVar2.cez()));
                    if (!hVar.pJB.contains(cVar2)) {
                        hVar.pJB.add(cVar2);
                    }
                }
                ab.i("MicroMsg.RecordMsgBaseService", "jobs list size is 0, new jobs list size[%d]", Integer.valueOf(hVar.pJB.size()));
            }
            if (hVar.pJB.isEmpty()) {
                ab.i("MicroMsg.RecordMsgBaseService", "try to do job, but job list size is empty, return");
                hVar.finish();
                return;
            }
            int i;
            cVar2 = (c) hVar.pJB.removeFirst();
            aVar = (a) hVar.pJA.get(cVar2.cez());
            if (aVar == null) {
                aVar = new a(hVar, (byte) 0);
                hVar.pJA.put(cVar2.cez(), aVar);
            }
            aVar.ghB--;
            if (aVar.ghB < 0) {
                if (((long) hVar.pJz) > SystemClock.elapsedRealtime() - aVar.pJE) {
                    i = 0;
                    if (i == 0) {
                        hVar.a(cVar2);
                        hVar.pJx = true;
                        return;
                    }
                    hVar.run();
                    return;
                }
                aVar.ghB = hVar.pJy - 1;
            }
            aVar.pJE = SystemClock.elapsedRealtime();
            i = 1;
            if (i == 0) {
            }
        } else {
            ab.i("MicroMsg.RecordMsgBaseService", "is working, return");
        }
    }

    public final void run() {
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135666);
                h.a(h.this);
                AppMethodBeat.o(135666);
            }

            public final String toString() {
                AppMethodBeat.i(135667);
                String str = super.toString() + "|tryDoJob";
                AppMethodBeat.o(135667);
                return str;
            }
        });
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
