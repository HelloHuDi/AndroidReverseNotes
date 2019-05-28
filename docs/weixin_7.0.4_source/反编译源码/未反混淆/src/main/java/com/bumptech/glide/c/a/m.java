package com.bumptech.glide.c.a;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class m extends b<InputStream> {
    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void R(Object obj) {
        AppMethodBeat.i(91729);
        ((InputStream) obj).close();
        AppMethodBeat.o(91729);
    }

    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public final Class<InputStream> mg() {
        return InputStream.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object a(AssetManager assetManager, String str) {
        AppMethodBeat.i(91730);
        InputStream open = assetManager.open(str);
        AppMethodBeat.o(91730);
        return open;
    }
}
