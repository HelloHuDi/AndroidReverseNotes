package com.tencent.tinker.p668a.p671b.p1109a;

import com.tencent.mars.cdn.CdnLogic;
import java.io.EOFException;

/* renamed from: com.tencent.tinker.a.b.a.g */
public final class C46813g extends C16318a {
    final short[] Azg;

    public C46813g(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.Azg = sArr;
    }

    public final int read() {
        try {
            short s = this.Azg[this.akp];
            dSc();
            return s & CdnLogic.kBizGeneric;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EOFException();
        }
    }

    public final int readInt() {
        return read() | (read() << 16);
    }

    public final long readLong() {
        return ((((long) read()) | (((long) read()) << 16)) | (((long) read()) << 32)) | (((long) read()) << 48);
    }
}
