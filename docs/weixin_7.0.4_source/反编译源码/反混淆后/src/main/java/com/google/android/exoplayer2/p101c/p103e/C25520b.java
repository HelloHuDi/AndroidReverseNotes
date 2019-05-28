package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.p103e.C32031h.C32032a;
import com.google.android.exoplayer2.p111i.C0872f;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.view.C31128d;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.e.b */
final class C25520b extends C32031h {
    C0872f aZZ;
    private C0843a baa;

    /* renamed from: com.google.android.exoplayer2.c.e.b$a */
    class C0843a implements C37237f, C37247l {
        long[] bab;
        long[] bac;
        private long bad = -1;
        long firstFrameOffset = -1;

        /* renamed from: i */
        public final long mo2551i(C45026f c45026f) {
            if (this.bad < 0) {
                return -1;
            }
            long j = -(this.bad + 2);
            this.bad = -1;
            return j;
        }

        /* renamed from: S */
        public final long mo2549S(long j) {
            AppMethodBeat.m2504i(95027);
            long U = C25520b.this.mo52327U(j);
            this.bad = this.bab[C17675v.m27553a(this.bab, U, true)];
            AppMethodBeat.m2505o(95027);
            return U;
        }

        /* renamed from: rk */
        public final C37247l mo2553rk() {
            return this;
        }

        /* renamed from: qX */
        public final boolean mo2552qX() {
            return true;
        }

        /* renamed from: M */
        public final long mo2548M(long j) {
            AppMethodBeat.m2504i(95028);
            int a = C17675v.m27553a(this.bab, C25520b.this.mo52327U(j), true);
            long j2 = this.bac[a] + this.firstFrameOffset;
            AppMethodBeat.m2505o(95028);
            return j2;
        }

        public final long getDurationUs() {
            C0872f c0872f = C25520b.this.aZZ;
            return (c0872f.brj * 1000000) / ((long) c0872f.sampleRate);
        }
    }

    C25520b() {
    }

    /* renamed from: r */
    public static boolean m40325r(C32065l c32065l) {
        AppMethodBeat.m2504i(95029);
        if (c32065l.mo52382tB() >= 5 && c32065l.readUnsignedByte() == C31128d.MIC_SketchMark && c32065l.mo52366cM() == 1179402563) {
            AppMethodBeat.m2505o(95029);
            return true;
        }
        AppMethodBeat.m2505o(95029);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        AppMethodBeat.m2504i(95030);
        super.reset(z);
        if (z) {
            this.aZZ = null;
            this.baa = null;
        }
        AppMethodBeat.m2505o(95030);
    }

    /* renamed from: p */
    private static boolean m40324p(byte[] bArr) {
        return bArr[0] == (byte) -1;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079 A:{LOOP_START, PHI: r0 r2 , LOOP:1: B:22:0x0079->B:21:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: s */
    public final long mo32323s(C32065l c32065l) {
        int i = 1;
        AppMethodBeat.m2504i(95031);
        if (C25520b.m40324p(c32065l.data)) {
            int i2 = (c32065l.data[2] & 255) >> 4;
            switch (i2) {
                case 1:
                    i = C33250az.CTRL_INDEX;
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
                    c32065l.mo52369eM(4);
                    long j = (long) c32065l.data[c32065l.position];
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
                                    byte b = c32065l.data[c32065l.position + i];
                                    if ((b & C33250az.CTRL_INDEX) != 128) {
                                        numberFormatException = new NumberFormatException("Invalid UTF-8 sequence continuation byte: ".concat(String.valueOf(j)));
                                        AppMethodBeat.m2505o(95031);
                                        throw numberFormatException;
                                    }
                                    j = (j << 6) | ((long) (b & 63));
                                    i++;
                                }
                                c32065l.position += i3;
                                i = i2 == 6 ? c32065l.readUnsignedByte() : c32065l.readUnsignedShort();
                                c32065l.setPosition(0);
                                i++;
                                break;
                            }
                            numberFormatException = new NumberFormatException("Invalid UTF-8 sequence first byte: ".concat(String.valueOf(j)));
                            AppMethodBeat.m2505o(95031);
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
            AppMethodBeat.m2505o(95031);
            return j2;
        }
        AppMethodBeat.m2505o(95031);
        return -1;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo32321a(C32065l c32065l, long j, C32032a c32032a) {
        int i = 0;
        AppMethodBeat.m2504i(95032);
        byte[] bArr = c32065l.data;
        if (this.aZZ == null) {
            this.aZZ = new C0872f(bArr);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, c32065l.limit);
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            C0872f c0872f = this.aZZ;
            c32032a.aOv = Format.m15271a(null, "audio/flac", -1, c0872f.sampleRate * c0872f.bdU, this.aZZ.channels, this.aZZ.sampleRate, singletonList, null, null);
        } else if ((bArr[0] & C31128d.MIC_SketchMark) == 3) {
            this.baa = new C0843a();
            C0843a c0843a = this.baa;
            c32065l.mo52369eM(1);
            int tD = c32065l.mo52384tD() / 18;
            c0843a.bab = new long[tD];
            c0843a.bac = new long[tD];
            while (i < tD) {
                c0843a.bab[i] = c32065l.readLong();
                c0843a.bac[i] = c32065l.readLong();
                c32065l.mo52369eM(2);
                i++;
            }
        } else if (C25520b.m40324p(bArr)) {
            if (this.baa != null) {
                this.baa.firstFrameOffset = j;
                c32032a.bax = this.baa;
            }
            AppMethodBeat.m2505o(95032);
            return false;
        }
        AppMethodBeat.m2505o(95032);
        return true;
    }
}
