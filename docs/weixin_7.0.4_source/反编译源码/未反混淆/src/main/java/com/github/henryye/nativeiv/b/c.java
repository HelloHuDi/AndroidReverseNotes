package com.github.henryye.nativeiv.b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.github.henryye.nativeiv.bitmap.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static final Map<String, com.github.henryye.nativeiv.bitmap.c> aMq;

    static {
        AppMethodBeat.i(115776);
        HashMap hashMap = new HashMap(6);
        aMq = hashMap;
        hashMap.put("image/jpeg", com.github.henryye.nativeiv.bitmap.c.JPG);
        aMq.put("image/gif", com.github.henryye.nativeiv.bitmap.c.GIF);
        aMq.put("image/png", com.github.henryye.nativeiv.bitmap.c.PNG);
        aMq.put("image/x-ms-bmp", com.github.henryye.nativeiv.bitmap.c.BMP);
        aMq.put("image/bmp", com.github.henryye.nativeiv.bitmap.c.BMP);
        aMq.put("image/webp", com.github.henryye.nativeiv.bitmap.c.WEBP);
        AppMethodBeat.o(115776);
    }

    public static d g(InputStream inputStream) {
        AppMethodBeat.i(115775);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        InputStream h = d.h(inputStream);
        d.i(h);
        BitmapFactory.decodeStream(h, null, options);
        com.github.henryye.nativeiv.bitmap.c cVar = (com.github.henryye.nativeiv.bitmap.c) aMq.get(options.outMimeType);
        if (cVar == null) {
            cVar = com.github.henryye.nativeiv.bitmap.c.UNKNOWN;
        }
        try {
            h.reset();
        } catch (IOException e) {
            com.tencent.magicbrush.a.c.c.a("Ni.FormatUtil", e, "hy: the given stream is markable, but still reset error. should not forward", new Object[0]);
            cVar = com.github.henryye.nativeiv.bitmap.c.UNKNOWN;
        }
        d dVar = new d();
        dVar.aMl = cVar;
        dVar.aMn = (long) options.outHeight;
        dVar.aMm = (long) options.outWidth;
        AppMethodBeat.o(115775);
        return dVar;
    }
}
