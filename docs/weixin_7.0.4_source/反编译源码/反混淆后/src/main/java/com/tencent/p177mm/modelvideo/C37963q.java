package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.modelvideo.q */
public final class C37963q {
    private String fWW;
    private boolean fWX;
    private long time;

    /* renamed from: d */
    public static String m64228d(String str, long j, boolean z) {
        AppMethodBeat.m2504i(50780);
        String str2 = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (z ? 1 : 0) + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.m2505o(50780);
        return str2;
    }

    public C37963q(String str) {
        AppMethodBeat.m2504i(50781);
        if (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
            str = str.substring(0, str.length() - 1);
        }
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        try {
            if (split.length > 0) {
                this.fWW = split[0];
            }
            if (split.length > 1) {
                this.time = C5046bo.getLong(split[1], 0);
            }
            if (split.length > 2) {
                this.fWX = split[2].equals("1");
            }
            AppMethodBeat.m2505o(50781);
        } catch (Exception e) {
            if (this.fWW == null) {
                this.fWW = "";
            }
            this.fWX = false;
            this.time = 0;
            C4990ab.m7412e("MicroMsg.VideoContent", "VoiceContent parse failed.");
            AppMethodBeat.m2505o(50781);
        }
    }

    public final String alt() {
        return this.fWW;
    }
}
