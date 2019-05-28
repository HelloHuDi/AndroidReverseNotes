package com.tencent.mm.plugin.appbrand.g;

import android.support.d.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;

public final class b {
    public static int j(InputStream inputStream) {
        int i = 0;
        AppMethodBeat.i(65352);
        if (inputStream == null) {
            AppMethodBeat.o(65352);
        } else {
            try {
                i = new a(inputStream).getAttributeInt(a.TAG_ORIENTATION, 1);
                AppMethodBeat.o(65352);
            } catch (Exception e) {
                AppMethodBeat.o(65352);
            }
        }
        return i;
    }

    public static void bY(String str, String str2) {
        AppMethodBeat.i(65353);
        if (ct(str) && ct(str2)) {
            a aVar = new a(str2);
            a.a(new a(str), aVar);
            aVar.setAttribute(a.TAG_ORIENTATION, null);
            aVar.setAttribute(a.TAG_IMAGE_WIDTH, null);
            aVar.setAttribute(a.TAG_THUMBNAIL_IMAGE_WIDTH, null);
            aVar.saveAttributes();
            AppMethodBeat.o(65353);
            return;
        }
        AppMethodBeat.o(65353);
    }

    public static void a(InputStream inputStream, String str) {
        AppMethodBeat.i(65354);
        if (inputStream == null || !ct(str)) {
            AppMethodBeat.o(65354);
            return;
        }
        a aVar = new a(str);
        a.a(new a(inputStream), aVar);
        aVar.setAttribute(a.TAG_ORIENTATION, null);
        aVar.setAttribute(a.TAG_IMAGE_WIDTH, null);
        aVar.setAttribute(a.TAG_THUMBNAIL_IMAGE_WIDTH, null);
        aVar.saveAttributes();
        AppMethodBeat.o(65354);
    }

    private static boolean ct(String str) {
        AppMethodBeat.i(65355);
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            AppMethodBeat.o(65355);
            return false;
        }
        AppMethodBeat.o(65355);
        return true;
    }
}
