package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class ap {
    public String cvZ = "-1";
    public String fWW;
    public boolean fWX;
    public long time;
    public boolean xXK;
    public String xXL = "";

    public static String a(String str, long j, boolean z, String str2, boolean z2, String str3) {
        int i = 1;
        AppMethodBeat.i(62697);
        StringBuilder append = new StringBuilder().append(str).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(j).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(z ? 1 : 0).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str2).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str3.replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "*#*")).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (!z2) {
            i = 0;
        }
        String stringBuilder = append.append(i).append(IOUtils.LINE_SEPARATOR_UNIX).toString();
        AppMethodBeat.o(62697);
        return stringBuilder;
    }

    public final String dsX() {
        int i = 1;
        AppMethodBeat.i(62698);
        StringBuilder append = new StringBuilder().append(this.fWW).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(this.time).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(this.fWX ? 1 : 0).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(this.cvZ).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(this.xXL).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (!this.xXK) {
            i = 0;
        }
        String stringBuilder = append.append(i).append(IOUtils.LINE_SEPARATOR_UNIX).toString();
        AppMethodBeat.o(62698);
        return stringBuilder;
    }

    public ap(String str) {
        AppMethodBeat.i(62699);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
            AppMethodBeat.o(62699);
            return;
        }
        try {
            String substring;
            int i;
            if (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                substring = str.substring(0, str.length() - 1);
            } else {
                this.xXL = str.replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "*#*");
                substring = str;
            }
            String[] split = substring.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 6);
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
            if (split.length > i + 3) {
                this.cvZ = split[i + 3];
            }
            if (split.length > i + 4) {
                this.xXL = split[i + 4].replace("*#*", VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            }
            if (split.length > i + 5) {
                this.xXK = split[i + 5].equals("1");
            }
            AppMethodBeat.o(62699);
        } catch (Exception e) {
            this.time = 0;
            ab.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", str, bo.l(e));
            AppMethodBeat.o(62699);
        }
    }

    public static ap aps(String str) {
        AppMethodBeat.i(62700);
        ap apVar = new ap(str);
        AppMethodBeat.o(62700);
        return apVar;
    }
}
