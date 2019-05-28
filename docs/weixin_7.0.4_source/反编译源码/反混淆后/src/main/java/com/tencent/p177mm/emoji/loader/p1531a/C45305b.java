package com.tencent.p177mm.emoji.loader.p1531a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\t\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/graphics/Bitmap;", "get", "key", "put", "", "bitmap", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.a.b */
public final class C45305b {
    private static final C6294h<String, Bitmap> exA = new C6294h(60);
    public static final C45305b exB = new C45305b();

    static {
        AppMethodBeat.m2504i(63170);
        AppMethodBeat.m2505o(63170);
    }

    private C45305b() {
    }

    /* renamed from: kR */
    public static Bitmap m83553kR(String str) {
        AppMethodBeat.m2504i(63168);
        C4990ab.m7416i(C37681c.TAG, "get: ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.m2505o(63168);
            return null;
        }
        Bitmap bitmap = (Bitmap) exA.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(63168);
            return null;
        }
        AppMethodBeat.m2505o(63168);
        return bitmap;
    }

    /* renamed from: c */
    public static void m83552c(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(63169);
        C4990ab.m7416i(C37681c.TAG, "put: " + str + ", " + bitmap);
        if (str != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                exA.remove(str);
            } else {
                exA.put(str, bitmap);
                AppMethodBeat.m2505o(63169);
                return;
            }
        }
        AppMethodBeat.m2505o(63169);
    }
}
