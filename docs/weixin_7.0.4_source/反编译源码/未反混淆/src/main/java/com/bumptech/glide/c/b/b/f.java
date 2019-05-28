package com.bumptech.glide.c.b.b;

import android.content.Context;
import com.bumptech.glide.c.b.b.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class f extends d {
    public f(Context context) {
        this(context, "image_manager_disk_cache");
    }

    private f(final Context context, final String str) {
        super(new a() {
            public final File mW() {
                AppMethodBeat.i(91985);
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    AppMethodBeat.o(91985);
                    return null;
                } else if (str != null) {
                    File file = new File(cacheDir, str);
                    AppMethodBeat.o(91985);
                    return file;
                } else {
                    AppMethodBeat.o(91985);
                    return cacheDir;
                }
            }
        });
        AppMethodBeat.i(91986);
        AppMethodBeat.o(91986);
    }
}
