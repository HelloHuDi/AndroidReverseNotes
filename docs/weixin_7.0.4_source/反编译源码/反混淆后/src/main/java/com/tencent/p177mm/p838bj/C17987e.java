package com.tencent.p177mm.p838bj;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.media.p254g.C37894c;
import com.tencent.p177mm.media.p254g.C37894c.C37895b;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33379c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.bj.e */
public final class C17987e {
    private static final Object fYf = new Object();

    /* renamed from: com.tencent.mm.bj.e$a */
    static class C17988a implements C45413i<IPCVoid, IPCBoolean> {
        private C17988a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            boolean z;
            AppMethodBeat.m2504i(50919);
            if (((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("HEVCTranscodeMediaCodec", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            IPCBoolean iPCBoolean = new IPCBoolean(z);
            AppMethodBeat.m2505o(50919);
            return iPCBoolean;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m28305b(String str, String str2, VideoTransPara videoTransPara, long j) {
        AppMethodBeat.m2504i(50929);
        C17987e.m28303a(str, str2, videoTransPara, j);
        AppMethodBeat.m2505o(50929);
    }

    /* renamed from: x */
    static /* synthetic */ void m28311x(int i, long j) {
        AppMethodBeat.m2504i(50930);
        C17987e.m28310w(i, j);
        AppMethodBeat.m2505o(50930);
    }

    static {
        AppMethodBeat.m2504i(50931);
        AppMethodBeat.m2505o(50931);
    }

    /* renamed from: uD */
    public static boolean m28307uD(String str) {
        AppMethodBeat.m2504i(50920);
        C4990ab.m7416i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime") && !C5046bo.isNullOrNil(trackFormat.getString("mime"))) {
                    C4990ab.m7417i("MicroMsg.TransferUtil", "mime: %s", trackFormat.getString("mime"));
                    if (trackFormat.getString("mime").startsWith("video/hevc")) {
                        AppMethodBeat.m2505o(50920);
                        return true;
                    }
                }
            }
            mediaExtractor.release();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TransferUtil", e, "check H265 error", new Object[0]);
        }
        AppMethodBeat.m2505o(50920);
        return false;
    }

    /* renamed from: uE */
    public static VideoTransPara m28308uE(String str) {
        AppMethodBeat.m2504i(50921);
        C4990ab.m7417i("MicroMsg.TransferUtil", "buildPara：srcPath %s ", str);
        VideoTransPara videoTransPara = new VideoTransPara();
        C4990ab.m7417i("MicroMsg.TransferUtil", "Video format is h265 : %s", Boolean.valueOf(C17987e.m28307uD(str)));
        if (Boolean.valueOf(C17987e.m28307uD(str)).booleanValue()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            videoTransPara.duration = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            videoTransPara.duration = C5046bo.m7576mA((long) videoTransPara.duration);
            videoTransPara.width = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            videoTransPara.height = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            videoTransPara.videoBitrate = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
            C17987e.m28302a(str, videoTransPara);
            mediaMetadataRetriever.release();
        } else {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            C21846d.m33389a(str, pInt, pInt2, pInt3, pInt4, pInt5);
            videoTransPara.duration = C5046bo.m7576mA((long) pInt.value);
            videoTransPara.width = pInt2.value;
            videoTransPara.height = pInt3.value;
            videoTransPara.fps = pInt4.value;
            videoTransPara.videoBitrate = pInt5.value;
        }
        C4990ab.m7411d("MicroMsg.TransferUtil", "VideoPara is : %s", videoTransPara);
        AppMethodBeat.m2505o(50921);
        return videoTransPara;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008b A:{Catch:{ all -> 0x00bc }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m28302a(String str, VideoTransPara videoTransPara) {
        Throwable e;
        C43528a WR;
        AppMethodBeat.m2504i(50922);
        MediaExtractor mediaExtractor;
        try {
            mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                for (int i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime") && !C5046bo.isNullOrNil(trackFormat.getString("mime"))) {
                        C4990ab.m7417i("MicroMsg.TransferUtil", "mime: %s", trackFormat.getString("mime"));
                        if (trackFormat.getString("mime").startsWith("video/")) {
                            videoTransPara.fps = trackFormat.getInteger("frame-rate");
                            C4990ab.m7417i("MicroMsg.TransferUtil", "fps: %s", Integer.valueOf(videoTransPara.fps));
                            break;
                        }
                    }
                }
                mediaExtractor.release();
                AppMethodBeat.m2505o(50922);
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.TransferUtil", e, "find fps error", new Object[0]);
                    WR = C21846d.m33388WR(str);
                    if (WR != null) {
                    }
                    if (mediaExtractor == null) {
                    }
                } catch (Throwable th) {
                    e = th;
                    if (mediaExtractor != null) {
                    }
                    AppMethodBeat.m2505o(50922);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaExtractor = null;
            C4990ab.printErrStackTrace("MicroMsg.TransferUtil", e, "find fps error", new Object[0]);
            WR = C21846d.m33388WR(str);
            if (WR != null) {
                videoTransPara.fps = WR.eTk;
                C4990ab.m7417i("MicroMsg.TransferUtil", "set fps from getMedia: %s", Integer.valueOf(WR.eTk));
            }
            if (mediaExtractor == null) {
                mediaExtractor.release();
                AppMethodBeat.m2505o(50922);
                return;
            }
            AppMethodBeat.m2505o(50922);
        } catch (Throwable th2) {
            e = th2;
            mediaExtractor = null;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            AppMethodBeat.m2505o(50922);
            throw e;
        }
    }

    /* renamed from: a */
    public static VideoTransPara m28301a(VideoTransPara videoTransPara, String str) {
        AppMethodBeat.m2504i(50923);
        VideoTransPara b = C42204d.afF().mo67741b(videoTransPara);
        if (b == null) {
            C4990ab.m7417i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", videoTransPara);
            b = C17987e.m28309uF(str);
            AppMethodBeat.m2505o(50923);
            return b;
        }
        C4990ab.m7411d("MicroMsg.TransferUtil", "compress new para is %s", b);
        if (videoTransPara.videoBitrate <= 640000 || b.videoBitrate > videoTransPara.videoBitrate) {
            C4990ab.m7417i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", b, videoTransPara);
            b = C17987e.m28309uF(str);
            AppMethodBeat.m2505o(50923);
            return b;
        } else if (videoTransPara.fps < 45 || videoTransPara.duration * 1000 < 180000) {
            AppMethodBeat.m2505o(50923);
            return b;
        } else {
            b = C17987e.m28309uF(str);
            AppMethodBeat.m2505o(50923);
            return b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6 A:{SYNTHETIC, Splitter:B:39:0x00a6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: uF */
    private static VideoTransPara m28309uF(String str) {
        Throwable th;
        AppMethodBeat.m2504i(50924);
        try {
            VideoTransPara videoTransPara = new VideoTransPara();
            int[] iArr = new int[2];
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    int i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                    int i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
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
                    videoTransPara.videoBitrate = C29014b.qwZ;
                    videoTransPara.fzV = C29014b.qwY;
                    videoTransPara.fzU = 2;
                    videoTransPara.fps = (int) C29014b.qxa;
                    videoTransPara.duration = C17987e.m28306ea(str);
                    AppMethodBeat.m2505o(50924);
                    return videoTransPara;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    AppMethodBeat.m2505o(50924);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                }
                AppMethodBeat.m2505o(50924);
                throw th;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TransferUtil", e, "compressBitrateDefault failed: %s", e.getMessage());
            AppMethodBeat.m2505o(50924);
            return null;
        }
    }

    /* renamed from: ea */
    public static int m28306ea(String str) {
        int i = 0;
        AppMethodBeat.m2504i(50925);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        mediaMetadataRetriever.release();
        if (extractMetadata == null) {
            AppMethodBeat.m2505o(50925);
        } else {
            try {
                i = Integer.valueOf(extractMetadata).intValue();
                AppMethodBeat.m2505o(50925);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.TransferUtil", "getDuration error %s", e.getMessage());
                AppMethodBeat.m2505o(50925);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static int m28300a(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(50926);
        C4990ab.m7416i("MicroMsg.TransferUtil", "Begin to local tranfer");
        final long yz = C5046bo.m7588yz();
        final String str3 = str;
        final String str4 = str2;
        final VideoTransPara videoTransPara2 = videoTransPara;
        C179861 c179861 = new C37895b() {
            /* renamed from: lW */
            public final void mo21981lW(String str) {
                AppMethodBeat.m2504i(50918);
                C4990ab.m7416i("MicroMsg.TransferUtil", "mediaCodecRemuxer remux onFinish");
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.TransferUtil", "MediaCodecRemuxer remux failed, ret path is null, retry x264");
                    try {
                        C17987e.m28305b(str3, str4, videoTransPara2, yz);
                    } catch (Exception e) {
                        C4990ab.m7416i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer error!!!");
                        C17987e.m28311x(-1, yz);
                    }
                    synchronized (C17987e.fYf) {
                        try {
                            C17987e.fYf.notifyAll();
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.TransferUtil", e2, "wait mediaCodecRemuxer error", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(50918);
                        }
                    }
                    AppMethodBeat.m2505o(50918);
                    return;
                }
                C17987e.m28311x(0, yz);
                synchronized (C17987e.fYf) {
                    try {
                        C17987e.fYf.notifyAll();
                    } catch (Exception e22) {
                        C4990ab.printErrStackTrace("MicroMsg.TransferUtil", e22, "wait mediaCodecRemuxer error", new Object[0]);
                    } catch (Throwable th2) {
                        AppMethodBeat.m2505o(50918);
                    }
                }
                AppMethodBeat.m2505o(50918);
            }
        };
        boolean z = true;
        try {
            C9084g c9084g;
            C37894c c37894c;
            int i;
            if (C4996ah.bqo()) {
                z = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("HEVCTranscodeMediaCodec", 1) == 1;
            } else {
                IPCBoolean iPCBoolean = (IPCBoolean) C9549f.m17010a("com.tencent.mm", new IPCVoid(), C17988a.class);
                if (iPCBoolean != null) {
                    z = iPCBoolean.value;
                }
            }
            int i2 = C1427q.etn.esH;
            boolean z2 = i2 != -1 ? i2 == 1 : !z;
            C4990ab.m7417i("MicroMsg.TransferUtil", "serverConfigMediaCodec: %s, dynamicConfigX264: %s, useX264: %s", Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2));
            if (z2) {
                c9084g = new C9084g();
                c9084g.mo20567b(str, str2, videoTransPara);
                c9084g.fYu = true;
                c9084g.fYv = z2;
                c37894c = null;
            } else {
                C43528a WR = C21846d.m33388WR(str);
                if (WR != null && WR.eTk > 0) {
                    videoTransPara.fps = (int) Math.min(30.0f, (float) WR.eTk);
                    C4990ab.m7417i("MicroMsg.TransferUtil", "transfer h265 use 30fps, newPara.fps:%s, mediaInfo.frameRate:%s", Integer.valueOf(videoTransPara.fps), Integer.valueOf(WR.eTk));
                }
                c37894c = C37894c.eXz.mo20921a(str, str2, videoTransPara.width, videoTransPara.height, videoTransPara.videoBitrate, videoTransPara.fps, c179861);
                c9084g = null;
            }
            if (c9084g == null || !z2) {
                if (c37894c != null) {
                    try {
                        C4990ab.m7416i("MicroMsg.TransferUtil", "start mediaCodecRemuxer remux");
                        c37894c.mo53305Va();
                        synchronized (fYf) {
                            try {
                                fYf.wait();
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.TransferUtil", e, "wait mediaCodecRemux error", new Object[0]);
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(50926);
                            }
                        }
                        C4990ab.m7416i("MicroMsg.TransferUtil", "mediaCodecRemuxLock wait finish");
                        i = 0;
                    } catch (Exception e2) {
                        C4990ab.m7417i("MicroMsg.TransferUtil", "MediaCodecRemuxer remux, retry x264, error:%s", e2.getMessage());
                        C17987e.m28303a(str, str2, videoTransPara, yz);
                    }
                }
                i = 0;
            } else {
                try {
                    i = c9084g.mo20568fW((long) C17987e.m28306ea(str));
                    C17987e.m28310w(i, yz);
                } catch (Exception e22) {
                    Exception exception = e22;
                    i = -1;
                    C4990ab.m7413e("MicroMsg.TransferUtil", "Local tranfer to H264 error: %s", exception.getMessage());
                    C41791b.fXS.mo45830WY();
                } catch (Throwable th2) {
                    C41791b.fXS.mo45830WY();
                    AppMethodBeat.m2505o(50926);
                }
            }
            C41791b.fXS.mo45830WY();
            AppMethodBeat.m2505o(50926);
            return i;
        } catch (Exception e222) {
            C4990ab.m7413e("MicroMsg.TransferUtil", "Local tranfer init failed: %s", e222.getMessage());
            AppMethodBeat.m2505o(50926);
            return -1;
        }
    }

    /* renamed from: a */
    private static void m28303a(String str, String str2, VideoTransPara videoTransPara, long j) {
        AppMethodBeat.m2504i(50927);
        C4990ab.m7409c("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", str, str2, videoTransPara);
        C9084g c9084g = new C9084g();
        c9084g.mo20567b(str, str2, videoTransPara);
        c9084g.fYu = true;
        c9084g.fYv = true;
        C4990ab.m7417i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", Integer.valueOf(c9084g.mo20568fW((long) C17987e.m28306ea(str))));
        C17987e.m28310w(r0, j);
        AppMethodBeat.m2505o(50927);
    }

    /* renamed from: w */
    private static void m28310w(int i, long j) {
        AppMethodBeat.m2504i(50928);
        if (i < 0) {
            C4990ab.m7417i("MicroMsg.TransferUtil", "Local tranfer to H264 failed：%s", Integer.valueOf(i));
        }
        C4990ab.m7416i("MicroMsg.TransferUtil", "Transfer Finish");
        C4990ab.m7417i("MicroMsg.TransferUtil", "totalTime：%d", Long.valueOf(C5046bo.m7588yz() - j));
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(C33379c.CTRL_INDEX);
        iDKey.SetKey(C31128d.MIC_PTU_ZIPAI_OKINAWA);
        iDKey.SetValue(r0);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(C33379c.CTRL_INDEX);
        iDKey2.SetKey(C31128d.MIC_PTU_ZIPAI_LIGHTRED);
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        C7060h.pYm.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(50928);
    }
}
