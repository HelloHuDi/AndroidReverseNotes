package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public interface b {

    public static class b {
        public String aIm;
        public int errCode;

        public b(int i, String str) {
            this.errCode = i;
            this.aIm = str;
        }
    }

    public static class a {
        public String aIm;
        public int lVa;
        public int lVb;

        a(String str) {
            this.lVb = 7;
            this.aIm = str;
        }

        a() {
            this.lVa = 1;
        }
    }

    public static class c {
        private static String TAG = "MicroMsg.IFaceMotion.Factory";

        public static b a(com.tencent.mm.plugin.facedetect.model.h.a aVar) {
            AppMethodBeat.i(d.MIC_PTU_YINGTAOBUDING);
            b dVar;
            if (aVar == null) {
                AppMethodBeat.o(d.MIC_PTU_YINGTAOBUDING);
                return null;
            } else if (aVar.type == 4) {
                ab.i(TAG, "hy: is read number");
                dVar = new d(aVar.lTX);
                AppMethodBeat.o(d.MIC_PTU_YINGTAOBUDING);
                return dVar;
            } else {
                ab.i(TAG, "hy: is normal");
                dVar = new c(aVar.gJH, aVar.lTU);
                AppMethodBeat.o(d.MIC_PTU_YINGTAOBUDING);
                return dVar;
            }
        }
    }

    void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2);

    boolean a(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean b(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean bsV();

    boolean bsW();

    void bsX();

    b bsY();

    a bsZ();

    void setBusinessTip(String str);
}
