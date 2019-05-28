package com.tencent.p177mm.p838bj;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p838bj.C25863h.C258642;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.bj.g */
public final class C9084g {
    private int eTa;
    private String eys;
    private C9083a fYk;
    private C9083a fYl;
    private List<C9083a> fYm = new ArrayList();
    private List<C9083a> fYn = new ArrayList();
    private String fYo;
    private String fYp;
    private VideoTransPara fYq;
    private long fYr;
    private long fYs;
    private int fYt = -1;
    boolean fYu = false;
    boolean fYv = false;
    private boolean isInited = false;
    private MediaExtractor mMediaExtractor;
    private int mRotationDegree = -1;

    /* renamed from: com.tencent.mm.bj.g$a */
    class C9083a {
        int index;
        MediaFormat mediaFormat;

        C9083a(MediaFormat mediaFormat, int i) {
            this.mediaFormat = mediaFormat;
            this.index = i;
        }
    }

    public C9084g() {
        AppMethodBeat.m2504i(50932);
        AppMethodBeat.m2505o(50932);
    }

    /* renamed from: b */
    public final void mo20567b(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(50933);
        C4990ab.m7410d("MicroMsg.VideoTranferH265toH264", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long yz = C5046bo.m7588yz();
        C9084g.m16473c(str, str2, videoTransPara);
        this.fYo = str;
        this.fYp = str2;
        this.fYq = videoTransPara;
        this.mMediaExtractor = new MediaExtractor();
        this.mMediaExtractor.setDataSource(str);
        m16471a(this.mMediaExtractor);
        if (this.fYm == null || this.fYm.size() == 0) {
            C25862f c25862f = new C25862f("Can not find video or audio track in this video file.");
            AppMethodBeat.m2505o(50933);
            throw c25862f;
        }
        this.fYt = alM();
        this.mRotationDegree = C9084g.m16475uG(str);
        this.isInited = true;
        C4990ab.m7413e("MicroMsg.VideoTranferH265toH264", "init cost time %dms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(50933);
    }

    /* renamed from: fW */
    public final int mo20568fW(long j) {
        int i;
        AppMethodBeat.m2504i(50934);
        m16474fX(j);
        this.fYk = (C9083a) this.fYm.get(0);
        if (!(this.fYn == null || this.fYn.size() == 0)) {
            this.fYl = (C9083a) this.fYn.get(0);
        }
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (this.fYt <= 0) {
            i = 1048576;
        } else {
            i = this.fYt;
        }
        if (m16470a(mediaExtractor, i, this.eTa, this.fYo) == -1) {
            C4990ab.m7412e("MicroMsg.VideoTranferH265toH264", "transcodeAndMux error");
            release();
            AppMethodBeat.m2505o(50934);
            return -1;
        }
        AppMethodBeat.m2505o(50934);
        return 0;
    }

    /* renamed from: a */
    private int m16470a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        AppMethodBeat.m2504i(50935);
        C4990ab.m7416i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.transcodeAndMux(88) ");
        C25863h c25863h = null;
        try {
            C25863h c25863h2 = new C25863h(this.eTa);
            try {
                int i3;
                c25863h2.bqO = this.fYr;
                c25863h2.eTA = this.fYs;
                VideoTransPara videoTransPara = this.fYq;
                C4990ab.m7417i("MicroMsg.VideoTranscoder", "setVideoPara: %s", videoTransPara);
                c25863h2.fYK = videoTransPara;
                if (this.mRotationDegree == 90 || this.mRotationDegree == 270) {
                    c25863h2.mo43847cE(videoTransPara.height, videoTransPara.width);
                } else {
                    c25863h2.mo43847cE(videoTransPara.width, videoTransPara.height);
                }
                c25863h2.fYM = str;
                C4990ab.m7417i("MicroMsg.VideoTranscoder", "setSrcVideoRotate: %s", Integer.valueOf(this.mRotationDegree));
                c25863h2.rotate = i3;
                c25863h2.fYv = this.fYv;
                C4990ab.m7416i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    C4990ab.m7416i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.fYk.index);
                    mediaExtractor.seekTo(this.fYr * 1000, 0);
                    VideoTransPara videoTransPara2 = this.fYq;
                    this.eTa = MP4MuxerJNI.initDataBufLock(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                    long yz = C5046bo.m7588yz();
                    i3 = this.fYk.index;
                    c25863h2.eWb = mediaExtractor;
                    c25863h2.eWc = i3;
                    if (c25863h2.mo43845a(this.fYk.mediaFormat, this.fYu) < 0) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.eTa);
                            mediaExtractor.release();
                            C41791b.fXS.mo45830WY();
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        int i4;
                        if (!C5046bo.isNullOrNil(c25863h2.fYM)) {
                            String simpleMp4Info = SightVideoJNI.getSimpleMp4Info(c25863h2.fYM);
                            C4990ab.m7417i("MicroMsg.VideoTranscoder", "src file: %s", simpleMp4Info);
                            if (!C5046bo.isNullOrNil(simpleMp4Info)) {
                                try {
                                    int i5 = (int) new JSONObject(simpleMp4Info).getDouble("videoFPS");
                                    double d = (c25863h2.fYK == null || c25863h2.fYK.fps <= 0) ? 30.0d : (double) c25863h2.fYK.fps;
                                    c25863h2.eTJ = (int) Math.ceil(((double) i5) / d);
                                    C4990ab.m7417i("MicroMsg.VideoTranscoder", "frameDropInterval: %s, videoFPS: %s, targetFPS: %s", Integer.valueOf(c25863h2.eTJ), Integer.valueOf(i5), Double.valueOf(d));
                                } catch (Exception e3) {
                                    C4990ab.printErrStackTrace("MicroMsg.VideoTranscoder", e3, "calcFrameDropCount error: %s", e3.getMessage());
                                }
                            }
                        }
                        c25863h2.fYN.mo67539mp(c25863h2.eTJ);
                        c25863h2.fYN.mo67541z(new C258642());
                        long az = C5046bo.m7525az(yz);
                        mediaExtractor.unselectTrack(this.fYk.index);
                        if (this.fYl != null) {
                            yz = C5046bo.m7588yz();
                            m16472a(mediaExtractor, i, i2);
                            C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "process audio used %sms, compressAudio: %s", Long.valueOf(C5046bo.m7525az(yz)), Boolean.FALSE);
                        }
                        long yz2 = C5046bo.m7588yz();
                        String alN = alN();
                        C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "process video used %sms", Long.valueOf(az));
                        C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "start muxing, tempPath: %s", alN);
                        int i6 = 1;
                        int i7 = videoTransPara2.audioSampleRate;
                        int i8 = videoTransPara2.fzS;
                        try {
                            i6 = this.fYl.mediaFormat.getInteger("channel-count");
                            i7 = this.fYl.mediaFormat.getInteger("sample-rate");
                            i8 = this.fYl.mediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                            i3 = i7;
                            i4 = i6;
                        } catch (Exception e32) {
                            C4990ab.m7413e("MicroMsg.VideoTranferH265toH264", "get audio channel count error: %s", e32.getMessage());
                            i3 = i7;
                            i4 = i6;
                        }
                        C4990ab.m7413e("MicroMsg.VideoTranferH265toH264", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i8));
                        C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "start muxing, aacSampleRate: %s, channelCount: %s, fps: %s, tempPath: %s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(videoTransPara2.fps), alN);
                        if (c25863h2.fYv) {
                            i3 = MP4MuxerJNI.muxingForX264Lock(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, (int) (this.fYs - this.fYr), null, 0);
                        } else {
                            i3 = MP4MuxerJNI.muxingLock(this.eTa, i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, null, 0);
                        }
                        C4990ab.m7412e("MicroMsg.VideoTranferH265toH264", "finish muxing ");
                        if (i3 < 0) {
                            C4990ab.m7413e("MicroMsg.VideoTranferH265toH264", "muxing failed! %d", Integer.valueOf(i3));
                        }
                        if (this.mRotationDegree > 0) {
                            SightVideoJNI.tagRotateVideo(alN(), this.fYp, this.mRotationDegree);
                        } else {
                            FileOp.m64136aQ(alN(), this.fYp);
                        }
                        C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "mux and tagRotate used %sms", Long.valueOf(C5046bo.m7525az(yz2)));
                        C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "tagMP4Dscp used %sms", Long.valueOf(C5046bo.m7525az(C5046bo.m7588yz())));
                        try {
                            MP4MuxerJNI.releaseDataBufLock(this.eTa);
                            mediaExtractor.release();
                            C41791b.fXS.mo45830WY();
                        } catch (Exception e4) {
                        }
                    } catch (Exception e322) {
                        C4990ab.printErrStackTrace("MicroMsg.VideoTranferH265toH264", e322, "The source video file is malformed %s", e322.getMessage());
                        try {
                            MP4MuxerJNI.releaseDataBufLock(this.eTa);
                            mediaExtractor.release();
                            C41791b.fXS.mo45830WY();
                        } catch (Exception e5) {
                        }
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBufLock(this.eTa);
                            mediaExtractor.release();
                            C41791b.fXS.mo45830WY();
                        } catch (Exception e6) {
                        }
                        AppMethodBeat.m2505o(50935);
                    }
                    try {
                        c25863h2.release();
                    } catch (Exception e7) {
                    }
                    AppMethodBeat.m2505o(50935);
                    return 0;
                } catch (Exception e3222) {
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.VideoTranferH265toH264", e3222, "Transcode and mux failed %s", e3222.getMessage());
                        try {
                            c25863h2.release();
                        } catch (Exception e8) {
                        }
                        AppMethodBeat.m2505o(50935);
                        return -1;
                    } catch (Throwable th2) {
                        try {
                            c25863h2.release();
                        } catch (Exception e9) {
                        }
                        AppMethodBeat.m2505o(50935);
                    }
                }
            } catch (Exception e10) {
                e = e10;
                c25863h = c25863h2;
            }
        } catch (Exception e11) {
            e = e11;
            C4990ab.printErrStackTrace("MicroMsg.VideoTranferH265toH264", e, "trascodeAndMux error", new Object[0]);
            if (c25863h != null) {
                c25863h.release();
            }
            AppMethodBeat.m2505o(50935);
            return -1;
        }
    }

    /* renamed from: a */
    private boolean m16472a(MediaExtractor mediaExtractor, int i, int i2) {
        AppMethodBeat.m2504i(50936);
        if (this.fYl == null) {
            AppMethodBeat.m2505o(50936);
        } else {
            mediaExtractor.selectTrack(this.fYl.index);
            mediaExtractor.seekTo(this.fYr * 1000, 0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
            try {
                this.fYl.mediaFormat.getInteger("channel-count");
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.VideoTranferH265toH264", "get channel count error: %s", Integer.valueOf(1));
            }
            C4990ab.m7416i("MicroMsg.VideoTranferH265toH264", "audio channel count");
            while (true) {
                allocateDirect.clear();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                if (readSampleData <= 0) {
                    C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                    break;
                } else if (mediaExtractor.getSampleTime() >= this.fYs * 1000) {
                    break;
                } else if (mediaExtractor.getSampleTrackIndex() != this.fYl.index) {
                    C4990ab.m7412e("MicroMsg.VideoTranferH265toH264", "track index not match! break");
                    break;
                } else {
                    allocateDirect.position(0);
                    MP4MuxerJNI.writeAACDataLock(i2, allocateDirect, readSampleData);
                    mediaExtractor.advance();
                }
            }
            AppMethodBeat.m2505o(50936);
        }
        return false;
    }

    /* renamed from: c */
    private static void m16473c(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(50937);
        IllegalArgumentException illegalArgumentException;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || videoTransPara == null) {
            illegalArgumentException = new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
            AppMethodBeat.m2505o(50937);
            throw illegalArgumentException;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (FileOp.m64138ct(str) && file.canRead() && file.length() != 0) {
            AppMethodBeat.m2505o(50937);
            return;
        }
        illegalArgumentException = new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
        AppMethodBeat.m2505o(50937);
        throw illegalArgumentException;
    }

    /* renamed from: a */
    private void m16471a(MediaExtractor mediaExtractor) {
        AppMethodBeat.m2504i(50938);
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !C5046bo.isNullOrNil(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.fYn.add(new C9083a(trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.fYm.add(new C9083a(trackFormat, i));
                }
            }
        }
        C4990ab.m7417i("MicroMsg.VideoTranferH265toH264", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.fYn.size()), Integer.valueOf(this.fYm.size()));
        AppMethodBeat.m2505o(50938);
    }

    private int alM() {
        Iterator it;
        int i;
        C9083a c9083a;
        AppMethodBeat.m2504i(50939);
        int i2 = -1;
        if (!(this.fYn == null || this.fYn.size() == 0)) {
            it = this.fYn.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                c9083a = (C9083a) it.next();
                if (c9083a.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(c9083a.mediaFormat.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
            }
            i2 = i;
        }
        if (!(this.fYm == null || this.fYm.size() == 0)) {
            it = this.fYm.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                c9083a = (C9083a) it.next();
                if (c9083a.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(c9083a.mediaFormat.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
            }
            i2 = i;
        }
        AppMethodBeat.m2505o(50939);
        return i2;
    }

    /* renamed from: uG */
    private static int m16475uG(String str) {
        Throwable th;
        AppMethodBeat.m2504i(50940);
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                Object extractMetadata;
                mediaMetadataRetriever.setDataSource(str);
                if (C1443d.m3068iW(17)) {
                    extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    extractMetadata = SightVideoJNI.getMp4Rotate(str);
                }
                C4990ab.m7410d("MicroMsg.VideoTranferH265toH264", "findRotationMessage sDegree = ".concat(String.valueOf(extractMetadata)));
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                C4990ab.m7410d("MicroMsg.VideoTranferH265toH264", "findRotationMessage sHeight = ".concat(String.valueOf(extractMetadata2)));
                C4990ab.m7410d("MicroMsg.VideoTranferH265toH264", "findRotationMessage sWidth = ".concat(String.valueOf(extractMetadata3)));
                int i = C5046bo.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                AppMethodBeat.m2505o(50940);
                return i;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            AppMethodBeat.m2505o(50940);
            throw th;
        }
    }

    private void release() {
        AppMethodBeat.m2504i(50941);
        this.isInited = false;
        if (this.mMediaExtractor != null) {
            this.mMediaExtractor.release();
        }
        AppMethodBeat.m2505o(50941);
    }

    /* renamed from: fX */
    private void m16474fX(long j) {
        AppMethodBeat.m2504i(50942);
        C4990ab.m7413e("MicroMsg.VideoTranferH265toH264", "init %s", Boolean.valueOf(this.isInited));
        if (!this.isInited) {
            C4990ab.m7412e("MicroMsg.VideoTranferH265toH264", "checkTimeParameter has not been initialized.");
        }
        this.fYr = 0;
        MediaFormat mediaFormat = ((C9083a) this.fYm.get(0)).mediaFormat;
        if (mediaFormat.containsKey("durationUs")) {
            if (j <= 0 || j > mediaFormat.getLong("durationUs") / 1000) {
                j = mediaFormat.getLong("durationUs") / 1000;
            }
            this.fYs = j;
            AppMethodBeat.m2505o(50942);
            return;
        }
        C25862f c25862f = new C25862f("Can not find duration.");
        AppMethodBeat.m2505o(50942);
        throw c25862f;
    }

    private String alN() {
        AppMethodBeat.m2504i(50943);
        if (this.eys == null) {
            this.eys = this.fYp + "video_temp.mp4";
        }
        String str = this.eys;
        AppMethodBeat.m2505o(50943);
        return str;
    }
}
