package com.tencent.p177mm.ipcinvoker.p855h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.ipcinvoker.h.c */
public final class C9552c {
    /* renamed from: P */
    public static final String m17015P(String str, String str2) {
        AppMethodBeat.m2504i(114129);
        if (str.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) || str.length() <= 0) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split[0] == null || split[0].length() <= 0) {
                AppMethodBeat.m2505o(114129);
                return str2;
            }
            str = split[0];
            AppMethodBeat.m2505o(114129);
            return str;
        }
        AppMethodBeat.m2505o(114129);
        return str;
    }
}
