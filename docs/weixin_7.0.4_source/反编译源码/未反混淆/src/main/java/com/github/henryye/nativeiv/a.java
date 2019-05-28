package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.b;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public Map<BitmapType, b> aLP = new HashMap(2);
    public SparseArray<Map<BitmapType, b>> aLQ = new SparseArray();

    public a() {
        AppMethodBeat.i(115742);
        this.aLP.put(BitmapType.Native, new b() {
            public final IBitmap pz() {
                AppMethodBeat.i(115739);
                b bVar = new b();
                AppMethodBeat.o(115739);
                return bVar;
            }

            public final boolean a(c cVar) {
                return false;
            }

            public final void destroy() {
            }
        });
        this.aLP.put(BitmapType.Legacy, new b<Bitmap>() {
            public final IBitmap<Bitmap> pz() {
                AppMethodBeat.i(115740);
                LegacyBitmap legacyBitmap = new LegacyBitmap();
                AppMethodBeat.o(115740);
                return legacyBitmap;
            }

            public final boolean a(c cVar) {
                return true;
            }

            public final void destroy() {
            }
        });
        this.aLP.put(BitmapType.Undefined, new b() {
            public final IBitmap pz() {
                AppMethodBeat.i(115741);
                a aVar = new a();
                AppMethodBeat.o(115741);
                return aVar;
            }

            public final boolean a(c cVar) {
                return true;
            }

            public final void destroy() {
            }
        });
        AppMethodBeat.o(115742);
    }

    public static void b(Map<BitmapType, b> map) {
        AppMethodBeat.i(115743);
        if (map == null) {
            AppMethodBeat.o(115743);
            return;
        }
        for (b destroy : map.values()) {
            destroy.destroy();
        }
        AppMethodBeat.o(115743);
    }

    public static IBitmap a(c cVar, Map<BitmapType, b> map) {
        AppMethodBeat.i(115744);
        IBitmap pz;
        if (((b) map.get(BitmapType.Native)).a(cVar)) {
            pz = ((b) map.get(BitmapType.Native)).pz();
            AppMethodBeat.o(115744);
            return pz;
        } else if (((b) map.get(BitmapType.Legacy)).a(cVar)) {
            pz = ((b) map.get(BitmapType.Legacy)).pz();
            AppMethodBeat.o(115744);
            return pz;
        } else {
            pz = ((b) map.get(BitmapType.Undefined)).pz();
            AppMethodBeat.o(115744);
            return pz;
        }
    }
}
