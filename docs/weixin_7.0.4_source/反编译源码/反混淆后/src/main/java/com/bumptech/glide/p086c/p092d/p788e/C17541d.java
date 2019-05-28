package com.bumptech.glide.p086c.p092d.p788e;

import android.util.Log;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31969l;
import com.bumptech.glide.p086c.C44994c;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p095h.C31973a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bumptech.glide.c.d.e.d */
public final class C17541d implements C31969l<C37186c> {
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo2227a(Object obj, File file, C31967j c31967j) {
        AppMethodBeat.m2504i(92333);
        boolean a = C17541d.m27387a((C17526u) obj, file);
        AppMethodBeat.m2505o(92333);
        return a;
    }

    /* renamed from: b */
    public final C44994c mo2228b(C31967j c31967j) {
        return C44994c.SOURCE;
    }

    /* renamed from: a */
    private static boolean m27387a(C17526u<C37186c> c17526u, File file) {
        boolean z;
        AppMethodBeat.m2504i(92332);
        try {
            C31973a.m51949b(((C37186c) c17526u.get()).getBuffer(), file);
            z = true;
        } catch (IOException e) {
            Log.isLoggable("GifEncoder", 5);
            z = false;
        }
        AppMethodBeat.m2505o(92332);
        return z;
    }
}
