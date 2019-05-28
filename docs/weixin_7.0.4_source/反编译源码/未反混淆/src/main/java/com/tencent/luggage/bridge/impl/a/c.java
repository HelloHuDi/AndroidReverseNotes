package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends a {
    public boolean match(String str) {
        AppMethodBeat.i(90767);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(90767);
            return false;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) {
            AppMethodBeat.o(90767);
            return true;
        }
        AppMethodBeat.o(90767);
        return false;
    }

    public Bitmap b(String str, Rect rect, com.tencent.mm.plugin.appbrand.d.a.c cVar) {
        return null;
    }

    public final String wP() {
        return "NetworkImageReader";
    }
}
