package com.tencent.p177mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p230g.p231a.C26232ri;
import com.tencent.p177mm.p612ui.C5510e.C5504k;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Set;

/* renamed from: com.tencent.mm.modelsns.a */
public final class C26476a {
    public static Set<String> fPS;

    /* renamed from: com.tencent.mm.modelsns.a$a */
    public static class C26477a {
        public String fPT;
        public String fPU;
        public String fPV;
        public int fPW = -1;
        public int fPX = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoWidth = -1;

        /* renamed from: tw */
        public static C26477a m42193tw(String str) {
            AppMethodBeat.m2504i(16606);
            MediaExtractor mediaExtractor = new MediaExtractor();
            C26477a c26477a = new C26477a();
            c26477a.fPT = str;
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                MediaFormat mediaFormat = null;
                MediaFormat mediaFormat2 = null;
                for (int i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime")) {
                        String string = trackFormat.getString("mime");
                        C4990ab.m7417i("MicroMsg.ShareSnsImpl", "find video mime : %s", string);
                        if (string != null) {
                            if (string.startsWith("video/")) {
                                if (mediaFormat2 == null) {
                                    mediaFormat2 = trackFormat;
                                }
                            } else if (string.startsWith("audio/") && r0 == null) {
                                mediaFormat = trackFormat;
                            }
                            if (!(mediaFormat == null || r1 == null)) {
                                break;
                            }
                        }
                        continue;
                    } else {
                        C4990ab.m7416i("MicroMsg.ShareSnsImpl", "find video mime : not found.");
                    }
                }
                MediaFormat mediaFormat3 = mediaFormat;
                if (mediaFormat2 != null) {
                    c26477a.fPW = !mediaFormat2.containsKey("durationUs") ? 0 : (int) (mediaFormat2.getLong("durationUs") / 1000);
                    c26477a.videoHeight = !mediaFormat2.containsKey("height") ? 0 : mediaFormat2.getInteger("height");
                    c26477a.videoWidth = !mediaFormat2.containsKey("width") ? 0 : mediaFormat2.getInteger("width");
                    c26477a.fPU = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                    c26477a.videoBitRate = !mediaFormat2.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat2.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    c26477a.fPX = !mediaFormat2.containsKey("i-frame-interval") ? 0 : mediaFormat2.getInteger("i-frame-interval");
                    c26477a.videoFrameRate = !mediaFormat2.containsKey("frame-rate") ? 0 : mediaFormat2.getInteger("frame-rate");
                }
                if (mediaFormat3 != null) {
                    c26477a.fPV = !mediaFormat3.containsKey("mime") ? "" : mediaFormat3.getString("mime");
                }
                mediaExtractor.release();
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.ShareSnsImpl", "Video extractor init failed. video path = [%s] e = [%s]", str, e.getMessage());
                mediaExtractor.release();
            } catch (Throwable th) {
                mediaExtractor.release();
                AppMethodBeat.m2505o(16606);
            }
            AppMethodBeat.m2505o(16606);
            return c26477a;
        }
    }

    /* renamed from: a */
    public static Intent m42191a(int i, WXMediaMessage wXMediaMessage, String str, String str2, boolean z) {
        int i2;
        AppMethodBeat.m2504i(16607);
        C4990ab.m7410d("MicroMsg.ShareSnsImpl", "appmsg.description " + wXMediaMessage.description);
        C4990ab.m7410d("MicroMsg.ShareSnsImpl", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i2 = 2;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 5;
                break;
            case 5:
            case 6:
                i2 = 3;
                break;
            case 7:
                i2 = 3;
                break;
            case 38:
            case 39:
                i2 = 15;
                break;
            default:
                i2 = -1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("KThrid_app", true);
        C4990ab.m7410d("MicroMsg.ShareSnsImpl", "TimeLineType " + i2 + " " + iMediaObject.type());
        intent.putExtra("Ksnsupload_appid", str);
        intent.putExtra("Ksnsupload_appname", str2);
        intent.putExtra("Ksnsupload_open_sdk_version", i);
        intent.putExtra("KSnsAction", true);
        intent.putExtra("need_result", true);
        intent.putExtra("Ksnsupload_app_is_game", z);
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        if (i2 == -1) {
            C4990ab.m7410d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
            AppMethodBeat.m2505o(16607);
            return null;
        }
        String bc;
        String str3;
        String atg;
        StringBuilder stringBuilder;
        Bitmap tv;
        Options amj;
        switch (iMediaObject.type()) {
            case 1:
                intent.putExtra(C5504k.ygd, ((WXTextObject) iMediaObject).text);
                intent.putExtra("Ksnsupload_type", 8);
                AppMethodBeat.m2505o(16607);
                return intent;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", wXImageObject.imagePath);
                AppMethodBeat.m2505o(16607);
                return intent;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                bc = C5046bo.m7532bc(!C5046bo.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                C5046bo.m7532bc(!C5046bo.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                C5046bo.m7532bc(!C5046bo.isNullOrNil(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, "");
                intent.putExtra("Ksnsupload_link", bc);
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 2);
                intent.putExtra("ksnsis_music", true);
                AppMethodBeat.m2505o(16607);
                return intent;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                intent.putExtra("Ksnsupload_link", C5046bo.m7532bc(!C5046bo.isNullOrNil(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""));
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("ksnsis_video", true);
                AppMethodBeat.m2505o(16607);
                return intent;
            case 5:
                intent.putExtra("Ksnsupload_link", ((WXWebpageObject) iMediaObject).webpageUrl);
                intent.putExtra("Ksnsupload_title", C5046bo.m7532bc(wXMediaMessage.title, ""));
                intent.putExtra("Ksnsupload_imgbuf", wXMediaMessage.thumbData);
                intent.putExtra("Ksnsupload_type", 1);
                AppMethodBeat.m2505o(16607);
                return intent;
            case 6:
                C4990ab.m7412e("MicroMsg.ShareSnsImpl", "file is not support!");
                AppMethodBeat.m2505o(16607);
                return null;
            case 7:
                AppMethodBeat.m2505o(16607);
                return null;
            case 38:
                WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                bc = wXVideoFileObject.filePath;
                str3 = "";
                atg = C5730e.atg(bc);
                if (C5046bo.isNullOrNil(str3) || !C5730e.m8628ct(str3)) {
                    stringBuilder = new StringBuilder();
                    C9638aw.m17190ZK();
                    str3 = stringBuilder.append(C18628c.getAccSnsTmpPath()).append(atg).toString();
                    try {
                        tv = C26476a.m42192tv(bc);
                        if (tv != null) {
                            C4990ab.m7417i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", Integer.valueOf(tv.getWidth()), Integer.valueOf(tv.getHeight()));
                            C5056d.m7625a(tv, 80, CompressFormat.JPEG, str3, true);
                            amj = C5056d.amj(str3);
                            C4990ab.m7417i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        } else {
                            C4990ab.m7413e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", bc);
                            AppMethodBeat.m2505o(16607);
                            return null;
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.ShareSnsImpl", "savebitmap error %s", e.getMessage());
                    }
                }
                intent.putExtra("KSightPath", bc);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", atg);
                AppMethodBeat.m2505o(16607);
                return intent;
            case 39:
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                bc = wXGameVideoFileObject.filePath;
                String str4 = "";
                C4990ab.m7417i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", bc, str4, wXGameVideoFileObject.videoUrl, wXGameVideoFileObject.thumbUrl);
                String atg2 = C5730e.atg(bc);
                if (C5046bo.isNullOrNil(str4) || !C5730e.m8628ct(str4)) {
                    stringBuilder = new StringBuilder();
                    C9638aw.m17190ZK();
                    str3 = stringBuilder.append(C18628c.getAccSnsTmpPath()).append(atg2).toString();
                    try {
                        tv = C26476a.m42192tv(bc);
                        if (tv != null) {
                            C4990ab.m7417i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", Integer.valueOf(tv.getWidth()), Integer.valueOf(tv.getHeight()));
                            C5056d.m7625a(tv, 80, CompressFormat.JPEG, str3, true);
                            amj = C5056d.amj(str3);
                            C4990ab.m7417i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        } else {
                            C4990ab.m7413e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", bc);
                            AppMethodBeat.m2505o(16607);
                            return null;
                        }
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.ShareSnsImpl", "savebitmap error %s", e2.getMessage());
                    }
                } else {
                    str3 = str4;
                }
                intent.putExtra("KSightPath", bc);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", atg2);
                intent.putExtra("KSightCdnUrl", atg);
                intent.putExtra("KSightCdnThumbUrl", r6);
                AppMethodBeat.m2505o(16607);
                return intent;
            default:
                C4990ab.m7412e("MicroMsg.ShareSnsImpl", "none type not support!");
                AppMethodBeat.m2505o(16607);
                return null;
        }
    }

    /* renamed from: tv */
    private static Bitmap m42192tv(String str) {
        AppMethodBeat.m2504i(16608);
        C26232ri c26232ri = new C26232ri();
        c26232ri.cNn.cNp = str;
        C4879a.xxA.mo10055m(c26232ri);
        Bitmap bitmap = (Bitmap) c26232ri.cNo.result;
        AppMethodBeat.m2505o(16608);
        return bitmap;
    }
}
