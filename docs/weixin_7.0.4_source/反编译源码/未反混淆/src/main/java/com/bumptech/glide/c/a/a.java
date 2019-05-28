package com.bumptech.glide.c.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;

public final class a extends l<AssetFileDescriptor> {
    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void R(Object obj) {
        AppMethodBeat.i(91694);
        ((AssetFileDescriptor) obj).close();
        AppMethodBeat.o(91694);
    }

    public a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final Class<AssetFileDescriptor> mg() {
        return AssetFileDescriptor.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object a(Uri uri, ContentResolver contentResolver) {
        AppMethodBeat.i(91695);
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("FileDescriptor is null for: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(91695);
            throw fileNotFoundException;
        }
        AppMethodBeat.o(91695);
        return openAssetFileDescriptor;
    }
}
