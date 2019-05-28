package com.tencent.luggage.p1589e.p1590a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.p290g.C2154b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.FileInputStream;
import java.io.InputStream;

/* renamed from: com.tencent.luggage.e.a.a */
public final class C41710a {
    /* renamed from: j */
    public static int m73392j(InputStream inputStream) {
        int i = 0;
        AppMethodBeat.m2504i(65346);
        try {
            i = C2154b.m4368j(inputStream);
            AppMethodBeat.m2505o(65346);
        } catch (Exception e) {
            C4990ab.m7413e("Luggage.ImageInfoUtils", "getExifOrientation with stream, e = %s", e);
            AppMethodBeat.m2505o(65346);
        }
        return i;
    }

    /* renamed from: bJ */
    public static int m73388bJ(String str) {
        int i = 0;
        AppMethodBeat.m2504i(65347);
        if (C1173e.m2561ct(str)) {
            try {
                i = C2154b.m4368j(new FileInputStream(str));
                AppMethodBeat.m2505o(65347);
            } catch (Exception e) {
                C4990ab.m7413e("Luggage.ImageInfoUtils", "getExifOrientation, path = %s, e = %s", str, e);
                AppMethodBeat.m2505o(65347);
            }
        } else {
            C4990ab.m7412e("Luggage.ImageInfoUtils", "getExifOrientation err ");
            AppMethodBeat.m2505o(65347);
        }
        return i;
    }

    /* renamed from: e */
    public static boolean m73389e(Options options) {
        AppMethodBeat.m2504i(65348);
        if (options == null) {
            AppMethodBeat.m2505o(65348);
            return false;
        }
        String str = options.outMimeType;
        if (str == null) {
            AppMethodBeat.m2505o(65348);
            return false;
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            AppMethodBeat.m2505o(65348);
            return true;
        } else if (str.indexOf("jpeg") >= 0) {
            AppMethodBeat.m2505o(65348);
            return true;
        } else {
            AppMethodBeat.m2505o(65348);
            return false;
        }
    }

    /* renamed from: f */
    public static String m73390f(Options options) {
        AppMethodBeat.m2504i(65349);
        String str = options.outMimeType;
        if (str == null) {
            str = "unknown";
            AppMethodBeat.m2505o(65349);
            return str;
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            str = "jpeg";
            AppMethodBeat.m2505o(65349);
            return str;
        } else if (str.indexOf("jpeg") >= 0) {
            str = "jpeg";
            AppMethodBeat.m2505o(65349);
            return str;
        } else if (str.indexOf("png") >= 0) {
            str = "png";
            AppMethodBeat.m2505o(65349);
            return str;
        } else if (str.indexOf("gif") >= 0) {
            str = "gif";
            AppMethodBeat.m2505o(65349);
            return str;
        } else {
            str = "unknown";
            AppMethodBeat.m2505o(65349);
            return str;
        }
    }

    /* renamed from: fO */
    public static String m73391fO(int i) {
        switch (i) {
            case 0:
                return "up";
            case 1:
                return "up";
            case 2:
                return "up-mirrored";
            case 3:
                return "down";
            case 4:
                return "down-mirrored";
            case 5:
                return "left-mirrored";
            case 6:
                return "right";
            case 7:
                return "right-mirrored";
            case 8:
                return "left";
            default:
                return "up";
        }
    }
}
