package com.tencent.p177mm.loader.p858b.p859a;

import com.tencent.p177mm.modelsfs.SFSContext;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p1582e.C41372b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/loader/cache/disk/DiskFunction;", "", "()V", "TAG", "", "compress", "", "bm", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "stream", "Ljava/io/OutputStream;", "obtainOutputStream", "filePath", "ctx", "Lcom/tencent/mm/modelsfs/SFSContext;", "save", "data", "", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.b.a.c */
public final class C9564c {
    private static final String TAG = TAG;
    public static final C9564c ePl = new C9564c();

    private C9564c() {
    }

    /* renamed from: a */
    public static OutputStream m17032a(String str, SFSContext sFSContext) {
        C25052j.m39376p(str, "filePath");
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            return null;
        }
        if (sFSContext != null) {
            return sFSContext.mo44222pH(str);
        }
        C5728b dMC = new C5728b(str).dMC();
        if (!(dMC == null || dMC.exists())) {
            dMC.mkdirs();
        }
        return C5730e.m8639pH(str);
    }

    /* renamed from: a */
    public static boolean m17035a(byte[] bArr, OutputStream outputStream) {
        C25052j.m39376p(bArr, "data");
        C25052j.m39376p(outputStream, "stream");
        outputStream.write(bArr);
        return true;
    }

    /* renamed from: a */
    public static boolean m17034a(String str, OutputStream outputStream) {
        Closeable closeable;
        Throwable th;
        Throwable th2 = null;
        C25052j.m39376p(str, "filePath");
        C25052j.m39376p(outputStream, "stream");
        if (C5730e.m8628ct(str)) {
            InputStream openRead = C5730e.openRead(str);
            if (openRead != null) {
                closeable = openRead;
                try {
                    InputStream inputStream = (InputStream) closeable;
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            C41372b.m72155a(closeable, null);
                            return true;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                }
            }
        }
        return false;
        C41372b.m72155a(closeable, th2);
        throw th;
    }
}
