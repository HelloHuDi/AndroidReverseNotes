package com.bumptech.glide.a;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

final class b implements Closeable {
    final Charset axR;
    private byte[] buf;
    int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private b(InputStream inputStream, Charset charset, byte b) {
        AppMethodBeat.i(51807);
        if (inputStream == null || charset == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(51807);
            throw nullPointerException;
        } else if (charset.equals(c.US_ASCII)) {
            this.in = inputStream;
            this.axR = charset;
            this.buf = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            AppMethodBeat.o(51807);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported encoding");
            AppMethodBeat.o(51807);
            throw illegalArgumentException;
        }
    }

    public final void close() {
        AppMethodBeat.i(51808);
        synchronized (this.in) {
            try {
                if (this.buf != null) {
                    this.buf = null;
                    this.in.close();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51808);
            }
        }
    }

    public final String readLine() {
        String str;
        AppMethodBeat.i(51809);
        synchronized (this.in) {
            try {
                if (this.buf == null) {
                    Object iOException = new IOException("LineReader is closed");
                    throw iOException;
                }
                int i;
                if (this.pos >= this.end) {
                    lS();
                }
                int i2 = this.pos;
                while (i2 != this.end) {
                    if (this.buf[i2] == (byte) 10) {
                        int i3 = (i2 == this.pos || this.buf[i2 - 1] != (byte) 13) ? i2 : i2 - 1;
                        str = new String(this.buf, this.pos, i3 - this.pos, this.axR.name());
                        this.pos = i2 + 1;
                        AppMethodBeat.o(51809);
                    } else {
                        i2++;
                    }
                }
                AnonymousClass1 anonymousClass1 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                    public final String toString() {
                        AppMethodBeat.i(51804);
                        int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
                        try {
                            String str = new String(this.buf, 0, i, b.this.axR.name());
                            AppMethodBeat.o(51804);
                            return str;
                        } catch (UnsupportedEncodingException e) {
                            AssertionError assertionError = new AssertionError(e);
                            AppMethodBeat.o(51804);
                            throw assertionError;
                        }
                    }
                };
                while (true) {
                    anonymousClass1.write(this.buf, this.pos, this.end - this.pos);
                    this.end = -1;
                    lS();
                    i = this.pos;
                    while (i != this.end) {
                        if (this.buf[i] == (byte) 10) {
                            break;
                        }
                        i++;
                    }
                }
                if (i != this.pos) {
                    anonymousClass1.write(this.buf, this.pos, i - this.pos);
                }
                this.pos = i + 1;
                str = anonymousClass1.toString();
                AppMethodBeat.o(51809);
            } finally {
                AppMethodBeat.o(51809);
            }
        }
        return str;
    }

    private void lS() {
        AppMethodBeat.i(51810);
        int read = this.in.read(this.buf, 0, this.buf.length);
        if (read == -1) {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(51810);
            throw eOFException;
        }
        this.pos = 0;
        this.end = read;
        AppMethodBeat.o(51810);
    }
}
