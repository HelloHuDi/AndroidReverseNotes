package com.tencent.p177mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.facedetect.model.h */
public final class C43033h {
    public static C43033h lTS;
    public int[] lTQ = null;
    public int lTR = -1;
    public int lfO = 0;

    /* renamed from: com.tencent.mm.plugin.facedetect.model.h$a */
    public static class C39012a {
        public String gJH;
        public long lTT;
        public long lTU;
        public boolean lTV;
        public long lTW;
        public String lTX;
        public boolean lTY;
        public boolean lTZ;
        public int type;

        public C39012a(int i, String str) {
            AppMethodBeat.m2504i(216);
            this.type = i;
            this.lTX = str;
            switch (this.type) {
                case 0:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = C4996ah.getContext().getString(C25738R.string.er4);
                    this.lTV = true;
                    this.lTW = 2500;
                    this.lTY = false;
                    this.lTZ = false;
                    AppMethodBeat.m2505o(216);
                    return;
                case 1:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = C4996ah.getContext().getString(C25738R.string.bkh);
                    this.lTV = false;
                    this.lTW = -1;
                    this.lTY = true;
                    this.lTZ = true;
                    AppMethodBeat.m2505o(216);
                    return;
                case 2:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = C4996ah.getContext().getString(C25738R.string.bki);
                    this.lTV = false;
                    this.lTW = -1;
                    this.lTY = true;
                    this.lTZ = true;
                    AppMethodBeat.m2505o(216);
                    return;
                case 3:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = C4996ah.getContext().getString(C25738R.string.bkg);
                    this.lTV = true;
                    this.lTW = -1;
                    this.lTY = true;
                    this.lTZ = true;
                    AppMethodBeat.m2505o(216);
                    return;
                case 4:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = C4996ah.getContext().getString(C25738R.string.bkj);
                    this.lTV = true;
                    this.lTW = 1000;
                    this.lTY = true;
                    this.lTZ = true;
                    AppMethodBeat.m2505o(216);
                    return;
                default:
                    C4990ab.m7412e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
                    this.type = 100;
                    AppMethodBeat.m2505o(216);
                    return;
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(217);
            String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.lTT + ", hintTween=" + this.lTU + ", hintStr='" + this.gJH + '\'' + ", isCheckFace=" + this.lTV + ", minSuccTime=" + this.lTW + ", actionData='" + this.lTX + '\'' + '}';
            AppMethodBeat.m2505o(217);
            return str;
        }
    }

    public static C39012a bsI() {
        String str;
        AppMethodBeat.m2504i(218);
        int bsD = C11810f.lTL.bsD();
        C43032g c43032g = C11810f.lTL.lTM.lVR;
        if (c43032g.lTP == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
            str = null;
        } else {
            str = c43032g.lTP.engineGetCurrMotionData();
        }
        C39012a c39012a = new C39012a(bsD, str);
        AppMethodBeat.m2505o(218);
        return c39012a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(219);
        String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.lTQ) + '}';
        AppMethodBeat.m2505o(219);
        return str;
    }
}
