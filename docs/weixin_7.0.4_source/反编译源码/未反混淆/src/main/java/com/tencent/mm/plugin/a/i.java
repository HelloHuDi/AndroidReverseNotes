package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;

public final class i extends a {
    public i(int i, long j, int i2) {
        super(i, j, i2, 0);
    }

    public static e b(RandomAccessFile randomAccessFile, byte[] bArr) {
        AppMethodBeat.i(117855);
        e eVar = (e) c.a(randomAccessFile, bArr, a.aWl);
        AppMethodBeat.o(117855);
        return eVar;
    }
}
