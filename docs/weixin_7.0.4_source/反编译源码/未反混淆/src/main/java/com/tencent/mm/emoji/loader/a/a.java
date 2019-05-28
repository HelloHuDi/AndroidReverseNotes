package com.tencent.mm.emoji.loader.a;

import a.l;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"})
public final class a {
    private static final String TAG = TAG;
    private static final ae<String, WeakReference<Drawable>> exy = new ae(20);
    public static final a exz = new a();

    static {
        AppMethodBeat.i(63167);
        AppMethodBeat.o(63167);
    }

    private a() {
    }

    public static Drawable kQ(String str) {
        AppMethodBeat.i(63165);
        ab.i(TAG, "get ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(63165);
            return null;
        }
        WeakReference weakReference = (WeakReference) exy.get(str);
        if (weakReference != null) {
            Drawable drawable = (Drawable) weakReference.get();
            AppMethodBeat.o(63165);
            return drawable;
        }
        AppMethodBeat.o(63165);
        return null;
    }

    public static void b(String str, Drawable drawable) {
        AppMethodBeat.i(63166);
        ab.i(TAG, "put ".concat(String.valueOf(str)));
        if (str != null) {
            if (drawable != null) {
                exy.put(str, new WeakReference(drawable));
                AppMethodBeat.o(63166);
                return;
            }
            exy.remove(str);
        }
        AppMethodBeat.o(63166);
    }
}
