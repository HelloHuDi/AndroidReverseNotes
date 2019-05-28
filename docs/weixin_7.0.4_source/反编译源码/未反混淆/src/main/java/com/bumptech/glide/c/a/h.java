package com.bumptech.glide.c.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends b<ParcelFileDescriptor> {
    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void R(Object obj) {
        AppMethodBeat.i(91716);
        ((ParcelFileDescriptor) obj).close();
        AppMethodBeat.o(91716);
    }

    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public final Class<ParcelFileDescriptor> mg() {
        return ParcelFileDescriptor.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object a(AssetManager assetManager, String str) {
        AppMethodBeat.i(91717);
        ParcelFileDescriptor parcelFileDescriptor = assetManager.openFd(str).getParcelFileDescriptor();
        AppMethodBeat.o(91717);
        return parcelFileDescriptor;
    }
}
