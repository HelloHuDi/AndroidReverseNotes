package com.google.android.exoplayer2.c.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.Arrays;
import java.util.Collections;

public final class i implements h {
    private static final double[] bbK = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private boolean aTf;
    private m aTw;
    private long bbJ;
    private long bbL;
    private final boolean[] bbM = new boolean[4];
    private final a bbN = new a();
    private long bbO;
    private boolean bbP;
    private long bbQ;
    private long bbR;
    private boolean bbS;
    private boolean bbT;
    private String bbx;

    static final class a {
        static final byte[] bbU = new byte[]{(byte) 0, (byte) 0, (byte) 1};
        boolean bbV;
        public int bbW;
        public byte[] data = new byte[128];
        public int length;

        public a() {
            AppMethodBeat.i(95111);
            AppMethodBeat.o(95111);
        }

        public final void d(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(95112);
            if (this.bbV) {
                int i3 = i2 - i;
                if (this.data.length < this.length + i3) {
                    this.data = Arrays.copyOf(this.data, (this.length + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length = i3 + this.length;
                AppMethodBeat.o(95112);
                return;
            }
            AppMethodBeat.o(95112);
        }
    }

    public i() {
        AppMethodBeat.i(95113);
        AppMethodBeat.o(95113);
    }

    public final void rn() {
        AppMethodBeat.i(95114);
        j.b(this.bbM);
        a aVar = this.bbN;
        aVar.bbV = false;
        aVar.length = 0;
        aVar.bbW = 0;
        this.bbO = 0;
        this.bbP = false;
        AppMethodBeat.o(95114);
    }

    public final void a(g gVar, d dVar) {
        AppMethodBeat.i(95115);
        dVar.rz();
        this.bbx = dVar.rB();
        this.aTw = gVar.dM(dVar.rA());
        AppMethodBeat.o(95115);
    }

    public final void d(long j, boolean z) {
        this.bbQ = j;
    }

    public final void ro() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(l lVar) {
        AppMethodBeat.i(95116);
        int i = lVar.position;
        int i2 = lVar.limit;
        byte[] bArr = lVar.data;
        this.bbO += (long) lVar.tB();
        this.aTw.a(lVar, lVar.tB());
        while (true) {
            int a = j.a(bArr, i, i2, this.bbM);
            if (a == i2) {
                if (!this.aTf) {
                    this.bbN.d(bArr, i, i2);
                }
                AppMethodBeat.o(95116);
                return;
            }
            long j;
            int i3 = lVar.data[a + 3] & 255;
            if (!this.aTf) {
                Object obj;
                int i4 = a - i;
                if (i4 > 0) {
                    this.bbN.d(bArr, i, a);
                }
                i = i4 < 0 ? -i4 : 0;
                a aVar = this.bbN;
                if (aVar.bbV) {
                    aVar.length -= i;
                    if (aVar.bbW == 0 && i3 == 181) {
                        aVar.bbW = aVar.length;
                    } else {
                        aVar.bbV = false;
                        obj = 1;
                        if (obj != null) {
                            a aVar2 = this.bbN;
                            String str = this.bbx;
                            byte[] copyOf = Arrays.copyOf(aVar2.data, aVar2.length);
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
                            Format a2 = Format.a(str, "video/mpeg2", i6, i5, Collections.singletonList(copyOf), f);
                            j = 0;
                            i5 = (copyOf[7] & 15) - 1;
                            if (i5 >= 0 && i5 < bbK.length) {
                                double d = bbK[i5];
                                i5 = aVar2.bbW;
                                int i7 = (copyOf[i5 + 9] & 96) >> 5;
                                i5 = copyOf[i5 + 9] & 31;
                                if (i7 != i5) {
                                    d *= (((double) i7) + 1.0d) / ((double) (i5 + 1));
                                }
                                j = (long) (1000000.0d / d);
                            }
                            Pair create = Pair.create(a2, Long.valueOf(j));
                            this.aTw.f((Format) create.first);
                            this.bbL = ((Long) create.second).longValue();
                            this.aTf = true;
                        }
                    }
                } else if (i3 == 179) {
                    aVar.bbV = true;
                }
                aVar.d(a.bbU, 0, a.bbU.length);
                obj = null;
                if (obj != null) {
                }
            }
            if (i3 == 0 || i3 == 179) {
                int i8 = i2 - a;
                if (this.bbP && this.bbT && this.aTf) {
                    this.aTw.a(this.bbJ, this.bbS ? 1 : 0, ((int) (this.bbO - this.bbR)) - i8, i8, null);
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
