package com.google.android.exoplayer2.p110h;

import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.h.j */
public final class C45037j implements C32053b {
    private int aMH;
    private final boolean bpR;
    private final int bpS;
    private final byte[] bpT;
    private final C0865a[] bpU;
    private int bpV;
    private int bpW;
    private C0865a[] bpX;

    public C45037j() {
        this((byte) 0);
    }

    private C45037j(byte b) {
        AppMethodBeat.m2504i(95806);
        C45039a.checkArgument(true);
        C45039a.checkArgument(true);
        this.bpR = true;
        this.bpS = 65536;
        this.bpW = 0;
        this.bpX = new C0865a[100];
        this.bpT = null;
        this.bpU = new C0865a[1];
        AppMethodBeat.m2505o(95806);
    }

    public final synchronized void reset() {
        AppMethodBeat.m2504i(95807);
        if (this.bpR) {
            mo72547eJ(0);
        }
        AppMethodBeat.m2505o(95807);
    }

    /* renamed from: eJ */
    public final synchronized void mo72547eJ(int i) {
        AppMethodBeat.m2504i(95808);
        Object obj = i < this.aMH ? 1 : null;
        this.aMH = i;
        if (obj != null) {
            trim();
        }
        AppMethodBeat.m2505o(95808);
    }

    /* renamed from: tj */
    public final synchronized C0865a mo52342tj() {
        C0865a c0865a;
        AppMethodBeat.m2504i(95809);
        this.bpV++;
        if (this.bpW > 0) {
            C0865a[] c0865aArr = this.bpX;
            int i = this.bpW - 1;
            this.bpW = i;
            c0865a = c0865aArr[i];
            this.bpX[this.bpW] = null;
        } else {
            c0865a = new C0865a(new byte[this.bpS]);
        }
        AppMethodBeat.m2505o(95809);
        return c0865a;
    }

    /* renamed from: a */
    public final synchronized void mo52340a(C0865a c0865a) {
        AppMethodBeat.m2504i(95810);
        this.bpU[0] = c0865a;
        mo52341a(this.bpU);
        AppMethodBeat.m2505o(95810);
    }

    /* renamed from: a */
    public final synchronized void mo52341a(C0865a[] c0865aArr) {
        AppMethodBeat.m2504i(95811);
        if (this.bpW + c0865aArr.length >= this.bpX.length) {
            this.bpX = (C0865a[]) Arrays.copyOf(this.bpX, Math.max(this.bpX.length * 2, this.bpW + c0865aArr.length));
        }
        for (C0865a c0865a : c0865aArr) {
            boolean z;
            if (c0865a.data == this.bpT || c0865a.data.length == this.bpS) {
                z = true;
            } else {
                z = false;
            }
            C45039a.checkArgument(z);
            C0865a[] c0865aArr2 = this.bpX;
            int i = this.bpW;
            this.bpW = i + 1;
            c0865aArr2[i] = c0865a;
        }
        this.bpV -= c0865aArr.length;
        notifyAll();
        AppMethodBeat.m2505o(95811);
    }

    public final synchronized void trim() {
        AppMethodBeat.m2504i(95812);
        int max = Math.max(0, C17675v.m27565bi(this.aMH, this.bpS) - this.bpV);
        if (max >= this.bpW) {
            AppMethodBeat.m2505o(95812);
        } else {
            if (this.bpT != null) {
                int i = this.bpW - 1;
                int i2 = 0;
                while (i2 <= i) {
                    C0865a c0865a = this.bpX[i2];
                    if (c0865a.data == this.bpT) {
                        i2++;
                    } else {
                        C0865a c0865a2 = this.bpX[i];
                        if (c0865a2.data != this.bpT) {
                            i--;
                        } else {
                            int i3 = i2 + 1;
                            this.bpX[i2] = c0865a2;
                            int i4 = i - 1;
                            this.bpX[i] = c0865a;
                            i = i4;
                            i2 = i3;
                        }
                    }
                }
                max = Math.max(max, i2);
                if (max >= this.bpW) {
                    AppMethodBeat.m2505o(95812);
                }
            }
            Arrays.fill(this.bpX, max, this.bpW, null);
            this.bpW = max;
            AppMethodBeat.m2505o(95812);
        }
    }

    /* renamed from: tp */
    public final synchronized int mo72549tp() {
        return this.bpV * this.bpS;
    }

    /* renamed from: tk */
    public final int mo52343tk() {
        return this.bpS;
    }
}
