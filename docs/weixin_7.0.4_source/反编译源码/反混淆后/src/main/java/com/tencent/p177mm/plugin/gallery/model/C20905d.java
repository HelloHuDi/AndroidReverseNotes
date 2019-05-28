package com.tencent.p177mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1174a;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.gallery.model.d */
public final class C20905d {
    C4934l<C20907b, String> fry = new C120771();
    Vector<C20907b> ghp = new Vector();
    C1177f<String, C20906a> mNF = new C26399b(100, new C120793(), getClass());
    C20908f mNG;
    private final C20907b mNH = new C120782();

    /* renamed from: com.tencent.mm.plugin.gallery.model.d$1 */
    class C120771 extends C4934l<C20907b, String> {
        C120771() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(21240);
            ((C20907b) obj).mo23913NA((String) obj2);
            AppMethodBeat.m2505o(21240);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.d$2 */
    class C120782 implements C20907b {
        C120782() {
        }

        /* renamed from: NA */
        public final void mo23913NA(String str) {
            AppMethodBeat.m2504i(21241);
            C4990ab.m7416i("MicroMsg.GalleryCache", "now listener size : " + C20905d.this.ghp.size());
            for (int size = C20905d.this.ghp.size() - 1; size >= 0; size--) {
                C20907b c20907b;
                try {
                    c20907b = (C20907b) C20905d.this.ghp.get(size);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.GalleryCache", "get wathcer failed:[%s] filePath:%s", e.toString(), str);
                    c20907b = null;
                }
                if (c20907b == null) {
                    C4990ab.m7411d("MicroMsg.GalleryCache", "get listener is null! filePath:%s", str);
                } else {
                    c20907b.mo23913NA(str);
                }
            }
            AppMethodBeat.m2505o(21241);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.d$3 */
    class C120793 implements C1175b<String, C20906a> {
        C120793() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(21242);
            String str = (String) obj;
            C20906a c20906a = (C20906a) obj2;
            if (c20906a == null) {
                C4990ab.m7410d("MicroMsg.GalleryCache", "weakReference is null");
                AppMethodBeat.m2505o(21242);
            } else if (c20906a.bitmap == null) {
                C4990ab.m7410d("MicroMsg.GalleryCache", "weakReference getbitmap is null");
                AppMethodBeat.m2505o(21242);
            } else {
                C4990ab.m7417i("MicroMsg.GalleryCache", "bitmap recycle %s", c20906a.bitmap.toString());
                c20906a.bitmap.recycle();
                C4990ab.m7411d("MicroMsg.GalleryCache", "gallery remove ", str);
                AppMethodBeat.m2505o(21242);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.d$4 */
    class C120804 implements C1174a<String, C20906a> {
        C120804() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.d$a */
    class C20906a {
        Bitmap bitmap;
        private int type;

        public C20906a(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.type = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.d$b */
    public interface C20907b {
        /* renamed from: NA */
        void mo23913NA(String str);
    }

    public C20905d() {
        AppMethodBeat.m2504i(21243);
        C20908f c20908f = new C20908f(new File(C6457e.eSn + "/diskcache"));
        c20908f.mNZ = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
        c20908f.bCh();
        c20908f.mo36228wl(-1);
        this.mNG = c20908f;
        this.fry.mo10125a(this.mNH, null);
        AppMethodBeat.m2505o(21243);
    }

    public final Bitmap getBitmap(String str) {
        AppMethodBeat.m2504i(21244);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GalleryCache", "null filepath");
            AppMethodBeat.m2505o(21244);
            return null;
        } else if (this.mNF == null) {
            C4990ab.m7420w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
            AppMethodBeat.m2505o(21244);
            return null;
        } else {
            if (this.mNF.mo4405aj(str)) {
                C20906a c20906a = (C20906a) this.mNF.mo4404ai(str);
                if (c20906a == null) {
                    C4990ab.m7411d("MicroMsg.GalleryCache", "weakreference is null! %s", str);
                    this.mNF.remove(str);
                    AppMethodBeat.m2505o(21244);
                    return null;
                }
                Bitmap bitmap = c20906a.bitmap;
                if (bitmap == null) {
                    this.mNF.remove(str);
                    C4990ab.m7417i("MicroMsg.GalleryCache", "get bitmap is null! %s", str);
                } else if (bitmap.isRecycled()) {
                    C4990ab.m7417i("MicroMsg.GalleryCache", "cahce bitmap has recycled: %s", str);
                    this.mNF.remove(str);
                    AppMethodBeat.m2505o(21244);
                    return null;
                } else {
                    C4990ab.m7416i("MicroMsg.GalleryCache", "get cached bitmap:".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(21244);
                    return bitmap;
                }
            }
            AppMethodBeat.m2505o(21244);
            return null;
        }
    }
}
