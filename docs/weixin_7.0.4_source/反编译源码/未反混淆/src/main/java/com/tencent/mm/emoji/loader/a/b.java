package com.tencent.mm.emoji.loader.a;

import a.l;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\t\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/graphics/Bitmap;", "get", "key", "put", "", "bitmap", "plugin-emojisdk_release"})
public final class b {
    private static final h<String, Bitmap> exA = new h(60);
    public static final b exB = new b();

    static {
        AppMethodBeat.i(63170);
        AppMethodBeat.o(63170);
    }

    private b() {
    }

    public static Bitmap kR(String str) {
        AppMethodBeat.i(63168);
        ab.i(c.TAG, "get: ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(63168);
            return null;
        }
        Bitmap bitmap = (Bitmap) exA.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(63168);
            return null;
        }
        AppMethodBeat.o(63168);
        return bitmap;
    }

    public static void c(String str, Bitmap bitmap) {
        AppMethodBeat.i(63169);
        ab.i(c.TAG, "put: " + str + ", " + bitmap);
        if (str != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                exA.remove(str);
            } else {
                exA.put(str, bitmap);
                AppMethodBeat.o(63169);
                return;
            }
        }
        AppMethodBeat.o(63169);
    }
}
