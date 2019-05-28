package com.google.p114b.p118e.p119a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.e.a.b */
final class C32086b {
    final byte[] bAL;
    private int bAM = 0;

    C32086b(int i) {
        AppMethodBeat.m2504i(57157);
        this.bAL = new byte[i];
        AppMethodBeat.m2505o(57157);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo52656d(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3;
            int i4 = this.bAM;
            this.bAM = i4 + 1;
            byte[] bArr = this.bAL;
            if (z) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            bArr[i4] = (byte) i3;
        }
    }
}
