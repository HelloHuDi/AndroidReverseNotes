package com.tencent.mm.bj;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class g {
    private int eTa;
    private String eys;
    private a fYk;
    private a fYl;
    private List<a> fYm = new ArrayList();
    private List<a> fYn = new ArrayList();
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

    class a {
        int index;
        MediaFormat mediaFormat;

        a(MediaFormat mediaFormat, int i) {
            this.mediaFormat = mediaFormat;
            this.index = i;
        }
    }

    public g() {
        AppMethodBeat.i(50932);
        AppMethodBeat.o(50932);
    }

    public final void b(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.i(50933);
        ab.d("MicroMsg.VideoTranferH265toH264", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long yz = bo.yz();
        c(str, str2, videoTransPara);
        this.fYo = str;
        this.fYp = str2;
        this.fYq = videoTransPara;
        this.mMediaExtractor = new MediaExtractor();
        this.mMediaExtractor.setDataSource(str);
        a(this.mMediaExtractor);
        if (this.fYm == null || this.fYm.size() == 0) {
            f fVar = new f("Can not find video or audio track in this video file.");
            AppMethodBeat.o(50933);
            throw fVar;
        }
        this.fYt = alM();
        this.mRotationDegree = uG(str);
        this.isInited = true;
        ab.e("MicroMsg.VideoTranferH265toH264", "init cost time %dms", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(50933);
    }

    public final int fW(long j) {
        int i;
        AppMethodBeat.i(50934);
        fX(j);
        this.fYk = (a) this.fYm.get(0);
        if (!(this.fYn == null || this.fYn.size() == 0)) {
            this.fYl = (a) this.fYn.get(0);
        }
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (this.fYt <= 0) {
            i = 1048576;
        } else {
            i = this.fYt;
        }
        if (a(mediaExtractor, i, this.eTa, this.fYo) == -1) {
            ab.e("MicroMsg.VideoTranferH265toH264", "transcodeAndMux error");
            release();
            AppMethodBeat.o(50934);
            return -1;
        }
        AppMethodBeat.o(50934);
        return 0;
    }

    private int a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        AppMethodBeat.i(50935);
        ab.i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.transcodeAndMux(88) ");
        h hVar = null;
        try {
            h hVar2 = new h(this.eTa);
            try {
                int i3;
                hVar2.bqO = this.fYr;
                hVar2.eTA = this.fYs;
                VideoTransPara videoTransPara = this.fYq;
                ab.i("MicroMsg.VideoTranscoder", "setVideoPara: %s", videoTransPara);
                hVar2.fYK = videoTransPara;
                if (this.mRotationDegree == 90 || this.mRotationDegree == 270) {
                    hVar2.cE(videoTransPara.height, videoTransPara.width);
                } else {
                    hVar2.cE(videoTransPara.width, videoTransPara.height);
                }
                hVar2.fYM = str;
                ab.i("MicroMsg.VideoTranscoder", "setSrcVideoRotate: %s", Integer.valueOf(this.mRotationDegree));
                hVar2.rotate = i3;
                hVar2.fYv = this.fYv;
                ab.i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    ab.i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.fYk.index);
                    mediaExtractor.seekTo(this.fYr * 1000, 0);
                    VideoTransPara videoTransPara2 = this.fYq;
                    this.eTa = MP4MuxerJNI.initDataBufLock(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                    long yz = bo.yz();
                    i3 = this.fYk.index;
                    hVar2.eWb = mediaExtractor;
                    hVar2.eWc = i3;
                    if (hVar2.a(this.fYk.mediaFormat, this.fYu) < 0) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.eTa);
                            mediaExtractor.release();
                            b.fXS.WY();
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        int i4;
                        if (!bo.isNullOrNil(hVar2.fYM)) {
                            String simpleMp4Info = SightVideoJNI.getSimpleMp4Info(hVar2.fYM);
                            ab.i("MicroMsg.VideoTranscoder", "src file: %s", simpleMp4Info);
                            if (!bo.isNullOrNil(simpleMp4Info)) {
                                try {
                                    int i5 = (int) new JSONObject(simpleMp4Info).getDouble("videoFPS");
                                    double d = (hVar2.fYK == null || hVar2.fYK.fps <= 0) ? 30.0d : (double) hVar2.fYK.fps;
                                    hVar2.eTJ = (int) Math.ceil(((double) i5) / d);
                                    ab.i("MicroMsg.VideoTranscoder", "frameDropInterval: %s, videoFPS: %s, targetFPS: %s", Integer.valueOf(hVar2.eTJ), Integer.valueOf(i5), Double.valueOf(d));
                                } catch (Exception e3) {
                                    ab.printErrStackTrace("MicroMsg.VideoTranscoder", e3, "calcFrameDropCount error: %s", e3.getMessage());
                                }
                            }
                        }
                        hVar2.fYN.mp(hVar2.eTJ);
                        hVar2.fYN.z(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(50945);
                                h hVar = h.this;
                                ab.i("MicroMsg.VideoTranscoder", "waitEncoderFinish: %s %s %s %s %s", hVar.fYF, hVar.fYG, Boolean.valueOf(hVar.fYv), hVar.fYI, hVar.fYJ);
                                if (hVar.fYv) {
                                    if (!(hVar.fYF == null || hVar.fYG == null)) {
                                        hVar.fYF.fYU = true;
                                        try {
                                            hVar.fYG.join();
                                            d.xDG.remove(hVar.fYF);
                                            AppMethodBeat.o(50945);
                                            return;
                                        } catch (Exception e) {
                                            ab.printErrStackTrace("MicroMsg.VideoTranscoder", e, "waitEncoderFinish, join error: %s", e.getMessage());
                                            AppMethodBeat.o(50945);
                                            return;
                                        }
                                    }
                                } else if (!(hVar.fYI == null || hVar.fYJ == null)) {
                                    try {
                                        hVar.fYI.quitSafely();
                                        hVar.fYI.join();
                                        hVar.fYJ = null;
                                        AppMethodBeat.o(50945);
                                        return;
                                    } catch (Exception e2) {
                                        ab.printErrStackTrace("MicroMsg.VideoTranscoder", e2, "waitEncoderFinish, join error: %s", e2.getMessage());
                                    }
                                }
                                AppMethodBeat.o(50945);
                            }
                        });
                        long az = bo.az(yz);
                        mediaExtractor.unselectTrack(this.fYk.index);
                        if (this.fYl != null) {
                            yz = bo.yz();
                            a(mediaExtractor, i, i2);
                            ab.i("MicroMsg.VideoTranferH265toH264", "process audio used %sms, compressAudio: %s", Long.valueOf(bo.az(yz)), Boolean.FALSE);
                        }
                        long yz2 = bo.yz();
                        String alN = alN();
                        ab.i("MicroMsg.VideoTranferH265toH264", "process video used %sms", Long.valueOf(az));
                        ab.i("MicroMsg.VideoTranferH265toH264", "start muxing, tempPath: %s", alN);
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
                            ab.e("MicroMsg.VideoTranferH265toH264", "get audio channel count error: %s", e32.getMessage());
                            i3 = i7;
                            i4 = i6;
                        }
                        ab.e("MicroMsg.VideoTranferH265toH264", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i8));
                        ab.i("MicroMsg.VideoTranferH265toH264", "start muxing, aacSampleRate: %s, channelCount: %s, fps: %s, tempPath: %s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(videoTransPara2.fps), alN);
                        if (hVar2.fYv) {
                            i3 = MP4MuxerJNI.muxingForX264Lock(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, (int) (this.fYs - this.fYr), null, 0);
                        } else {
                            i3 = MP4MuxerJNI.muxingLock(this.eTa, i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, null, 0);
                        }
                        ab.e("MicroMsg.VideoTranferH265toH264", "finish muxing ");
                        if (i3 < 0) {
                            ab.e("MicroMsg.VideoTranferH265toH264", "muxing failed! %d", Integer.valueOf(i3));
                        }
                        if (this.mRotationDegree > 0) {
                            SightVideoJNI.tagRotateVideo(alN(), this.fYp, this.mRotationDegree);
                        } else {
                            FileOp.aQ(alN(), this.fYp);
                        }
                        ab.i("MicroMsg.VideoTranferH265toH264", "mux and tagRotate used %sms", Long.valueOf(bo.az(yz2)));
                        ab.i("MicroMsg.VideoTranferH265toH264", "tagMP4Dscp used %sms", Long.valueOf(bo.az(bo.yz())));
                        try {
                            MP4MuxerJNI.releaseDataBufLock(this.eTa);
                            mediaExtractor.release();
                            b.fXS.WY();
                        } catch (Exception e4) {
                        }
                    } catch (Exception e322) {
                        ab.printErrStackTrace("MicroMsg.VideoTranferH265toH264", e322, "The source video file is malformed %s", e322.getMessage());
                        try {
                            MP4MuxerJNI.releaseDataBufLock(this.eTa);
                            mediaExtractor.release();
                            b.fXS.WY();
                        } catch (Exception e5) {
                        }
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBufLock(this.eTa);
                            mediaExtractor.release();
                            b.fXS.WY();
                        } catch (Exception e6) {
                        }
                        AppMethodBeat.o(50935);
                    }
                    try {
                        hVar2.release();
                    } catch (Exception e7) {
                    }
                    AppMethodBeat.o(50935);
                    return 0;
                } catch (Exception e3222) {
                    try {
                        ab.printErrStackTrace("MicroMsg.VideoTranferH265toH264", e3222, "Transcode and mux failed %s", e3222.getMessage());
                        try {
                            hVar2.release();
                        } catch (Exception e8) {
                        }
                        AppMethodBeat.o(50935);
                        return -1;
                    } catch (Throwable th2) {
                        try {
                            hVar2.release();
                        } catch (Exception e9) {
                        }
                        AppMethodBeat.o(50935);
                    }
                }
            } catch (Exception e10) {
                e = e10;
                hVar = hVar2;
            }
        } catch (Exception e11) {
            e = e11;
            ab.printErrStackTrace("MicroMsg.VideoTranferH265toH264", e, "trascodeAndMux error", new Object[0]);
            if (hVar != null) {
                hVar.release();
            }
            AppMethodBeat.o(50935);
            return -1;
        }
    }

    private boolean a(MediaExtractor mediaExtractor, int i, int i2) {
        AppMethodBeat.i(50936);
        if (this.fYl == null) {
            AppMethodBeat.o(50936);
        } else {
            mediaExtractor.selectTrack(this.fYl.index);
            mediaExtractor.seekTo(this.fYr * 1000, 0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
            try {
                this.fYl.mediaFormat.getInteger("channel-count");
            } catch (Exception e) {
                ab.e("MicroMsg.VideoTranferH265toH264", "get channel count error: %s", Integer.valueOf(1));
            }
            ab.i("MicroMsg.VideoTranferH265toH264", "audio channel count");
            while (true) {
                allocateDirect.clear();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                if (readSampleData <= 0) {
                    ab.i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                    break;
                } else if (mediaExtractor.getSampleTime() >= this.fYs * 1000) {
                    break;
                } else if (mediaExtractor.getSampleTrackIndex() != this.fYl.index) {
                    ab.e("MicroMsg.VideoTranferH265toH264", "track index not match! break");
                    break;
                } else {
                    allocateDirect.position(0);
                    MP4MuxerJNI.writeAACDataLock(i2, allocateDirect, readSampleData);
                    mediaExtractor.advance();
                }
            }
            AppMethodBeat.o(50936);
        }
        return false;
    }

    private static void c(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.i(50937);
        IllegalArgumentException illegalArgumentException;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || videoTransPara == null) {
            illegalArgumentException = new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
            AppMethodBeat.o(50937);
            throw illegalArgumentException;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (FileOp.ct(str) && file.canRead() && file.length() != 0) {
            AppMethodBeat.o(50937);
            return;
        }
        illegalArgumentException = new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
        AppMethodBeat.o(50937);
        throw illegalArgumentException;
    }

    private void a(MediaExtractor mediaExtractor) {
        AppMethodBeat.i(50938);
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !bo.isNullOrNil(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                ab.i("MicroMsg.VideoTranferH265toH264", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.fYn.add(new a(trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.fYm.add(new a(trackFormat, i));
                }
            }
        }
        ab.i("MicroMsg.VideoTranferH265toH264", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.fYn.size()), Integer.valueOf(this.fYm.size()));
        AppMethodBeat.o(50938);
    }

    private int alM() {
        Iterator it;
        int i;
        a aVar;
        AppMethodBeat.i(50939);
        int i2 = -1;
        if (!(this.fYn == null || this.fYn.size() == 0)) {
            it = this.fYn.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                aVar = (a) it.next();
                if (aVar.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.mediaFormat.getInteger("max-input-size"), i);
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
                aVar = (a) it.next();
                if (aVar.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.mediaFormat.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
            }
            i2 = i;
        }
        AppMethodBeat.o(50939);
        return i2;
    }

    private static int uG(String str) {
        Throwable th;
        AppMethodBeat.i(50940);
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                Object extractMetadata;
                mediaMetadataRetriever.setDataSource(str);
                if (com.tencent.mm.compatible.util.d.iW(17)) {
                    extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    extractMetadata = SightVideoJNI.getMp4Rotate(str);
                }
                ab.d("MicroMsg.VideoTranferH265toH264", "findRotationMessage sDegree = ".concat(String.valueOf(extractMetadata)));
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                ab.d("MicroMsg.VideoTranferH265toH264", "findRotationMessage sHeight = ".concat(String.valueOf(extractMetadata2)));
                ab.d("MicroMsg.VideoTranferH265toH264", "findRotationMessage sWidth = ".concat(String.valueOf(extractMetadata3)));
                int i = bo.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                AppMethodBeat.o(50940);
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
            AppMethodBeat.o(50940);
            throw th;
        }
    }

    private void release() {
        AppMethodBeat.i(50941);
        this.isInited = false;
        if (this.mMediaExtractor != null) {
            this.mMediaExtractor.release();
        }
        AppMethodBeat.o(50941);
    }

    private void fX(long j) {
        AppMethodBeat.i(50942);
        ab.e("MicroMsg.VideoTranferH265toH264", "init %s", Boolean.valueOf(this.isInited));
        if (!this.isInited) {
            ab.e("MicroMsg.VideoTranferH265toH264", "checkTimeParameter has not been initialized.");
        }
        this.fYr = 0;
        MediaFormat mediaFormat = ((a) this.fYm.get(0)).mediaFormat;
        if (mediaFormat.containsKey("durationUs")) {
            if (j <= 0 || j > mediaFormat.getLong("durationUs") / 1000) {
                j = mediaFormat.getLong("durationUs") / 1000;
            }
            this.fYs = j;
            AppMethodBeat.o(50942);
            return;
        }
        f fVar = new f("Can not find duration.");
        AppMethodBeat.o(50942);
        throw fVar;
    }

    private String alN() {
        AppMethodBeat.i(50943);
        if (this.eys == null) {
            this.eys = this.fYp + "video_temp.mp4";
        }
        String str = this.eys;
        AppMethodBeat.o(50943);
        return str;
    }
}
