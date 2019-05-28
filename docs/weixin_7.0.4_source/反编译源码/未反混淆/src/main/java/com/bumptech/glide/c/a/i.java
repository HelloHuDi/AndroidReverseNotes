package com.bumptech.glide.c.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;

public final class i extends l<ParcelFileDescriptor> {
    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void R(Object obj) {
        AppMethodBeat.i(91718);
        ((ParcelFileDescriptor) obj).close();
        AppMethodBeat.o(91718);
    }

    public i(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final Class<ParcelFileDescriptor> mg() {
        return ParcelFileDescriptor.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object a(Uri uri, ContentResolver contentResolver) {
        AppMethodBeat.i(91719);
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("FileDescriptor is null for: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(91719);
            throw fileNotFoundException;
        }
        ParcelFileDescriptor parcelFileDescriptor = openAssetFileDescriptor.getParcelFileDescriptor();
        AppMethodBeat.o(91719);
        return parcelFileDescriptor;
    }
}
