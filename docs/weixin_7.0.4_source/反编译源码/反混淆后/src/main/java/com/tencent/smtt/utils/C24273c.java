package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.smtt.utils.c */
public class C24273c implements Closeable {
    /* renamed from: a */
    private final RandomAccessFile f4525a;
    /* renamed from: b */
    private final File f4526b;
    /* renamed from: c */
    private final byte[] f4527c;
    /* renamed from: d */
    private boolean f4528d;

    public C24273c(File file) {
        AppMethodBeat.m2504i(65189);
        this.f4527c = new byte[8];
        this.f4526b = file;
        this.f4525a = new RandomAccessFile(this.f4526b, "r");
        AppMethodBeat.m2505o(65189);
    }

    public C24273c(String str) {
        this(new File(str));
        AppMethodBeat.m2504i(65188);
        AppMethodBeat.m2505o(65188);
    }

    /* renamed from: a */
    public final int mo40361a(byte[] bArr) {
        AppMethodBeat.m2504i(65191);
        int read = this.f4525a.read(bArr);
        AppMethodBeat.m2505o(65191);
        return read;
    }

    /* renamed from: a */
    public final int mo40362a(char[] cArr) {
        AppMethodBeat.m2504i(65192);
        byte[] bArr = new byte[cArr.length];
        int read = this.f4525a.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        AppMethodBeat.m2505o(65192);
        return read;
    }

    /* renamed from: a */
    public final short mo40363a() {
        AppMethodBeat.m2504i(65193);
        short readShort = this.f4525a.readShort();
        if (this.f4528d) {
            readShort = (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
            AppMethodBeat.m2505o(65193);
            return readShort;
        }
        AppMethodBeat.m2505o(65193);
        return readShort;
    }

    /* renamed from: a */
    public void mo40364a(long j) {
        AppMethodBeat.m2504i(65190);
        this.f4525a.seek(j);
        AppMethodBeat.m2505o(65190);
    }

    /* renamed from: a */
    public void mo40365a(boolean z) {
        this.f4528d = z;
    }

    /* renamed from: b */
    public final int mo40366b() {
        AppMethodBeat.m2504i(65194);
        int readInt = this.f4525a.readInt();
        if (this.f4528d) {
            readInt = ((readInt & WebView.NIGHT_MODE_COLOR) >>> 24) | ((((readInt & 255) << 24) | ((65280 & readInt) << 8)) | ((16711680 & readInt) >>> 8));
            AppMethodBeat.m2505o(65194);
            return readInt;
        }
        AppMethodBeat.m2505o(65194);
        return readInt;
    }

    /* renamed from: c */
    public final long mo40367c() {
        AppMethodBeat.m2504i(65195);
        long j;
        if (this.f4528d) {
            this.f4525a.readFully(this.f4527c, 0, 8);
            j = (((((((((long) this.f4527c[7]) << 56) | (((long) (this.f4527c[6] & 255)) << 48)) | (((long) (this.f4527c[5] & 255)) << 40)) | (((long) (this.f4527c[4] & 255)) << 32)) | (((long) (this.f4527c[3] & 255)) << 24)) | (((long) (this.f4527c[2] & 255)) << 16)) | (((long) (this.f4527c[1] & 255)) << 8)) | ((long) (this.f4527c[0] & 255));
            AppMethodBeat.m2505o(65195);
            return j;
        }
        j = this.f4525a.readLong();
        AppMethodBeat.m2505o(65195);
        return j;
    }

    public void close() {
        AppMethodBeat.m2504i(65196);
        try {
            this.f4525a.close();
            AppMethodBeat.m2505o(65196);
        } catch (IOException e) {
            AppMethodBeat.m2505o(65196);
        }
    }
}
