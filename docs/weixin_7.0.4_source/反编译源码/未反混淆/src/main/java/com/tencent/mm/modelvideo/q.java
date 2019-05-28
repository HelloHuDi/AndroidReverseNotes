package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class q {
    private String fWW;
    private boolean fWX;
    private long time;

    public static String d(String str, long j, boolean z) {
        AppMethodBeat.i(50780);
        String str2 = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (z ? 1 : 0) + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.o(50780);
        return str2;
    }

    public q(String str) {
        AppMethodBeat.i(50781);
        if (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
            str = str.substring(0, str.length() - 1);
        }
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        try {
            if (split.length > 0) {
                this.fWW = split[0];
            }
            if (split.length > 1) {
                this.time = bo.getLong(split[1], 0);
            }
            if (split.length > 2) {
                this.fWX = split[2].equals("1");
            }
            AppMethodBeat.o(50781);
        } catch (Exception e) {
            if (this.fWW == null) {
                this.fWW = "";
            }
            this.fWX = false;
            this.time = 0;
            ab.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
            AppMethodBeat.o(50781);
        }
    }

    public final String alt() {
        return this.fWW;
    }
}
