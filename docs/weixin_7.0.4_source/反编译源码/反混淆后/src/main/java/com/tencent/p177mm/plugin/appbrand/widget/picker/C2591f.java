package com.tencent.p177mm.plugin.appbrand.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.f */
public final class C2591f {
    /* renamed from: qR */
    public static boolean m4842qR(int i) {
        return i >= 0 && i <= 59;
    }

    /* renamed from: qS */
    public static boolean m4843qS(int i) {
        return i >= 0 && i <= 23;
    }

    /* renamed from: EO */
    public static int[] m4840EO(String str) {
        AppMethodBeat.m2504i(126755);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(126755);
            return null;
        }
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (split == null || split.length != 2) {
            AppMethodBeat.m2505o(126755);
            return null;
        }
        int EP = C2591f.m4841EP(split[0]);
        int EP2 = C2591f.m4841EP(split[1]);
        if (C2591f.m4843qS(EP) && C2591f.m4842qR(EP2)) {
            int[] iArr = new int[]{EP, EP2};
            AppMethodBeat.m2505o(126755);
            return iArr;
        }
        AppMethodBeat.m2505o(126755);
        return null;
    }

    /* renamed from: EP */
    private static int m4841EP(String str) {
        AppMethodBeat.m2504i(126756);
        try {
            int parseInt = Integer.parseInt(str, 10);
            AppMethodBeat.m2505o(126756);
            return parseInt;
        } catch (Exception e) {
            AppMethodBeat.m2505o(126756);
            return -1;
        }
    }
}
