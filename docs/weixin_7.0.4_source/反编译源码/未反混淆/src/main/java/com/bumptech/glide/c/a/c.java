package com.bumptech.glide.c.a;

import com.bumptech.glide.c.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class c extends OutputStream {
    private b awk;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, (byte) 0);
    }

    private c(OutputStream outputStream, b bVar, byte b) {
        AppMethodBeat.i(91696);
        this.out = outputStream;
        this.awk = bVar;
        this.buffer = (byte[]) bVar.a(65536, byte[].class);
        AppMethodBeat.o(91696);
    }

    public final void write(int i) {
        AppMethodBeat.i(91697);
        byte[] bArr = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        bArr[i2] = (byte) i;
        mi();
        AppMethodBeat.o(91697);
    }

    public final void write(byte[] bArr) {
        AppMethodBeat.i(91698);
        write(bArr, 0, bArr.length);
        AppMethodBeat.o(91698);
    }

    public final void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(91699);
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.index != 0 || i4 < this.buffer.length) {
                i4 = Math.min(i4, this.buffer.length - this.index);
                System.arraycopy(bArr, i5, this.buffer, this.index, i4);
                this.index += i4;
                i3 += i4;
                mi();
            } else {
                this.out.write(bArr, i5, i4);
                AppMethodBeat.o(91699);
                return;
            }
        } while (i3 < i2);
        AppMethodBeat.o(91699);
    }

    public final void flush() {
        AppMethodBeat.i(91700);
        flushBuffer();
        this.out.flush();
        AppMethodBeat.o(91700);
    }

    private void flushBuffer() {
        AppMethodBeat.i(91701);
        if (this.index > 0) {
            this.out.write(this.buffer, 0, this.index);
            this.index = 0;
        }
        AppMethodBeat.o(91701);
    }

    private void mi() {
        AppMethodBeat.i(91702);
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
        AppMethodBeat.o(91702);
    }

    public final void close() {
        AppMethodBeat.i(91703);
        try {
            flush();
            this.out.close();
            if (this.buffer != null) {
                this.awk.put(this.buffer);
                this.buffer = null;
            }
            AppMethodBeat.o(91703);
        } catch (Throwable th) {
            this.out.close();
            AppMethodBeat.o(91703);
        }
    }
}
