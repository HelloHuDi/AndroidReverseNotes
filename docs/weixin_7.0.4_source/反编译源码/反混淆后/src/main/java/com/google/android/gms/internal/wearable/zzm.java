package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzm extends IOException {
    zzm(int i, int i2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        AppMethodBeat.m2504i(70749);
        AppMethodBeat.m2505o(70749);
    }
}
