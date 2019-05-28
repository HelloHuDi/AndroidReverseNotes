package com.bumptech.glide.p086c.p087a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;

/* renamed from: com.bumptech.glide.c.a.i */
public final class C37160i extends C25404l<ParcelFileDescriptor> {
    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: R */
    public final /* synthetic */ void mo42446R(Object obj) {
        AppMethodBeat.m2504i(91718);
        ((ParcelFileDescriptor) obj).close();
        AppMethodBeat.m2505o(91718);
    }

    public C37160i(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* renamed from: mg */
    public final Class<ParcelFileDescriptor> mo2187mg() {
        return ParcelFileDescriptor.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Object mo42447a(Uri uri, ContentResolver contentResolver) {
        AppMethodBeat.m2504i(91719);
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("FileDescriptor is null for: ".concat(String.valueOf(uri)));
            AppMethodBeat.m2505o(91719);
            throw fileNotFoundException;
        }
        ParcelFileDescriptor parcelFileDescriptor = openAssetFileDescriptor.getParcelFileDescriptor();
        AppMethodBeat.m2505o(91719);
        return parcelFileDescriptor;
    }
}
