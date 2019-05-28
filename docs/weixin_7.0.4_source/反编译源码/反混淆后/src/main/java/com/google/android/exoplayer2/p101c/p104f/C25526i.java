package com.google.android.exoplayer2.p101c.p104f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45041j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.Arrays;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.c.f.i */
public final class C25526i implements C0845h {
    private static final double[] bbK = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private boolean aTf;
    private C32041m aTw;
    private long bbJ;
    private long bbL;
    private final boolean[] bbM = new boolean[4];
    private final C0846a bbN = new C0846a();
    private long bbO;
    private boolean bbP;
    private long bbQ;
    private long bbR;
    private boolean bbS;
    private boolean bbT;
    private String bbx;

    /* renamed from: com.google.android.exoplayer2.c.f.i$a */
    static final class C0846a {
        static final byte[] bbU = new byte[]{(byte) 0, (byte) 0, (byte) 1};
        boolean bbV;
        public int bbW;
        public byte[] data = new byte[128];
        public int length;

        public C0846a() {
            AppMethodBeat.m2504i(95111);
            AppMethodBeat.m2505o(95111);
        }

        /* renamed from: d */
        public final void mo2560d(byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(95112);
            if (this.bbV) {
                int i3 = i2 - i;
                if (this.data.length < this.length + i3) {
                    this.data = Arrays.copyOf(this.data, (this.length + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length = i3 + this.length;
                AppMethodBeat.m2505o(95112);
                return;
            }
            AppMethodBeat.m2505o(95112);
        }
    }

    public C25526i() {
        AppMethodBeat.m2504i(95113);
        AppMethodBeat.m2505o(95113);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        AppMethodBeat.m2504i(95114);
        C45041j.m82575b(this.bbM);
        C0846a c0846a = this.bbN;
        c0846a.bbV = false;
        c0846a.length = 0;
        c0846a.bbW = 0;
        this.bbO = 0;
        this.bbP = false;
        AppMethodBeat.m2505o(95114);
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95115);
        c8661d.mo19155rz();
        this.bbx = c8661d.mo19154rB();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        AppMethodBeat.m2505o(95115);
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        this.bbQ = j;
    }

    /* renamed from: ro */
    public final void mo2558ro() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        AppMethodBeat.m2504i(95116);
        int i = c32065l.position;
        int i2 = c32065l.limit;
        byte[] bArr = c32065l.data;
        this.bbO += (long) c32065l.mo52382tB();
        this.aTw.mo42835a(c32065l, c32065l.mo52382tB());
        while (true) {
            int a = C45041j.m82574a(bArr, i, i2, this.bbM);
            if (a == i2) {
                if (!this.aTf) {
                    this.bbN.mo2560d(bArr, i, i2);
                }
                AppMethodBeat.m2505o(95116);
                return;
            }
            long j;
            int i3 = c32065l.data[a + 3] & 255;
            if (!this.aTf) {
                Object obj;
                int i4 = a - i;
                if (i4 > 0) {
                    this.bbN.mo2560d(bArr, i, a);
                }
                i = i4 < 0 ? -i4 : 0;
                C0846a c0846a = this.bbN;
                if (c0846a.bbV) {
                    c0846a.length -= i;
                    if (c0846a.bbW == 0 && i3 == 181) {
                        c0846a.bbW = c0846a.length;
                    } else {
                        c0846a.bbV = false;
                        obj = 1;
                        if (obj != null) {
                            C0846a c0846a2 = this.bbN;
                            String str = this.bbx;
                            byte[] copyOf = Arrays.copyOf(c0846a2.data, c0846a2.length);
                            int i5 = copyOf[5] & 255;
                            int i6 = (i5 >> 4) | ((copyOf[4] & 255) << 4);
                            i5 = ((i5 & 15) << 8) | (copyOf[6] & 255);
                            float f = 1.0f;
                            switch ((copyOf[7] & 240) >> 4) {
                                case 2:
                                    f = ((float) (i5 * 4)) / ((float) (i6 * 3));
                                    break;
                                case 3:
                                    f = ((float) (i5 * 16)) / ((float) (i6 * 9));
                                    break;
                                case 4:
                                    f = ((float) (i5 * 121)) / ((float) (i6 * 100));
                                    break;
                            }
                            Format a2 = Format.m15273a(str, "video/mpeg2", i6, i5, Collections.singletonList(copyOf), f);
                            j = 0;
                            i5 = (copyOf[7] & 15) - 1;
                            if (i5 >= 0 && i5 < bbK.length) {
                                double d = bbK[i5];
                                i5 = c0846a2.bbW;
                                int i7 = (copyOf[i5 + 9] & 96) >> 5;
                                i5 = copyOf[i5 + 9] & 31;
                                if (i7 != i5) {
                                    d *= (((double) i7) + 1.0d) / ((double) (i5 + 1));
                                }
                                j = (long) (1000000.0d / d);
                            }
                            Pair create = Pair.create(a2, Long.valueOf(j));
                            this.aTw.mo42836f((Format) create.first);
                            this.bbL = ((Long) create.second).longValue();
                            this.aTf = true;
                        }
                    }
                } else if (i3 == 179) {
                    c0846a.bbV = true;
                }
                c0846a.mo2560d(C0846a.bbU, 0, C0846a.bbU.length);
                obj = null;
                if (obj != null) {
                }
            }
            if (i3 == 0 || i3 == 179) {
                int i8 = i2 - a;
                if (this.bbP && this.bbT && this.aTf) {
                    this.aTw.mo42834a(this.bbJ, this.bbS ? 1 : 0, ((int) (this.bbO - this.bbR)) - i8, i8, null);
                }
                if (!this.bbP || this.bbT) {
                    this.bbR = this.bbO - ((long) i8);
                    j = this.bbQ != -9223372036854775807L ? this.bbQ : this.bbP ? this.bbJ + this.bbL : 0;
                    this.bbJ = j;
                    this.bbS = false;
                    this.bbQ = -9223372036854775807L;
                    this.bbP = true;
                }
                this.bbT = i3 == 0;
            } else if (i3 == FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE) {
                this.bbS = true;
            }
            i = a + 3;
        }
    }
}
