package com.bumptech.glide.p086c.p092d.p093a;

import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.d.a.m */
public final class C25444m extends FilterInputStream {
    private final C8515b azx;
    private volatile byte[] buf;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    /* renamed from: com.bumptech.glide.c.d.a.m$a */
    static class C25445a extends IOException {
        C25445a(String str) {
            super(str);
        }
    }

    public C25444m(InputStream inputStream, C8515b c8515b) {
        this(inputStream, c8515b, (byte) 0);
    }

    private C25444m(InputStream inputStream, C8515b c8515b, byte b) {
        super(inputStream);
        AppMethodBeat.m2504i(92248);
        this.markpos = -1;
        this.azx = c8515b;
        this.buf = (byte[]) c8515b.mo18608a(65536, byte[].class);
        AppMethodBeat.m2505o(92248);
    }

    public final synchronized int available() {
        int available;
        AppMethodBeat.m2504i(92249);
        InputStream inputStream = this.in;
        if (this.buf == null || inputStream == null) {
            IOException nv = C25444m.m40212nv();
            AppMethodBeat.m2505o(92249);
            throw nv;
        }
        available = inputStream.available() + (this.count - this.pos);
        AppMethodBeat.m2505o(92249);
        return available;
    }

    /* renamed from: nv */
    private static IOException m40212nv() {
        AppMethodBeat.m2504i(92250);
        IOException iOException = new IOException("BufferedInputStream is closed");
        AppMethodBeat.m2505o(92250);
        throw iOException;
    }

    /* renamed from: nw */
    public final synchronized void mo42477nw() {
        this.marklimit = this.buf.length;
    }

    public final synchronized void release() {
        AppMethodBeat.m2504i(92251);
        if (this.buf != null) {
            this.azx.put(this.buf);
            this.buf = null;
        }
        AppMethodBeat.m2505o(92251);
    }

    public final void close() {
        AppMethodBeat.m2504i(92252);
        if (this.buf != null) {
            this.azx.put(this.buf);
            this.buf = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
        AppMethodBeat.m2505o(92252);
    }

    /* renamed from: a */
    private int m40211a(InputStream inputStream, byte[] bArr) {
        AppMethodBeat.m2504i(92253);
        int read;
        if (this.markpos == -1 || this.pos - this.markpos >= this.marklimit) {
            read = inputStream.read(bArr);
            if (read > 0) {
                this.markpos = -1;
                this.pos = 0;
                this.count = read;
            }
            AppMethodBeat.m2505o(92253);
            return read;
        }
        if (this.markpos == 0 && this.marklimit > bArr.length && this.count == bArr.length) {
            read = bArr.length * 2;
            if (read > this.marklimit) {
                read = this.marklimit;
            }
            byte[] bArr2 = (byte[]) this.azx.mo18608a(read, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buf = bArr2;
            this.azx.put(bArr);
            bArr = bArr2;
        } else if (this.markpos > 0) {
            System.arraycopy(bArr, this.markpos, bArr, 0, bArr.length - this.markpos);
        }
        this.pos -= this.markpos;
        this.markpos = 0;
        this.count = 0;
        int read2 = inputStream.read(bArr, this.pos, bArr.length - this.pos);
        this.count = read2 <= 0 ? this.pos : this.pos + read2;
        AppMethodBeat.m2505o(92253);
        return read2;
    }

    public final synchronized void mark(int i) {
        AppMethodBeat.m2504i(92254);
        this.marklimit = Math.max(this.marklimit, i);
        this.markpos = this.pos;
        AppMethodBeat.m2505o(92254);
    }

    public final boolean markSupported() {
        return true;
    }

    public final synchronized int read() {
        int i = -1;
        synchronized (this) {
            AppMethodBeat.m2504i(92255);
            byte[] bArr = this.buf;
            InputStream inputStream = this.in;
            IOException nv;
            if (bArr == null || inputStream == null) {
                nv = C25444m.m40212nv();
                AppMethodBeat.m2505o(92255);
                throw nv;
            }
            if (this.pos < this.count || m40211a(inputStream, bArr) != -1) {
                if (bArr != this.buf) {
                    bArr = this.buf;
                    if (bArr == null) {
                        nv = C25444m.m40212nv();
                        AppMethodBeat.m2505o(92255);
                        throw nv;
                    }
                }
                if (this.count - this.pos > 0) {
                    i = this.pos;
                    this.pos = i + 1;
                    i = bArr[i] & 255;
                    AppMethodBeat.m2505o(92255);
                } else {
                    AppMethodBeat.m2505o(92255);
                }
            } else {
                AppMethodBeat.m2505o(92255);
            }
        }
        return i;
    }

    public final synchronized int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(92256);
        byte[] bArr2 = this.buf;
        IOException nv;
        if (bArr2 == null) {
            nv = C25444m.m40212nv();
            AppMethodBeat.m2505o(92256);
            throw nv;
        } else if (i2 == 0) {
            i2 = 0;
            AppMethodBeat.m2505o(92256);
        } else {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                nv = C25444m.m40212nv();
                AppMethodBeat.m2505o(92256);
                throw nv;
            }
            int i3;
            int i4;
            if (this.pos < this.count) {
                i3 = this.count - this.pos >= i2 ? i2 : this.count - this.pos;
                System.arraycopy(bArr2, this.pos, bArr, i, i3);
                this.pos += i3;
                if (i3 == i2 || inputStream.available() == 0) {
                    AppMethodBeat.m2505o(92256);
                    i2 = i3;
                } else {
                    i += i3;
                    i4 = i2 - i3;
                }
            } else {
                i4 = i2;
            }
            while (true) {
                if (this.markpos == -1 && i4 >= bArr2.length) {
                    i3 = inputStream.read(bArr, i, i4);
                    if (i3 == -1) {
                        if (i4 == i2) {
                            AppMethodBeat.m2505o(92256);
                            i2 = -1;
                        } else {
                            i2 -= i4;
                            AppMethodBeat.m2505o(92256);
                        }
                    }
                } else if (m40211a(inputStream, bArr2) != -1) {
                    if (bArr2 != this.buf) {
                        bArr2 = this.buf;
                        if (bArr2 == null) {
                            nv = C25444m.m40212nv();
                            AppMethodBeat.m2505o(92256);
                            throw nv;
                        }
                    }
                    i3 = this.count - this.pos >= i4 ? i4 : this.count - this.pos;
                    System.arraycopy(bArr2, this.pos, bArr, i, i3);
                    this.pos += i3;
                } else if (i4 == i2) {
                    AppMethodBeat.m2505o(92256);
                    i2 = -1;
                } else {
                    i2 -= i4;
                    AppMethodBeat.m2505o(92256);
                }
                i4 -= i3;
                if (i4 == 0) {
                    AppMethodBeat.m2505o(92256);
                    break;
                } else if (inputStream.available() == 0) {
                    i2 -= i4;
                    AppMethodBeat.m2505o(92256);
                    break;
                } else {
                    i += i3;
                }
            }
        }
        return i2;
    }

    public final synchronized void reset() {
        AppMethodBeat.m2504i(92257);
        if (this.buf == null) {
            IOException iOException = new IOException("Stream is closed");
            AppMethodBeat.m2505o(92257);
            throw iOException;
        } else if (-1 == this.markpos) {
            C25445a c25445a = new C25445a("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
            AppMethodBeat.m2505o(92257);
            throw c25445a;
        } else {
            this.pos = this.markpos;
            AppMethodBeat.m2505o(92257);
        }
    }

    public final synchronized long skip(long j) {
        AppMethodBeat.m2504i(92258);
        if (j < 1) {
            j = 0;
            AppMethodBeat.m2505o(92258);
        } else {
            byte[] bArr = this.buf;
            IOException nv;
            if (bArr == null) {
                nv = C25444m.m40212nv();
                AppMethodBeat.m2505o(92258);
                throw nv;
            }
            InputStream inputStream = this.in;
            if (inputStream == null) {
                nv = C25444m.m40212nv();
                AppMethodBeat.m2505o(92258);
                throw nv;
            } else if (((long) (this.count - this.pos)) >= j) {
                this.pos = (int) (((long) this.pos) + j);
                AppMethodBeat.m2505o(92258);
            } else {
                long j2 = ((long) this.count) - ((long) this.pos);
                this.pos = this.count;
                if (this.markpos == -1 || j > ((long) this.marklimit)) {
                    j = j2 + inputStream.skip(j - j2);
                    AppMethodBeat.m2505o(92258);
                } else if (m40211a(inputStream, bArr) == -1) {
                    AppMethodBeat.m2505o(92258);
                    j = j2;
                } else if (((long) (this.count - this.pos)) >= j - j2) {
                    this.pos = (int) ((((long) this.pos) + j) - j2);
                    AppMethodBeat.m2505o(92258);
                } else {
                    j = (j2 + ((long) this.count)) - ((long) this.pos);
                    this.pos = this.count;
                    AppMethodBeat.m2505o(92258);
                }
            }
        }
        return j;
    }
}
