package com.tencent.p177mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ&\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.d */
public final class C34007d {
    private static final String TAG = TAG;
    private static final long lhy = lhy;
    public static final C34007d lhz = new C34007d();

    static {
        AppMethodBeat.m2504i(2614);
        AppMethodBeat.m2505o(2614);
    }

    private C34007d() {
    }

    public static void bmP() {
        AppMethodBeat.m2504i(2582);
        C4990ab.m7416i(TAG, "markEmojiCaptureUIOnCreate");
        C7060h.pYm.mo15419k(lhy, 0, 1);
        AppMethodBeat.m2505o(2582);
    }

    public static void bmQ() {
        AppMethodBeat.m2504i(2583);
        C4990ab.m7416i(TAG, "markEmojiCaptureUIOnDestroy");
        C7060h.pYm.mo15419k(lhy, 1, 1);
        AppMethodBeat.m2505o(2583);
    }

    /* renamed from: Vm */
    public static void m55706Vm() {
        AppMethodBeat.m2504i(2584);
        C4990ab.m7416i(TAG, "markCameraOpenFailed");
        C7060h.pYm.mo15419k(lhy, 3, 1);
        AppMethodBeat.m2505o(2584);
    }

    public static void bmR() {
        AppMethodBeat.m2504i(2585);
        C4990ab.m7416i(TAG, "markGpuCropPreview");
        C7060h.pYm.mo15419k(lhy, 6, 1);
        AppMethodBeat.m2505o(2585);
    }

    public static void bmS() {
        AppMethodBeat.m2504i(2586);
        C4990ab.m7416i(TAG, "markCpuCropPreview");
        C7060h.pYm.mo15419k(lhy, 7, 1);
        AppMethodBeat.m2505o(2586);
    }

    public static void bmT() {
        AppMethodBeat.m2504i(2587);
        C4990ab.m7416i(TAG, "markGpuCropPreviewFailed");
        C7060h.pYm.mo15419k(lhy, 8, 1);
        AppMethodBeat.m2505o(2587);
    }

    public static void bmU() {
        AppMethodBeat.m2504i(2588);
        C4990ab.m7416i(TAG, "markCpuCropPreviewFailed");
        C7060h.pYm.mo15419k(lhy, 9, 1);
        AppMethodBeat.m2505o(2588);
    }

    public static void bmV() {
        AppMethodBeat.m2504i(2589);
        C4990ab.m7416i(TAG, "markVideoRecordFailed");
        C7060h.pYm.mo15419k(lhy, 10, 1);
        AppMethodBeat.m2505o(2589);
    }

    public static void bmW() {
        AppMethodBeat.m2504i(2590);
        C4990ab.m7416i(TAG, "markVideoRecordNoThumb");
        C7060h.pYm.mo15419k(lhy, 11, 1);
        AppMethodBeat.m2505o(2590);
    }

    public static void bmX() {
        AppMethodBeat.m2504i(2591);
        C4990ab.m7416i(TAG, "markSdkInitFailed");
        C7060h.pYm.mo15419k(lhy, 13, 1);
        AppMethodBeat.m2505o(2591);
    }

    public static void bmY() {
        AppMethodBeat.m2504i(2592);
        C4990ab.m7416i(TAG, "markSdkDrawFailed");
        C7060h.pYm.mo15419k(lhy, 14, 1);
        AppMethodBeat.m2505o(2592);
    }

    public static void bmZ() {
        AppMethodBeat.m2504i(2593);
        C4990ab.m7416i(TAG, "markSdkReleaseFailed");
        C7060h.pYm.mo15419k(lhy, 15, 1);
        AppMethodBeat.m2505o(2593);
    }

    /* renamed from: a */
    public static void m55707a(boolean z, boolean z2, boolean z3, int i) {
        AppMethodBeat.m2504i(2594);
        C4990ab.m7416i(TAG, "markStartEmojiMix, removeBackground:" + z + ", hasSticker:" + z2 + ", speedUp:" + z3 + ", videoDuration:" + i);
        C7060h.pYm.mo15419k(lhy, 17, 1);
        if (z) {
            C7060h.pYm.mo15419k(lhy, 18, 1);
        }
        if (z2) {
            C7060h.pYm.mo15419k(lhy, 19, 1);
        }
        if (z3) {
            C7060h.pYm.mo15419k(lhy, 20, 1);
        }
        if (i > 0) {
            C7060h.pYm.mo15419k(lhy, 36, (long) i);
        }
        AppMethodBeat.m2505o(2594);
    }

    /* renamed from: p */
    public static void m55708p(long j, boolean z) {
        AppMethodBeat.m2504i(2595);
        C4990ab.m7416i(TAG, "markEmojiMixSucc, costTime:" + j + ", removeBackground:" + z);
        C7060h.pYm.mo15419k(lhy, 21, 1);
        if (z) {
            C7060h.pYm.mo15419k(lhy, 23, 1);
        } else {
            C7060h.pYm.mo15419k(lhy, 22, 1);
        }
        if (z) {
            C7060h.pYm.mo15419k(lhy, 42, j);
            AppMethodBeat.m2505o(2595);
            return;
        }
        C7060h.pYm.mo15419k(lhy, 39, j);
        AppMethodBeat.m2505o(2595);
    }

    public static void bna() {
        AppMethodBeat.m2504i(2596);
        C4990ab.m7416i(TAG, "markPixelBufferInitFailed");
        C7060h.pYm.mo15419k(lhy, 25, 1);
        AppMethodBeat.m2505o(2596);
    }

    public static void bnb() {
        AppMethodBeat.m2504i(2597);
        C4990ab.m7416i(TAG, "markVideoDecoderInitFailed");
        C7060h.pYm.mo15419k(lhy, 26, 1);
        AppMethodBeat.m2505o(2597);
    }

    public static void bnc() {
        AppMethodBeat.m2504i(2598);
        C4990ab.m7416i(TAG, "markMixFrameDrawFailed");
        C7060h.pYm.mo15419k(lhy, 27, 1);
        AppMethodBeat.m2505o(2598);
    }

    public static void bnd() {
        AppMethodBeat.m2504i(2599);
        C4990ab.m7416i(TAG, "markUseWxam");
        C7060h.pYm.mo15419k(lhy, 30, 1);
        AppMethodBeat.m2505o(2599);
    }

    public static void bne() {
        AppMethodBeat.m2504i(2600);
        C4990ab.m7416i(TAG, "markUseGif");
        C7060h.pYm.mo15419k(lhy, 31, 1);
        AppMethodBeat.m2505o(2600);
    }

    public static void bnf() {
        AppMethodBeat.m2504i(2601);
        C4990ab.m7416i(TAG, "markWxamInitFailed");
        C7060h.pYm.mo15419k(lhy, 32, 1);
        AppMethodBeat.m2505o(2601);
    }

    public static void bng() {
        AppMethodBeat.m2504i(2602);
        C4990ab.m7416i(TAG, "markGifInitFailed");
        C7060h.pYm.mo15419k(lhy, 33, 1);
        AppMethodBeat.m2505o(2602);
    }

    public static void bnh() {
        AppMethodBeat.m2504i(2603);
        C4990ab.m7416i(TAG, "markSdkSegmentInitFailed");
        C7060h.pYm.mo15421z(lhy, 45);
        AppMethodBeat.m2505o(2603);
    }

    public static void bni() {
        AppMethodBeat.m2504i(2604);
        C4990ab.m7416i(TAG, "markSdkSegmentDetectFailed");
        C7060h.pYm.mo15421z(lhy, 46);
        AppMethodBeat.m2505o(2604);
    }

    public static void bnj() {
        AppMethodBeat.m2504i(2605);
        C4990ab.m7416i(TAG, "markSdkSegmentDestroyFailed");
        C7060h.pYm.mo15421z(lhy, 47);
        AppMethodBeat.m2505o(2605);
    }

    public static void bnk() {
        AppMethodBeat.m2504i(2606);
        C4990ab.m7416i(TAG, "markSdkSoFailed");
        C7060h.pYm.mo15421z(lhy, 54);
        AppMethodBeat.m2505o(2606);
    }

    public static void bnl() {
        AppMethodBeat.m2504i(2607);
        C7060h.pYm.mo15421z(lhy, 56);
        AppMethodBeat.m2505o(2607);
    }

    public static void bnm() {
        AppMethodBeat.m2504i(2608);
        C7060h.pYm.mo15421z(lhy, 57);
        AppMethodBeat.m2505o(2608);
    }

    public static void bnn() {
        AppMethodBeat.m2504i(2609);
        C4990ab.m7416i(TAG, "markProxyCallFailed");
        C7060h.pYm.mo15421z(lhy, 59);
        AppMethodBeat.m2505o(2609);
    }

    public static void bno() {
        AppMethodBeat.m2504i(2610);
        C4990ab.m7416i(TAG, "markSegmentSoFailed");
        C7060h.pYm.mo15421z(lhy, 63);
        AppMethodBeat.m2505o(2610);
    }

    public static void bnp() {
        AppMethodBeat.m2504i(2611);
        C4990ab.m7416i(TAG, "markSegmentCpuSoFailed");
        C7060h.pYm.mo15421z(lhy, 64);
        AppMethodBeat.m2505o(2611);
    }

    public static void bnq() {
        AppMethodBeat.m2504i(2612);
        C4990ab.m7416i(TAG, "markSegmentNotManualInit");
        C7060h.pYm.mo15421z(lhy, 66);
        AppMethodBeat.m2505o(2612);
    }

    public static void bnr() {
        AppMethodBeat.m2504i(2613);
        C4990ab.m7416i(TAG, "markSegmentSoInitFailed");
        C7060h.pYm.mo15421z(lhy, 67);
        AppMethodBeat.m2505o(2613);
    }
}
