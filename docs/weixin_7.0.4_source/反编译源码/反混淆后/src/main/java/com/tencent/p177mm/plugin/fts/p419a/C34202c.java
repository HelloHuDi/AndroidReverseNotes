package com.tencent.p177mm.plugin.fts.p419a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.fts.a.c */
public final class C34202c {
    public static final int[] mCc = new int[]{65536};
    public static final int[] mCd = new int[]{196608};
    public static final int[] mCe = new int[]{262144};
    public static final int[] mCf = new int[]{327680};
    public static final int[] mCg = new int[]{393216};
    public static final int[] mCh = new int[]{458752};
    public static final int[] mCi = new int[]{131073, 131074};
    public static final int[] mCj = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131076, 131081};
    public static final int[] mCk = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131076, 131081};
    public static final int[] mCl = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    public static final int[] mCm = new int[]{131073, 131074};
    public static final int[] mCn = new int[]{131077, 131078};
    public static final int[] mCo = new int[]{131079, 131080};
    public static final int[] mCp = new int[]{5, 6, 7, 1, 2, 3};
    public static final Map<Integer, Integer> mCq;
    public static final int[] mCr = new int[]{2, 3, 6, 7};
    public static final int[] mCs = new int[]{29, 30, 31, 34, 35, 36, 33, 32, 37};
    public static final int[] mCt;
    public static final int[] mCu;
    public static final int[] mCv = new int[43];
    public static final int[] mCw = new int[27];
    public static final String mCx = (C1761b.eSn + "fts/");

    /* renamed from: com.tencent.mm.plugin.fts.a.c$a */
    public static final class C28110a {
        public static final Pattern mCA = Pattern.compile("​");
        public static final Pattern mCB = Pattern.compile("‌");
        public static final Pattern mCC;
        public static final Pattern mCD;
        public static final Pattern mCE = Pattern.compile("\\s+");
        public static final Pattern mCF = Pattern.compile(",");
        public static final Pattern mCG = Pattern.compile("[A-Za-z]+");
        public static final Pattern mCy = Pattern.compile(";");
        public static final Pattern mCz = Pattern.compile(" ");

        static {
            AppMethodBeat.m2504i(114186);
            Pattern compile = Pattern.compile("‍");
            mCC = compile;
            mCD = compile;
            AppMethodBeat.m2505o(114186);
        }
    }

    static {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(114187);
        int[] iArr = new int[]{8, 9, 10};
        mCt = iArr;
        mCu = iArr;
        int[] iArr2 = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080};
        int[] iArr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0};
        int[] iArr4 = new int[]{1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0};
        HashMap hashMap = new HashMap();
        for (i = 0; i < 9; i++) {
            hashMap.put(Integer.valueOf(iArr2[i]), Integer.valueOf(i));
        }
        mCq = Collections.unmodifiableMap(hashMap);
        for (i = 0; i < 43; i++) {
            mCv[iArr3[i]] = i;
        }
        while (i2 < 27) {
            mCw[iArr4[i2]] = i2;
            i2++;
        }
        AppMethodBeat.m2505o(114187);
    }
}
