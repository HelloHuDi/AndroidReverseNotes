package com.google.android.exoplayer2.source;

import android.support.v4.widget.j;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.io.EOFException;
import java.nio.ByteBuffer;

public final class k implements m {
    private final l aTj = new l(32);
    private long bbO;
    private final com.google.android.exoplayer2.h.b bgF;
    private final int bhF;
    public final j bhG = new j();
    private final com.google.android.exoplayer2.source.j.a bhH = new com.google.android.exoplayer2.source.j.a();
    private a bhI = new a(0, this.bhF);
    private a bhJ = this.bhI;
    private a bhK = this.bhI;
    private Format bhL;
    private boolean bhM;
    private Format bhN;
    private long bhO;
    public boolean bhP;
    public b bhQ;

    static final class a {
        public final long aXw;
        public final long aZQ;
        public boolean bhR;
        public com.google.android.exoplayer2.h.a bhS;
        public a bhT;

        public a(long j, int i) {
            AppMethodBeat.i(95528);
            this.aZQ = j;
            this.aXw = ((long) i) + j;
            AppMethodBeat.o(95528);
        }

        public final void a(com.google.android.exoplayer2.h.a aVar, a aVar2) {
            this.bhS = aVar;
            this.bhT = aVar2;
            this.bhR = true;
        }

        public final int af(long j) {
            return ((int) (j - this.aZQ)) + this.bhS.offset;
        }

        public final a sr() {
            this.bhS = null;
            a aVar = this.bhT;
            this.bhT = null;
            return aVar;
        }
    }

    public interface b {
        void sa();
    }

    public k(com.google.android.exoplayer2.h.b bVar) {
        AppMethodBeat.i(95529);
        this.bgF = bVar;
        this.bhF = bVar.tk();
        AppMethodBeat.o(95529);
    }

    public final void reset(boolean z) {
        AppMethodBeat.i(95530);
        this.bhG.reset(z);
        a(this.bhI);
        this.bhI = new a(0, this.bhF);
        this.bhJ = this.bhI;
        this.bhK = this.bhI;
        this.bbO = 0;
        this.bgF.trim();
        AppMethodBeat.o(95530);
    }

    public final void rewind() {
        AppMethodBeat.i(95531);
        this.bhG.rewind();
        this.bhJ = this.bhI;
        AppMethodBeat.o(95531);
    }

    public final void i(long j, boolean z) {
        AppMethodBeat.i(95532);
        ae(this.bhG.h(j, z));
        AppMethodBeat.o(95532);
    }

    public final void sp() {
        AppMethodBeat.i(95533);
        ae(this.bhG.sn());
        AppMethodBeat.o(95533);
    }

    public final void sq() {
        AppMethodBeat.i(95534);
        ae(this.bhG.so());
        AppMethodBeat.o(95534);
    }

    public final boolean g(long j, boolean z) {
        AppMethodBeat.i(95535);
        boolean g = this.bhG.g(j, z);
        AppMethodBeat.o(95535);
        return g;
    }

    public final int a(com.google.android.exoplayer2.k kVar, e eVar, boolean z, boolean z2, long j) {
        AppMethodBeat.i(95536);
        switch (this.bhG.a(kVar, eVar, z, z2, this.bhL, this.bhH)) {
            case -5:
                this.bhL = kVar.aOv;
                AppMethodBeat.o(95536);
                return -5;
            case -4:
                if (!eVar.qG()) {
                    if (eVar.aSk < j) {
                        eVar.dB(j.INVALID_ID);
                    }
                    if (eVar.qK()) {
                        a(eVar, this.bhH);
                    }
                    eVar.dD(this.bhH.size);
                    a(this.bhH.xb, eVar.aEY, this.bhH.size);
                }
                AppMethodBeat.o(95536);
                return -4;
            case -3:
                AppMethodBeat.o(95536);
                return -3;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(95536);
                throw illegalStateException;
        }
    }

    private void a(e eVar, com.google.android.exoplayer2.source.j.a aVar) {
        long j;
        long j2;
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(95537);
        long j3 = aVar.xb;
        this.aTj.reset(1);
        a(j3, this.aTj.data, 1);
        j3++;
        byte b = this.aTj.data[0];
        int i3 = (b & 128) != 0 ? 1 : 0;
        int i4 = b & d.MIC_SketchMark;
        if (eVar.aSj.iv == null) {
            eVar.aSj.iv = new byte[16];
        }
        a(j3, eVar.aSj.iv, i4);
        j3 += (long) i4;
        if (i3 != 0) {
            this.aTj.reset(2);
            a(j3, this.aTj.data, 2);
            j3 += 2;
            i = this.aTj.readUnsignedShort();
            j = j3;
        } else {
            j = j3;
        }
        int[] iArr = eVar.aSj.numBytesOfClearData;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = eVar.aSj.numBytesOfEncryptedData;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (i3 != 0) {
            i3 = i * 6;
            this.aTj.reset(i3);
            a(j, this.aTj.data, i3);
            j += (long) i3;
            this.aTj.setPosition(0);
            while (i2 < i) {
                iArr[i2] = this.aTj.readUnsignedShort();
                iArr2[i2] = this.aTj.tI();
                i2++;
            }
            j2 = j;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j - aVar.xb));
            j2 = j;
        }
        com.google.android.exoplayer2.c.m.a aVar2 = aVar.aUO;
        eVar.aSj.a(i, iArr, iArr2, aVar2.aTc, eVar.aSj.iv, aVar2.aTb, aVar2.aRX, aVar2.aRY);
        i3 = (int) (j2 - aVar.xb);
        aVar.xb += (long) i3;
        aVar.size -= i3;
        AppMethodBeat.o(95537);
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(95538);
        ad(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.bhJ.aXw - j));
            byteBuffer.put(this.bhJ.bhS.data, this.bhJ.af(j), min);
            i -= min;
            j += (long) min;
            if (j == this.bhJ.aXw) {
                this.bhJ = this.bhJ.bhT;
            }
        }
        AppMethodBeat.o(95538);
    }

    private void a(long j, byte[] bArr, int i) {
        AppMethodBeat.i(95539);
        ad(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.bhJ.aXw - j));
            System.arraycopy(this.bhJ.bhS.data, this.bhJ.af(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == this.bhJ.aXw) {
                this.bhJ = this.bhJ.bhT;
            }
        }
        AppMethodBeat.o(95539);
    }

    private void ad(long j) {
        while (j >= this.bhJ.aXw) {
            this.bhJ = this.bhJ.bhT;
        }
    }

    private void ae(long j) {
        AppMethodBeat.i(95540);
        if (j == -1) {
            AppMethodBeat.o(95540);
            return;
        }
        while (j >= this.bhI.aXw) {
            this.bgF.a(this.bhI.bhS);
            this.bhI = this.bhI.sr();
        }
        if (this.bhJ.aZQ < this.bhI.aZQ) {
            this.bhJ = this.bhI;
        }
        AppMethodBeat.o(95540);
    }

    public final void f(Format format) {
        AppMethodBeat.i(95541);
        long j = this.bhO;
        Format E = format == null ? null : (j == 0 || format.aOr == Long.MAX_VALUE) ? format : format.E(j + format.aOr);
        boolean i = this.bhG.i(E);
        this.bhN = format;
        this.bhM = false;
        if (this.bhQ != null && i) {
            this.bhQ.sa();
        }
        AppMethodBeat.o(95541);
    }

    public final int a(f fVar, int i, boolean z) {
        AppMethodBeat.i(95542);
        int read = fVar.read(this.bhK.bhS.data, this.bhK.af(this.bbO), eq(i));
        if (read != -1) {
            er(read);
            AppMethodBeat.o(95542);
            return read;
        } else if (z) {
            AppMethodBeat.o(95542);
            return -1;
        } else {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(95542);
            throw eOFException;
        }
    }

    public final void a(l lVar, int i) {
        AppMethodBeat.i(95543);
        while (i > 0) {
            int eq = eq(i);
            lVar.readBytes(this.bhK.bhS.data, this.bhK.af(this.bbO), eq);
            i -= eq;
            er(eq);
        }
        AppMethodBeat.o(95543);
    }

    public final void a(long j, int i, int i2, int i3, com.google.android.exoplayer2.c.m.a aVar) {
        AppMethodBeat.i(95544);
        if (this.bhM) {
            f(this.bhN);
        }
        if (this.bhP) {
            if ((i & 1) == 0 || !this.bhG.ac(j)) {
                AppMethodBeat.o(95544);
                return;
            }
            this.bhP = false;
        }
        this.bhG.a(j + this.bhO, i, (this.bbO - ((long) i2)) - ((long) i3), i2, aVar);
        AppMethodBeat.o(95544);
    }

    private void a(a aVar) {
        int i = 0;
        AppMethodBeat.i(95545);
        if (aVar.bhR) {
            int i2;
            if (this.bhK.bhR) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            com.google.android.exoplayer2.h.a[] aVarArr = new com.google.android.exoplayer2.h.a[(i2 + (((int) (this.bhK.aZQ - aVar.aZQ)) / this.bhF))];
            while (i < aVarArr.length) {
                aVarArr[i] = aVar.bhS;
                aVar = aVar.sr();
                i++;
            }
            this.bgF.a(aVarArr);
            AppMethodBeat.o(95545);
            return;
        }
        AppMethodBeat.o(95545);
    }

    private int eq(int i) {
        AppMethodBeat.i(95546);
        if (!this.bhK.bhR) {
            this.bhK.a(this.bgF.tj(), new a(this.bhK.aXw, this.bhF));
        }
        int min = Math.min(i, (int) (this.bhK.aXw - this.bbO));
        AppMethodBeat.o(95546);
        return min;
    }

    private void er(int i) {
        this.bbO += (long) i;
        if (this.bbO == this.bhK.aXw) {
            this.bhK = this.bhK.bhT;
        }
    }
}
