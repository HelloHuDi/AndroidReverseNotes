package com.tencent.p177mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.modelvoice.n */
public final class C42230n {
    public String fWW;
    public boolean fWX;
    public long time;

    /* renamed from: d */
    public static String m74526d(String str, long j, boolean z) {
        AppMethodBeat.m2504i(55837);
        String str2 = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (z ? 1 : 0) + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.m2505o(55837);
        return str2;
    }

    public C42230n(String str) {
        AppMethodBeat.m2504i(55838);
        try {
            int i;
            if (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                str = str.substring(0, str.length() - 1);
            }
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length == 4 && C7616ad.m13548mR(split[0])) {
                i = 1;
            } else {
                i = 0;
            }
            if (split.length > i) {
                this.fWW = split[i];
            }
            if (split.length > i + 1) {
                this.time = C5046bo.getLong(split[i + 1], 0);
            }
            if (split.length > i + 2) {
                this.fWX = split[i + 2].equals("1");
            }
            AppMethodBeat.m2505o(55838);
        } catch (Exception e) {
            if (this.fWW == null) {
                this.fWW = "";
            }
            this.fWX = false;
            this.time = 0;
            C4990ab.m7412e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
            AppMethodBeat.m2505o(55838);
        }
    }

    public final String alt() {
        return this.fWW;
    }
}
