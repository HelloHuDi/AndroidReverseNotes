package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class n {
    public String fWW;
    public boolean fWX;
    public long time;

    public static String d(String str, long j, boolean z) {
        AppMethodBeat.i(55837);
        String str2 = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (z ? 1 : 0) + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.o(55837);
        return str2;
    }

    public n(String str) {
        AppMethodBeat.i(55838);
        try {
            int i;
            if (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                str = str.substring(0, str.length() - 1);
            }
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length == 4 && ad.mR(split[0])) {
                i = 1;
            } else {
                i = 0;
            }
            if (split.length > i) {
                this.fWW = split[i];
            }
            if (split.length > i + 1) {
                this.time = bo.getLong(split[i + 1], 0);
            }
            if (split.length > i + 2) {
                this.fWX = split[i + 2].equals("1");
            }
            AppMethodBeat.o(55838);
        } catch (Exception e) {
            if (this.fWW == null) {
                this.fWW = "";
            }
            this.fWX = false;
            this.time = 0;
            ab.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
            AppMethodBeat.o(55838);
        }
    }

    public final String alt() {
        return this.fWW;
    }
}
