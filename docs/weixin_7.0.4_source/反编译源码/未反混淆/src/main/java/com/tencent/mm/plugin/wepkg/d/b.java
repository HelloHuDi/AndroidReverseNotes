package com.tencent.mm.plugin.wepkg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends InputStream {
    private long size;
    private a uXU;

    public b(File file, long j, long j2) {
        AppMethodBeat.i(63614);
        this.size = j2;
        this.uXU = new a(new FileInputStream(file));
        lX(j);
        this.uXU.dgF();
        AppMethodBeat.o(63614);
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.i(63616);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.o(63616);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(63617);
        long lW = lW((long) i2);
        if (lW != 0 || i2 <= 0) {
            int read = this.uXU.read(bArr, i, (int) lW);
            AppMethodBeat.o(63617);
            return read;
        }
        AppMethodBeat.o(63617);
        return -1;
    }

    public final long skip(long j) {
        AppMethodBeat.i(63618);
        long skip = this.uXU.skip(lW(j));
        AppMethodBeat.o(63618);
        return skip;
    }

    public final int available() {
        AppMethodBeat.i(63619);
        int lW = (int) lW((long) this.uXU.available());
        AppMethodBeat.o(63619);
        return lW;
    }

    private long lW(long j) {
        AppMethodBeat.i(63620);
        long min = Math.min(dgG(), j);
        AppMethodBeat.o(63620);
        return min;
    }

    private long dgG() {
        return this.size - ((long) this.uXU.count);
    }

    private void lX(long j) {
        AppMethodBeat.i(63621);
        long j2 = 0;
        while (j2 < j) {
            long skip = this.uXU.skip(j - j2);
            if (skip <= 0) {
                break;
            }
            j2 += skip;
        }
        if (j2 < j) {
            IOException iOException = new IOException("could not seek pos ".concat(String.valueOf(j)));
            AppMethodBeat.o(63621);
            throw iOException;
        }
        AppMethodBeat.o(63621);
    }

    public final int read() {
        Object obj;
        AppMethodBeat.i(63615);
        if (dgG() <= 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(63615);
            return -1;
        }
        int read = this.uXU.read();
        AppMethodBeat.o(63615);
        return read;
    }
}
