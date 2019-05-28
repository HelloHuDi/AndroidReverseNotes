package com.tencent.p177mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.mmsight.model.l */
public final class C3483l {
    /* renamed from: a */
    public static boolean m5789a(String str, VideoTransPara videoTransPara, baa baa, C28508d c28508d) {
        AppMethodBeat.m2504i(60311);
        try {
            if (C5046bo.isNullOrNil(str) || videoTransPara == null) {
                AppMethodBeat.m2505o(60311);
                return false;
            }
            if (baa == null) {
                baa = new baa();
            }
            C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", Boolean.valueOf(baa.wDP), str, videoTransPara, Boolean.valueOf(baa.wDT));
            if (baa.wDT) {
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", str);
                AppMethodBeat.m2505o(60311);
                return false;
            } else if (!baa.wDP || C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(60311);
                return false;
            } else {
                SightVideoJNI.tagMP4Dscp(str, C42204d.afF().getWeixinMeta());
                if (!C5046bo.isNullOrNil(baa.wDS)) {
                    SightVideoJNI.tagMp4RecordInfo(str, baa.wDS);
                }
                long yz = C5046bo.m7588yz();
                SightVideoJNI.optimizeMP4(str);
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", Long.valueOf(C5046bo.m7525az(yz)));
                c28508d.bOc();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i3 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                mediaMetadataRetriever.release();
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s", Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height), Integer.valueOf(videoTransPara.videoBitrate));
                int min = Math.min(i, i2);
                boolean z = C1427q.etj.etJ == 1;
                boolean z2 = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("MMSightCheckSendVideoBitrate"), 0) == 1;
                float f = C5046bo.getFloat(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3f);
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f));
                Object obj = (z || z2) ? 1 : null;
                if (min > videoTransPara.width && ((min <= videoTransPara.width || min % 16 != 0 || Math.abs(min - videoTransPara.width) >= 16) && (obj == null || ((float) i3) < ((float) videoTransPara.videoBitrate) * f))) {
                    AppMethodBeat.m2505o(60311);
                    return true;
                } else if (baa.wDO) {
                    AppMethodBeat.m2505o(60311);
                    return true;
                } else {
                    if (obj != null) {
                        if (((float) i3) >= ((float) videoTransPara.videoBitrate) * f) {
                            C4990ab.m7416i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
                            C7060h.pYm.mo8378a(440, 205, 1, false);
                            AppMethodBeat.m2505o(60311);
                            return true;
                        }
                    }
                    baa.wDT = true;
                    AppMethodBeat.m2505o(60311);
                    return false;
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", e.getMessage(), str);
            if (baa != null) {
                baa.wDT = true;
            }
            AppMethodBeat.m2505o(60311);
            return false;
        }
    }

    /* renamed from: b */
    public static int m5790b(String str, VideoTransPara videoTransPara, baa baa, C28508d c28508d) {
        AppMethodBeat.m2504i(60312);
        if (baa != null && baa.wDP && C5730e.m8628ct(str)) {
            if (baa.wDT) {
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", str);
            }
            try {
                String str2;
                String substring;
                int i;
                String atb = C5730e.atb(str);
                if (atb.endsWith("/")) {
                    str2 = atb;
                } else {
                    str2 = atb + "/";
                }
                atb = new C5728b(str).getName();
                int lastIndexOf = atb.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    substring = atb.substring(0, lastIndexOf);
                } else {
                    substring = atb;
                }
                atb = str2 + substring + "_hd";
                if (str.endsWith(VideoMaterialUtil.MP4_SUFFIX)) {
                    atb = atb + VideoMaterialUtil.MP4_SUFFIX;
                }
                String str3 = str2 + substring + "tempRemuxing.mp4";
                C5730e.m8644y(str, atb);
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", str2, substring, atb, str3, Integer.valueOf(baa.wDQ));
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(atb);
                int i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i3 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int min = Math.min(i2, i3);
                if (min <= videoTransPara.width || (min > videoTransPara.width && min % 16 == 0 && Math.abs(min - videoTransPara.width) < 16)) {
                    i = i3;
                    min = i2;
                } else {
                    if (i2 < i3) {
                        min = videoTransPara.width;
                        i = (int) (((double) i3) / ((1.0d * ((double) i2)) / ((double) min)));
                    } else {
                        i = videoTransPara.width;
                        min = (int) (((double) i2) / ((1.0d * ((double) i3)) / ((double) i)));
                    }
                    if (i % 2 != 0) {
                        i++;
                    }
                    if (min % 2 != 0) {
                        min++;
                    }
                }
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(min), Integer.valueOf(i), videoTransPara);
                long yz = C5046bo.m7588yz();
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(min), Integer.valueOf(i), Integer.valueOf(SightVideoJNI.remuxing(atb, str3, min, i, videoTransPara.videoBitrate, videoTransPara.fzV, 8, videoTransPara.fzU, 25.0f, 30.0f, null, 0, false)), Long.valueOf(C5046bo.m7525az(yz)));
                C5730e.m8623aQ(str3, str);
                long yz2 = C5046bo.m7588yz();
                if (baa.wDP) {
                    SightVideoJNI.tagMP4Dscp(str, C42204d.afF().getWeixinMeta());
                    if (!C5046bo.isNullOrNil(baa.wDS)) {
                        SightVideoJNI.tagMp4RecordInfo(str, baa.wDS);
                    }
                    SightVideoJNI.optimizeMP4(str);
                }
                c28508d.bOc();
                C4990ab.m7417i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", Long.valueOf(C5046bo.m7525az(yz2)));
                AppMethodBeat.m2505o(60312);
                return r2;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", e.getMessage());
                AppMethodBeat.m2505o(60312);
                return -1;
            }
        }
        AppMethodBeat.m2505o(60312);
        return -1;
    }
}
