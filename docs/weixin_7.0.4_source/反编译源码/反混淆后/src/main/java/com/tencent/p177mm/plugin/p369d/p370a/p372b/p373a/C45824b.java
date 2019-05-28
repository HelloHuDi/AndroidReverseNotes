package com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C38832h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.d.a.b.a.b */
public class C45824b extends C20287a {
    static final String TAG = C45824b.class.getName();
    public static String jHe = C38832h.jGY;
    public static String jHf = C38832h.jGZ;
    public static String jHg = C38832h.jHa;
    private final int jHh;
    private final int jHi;
    private final int jHj;
    private final int jHk;
    private final int jHl;
    C11470b jHm;
    C11469a jHn;
    int jHo;

    /* renamed from: com.tencent.mm.plugin.d.a.b.a.b$a */
    class C11469a {
        public boolean jHp = false;
        public double jHq = 0.0d;
        public int jHr = 0;
        public int jHs = 0;
        public int jHt = 0;
        public C33885c jHu = new C33885c();

        public C11469a() {
            AppMethodBeat.m2504i(18457);
            AppMethodBeat.m2505o(18457);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.a.b$b */
    class C11470b {
        public boolean jHp = false;
        public int jHr = 0;
        public int jHs = 0;
        public int jHt = 0;
        public C33885c jHu = new C33885c();
        public double jHw = 0.0d;
        public double jHx = 0.0d;
        public double jHy = 0.0d;

        public C11470b() {
            AppMethodBeat.m2504i(18458);
            AppMethodBeat.m2505o(18458);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.a.b$c */
    public static class C33885c {
        public int enR = 0;
        public int enV = 0;
        public int jHA = 0;
        public int jHB = 0;
        public int jHC = 0;
        public int jHz = 0;

        /* renamed from: M */
        public final boolean mo54436M(byte[] bArr, int i) {
            AppMethodBeat.m2504i(18459);
            String access$000 = C45824b.TAG;
            String str = "data size = %d, offset = %d, lenght = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(7);
            C4990ab.m7411d(access$000, str, objArr);
            if (bArr == null || i < 0 || bArr.length < i + 7) {
                C4990ab.m7412e(C45824b.TAG, "data input error");
                AppMethodBeat.m2505o(18459);
                return false;
            }
            this.enV = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            this.enR = bArr[i + 2] & 255;
            this.jHz = bArr[i + 3] & 255;
            this.jHA = bArr[i + 4] & 255;
            this.jHB = bArr[i + 5] & 255;
            this.jHC = bArr[i + 6] & 255;
            C4990ab.m7411d(C45824b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", Integer.valueOf(this.enV), Integer.valueOf(this.enR), Integer.valueOf(this.jHz), Integer.valueOf(this.jHA), Integer.valueOf(this.jHB), Integer.valueOf(this.jHC));
            AppMethodBeat.m2505o(18459);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(18461);
        AppMethodBeat.m2505o(18461);
    }

    public C45824b() {
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

    /* renamed from: L */
    static double m84812L(byte[] bArr, int i) {
        AppMethodBeat.m2504i(18460);
        int i2 = (bArr[i + 1] << 8) & 65280;
        int i3 = (i2 >> 12) - 16;
        int i4 = i2 & 3840;
        int i5 = (bArr[i] & 255) + (65280 & i4);
        double pow = ((double) i5) * Math.pow(10.0d, (double) i3);
        C4990ab.m7410d(TAG, "hbyte=" + i2 + " hvalue=" + i4 + " value=" + i5 + " exp=" + i3);
        AppMethodBeat.m2505o(18460);
        return pow;
    }

    public final byte[] aVE() {
        return null;
    }
}
