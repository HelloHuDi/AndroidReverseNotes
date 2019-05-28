package com.bumptech.glide.p086c.p087a;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.a.m */
public final class C8514m extends C37159b<InputStream> {
    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: R */
    public final /* synthetic */ void mo18606R(Object obj) {
        AppMethodBeat.m2504i(91729);
        ((InputStream) obj).close();
        AppMethodBeat.m2505o(91729);
    }

    public C8514m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* renamed from: mg */
    public final Class<InputStream> mo2187mg() {
        return InputStream.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Object mo18607a(AssetManager assetManager, String str) {
        AppMethodBeat.m2504i(91730);
        InputStream open = assetManager.open(str);
        AppMethodBeat.m2505o(91730);
        return open;
    }
}
