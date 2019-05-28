package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.e.k;
import com.tencent.mm.vfs.e;
import java.util.Set;

public final class a {
    public static Set<String> fPS;

    public static class a {
        public String fPT;
        public String fPU;
        public String fPV;
        public int fPW = -1;
        public int fPX = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoWidth = -1;

        public static a tw(String str) {
            AppMethodBeat.i(16606);
            MediaExtractor mediaExtractor = new MediaExtractor();
            a aVar = new a();
            aVar.fPT = str;
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                MediaFormat mediaFormat = null;
                MediaFormat mediaFormat2 = null;
                for (int i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime")) {
                        String string = trackFormat.getString("mime");
                        ab.i("MicroMsg.ShareSnsImpl", "find video mime : %s", string);
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
                        ab.i("MicroMsg.ShareSnsImpl", "find video mime : not found.");
                    }
                }
                MediaFormat mediaFormat3 = mediaFormat;
                if (mediaFormat2 != null) {
                    aVar.fPW = !mediaFormat2.containsKey("durationUs") ? 0 : (int) (mediaFormat2.getLong("durationUs") / 1000);
                    aVar.videoHeight = !mediaFormat2.containsKey("height") ? 0 : mediaFormat2.getInteger("height");
                    aVar.videoWidth = !mediaFormat2.containsKey("width") ? 0 : mediaFormat2.getInteger("width");
                    aVar.fPU = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                    aVar.videoBitRate = !mediaFormat2.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat2.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    aVar.fPX = !mediaFormat2.containsKey("i-frame-interval") ? 0 : mediaFormat2.getInteger("i-frame-interval");
                    aVar.videoFrameRate = !mediaFormat2.containsKey("frame-rate") ? 0 : mediaFormat2.getInteger("frame-rate");
                }
                if (mediaFormat3 != null) {
                    aVar.fPV = !mediaFormat3.containsKey("mime") ? "" : mediaFormat3.getString("mime");
                }
                mediaExtractor.release();
            } catch (Exception e) {
                ab.i("MicroMsg.ShareSnsImpl", "Video extractor init failed. video path = [%s] e = [%s]", str, e.getMessage());
                mediaExtractor.release();
            } catch (Throwable th) {
                mediaExtractor.release();
                AppMethodBeat.o(16606);
            }
            AppMethodBeat.o(16606);
            return aVar;
        }
    }

    public static Intent a(int i, WXMediaMessage wXMediaMessage, String str, String str2, boolean z) {
        int i2;
        AppMethodBeat.i(16607);
        ab.d("MicroMsg.ShareSnsImpl", "appmsg.description " + wXMediaMessage.description);
        ab.d("MicroMsg.ShareSnsImpl", "appmsg.title " + wXMediaMessage.title);
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
        ab.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i2 + " " + iMediaObject.type());
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
            ab.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
            AppMethodBeat.o(16607);
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
                intent.putExtra(k.ygd, ((WXTextObject) iMediaObject).text);
                intent.putExtra("Ksnsupload_type", 8);
                AppMethodBeat.o(16607);
                return intent;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", wXImageObject.imagePath);
                AppMethodBeat.o(16607);
                return intent;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                bc = bo.bc(!bo.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                bo.bc(!bo.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                bo.bc(!bo.isNullOrNil(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, "");
                intent.putExtra("Ksnsupload_link", bc);
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 2);
                intent.putExtra("ksnsis_music", true);
                AppMethodBeat.o(16607);
                return intent;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                intent.putExtra("Ksnsupload_link", bo.bc(!bo.isNullOrNil(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""));
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("ksnsis_video", true);
                AppMethodBeat.o(16607);
                return intent;
            case 5:
                intent.putExtra("Ksnsupload_link", ((WXWebpageObject) iMediaObject).webpageUrl);
                intent.putExtra("Ksnsupload_title", bo.bc(wXMediaMessage.title, ""));
                intent.putExtra("Ksnsupload_imgbuf", wXMediaMessage.thumbData);
                intent.putExtra("Ksnsupload_type", 1);
                AppMethodBeat.o(16607);
                return intent;
            case 6:
                ab.e("MicroMsg.ShareSnsImpl", "file is not support!");
                AppMethodBeat.o(16607);
                return null;
            case 7:
                AppMethodBeat.o(16607);
                return null;
            case 38:
                WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                bc = wXVideoFileObject.filePath;
                str3 = "";
                atg = e.atg(bc);
                if (bo.isNullOrNil(str3) || !e.ct(str3)) {
                    stringBuilder = new StringBuilder();
                    aw.ZK();
                    str3 = stringBuilder.append(c.getAccSnsTmpPath()).append(atg).toString();
                    try {
                        tv = tv(bc);
                        if (tv != null) {
                            ab.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", Integer.valueOf(tv.getWidth()), Integer.valueOf(tv.getHeight()));
                            d.a(tv, 80, CompressFormat.JPEG, str3, true);
                            amj = d.amj(str3);
                            ab.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        } else {
                            ab.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", bc);
                            AppMethodBeat.o(16607);
                            return null;
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", e.getMessage());
                    }
                }
                intent.putExtra("KSightPath", bc);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", atg);
                AppMethodBeat.o(16607);
                return intent;
            case 39:
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                bc = wXGameVideoFileObject.filePath;
                String str4 = "";
                ab.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", bc, str4, wXGameVideoFileObject.videoUrl, wXGameVideoFileObject.thumbUrl);
                String atg2 = e.atg(bc);
                if (bo.isNullOrNil(str4) || !e.ct(str4)) {
                    stringBuilder = new StringBuilder();
                    aw.ZK();
                    str3 = stringBuilder.append(c.getAccSnsTmpPath()).append(atg2).toString();
                    try {
                        tv = tv(bc);
                        if (tv != null) {
                            ab.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", Integer.valueOf(tv.getWidth()), Integer.valueOf(tv.getHeight()));
                            d.a(tv, 80, CompressFormat.JPEG, str3, true);
                            amj = d.amj(str3);
                            ab.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                        } else {
                            ab.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", bc);
                            AppMethodBeat.o(16607);
                            return null;
                        }
                    } catch (Exception e2) {
                        ab.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", e2.getMessage());
                    }
                } else {
                    str3 = str4;
                }
                intent.putExtra("KSightPath", bc);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", atg2);
                intent.putExtra("KSightCdnUrl", atg);
                intent.putExtra("KSightCdnThumbUrl", r6);
                AppMethodBeat.o(16607);
                return intent;
            default:
                ab.e("MicroMsg.ShareSnsImpl", "none type not support!");
                AppMethodBeat.o(16607);
                return null;
        }
    }

    private static Bitmap tv(String str) {
        AppMethodBeat.i(16608);
        ri riVar = new ri();
        riVar.cNn.cNp = str;
        com.tencent.mm.sdk.b.a.xxA.m(riVar);
        Bitmap bitmap = (Bitmap) riVar.cNo.result;
        AppMethodBeat.o(16608);
        return bitmap;
    }
}
