package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class f {
    public static boolean qR(int i) {
        return i >= 0 && i <= 59;
    }

    public static boolean qS(int i) {
        return i >= 0 && i <= 23;
    }

    public static int[] EO(String str) {
        AppMethodBeat.i(126755);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(126755);
            return null;
        }
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (split == null || split.length != 2) {
            AppMethodBeat.o(126755);
            return null;
        }
        int EP = EP(split[0]);
        int EP2 = EP(split[1]);
        if (qS(EP) && qR(EP2)) {
            int[] iArr = new int[]{EP, EP2};
            AppMethodBeat.o(126755);
            return iArr;
        }
        AppMethodBeat.o(126755);
        return null;
    }

    private static int EP(String str) {
        AppMethodBeat.i(126756);
        try {
            int parseInt = Integer.parseInt(str, 10);
            AppMethodBeat.o(126756);
            return parseInt;
        } catch (Exception e) {
            AppMethodBeat.o(126756);
            return -1;
        }
    }
}
