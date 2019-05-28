package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.c.f.n */
final class C37241n {
    private boolean bbV;
    private final int bcT;
    boolean bcU;
    public byte[] bcV = new byte[131];
    public int bcW;

    public C37241n(int i) {
        AppMethodBeat.m2504i(95140);
        this.bcT = i;
        this.bcV[2] = (byte) 1;
        AppMethodBeat.m2505o(95140);
    }

    public final void reset() {
        this.bbV = false;
        this.bcU = false;
    }

    /* renamed from: ei */
    public final void mo59491ei(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(95141);
        C45039a.checkState(!this.bbV);
        if (i != this.bcT) {
            z = false;
        }
        this.bbV = z;
        if (this.bbV) {
            this.bcW = 3;
            this.bcU = false;
        }
        AppMethodBeat.m2505o(95141);
    }

    /* renamed from: f */
    public final void mo59493f(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95142);
        if (this.bbV) {
            int i3 = i2 - i;
            if (this.bcV.length < this.bcW + i3) {
                this.bcV = Arrays.copyOf(this.bcV, (this.bcW + i3) * 2);
            }
            System.arraycopy(bArr, i, this.bcV, this.bcW, i3);
            this.bcW = i3 + this.bcW;
            AppMethodBeat.m2505o(95142);
            return;
        }
        AppMethodBeat.m2505o(95142);
    }

    /* renamed from: ej */
    public final boolean mo59492ej(int i) {
        if (!this.bbV) {
            return false;
        }
        this.bcW -= i;
        this.bbV = false;
        this.bcU = true;
        return true;
    }
}
