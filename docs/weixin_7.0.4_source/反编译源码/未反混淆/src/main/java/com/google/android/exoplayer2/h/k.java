package com.google.android.exoplayer2.h;

import android.os.Handler;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Collections;

public final class k implements d, u<Object> {
    private final a bpY;
    private final p bpZ;
    private final b bqa;
    private int bqb;
    private long bqc;
    private long bqd;
    private long bqe;
    private long bqf;
    private long bqg;
    private final Handler eventHandler;

    public k() {
        this(null, null);
    }

    public k(Handler handler, a aVar) {
        this(handler, aVar, (byte) 0);
    }

    private k(Handler handler, a aVar, byte b) {
        this(handler, aVar, b.bqX);
    }

    private k(Handler handler, a aVar, b bVar) {
        AppMethodBeat.i(95813);
        this.eventHandler = handler;
        this.bpY = aVar;
        this.bpZ = new p();
        this.bqa = bVar;
        this.bqg = -1;
        AppMethodBeat.o(95813);
    }

    public final synchronized long tl() {
        return this.bqg;
    }

    public final synchronized void tq() {
        AppMethodBeat.i(95814);
        if (this.bqb == 0) {
            this.bqc = this.bqa.elapsedRealtime();
        }
        this.bqb++;
        AppMethodBeat.o(95814);
    }

    public final synchronized void eK(int i) {
        this.bqd += (long) i;
    }

    /* JADX WARNING: Missing block: B:62:0x0143, code skipped:
            if (r5.brC.isEmpty() == false) goto L_0x0148;
     */
    /* JADX WARNING: Missing block: B:63:0x0145, code skipped:
            r0 = Float.NaN;
     */
    /* JADX WARNING: Missing block: B:64:0x0148, code skipped:
            r0 = ((com.google.android.exoplayer2.i.p.a) r5.brC.get(r5.brC.size() - 1)).value;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void tr() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(95815);
            com.google.android.exoplayer2.i.a.checkState(this.bqb > 0);
            long elapsedRealtime = this.bqa.elapsedRealtime();
            final int i2 = (int) (elapsedRealtime - this.bqc);
            this.bqe += (long) i2;
            this.bqf += this.bqd;
            if (i2 > 0) {
                int i3;
                p.a aVar;
                int i4;
                float f = (float) ((this.bqd * 8000) / ((long) i2));
                p pVar = this.bpZ;
                int sqrt = (int) Math.sqrt((double) this.bqd);
                if (pVar.brE != 1) {
                    Collections.sort(pVar.brC, p.brz);
                    pVar.brE = 1;
                }
                if (pVar.brH > 0) {
                    p.a[] aVarArr = pVar.brD;
                    i3 = pVar.brH - 1;
                    pVar.brH = i3;
                    aVar = aVarArr[i3];
                } else {
                    aVar = new p.a();
                }
                i3 = pVar.brF;
                pVar.brF = i3 + 1;
                aVar.index = i3;
                aVar.weight = sqrt;
                aVar.value = f;
                pVar.brC.add(aVar);
                pVar.brG += sqrt;
                while (pVar.brG > pVar.brB) {
                    i3 = pVar.brG - pVar.brB;
                    aVar = (p.a) pVar.brC.get(0);
                    if (aVar.weight <= i3) {
                        pVar.brG -= aVar.weight;
                        pVar.brC.remove(0);
                        if (pVar.brH < 5) {
                            p.a[] aVarArr2 = pVar.brD;
                            i4 = pVar.brH;
                            pVar.brH = i4 + 1;
                            aVarArr2[i4] = aVar;
                        }
                    } else {
                        aVar.weight -= i3;
                        pVar.brG -= i3;
                    }
                }
                if (this.bqe >= FaceGestureDetGLThread.BRIGHTNESS_DURATION || this.bqf >= i.ACTION_MINI_PROGRAM_LAUNCH) {
                    float f2;
                    pVar = this.bpZ;
                    if (pVar.brE != 0) {
                        Collections.sort(pVar.brC, p.brA);
                        pVar.brE = 0;
                    }
                    float f3 = 0.5f * ((float) pVar.brG);
                    i3 = 0;
                    while (true) {
                        i4 = i;
                        if (i3 >= pVar.brC.size()) {
                            break;
                        }
                        aVar = (p.a) pVar.brC.get(i3);
                        i = aVar.weight + i4;
                        if (((float) i) >= f3) {
                            f2 = aVar.value;
                            break;
                        }
                        i3++;
                    }
                    this.bqg = Float.isNaN(f2) ? -1 : (long) f2;
                }
            }
            final long j = this.bqd;
            final long j2 = this.bqg;
            if (!(this.eventHandler == null || this.bpY == null)) {
                this.eventHandler.post(new Runnable() {
                    public final void run() {
                    }
                });
            }
            int i5 = this.bqb - 1;
            this.bqb = i5;
            if (i5 > 0) {
                this.bqc = elapsedRealtime;
            }
            this.bqd = 0;
            AppMethodBeat.o(95815);
        }
    }
}
