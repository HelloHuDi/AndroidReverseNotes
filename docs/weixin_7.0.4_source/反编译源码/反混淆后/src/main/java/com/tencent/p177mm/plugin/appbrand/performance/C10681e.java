package com.tencent.p177mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.RandomAccessFile;

/* renamed from: com.tencent.mm.plugin.appbrand.performance.e */
public final class C10681e {
    private final int ivS;
    private volatile RandomAccessFile ivT;
    private volatile RandomAccessFile ivU;
    private boolean ivV;
    private long ivW;
    private long ivX;
    private long ivY;

    public C10681e(int i) {
        this.ivS = i;
    }

    public final double aKs() {
        AppMethodBeat.m2504i(102242);
        if (this.ivV) {
            AppMethodBeat.m2505o(102242);
            return 0.0d;
        }
        double d = 0.0d;
        try {
            if (this.ivU == null) {
                this.ivU = new RandomAccessFile("/proc/" + this.ivS + "/stat", "r");
            }
            this.ivU.seek(0);
            String readLine = this.ivU.readLine();
            if (C5046bo.isNullOrNil(readLine)) {
                AppMethodBeat.m2505o(102242);
                return 0.0d;
            }
            String[] split = readLine.split(" ");
            if (split.length < 17) {
                AppMethodBeat.m2505o(102242);
                return 0.0d;
            }
            long j;
            long anl;
            if (this.ivT == null) {
                this.ivT = new RandomAccessFile("/proc/stat", "r");
            }
            this.ivT.seek(0);
            readLine = this.ivT.readLine();
            if (C5046bo.isNullOrNil(readLine)) {
                j = 0;
            } else {
                String[] split2 = readLine.split(" ");
                if (split2.length < 9) {
                    j = 0;
                } else {
                    anl = C5046bo.anl(split2[2]);
                    long anl2 = C5046bo.anl(split2[3]);
                    long anl3 = C5046bo.anl(split2[4]);
                    long anl4 = C5046bo.anl(split2[5]);
                    long anl5 = C5046bo.anl(split2[6]);
                    long anl6 = C5046bo.anl(split2[7]);
                    j = C5046bo.anl(split2[9]) + ((((((anl + anl2) + anl3) + anl4) + anl5) + anl6) + C5046bo.anl(split2[8]));
                }
            }
            anl = C5046bo.anl(split[13]);
            long anl7 = C5046bo.anl(split[14]);
            if (this.ivW != 0) {
                double d2 = ((double) ((anl7 - this.ivY) * 100)) / ((double) (j - this.ivW));
                d = Math.max(0.0d, d2) + Math.max(0.0d, ((double) ((anl - this.ivX) * 100)) / ((double) (j - this.ivW)));
            }
            this.ivW = j;
            this.ivX = anl;
            this.ivY = anl7;
            AppMethodBeat.m2505o(102242);
            return d;
        } catch (Exception e) {
            C4990ab.m7412e(" MicroMsg.CpuSampler", "read pid stat file error: ".concat(String.valueOf(e)));
            this.ivV = true;
        }
    }
}
