package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.davemorrissey.labs.subscaleview.view.a */
public final class C31985a {
    final Integer aIH;
    public boolean aII;
    public int aIJ;
    public int aIK;
    public Rect aIL;
    boolean aIM;
    public final Bitmap bitmap;
    public final Uri uri;

    public C31985a(Bitmap bitmap) {
        AppMethodBeat.m2504i(115636);
        this.bitmap = bitmap;
        this.uri = null;
        this.aIH = null;
        this.aII = false;
        this.aIJ = bitmap.getWidth();
        this.aIK = bitmap.getHeight();
        this.aIM = true;
        AppMethodBeat.m2505o(115636);
    }

    private C31985a(Uri uri) {
        AppMethodBeat.m2504i(115637);
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
        AppMethodBeat.m2505o(115637);
    }

    C31985a(int i) {
        AppMethodBeat.m2504i(115638);
        this.bitmap = null;
        this.uri = null;
        this.aIH = Integer.valueOf(i);
        this.aII = true;
        AppMethodBeat.m2505o(115638);
    }

    /* renamed from: af */
    public static C31985a m51974af(String str) {
        AppMethodBeat.m2504i(115639);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("Uri must not be null");
            AppMethodBeat.m2505o(115639);
            throw nullPointerException;
        }
        if (!str.contains("://")) {
            Object substring;
            if (str.startsWith("/")) {
                substring = str.substring(1);
            }
            str = "file:///".concat(String.valueOf(substring));
        }
        C31985a c31985a = new C31985a(Uri.parse(str));
        AppMethodBeat.m2505o(115639);
        return c31985a;
    }

    /* renamed from: ox */
    public final C31985a mo52092ox() {
        this.aII = true;
        return this;
    }
}
