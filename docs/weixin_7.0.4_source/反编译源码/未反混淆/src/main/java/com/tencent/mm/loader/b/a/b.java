package com.tencent.mm.loader.b.a;

import a.f.b.j;
import a.k.u;
import a.l;
import a.v;
import android.graphics.Bitmap;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.d;
import java.io.FileNotFoundException;
import java.io.InputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J0\u0010\u0010\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J0\u0010\u0012\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J3\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0002J2\u0010\u0015\u001a\u0004\u0018\u00010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0002J@\u0010\u0016\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016JL\u0010\u0019\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016JZ\u0010\u001d\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, dWq = {"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache;", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "clear", "", "delete", "", "exists", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "getGeneralFilePathFromOptions", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
public final class b extends d<String, Bitmap> {
    private static final String TAG = TAG;
    public static final a ePk = new a();
    private f ePi;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public final boolean a(com.tencent.mm.loader.h.a.a<String> aVar, com.tencent.mm.loader.h.f<?> fVar, e<Bitmap> eVar, e<Bitmap> eVar2, com.tencent.mm.loader.c.e eVar3, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        j.p(aVar, "url");
        j.p(fVar, "httpResponse");
        j.p(eVar, "source");
        j.p(eVar3, "opts");
        j.p(fVar2, "reaper");
        return true;
    }

    public final boolean a(com.tencent.mm.loader.h.a.a<String> aVar, com.tencent.mm.loader.h.f<?> fVar, com.tencent.mm.loader.c.e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        j.p(aVar, "url");
        j.p(fVar, "httpResponse");
        j.p(eVar, "opts");
        j.p(fVar2, "reaper");
        return true;
    }

    public final boolean b(com.tencent.mm.loader.h.a.a<String> aVar, com.tencent.mm.loader.c.e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        j.p(aVar, "url");
        j.p(eVar, "opts");
        j.p(fVar, "reaper");
        return true;
    }

    public final String a(com.tencent.mm.loader.h.a.a<String> aVar, com.tencent.mm.loader.c.e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
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

    public final com.tencent.mm.loader.h.b.a c(com.tencent.mm.loader.h.a.a<String> aVar, com.tencent.mm.loader.c.e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        Object obj = null;
        j.p(aVar, "url");
        j.p(eVar, "opts");
        j.p(fVar, "reaper");
        try {
            if (aVar.Uf() == com.tencent.mm.loader.h.a.b.ASSET_DATA) {
                return com.tencent.mm.loader.h.b.a.lU(aVar.Uh());
            }
            if (aVar.Uf() == com.tencent.mm.loader.h.a.b.LOCAL_PATH) {
                return com.tencent.mm.loader.h.b.a.i(aVar.Uh(), com.tencent.mm.vending.j.a.cW(aVar.Uh()));
            }
            try {
                SFSContext TF = eVar.TF();
                String a;
                CharSequence charSequence;
                if (TF != null) {
                    a = a(aVar, eVar, fVar);
                    charSequence = a;
                    if (charSequence == null || charSequence.length() == 0) {
                        obj = 1;
                    }
                    return obj != null ? null : com.tencent.mm.loader.h.b.a.a(TF.openRead(a), TF.openRead(a));
                } else {
                    StringBuilder append;
                    f fVar2;
                    a = eVar.Tv();
                    if (a == null || a.length() == 0) {
                        a = eVar.Tw();
                        if (!(a == null || a.length() == 0)) {
                            append = new StringBuilder().append(a).append("/");
                            fVar2 = this.ePi;
                            if (fVar2 == null) {
                                j.dWJ();
                            }
                            a = append.append(fVar2.b(aVar)).toString();
                        }
                    }
                    if (eVar.Tu() && bo.isNullOrNil(r2)) {
                        append = new StringBuilder().append(com.tencent.mm.loader.l.b.Ur()).append("/");
                        fVar2 = this.ePi;
                        if (fVar2 == null) {
                            j.dWJ();
                        }
                        a = append.append(fVar2.b(aVar)).toString();
                    }
                    if (a == null || a.length() == 0) {
                        a = null;
                    }
                    charSequence = a;
                    Object obj2 = (charSequence == null || charSequence.length() == 0) ? 1 : null;
                    return obj2 != null ? null : com.tencent.mm.loader.h.b.a.a((InputStream) new d(a), (InputStream) new d(a));
                }
            } catch (FileNotFoundException e) {
                return null;
            }
        } catch (Exception e2) {
        }
    }
}
