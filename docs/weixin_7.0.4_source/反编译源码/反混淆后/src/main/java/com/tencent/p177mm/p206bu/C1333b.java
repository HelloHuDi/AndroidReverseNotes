package com.tencent.p177mm.p206bu;

import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTFaceDetector;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.wxmm.v2helper;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ,\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u000bJ\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "", "faceDetectWidth", "", "(I)V", "faceDetector", "Lcom/tencent/ttpic/PTFaceDetector;", "lastHasFace", "", "lastRotation", "destroy", "", "detectFace", "Lcom/tencent/ttpic/PTFaceAttr;", "frame", "Lcom/tencent/filter/Frame;", "needGesture", "sync", "isAllFrameDetect", "getFaceDetector", "Lcom/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector;", "getPhotoAngle", "", "init", "updateFaceDetector", "Companion", "plugin-ptsdk_release"})
/* renamed from: com.tencent.mm.bu.b */
public final class C1333b {
    public static final C1334a xtS = new C1334a();
    private int cjS;
    public PTFaceDetector xtP;
    private boolean xtQ;
    private final int xtR;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess$Companion;", "", "()V", "FaceDetectWidth", "", "TAG", "", "plugin-ptsdk_release"})
    /* renamed from: com.tencent.mm.bu.b$a */
    public static final class C1334a {
        private C1334a() {
        }

        public /* synthetic */ C1334a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(71507);
        AppMethodBeat.m2505o(71507);
    }

    public C1333b(char c) {
        this();
    }

    private C1333b() {
        this.xtR = 180;
    }

    public final void init() {
        AppMethodBeat.m2504i(71501);
        C4990ab.m7416i("MicroMsg.PTFaceDetectorProcess", "init");
        try {
            this.xtP = new PTFaceDetector();
            PTFaceDetector pTFaceDetector = this.xtP;
            if (pTFaceDetector != null) {
                pTFaceDetector.init();
            }
            dmC();
            AppMethodBeat.m2505o(71501);
        } catch (Exception e) {
            C7060h.pYm.mo15421z(1012, 49);
            AppMethodBeat.m2505o(71501);
        }
    }

    public final float getPhotoAngle() {
        AppMethodBeat.m2504i(71502);
        PTFaceDetector pTFaceDetector = this.xtP;
        if (pTFaceDetector != null) {
            VideoPreviewFaceOutlineDetector faceDetector = pTFaceDetector.getFaceDetector();
            if (faceDetector != null) {
                float photoAngle = faceDetector.getPhotoAngle();
                AppMethodBeat.m2505o(71502);
                return photoAngle;
            }
        }
        AppMethodBeat.m2505o(71502);
        return 0.0f;
    }

    /* renamed from: a */
    public static /* synthetic */ PTFaceAttr m2852a(C1333b c1333b, C41672h c41672h) {
        AppMethodBeat.m2504i(71504);
        PTFaceAttr a = c1333b.mo4681a(c41672h, false, false, false);
        AppMethodBeat.m2505o(71504);
        return a;
    }

    /* renamed from: a */
    public final PTFaceAttr mo4681a(C41672h c41672h, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(71503);
        C25052j.m39376p(c41672h, "frame");
        try {
            PTFaceAttr detectFrame;
            int i = (VideoFilterUtil.get4DirectionAngle((double) getPhotoAngle()) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            double d = (((double) this.xtR) * 1.0d) / ((double) c41672h.width);
            BenchUtil.benchStart("PTFaceDetector");
            PTFaceDetector pTFaceDetector = this.xtP;
            if (pTFaceDetector != null) {
                if (this.xtQ) {
                    i = this.cjS;
                }
                detectFrame = pTFaceDetector.detectFrame(c41672h, null, i, true, z, false, d, z2, z3);
            } else {
                detectFrame = null;
            }
            if (detectFrame != null) {
                this.xtQ = detectFrame.getFaceCount() > 0;
                if (this.xtQ) {
                    this.cjS = detectFrame.getRotation();
                }
            } else {
                this.xtQ = false;
            }
            BenchUtil.benchEnd("PTFaceDetector");
            AppMethodBeat.m2505o(71503);
            return detectFrame;
        } catch (Exception e) {
            C7060h.pYm.mo15421z(1012, 50);
            AppMethodBeat.m2505o(71503);
            return null;
        }
    }

    public final void destroy() {
        AppMethodBeat.m2504i(71505);
        C4990ab.m7416i("MicroMsg.PTFaceDetectorProcess", "destroy");
        try {
            PTFaceDetector pTFaceDetector = this.xtP;
            if (pTFaceDetector != null) {
                pTFaceDetector.destroy();
            }
        } catch (Exception e) {
            C7060h.pYm.mo15421z(1012, 51);
        }
        this.xtP = null;
        AppMethodBeat.m2505o(71505);
    }

    private final void dmC() {
        AppMethodBeat.m2504i(71506);
        PTFaceDetector pTFaceDetector = this.xtP;
        if (pTFaceDetector != null) {
            VideoPreviewFaceOutlineDetector faceDetector = pTFaceDetector.getFaceDetector();
            if (faceDetector != null) {
                faceDetector.clearActionCounter();
                AppMethodBeat.m2505o(71506);
                return;
            }
        }
        AppMethodBeat.m2505o(71506);
    }
}
