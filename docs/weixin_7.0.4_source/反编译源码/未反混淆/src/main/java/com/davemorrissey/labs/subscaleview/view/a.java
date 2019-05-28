package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a {
    final Integer aIH;
    public boolean aII;
    public int aIJ;
    public int aIK;
    public Rect aIL;
    boolean aIM;
    public final Bitmap bitmap;
    public final Uri uri;

    public a(Bitmap bitmap) {
        AppMethodBeat.i(115636);
        this.bitmap = bitmap;
        this.uri = null;
        this.aIH = null;
        this.aII = false;
        this.aIJ = bitmap.getWidth();
        this.aIK = bitmap.getHeight();
        this.aIM = true;
        AppMethodBeat.o(115636);
    }

    private a(Uri uri) {
        AppMethodBeat.i(115637);
        String uri2 = uri.toString();
        if (uri2.startsWith("file:///") && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.aIH = null;
        this.aII = true;
        AppMethodBeat.o(115637);
    }

    a(int i) {
        AppMethodBeat.i(115638);
        this.bitmap = null;
        this.uri = null;
        this.aIH = Integer.valueOf(i);
        this.aII = true;
        AppMethodBeat.o(115638);
    }

    public static a af(String str) {
        AppMethodBeat.i(115639);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("Uri must not be null");
            AppMethodBeat.o(115639);
            throw nullPointerException;
        }
        if (!str.contains("://")) {
            Object substring;
            if (str.startsWith("/")) {
                substring = str.substring(1);
            }
            str = "file:///".concat(String.valueOf(substring));
        }
        a aVar = new a(Uri.parse(str));
        AppMethodBeat.o(115639);
        return aVar;
    }

    public final a ox() {
        this.aII = true;
        return this;
    }
}
