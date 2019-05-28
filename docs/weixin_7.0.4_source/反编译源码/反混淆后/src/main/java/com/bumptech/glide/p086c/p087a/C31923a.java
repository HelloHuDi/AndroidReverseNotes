package com.bumptech.glide.p086c.p087a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;

/* renamed from: com.bumptech.glide.c.a.a */
public final class C31923a extends C25404l<AssetFileDescriptor> {
    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: R */
    public final /* synthetic */ void mo42446R(Object obj) {
        AppMethodBeat.m2504i(91694);
        ((AssetFileDescriptor) obj).close();
        AppMethodBeat.m2505o(91694);
    }

    public C31923a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* renamed from: mg */
    public final Class<AssetFileDescriptor> mo2187mg() {
        return AssetFileDescriptor.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Object mo42447a(Uri uri, ContentResolver contentResolver) {
        AppMethodBeat.m2504i(91695);
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("FileDescriptor is null for: ".concat(String.valueOf(uri)));
            AppMethodBeat.m2505o(91695);
            throw fileNotFoundException;
        }
        AppMethodBeat.m2505o(91695);
        return openAssetFileDescriptor;
    }
}
