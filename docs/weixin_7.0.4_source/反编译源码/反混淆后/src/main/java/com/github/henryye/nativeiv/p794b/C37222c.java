package com.github.henryye.nativeiv.p794b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.github.henryye.nativeiv.bitmap.C25505d;
import com.github.henryye.nativeiv.bitmap.C37223c;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.github.henryye.nativeiv.b.c */
public final class C37222c {
    private static final Map<String, C37223c> aMq;

    static {
        AppMethodBeat.m2504i(115776);
        HashMap hashMap = new HashMap(6);
        aMq = hashMap;
        hashMap.put("image/jpeg", C37223c.JPG);
        aMq.put("image/gif", C37223c.GIF);
        aMq.put("image/png", C37223c.PNG);
        aMq.put("image/x-ms-bmp", C37223c.BMP);
        aMq.put("image/bmp", C37223c.BMP);
        aMq.put("image/webp", C37223c.WEBP);
        AppMethodBeat.m2505o(115776);
    }

    /* renamed from: g */
    public static C25505d m62374g(InputStream inputStream) {
        AppMethodBeat.m2504i(115775);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        InputStream h = C45013d.m82444h(inputStream);
        C45013d.m82445i(h);
        BitmapFactory.decodeStream(h, null, options);
        C37223c c37223c = (C37223c) aMq.get(options.outMimeType);
        if (c37223c == null) {
            c37223c = C37223c.UNKNOWN;
        }
        try {
            h.reset();
        } catch (IOException e) {
            C17837c.m27913a("Ni.FormatUtil", e, "hy: the given stream is markable, but still reset error. should not forward", new Object[0]);
            c37223c = C37223c.UNKNOWN;
        }
        C25505d c25505d = new C25505d();
        c25505d.aMl = c37223c;
        c25505d.aMn = (long) options.outHeight;
        c25505d.aMm = (long) options.outWidth;
        AppMethodBeat.m2505o(115775);
        return c25505d;
    }
}
