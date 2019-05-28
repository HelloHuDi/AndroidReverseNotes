package com.tencent.mm.plugin.emojicapture.model;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ&\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class d {
    private static final String TAG = TAG;
    private static final long lhy = lhy;
    public static final d lhz = new d();

    static {
        AppMethodBeat.i(2614);
        AppMethodBeat.o(2614);
    }

    private d() {
    }

    public static void bmP() {
        AppMethodBeat.i(2582);
        ab.i(TAG, "markEmojiCaptureUIOnCreate");
        h.pYm.k(lhy, 0, 1);
        AppMethodBeat.o(2582);
    }

    public static void bmQ() {
        AppMethodBeat.i(2583);
        ab.i(TAG, "markEmojiCaptureUIOnDestroy");
        h.pYm.k(lhy, 1, 1);
        AppMethodBeat.o(2583);
    }

    public static void Vm() {
        AppMethodBeat.i(2584);
        ab.i(TAG, "markCameraOpenFailed");
        h.pYm.k(lhy, 3, 1);
        AppMethodBeat.o(2584);
    }

    public static void bmR() {
        AppMethodBeat.i(2585);
        ab.i(TAG, "markGpuCropPreview");
        h.pYm.k(lhy, 6, 1);
        AppMethodBeat.o(2585);
    }

    public static void bmS() {
        AppMethodBeat.i(2586);
        ab.i(TAG, "markCpuCropPreview");
        h.pYm.k(lhy, 7, 1);
        AppMethodBeat.o(2586);
    }

    public static void bmT() {
        AppMethodBeat.i(2587);
        ab.i(TAG, "markGpuCropPreviewFailed");
        h.pYm.k(lhy, 8, 1);
        AppMethodBeat.o(2587);
    }

    public static void bmU() {
        AppMethodBeat.i(2588);
        ab.i(TAG, "markCpuCropPreviewFailed");
        h.pYm.k(lhy, 9, 1);
        AppMethodBeat.o(2588);
    }

    public static void bmV() {
        AppMethodBeat.i(2589);
        ab.i(TAG, "markVideoRecordFailed");
        h.pYm.k(lhy, 10, 1);
        AppMethodBeat.o(2589);
    }

    public static void bmW() {
        AppMethodBeat.i(2590);
        ab.i(TAG, "markVideoRecordNoThumb");
        h.pYm.k(lhy, 11, 1);
        AppMethodBeat.o(2590);
    }

    public static void bmX() {
        AppMethodBeat.i(2591);
        ab.i(TAG, "markSdkInitFailed");
        h.pYm.k(lhy, 13, 1);
        AppMethodBeat.o(2591);
    }

    public static void bmY() {
        AppMethodBeat.i(2592);
        ab.i(TAG, "markSdkDrawFailed");
        h.pYm.k(lhy, 14, 1);
        AppMethodBeat.o(2592);
    }

    public static void bmZ() {
        AppMethodBeat.i(2593);
        ab.i(TAG, "markSdkReleaseFailed");
        h.pYm.k(lhy, 15, 1);
        AppMethodBeat.o(2593);
    }

    public static void a(boolean z, boolean z2, boolean z3, int i) {
        AppMethodBeat.i(2594);
        ab.i(TAG, "markStartEmojiMix, removeBackground:" + z + ", hasSticker:" + z2 + ", speedUp:" + z3 + ", videoDuration:" + i);
        h.pYm.k(lhy, 17, 1);
        if (z) {
            h.pYm.k(lhy, 18, 1);
        }
        if (z2) {
            h.pYm.k(lhy, 19, 1);
        }
        if (z3) {
            h.pYm.k(lhy, 20, 1);
        }
        if (i > 0) {
            h.pYm.k(lhy, 36, (long) i);
        }
        AppMethodBeat.o(2594);
    }

    public static void p(long j, boolean z) {
        AppMethodBeat.i(2595);
        ab.i(TAG, "markEmojiMixSucc, costTime:" + j + ", removeBackground:" + z);
        h.pYm.k(lhy, 21, 1);
        if (z) {
            h.pYm.k(lhy, 23, 1);
        } else {
            h.pYm.k(lhy, 22, 1);
        }
        if (z) {
            h.pYm.k(lhy, 42, j);
            AppMethodBeat.o(2595);
            return;
        }
        h.pYm.k(lhy, 39, j);
        AppMethodBeat.o(2595);
    }

    public static void bna() {
        AppMethodBeat.i(2596);
        ab.i(TAG, "markPixelBufferInitFailed");
        h.pYm.k(lhy, 25, 1);
        AppMethodBeat.o(2596);
    }

    public static void bnb() {
        AppMethodBeat.i(2597);
        ab.i(TAG, "markVideoDecoderInitFailed");
        h.pYm.k(lhy, 26, 1);
        AppMethodBeat.o(2597);
    }

    public static void bnc() {
        AppMethodBeat.i(2598);
        ab.i(TAG, "markMixFrameDrawFailed");
        h.pYm.k(lhy, 27, 1);
        AppMethodBeat.o(2598);
    }

    public static void bnd() {
        AppMethodBeat.i(2599);
        ab.i(TAG, "markUseWxam");
        h.pYm.k(lhy, 30, 1);
        AppMethodBeat.o(2599);
    }

    public static void bne() {
        AppMethodBeat.i(2600);
        ab.i(TAG, "markUseGif");
        h.pYm.k(lhy, 31, 1);
        AppMethodBeat.o(2600);
    }

    public static void bnf() {
        AppMethodBeat.i(2601);
        ab.i(TAG, "markWxamInitFailed");
        h.pYm.k(lhy, 32, 1);
        AppMethodBeat.o(2601);
    }

    public static void bng() {
        AppMethodBeat.i(2602);
        ab.i(TAG, "markGifInitFailed");
        h.pYm.k(lhy, 33, 1);
        AppMethodBeat.o(2602);
    }

    public static void bnh() {
        AppMethodBeat.i(2603);
        ab.i(TAG, "markSdkSegmentInitFailed");
        h.pYm.z(lhy, 45);
        AppMethodBeat.o(2603);
    }

    public static void bni() {
        AppMethodBeat.i(2604);
        ab.i(TAG, "markSdkSegmentDetectFailed");
        h.pYm.z(lhy, 46);
        AppMethodBeat.o(2604);
    }

    public static void bnj() {
        AppMethodBeat.i(2605);
        ab.i(TAG, "markSdkSegmentDestroyFailed");
        h.pYm.z(lhy, 47);
        AppMethodBeat.o(2605);
    }

    public static void bnk() {
        AppMethodBeat.i(2606);
        ab.i(TAG, "markSdkSoFailed");
        h.pYm.z(lhy, 54);
        AppMethodBeat.o(2606);
    }

    public static void bnl() {
        AppMethodBeat.i(2607);
        h.pYm.z(lhy, 56);
        AppMethodBeat.o(2607);
    }

    public static void bnm() {
        AppMethodBeat.i(2608);
        h.pYm.z(lhy, 57);
        AppMethodBeat.o(2608);
    }

    public static void bnn() {
        AppMethodBeat.i(2609);
        ab.i(TAG, "markProxyCallFailed");
        h.pYm.z(lhy, 59);
        AppMethodBeat.o(2609);
    }

    public static void bno() {
        AppMethodBeat.i(2610);
        ab.i(TAG, "markSegmentSoFailed");
        h.pYm.z(lhy, 63);
        AppMethodBeat.o(2610);
    }

    public static void bnp() {
        AppMethodBeat.i(2611);
        ab.i(TAG, "markSegmentCpuSoFailed");
        h.pYm.z(lhy, 64);
        AppMethodBeat.o(2611);
    }

    public static void bnq() {
        AppMethodBeat.i(2612);
        ab.i(TAG, "markSegmentNotManualInit");
        h.pYm.z(lhy, 66);
        AppMethodBeat.o(2612);
    }

    public static void bnr() {
        AppMethodBeat.i(2613);
        ab.i(TAG, "markSegmentSoInitFailed");
        h.pYm.z(lhy, 67);
        AppMethodBeat.o(2613);
    }
}
