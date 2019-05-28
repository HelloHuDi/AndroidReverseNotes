package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class f {
    public static String d(String str, long j, boolean z) {
        AppMethodBeat.i(25283);
        String str2 = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (z ? 1 : 0) + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.o(25283);
        return str2;
    }
}
