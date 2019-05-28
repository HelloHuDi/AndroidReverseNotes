package com.tencent.d.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class b {
    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(114518);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                AppMethodBeat.o(114518);
                return;
            }
        }
        AppMethodBeat.o(114518);
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(114519);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                AppMethodBeat.o(114519);
                return j;
            }
        }
    }
}
