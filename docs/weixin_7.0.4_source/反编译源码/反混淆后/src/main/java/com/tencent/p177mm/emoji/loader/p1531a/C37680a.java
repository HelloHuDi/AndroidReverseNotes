package com.tencent.p177mm.emoji.loader.p1531a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import java.lang.ref.WeakReference;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.a.a */
public final class C37680a {
    private static final String TAG = TAG;
    private static final C4993ae<String, WeakReference<Drawable>> exy = new C4993ae(20);
    public static final C37680a exz = new C37680a();

    static {
        AppMethodBeat.m2504i(63167);
        AppMethodBeat.m2505o(63167);
    }

    private C37680a() {
    }

    /* renamed from: kQ */
    public static Drawable m63718kQ(String str) {
        AppMethodBeat.m2504i(63165);
        C4990ab.m7416i(TAG, "get ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.m2505o(63165);
            return null;
        }
        WeakReference weakReference = (WeakReference) exy.get(str);
        if (weakReference != null) {
            Drawable drawable = (Drawable) weakReference.get();
            AppMethodBeat.m2505o(63165);
            return drawable;
        }
        AppMethodBeat.m2505o(63165);
        return null;
    }

    /* renamed from: b */
    public static void m63717b(String str, Drawable drawable) {
        AppMethodBeat.m2504i(63166);
        C4990ab.m7416i(TAG, "put ".concat(String.valueOf(str)));
        if (str != null) {
            if (drawable != null) {
                exy.put(str, new WeakReference(drawable));
                AppMethodBeat.m2505o(63166);
                return;
            }
            exy.remove(str);
        }
        AppMethodBeat.m2505o(63166);
    }
}
