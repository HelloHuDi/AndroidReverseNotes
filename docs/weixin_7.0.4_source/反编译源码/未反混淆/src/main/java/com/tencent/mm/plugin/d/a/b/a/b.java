package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ab;

public class b extends a {
    static final String TAG = b.class.getName();
    public static String jHe = h.jGY;
    public static String jHf = h.jGZ;
    public static String jHg = h.jHa;
    private final int jHh;
    private final int jHi;
    private final int jHj;
    private final int jHk;
    private final int jHl;
    b jHm;
    a jHn;
    int jHo;

    class a {
        public boolean jHp = false;
        public double jHq = 0.0d;
        public int jHr = 0;
        public int jHs = 0;
        public int jHt = 0;
        public c jHu = new c();

        public a() {
            AppMethodBeat.i(18457);
            AppMethodBeat.o(18457);
        }
    }

    class b {
        public boolean jHp = false;
        public int jHr = 0;
        public int jHs = 0;
        public int jHt = 0;
        public c jHu = new c();
        public double jHw = 0.0d;
        public double jHx = 0.0d;
        public double jHy = 0.0d;

        public b() {
            AppMethodBeat.i(18458);
            AppMethodBeat.o(18458);
        }
    }

    public static class c {
        public int enR = 0;
        public int enV = 0;
        public int jHA = 0;
        public int jHB = 0;
        public int jHC = 0;
        public int jHz = 0;

        public final boolean M(byte[] bArr, int i) {
            AppMethodBeat.i(18459);
            String access$000 = b.TAG;
            String str = "data size = %d, offset = %d, lenght = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(7);
            ab.d(access$000, str, objArr);
            if (bArr == null || i < 0 || bArr.length < i + 7) {
                ab.e(b.TAG, "data input error");
                AppMethodBeat.o(18459);
                return false;
            }
            this.enV = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            this.enR = bArr[i + 2] & 255;
            this.jHz = bArr[i + 3] & 255;
            this.jHA = bArr[i + 4] & 255;
            this.jHB = bArr[i + 5] & 255;
            this.jHC = bArr[i + 6] & 255;
            ab.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", Integer.valueOf(this.enV), Integer.valueOf(this.enR), Integer.valueOf(this.jHz), Integer.valueOf(this.jHA), Integer.valueOf(this.jHB), Integer.valueOf(this.jHC));
            AppMethodBeat.o(18459);
            return true;
        }
    }

    static {
        AppMethodBeat.i(18461);
        AppMethodBeat.o(18461);
    }

    public b() {
        this.jHh = 1;
        this.jHi = 2;
        this.jHj = 4;
        this.jHk = 8;
        this.jHl = 16;
        this.jHc = null;
        this.jHd = 2;
        this.jGw = 8;
        this.jHm = null;
    }

    static double L(byte[] bArr, int i) {
        AppMethodBeat.i(18460);
        int i2 = (bArr[i + 1] << 8) & 65280;
        int i3 = (i2 >> 12) - 16;
        int i4 = i2 & 3840;
        int i5 = (bArr[i] & 255) + (65280 & i4);
        double pow = ((double) i5) * Math.pow(10.0d, (double) i3);
        ab.d(TAG, "hbyte=" + i2 + " hvalue=" + i4 + " value=" + i5 + " exp=" + i3);
        AppMethodBeat.o(18460);
        return pow;
    }

    public final byte[] aVE() {
        return null;
    }
}
