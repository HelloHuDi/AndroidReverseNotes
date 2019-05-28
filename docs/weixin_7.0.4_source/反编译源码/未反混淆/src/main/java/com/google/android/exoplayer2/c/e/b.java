package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.view.d;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b extends h {
    f aZZ;
    private a baa;

    class a implements f, l {
        long[] bab;
        long[] bac;
        private long bad = -1;
        long firstFrameOffset = -1;

        public final long i(com.google.android.exoplayer2.c.f fVar) {
            if (this.bad < 0) {
                return -1;
            }
            long j = -(this.bad + 2);
            this.bad = -1;
            return j;
        }

        public final long S(long j) {
            AppMethodBeat.i(95027);
            long U = b.this.U(j);
            this.bad = this.bab[v.a(this.bab, U, true)];
            AppMethodBeat.o(95027);
            return U;
        }

        public final l rk() {
            return this;
        }

        public final boolean qX() {
            return true;
        }

        public final long M(long j) {
            AppMethodBeat.i(95028);
            int a = v.a(this.bab, b.this.U(j), true);
            long j2 = this.bac[a] + this.firstFrameOffset;
            AppMethodBeat.o(95028);
            return j2;
        }

        public final long getDurationUs() {
            f fVar = b.this.aZZ;
            return (fVar.brj * 1000000) / ((long) fVar.sampleRate);
        }
    }

    b() {
    }

    public static boolean r(com.google.android.exoplayer2.i.l lVar) {
        AppMethodBeat.i(95029);
        if (lVar.tB() >= 5 && lVar.readUnsignedByte() == d.MIC_SketchMark && lVar.cM() == 1179402563) {
            AppMethodBeat.o(95029);
            return true;
        }
        AppMethodBeat.o(95029);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        AppMethodBeat.i(95030);
        super.reset(z);
        if (z) {
            this.aZZ = null;
            this.baa = null;
        }
        AppMethodBeat.o(95030);
    }

    private static boolean p(byte[] bArr) {
        return bArr[0] == (byte) -1;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079 A:{LOOP_START, LOOP:1: B:22:0x0079->B:21:0x0072, PHI: r0 r2 } */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long s(com.google.android.exoplayer2.i.l lVar) {
        int i = 1;
        AppMethodBeat.i(95031);
        if (p(lVar.data)) {
            int i2 = (lVar.data[2] & 255) >> 4;
            switch (i2) {
                case 1:
                    i = az.CTRL_INDEX;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    i = 576 << (i2 - 2);
                    break;
                case 6:
                case 7:
                    int i3;
                    lVar.eM(4);
                    long j = (long) lVar.data[lVar.position];
                    for (i3 = 7; i3 >= 0; i3--) {
                        if ((((long) (1 << i3)) & j) == 0) {
                            if (i3 < 6) {
                                j &= (long) ((1 << i3) - 1);
                                i3 = 7 - i3;
                            } else {
                                if (i3 == 7) {
                                    i3 = 1;
                                }
                                i3 = 0;
                            }
                            NumberFormatException numberFormatException;
                            if (i3 == 0) {
                                while (i < i3) {
                                    byte b = lVar.data[lVar.position + i];
                                    if ((b & az.CTRL_INDEX) != 128) {
                                        numberFormatException = new NumberFormatException("Invalid UTF-8 sequence continuation byte: ".concat(String.valueOf(j)));
                                        AppMethodBeat.o(95031);
                                        throw numberFormatException;
                                    }
                                    j = (j << 6) | ((long) (b & 63));
                                    i++;
                                }
                                lVar.position += i3;
                                i = i2 == 6 ? lVar.readUnsignedByte() : lVar.readUnsignedShort();
                                lVar.setPosition(0);
                                i++;
                                break;
                            }
                            numberFormatException = new NumberFormatException("Invalid UTF-8 sequence first byte: ".concat(String.valueOf(j)));
                            AppMethodBeat.o(95031);
                            throw numberFormatException;
                        }
                    }
                    i3 = 0;
                    if (i3 == 0) {
                    }
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    i = 256 << (i2 - 8);
                    break;
                default:
                    i = -1;
                    break;
            }
            long j2 = (long) i;
            AppMethodBeat.o(95031);
            return j2;
        }
        AppMethodBeat.o(95031);
        return -1;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(com.google.android.exoplayer2.i.l lVar, long j, a aVar) {
        int i = 0;
        AppMethodBeat.i(95032);
        byte[] bArr = lVar.data;
        if (this.aZZ == null) {
            this.aZZ = new f(bArr);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.limit);
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            f fVar = this.aZZ;
            aVar.aOv = Format.a(null, "audio/flac", -1, fVar.sampleRate * fVar.bdU, this.aZZ.channels, this.aZZ.sampleRate, singletonList, null, null);
        } else if ((bArr[0] & d.MIC_SketchMark) == 3) {
            this.baa = new a();
            a aVar2 = this.baa;
            lVar.eM(1);
            int tD = lVar.tD() / 18;
            aVar2.bab = new long[tD];
            aVar2.bac = new long[tD];
            while (i < tD) {
                aVar2.bab[i] = lVar.readLong();
                aVar2.bac[i] = lVar.readLong();
                lVar.eM(2);
                i++;
            }
        } else if (p(bArr)) {
            if (this.baa != null) {
                this.baa.firstFrameOffset = j;
                aVar.bax = this.baa;
            }
            AppMethodBeat.o(95032);
            return false;
        }
        AppMethodBeat.o(95032);
        return true;
    }
}
