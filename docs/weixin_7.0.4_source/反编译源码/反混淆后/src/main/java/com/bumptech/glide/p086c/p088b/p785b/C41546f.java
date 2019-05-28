package com.bumptech.glide.p086c.p088b.p785b;

import android.content.Context;
import com.bumptech.glide.p086c.p088b.p785b.C41190d.C17518a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.bumptech.glide.c.b.b.f */
public final class C41546f extends C41190d {
    public C41546f(Context context) {
        this(context, "image_manager_disk_cache");
    }

    private C41546f(final Context context, final String str) {
        super(new C17518a() {
            /* renamed from: mW */
            public final File mo31949mW() {
                AppMethodBeat.m2504i(91985);
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    AppMethodBeat.m2505o(91985);
                    return null;
                } else if (str != null) {
                    File file = new File(cacheDir, str);
                    AppMethodBeat.m2505o(91985);
                    return file;
                } else {
                    AppMethodBeat.m2505o(91985);
                    return cacheDir;
                }
            }
        });
        AppMethodBeat.m2504i(91986);
        AppMethodBeat.m2505o(91986);
    }
}
