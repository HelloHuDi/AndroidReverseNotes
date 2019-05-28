package com.tencent.p177mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.modelcontrol.a */
public final class C18654a {
    private static C26440f[] fzF;

    static {
        AppMethodBeat.m2504i(50591);
        fzF = null;
        r8 = new C26440f[2];
        fzF = r8;
        r8[0] = new C26440f(0, 120, 540, VideoFilterUtil.IMAGE_HEIGHT, 30, 1200000, 1200000);
        fzF[1] = new C26440f(120, 300, v2helper.VOIP_ENC_HEIGHT_LV1, 640, 24, 544000, 544000);
        AppMethodBeat.m2505o(50591);
    }

    /* JADX WARNING: Missing block: B:4:0x000a, code skipped:
            if (r10.length <= 0) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static int m29158a(C26440f[] c26440fArr, VideoTransPara videoTransPara, VideoTransPara videoTransPara2) {
        int i;
        AppMethodBeat.m2504i(50590);
        if (c26440fArr != null) {
            try {
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BitrateCalculator", "do calc bitrate error: " + e.toString());
                i = 0;
            }
        }
        c26440fArr = fzF;
        int length = c26440fArr.length;
        videoTransPara2.width = videoTransPara.width;
        videoTransPara2.height = videoTransPara.height;
        videoTransPara2.fps = videoTransPara.fps;
        videoTransPara2.videoBitrate = videoTransPara.videoBitrate;
        videoTransPara2.duration = videoTransPara.duration;
        Object obj = videoTransPara.width > videoTransPara.height ? 1 : null;
        int i2 = obj != null ? videoTransPara.width : videoTransPara.height;
        int i3 = obj != null ? videoTransPara.height : videoTransPara.width;
        int i4 = videoTransPara.duration;
        if (videoTransPara2.duration < c26440fArr[length - 1].fzZ || videoTransPara2.duration < fzF[1].fzZ) {
            int i5 = 0;
            while (i5 < length) {
                if (i4 < c26440fArr[i5].fzY || i4 >= c26440fArr[i5].fzZ) {
                    i5++;
                } else {
                    length = c26440fArr[i5].fAa;
                    i = c26440fArr[i5].fAb;
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
                    videoTransPara2.fps = videoTransPara2.fps > c26440fArr[i5].fAc ? c26440fArr[i5].fAc : videoTransPara2.fps;
                    videoTransPara2.videoBitrate = (int) (((((double) (((((c26440fArr[i5].fAd * c26440fArr[i5].fzZ) + (c26440fArr[i5].fAe * videoTransPara2.duration)) - (c26440fArr[i5].fAd * videoTransPara2.duration)) - (c26440fArr[i5].fAe * c26440fArr[i5].fzY)) / (c26440fArr[i5].fzZ - c26440fArr[i5].fzY))) * Math.sqrt((1.0d * ((double) (videoTransPara2.width * videoTransPara2.height))) / ((double) (c26440fArr[i5].fAa * c26440fArr[i5].fAb)))) * ((double) (videoTransPara2.fps + 10))) / 40.0d);
                    i = videoTransPara2.videoBitrate;
                    AppMethodBeat.m2505o(50590);
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
            AppMethodBeat.m2505o(50590);
            return i;
        }
        i = 0;
        AppMethodBeat.m2505o(50590);
        return i;
    }
}
