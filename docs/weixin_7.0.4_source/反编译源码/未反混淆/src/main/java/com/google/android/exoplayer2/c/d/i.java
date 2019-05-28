package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i {
    private static final int[] aZl = new int[]{v.aT("isom"), v.aT("iso2"), v.aT("iso3"), v.aT("iso4"), v.aT("iso5"), v.aT("iso6"), v.aT("avc1"), v.aT("hvc1"), v.aT("hev1"), v.aT("mp41"), v.aT("mp42"), v.aT("3g2a"), v.aT("3g2b"), v.aT("3gr6"), v.aT("3gs6"), v.aT("3ge6"), v.aT("3gg6"), v.aT("M4V "), v.aT("M4A "), v.aT("f4v "), v.aT("kddi"), v.aT("M4VP"), v.aT("qt  "), v.aT("MSNV")};

    static {
        AppMethodBeat.i(95012);
        AppMethodBeat.o(95012);
    }

    public static boolean g(f fVar) {
        AppMethodBeat.i(95008);
        boolean b = b(fVar, true);
        AppMethodBeat.o(95008);
        return b;
    }

    public static boolean h(f fVar) {
        AppMethodBeat.i(95009);
        boolean b = b(fVar, false);
        AppMethodBeat.o(95009);
        return b;
    }

    private static boolean b(f fVar, boolean z) {
        AppMethodBeat.i(95010);
        long length = fVar.getLength();
        if (length == -1 || length > 4096) {
            length = 4096;
        }
        int i = (int) length;
        l lVar = new l(64);
        Object obj = null;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < i) {
            int i3 = 8;
            lVar.reset(8);
            fVar.b(lVar.data, 0, 8);
            long cM = lVar.cM();
            int readInt = lVar.readInt();
            if (cM == 1) {
                i3 = 16;
                fVar.b(lVar.data, 8, 8);
                lVar.eL(16);
                cM = lVar.tK();
            } else if (cM == 0) {
                long length2 = fVar.getLength();
                if (length2 != -1) {
                    cM = (length2 - fVar.getPosition()) + 8;
                }
            }
            if (cM >= ((long) i3)) {
                i2 += i3;
                if (readInt != a.aWi) {
                    if (readInt != a.aWr && readInt != a.aWt) {
                        if ((((long) i2) + cM) - ((long) i3) >= ((long) i)) {
                            break;
                        }
                        int i4 = (int) (cM - ((long) i3));
                        int i5 = i2 + i4;
                        if (readInt != a.aVH) {
                            if (i4 != 0) {
                                fVar.dH(i4);
                            }
                            i2 = i5;
                        } else if (i4 < 8) {
                            AppMethodBeat.o(95010);
                            return false;
                        } else {
                            lVar.reset(i4);
                            fVar.b(lVar.data, 0, i4);
                            i3 = i4 / 4;
                            for (i4 = 0; i4 < i3; i4++) {
                                if (i4 == 1) {
                                    lVar.eM(4);
                                } else if (dY(lVar.readInt())) {
                                    obj = 1;
                                    break;
                                }
                            }
                            if (obj == null) {
                                AppMethodBeat.o(95010);
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
                AppMethodBeat.o(95010);
                return false;
            }
        }
        if (obj == null || z != z2) {
            AppMethodBeat.o(95010);
            return false;
        }
        AppMethodBeat.o(95010);
        return true;
    }

    private static boolean dY(int i) {
        AppMethodBeat.i(95011);
        if ((i >>> 8) == v.aT("3gp")) {
            AppMethodBeat.o(95011);
            return true;
        }
        for (int i2 : aZl) {
            if (i2 == i) {
                AppMethodBeat.o(95011);
                return true;
            }
        }
        AppMethodBeat.o(95011);
        return false;
    }
}
