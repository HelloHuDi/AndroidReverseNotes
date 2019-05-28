package com.tencent.p177mm.loader.p858b.p859a;

import android.graphics.Bitmap;
import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p1197h.C42162f;
import com.tencent.p177mm.loader.p1197h.p1198a.C18543b;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p1197h.p1199b.C18545a;
import com.tencent.p177mm.loader.p1201l.C18558b;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.loader.p863f.C32733f;
import com.tencent.p177mm.modelsfs.SFSContext;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vfs.C40922d;
import java.io.FileNotFoundException;
import java.io.InputStream;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J0\u0010\u0010\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J0\u0010\u0012\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J3\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0002J2\u0010\u0015\u001a\u0004\u0018\u00010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0002J@\u0010\u0016\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016JL\u0010\u0019\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016JZ\u0010\u001d\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, dWq = {"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache;", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "clear", "", "delete", "", "exists", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "getGeneralFilePathFromOptions", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.b.a.b */
public final class C45417b extends C26352d<String, Bitmap> {
    private static final String TAG = TAG;
    public static final C42152a ePk = new C42152a();
    private C32733f ePi;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.b.a.b$a */
    public static final class C42152a {
        private C42152a() {
        }

        public /* synthetic */ C42152a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final boolean mo44152a(C42156a<String> c42156a, C42162f<?> c42162f, C42161e<Bitmap> c42161e, C42161e<Bitmap> c42161e2, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c42162f, "httpResponse");
        C25052j.m39376p(c42161e, "source");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        return true;
    }

    /* renamed from: a */
    public final boolean mo37767a(C42156a<String> c42156a, C42162f<?> c42162f, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c42162f, "httpResponse");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        return true;
    }

    /* renamed from: b */
    public final boolean mo37768b(C42156a<String> c42156a, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        return true;
    }

    /* renamed from: a */
    public final String mo37766a(C42156a<String> c42156a, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
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

    /* renamed from: c */
    public final C18545a mo37769c(C42156a<String> c42156a, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        Object obj = null;
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        try {
            if (c42156a.mo67692Uf() == C18543b.ASSET_DATA) {
                return C18545a.m28858lU(c42156a.mo67694Uh());
            }
            if (c42156a.mo67692Uf() == C18543b.LOCAL_PATH) {
                return C18545a.m28856i(c42156a.mo67694Uh(), C5710a.m8576cW(c42156a.mo67694Uh()));
            }
            try {
                SFSContext TF = c37878e.mo60617TF();
                String a;
                CharSequence charSequence;
                if (TF != null) {
                    a = mo37766a(c42156a, c37878e, c45421f);
                    charSequence = a;
                    if (charSequence == null || charSequence.length() == 0) {
                        obj = 1;
                    }
                    return obj != null ? null : C18545a.m28855a(TF.openRead(a), TF.openRead(a));
                } else {
                    StringBuilder append;
                    C32733f c32733f;
                    a = c37878e.mo60623Tv();
                    if (a == null || a.length() == 0) {
                        a = c37878e.mo60624Tw();
                        if (!(a == null || a.length() == 0)) {
                            append = new StringBuilder().append(a).append("/");
                            c32733f = this.ePi;
                            if (c32733f == null) {
                                C25052j.dWJ();
                            }
                            a = append.append(c32733f.mo53285b(c42156a)).toString();
                        }
                    }
                    if (c37878e.mo60622Tu() && C5046bo.isNullOrNil(r2)) {
                        append = new StringBuilder().append(C18558b.m28879Ur()).append("/");
                        c32733f = this.ePi;
                        if (c32733f == null) {
                            C25052j.dWJ();
                        }
                        a = append.append(c32733f.mo53285b(c42156a)).toString();
                    }
                    if (a == null || a.length() == 0) {
                        a = null;
                    }
                    charSequence = a;
                    Object obj2 = (charSequence == null || charSequence.length() == 0) ? 1 : null;
                    return obj2 != null ? null : C18545a.m28855a((InputStream) new C40922d(a), (InputStream) new C40922d(a));
                }
            } catch (FileNotFoundException e) {
                return null;
            }
        } catch (Exception e2) {
        }
    }
}
