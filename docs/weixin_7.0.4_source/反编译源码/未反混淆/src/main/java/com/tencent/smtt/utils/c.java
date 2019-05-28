package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class c implements Closeable {
    private final RandomAccessFile a;
    private final File b;
    private final byte[] c;
    private boolean d;

    public c(File file) {
        AppMethodBeat.i(65189);
        this.c = new byte[8];
        this.b = file;
        this.a = new RandomAccessFile(this.b, "r");
        AppMethodBeat.o(65189);
    }

    public c(String str) {
        this(new File(str));
        AppMethodBeat.i(65188);
        AppMethodBeat.o(65188);
    }

    public final int a(byte[] bArr) {
        AppMethodBeat.i(65191);
        int read = this.a.read(bArr);
        AppMethodBeat.o(65191);
        return read;
    }

    public final int a(char[] cArr) {
        AppMethodBeat.i(65192);
        byte[] bArr = new byte[cArr.length];
        int read = this.a.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        AppMethodBeat.o(65192);
        return read;
    }

    public final short a() {
        AppMethodBeat.i(65193);
        short readShort = this.a.readShort();
        if (this.d) {
            readShort = (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
            AppMethodBeat.o(65193);
            return readShort;
        }
        AppMethodBeat.o(65193);
        return readShort;
    }

    public void a(long j) {
        AppMethodBeat.i(65190);
        this.a.seek(j);
        AppMethodBeat.o(65190);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public final int b() {
        AppMethodBeat.i(65194);
        int readInt = this.a.readInt();
        if (this.d) {
            readInt = ((readInt & WebView.NIGHT_MODE_COLOR) >>> 24) | ((((readInt & 255) << 24) | ((65280 & readInt) << 8)) | ((16711680 & readInt) >>> 8));
            AppMethodBeat.o(65194);
            return readInt;
        }
        AppMethodBeat.o(65194);
        return readInt;
    }

    public final long c() {
        AppMethodBeat.i(65195);
        long j;
        if (this.d) {
            this.a.readFully(this.c, 0, 8);
            j = (((((((((long) this.c[7]) << 56) | (((long) (this.c[6] & 255)) << 48)) | (((long) (this.c[5] & 255)) << 40)) | (((long) (this.c[4] & 255)) << 32)) | (((long) (this.c[3] & 255)) << 24)) | (((long) (this.c[2] & 255)) << 16)) | (((long) (this.c[1] & 255)) << 8)) | ((long) (this.c[0] & 255));
            AppMethodBeat.o(65195);
            return j;
        }
        j = this.a.readLong();
        AppMethodBeat.o(65195);
        return j;
    }

    public void close() {
        AppMethodBeat.i(65196);
        try {
            this.a.close();
            AppMethodBeat.o(65196);
        } catch (IOException e) {
            AppMethodBeat.o(65196);
        }
    }
}
