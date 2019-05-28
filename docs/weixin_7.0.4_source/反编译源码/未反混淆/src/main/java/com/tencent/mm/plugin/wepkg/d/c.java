package com.tencent.mm.plugin.wepkg.d;

import java.io.FilterInputStream;
import java.io.InputStream;

public abstract class c extends FilterInputStream {
    public c(InputStream inputStream) {
        super(inputStream);
    }

    public int read() {
        return this.in.read();
    }

    public int read(byte[] bArr) {
        return this.in.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.in.read(bArr, i, i2);
    }

    public long skip(long j) {
        return this.in.skip(j);
    }

    public int available() {
        return this.in.available();
    }

    public void close() {
        this.in.close();
    }

    public synchronized void mark(int i) {
        this.in.mark(i);
    }

    public synchronized void reset() {
        this.in.reset();
    }

    public boolean markSupported() {
        return this.in.markSupported();
    }
}
