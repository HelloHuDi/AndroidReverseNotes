package com.tencent.p177mm.loader.p1197h.p1199b;

import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.loader.h.b.a */
public final class C18545a implements Closeable {
    InputStream azC = null;
    byte[] eSb = null;
    C42157d eSc;
    C18551c eSd;
    Object eSe;

    /* renamed from: com.tencent.mm.loader.h.b.a$a */
    static class C18546a implements C18551c, C42157d {
        InputStream azv = null;
        String mFilePath;

        public C18546a(String str) {
            this.mFilePath = str;
        }

        /* renamed from: Uj */
        public final InputStream mo33798Uj() {
            try {
                this.azv = C5730e.openRead(this.mFilePath);
                return this.azv;
            } catch (FileNotFoundException e) {
                return null;
            }
        }

        public final void close() {
            C18545a.m28859s(this.azv);
        }
    }

    /* renamed from: com.tencent.mm.loader.h.b.a$b */
    static class C18547b implements C18551c {
        byte[] mBuf;

        public C18547b(byte[] bArr) {
            this.mBuf = bArr;
        }

        public final void close() {
        }
    }

    /* renamed from: com.tencent.mm.loader.h.b.a$c */
    static class C18548c implements C18551c {
        InputStream eSf;

        public C18548c(InputStream inputStream) {
            this.eSf = inputStream;
        }

        public final void close() {
            C18545a.m28859s(this.eSf);
        }
    }

    /* renamed from: com.tencent.mm.loader.h.b.a$d */
    static class C18549d implements C42157d {
        InputStream azv = null;
        byte[] mBuf;

        public C18549d(byte[] bArr) {
            this.mBuf = bArr;
        }

        /* renamed from: Uj */
        public final InputStream mo33798Uj() {
            if (this.azv == null) {
                this.azv = new ByteArrayInputStream(this.mBuf);
            }
            return this.azv;
        }

        public final void close() {
            C18545a.m28859s(this.azv);
        }
    }

    /* renamed from: com.tencent.mm.loader.h.b.a$e */
    static class C18550e implements C42157d {
        InputStream eSf;

        public C18550e(InputStream inputStream) {
            this.eSf = inputStream;
        }

        /* renamed from: Uj */
        public final InputStream mo33798Uj() {
            return this.eSf;
        }

        public final void close() {
            C18545a.m28859s(this.eSf);
        }
    }

    /* renamed from: lT */
    public static C18545a m28857lT(String str) {
        return C18545a.m28856i(str, null);
    }

    /* renamed from: i */
    public static C18545a m28856i(String str, Object obj) {
        return C18545a.m28854a(new C18546a(str), obj);
    }

    /* renamed from: lU */
    public static C18545a m28858lU(String str) {
        return C18545a.m28855a(C4996ah.getContext().getAssets().open(str), C4996ah.getContext().getAssets().open(str));
    }

    /* renamed from: a */
    private static <T extends C42157d & C18551c> C18545a m28854a(T t, Object obj) {
        return new C18545a(t, (C18551c) t, obj);
    }

    private C18545a(C42157d c42157d, C18551c c18551c, Object obj) {
        this.eSc = c42157d;
        this.eSd = c18551c;
        this.eSe = obj;
    }

    /* renamed from: Uj */
    public final InputStream mo33796Uj() {
        if (this.azC != null) {
            return this.azC;
        }
        if (this.eSc == null) {
            return null;
        }
        this.azC = this.eSc.mo33798Uj();
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

    /* renamed from: a */
    public static C18545a m28855a(InputStream inputStream, InputStream inputStream2) {
        return new C18545a(new C18550e(inputStream), new C18548c(inputStream2), null);
    }

    /* renamed from: L */
    public static C18545a m28853L(byte[] bArr) {
        return new C18545a(new C18549d(bArr), new C18547b(bArr), null);
    }

    /* renamed from: s */
    static /* synthetic */ void m28859s(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
