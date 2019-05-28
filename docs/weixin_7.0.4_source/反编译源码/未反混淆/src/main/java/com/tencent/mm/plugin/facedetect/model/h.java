package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Arrays;

public final class h {
    public static h lTS;
    public int[] lTQ = null;
    public int lTR = -1;
    public int lfO = 0;

    public static class a {
        public String gJH;
        public long lTT;
        public long lTU;
        public boolean lTV;
        public long lTW;
        public String lTX;
        public boolean lTY;
        public boolean lTZ;
        public int type;

        public a(int i, String str) {
            AppMethodBeat.i(216);
            this.type = i;
            this.lTX = str;
            switch (this.type) {
                case 0:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = ah.getContext().getString(R.string.er4);
                    this.lTV = true;
                    this.lTW = 2500;
                    this.lTY = false;
                    this.lTZ = false;
                    AppMethodBeat.o(216);
                    return;
                case 1:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = ah.getContext().getString(R.string.bkh);
                    this.lTV = false;
                    this.lTW = -1;
                    this.lTY = true;
                    this.lTZ = true;
                    AppMethodBeat.o(216);
                    return;
                case 2:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = ah.getContext().getString(R.string.bki);
                    this.lTV = false;
                    this.lTW = -1;
                    this.lTY = true;
                    this.lTZ = true;
                    AppMethodBeat.o(216);
                    return;
                case 3:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = ah.getContext().getString(R.string.bkg);
                    this.lTV = true;
                    this.lTW = -1;
                    this.lTY = true;
                    this.lTZ = true;
                    AppMethodBeat.o(216);
                    return;
                case 4:
                    this.lTT = 30;
                    this.lTU = 7000;
                    this.gJH = ah.getContext().getString(R.string.bkj);
                    this.lTV = true;
                    this.lTW = 1000;
                    this.lTY = true;
                    this.lTZ = true;
                    AppMethodBeat.o(216);
                    return;
                default:
                    ab.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
                    this.type = 100;
                    AppMethodBeat.o(216);
                    return;
            }
        }

        public final String toString() {
            AppMethodBeat.i(217);
            String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.lTT + ", hintTween=" + this.lTU + ", hintStr='" + this.gJH + '\'' + ", isCheckFace=" + this.lTV + ", minSuccTime=" + this.lTW + ", actionData='" + this.lTX + '\'' + '}';
            AppMethodBeat.o(217);
            return str;
        }
    }

    public static a bsI() {
        String str;
        AppMethodBeat.i(218);
        int bsD = f.lTL.bsD();
        g gVar = f.lTL.lTM.lVR;
        if (gVar.lTP == null) {
            ab.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
            str = null;
        } else {
            str = gVar.lTP.engineGetCurrMotionData();
        }
        a aVar = new a(bsD, str);
        AppMethodBeat.o(218);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(219);
        String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.lTQ) + '}';
        AppMethodBeat.o(219);
        return str;
    }
}
