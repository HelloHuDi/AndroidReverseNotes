package com.bumptech.glide.p086c.p087a;

import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

/* renamed from: com.bumptech.glide.c.a.c */
public final class C31924c extends OutputStream {
    private C8515b awk;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    public C31924c(OutputStream outputStream, C8515b c8515b) {
        this(outputStream, c8515b, (byte) 0);
    }

    private C31924c(OutputStream outputStream, C8515b c8515b, byte b) {
        AppMethodBeat.m2504i(91696);
        this.out = outputStream;
        this.awk = c8515b;
        this.buffer = (byte[]) c8515b.mo18608a(65536, byte[].class);
        AppMethodBeat.m2505o(91696);
    }

    public final void write(int i) {
        AppMethodBeat.m2504i(91697);
        byte[] bArr = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        bArr[i2] = (byte) i;
        m51848mi();
        AppMethodBeat.m2505o(91697);
    }

    public final void write(byte[] bArr) {
        AppMethodBeat.m2504i(91698);
        write(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(91698);
    }

    public final void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(91699);
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.index != 0 || i4 < this.buffer.length) {
                i4 = Math.min(i4, this.buffer.length - this.index);
                System.arraycopy(bArr, i5, this.buffer, this.index, i4);
                this.index += i4;
                i3 += i4;
                m51848mi();
            } else {
                this.out.write(bArr, i5, i4);
                AppMethodBeat.m2505o(91699);
                return;
            }
        } while (i3 < i2);
        AppMethodBeat.m2505o(91699);
    }

    public final void flush() {
        AppMethodBeat.m2504i(91700);
        flushBuffer();
        this.out.flush();
        AppMethodBeat.m2505o(91700);
    }

    private void flushBuffer() {
        AppMethodBeat.m2504i(91701);
        if (this.index > 0) {
            this.out.write(this.buffer, 0, this.index);
            this.index = 0;
        }
        AppMethodBeat.m2505o(91701);
    }

    /* renamed from: mi */
    private void m51848mi() {
        AppMethodBeat.m2504i(91702);
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
        AppMethodBeat.m2505o(91702);
    }

    public final void close() {
        AppMethodBeat.m2504i(91703);
        try {
            flush();
            this.out.close();
            if (this.buffer != null) {
                this.awk.put(this.buffer);
                this.buffer = null;
            }
            AppMethodBeat.m2505o(91703);
        } catch (Throwable th) {
            this.out.close();
            AppMethodBeat.m2505o(91703);
        }
    }
}
