package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class b {
    public static String cYv() {
        AppMethodBeat.i(6916);
        File file = new File(e.eSk.replace("/data/user/0", "/data/data"), "cityService/js");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = new File(file.getAbsoluteFile(), "analytics.js").getAbsolutePath();
        AppMethodBeat.o(6916);
        return absolutePath;
    }

    public static void n(String str, String str2, int i, int i2) {
        AppMethodBeat.i(6917);
        String str3 = null;
        try {
            str3 = URLEncoder.encode(bo.nullAsNil(str2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.CityServiceHelper", e, "", new Object[0]);
        }
        h.pYm.e(15650, str, str3, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(6917);
    }

    public static void up(int i) {
        AppMethodBeat.i(6918);
        h.pYm.a(894, (long) i, 1, false);
        AppMethodBeat.o(6918);
    }
}
