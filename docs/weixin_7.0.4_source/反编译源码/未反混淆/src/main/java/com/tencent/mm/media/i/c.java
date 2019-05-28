package com.tencent.mm.media.i;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b=\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020\u000bJ\u0006\u0010(\u001a\u00020\u000bJ\u0006\u0010)\u001a\u00020\u000bJ\u0006\u0010*\u001a\u00020\u000bJ\u0006\u0010+\u001a\u00020\u000bJ\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020\u000bJ\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\u000bJ\u0006\u00100\u001a\u00020\u000bJ\u0006\u00101\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020\u000bJ\u0006\u00103\u001a\u00020\u000bJ\u0006\u00104\u001a\u00020\u000bJ\u0006\u00105\u001a\u00020\u000bJ\u0006\u00106\u001a\u00020\u000bJ\u0006\u00107\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020\u000bJ\u0006\u00109\u001a\u00020\u000bJ\u0006\u0010:\u001a\u00020\u000bJ\u0006\u0010;\u001a\u00020\u000bJ\u0006\u0010<\u001a\u00020\u000bJ\u0006\u0010=\u001a\u00020\u000bJ\u0006\u0010>\u001a\u00020\u000bJ\u0016\u0010?\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010@\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004J\u000e\u0010B\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010D\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010E\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010F\u001a\u00020\u000bJ\u0006\u0010G\u001a\u00020\u000bJ\u0006\u0010H\u001a\u00020\u000bJ\u0006\u0010I\u001a\u00020\u000bJ\u0016\u0010J\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010K\u001a\u00020\u000bJ\u0006\u0010L\u001a\u00020\u000bJ\u0006\u0010M\u001a\u00020\u000bJ\u0006\u0010N\u001a\u00020\u000bJ\u0006\u0010O\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, dWq = {"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markCameraOpen", "", "markCameraOpenFailed", "markCameraOpenSuccess", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "bitrate", "", "fps", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "time", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxVideoParaError", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "plugin-mediaeditor_release"})
public final class c {
    private static long fah = -1;
    private static long fai = -1;
    public static final c faj = new c();

    static {
        AppMethodBeat.i(13180);
        AppMethodBeat.o(13180);
    }

    private c() {
    }

    public static void Vk() {
        AppMethodBeat.i(13127);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
        h.pYm.k(985, 3, 1);
        AppMethodBeat.o(13127);
    }

    public static void Vl() {
        AppMethodBeat.i(13128);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
        h.pYm.k(985, 4, 1);
        AppMethodBeat.o(13128);
    }

    public static void Vm() {
        AppMethodBeat.i(13129);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
        h.pYm.k(985, 5, 1);
        AppMethodBeat.o(13129);
    }

    public static void Vn() {
        AppMethodBeat.i(13130);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
        fah = -1;
        h.pYm.k(985, 30, 1);
        AppMethodBeat.o(13130);
    }

    public static void Vo() {
        AppMethodBeat.i(13131);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
        h.pYm.k(985, 31, 1);
        AppMethodBeat.o(13131);
    }

    public static void Vp() {
        AppMethodBeat.i(13132);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
        h.pYm.k(985, 32, 1);
        AppMethodBeat.o(13132);
    }

    public static void Vq() {
        AppMethodBeat.i(13133);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
        h.pYm.k(985, 33, 1);
        AppMethodBeat.o(13133);
    }

    public static void Vr() {
        AppMethodBeat.i(13134);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
        fai = bo.yz();
        AppMethodBeat.o(13134);
    }

    public static void Vs() {
        AppMethodBeat.i(13135);
        if (fai > 0) {
            long az = bo.az(fai);
            ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264WaitStop, waitTime:".concat(String.valueOf(az)));
            h.pYm.k(985, 34, az);
            h.pYm.k(985, 35, 1);
            fai = -1;
        }
        AppMethodBeat.o(13135);
    }

    public static void Vt() {
        AppMethodBeat.i(13136);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
        h.pYm.k(985, 37, 1);
        AppMethodBeat.o(13136);
    }

    public static void Vu() {
        AppMethodBeat.i(13137);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
        h.pYm.k(985, 39, 1);
        AppMethodBeat.o(13137);
    }

    public static void cj(int i, int i2) {
        AppMethodBeat.i(13138);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + i + ", fps:" + i2);
        h.pYm.k(985, 38, (long) i);
        h.pYm.k(985, 41, (long) i2);
        AppMethodBeat.o(13138);
    }

    public static void Vv() {
        AppMethodBeat.i(13139);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
        fai = -1;
        h.pYm.k(985, 13, 1);
        AppMethodBeat.o(13139);
    }

    public static void Vw() {
        AppMethodBeat.i(13140);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
        h.pYm.k(985, 14, 1);
        AppMethodBeat.o(13140);
    }

    public static void Vx() {
        AppMethodBeat.i(13141);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
        h.pYm.k(985, 15, 1);
        AppMethodBeat.o(13141);
    }

    public static void Vy() {
        AppMethodBeat.i(13142);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
        h.pYm.k(985, 16, 1);
        AppMethodBeat.o(13142);
    }

    public static void Vz() {
        AppMethodBeat.i(13143);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
        fai = bo.yz();
        AppMethodBeat.o(13143);
    }

    public static void VA() {
        AppMethodBeat.i(13144);
        if (fai > 0) {
            long az = bo.az(fai);
            ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWaitStop, waitTime:".concat(String.valueOf(az)));
            h.pYm.k(985, 17, az);
            h.pYm.k(985, 18, 1);
            fai = -1;
        }
        AppMethodBeat.o(13144);
    }

    public static void VB() {
        AppMethodBeat.i(13145);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
        h.pYm.k(985, 20, 1);
        AppMethodBeat.o(13145);
    }

    public static void VC() {
        AppMethodBeat.i(13146);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
        h.pYm.k(985, 22, 1);
        AppMethodBeat.o(13146);
    }

    public static void ck(int i, int i2) {
        AppMethodBeat.i(13147);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + i + ", fps:" + i2);
        h.pYm.k(985, 21, (long) i);
        h.pYm.k(985, 24, (long) i2);
        AppMethodBeat.o(13147);
    }

    public static void kc(int i) {
        AppMethodBeat.i(13148);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, mixType:".concat(String.valueOf(i)));
        h.pYm.k(986, 0, 1);
        if (i == 1) {
            ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
            h.pYm.k(986, 1, 1);
            AppMethodBeat.o(13148);
        } else if (i == 3) {
            ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
            h.pYm.k(986, 2, 1);
            AppMethodBeat.o(13148);
        } else if (i == 2) {
            ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
            h.pYm.k(986, 3, 1);
            AppMethodBeat.o(13148);
        } else {
            if (i == 0) {
                ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
                h.pYm.k(986, 4, 1);
            }
            AppMethodBeat.o(13148);
        }
    }

    public static void VD() {
        AppMethodBeat.i(13149);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
        h.pYm.k(986, 7, 1);
        AppMethodBeat.o(13149);
    }

    public static void VE() {
        AppMethodBeat.i(13150);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
        h.pYm.k(986, 10, 1);
        AppMethodBeat.o(13150);
    }

    public static void VF() {
        AppMethodBeat.i(13151);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
        h.pYm.k(986, 11, 1);
        AppMethodBeat.o(13151);
    }

    public static void VG() {
        AppMethodBeat.i(13152);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRect");
        h.pYm.k(986, 12, 1);
        AppMethodBeat.o(13152);
    }

    public static void VH() {
        AppMethodBeat.i(13153);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropHit");
        h.pYm.k(986, 13, 1);
        AppMethodBeat.o(13153);
    }

    public static void VI() {
        AppMethodBeat.i(13154);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
        h.pYm.k(986, 14, 1);
        AppMethodBeat.o(13154);
    }

    public static void VJ() {
        AppMethodBeat.i(13155);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
        h.pYm.k(986, 15, 1);
        AppMethodBeat.o(13155);
    }

    public static void VK() {
        AppMethodBeat.i(13156);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
        h.pYm.k(986, 16, 1);
        AppMethodBeat.o(13156);
    }

    public static void VL() {
        AppMethodBeat.i(13157);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
        h.pYm.k(986, 17, 1);
        AppMethodBeat.o(13157);
    }

    public static void VM() {
        AppMethodBeat.i(13158);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
        h.pYm.k(986, 18, 1);
        AppMethodBeat.o(13158);
    }

    public static void VN() {
        AppMethodBeat.i(13159);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
        h.pYm.k(986, 19, 1);
        AppMethodBeat.o(13159);
    }

    public static void VO() {
        AppMethodBeat.i(13160);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
        h.pYm.k(986, 22, 1);
        AppMethodBeat.o(13160);
    }

    public static void VP() {
        AppMethodBeat.i(13161);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
        h.pYm.k(986, 23, 1);
        AppMethodBeat.o(13161);
    }

    public static void VQ() {
        AppMethodBeat.i(13162);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
        h.pYm.k(986, 24, 1);
        AppMethodBeat.o(13162);
    }

    public static void VR() {
        AppMethodBeat.i(13163);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
        h.pYm.k(986, 26, 1);
        AppMethodBeat.o(13163);
    }

    public static void fg(long j) {
        AppMethodBeat.i(13164);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMixTime: ".concat(String.valueOf(j)));
        h.pYm.k(986, 27, j);
        AppMethodBeat.o(13164);
    }

    public static void VS() {
        AppMethodBeat.i(13165);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
        h.pYm.k(986, 30, 1);
        AppMethodBeat.o(13165);
    }

    public static void fh(long j) {
        AppMethodBeat.i(13166);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMixTime: ".concat(String.valueOf(j)));
        h.pYm.k(986, 31, j);
        AppMethodBeat.o(13166);
    }

    public static void t(int i, long j) {
        AppMethodBeat.i(13167);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + i + ", time:" + j);
        h.pYm.k(986, 34, 1);
        if (i == 1) {
            ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeNoMusic, time:".concat(String.valueOf(j)));
            h.pYm.k(986, 35, j);
            AppMethodBeat.o(13167);
        } else if (i == 3) {
            ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeAll, time:".concat(String.valueOf(j)));
            h.pYm.k(986, 41, j);
            AppMethodBeat.o(13167);
        } else if (i == 2) {
            ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeMusicOnly, time:".concat(String.valueOf(j)));
            h.pYm.k(986, 37, j);
            AppMethodBeat.o(13167);
        } else {
            if (i == 0) {
                ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeSlient, time:".concat(String.valueOf(j)));
                h.pYm.k(986, 39, j);
            }
            AppMethodBeat.o(13167);
        }
    }

    public static void d(long j, long j2, long j3) {
        AppMethodBeat.i(13168);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + j + ", fps:" + j2 + ", originVideoFps:" + j3);
        h.pYm.k(986, 43, j3);
        h.pYm.k(986, 45, j2);
        h.pYm.k(986, 48, j);
        AppMethodBeat.o(13168);
    }

    public static void VT() {
        AppMethodBeat.i(13169);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
        h.pYm.k(986, 53, 1);
        AppMethodBeat.o(13169);
    }

    public static void VU() {
        AppMethodBeat.i(13170);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
        h.pYm.k(986, 25, 1);
        AppMethodBeat.o(13170);
    }

    public static void VV() {
        AppMethodBeat.i(13171);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
        h.pYm.k(986, 76, 1);
        AppMethodBeat.o(13171);
    }

    public static void VW() {
        AppMethodBeat.i(13172);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
        h.pYm.k(986, 80, 1);
        AppMethodBeat.o(13172);
    }

    public static void yj() {
        AppMethodBeat.i(139142);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
        h.pYm.k(986, 80, 1);
        AppMethodBeat.o(139142);
    }

    public static void VX() {
        AppMethodBeat.i(13173);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
        h.pYm.k(986, 77, 1);
        AppMethodBeat.o(13173);
    }

    public static void VY() {
        AppMethodBeat.i(13174);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
        h.pYm.k(986, 81, 1);
        AppMethodBeat.o(13174);
    }

    public static void VZ() {
        AppMethodBeat.i(13175);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
        h.pYm.k(986, 78, 1);
        AppMethodBeat.o(13175);
    }

    public static void Wa() {
        AppMethodBeat.i(13176);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
        h.pYm.k(986, 82, 1);
        AppMethodBeat.o(13176);
    }

    public static void Wb() {
        AppMethodBeat.i(13177);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
        h.pYm.k(986, 83, 1);
        AppMethodBeat.o(13177);
    }

    public static void Wc() {
        AppMethodBeat.i(13178);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
        h.pYm.k(986, 84, 1);
        AppMethodBeat.o(13178);
    }

    public static void Wd() {
        AppMethodBeat.i(13179);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
        h.pYm.k(986, 54, 1);
        AppMethodBeat.o(13179);
    }

    public static void We() {
        AppMethodBeat.i(138369);
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
        h.pYm.k(986, 86, 1);
        AppMethodBeat.o(138369);
    }
}
