package com.tencent.mm.loader.b.a;

import a.f.b.j;
import a.l;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/loader/cache/disk/DiskFunction;", "", "()V", "TAG", "", "compress", "", "bm", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "stream", "Ljava/io/OutputStream;", "obtainOutputStream", "filePath", "ctx", "Lcom/tencent/mm/modelsfs/SFSContext;", "save", "data", "", "libimageloader_release"})
public final class c {
    private static final String TAG = TAG;
    public static final c ePl = new c();

    private c() {
    }

    public static OutputStream a(String str, SFSContext sFSContext) {
        j.p(str, "filePath");
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            return null;
        }
        if (sFSContext != null) {
            return sFSContext.pH(str);
        }
        b dMC = new b(str).dMC();
        if (!(dMC == null || dMC.exists())) {
            dMC.mkdirs();
        }
        return e.pH(str);
    }

    public static boolean a(byte[] bArr, OutputStream outputStream) {
        j.p(bArr, "data");
        j.p(outputStream, "stream");
        outputStream.write(bArr);
        return true;
    }

    public static boolean a(String str, OutputStream outputStream) {
        Closeable closeable;
        Throwable th;
        Throwable th2 = null;
        j.p(str, "filePath");
        j.p(outputStream, "stream");
        if (e.ct(str)) {
            InputStream openRead = e.openRead(str);
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
                            a.e.b.a(closeable, null);
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
        a.e.b.a(closeable, th2);
        throw th;
    }
}
