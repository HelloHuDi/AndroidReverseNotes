package com.tencent.luggage.e.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileInputStream;
import java.io.InputStream;

public final class a {
    public static int j(InputStream inputStream) {
        int i = 0;
        AppMethodBeat.i(65346);
        try {
            i = b.j(inputStream);
            AppMethodBeat.o(65346);
        } catch (Exception e) {
            ab.e("Luggage.ImageInfoUtils", "getExifOrientation with stream, e = %s", e);
            AppMethodBeat.o(65346);
        }
        return i;
    }

    public static int bJ(String str) {
        int i = 0;
        AppMethodBeat.i(65347);
        if (e.ct(str)) {
            try {
                i = b.j(new FileInputStream(str));
                AppMethodBeat.o(65347);
            } catch (Exception e) {
                ab.e("Luggage.ImageInfoUtils", "getExifOrientation, path = %s, e = %s", str, e);
                AppMethodBeat.o(65347);
            }
        } else {
            ab.e("Luggage.ImageInfoUtils", "getExifOrientation err ");
            AppMethodBeat.o(65347);
        }
        return i;
    }

    public static boolean e(Options options) {
        AppMethodBeat.i(65348);
        if (options == null) {
            AppMethodBeat.o(65348);
            return false;
        }
        String str = options.outMimeType;
        if (str == null) {
            AppMethodBeat.o(65348);
            return false;
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            AppMethodBeat.o(65348);
            return true;
        } else if (str.indexOf("jpeg") >= 0) {
            AppMethodBeat.o(65348);
            return true;
        } else {
            AppMethodBeat.o(65348);
            return false;
        }
    }

    public static String f(Options options) {
        AppMethodBeat.i(65349);
        String str = options.outMimeType;
        if (str == null) {
            str = "unknown";
            AppMethodBeat.o(65349);
            return str;
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            str = "jpeg";
            AppMethodBeat.o(65349);
            return str;
        } else if (str.indexOf("jpeg") >= 0) {
            str = "jpeg";
            AppMethodBeat.o(65349);
            return str;
        } else if (str.indexOf("png") >= 0) {
            str = "png";
            AppMethodBeat.o(65349);
            return str;
        } else if (str.indexOf("gif") >= 0) {
            str = "gif";
            AppMethodBeat.o(65349);
            return str;
        } else {
            str = "unknown";
            AppMethodBeat.o(65349);
            return str;
        }
    }

    public static String fO(int i) {
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
