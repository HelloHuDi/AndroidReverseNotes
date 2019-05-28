package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Vector;

public final class d {
    l<b, String> fry = new l<b, String>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(21240);
            ((b) obj).NA((String) obj2);
            AppMethodBeat.o(21240);
        }
    };
    Vector<b> ghp = new Vector();
    f<String, a> mNF = new com.tencent.mm.memory.a.b(100, new com.tencent.mm.a.f.b<String, a>() {
        public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(21242);
            String str = (String) obj;
            a aVar = (a) obj2;
            if (aVar == null) {
                ab.d("MicroMsg.GalleryCache", "weakReference is null");
                AppMethodBeat.o(21242);
            } else if (aVar.bitmap == null) {
                ab.d("MicroMsg.GalleryCache", "weakReference getbitmap is null");
                AppMethodBeat.o(21242);
            } else {
                ab.i("MicroMsg.GalleryCache", "bitmap recycle %s", aVar.bitmap.toString());
                aVar.bitmap.recycle();
                ab.d("MicroMsg.GalleryCache", "gallery remove ", str);
                AppMethodBeat.o(21242);
            }
        }
    }, getClass());
    f mNG;
    private final b mNH = new b() {
        public final void NA(String str) {
            AppMethodBeat.i(21241);
            ab.i("MicroMsg.GalleryCache", "now listener size : " + d.this.ghp.size());
            for (int size = d.this.ghp.size() - 1; size >= 0; size--) {
                b bVar;
                try {
                    bVar = (b) d.this.ghp.get(size);
                } catch (Exception e) {
                    ab.e("MicroMsg.GalleryCache", "get wathcer failed:[%s] filePath:%s", e.toString(), str);
                    bVar = null;
                }
                if (bVar == null) {
                    ab.d("MicroMsg.GalleryCache", "get listener is null! filePath:%s", str);
                } else {
                    bVar.NA(str);
                }
            }
            AppMethodBeat.o(21241);
        }
    };

    class a {
        Bitmap bitmap;
        private int type;

        public a(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.type = i;
        }
    }

    public interface b {
        void NA(String str);
    }

    public d() {
        AppMethodBeat.i(21243);
        f fVar = new f(new File(e.eSn + "/diskcache"));
        fVar.mNZ = ah.getContext().getSharedPreferences(ah.doA(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
        fVar.bCh();
        fVar.wl(-1);
        this.mNG = fVar;
        this.fry.a(this.mNH, null);
        AppMethodBeat.o(21243);
    }

    public final Bitmap getBitmap(String str) {
        AppMethodBeat.i(21244);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GalleryCache", "null filepath");
            AppMethodBeat.o(21244);
            return null;
        } else if (this.mNF == null) {
            ab.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
            AppMethodBeat.o(21244);
            return null;
        } else {
            if (this.mNF.aj(str)) {
                a aVar = (a) this.mNF.ai(str);
                if (aVar == null) {
                    ab.d("MicroMsg.GalleryCache", "weakreference is null! %s", str);
                    this.mNF.remove(str);
                    AppMethodBeat.o(21244);
                    return null;
                }
                Bitmap bitmap = aVar.bitmap;
                if (bitmap == null) {
                    this.mNF.remove(str);
                    ab.i("MicroMsg.GalleryCache", "get bitmap is null! %s", str);
                } else if (bitmap.isRecycled()) {
                    ab.i("MicroMsg.GalleryCache", "cahce bitmap has recycled: %s", str);
                    this.mNF.remove(str);
                    AppMethodBeat.o(21244);
                    return null;
                } else {
                    ab.i("MicroMsg.GalleryCache", "get cached bitmap:".concat(String.valueOf(str)));
                    AppMethodBeat.o(21244);
                    return bitmap;
                }
            }
            AppMethodBeat.o(21244);
            return null;
        }
    }
}
