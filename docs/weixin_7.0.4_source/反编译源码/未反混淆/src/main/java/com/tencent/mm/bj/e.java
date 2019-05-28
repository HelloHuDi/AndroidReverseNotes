package com.tencent.mm.bj;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.g.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class e {
    private static final Object fYf = new Object();

    static class a implements i<IPCVoid, IPCBoolean> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            boolean z;
            AppMethodBeat.i(50919);
            if (((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("HEVCTranscodeMediaCodec", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            IPCBoolean iPCBoolean = new IPCBoolean(z);
            AppMethodBeat.o(50919);
            return iPCBoolean;
        }
    }

    static /* synthetic */ void b(String str, String str2, VideoTransPara videoTransPara, long j) {
        AppMethodBeat.i(50929);
        a(str, str2, videoTransPara, j);
        AppMethodBeat.o(50929);
    }

    static /* synthetic */ void x(int i, long j) {
        AppMethodBeat.i(50930);
        w(i, j);
        AppMethodBeat.o(50930);
    }

    static {
        AppMethodBeat.i(50931);
        AppMethodBeat.o(50931);
    }

    public static boolean uD(String str) {
        AppMethodBeat.i(50920);
        ab.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime") && !bo.isNullOrNil(trackFormat.getString("mime"))) {
                    ab.i("MicroMsg.TransferUtil", "mime: %s", trackFormat.getString("mime"));
                    if (trackFormat.getString("mime").startsWith("video/hevc")) {
                        AppMethodBeat.o(50920);
                        return true;
                    }
                }
            }
            mediaExtractor.release();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TransferUtil", e, "check H265 error", new Object[0]);
        }
        AppMethodBeat.o(50920);
        return false;
    }

    public static VideoTransPara uE(String str) {
        AppMethodBeat.i(50921);
        ab.i("MicroMsg.TransferUtil", "buildPara：srcPath %s ", str);
        VideoTransPara videoTransPara = new VideoTransPara();
        ab.i("MicroMsg.TransferUtil", "Video format is h265 : %s", Boolean.valueOf(uD(str)));
        if (Boolean.valueOf(uD(str)).booleanValue()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            videoTransPara.duration = bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            videoTransPara.duration = bo.mA((long) videoTransPara.duration);
            videoTransPara.width = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            videoTransPara.height = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            videoTransPara.videoBitrate = bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
            a(str, videoTransPara);
            mediaMetadataRetriever.release();
        } else {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            d.a(str, pInt, pInt2, pInt3, pInt4, pInt5);
            videoTransPara.duration = bo.mA((long) pInt.value);
            videoTransPara.width = pInt2.value;
            videoTransPara.height = pInt3.value;
            videoTransPara.fps = pInt4.value;
            videoTransPara.videoBitrate = pInt5.value;
        }
        ab.d("MicroMsg.TransferUtil", "VideoPara is : %s", videoTransPara);
        AppMethodBeat.o(50921);
        return videoTransPara;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008b A:{Catch:{ all -> 0x00bc }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(String str, VideoTransPara videoTransPara) {
        Throwable e;
        com.tencent.mm.plugin.sight.base.a WR;
        AppMethodBeat.i(50922);
        MediaExtractor mediaExtractor;
        try {
            mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                for (int i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime") && !bo.isNullOrNil(trackFormat.getString("mime"))) {
                        ab.i("MicroMsg.TransferUtil", "mime: %s", trackFormat.getString("mime"));
                        if (trackFormat.getString("mime").startsWith("video/")) {
                            videoTransPara.fps = trackFormat.getInteger("frame-rate");
                            ab.i("MicroMsg.TransferUtil", "fps: %s", Integer.valueOf(videoTransPara.fps));
                            break;
                        }
                    }
                }
                mediaExtractor.release();
                AppMethodBeat.o(50922);
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.printErrStackTrace("MicroMsg.TransferUtil", e, "find fps error", new Object[0]);
                    WR = d.WR(str);
                    if (WR != null) {
                    }
                    if (mediaExtractor == null) {
                    }
                } catch (Throwable th) {
                    e = th;
                    if (mediaExtractor != null) {
                    }
                    AppMethodBeat.o(50922);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaExtractor = null;
            ab.printErrStackTrace("MicroMsg.TransferUtil", e, "find fps error", new Object[0]);
            WR = d.WR(str);
            if (WR != null) {
                videoTransPara.fps = WR.eTk;
                ab.i("MicroMsg.TransferUtil", "set fps from getMedia: %s", Integer.valueOf(WR.eTk));
            }
            if (mediaExtractor == null) {
                mediaExtractor.release();
                AppMethodBeat.o(50922);
                return;
            }
            AppMethodBeat.o(50922);
        } catch (Throwable th2) {
            e = th2;
            mediaExtractor = null;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            AppMethodBeat.o(50922);
            throw e;
        }
    }

    public static VideoTransPara a(VideoTransPara videoTransPara, String str) {
        AppMethodBeat.i(50923);
        VideoTransPara b = com.tencent.mm.modelcontrol.d.afF().b(videoTransPara);
        if (b == null) {
            ab.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", videoTransPara);
            b = uF(str);
            AppMethodBeat.o(50923);
            return b;
        }
        ab.d("MicroMsg.TransferUtil", "compress new para is %s", b);
        if (videoTransPara.videoBitrate <= 640000 || b.videoBitrate > videoTransPara.videoBitrate) {
            ab.i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", b, videoTransPara);
            b = uF(str);
            AppMethodBeat.o(50923);
            return b;
        } else if (videoTransPara.fps < 45 || videoTransPara.duration * 1000 < 180000) {
            AppMethodBeat.o(50923);
            return b;
        } else {
            b = uF(str);
            AppMethodBeat.o(50923);
            return b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6 A:{SYNTHETIC, Splitter:B:39:0x00a6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static VideoTransPara uF(String str) {
        Throwable th;
        AppMethodBeat.i(50924);
        try {
            VideoTransPara videoTransPara = new VideoTransPara();
            int[] iArr = new int[2];
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    int i = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                    int i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                    iArr[0] = i;
                    iArr[1] = i2;
                    int i3 = 0;
                    while (i3 < 3) {
                        if (i % 2 == 0 && i2 % 2 == 0) {
                            if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                                break;
                            }
                            i /= 2;
                            i2 /= 2;
                            i3++;
                        } else {
                            mediaMetadataRetriever.release();
                            break;
                        }
                    }
                    iArr[0] = i;
                    iArr[1] = i2;
                    mediaMetadataRetriever.release();
                    videoTransPara.width = iArr[0];
                    videoTransPara.height = iArr[1];
                    videoTransPara.videoBitrate = b.qwZ;
                    videoTransPara.fzV = b.qwY;
                    videoTransPara.fzU = 2;
                    videoTransPara.fps = (int) b.qxa;
                    videoTransPara.duration = ea(str);
                    AppMethodBeat.o(50924);
                    return videoTransPara;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    AppMethodBeat.o(50924);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                }
                AppMethodBeat.o(50924);
                throw th;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TransferUtil", e, "compressBitrateDefault failed: %s", e.getMessage());
            AppMethodBeat.o(50924);
            return null;
        }
    }

    public static int ea(String str) {
        int i = 0;
        AppMethodBeat.i(50925);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        mediaMetadataRetriever.release();
        if (extractMetadata == null) {
            AppMethodBeat.o(50925);
        } else {
            try {
                i = Integer.valueOf(extractMetadata).intValue();
                AppMethodBeat.o(50925);
            } catch (Exception e) {
                ab.e("MicroMsg.TransferUtil", "getDuration error %s", e.getMessage());
                AppMethodBeat.o(50925);
            }
        }
        return i;
    }

    public static int a(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.i(50926);
        ab.i("MicroMsg.TransferUtil", "Begin to local tranfer");
        final long yz = bo.yz();
        final String str3 = str;
        final String str4 = str2;
        final VideoTransPara videoTransPara2 = videoTransPara;
        AnonymousClass1 anonymousClass1 = new c.b() {
            public final void lW(String str) {
                AppMethodBeat.i(50918);
                ab.i("MicroMsg.TransferUtil", "mediaCodecRemuxer remux onFinish");
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.TransferUtil", "MediaCodecRemuxer remux failed, ret path is null, retry x264");
                    try {
                        e.b(str3, str4, videoTransPara2, yz);
                    } catch (Exception e) {
                        ab.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer error!!!");
                        e.x(-1, yz);
                    }
                    synchronized (e.fYf) {
                        try {
                            e.fYf.notifyAll();
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.TransferUtil", e2, "wait mediaCodecRemuxer error", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.o(50918);
                        }
                    }
                    AppMethodBeat.o(50918);
                    return;
                }
                e.x(0, yz);
                synchronized (e.fYf) {
                    try {
                        e.fYf.notifyAll();
                    } catch (Exception e22) {
                        ab.printErrStackTrace("MicroMsg.TransferUtil", e22, "wait mediaCodecRemuxer error", new Object[0]);
                    } catch (Throwable th2) {
                        AppMethodBeat.o(50918);
                    }
                }
                AppMethodBeat.o(50918);
            }
        };
        boolean z = true;
        try {
            g gVar;
            c cVar;
            int i;
            if (ah.bqo()) {
                z = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("HEVCTranscodeMediaCodec", 1) == 1;
            } else {
                IPCBoolean iPCBoolean = (IPCBoolean) f.a("com.tencent.mm", new IPCVoid(), a.class);
                if (iPCBoolean != null) {
                    z = iPCBoolean.value;
                }
            }
            int i2 = q.etn.esH;
            boolean z2 = i2 != -1 ? i2 == 1 : !z;
            ab.i("MicroMsg.TransferUtil", "serverConfigMediaCodec: %s, dynamicConfigX264: %s, useX264: %s", Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2));
            if (z2) {
                gVar = new g();
                gVar.b(str, str2, videoTransPara);
                gVar.fYu = true;
                gVar.fYv = z2;
                cVar = null;
            } else {
                com.tencent.mm.plugin.sight.base.a WR = d.WR(str);
                if (WR != null && WR.eTk > 0) {
                    videoTransPara.fps = (int) Math.min(30.0f, (float) WR.eTk);
                    ab.i("MicroMsg.TransferUtil", "transfer h265 use 30fps, newPara.fps:%s, mediaInfo.frameRate:%s", Integer.valueOf(videoTransPara.fps), Integer.valueOf(WR.eTk));
                }
                cVar = c.eXz.a(str, str2, videoTransPara.width, videoTransPara.height, videoTransPara.videoBitrate, videoTransPara.fps, anonymousClass1);
                gVar = null;
            }
            if (gVar == null || !z2) {
                if (cVar != null) {
                    try {
                        ab.i("MicroMsg.TransferUtil", "start mediaCodecRemuxer remux");
                        cVar.Va();
                        synchronized (fYf) {
                            try {
                                fYf.wait();
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.TransferUtil", e, "wait mediaCodecRemux error", new Object[0]);
                            } catch (Throwable th) {
                                AppMethodBeat.o(50926);
                            }
                        }
                        ab.i("MicroMsg.TransferUtil", "mediaCodecRemuxLock wait finish");
                        i = 0;
                    } catch (Exception e2) {
                        ab.i("MicroMsg.TransferUtil", "MediaCodecRemuxer remux, retry x264, error:%s", e2.getMessage());
                        a(str, str2, videoTransPara, yz);
                    }
                }
                i = 0;
            } else {
                try {
                    i = gVar.fW((long) ea(str));
                    w(i, yz);
                } catch (Exception e22) {
                    Exception exception = e22;
                    i = -1;
                    ab.e("MicroMsg.TransferUtil", "Local tranfer to H264 error: %s", exception.getMessage());
                    b.fXS.WY();
                } catch (Throwable th2) {
                    b.fXS.WY();
                    AppMethodBeat.o(50926);
                }
            }
            b.fXS.WY();
            AppMethodBeat.o(50926);
            return i;
        } catch (Exception e222) {
            ab.e("MicroMsg.TransferUtil", "Local tranfer init failed: %s", e222.getMessage());
            AppMethodBeat.o(50926);
            return -1;
        }
    }

    private static void a(String str, String str2, VideoTransPara videoTransPara, long j) {
        AppMethodBeat.i(50927);
        ab.c("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", str, str2, videoTransPara);
        g gVar = new g();
        gVar.b(str, str2, videoTransPara);
        gVar.fYu = true;
        gVar.fYv = true;
        ab.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", Integer.valueOf(gVar.fW((long) ea(str))));
        w(r0, j);
        AppMethodBeat.o(50927);
    }

    private static void w(int i, long j) {
        AppMethodBeat.i(50928);
        if (i < 0) {
            ab.i("MicroMsg.TransferUtil", "Local tranfer to H264 failed：%s", Integer.valueOf(i));
        }
        ab.i("MicroMsg.TransferUtil", "Transfer Finish");
        ab.i("MicroMsg.TransferUtil", "totalTime：%d", Long.valueOf(bo.yz() - j));
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX);
        iDKey.SetKey(com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA);
        iDKey.SetValue(r0);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX);
        iDKey2.SetKey(com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED);
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.pYm.b(arrayList, false);
        AppMethodBeat.o(50928);
    }
}
