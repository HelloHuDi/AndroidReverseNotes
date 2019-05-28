package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.p086c.p088b.C31941j;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p791f.C41570e;
import com.bumptech.glide.p791f.p1156a.C41569b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.bumptech.glide.e */
public final class C37191e extends ContextWrapper {
    static final C25465k<?, ?> awz = new C17513b();
    private final Handler awA = new Handler(Looper.getMainLooper());
    private final C41569b awB;
    final C31941j awe;
    public final C31976h awj;
    public final C8515b awk;
    final Map<Class<?>, C25465k<?, ?>> awp;
    public final int awu;
    final C41570e awv;

    static {
        AppMethodBeat.m2504i(91614);
        AppMethodBeat.m2505o(91614);
    }

    public C37191e(Context context, C8515b c8515b, C31976h c31976h, C41569b c41569b, C41570e c41570e, Map<Class<?>, C25465k<?, ?>> map, C31941j c31941j, int i) {
        super(context.getApplicationContext());
        AppMethodBeat.m2504i(91613);
        this.awk = c8515b;
        this.awj = c31976h;
        this.awB = c41569b;
        this.awv = c41570e;
        this.awp = map;
        this.awe = c31941j;
        this.awu = i;
        AppMethodBeat.m2505o(91613);
    }
}
