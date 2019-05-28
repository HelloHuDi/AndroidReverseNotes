package com.tencent.mm.ui.e.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static b zxo = null;

    public static void a(b bVar) {
        zxo = bVar;
    }

    public static void b(ImageView imageView, String str) {
        AppMethodBeat.i(107321);
        if (zxo != null) {
            zxo.b(imageView, str);
        }
        AppMethodBeat.o(107321);
    }
}
