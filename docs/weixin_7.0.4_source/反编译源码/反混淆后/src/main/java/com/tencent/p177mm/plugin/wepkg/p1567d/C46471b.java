package com.tencent.p177mm.plugin.wepkg.p1567d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.wepkg.d.b */
public final class C46471b extends InputStream {
    private long size;
    private C41335a uXU;

    public C46471b(File file, long j, long j2) {
        AppMethodBeat.m2504i(63614);
        this.size = j2;
        this.uXU = new C41335a(new FileInputStream(file));
        m87650lX(j);
        this.uXU.dgF();
        AppMethodBeat.m2505o(63614);
    }

    public final int read(byte[] bArr) {
        AppMethodBeat.m2504i(63616);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(63616);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(63617);
        long lW = m87649lW((long) i2);
        if (lW != 0 || i2 <= 0) {
            int read = this.uXU.read(bArr, i, (int) lW);
            AppMethodBeat.m2505o(63617);
            return read;
        }
        AppMethodBeat.m2505o(63617);
        return -1;
    }

    public final long skip(long j) {
        AppMethodBeat.m2504i(63618);
        long skip = this.uXU.skip(m87649lW(j));
        AppMethodBeat.m2505o(63618);
        return skip;
    }

    public final int available() {
        AppMethodBeat.m2504i(63619);
        int lW = (int) m87649lW((long) this.uXU.available());
        AppMethodBeat.m2505o(63619);
        return lW;
    }

    /* renamed from: lW */
    private long m87649lW(long j) {
        AppMethodBeat.m2504i(63620);
        long min = Math.min(dgG(), j);
        AppMethodBeat.m2505o(63620);
        return min;
    }

    private long dgG() {
        return this.size - ((long) this.uXU.count);
    }

    /* renamed from: lX */
    private void m87650lX(long j) {
        AppMethodBeat.m2504i(63621);
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
            AppMethodBeat.m2505o(63621);
            throw iOException;
        }
        AppMethodBeat.m2505o(63621);
    }

    public final int read() {
        Object obj;
        AppMethodBeat.m2504i(63615);
        if (dgG() <= 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(63615);
            return -1;
        }
        int read = this.uXU.read();
        AppMethodBeat.m2505o(63615);
        return read;
    }
}
