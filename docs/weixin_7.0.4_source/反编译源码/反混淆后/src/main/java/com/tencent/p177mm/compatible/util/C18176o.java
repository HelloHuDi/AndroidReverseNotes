package com.tencent.p177mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.compatible.util.o */
public final class C18176o {
    /* renamed from: t */
    public static boolean m28622t(CharSequence charSequence) {
        AppMethodBeat.m2504i(93108);
        if (charSequence == null) {
            AppMethodBeat.m2505o(93108);
            return false;
        } else if (C1427q.etn.erX == 1) {
            AppMethodBeat.m2505o(93108);
            return true;
        } else if (VERSION.SDK_INT != 16) {
            AppMethodBeat.m2505o(93108);
            return false;
        } else if (C5046bo.m7532bc(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0) {
            AppMethodBeat.m2505o(93108);
            return false;
        } else {
            AppMethodBeat.m2505o(93108);
            return true;
        }
    }

    /* renamed from: kz */
    public static String m28621kz(String str) {
        AppMethodBeat.m2504i(93109);
        if (str == null) {
            AppMethodBeat.m2505o(93109);
            return str;
        } else if (C1427q.etn.erX == 2) {
            AppMethodBeat.m2505o(93109);
            return str;
        } else if (C1427q.etn.esi == 1) {
            AppMethodBeat.m2505o(93109);
            return str;
        } else if (C1427q.etn.erX == 1) {
            if (str.toString().contains(IOUtils.LINE_SEPARATOR_UNIX)) {
                str = str.toString().replace(IOUtils.LINE_SEPARATOR_UNIX, " ");
                AppMethodBeat.m2505o(93109);
                return str;
            }
            AppMethodBeat.m2505o(93109);
            return str;
        } else if (VERSION.SDK_INT != 16) {
            AppMethodBeat.m2505o(93109);
            return str;
        } else if (!str.toString().contains(IOUtils.LINE_SEPARATOR_UNIX)) {
            AppMethodBeat.m2505o(93109);
            return str;
        } else if (C5046bo.m7532bc(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) >= 0) {
            AppMethodBeat.m2505o(93109);
            return str;
        } else {
            str = str.toString().replace(IOUtils.LINE_SEPARATOR_UNIX, " ");
            AppMethodBeat.m2505o(93109);
            return str;
        }
    }
}
