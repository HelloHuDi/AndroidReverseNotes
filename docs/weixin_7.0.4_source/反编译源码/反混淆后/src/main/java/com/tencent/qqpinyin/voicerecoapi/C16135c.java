package com.tencent.qqpinyin.voicerecoapi;

import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.qqpinyin.voicerecoapi.c */
public final class C16135c {
    private TRVADNative AqD;
    private int gaV;
    private int ioJ;

    /* renamed from: com.tencent.qqpinyin.voicerecoapi.c$a */
    public static class C16136a {
        public int AqE = 0;
        public int AqF = 256;
        public int AqG = 512;
        private int AqH = 0;
        public int AqI = 0;
    }

    public C16135c(int i) {
        AppMethodBeat.m2504i(35436);
        this.AqD = new TRVADNative();
        this.gaV = i;
        this.ioJ = GmsVersion.VERSION_LONGHORN;
        AppMethodBeat.m2505o(35436);
    }

    public C16135c() {
        AppMethodBeat.m2504i(35437);
        this.AqD = new TRVADNative();
        this.gaV = 500000;
        this.ioJ = 10000000;
        AppMethodBeat.m2505o(35437);
    }

    public final int dPU() {
        AppMethodBeat.m2504i(35438);
        int mfeInit = this.AqD.mfeInit(this.gaV, this.ioJ);
        if (mfeInit == 0) {
            mfeInit = this.AqD.mfeOpen();
            if (mfeInit == 0) {
                mfeInit = this.AqD.mfeEnableNoiseDetection(true);
                if (mfeInit == 0) {
                    mfeInit = this.AqD.mfeStart();
                }
            }
        }
        if (mfeInit == 0) {
            AppMethodBeat.m2505o(35438);
            return 0;
        }
        AppMethodBeat.m2505o(35438);
        return -1;
    }

    public final int stop() {
        AppMethodBeat.m2504i(35439);
        int mfeStop = this.AqD.mfeStop();
        if (mfeStop == 0) {
            mfeStop = this.AqD.mfeClose();
            if (mfeStop == 0) {
                mfeStop = this.AqD.mfeExit();
            }
        }
        if (mfeStop == 0) {
            AppMethodBeat.m2505o(35439);
            return 0;
        }
        AppMethodBeat.m2505o(35439);
        return -1;
    }

    /* renamed from: a */
    public final synchronized void mo28643a(short[] sArr, int i, C16136a c16136a) {
        double d = 26.0d;
        synchronized (this) {
            AppMethodBeat.m2504i(35440);
            if (i <= 0) {
                AppMethodBeat.m2505o(35440);
            } else {
                switch (this.AqD.mfeSendData(sArr, i)) {
                    case 1:
                        c16136a.AqE = 1;
                        break;
                    case 2:
                        c16136a.AqE = 2;
                        break;
                    case 3:
                        c16136a.AqE = 3;
                        break;
                    default:
                        c16136a.AqE = 0;
                        break;
                }
                int i2 = 0;
                int i3 = 0;
                while (i2 < i) {
                    i2++;
                    i3 = (int) (((double) i3) + (Math.sqrt((double) (sArr[i2] * sArr[i2])) / ((double) i)));
                }
                if (i3 < 100) {
                    d = 0.0d;
                } else if (i3 <= 16383) {
                    d = 26.0d * ((((double) i3) - 100.0d) / 32667.0d);
                }
                c16136a.AqI = (int) d;
                new StringBuilder("volumn��").append(c16136a.AqI);
                AppMethodBeat.m2505o(35440);
            }
        }
    }
}
