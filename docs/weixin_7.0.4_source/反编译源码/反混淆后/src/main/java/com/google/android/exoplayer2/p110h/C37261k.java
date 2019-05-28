package com.google.android.exoplayer2.p110h;

import android.os.Handler;
import com.google.android.exoplayer2.p110h.C32056d.C8679a;
import com.google.android.exoplayer2.p111i.C37264b;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.p111i.C8687p;
import com.google.android.exoplayer2.p111i.C8687p.C8688a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.h.k */
public final class C37261k implements C32056d, C41615u<Object> {
    private final C8679a bpY;
    private final C8687p bpZ;
    private final C37264b bqa;
    private int bqb;
    private long bqc;
    private long bqd;
    private long bqe;
    private long bqf;
    private long bqg;
    private final Handler eventHandler;

    public C37261k() {
        this(null, null);
    }

    public C37261k(Handler handler, C8679a c8679a) {
        this(handler, c8679a, (byte) 0);
    }

    private C37261k(Handler handler, C8679a c8679a, byte b) {
        this(handler, c8679a, C37264b.bqX);
    }

    private C37261k(Handler handler, C8679a c8679a, C37264b c37264b) {
        AppMethodBeat.m2504i(95813);
        this.eventHandler = handler;
        this.bpY = c8679a;
        this.bpZ = new C8687p();
        this.bqa = c37264b;
        this.bqg = -1;
        AppMethodBeat.m2505o(95813);
    }

    /* renamed from: tl */
    public final synchronized long mo52345tl() {
        return this.bqg;
    }

    /* renamed from: tq */
    public final synchronized void mo59502tq() {
        AppMethodBeat.m2504i(95814);
        if (this.bqb == 0) {
            this.bqc = this.bqa.elapsedRealtime();
        }
        this.bqb++;
        AppMethodBeat.m2505o(95814);
    }

    /* renamed from: eK */
    public final synchronized void mo59501eK(int i) {
        this.bqd += (long) i;
    }

    /* JADX WARNING: Missing block: B:62:0x0143, code skipped:
            if (r5.brC.isEmpty() == false) goto L_0x0148;
     */
    /* JADX WARNING: Missing block: B:63:0x0145, code skipped:
            r0 = Float.NaN;
     */
    /* JADX WARNING: Missing block: B:64:0x0148, code skipped:
            r0 = ((com.google.android.exoplayer2.p111i.C8687p.C8688a) r5.brC.get(r5.brC.size() - 1)).value;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: tr */
    public final synchronized void mo59503tr() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(95815);
            C45039a.checkState(this.bqb > 0);
            long elapsedRealtime = this.bqa.elapsedRealtime();
            final int i2 = (int) (elapsedRealtime - this.bqc);
            this.bqe += (long) i2;
            this.bqf += this.bqd;
            if (i2 > 0) {
                int i3;
                C8688a c8688a;
                int i4;
                float f = (float) ((this.bqd * 8000) / ((long) i2));
                C8687p c8687p = this.bpZ;
                int sqrt = (int) Math.sqrt((double) this.bqd);
                if (c8687p.brE != 1) {
                    Collections.sort(c8687p.brC, C8687p.brz);
                    c8687p.brE = 1;
                }
                if (c8687p.brH > 0) {
                    C8688a[] c8688aArr = c8687p.brD;
                    i3 = c8687p.brH - 1;
                    c8687p.brH = i3;
                    c8688a = c8688aArr[i3];
                } else {
                    c8688a = new C8688a();
                }
                i3 = c8687p.brF;
                c8687p.brF = i3 + 1;
                c8688a.index = i3;
                c8688a.weight = sqrt;
                c8688a.value = f;
                c8687p.brC.add(c8688a);
                c8687p.brG += sqrt;
                while (c8687p.brG > c8687p.brB) {
                    i3 = c8687p.brG - c8687p.brB;
                    c8688a = (C8688a) c8687p.brC.get(0);
                    if (c8688a.weight <= i3) {
                        c8687p.brG -= c8688a.weight;
                        c8687p.brC.remove(0);
                        if (c8687p.brH < 5) {
                            C8688a[] c8688aArr2 = c8687p.brD;
                            i4 = c8687p.brH;
                            c8687p.brH = i4 + 1;
                            c8688aArr2[i4] = c8688a;
                        }
                    } else {
                        c8688a.weight -= i3;
                        c8687p.brG -= i3;
                    }
                }
                if (this.bqe >= FaceGestureDetGLThread.BRIGHTNESS_DURATION || this.bqf >= C1625i.ACTION_MINI_PROGRAM_LAUNCH) {
                    float f2;
                    c8687p = this.bpZ;
                    if (c8687p.brE != 0) {
                        Collections.sort(c8687p.brC, C8687p.brA);
                        c8687p.brE = 0;
                    }
                    float f3 = 0.5f * ((float) c8687p.brG);
                    i3 = 0;
                    while (true) {
                        i4 = i;
                        if (i3 >= c8687p.brC.size()) {
                            break;
                        }
                        c8688a = (C8688a) c8687p.brC.get(i3);
                        i = c8688a.weight + i4;
                        if (((float) i) >= f3) {
                            f2 = c8688a.value;
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
            AppMethodBeat.m2505o(95815);
        }
    }
}
