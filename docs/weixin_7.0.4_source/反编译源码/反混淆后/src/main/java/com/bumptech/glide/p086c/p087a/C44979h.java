package com.bumptech.glide.p086c.p087a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.a.h */
public final class C44979h extends C37159b<ParcelFileDescriptor> {
    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: R */
    public final /* synthetic */ void mo18606R(Object obj) {
        AppMethodBeat.m2504i(91716);
        ((ParcelFileDescriptor) obj).close();
        AppMethodBeat.m2505o(91716);
    }

    public C44979h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* renamed from: mg */
    public final Class<ParcelFileDescriptor> mo2187mg() {
        return ParcelFileDescriptor.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Object mo18607a(AssetManager assetManager, String str) {
        AppMethodBeat.m2504i(91717);
        ParcelFileDescriptor parcelFileDescriptor = assetManager.openFd(str).getParcelFileDescriptor();
        AppMethodBeat.m2505o(91717);
        return parcelFileDescriptor;
    }
}
