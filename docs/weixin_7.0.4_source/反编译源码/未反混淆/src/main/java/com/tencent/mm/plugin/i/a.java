package com.tencent.mm.plugin.i;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;

public final class a {
    public String cvZ;
    public int nuA;
    public int nuB;
    public int nuC;
    public int nuD;
    public String nuw;
    public String nux;
    public int nuy;
    public int nuz;

    public static String cv(String str) {
        AppMethodBeat.i(79092);
        byte[] e = e.e(str, 0, 6);
        String str2;
        if (e == null || e.length != 6) {
            str2 = "";
            AppMethodBeat.o(79092);
            return str2;
        }
        String str3 = "";
        try {
            str2 = new String(e, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            ab.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:".concat(String.valueOf(e2)));
            str2 = str3;
        }
        AppMethodBeat.o(79092);
        return str2;
    }

    public static String OK(String str) {
        AppMethodBeat.i(79093);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(79093);
            return str2;
        }
        str2 = str.replace(",", ";");
        AppMethodBeat.o(79093);
        return str2;
    }

    public static int tF(String str) {
        AppMethodBeat.i(79094);
        try {
            Options amj = d.amj(str);
            if (amj == null) {
                AppMethodBeat.o(79094);
                return 0;
            }
            String str2 = amj.outMimeType;
            if (str2 == null) {
                AppMethodBeat.o(79094);
                return 0;
            }
            str2 = str2.toLowerCase();
            if (str2.indexOf("png") >= 0) {
                AppMethodBeat.o(79094);
                return 1;
            } else if (str2.indexOf("jpg") >= 0) {
                AppMethodBeat.o(79094);
                return 2;
            } else if (str2.indexOf("jpeg") >= 0) {
                AppMethodBeat.o(79094);
                return 2;
            } else {
                AppMethodBeat.o(79094);
                return 0;
            }
        } catch (Exception e) {
            AppMethodBeat.o(79094);
            return 0;
        }
    }
}
