package com.tencent.p177mm.plugin.subapp.p1039c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.subapp.c.f */
public final class C39938f {
    /* renamed from: d */
    public static String m68400d(String str, long j, boolean z) {
        AppMethodBeat.m2504i(25283);
        String str2 = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (z ? 1 : 0) + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.m2505o(25283);
        return str2;
    }
}
