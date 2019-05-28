package com.google.android.exoplayer2.source;

import android.support.p057v4.widget.C8415j;
import com.google.android.exoplayer2.C8692k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C32041m.C8663a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p110h.C0865a;
import com.google.android.exoplayer2.p110h.C32053b;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.source.C37282j.C37283a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.source.k */
public final class C25560k implements C32041m {
    private final C32065l aTj = new C32065l(32);
    private long bbO;
    private final C32053b bgF;
    private final int bhF;
    public final C37282j bhG = new C37282j();
    private final C37283a bhH = new C37283a();
    private C8717a bhI = new C8717a(0, this.bhF);
    private C8717a bhJ = this.bhI;
    private C8717a bhK = this.bhI;
    private Format bhL;
    private boolean bhM;
    private Format bhN;
    private long bhO;
    public boolean bhP;
    public C17687b bhQ;

    /* renamed from: com.google.android.exoplayer2.source.k$a */
    static final class C8717a {
        public final long aXw;
        public final long aZQ;
        public boolean bhR;
        public C0865a bhS;
        public C8717a bhT;

        public C8717a(long j, int i) {
            AppMethodBeat.m2504i(95528);
            this.aZQ = j;
            this.aXw = ((long) i) + j;
            AppMethodBeat.m2505o(95528);
        }

        /* renamed from: a */
        public final void mo19296a(C0865a c0865a, C8717a c8717a) {
            this.bhS = c0865a;
            this.bhT = c8717a;
            this.bhR = true;
        }

        /* renamed from: af */
        public final int mo19297af(long j) {
            return ((int) (j - this.aZQ)) + this.bhS.offset;
        }

        /* renamed from: sr */
        public final C8717a mo19298sr() {
            this.bhS = null;
            C8717a c8717a = this.bhT;
            this.bhT = null;
            return c8717a;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.k$b */
    public interface C17687b {
        /* renamed from: sa */
        void mo32390sa();
    }

    public C25560k(C32053b c32053b) {
        AppMethodBeat.m2504i(95529);
        this.bgF = c32053b;
        this.bhF = c32053b.mo52343tk();
        AppMethodBeat.m2505o(95529);
    }

    public final void reset(boolean z) {
        AppMethodBeat.m2504i(95530);
        this.bhG.reset(z);
        m40419a(this.bhI);
        this.bhI = new C8717a(0, this.bhF);
        this.bhJ = this.bhI;
        this.bhK = this.bhI;
        this.bbO = 0;
        this.bgF.trim();
        AppMethodBeat.m2505o(95530);
    }

    public final void rewind() {
        AppMethodBeat.m2504i(95531);
        this.bhG.rewind();
        this.bhJ = this.bhI;
        AppMethodBeat.m2505o(95531);
    }

    /* renamed from: i */
    public final void mo42838i(long j, boolean z) {
        AppMethodBeat.m2504i(95532);
        m40421ae(this.bhG.mo59533h(j, z));
        AppMethodBeat.m2505o(95532);
    }

    /* renamed from: sp */
    public final void mo42841sp() {
        AppMethodBeat.m2504i(95533);
        m40421ae(this.bhG.mo59543sn());
        AppMethodBeat.m2505o(95533);
    }

    /* renamed from: sq */
    public final void mo42842sq() {
        AppMethodBeat.m2504i(95534);
        m40421ae(this.bhG.mo59544so());
        AppMethodBeat.m2505o(95534);
    }

    /* renamed from: g */
    public final boolean mo42837g(long j, boolean z) {
        AppMethodBeat.m2504i(95535);
        boolean g = this.bhG.mo59532g(j, z);
        AppMethodBeat.m2505o(95535);
        return g;
    }

    /* renamed from: a */
    public final int mo42833a(C8692k c8692k, C32022e c32022e, boolean z, boolean z2, long j) {
        AppMethodBeat.m2504i(95536);
        switch (this.bhG.mo59528a(c8692k, c32022e, z, z2, this.bhL, this.bhH)) {
            case -5:
                this.bhL = c8692k.aOv;
                AppMethodBeat.m2505o(95536);
                return -5;
            case -4:
                if (!c32022e.mo42774qG()) {
                    if (c32022e.aSk < j) {
                        c32022e.mo42771dB(C8415j.INVALID_ID);
                    }
                    if (c32022e.mo52316qK()) {
                        m40418a(c32022e, this.bhH);
                    }
                    c32022e.mo52315dD(this.bhH.size);
                    m40416a(this.bhH.f15849xb, c32022e.aEY, this.bhH.size);
                }
                AppMethodBeat.m2505o(95536);
                return -4;
            case -3:
                AppMethodBeat.m2505o(95536);
                return -3;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(95536);
                throw illegalStateException;
        }
    }

    /* renamed from: a */
    private void m40418a(C32022e c32022e, C37283a c37283a) {
        long j;
        long j2;
        int i = 1;
        int i2 = 0;
        AppMethodBeat.m2504i(95537);
        long j3 = c37283a.f15849xb;
        this.aTj.reset(1);
        m40417a(j3, this.aTj.data, 1);
        j3++;
        byte b = this.aTj.data[0];
        int i3 = (b & 128) != 0 ? 1 : 0;
        int i4 = b & C31128d.MIC_SketchMark;
        if (c32022e.aSj.f1032iv == null) {
            c32022e.aSj.f1032iv = new byte[16];
        }
        m40417a(j3, c32022e.aSj.f1032iv, i4);
        j3 += (long) i4;
        if (i3 != 0) {
            this.aTj.reset(2);
            m40417a(j3, this.aTj.data, 2);
            j3 += 2;
            i = this.aTj.readUnsignedShort();
            j = j3;
        } else {
            j = j3;
        }
        int[] iArr = c32022e.aSj.numBytesOfClearData;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = c32022e.aSj.numBytesOfEncryptedData;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (i3 != 0) {
            i3 = i * 6;
            this.aTj.reset(i3);
            m40417a(j, this.aTj.data, i3);
            j += (long) i3;
            this.aTj.setPosition(0);
            while (i2 < i) {
                iArr[i2] = this.aTj.readUnsignedShort();
                iArr2[i2] = this.aTj.mo52389tI();
                i2++;
            }
            j2 = j;
        } else {
            iArr[0] = 0;
            iArr2[0] = c37283a.size - ((int) (j - c37283a.f15849xb));
            j2 = j;
        }
        C8663a c8663a = c37283a.aUO;
        c32022e.aSj.mo2543a(i, iArr, iArr2, c8663a.aTc, c32022e.aSj.f1032iv, c8663a.aTb, c8663a.aRX, c8663a.aRY);
        i3 = (int) (j2 - c37283a.f15849xb);
        c37283a.f15849xb += (long) i3;
        c37283a.size -= i3;
        AppMethodBeat.m2505o(95537);
    }

    /* renamed from: a */
    private void m40416a(long j, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(95538);
        m40420ad(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.bhJ.aXw - j));
            byteBuffer.put(this.bhJ.bhS.data, this.bhJ.mo19297af(j), min);
            i -= min;
            j += (long) min;
            if (j == this.bhJ.aXw) {
                this.bhJ = this.bhJ.bhT;
            }
        }
        AppMethodBeat.m2505o(95538);
    }

    /* renamed from: a */
    private void m40417a(long j, byte[] bArr, int i) {
        AppMethodBeat.m2504i(95539);
        m40420ad(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.bhJ.aXw - j));
            System.arraycopy(this.bhJ.bhS.data, this.bhJ.mo19297af(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == this.bhJ.aXw) {
                this.bhJ = this.bhJ.bhT;
            }
        }
        AppMethodBeat.m2505o(95539);
    }

    /* renamed from: ad */
    private void m40420ad(long j) {
        while (j >= this.bhJ.aXw) {
            this.bhJ = this.bhJ.bhT;
        }
    }

    /* renamed from: ae */
    private void m40421ae(long j) {
        AppMethodBeat.m2504i(95540);
        if (j == -1) {
            AppMethodBeat.m2505o(95540);
            return;
        }
        while (j >= this.bhI.aXw) {
            this.bgF.mo52340a(this.bhI.bhS);
            this.bhI = this.bhI.mo19298sr();
        }
        if (this.bhJ.aZQ < this.bhI.aZQ) {
            this.bhJ = this.bhI;
        }
        AppMethodBeat.m2505o(95540);
    }

    /* renamed from: f */
    public final void mo42836f(Format format) {
        AppMethodBeat.m2504i(95541);
        long j = this.bhO;
        Format E = format == null ? null : (j == 0 || format.aOr == Long.MAX_VALUE) ? format : format.mo19111E(j + format.aOr);
        boolean i = this.bhG.mo59534i(E);
        this.bhN = format;
        this.bhM = false;
        if (this.bhQ != null && i) {
            this.bhQ.mo32390sa();
        }
        AppMethodBeat.m2505o(95541);
    }

    /* renamed from: a */
    public final int mo42832a(C45026f c45026f, int i, boolean z) {
        AppMethodBeat.m2504i(95542);
        int read = c45026f.read(this.bhK.bhS.data, this.bhK.mo19297af(this.bbO), m40422eq(i));
        if (read != -1) {
            m40423er(read);
            AppMethodBeat.m2505o(95542);
            return read;
        } else if (z) {
            AppMethodBeat.m2505o(95542);
            return -1;
        } else {
            EOFException eOFException = new EOFException();
            AppMethodBeat.m2505o(95542);
            throw eOFException;
        }
    }

    /* renamed from: a */
    public final void mo42835a(C32065l c32065l, int i) {
        AppMethodBeat.m2504i(95543);
        while (i > 0) {
            int eq = m40422eq(i);
            c32065l.readBytes(this.bhK.bhS.data, this.bhK.mo19297af(this.bbO), eq);
            i -= eq;
            m40423er(eq);
        }
        AppMethodBeat.m2505o(95543);
    }

    /* renamed from: a */
    public final void mo42834a(long j, int i, int i2, int i3, C8663a c8663a) {
        AppMethodBeat.m2504i(95544);
        if (this.bhM) {
            mo42836f(this.bhN);
        }
        if (this.bhP) {
            if ((i & 1) == 0 || !this.bhG.mo59530ac(j)) {
                AppMethodBeat.m2505o(95544);
                return;
            }
            this.bhP = false;
        }
        this.bhG.mo59529a(j + this.bhO, i, (this.bbO - ((long) i2)) - ((long) i3), i2, c8663a);
        AppMethodBeat.m2505o(95544);
    }

    /* renamed from: a */
    private void m40419a(C8717a c8717a) {
        int i = 0;
        AppMethodBeat.m2504i(95545);
        if (c8717a.bhR) {
            int i2;
            if (this.bhK.bhR) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            C0865a[] c0865aArr = new C0865a[(i2 + (((int) (this.bhK.aZQ - c8717a.aZQ)) / this.bhF))];
            while (i < c0865aArr.length) {
                c0865aArr[i] = c8717a.bhS;
                c8717a = c8717a.mo19298sr();
                i++;
            }
            this.bgF.mo52341a(c0865aArr);
            AppMethodBeat.m2505o(95545);
            return;
        }
        AppMethodBeat.m2505o(95545);
    }

    /* renamed from: eq */
    private int m40422eq(int i) {
        AppMethodBeat.m2504i(95546);
        if (!this.bhK.bhR) {
            this.bhK.mo19296a(this.bgF.mo52342tj(), new C8717a(this.bhK.aXw, this.bhF));
        }
        int min = Math.min(i, (int) (this.bhK.aXw - this.bbO));
        AppMethodBeat.m2505o(95546);
        return min;
    }

    /* renamed from: er */
    private void m40423er(int i) {
        this.bbO += (long) i;
        if (this.bbO == this.bhK.aXw) {
            this.bhK = this.bhK.bhT;
        }
    }
}
