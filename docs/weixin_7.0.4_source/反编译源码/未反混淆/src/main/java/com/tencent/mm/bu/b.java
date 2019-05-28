package com.tencent.mm.bu;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTFaceDetector;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.wxmm.v2helper;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ,\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u000bJ\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "", "faceDetectWidth", "", "(I)V", "faceDetector", "Lcom/tencent/ttpic/PTFaceDetector;", "lastHasFace", "", "lastRotation", "destroy", "", "detectFace", "Lcom/tencent/ttpic/PTFaceAttr;", "frame", "Lcom/tencent/filter/Frame;", "needGesture", "sync", "isAllFrameDetect", "getFaceDetector", "Lcom/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector;", "getPhotoAngle", "", "init", "updateFaceDetector", "Companion", "plugin-ptsdk_release"})
public final class b {
    public static final a xtS = new a();
    private int cjS;
    public PTFaceDetector xtP;
    private boolean xtQ;
    private final int xtR;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess$Companion;", "", "()V", "FaceDetectWidth", "", "TAG", "", "plugin-ptsdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(71507);
        AppMethodBeat.o(71507);
    }

    public b(char c) {
        this();
    }

    private b() {
        this.xtR = 180;
    }

    public final void init() {
        AppMethodBeat.i(71501);
        ab.i("MicroMsg.PTFaceDetectorProcess", "init");
        try {
            this.xtP = new PTFaceDetector();
            PTFaceDetector pTFaceDetector = this.xtP;
            if (pTFaceDetector != null) {
                pTFaceDetector.init();
            }
            dmC();
            AppMethodBeat.o(71501);
        } catch (Exception e) {
            h.pYm.z(1012, 49);
            AppMethodBeat.o(71501);
        }
    }

    public final float getPhotoAngle() {
        AppMethodBeat.i(71502);
        PTFaceDetector pTFaceDetector = this.xtP;
        if (pTFaceDetector != null) {
            VideoPreviewFaceOutlineDetector faceDetector = pTFaceDetector.getFaceDetector();
            if (faceDetector != null) {
                float photoAngle = faceDetector.getPhotoAngle();
                AppMethodBeat.o(71502);
                return photoAngle;
            }
        }
        AppMethodBeat.o(71502);
        return 0.0f;
    }

    public static /* synthetic */ PTFaceAttr a(b bVar, com.tencent.filter.h hVar) {
        AppMethodBeat.i(71504);
        PTFaceAttr a = bVar.a(hVar, false, false, false);
        AppMethodBeat.o(71504);
        return a;
    }

    public final PTFaceAttr a(com.tencent.filter.h hVar, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(71503);
        j.p(hVar, "frame");
        try {
            PTFaceAttr detectFrame;
            int i = (VideoFilterUtil.get4DirectionAngle((double) getPhotoAngle()) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            double d = (((double) this.xtR) * 1.0d) / ((double) hVar.width);
            BenchUtil.benchStart("PTFaceDetector");
            PTFaceDetector pTFaceDetector = this.xtP;
            if (pTFaceDetector != null) {
                if (this.xtQ) {
                    i = this.cjS;
                }
                detectFrame = pTFaceDetector.detectFrame(hVar, null, i, true, z, false, d, z2, z3);
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
            AppMethodBeat.o(71503);
            return detectFrame;
        } catch (Exception e) {
            h.pYm.z(1012, 50);
            AppMethodBeat.o(71503);
            return null;
        }
    }

    public final void destroy() {
        AppMethodBeat.i(71505);
        ab.i("MicroMsg.PTFaceDetectorProcess", "destroy");
        try {
            PTFaceDetector pTFaceDetector = this.xtP;
            if (pTFaceDetector != null) {
                pTFaceDetector.destroy();
            }
        } catch (Exception e) {
            h.pYm.z(1012, 51);
        }
        this.xtP = null;
        AppMethodBeat.o(71505);
    }

    private final void dmC() {
        AppMethodBeat.i(71506);
        PTFaceDetector pTFaceDetector = this.xtP;
        if (pTFaceDetector != null) {
            VideoPreviewFaceOutlineDetector faceDetector = pTFaceDetector.getFaceDetector();
            if (faceDetector != null) {
                faceDetector.clearActionCounter();
                AppMethodBeat.o(71506);
                return;
            }
        }
        AppMethodBeat.o(71506);
    }
}
