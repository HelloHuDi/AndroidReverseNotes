package com.tencent.p177mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.segment.C3491a.C3492a;
import com.tencent.p177mm.plugin.mmsight.segment.C39401h.C285151;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.mmsight.segment.q */
public final class C43315q extends C3491a {
    private int eTa;
    private C3492a ozt;
    private C3492a ozu;

    /* renamed from: b */
    public final void mo7956b(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(3689);
        super.mo7956b(str, str2, videoTransPara);
        AppMethodBeat.m2505o(3689);
    }

    /* renamed from: O */
    public final int mo7953O(long j, long j2) {
        AppMethodBeat.m2504i(3690);
        C21308m.m32692yV(C39401h.bQk());
        int O = super.mo7953O(j, j2);
        if (O == -1) {
            C21308m.m32693yW(C39401h.bQk());
        }
        AppMethodBeat.m2505o(3690);
        return O;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final int mo7954a(MediaExtractor mediaExtractor, List<C3492a> list, List<C3492a> list2) {
        int i;
        AppMethodBeat.m2504i(3691);
        this.ozt = (C3492a) list2.get(0);
        if (!(list == null || list.size() == 0)) {
            this.ozu = (C3492a) list.get(0);
        }
        if (this.fYt <= 0) {
            i = 1048576;
        } else {
            i = this.fYt;
        }
        if (m77249a(mediaExtractor, i, this.eTa, this.fYo) == -1) {
            C4990ab.m7412e("VideoClipperAPI18", "transcodeAndMux error");
            release();
            AppMethodBeat.m2505o(3691);
            return -1;
        }
        AppMethodBeat.m2505o(3691);
        return 0;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x00d0=Splitter:B:21:0x00d0, B:71:0x0271=Splitter:B:71:0x0271, B:62:0x01c3=Splitter:B:62:0x01c3} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02fd A:{Catch:{ Exception -> 0x00de, all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02aa A:{Catch:{ Exception -> 0x00de, all -> 0x00fd }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private int m77249a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        AppMethodBeat.m2504i(3692);
        C4990ab.m7416i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(88) ");
        C39401h c39401h = null;
        try {
            C39401h c39401h2 = new C39401h();
            try {
                int i3;
                c39401h2.bqO = this.fYr;
                c39401h2.eTA = this.fYs;
                VideoTransPara videoTransPara = this.fYq;
                C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "setVideoPara: %s", videoTransPara);
                c39401h2.fYK = videoTransPara;
                if (this.mRotationDegree == 90 || this.mRotationDegree == 270) {
                    c39401h2.mo62331cE(videoTransPara.height, videoTransPara.width);
                } else {
                    c39401h2.mo62331cE(videoTransPara.width, videoTransPara.height);
                }
                c39401h2.fYM = str;
                C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "setSrcVideoRotate: %s", Integer.valueOf(this.mRotationDegree));
                c39401h2.rotate = i3;
                C4990ab.m7416i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    C4990ab.m7416i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.ozt.index);
                    mediaExtractor.seekTo(this.fYr * 1000, 0);
                    try {
                        VideoTransPara videoTransPara2 = this.fYq;
                        this.eTa = MP4MuxerJNI.initDataBuf(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                        long yz = C5046bo.m7588yz();
                        i3 = this.ozt.index;
                        c39401h2.eWb = mediaExtractor;
                        c39401h2.eWc = i3;
                        C28518l c28518l;
                        if (c39401h2.mo62332f(this.ozt.mediaFormat) < 0) {
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.eTa);
                                mediaExtractor.release();
                                C43305j.owk.mo45830WY();
                            } catch (Exception e2) {
                            }
                            c28518l = new C28518l("init decoder error");
                            AppMethodBeat.m2505o(3692);
                            throw c28518l;
                        }
                        int i4;
                        if (!C5046bo.isNullOrNil(c39401h2.fYM)) {
                            String simpleMp4Info = SightVideoJNI.getSimpleMp4Info(c39401h2.fYM);
                            C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "src file: %s", simpleMp4Info);
                            if (!C5046bo.isNullOrNil(simpleMp4Info)) {
                                try {
                                    int i5 = (int) new JSONObject(simpleMp4Info).getDouble("videoFPS");
                                    double d = (c39401h2.fYK == null || c39401h2.fYK.fps <= 0) ? 30.0d : (double) c39401h2.fYK.fps;
                                    c39401h2.eTJ = (int) Math.ceil(((double) i5) / d);
                                    C4990ab.m7417i("MicroMsg.MediaCodecFFMpegTranscoder", "frameDropInterval: %s, videoFPS: %s, targetFPS: %s", Integer.valueOf(c39401h2.eTJ), Integer.valueOf(i5), Double.valueOf(d));
                                } catch (Exception e3) {
                                    C4990ab.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e3, "calcFrameDropCount error: %s", e3.getMessage());
                                }
                            }
                        }
                        c39401h2.oyh.mo24499mp(c39401h2.eTJ);
                        c39401h2.oyh.mo24501z(new C285151());
                        yz = C5046bo.m7525az(yz);
                        mediaExtractor.unselectTrack(this.ozt.index);
                        boolean z = false;
                        if (this.ozu != null) {
                            long yz2 = C5046bo.m7588yz();
                            z = m77250a(mediaExtractor, i, i2);
                            C4990ab.m7417i("VideoClipperAPI18", "process audio used %sms, compressAudio: %s", Long.valueOf(C5046bo.m7525az(yz2)), Boolean.valueOf(z));
                        }
                        long yz3 = C5046bo.m7588yz();
                        String alN = alN();
                        C4990ab.m7417i("VideoClipperAPI18", "process video used %sms", Long.valueOf(yz));
                        C4990ab.m7417i("VideoClipperAPI18", "start muxing, tempPath: %s", alN);
                        C21308m.m32691S(C39401h.bQk(), yz);
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
                                C4990ab.m7413e("VideoClipperAPI18", "get audio channel count error: %s", e32.getMessage());
                            }
                            C4990ab.m7413e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i8));
                            if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, (int) (this.fYs - this.fYr), null, 0) >= 0) {
                                C4990ab.m7413e("VideoClipperAPI18", "muxingForX264 failed! %d", Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, (int) (this.fYs - this.fYr), null, 0)));
                                c28518l = new C28518l("muxingForX264 failed!");
                                AppMethodBeat.m2505o(3692);
                                throw c28518l;
                            }
                            if (this.mRotationDegree > 0) {
                                SightVideoJNI.tagRotateVideo(alN(), this.fYp, this.mRotationDegree);
                            } else {
                                C5730e.m8623aQ(alN(), this.fYp);
                            }
                            C4990ab.m7417i("VideoClipperAPI18", "mux and tagRotate used %sms", Long.valueOf(C5046bo.m7525az(yz3)));
                            long yz4 = C5046bo.m7588yz();
                            SightVideoJNI.tagMP4Dscp(this.fYp, CaptureMMProxy.getInstance().getWeixinMeta());
                            C4990ab.m7417i("VideoClipperAPI18", "tagMP4Dscp used %sms", Long.valueOf(C5046bo.m7525az(yz4)));
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.eTa);
                                mediaExtractor.release();
                                C43305j.owk.mo45830WY();
                            } catch (Exception e4) {
                            }
                            try {
                                c39401h2.release();
                            } catch (Exception e5) {
                            }
                            AppMethodBeat.m2505o(3692);
                            return 0;
                        }
                        i3 = i7;
                        i4 = i6;
                        C4990ab.m7413e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i8));
                        if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i4, alN, (float) videoTransPara2.fps, (int) (this.fYs - this.fYr), null, 0) >= 0) {
                        }
                    } catch (Exception e322) {
                        C4990ab.m7421w("VideoClipperAPI18", "The source video file is malformed %s", e322.getMessage());
                        RuntimeException runtimeException = new RuntimeException(e322);
                        AppMethodBeat.m2505o(3692);
                        throw runtimeException;
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.eTa);
                            mediaExtractor.release();
                            C43305j.owk.mo45830WY();
                        } catch (Exception e6) {
                        }
                        AppMethodBeat.m2505o(3692);
                    }
                } catch (Exception e3222) {
                    try {
                        C4990ab.printErrStackTrace("VideoClipperAPI18", e3222, "Transcode and mux failed %s", e3222.getMessage());
                        try {
                            c39401h2.release();
                        } catch (Exception e7) {
                        }
                        AppMethodBeat.m2505o(3692);
                        return -1;
                    } catch (Throwable th2) {
                        try {
                            c39401h2.release();
                        } catch (Exception e8) {
                        }
                        AppMethodBeat.m2505o(3692);
                    }
                }
            } catch (Exception e9) {
                e = e9;
                c39401h = c39401h2;
            }
        } catch (Exception e10) {
            e = e10;
            C4990ab.printErrStackTrace("VideoClipperAPI18", e, "trascodeAndMux error", new Object[0]);
            if (c39401h != null) {
                c39401h.release();
            }
            AppMethodBeat.m2505o(3692);
            return -1;
        }
    }

    /* renamed from: a */
    private boolean m77250a(MediaExtractor mediaExtractor, int i, int i2) {
        AppMethodBeat.m2504i(3693);
        if (this.ozu == null) {
            AppMethodBeat.m2505o(3693);
            return false;
        }
        mediaExtractor.selectTrack(this.ozu.index);
        mediaExtractor.seekTo(this.fYr * 1000, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        try {
            this.ozu.mediaFormat.getInteger("channel-count");
        } catch (Exception e) {
            C4990ab.m7413e("VideoClipperAPI18", "get channel count error: %s", Integer.valueOf(1));
        }
        C4990ab.m7416i("VideoClipperAPI18", "audio channel count");
        if (CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC, 0) == 1) {
            C46083g c46083g = new C46083g(mediaExtractor, this.ozu.mediaFormat, this.fYr, this.fYs, this.fYq);
            c46083g.oxY = true;
            try {
                c46083g.oxW = MediaCodec.createDecoderByType(c46083g.clY);
                c46083g.oxW.configure(c46083g.fYc, null, null, 0);
                c46083g.oxW.start();
                c46083g.fYc = c46083g.oxW.getOutputFormat();
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "init decoder error: %s", e2.getMessage());
            }
            try {
                c46083g.eVr = new MediaFormat();
                c46083g.eVr.setString("mime", "audio/mp4a-latm");
                c46083g.eVr.setInteger("aac-profile", 2);
                c46083g.eVr.setInteger("sample-rate", c46083g.fYK.audioSampleRate);
                c46083g.eVr.setInteger("channel-count", 1);
                c46083g.eVr.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, c46083g.fYK.fzS);
                c46083g.eVr.setInteger("max-input-size", 16384);
                c46083g.oxX = MediaCodec.createEncoderByType(c46083g.clY);
                c46083g.oxX.configure(c46083g.eVr, null, null, 1);
                c46083g.oxW.start();
            } catch (Exception e22) {
                C4990ab.m7413e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", e22.getMessage());
                c46083g.oxY = false;
                c46083g.oxZ = new ArrayList();
                c46083g.oxX.release();
                c46083g.oxX = null;
            }
            C4990ab.m7417i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", Boolean.valueOf(c46083g.oxY));
            c46083g.bQh();
            AppMethodBeat.m2505o(3693);
            return true;
        }
        while (true) {
            allocateDirect.clear();
            int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
            C4990ab.m7411d("VideoClipperAPI18", "sampleSize: %d", Integer.valueOf(readSampleData));
            if (readSampleData <= 0) {
                C4990ab.m7417i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                break;
            } else if (mediaExtractor.getSampleTime() >= this.fYs * 1000) {
                break;
            } else if (mediaExtractor.getSampleTrackIndex() != this.ozu.index) {
                C4990ab.m7412e("VideoClipperAPI18", "track index not match! break");
                break;
            } else {
                allocateDirect.position(0);
                MP4MuxerJNI.writeAACData(i2, allocateDirect, readSampleData);
                mediaExtractor.advance();
            }
        }
        AppMethodBeat.m2505o(3693);
        return false;
    }

    /* renamed from: uG */
    public final int mo7958uG(String str) {
        Throwable th;
        AppMethodBeat.m2504i(3694);
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
                C4990ab.m7410d("VideoClipperAPI18", "findRotationMessage sDegree = ".concat(String.valueOf(extractMetadata)));
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                C4990ab.m7410d("VideoClipperAPI18", "findRotationMessage sHeight = ".concat(String.valueOf(extractMetadata2)));
                C4990ab.m7410d("VideoClipperAPI18", "findRotationMessage sWidth = ".concat(String.valueOf(extractMetadata3)));
                int i = C5046bo.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                AppMethodBeat.m2505o(3694);
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
            AppMethodBeat.m2505o(3694);
            throw th;
        }
    }
}
