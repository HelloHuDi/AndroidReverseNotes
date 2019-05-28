package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class e {
    public static final boolean a(InputStream inputStream, byte[] bArr, int i) {
        AppMethodBeat.i(125683);
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2 + 0, i - i2);
            if (read < 0) {
                AppMethodBeat.o(125683);
                return false;
            }
            i2 += read;
        }
        AppMethodBeat.o(125683);
        return true;
    }
}
