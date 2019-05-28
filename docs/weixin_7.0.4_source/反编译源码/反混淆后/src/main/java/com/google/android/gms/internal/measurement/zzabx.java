package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzabx extends IOException {
    zzabx(int i, int i2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        AppMethodBeat.m2504i(3480);
        AppMethodBeat.m2505o(3480);
    }
}
