package com.bumptech.glide.p084a;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.bumptech.glide.a.b */
final class C17510b implements Closeable {
    final Charset axR;
    private byte[] buf;
    int end;
    /* renamed from: in */
    private final InputStream f4044in;
    private int pos;

    public C17510b(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private C17510b(InputStream inputStream, Charset charset, byte b) {
        AppMethodBeat.m2504i(51807);
        if (inputStream == null || charset == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(51807);
            throw nullPointerException;
        } else if (charset.equals(C0740c.US_ASCII)) {
            this.f4044in = inputStream;
            this.axR = charset;
            this.buf = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            AppMethodBeat.m2505o(51807);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported encoding");
            AppMethodBeat.m2505o(51807);
            throw illegalArgumentException;
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(51808);
        synchronized (this.f4044in) {
            try {
                if (this.buf != null) {
                    this.buf = null;
                    this.f4044in.close();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51808);
            }
        }
    }

    public final String readLine() {
        String str;
        AppMethodBeat.m2504i(51809);
        synchronized (this.f4044in) {
            try {
                if (this.buf == null) {
                    Object iOException = new IOException("LineReader is closed");
                    throw iOException;
                }
                int i;
                if (this.pos >= this.end) {
                    m27336lS();
                }
                int i2 = this.pos;
                while (i2 != this.end) {
                    if (this.buf[i2] == (byte) 10) {
                        int i3 = (i2 == this.pos || this.buf[i2 - 1] != (byte) 13) ? i2 : i2 - 1;
                        str = new String(this.buf, this.pos, i3 - this.pos, this.axR.name());
                        this.pos = i2 + 1;
                        AppMethodBeat.m2505o(51809);
                    } else {
                        i2++;
                    }
                }
                C07391 c07391 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                    public final String toString() {
                        AppMethodBeat.m2504i(51804);
                        int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
                        try {
                            String str = new String(this.buf, 0, i, C17510b.this.axR.name());
                            AppMethodBeat.m2505o(51804);
                            return str;
                        } catch (UnsupportedEncodingException e) {
                            AssertionError assertionError = new AssertionError(e);
                            AppMethodBeat.m2505o(51804);
                            throw assertionError;
                        }
                    }
                };
                while (true) {
                    c07391.write(this.buf, this.pos, this.end - this.pos);
                    this.end = -1;
                    m27336lS();
                    i = this.pos;
                    while (i != this.end) {
                        if (this.buf[i] == (byte) 10) {
                            break;
                        }
                        i++;
                    }
                }
                if (i != this.pos) {
                    c07391.write(this.buf, this.pos, i - this.pos);
                }
                this.pos = i + 1;
                str = c07391.toString();
                AppMethodBeat.m2505o(51809);
            } finally {
                AppMethodBeat.m2505o(51809);
            }
        }
        return str;
    }

    /* renamed from: lS */
    private void m27336lS() {
        AppMethodBeat.m2504i(51810);
        int read = this.f4044in.read(this.buf, 0, this.buf.length);
        if (read == -1) {
            EOFException eOFException = new EOFException();
            AppMethodBeat.m2505o(51810);
            throw eOFException;
        }
        this.pos = 0;
        this.end = read;
        AppMethodBeat.m2505o(51810);
    }
}
