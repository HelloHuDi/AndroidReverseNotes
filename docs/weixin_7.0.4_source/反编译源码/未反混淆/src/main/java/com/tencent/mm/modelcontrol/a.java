package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;

public final class a {
    private static f[] fzF;

    static {
        AppMethodBeat.i(50591);
        fzF = null;
        r8 = new f[2];
        fzF = r8;
        r8[0] = new f(0, 120, 540, VideoFilterUtil.IMAGE_HEIGHT, 30, 1200000, 1200000);
        fzF[1] = new f(120, 300, v2helper.VOIP_ENC_HEIGHT_LV1, 640, 24, 544000, 544000);
        AppMethodBeat.o(50591);
    }

    /* JADX WARNING: Missing block: B:4:0x000a, code skipped:
            if (r10.length <= 0) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(f[] fVarArr, VideoTransPara videoTransPara, VideoTransPara videoTransPara2) {
        int i;
        AppMethodBeat.i(50590);
        if (fVarArr != null) {
            try {
            } catch (Exception e) {
                ab.e("MicroMsg.BitrateCalculator", "do calc bitrate error: " + e.toString());
                i = 0;
            }
        }
        fVarArr = fzF;
        int length = fVarArr.length;
        videoTransPara2.width = videoTransPara.width;
        videoTransPara2.height = videoTransPara.height;
        videoTransPara2.fps = videoTransPara.fps;
        videoTransPara2.videoBitrate = videoTransPara.videoBitrate;
        videoTransPara2.duration = videoTransPara.duration;
        Object obj = videoTransPara.width > videoTransPara.height ? 1 : null;
        int i2 = obj != null ? videoTransPara.width : videoTransPara.height;
        int i3 = obj != null ? videoTransPara.height : videoTransPara.width;
        int i4 = videoTransPara.duration;
        if (videoTransPara2.duration < fVarArr[length - 1].fzZ || videoTransPara2.duration < fzF[1].fzZ) {
            int i5 = 0;
            while (i5 < length) {
                if (i4 < fVarArr[i5].fzY || i4 >= fVarArr[i5].fzZ) {
                    i5++;
                } else {
                    length = fVarArr[i5].fAa;
                    i = fVarArr[i5].fAb;
                    if (i2 > length || i3 > i) {
                        if ((i2 * i > i3 * length ? 1 : null) != null) {
                            i = (i3 * length) / i2;
                        } else {
                            length = (i2 * i) / i3;
                        }
                        length = ((length + 8) >> 4) << 4;
                        i = ((i + 8) >> 4) << 4;
                    } else {
                        i = i3;
                        length = i2;
                    }
                    if (obj != null) {
                        i3 = length;
                    } else {
                        i3 = i;
                    }
                    videoTransPara2.width = i3;
                    if (obj == null) {
                        i = length;
                    }
                    videoTransPara2.height = i;
                    videoTransPara2.fps = videoTransPara2.fps > fVarArr[i5].fAc ? fVarArr[i5].fAc : videoTransPara2.fps;
                    videoTransPara2.videoBitrate = (int) (((((double) (((((fVarArr[i5].fAd * fVarArr[i5].fzZ) + (fVarArr[i5].fAe * videoTransPara2.duration)) - (fVarArr[i5].fAd * videoTransPara2.duration)) - (fVarArr[i5].fAe * fVarArr[i5].fzY)) / (fVarArr[i5].fzZ - fVarArr[i5].fzY))) * Math.sqrt((1.0d * ((double) (videoTransPara2.width * videoTransPara2.height))) / ((double) (fVarArr[i5].fAa * fVarArr[i5].fAb)))) * ((double) (videoTransPara2.fps + 10))) / 40.0d);
                    i = videoTransPara2.videoBitrate;
                    AppMethodBeat.o(50590);
                    return i;
                }
            }
            i = 0;
            while (true) {
                i5 = i;
                if (i5 >= 2) {
                    break;
                } else if (i4 < fzF[i5].fzY || i4 >= fzF[i5].fzZ) {
                    i = i5 + 1;
                } else {
                    length = fzF[i5].fAa;
                    i = fzF[i5].fAb;
                    if (i2 > length || i3 > i) {
                        if ((i2 * i > i3 * length ? 1 : null) != null) {
                            i = (i3 * length) / i2;
                        } else {
                            length = (i2 * i) / i3;
                        }
                        length = ((length + 8) >> 4) << 4;
                        i = ((i + 8) >> 4) << 4;
                    } else {
                        i = i3;
                        length = i2;
                    }
                    if (obj != null) {
                        i3 = length;
                    } else {
                        i3 = i;
                    }
                    videoTransPara2.width = i3;
                    if (obj == null) {
                        i = length;
                    }
                    videoTransPara2.height = i;
                    videoTransPara2.fps = videoTransPara2.fps > fzF[i5].fAc ? fzF[i5].fAc : videoTransPara2.fps;
                    videoTransPara2.videoBitrate = (int) (((((double) (((((fzF[i5].fAd * fzF[i5].fzZ) + (fzF[i5].fAe * videoTransPara2.duration)) - (fzF[i5].fAd * videoTransPara2.duration)) - (fzF[i5].fAe * fzF[i5].fzY)) / (fzF[i5].fzZ - fzF[i5].fzY))) * Math.sqrt((1.0d * ((double) (videoTransPara2.width * videoTransPara2.height))) / ((double) (fzF[i5].fAa * fzF[i5].fAb)))) * ((double) (videoTransPara2.fps + 10))) / 40.0d);
                    i = videoTransPara2.videoBitrate;
                }
            }
            AppMethodBeat.o(50590);
            return i;
        }
        i = 0;
        AppMethodBeat.o(50590);
        return i;
    }
}
