package com.tencent.p177mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.plugin.voip.model.j */
final class C29499j {
    private InputStream aEZ;
    protected C43733f sOE;
    int sOF;
    private int sOG;
    private int sOH;
    private final OutputStream sOI;
    private int[] sOJ;
    int sOK;

    public C29499j(InputStream inputStream) {
        AppMethodBeat.m2504i(4369);
        this.sOE = new C43733f();
        this.sOJ = new int[8];
        this.aEZ = inputStream;
        this.sOI = null;
        this.sOG = inputStream.read();
        this.sOH = inputStream.read();
        AppMethodBeat.m2505o(4369);
    }

    public C29499j(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.m2504i(4370);
        this.sOE = new C43733f();
        this.sOJ = new int[8];
        this.aEZ = inputStream;
        this.sOI = outputStream;
        this.sOG = inputStream.read();
        this.sOH = inputStream.read();
        AppMethodBeat.m2505o(4370);
    }

    /* renamed from: ml */
    public final boolean mo47772ml(boolean z) {
        AppMethodBeat.m2504i(4371);
        if (m46857mm(z) == 1) {
            AppMethodBeat.m2505o(4371);
            return true;
        }
        AppMethodBeat.m2505o(4371);
        return false;
    }

    /* renamed from: mm */
    private int m46857mm(boolean z) {
        int i = -1;
        AppMethodBeat.m2504i(4372);
        if (this.sOF == 8) {
            advance();
            if (this.sOG == -1) {
                AppMethodBeat.m2505o(4372);
                return i;
            }
        }
        i = (this.sOG >> (7 - this.sOF)) & 1;
        this.sOF++;
        if (z && this.sOI != null) {
            mo47765Ga(i);
        }
        AppMethodBeat.m2505o(4372);
        return i;
    }

    /* renamed from: FW */
    private long m46855FW(int i) {
        AppMethodBeat.m2504i(4373);
        if (i > 64) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
            AppMethodBeat.m2505o(4373);
            throw illegalArgumentException;
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | ((long) m46857mm(true));
        }
        AppMethodBeat.m2505o(4373);
        return j;
    }

    /* renamed from: FX */
    public final void mo47761FX(int i) {
        AppMethodBeat.m2504i(4374);
        if (i > 64) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
            AppMethodBeat.m2505o(4374);
            throw illegalArgumentException;
        }
        for (int i2 = 0; i2 < i; i2++) {
            m46857mm(true);
        }
        AppMethodBeat.m2505o(4374);
    }

    private void advance() {
        AppMethodBeat.m2504i(4375);
        this.sOG = this.sOH;
        this.sOH = this.aEZ.read();
        this.sOF = 0;
        AppMethodBeat.m2505o(4375);
    }

    public final long cIx() {
        AppMethodBeat.m2504i(4376);
        long FW = m46855FW(8);
        String.valueOf(FW);
        AppMethodBeat.m2505o(4376);
        return FW;
    }

    /* renamed from: FY */
    public final void mo47762FY(int i) {
        AppMethodBeat.m2504i(4377);
        mo47761FX(i);
        AppMethodBeat.m2505o(4377);
    }

    private int cIy() {
        int i = 0;
        AppMethodBeat.m2504i(4378);
        int i2 = 0;
        while (m46857mm(true) == 0) {
            i2++;
        }
        if (i2 > 0) {
            i = (int) (((long) ((1 << i2) - 1)) + m46855FW(i2));
        }
        AppMethodBeat.m2505o(4378);
        return i;
    }

    /* Access modifiers changed, original: final */
    public final void cIz() {
        AppMethodBeat.m2504i(4379);
        int i = 0;
        while (m46857mm(true) == 0) {
            i++;
        }
        if (i > 0) {
            mo47761FX(i);
        }
        AppMethodBeat.m2505o(4379);
    }

    public final int cIA() {
        AppMethodBeat.m2504i(4380);
        int cIy = cIy();
        String.valueOf(cIy);
        AppMethodBeat.m2505o(4380);
        return cIy;
    }

    public final void cIB() {
        AppMethodBeat.m2504i(4381);
        cIz();
        AppMethodBeat.m2505o(4381);
    }

    private int cIC() {
        AppMethodBeat.m2504i(4382);
        int cIy = cIy();
        cIy = ((cIy & 1) + (cIy >> 1)) * (((cIy & 1) << 1) - 1);
        String.valueOf(cIy);
        AppMethodBeat.m2505o(4382);
        return cIy;
    }

    /* renamed from: FZ */
    public final void mo47763FZ(int i) {
        AppMethodBeat.m2504i(4383);
        int[] iArr = new int[i];
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((cIC() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
            iArr[i4] = i3;
            i3 = iArr[i4];
        }
        AppMethodBeat.m2505o(4383);
    }

    public final void flush() {
        AppMethodBeat.m2504i(4384);
        for (int i = this.sOK; i < 8; i++) {
            this.sOJ[i] = 0;
        }
        this.sOK = 0;
        cID();
        AppMethodBeat.m2505o(4384);
    }

    private void cID() {
        AppMethodBeat.m2504i(4385);
        this.sOI.write((((((((this.sOJ[0] << 7) | (this.sOJ[1] << 6)) | (this.sOJ[2] << 5)) | (this.sOJ[3] << 4)) | (this.sOJ[4] << 3)) | (this.sOJ[5] << 2)) | (this.sOJ[6] << 1)) | this.sOJ[7]);
        AppMethodBeat.m2505o(4385);
    }

    /* renamed from: Ga */
    public final void mo47765Ga(int i) {
        AppMethodBeat.m2504i(4386);
        if (this.sOK == 8) {
            this.sOK = 0;
            cID();
        }
        int[] iArr = this.sOJ;
        int i2 = this.sOK;
        this.sOK = i2 + 1;
        iArr[i2] = i;
        AppMethodBeat.m2505o(4386);
    }

    /* renamed from: G */
    public final void mo47764G(long j, int i) {
        AppMethodBeat.m2504i(4387);
        for (int i2 = 0; i2 < i; i2++) {
            mo47765Ga(((int) (j >> ((i - i2) - 1))) & 1);
        }
        AppMethodBeat.m2505o(4387);
    }

    /* renamed from: Gb */
    private void m46856Gb(int i) {
        AppMethodBeat.m2504i(4388);
        int i2 = 0;
        int i3 = 0;
        while (i2 < 15) {
            if (i < (1 << i2) + i3) {
                break;
            }
            i3 += 1 << i2;
            i2++;
        }
        i2 = 0;
        mo47764G(0, i2);
        mo47765Ga(1);
        mo47764G((long) (i - i3), i2);
        AppMethodBeat.m2505o(4388);
    }

    /* renamed from: Gc */
    public final void mo47766Gc(int i) {
        AppMethodBeat.m2504i(4389);
        m46856Gb(i);
        AppMethodBeat.m2505o(4389);
    }

    /* renamed from: mn */
    public final void mo47773mn(boolean z) {
        AppMethodBeat.m2504i(4390);
        mo47765Ga(z ? 1 : 0);
        AppMethodBeat.m2505o(4390);
    }
}
