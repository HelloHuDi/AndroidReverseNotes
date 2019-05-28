package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.vfs.e;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@TargetApi(18)
public final class q extends a {
    private int eTa;
    private a ozt;
    private a ozu;

    public final void b(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.i(3689);
        super.b(str, str2, videoTransPara);
        AppMethodBeat.o(3689);
    }

    public final int O(long j, long j2) {
        AppMethodBeat.i(3690);
        m.yV(h.bQk());
        int O = super.O(j, j2);
        if (O == -1) {
            m.yW(h.bQk());
        }
        AppMethodBeat.o(3690);
        return O;
    }

    /* Access modifiers changed, original: protected|final */
    public final int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        int i;
        AppMethodBeat.i(3691);
        this.ozt = (a) list2.get(0);
        if (!(list == null || list.size() == 0)) {
            this.ozu = (a) list.get(0);
        }
        if (this.fYt <= 0) {
            i = 1048576;
        } else {
            i = this.fYt;
        }
        if (a(mediaExtractor, i, this.eTa, this.fYo) == -1) {
            ab.e("VideoClipperAPI18", "transcodeAndMux error");
            release();
            AppMethodBeat.o(3691);
            return -1;
        }
        AppMethodBeat.o(3691);
        return 0;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x00d0=Splitter:B:21:0x00d0, B:71:0x0271=Splitter:B:71:0x0271, B:62:0x01c3=Splitter:B:62:0x01c3} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02fd A:{Catch:{ Exception -> 0x00de, all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02aa A:{Catch:{ Exception -> 0x00de, all -> 0x00fd }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        AppMethodBeat.i(3692);
        ab.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(88) ");
        h hVar = null;
        try {
            h hVar2 = new h();
            try {
                int i3;
                hVar2.bqO = this.fYr;
                hVar2.eTA = this.fYs;
                VideoTransPara videoTransPara = this.fYq;
                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "setVideoPara: %s", videoTransPara);
                hVar2.fYK = videoTransPara;
                if (this.mRotationDegree == 90 || this.mRotationDegree == 270) {
                    hVar2.cE(videoTransPara.height, videoTransPara.width);
                } else {
                    hVar2.cE(videoTransPara.width, videoTransPara.height);
                }
                hVar2.fYM = str;
                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "setSrcVideoRotate: %s", Integer.valueOf(this.mRotationDegree));
                hVar2.rotate = i3;
                ab.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    ab.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.ozt.index);
                    mediaExtractor.seekTo(this.fYr * 1000, 0);
                    try {
                        VideoTransPara videoTransPara2 = this.fYq;
                        this.eTa = MP4MuxerJNI.initDataBuf(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                        long yz = bo.yz();
                        i3 = this.ozt.index;
                        hVar2.eWb = mediaExtractor;
                        hVar2.eWc = i3;
                        l lVar;
                        if (hVar2.f(this.ozt.mediaFormat) < 0) {
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.eTa);
                                mediaExtractor.release();
                                j.owk.WY();
                            } catch (Exception e2) {
                            }
                            lVar = new l("init decoder error");
                            AppMethodBeat.o(3692);
                            throw lVar;
                        }
                        int i4;
                        if (!bo.isNullOrNil(hVar2.fYM)) {
                            String simpleMp4Info = SightVideoJNI.getSimpleMp4Info(hVar2.fYM);
                            ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "src file: %s", simpleMp4Info);
                            if (!bo.isNullOrNil(simpleMp4Info)) {
                                try {
                                    int i5 = (int) new JSONObject(simpleMp4Info).getDouble("videoFPS");
                                    double d = (hVar2.fYK == null || hVar2.fYK.fps <= 0) ? 30.0d : (double) hVar2.fYK.fps;
                                    hVar2.eTJ = (int) Math.ceil(((double) i5) / d);
                                    ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "frameDropInterval: %s, videoFPS: %s, targetFPS: %s", Integer.valueOf(hVar2.eTJ), Integer.valueOf(i5), Double.valueOf(d));
                                } catch (Exception e3) {
                                    ab.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e3, "calcFrameDropCount error: %s", e3.getMessage());
                                }
                            }
                        }
                        hVar2.oyh.mp(hVar2.eTJ);
                        hVar2.oyh.z(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(3653);
                                h hVar = h.this;
                                ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", hVar.oyg, hVar.eVR);
                                if (!(hVar.oyg == null || hVar.eVR == null)) {
                                    hVar.oyg.fYU = true;
                                    try {
                                        hVar.eVR.join();
                                        d.xDG.remove(hVar.oyg);
                                        AppMethodBeat.o(3653);
                                        return;
                                    } catch (Exception e) {
                                        ab.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e, "waitEncoderFinish, join error: %s", e.getMessage());
                                    }
                                }
                                AppMethodBeat.o(3653);
                            }
                        });
                        yz = bo.az(yz);
                        mediaExtractor.unselectTrack(this.ozt.index);
                        boolean z = false;
                        if (this.ozu != null) {
                            long yz2 = bo.yz();
                            z = a(mediaExtractor, i, i2);
                            ab.i("VideoClipperAPI18", "process audio used %sms, compressAudio: %s", Long.valueOf(bo.az(yz2)), Boolean.valueOf(z));
                        }
                        long yz3 = bo.yz();
                        String alN = alN();
                        ab.i("VideoClipperAPI18", "process video used %sms", Long.valueOf(yz));
                        ab.i("VideoClipperAPI18", "start muxing, tempPath: %s", alN);
                        m.S(h.bQk(), yz);
                        int i6 = 1;
                        int i7 = videoTransPara2.audioSampleRate;
                        int i8 = videoTransPara2.fzS;
                        if (!z) {
                            try {
                                i6 = this.ozu.mediaFormat.getInteger("channel-count");
                                i7 = this.ozu.mediaFormat.getInteger("sample-rate");
                                i8 = this.ozu.mediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                                i3 = i7;
                                i4 = i6;
                            } catch (Exception e32) {
                                ab.e("VideoClipperAPI18", "get audio channel count error: %s", e32.getMessage());
                            }
                            ab.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i8));
                            if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, (int) (this.fYs - this.fYr), null, 0) >= 0) {
                                ab.e("VideoClipperAPI18", "muxingForX264 failed! %d", Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, (int) (this.fYs - this.fYr), null, 0)));
                                lVar = new l("muxingForX264 failed!");
                                AppMethodBeat.o(3692);
                                throw lVar;
                            }
                            if (this.mRotationDegree > 0) {
                                SightVideoJNI.tagRotateVideo(alN(), this.fYp, this.mRotationDegree);
                            } else {
                                e.aQ(alN(), this.fYp);
                            }
                            ab.i("VideoClipperAPI18", "mux and tagRotate used %sms", Long.valueOf(bo.az(yz3)));
                            long yz4 = bo.yz();
                            SightVideoJNI.tagMP4Dscp(this.fYp, CaptureMMProxy.getInstance().getWeixinMeta());
                            ab.i("VideoClipperAPI18", "tagMP4Dscp used %sms", Long.valueOf(bo.az(yz4)));
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.eTa);
                                mediaExtractor.release();
                                j.owk.WY();
                            } catch (Exception e4) {
                            }
                            try {
                                hVar2.release();
                            } catch (Exception e5) {
                            }
                            AppMethodBeat.o(3692);
                            return 0;
                        }
                        i3 = i7;
                        i4 = i6;
                        ab.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i8));
                        if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, (int) (this.fYs - this.fYr), null, 0) >= 0) {
                        }
                    } catch (Exception e322) {
                        ab.w("VideoClipperAPI18", "The source video file is malformed %s", e322.getMessage());
                        RuntimeException runtimeException = new RuntimeException(e322);
                        AppMethodBeat.o(3692);
                        throw runtimeException;
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.eTa);
                            mediaExtractor.release();
                            j.owk.WY();
                        } catch (Exception e6) {
                        }
                        AppMethodBeat.o(3692);
                    }
                } catch (Exception e3222) {
                    try {
                        ab.printErrStackTrace("VideoClipperAPI18", e3222, "Transcode and mux failed %s", e3222.getMessage());
                        try {
                            hVar2.release();
                        } catch (Exception e7) {
                        }
                        AppMethodBeat.o(3692);
                        return -1;
                    } catch (Throwable th2) {
                        try {
                            hVar2.release();
                        } catch (Exception e8) {
                        }
                        AppMethodBeat.o(3692);
                    }
                }
            } catch (Exception e9) {
                e = e9;
                hVar = hVar2;
            }
        } catch (Exception e10) {
            e = e10;
            ab.printErrStackTrace("VideoClipperAPI18", e, "trascodeAndMux error", new Object[0]);
            if (hVar != null) {
                hVar.release();
            }
            AppMethodBeat.o(3692);
            return -1;
        }
    }

    private boolean a(MediaExtractor mediaExtractor, int i, int i2) {
        AppMethodBeat.i(3693);
        if (this.ozu == null) {
            AppMethodBeat.o(3693);
            return false;
        }
        mediaExtractor.selectTrack(this.ozu.index);
        mediaExtractor.seekTo(this.fYr * 1000, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        try {
            this.ozu.mediaFormat.getInteger("channel-count");
        } catch (Exception e) {
            ab.e("VideoClipperAPI18", "get channel count error: %s", Integer.valueOf(1));
        }
        ab.i("VideoClipperAPI18", "audio channel count");
        if (CaptureMMProxy.getInstance().getInt(a.USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC, 0) == 1) {
            g gVar = new g(mediaExtractor, this.ozu.mediaFormat, this.fYr, this.fYs, this.fYq);
            gVar.oxY = true;
            try {
                gVar.oxW = MediaCodec.createDecoderByType(gVar.clY);
                gVar.oxW.configure(gVar.fYc, null, null, 0);
                gVar.oxW.start();
                gVar.fYc = gVar.oxW.getOutputFormat();
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "init decoder error: %s", e2.getMessage());
            }
            try {
                gVar.eVr = new MediaFormat();
                gVar.eVr.setString("mime", "audio/mp4a-latm");
                gVar.eVr.setInteger("aac-profile", 2);
                gVar.eVr.setInteger("sample-rate", gVar.fYK.audioSampleRate);
                gVar.eVr.setInteger("channel-count", 1);
                gVar.eVr.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, gVar.fYK.fzS);
                gVar.eVr.setInteger("max-input-size", 16384);
                gVar.oxX = MediaCodec.createEncoderByType(gVar.clY);
                gVar.oxX.configure(gVar.eVr, null, null, 1);
                gVar.oxW.start();
            } catch (Exception e22) {
                ab.e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", e22.getMessage());
                gVar.oxY = false;
                gVar.oxZ = new ArrayList();
                gVar.oxX.release();
                gVar.oxX = null;
            }
            ab.i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", Boolean.valueOf(gVar.oxY));
            gVar.bQh();
            AppMethodBeat.o(3693);
            return true;
        }
        while (true) {
            allocateDirect.clear();
            int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
            ab.d("VideoClipperAPI18", "sampleSize: %d", Integer.valueOf(readSampleData));
            if (readSampleData <= 0) {
                ab.i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                break;
            } else if (mediaExtractor.getSampleTime() >= this.fYs * 1000) {
                break;
            } else if (mediaExtractor.getSampleTrackIndex() != this.ozu.index) {
                ab.e("VideoClipperAPI18", "track index not match! break");
                break;
            } else {
                allocateDirect.position(0);
                MP4MuxerJNI.writeAACData(i2, allocateDirect, readSampleData);
                mediaExtractor.advance();
            }
        }
        AppMethodBeat.o(3693);
        return false;
    }

    public final int uG(String str) {
        Throwable th;
        AppMethodBeat.i(3694);
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
                ab.d("VideoClipperAPI18", "findRotationMessage sDegree = ".concat(String.valueOf(extractMetadata)));
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                ab.d("VideoClipperAPI18", "findRotationMessage sHeight = ".concat(String.valueOf(extractMetadata2)));
                ab.d("VideoClipperAPI18", "findRotationMessage sWidth = ".concat(String.valueOf(extractMetadata3)));
                int i = bo.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                AppMethodBeat.o(3694);
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
            AppMethodBeat.o(3694);
            throw th;
        }
    }
}
