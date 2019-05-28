package com.tencent.p177mm.plugin.mmsight.p1490a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mmsight.a.a */
public final class C34537a {

    /* renamed from: com.tencent.mm.plugin.mmsight.a.a$a */
    public static class C34538a {
        int cvd = 2;
        int scene;

        public C34538a(int i) {
            AppMethodBeat.m2504i(54953);
            if (i == 1) {
                this.scene = 1;
                AppMethodBeat.m2505o(54953);
            } else if (i == 2) {
                this.scene = 2;
                AppMethodBeat.m2505o(54953);
            } else if (i == 512) {
                this.cvd = 1;
                this.scene = 2;
                AppMethodBeat.m2505o(54953);
            } else {
                if (i == 4) {
                    this.scene = 4;
                }
                AppMethodBeat.m2505o(54953);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(54954);
            String str = "VideoEditCountData{scene=" + this.scene + ", source=" + this.cvd + '}';
            AppMethodBeat.m2505o(54954);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.a.a$b */
    public static class C34539b {
        public boolean eVT;
        public int efs;
        public int oxA;
        public boolean oxB;
        public int oxC;
        public int oxD;
        public int oxx;
        public int oxy;
        public int oxz;
        public int scene;
        public int textColor;

        public C34539b(int i) {
            AppMethodBeat.m2504i(54955);
            if (i == 1) {
                this.scene = 2;
                AppMethodBeat.m2505o(54955);
            } else if (i == 2) {
                this.scene = 4;
                AppMethodBeat.m2505o(54955);
            } else if (i == 512) {
                this.scene = 3;
                AppMethodBeat.m2505o(54955);
            } else {
                if (i == 4) {
                    this.scene = 8;
                }
                AppMethodBeat.m2505o(54955);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(54956);
            String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.eVT + ", rawDuration=" + this.oxx + ", cropDuration=" + this.oxy + ", emojiItemCount=" + this.oxz + ", textItemCount=" + this.oxA + ", isCrop=" + this.oxB + ", undoCount=" + this.efs + ", doodleCount=" + this.oxC + ", penColors=" + this.oxD + ", textColor=" + this.textColor + '}';
            AppMethodBeat.m2505o(54956);
            return str;
        }
    }

    /* renamed from: a */
    public static void m56630a(C34539b c34539b, String str) {
        AppMethodBeat.m2504i(54957);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[14];
        objArr[0] = Integer.valueOf(c34539b.scene);
        objArr[1] = Integer.valueOf(c34539b.eVT ? 2 : 1);
        objArr[2] = Integer.valueOf(c34539b.oxz);
        objArr[3] = Integer.valueOf(c34539b.oxA);
        objArr[4] = Integer.valueOf(c34539b.oxC);
        objArr[5] = Boolean.valueOf(c34539b.oxB);
        objArr[6] = Integer.valueOf(c34539b.efs);
        objArr[7] = Integer.valueOf(c34539b.oxx);
        objArr[8] = Integer.valueOf(c34539b.oxy);
        objArr[9] = Integer.valueOf(c34539b.oxD);
        objArr[10] = Integer.valueOf(0);
        objArr[11] = Integer.valueOf(c34539b.textColor);
        objArr[12] = str;
        objArr[13] = Long.valueOf(C5046bo.anT());
        c7060h.mo8381e(14362, objArr);
        C4990ab.m7417i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", c34539b.toString());
        AppMethodBeat.m2505o(54957);
    }

    /* renamed from: a */
    public static void m56629a(C34538a c34538a) {
        AppMethodBeat.m2504i(54958);
        C4990ab.m7417i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", c34538a.toString());
        C7060h.pYm.mo8381e(14529, Integer.valueOf(c34538a.scene), Integer.valueOf(c34538a.cvd));
        AppMethodBeat.m2505o(54958);
    }
}
