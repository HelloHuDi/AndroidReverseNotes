package com.tencent.mm.loader.h.b;

import com.tencent.mm.sdk.platformtools.ah;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a implements Closeable {
    InputStream azC = null;
    byte[] eSb = null;
    d eSc;
    c eSd;
    Object eSe;

    static class a implements c, d {
        InputStream azv = null;
        String mFilePath;

        public a(String str) {
            this.mFilePath = str;
        }

        public final InputStream Uj() {
            try {
                this.azv = com.tencent.mm.vfs.e.openRead(this.mFilePath);
                return this.azv;
            } catch (FileNotFoundException e) {
                return null;
            }
        }

        public final void close() {
            a.s(this.azv);
        }
    }

    static class b implements c {
        byte[] mBuf;

        public b(byte[] bArr) {
            this.mBuf = bArr;
        }

        public final void close() {
        }
    }

    static class c implements c {
        InputStream eSf;

        public c(InputStream inputStream) {
            this.eSf = inputStream;
        }

        public final void close() {
            a.s(this.eSf);
        }
    }

    static class d implements d {
        InputStream azv = null;
        byte[] mBuf;

        public d(byte[] bArr) {
            this.mBuf = bArr;
        }

        public final InputStream Uj() {
            if (this.azv == null) {
                this.azv = new ByteArrayInputStream(this.mBuf);
            }
            return this.azv;
        }

        public final void close() {
            a.s(this.azv);
        }
    }

    static class e implements d {
        InputStream eSf;

        public e(InputStream inputStream) {
            this.eSf = inputStream;
        }

        public final InputStream Uj() {
            return this.eSf;
        }

        public final void close() {
            a.s(this.eSf);
        }
    }

    public static a lT(String str) {
        return i(str, null);
    }

    public static a i(String str, Object obj) {
        return a(new a(str), obj);
    }

    public static a lU(String str) {
        return a(ah.getContext().getAssets().open(str), ah.getContext().getAssets().open(str));
    }

    private static <T extends d & c> a a(T t, Object obj) {
        return new a(t, (c) t, obj);
    }

    private a(d dVar, c cVar, Object obj) {
        this.eSc = dVar;
        this.eSd = cVar;
        this.eSe = obj;
    }

    public final InputStream Uj() {
        if (this.azC != null) {
            return this.azC;
        }
        if (this.eSc == null) {
            return null;
        }
        this.azC = this.eSc.Uj();
        return this.azC;
    }

    public final void close() {
        if (this.eSc != null) {
            this.eSc.close();
        }
        if (this.eSd != null) {
            this.eSd.close();
        }
    }

    public static a a(InputStream inputStream, InputStream inputStream2) {
        return new a(new e(inputStream), new c(inputStream2), null);
    }

    public static a L(byte[] bArr) {
        return new a(new d(bArr), new b(bArr), null);
    }

    static /* synthetic */ void s(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
