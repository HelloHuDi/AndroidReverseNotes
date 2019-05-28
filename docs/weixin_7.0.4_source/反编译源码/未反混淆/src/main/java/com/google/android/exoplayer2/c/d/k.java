package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.c.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    public final a aUO;
    public final boolean aZs;
    public final String aZt;
    public final int aZu;
    public final byte[] aZv;

    /* JADX WARNING: Missing block: B:17:0x0055, code skipped:
            if (r9.equals("cenc") != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4;
        int i5 = 0;
        int i6 = 1;
        AppMethodBeat.i(95013);
        int i7 = i == 0 ? 1 : 0;
        if (bArr2 == null) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        com.google.android.exoplayer2.i.a.checkArgument(i4 ^ i7);
        this.aZs = z;
        this.aZt = str;
        this.aZu = i;
        this.aZv = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals("cbc1")) {
                        i5 = 2;
                        break;
                    }
                case 3046671:
                    if (str.equals("cbcs")) {
                        i5 = 3;
                        break;
                    }
                case 3049879:
                    break;
                case 3049895:
                    if (str.equals("cens")) {
                        i5 = 1;
                        break;
                    }
                default:
                    i5 = -1;
                    break;
            }
            switch (i5) {
                case 0:
                case 1:
                    break;
                case 2:
                case 3:
                    i6 = 2;
                    break;
                default:
                    new StringBuilder("Unsupported protection scheme type '").append(str).append("'. Assuming AES-CTR crypto mode.");
                    break;
            }
        }
        this.aUO = new a(i6, bArr, i2, i3);
        AppMethodBeat.o(95013);
    }
}
