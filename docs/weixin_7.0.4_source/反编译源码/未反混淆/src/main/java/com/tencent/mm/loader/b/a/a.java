package com.tencent.mm.loader.b.a;

import a.e.b;
import a.f.b.j;
import a.k.u;
import a.l;
import a.v;
import a.y;
import android.graphics.Bitmap;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Closeable;
import java.io.OutputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J0\u0010\u000f\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J0\u0010\u0011\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016JZ\u0010\u0012\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "T", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "exists", "save", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "Companion", "libimageloader_release"})
public abstract class a<T> extends d<T, Bitmap> {
    private static final String TAG = TAG;
    public static final a ePj = new a();
    private f ePi;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public final boolean a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.h.f<?> fVar, e<Bitmap> eVar, e<Bitmap> eVar2, com.tencent.mm.loader.c.e eVar3, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        Closeable closeable;
        Throwable th;
        Throwable th2 = null;
        j.p(aVar, "url");
        j.p(fVar, "httpResponse");
        j.p(eVar, "source");
        j.p(eVar3, "opts");
        j.p(fVar2, "reaper");
        a(aVar, fVar, eVar3, fVar2);
        String a = a(aVar, eVar3, fVar2);
        ab.i(TAG, "save " + aVar + " filePath " + a);
        c cVar = c.ePl;
        OutputStream a2 = c.a(a, eVar3.TF());
        if (a2 != null) {
            closeable = a2;
            boolean z = false;
            if (eVar2 != null) {
                try {
                    c cVar2 = c.ePl;
                    Object value = eVar2.value();
                    j.o(value, "it.value()");
                    c.a((Bitmap) value, a2);
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                }
            }
            if (!z) {
                fVar.a(a2);
            }
            b(aVar, eVar3, fVar2);
            y yVar = y.AUy;
            b.a(closeable, null);
        }
        return true;
        b.a(closeable, th2);
        throw th;
    }

    public String a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.c.e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        j.p(aVar, "url");
        j.p(eVar, "opts");
        j.p(fVar, "reaper");
        String Tx = eVar.Tx();
        if (Tx == null || Tx.length() == 0) {
            String Tv = eVar.Tv();
            if (Tv != null && Tv.length() > 0) {
                Tx = eVar.Tw();
                if (Tx == null || Tx.length() == 0 || !u.jb(Tv, Tx)) {
                    ab.e(TAG, "[johnw] SFS can't deal with absolute path: %s", Tv);
                    throw new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(Tv)));
                }
                Tx = Tv.substring(Tx.length());
                j.o(Tx, "(this as java.lang.String).substring(startIndex)");
                if (u.jb(Tx, "/")) {
                    if (Tx == null) {
                        throw new v("null cannot be cast to non-null type java.lang.String");
                    }
                    Tx = Tx.substring(1);
                    j.o(Tx, "(this as java.lang.String).substring(startIndex)");
                }
            }
        }
        if (Tx == null || Tx.length() == 0) {
            f fVar2 = this.ePi;
            if (fVar2 == null) {
                j.dWJ();
            }
            Tx = fVar2.b(aVar);
        }
        return (Tx == null || Tx.length() == 0) ? "" : Tx;
    }
}
