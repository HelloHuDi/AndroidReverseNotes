package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class l {
    public static boolean a(String str, VideoTransPara videoTransPara, baa baa, d dVar) {
        AppMethodBeat.i(60311);
        try {
            if (bo.isNullOrNil(str) || videoTransPara == null) {
                AppMethodBeat.o(60311);
                return false;
            }
            if (baa == null) {
                baa = new baa();
            }
            ab.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", Boolean.valueOf(baa.wDP), str, videoTransPara, Boolean.valueOf(baa.wDT));
            if (baa.wDT) {
                ab.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", str);
                AppMethodBeat.o(60311);
                return false;
            } else if (!baa.wDP || bo.isNullOrNil(str)) {
                AppMethodBeat.o(60311);
                return false;
            } else {
                SightVideoJNI.tagMP4Dscp(str, d.afF().getWeixinMeta());
                if (!bo.isNullOrNil(baa.wDS)) {
                    SightVideoJNI.tagMp4RecordInfo(str, baa.wDS);
                }
                long yz = bo.yz();
                SightVideoJNI.optimizeMP4(str);
                ab.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", Long.valueOf(bo.az(yz)));
                dVar.bOc();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int i = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i3 = bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                mediaMetadataRetriever.release();
                ab.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                ab.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s", Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height), Integer.valueOf(videoTransPara.videoBitrate));
                int min = Math.min(i, i2);
                boolean z = q.etj.etJ == 1;
                boolean z2 = bo.getInt(((a) g.K(a.class)).Nu().getValue("MMSightCheckSendVideoBitrate"), 0) == 1;
                float f = bo.getFloat(((a) g.K(a.class)).Nu().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3f);
                ab.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f));
                Object obj = (z || z2) ? 1 : null;
                if (min > videoTransPara.width && ((min <= videoTransPara.width || min % 16 != 0 || Math.abs(min - videoTransPara.width) >= 16) && (obj == null || ((float) i3) < ((float) videoTransPara.videoBitrate) * f))) {
                    AppMethodBeat.o(60311);
                    return true;
                } else if (baa.wDO) {
                    AppMethodBeat.o(60311);
                    return true;
                } else {
                    if (obj != null) {
                        if (((float) i3) >= ((float) videoTransPara.videoBitrate) * f) {
                            ab.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
                            h.pYm.a(440, 205, 1, false);
                            AppMethodBeat.o(60311);
                            return true;
                        }
                    }
                    baa.wDT = true;
                    AppMethodBeat.o(60311);
                    return false;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", e.getMessage(), str);
            if (baa != null) {
                baa.wDT = true;
            }
            AppMethodBeat.o(60311);
            return false;
        }
    }

    public static int b(String str, VideoTransPara videoTransPara, baa baa, d dVar) {
        AppMethodBeat.i(60312);
        if (baa != null && baa.wDP && e.ct(str)) {
            if (baa.wDT) {
                ab.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", str);
            }
            try {
                String str2;
                String substring;
                int i;
                String atb = e.atb(str);
                if (atb.endsWith("/")) {
                    str2 = atb;
                } else {
                    str2 = atb + "/";
                }
                atb = new b(str).getName();
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
                e.y(str, atb);
                ab.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", str2, substring, atb, str3, Integer.valueOf(baa.wDQ));
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(atb);
                int i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i3 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
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
                ab.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(min), Integer.valueOf(i), videoTransPara);
                long yz = bo.yz();
                ab.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(min), Integer.valueOf(i), Integer.valueOf(SightVideoJNI.remuxing(atb, str3, min, i, videoTransPara.videoBitrate, videoTransPara.fzV, 8, videoTransPara.fzU, 25.0f, 30.0f, null, 0, false)), Long.valueOf(bo.az(yz)));
                e.aQ(str3, str);
                long yz2 = bo.yz();
                if (baa.wDP) {
                    SightVideoJNI.tagMP4Dscp(str, d.afF().getWeixinMeta());
                    if (!bo.isNullOrNil(baa.wDS)) {
                        SightVideoJNI.tagMp4RecordInfo(str, baa.wDS);
                    }
                    SightVideoJNI.optimizeMP4(str);
                }
                dVar.bOc();
                ab.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", Long.valueOf(bo.az(yz2)));
                AppMethodBeat.o(60312);
                return r2;
            } catch (Exception e) {
                ab.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", e.getMessage());
                AppMethodBeat.o(60312);
                return -1;
            }
        }
        AppMethodBeat.o(60312);
        return -1;
    }
}
