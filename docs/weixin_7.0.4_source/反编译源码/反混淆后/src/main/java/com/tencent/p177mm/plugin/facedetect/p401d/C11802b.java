package com.tencent.p177mm.plugin.facedetect.p401d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.facedetect.model.C43033h.C39012a;
import com.tencent.p177mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.facedetect.d.b */
public interface C11802b {

    /* renamed from: com.tencent.mm.plugin.facedetect.d.b$b */
    public static class C11803b {
        public String aIm;
        public int errCode;

        public C11803b(int i, String str) {
            this.errCode = i;
            this.aIm = str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.b$a */
    public static class C11804a {
        public String aIm;
        public int lVa;
        public int lVb;

        C11804a(String str) {
            this.lVb = 7;
            this.aIm = str;
        }

        C11804a() {
            this.lVa = 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.b$c */
    public static class C11805c {
        private static String TAG = "MicroMsg.IFaceMotion.Factory";

        /* renamed from: a */
        public static C11802b m19653a(C39012a c39012a) {
            AppMethodBeat.m2504i(C31128d.MIC_PTU_YINGTAOBUDING);
            C11802b c3023d;
            if (c39012a == null) {
                AppMethodBeat.m2505o(C31128d.MIC_PTU_YINGTAOBUDING);
                return null;
            } else if (c39012a.type == 4) {
                C4990ab.m7416i(TAG, "hy: is read number");
                c3023d = new C3023d(c39012a.lTX);
                AppMethodBeat.m2505o(C31128d.MIC_PTU_YINGTAOBUDING);
                return c3023d;
            } else {
                C4990ab.m7416i(TAG, "hy: is normal");
                c3023d = new C3019c(c39012a.gJH, c39012a.lTU);
                AppMethodBeat.m2505o(C31128d.MIC_PTU_YINGTAOBUDING);
                return c3023d;
            }
        }
    }

    /* renamed from: a */
    void mo7238a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2);

    /* renamed from: a */
    boolean mo7239a(FaceCharacteristicsResult faceCharacteristicsResult);

    /* renamed from: b */
    boolean mo7240b(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean bsV();

    boolean bsW();

    void bsX();

    C11803b bsY();

    C11804a bsZ();

    void setBusinessTip(String str);
}
