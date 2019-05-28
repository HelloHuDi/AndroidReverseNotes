package com.google.android.gms.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class zzb extends CertData {
    private final byte[] zzbd;

    zzb(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        AppMethodBeat.m2504i(90331);
        this.zzbd = bArr;
        AppMethodBeat.m2505o(90331);
    }

    /* Access modifiers changed, original: final */
    public final byte[] getBytes() {
        return this.zzbd;
    }
}
