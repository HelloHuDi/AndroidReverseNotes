package com.tencent.p177mm.loader.p858b.p859a;

import android.graphics.Bitmap;
import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p1197h.C42162f;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.loader.p863f.C32733f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.Closeable;
import java.io.OutputStream;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;
import p000a.p1582e.C41372b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J0\u0010\u000f\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J0\u0010\u0011\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016JZ\u0010\u0012\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "T", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "exists", "save", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "Companion", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.b.a.a */
public abstract class C37877a<T> extends C26352d<T, Bitmap> {
    private static final String TAG = TAG;
    public static final C32723a ePj = new C32723a();
    private C32733f ePi;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.b.a.a$a */
    public static final class C32723a {
        private C32723a() {
        }

        public /* synthetic */ C32723a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final boolean mo44152a(C42156a<T> c42156a, C42162f<?> c42162f, C42161e<Bitmap> c42161e, C42161e<Bitmap> c42161e2, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        Closeable closeable;
        Throwable th;
        Throwable th2 = null;
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c42162f, "httpResponse");
        C25052j.m39376p(c42161e, "source");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        mo37767a(c42156a, c42162f, c37878e, c45421f);
        String a = mo37766a(c42156a, c37878e, c45421f);
        C4990ab.m7416i(TAG, "save " + c42156a + " filePath " + a);
        C9564c c9564c = C9564c.ePl;
        OutputStream a2 = C9564c.m17032a(a, c37878e.mo60617TF());
        if (a2 != null) {
            closeable = a2;
            boolean z = false;
            if (c42161e2 != null) {
                try {
                    C9564c c9564c2 = C9564c.ePl;
                    Object value = c42161e2.value();
                    C25052j.m39375o(value, "it.value()");
                    C9564c.m17033a((Bitmap) value, a2);
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                }
            }
            if (!z) {
                c42162f.mo33801a(a2);
            }
            mo37768b(c42156a, c37878e, c45421f);
            C37091y c37091y = C37091y.AUy;
            C41372b.m72155a(closeable, null);
        }
        return true;
        C41372b.m72155a(closeable, th2);
        throw th;
    }

    /* renamed from: a */
    public String mo37766a(C42156a<T> c42156a, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        String Tx = c37878e.mo60625Tx();
        if (Tx == null || Tx.length() == 0) {
            String Tv = c37878e.mo60623Tv();
            if (Tv != null && Tv.length() > 0) {
                Tx = c37878e.mo60624Tw();
                if (Tx == null || Tx.length() == 0 || !C6163u.m9839jb(Tv, Tx)) {
                    C4990ab.m7413e(TAG, "[johnw] SFS can't deal with absolute path: %s", Tv);
                    throw new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(Tv)));
                }
                Tx = Tv.substring(Tx.length());
                C25052j.m39375o(Tx, "(this as java.lang.String).substring(startIndex)");
                if (C6163u.m9839jb(Tx, "/")) {
                    if (Tx == null) {
                        throw new C44941v("null cannot be cast to non-null type java.lang.String");
                    }
                    Tx = Tx.substring(1);
                    C25052j.m39375o(Tx, "(this as java.lang.String).substring(startIndex)");
                }
            }
        }
        if (Tx == null || Tx.length() == 0) {
            C32733f c32733f = this.ePi;
            if (c32733f == null) {
                C25052j.dWJ();
            }
            Tx = c32733f.mo53285b(c42156a);
        }
        return (Tx == null || Tx.length() == 0) ? "" : Tx;
    }
}
