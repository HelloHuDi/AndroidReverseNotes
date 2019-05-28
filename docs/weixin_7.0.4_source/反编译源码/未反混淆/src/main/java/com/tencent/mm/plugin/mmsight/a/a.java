package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {

    public static class a {
        int cvd = 2;
        int scene;

        public a(int i) {
            AppMethodBeat.i(54953);
            if (i == 1) {
                this.scene = 1;
                AppMethodBeat.o(54953);
            } else if (i == 2) {
                this.scene = 2;
                AppMethodBeat.o(54953);
            } else if (i == 512) {
                this.cvd = 1;
                this.scene = 2;
                AppMethodBeat.o(54953);
            } else {
                if (i == 4) {
                    this.scene = 4;
                }
                AppMethodBeat.o(54953);
            }
        }

        public final String toString() {
            AppMethodBeat.i(54954);
            String str = "VideoEditCountData{scene=" + this.scene + ", source=" + this.cvd + '}';
            AppMethodBeat.o(54954);
            return str;
        }
    }

    public static class b {
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

        public b(int i) {
            AppMethodBeat.i(54955);
            if (i == 1) {
                this.scene = 2;
                AppMethodBeat.o(54955);
            } else if (i == 2) {
                this.scene = 4;
                AppMethodBeat.o(54955);
            } else if (i == 512) {
                this.scene = 3;
                AppMethodBeat.o(54955);
            } else {
                if (i == 4) {
                    this.scene = 8;
                }
                AppMethodBeat.o(54955);
            }
        }

        public final String toString() {
            AppMethodBeat.i(54956);
            String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.eVT + ", rawDuration=" + this.oxx + ", cropDuration=" + this.oxy + ", emojiItemCount=" + this.oxz + ", textItemCount=" + this.oxA + ", isCrop=" + this.oxB + ", undoCount=" + this.efs + ", doodleCount=" + this.oxC + ", penColors=" + this.oxD + ", textColor=" + this.textColor + '}';
            AppMethodBeat.o(54956);
            return str;
        }
    }

    public static void a(b bVar, String str) {
        AppMethodBeat.i(54957);
        h hVar = h.pYm;
        Object[] objArr = new Object[14];
        objArr[0] = Integer.valueOf(bVar.scene);
        objArr[1] = Integer.valueOf(bVar.eVT ? 2 : 1);
        objArr[2] = Integer.valueOf(bVar.oxz);
        objArr[3] = Integer.valueOf(bVar.oxA);
        objArr[4] = Integer.valueOf(bVar.oxC);
        objArr[5] = Boolean.valueOf(bVar.oxB);
        objArr[6] = Integer.valueOf(bVar.efs);
        objArr[7] = Integer.valueOf(bVar.oxx);
        objArr[8] = Integer.valueOf(bVar.oxy);
        objArr[9] = Integer.valueOf(bVar.oxD);
        objArr[10] = Integer.valueOf(0);
        objArr[11] = Integer.valueOf(bVar.textColor);
        objArr[12] = str;
        objArr[13] = Long.valueOf(bo.anT());
        hVar.e(14362, objArr);
        ab.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", bVar.toString());
        AppMethodBeat.o(54957);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(54958);
        ab.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", aVar.toString());
        h.pYm.e(14529, Integer.valueOf(aVar.scene), Integer.valueOf(aVar.cvd));
        AppMethodBeat.o(54958);
    }
}
