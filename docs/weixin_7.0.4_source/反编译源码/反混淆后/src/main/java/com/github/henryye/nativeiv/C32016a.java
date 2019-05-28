package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.github.henryye.nativeiv.C0820b.C0821b;
import com.github.henryye.nativeiv.C0820b.C0822a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.C37223c;
import com.github.henryye.nativeiv.bitmap.C45014b;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.github.henryye.nativeiv.a */
public final class C32016a {
    public Map<BitmapType, C45014b> aLP = new HashMap(2);
    public SparseArray<Map<BitmapType, C45014b>> aLQ = new SparseArray();

    /* renamed from: com.github.henryye.nativeiv.a$2 */
    class C86352 implements C45014b<Bitmap> {
        C86352() {
        }

        /* renamed from: pz */
        public final IBitmap<Bitmap> mo2519pz() {
            AppMethodBeat.m2504i(115740);
            LegacyBitmap legacyBitmap = new LegacyBitmap();
            AppMethodBeat.m2505o(115740);
            return legacyBitmap;
        }

        /* renamed from: a */
        public final boolean mo2517a(C37223c c37223c) {
            return true;
        }

        public final void destroy() {
        }
    }

    /* renamed from: com.github.henryye.nativeiv.a$1 */
    class C255021 implements C45014b {
        C255021() {
        }

        /* renamed from: pz */
        public final IBitmap mo2519pz() {
            AppMethodBeat.m2504i(115739);
            C0821b c0821b = new C0821b();
            AppMethodBeat.m2505o(115739);
            return c0821b;
        }

        /* renamed from: a */
        public final boolean mo2517a(C37223c c37223c) {
            return false;
        }

        public final void destroy() {
        }
    }

    /* renamed from: com.github.henryye.nativeiv.a$3 */
    class C255033 implements C45014b {
        C255033() {
        }

        /* renamed from: pz */
        public final IBitmap mo2519pz() {
            AppMethodBeat.m2504i(115741);
            C0822a c0822a = new C0822a();
            AppMethodBeat.m2505o(115741);
            return c0822a;
        }

        /* renamed from: a */
        public final boolean mo2517a(C37223c c37223c) {
            return true;
        }

        public final void destroy() {
        }
    }

    public C32016a() {
        AppMethodBeat.m2504i(115742);
        this.aLP.put(BitmapType.Native, new C255021());
        this.aLP.put(BitmapType.Legacy, new C86352());
        this.aLP.put(BitmapType.Undefined, new C255033());
        AppMethodBeat.m2505o(115742);
    }

    /* renamed from: b */
    public static void m51988b(Map<BitmapType, C45014b> map) {
        AppMethodBeat.m2504i(115743);
        if (map == null) {
            AppMethodBeat.m2505o(115743);
            return;
        }
        for (C45014b destroy : map.values()) {
            destroy.destroy();
        }
        AppMethodBeat.m2505o(115743);
    }

    /* renamed from: a */
    public static IBitmap m51987a(C37223c c37223c, Map<BitmapType, C45014b> map) {
        AppMethodBeat.m2504i(115744);
        IBitmap pz;
        if (((C45014b) map.get(BitmapType.Native)).mo2517a(c37223c)) {
            pz = ((C45014b) map.get(BitmapType.Native)).mo2519pz();
            AppMethodBeat.m2505o(115744);
            return pz;
        } else if (((C45014b) map.get(BitmapType.Legacy)).mo2517a(c37223c)) {
            pz = ((C45014b) map.get(BitmapType.Legacy)).mo2519pz();
            AppMethodBeat.m2505o(115744);
            return pz;
        } else {
            pz = ((C45014b) map.get(BitmapType.Undefined)).mo2519pz();
            AppMethodBeat.m2505o(115744);
            return pz;
        }
    }
}
