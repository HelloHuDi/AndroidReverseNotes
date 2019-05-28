package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class o {
    public static boolean t(CharSequence charSequence) {
        AppMethodBeat.i(93108);
        if (charSequence == null) {
            AppMethodBeat.o(93108);
            return false;
        } else if (q.etn.erX == 1) {
            AppMethodBeat.o(93108);
            return true;
        } else if (VERSION.SDK_INT != 16) {
            AppMethodBeat.o(93108);
            return false;
        } else if (bo.bc(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0) {
            AppMethodBeat.o(93108);
            return false;
        } else {
            AppMethodBeat.o(93108);
            return true;
        }
    }

    public static String kz(String str) {
        AppMethodBeat.i(93109);
        if (str == null) {
            AppMethodBeat.o(93109);
            return str;
        } else if (q.etn.erX == 2) {
            AppMethodBeat.o(93109);
            return str;
        } else if (q.etn.esi == 1) {
            AppMethodBeat.o(93109);
            return str;
        } else if (q.etn.erX == 1) {
            if (str.toString().contains(IOUtils.LINE_SEPARATOR_UNIX)) {
                str = str.toString().replace(IOUtils.LINE_SEPARATOR_UNIX, " ");
                AppMethodBeat.o(93109);
                return str;
            }
            AppMethodBeat.o(93109);
            return str;
        } else if (VERSION.SDK_INT != 16) {
            AppMethodBeat.o(93109);
            return str;
        } else if (!str.toString().contains(IOUtils.LINE_SEPARATOR_UNIX)) {
            AppMethodBeat.o(93109);
            return str;
        } else if (bo.bc(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0) {
            AppMethodBeat.o(93109);
            return str;
        } else {
            str = str.toString().replace(IOUtils.LINE_SEPARATOR_UNIX, " ");
            AppMethodBeat.o(93109);
            return str;
        }
    }
}
