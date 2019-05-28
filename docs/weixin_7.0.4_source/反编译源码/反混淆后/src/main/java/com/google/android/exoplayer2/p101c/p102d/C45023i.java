package com.google.android.exoplayer2.p101c.p102d;

import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.d.i */
final class C45023i {
    private static final int[] aZl = new int[]{C17675v.m27562aT("isom"), C17675v.m27562aT("iso2"), C17675v.m27562aT("iso3"), C17675v.m27562aT("iso4"), C17675v.m27562aT("iso5"), C17675v.m27562aT("iso6"), C17675v.m27562aT("avc1"), C17675v.m27562aT("hvc1"), C17675v.m27562aT("hev1"), C17675v.m27562aT("mp41"), C17675v.m27562aT("mp42"), C17675v.m27562aT("3g2a"), C17675v.m27562aT("3g2b"), C17675v.m27562aT("3gr6"), C17675v.m27562aT("3gs6"), C17675v.m27562aT("3ge6"), C17675v.m27562aT("3gg6"), C17675v.m27562aT("M4V "), C17675v.m27562aT("M4A "), C17675v.m27562aT("f4v "), C17675v.m27562aT("kddi"), C17675v.m27562aT("M4VP"), C17675v.m27562aT("qt  "), C17675v.m27562aT("MSNV")};

    static {
        AppMethodBeat.m2504i(95012);
        AppMethodBeat.m2505o(95012);
    }

    /* renamed from: g */
    public static boolean m82491g(C45026f c45026f) {
        AppMethodBeat.m2504i(95008);
        boolean b = C45023i.m82489b(c45026f, true);
        AppMethodBeat.m2505o(95008);
        return b;
    }

    /* renamed from: h */
    public static boolean m82492h(C45026f c45026f) {
        AppMethodBeat.m2504i(95009);
        boolean b = C45023i.m82489b(c45026f, false);
        AppMethodBeat.m2505o(95009);
        return b;
    }

    /* renamed from: b */
    private static boolean m82489b(C45026f c45026f, boolean z) {
        AppMethodBeat.m2504i(95010);
        long length = c45026f.getLength();
        if (length == -1 || length > 4096) {
            length = 4096;
        }
        int i = (int) length;
        C32065l c32065l = new C32065l(64);
        Object obj = null;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < i) {
            int i3 = 8;
            c32065l.reset(8);
            c45026f.mo59479b(c32065l.data, 0, 8);
            long cM = c32065l.mo52366cM();
            int readInt = c32065l.readInt();
            if (cM == 1) {
                i3 = 16;
                c45026f.mo59479b(c32065l.data, 8, 8);
                c32065l.mo52368eL(16);
                cM = c32065l.mo52391tK();
            } else if (cM == 0) {
                long length2 = c45026f.getLength();
                if (length2 != -1) {
                    cM = (length2 - c45026f.getPosition()) + 8;
                }
            }
            if (cM >= ((long) i3)) {
                i2 += i3;
                if (readInt != C32025a.aWi) {
                    if (readInt != C32025a.aWr && readInt != C32025a.aWt) {
                        if ((((long) i2) + cM) - ((long) i3) >= ((long) i)) {
                            break;
                        }
                        int i4 = (int) (cM - ((long) i3));
                        int i5 = i2 + i4;
                        if (readInt != C32025a.aVH) {
                            if (i4 != 0) {
                                c45026f.mo59483dH(i4);
                            }
                            i2 = i5;
                        } else if (i4 < 8) {
                            AppMethodBeat.m2505o(95010);
                            return false;
                        } else {
                            c32065l.reset(i4);
                            c45026f.mo59479b(c32065l.data, 0, i4);
                            i3 = i4 / 4;
                            for (i4 = 0; i4 < i3; i4++) {
                                if (i4 == 1) {
                                    c32065l.mo52369eM(4);
                                } else if (C45023i.m82490dY(c32065l.readInt())) {
                                    obj = 1;
                                    break;
                                }
                            }
                            if (obj == null) {
                                AppMethodBeat.m2505o(95010);
                                return false;
                            }
                            i2 = i5;
                        }
                    } else {
                        z2 = true;
                        break;
                    }
                }
            } else {
                AppMethodBeat.m2505o(95010);
                return false;
            }
        }
        if (obj == null || z != z2) {
            AppMethodBeat.m2505o(95010);
            return false;
        }
        AppMethodBeat.m2505o(95010);
        return true;
    }

    /* renamed from: dY */
    private static boolean m82490dY(int i) {
        AppMethodBeat.m2504i(95011);
        if ((i >>> 8) == C17675v.m27562aT("3gp")) {
            AppMethodBeat.m2505o(95011);
            return true;
        }
        for (int i2 : aZl) {
            if (i2 == i) {
                AppMethodBeat.m2505o(95011);
                return true;
            }
        }
        AppMethodBeat.m2505o(95011);
        return false;
    }
}
