package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class c {
    public static final String P(String str, String str2) {
        AppMethodBeat.i(114129);
        if (str.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) || str.length() <= 0) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split[0] == null || split[0].length() <= 0) {
                AppMethodBeat.o(114129);
                return str2;
            }
            str = split[0];
            AppMethodBeat.o(114129);
            return str;
        }
        AppMethodBeat.o(114129);
        return str;
    }
}
