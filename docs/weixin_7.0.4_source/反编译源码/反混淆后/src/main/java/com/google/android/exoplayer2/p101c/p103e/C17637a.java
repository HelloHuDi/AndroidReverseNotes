package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.c.e.a */
final class C17637a implements C37237f {
    final long aXw;
    private final C32030e aZP = new C32030e();
    final long aZQ;
    final C32031h aZR;
    long aZS;
    private long aZT;
    private long aZU;
    private long aZV;
    private long aZW;
    private long aZX;
    private long start;
    private int state;

    /* renamed from: com.google.android.exoplayer2.c.e.a$a */
    class C8653a implements C37247l {
        private C8653a() {
        }

        /* synthetic */ C8653a(C17637a c17637a, byte b) {
            this();
        }

        /* renamed from: qX */
        public final boolean mo2552qX() {
            return true;
        }

        /* renamed from: M */
        public final long mo2548M(long j) {
            AppMethodBeat.m2504i(95019);
            long j2;
            if (j == 0) {
                j2 = C17637a.this.aZQ;
                AppMethodBeat.m2505o(95019);
                return j2;
            }
            j2 = C17637a.this.aZR.mo52327U(j);
            C17637a c17637a = C17637a.this;
            j2 = (((j2 * (c17637a.aXw - c17637a.aZQ)) / c17637a.aZS) - 30000) + C17637a.this.aZQ;
            if (j2 < c17637a.aZQ) {
                j2 = c17637a.aZQ;
            }
            if (j2 >= c17637a.aXw) {
                j2 = c17637a.aXw - 1;
            }
            AppMethodBeat.m2505o(95019);
            return j2;
        }

        public final long getDurationUs() {
            AppMethodBeat.m2504i(95020);
            long T = C17637a.this.aZR.mo52326T(C17637a.this.aZS);
            AppMethodBeat.m2505o(95020);
            return T;
        }
    }

    public C17637a(long j, long j2, C32031h c32031h, int i, long j3) {
        AppMethodBeat.m2504i(95021);
        boolean z = j >= 0 && j2 > j;
        C45039a.checkArgument(z);
        this.aZR = c32031h;
        this.aZQ = j;
        this.aXw = j2;
        if (((long) i) == j2 - j) {
            this.aZS = j3;
            this.state = 3;
            AppMethodBeat.m2505o(95021);
            return;
        }
        this.state = 0;
        AppMethodBeat.m2505o(95021);
    }

    /* renamed from: i */
    public final long mo2551i(C45026f c45026f) {
        long j;
        int i = 1;
        AppMethodBeat.m2504i(95022);
        switch (this.state) {
            case 0:
                this.aZT = c45026f.getPosition();
                this.state = 1;
                j = this.aXw - 65307;
                if (j > this.aZT) {
                    AppMethodBeat.m2505o(95022);
                    return j;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.aZU == 0) {
                    j = 0;
                } else {
                    long j2 = this.aZU;
                    if (this.start == this.aZV) {
                        j = -(this.aZW + 2);
                    } else {
                        long position = c45026f.getPosition();
                        if (m27465a(c45026f, this.aZV)) {
                            this.aZP.mo52324c(c45026f, false);
                            c45026f.mo59486qY();
                            j2 -= this.aZP.bam;
                            int i2 = this.aZP.aVG + this.aZP.bar;
                            if (j2 < 0 || j2 > 72000) {
                                if (j2 < 0) {
                                    this.aZV = position;
                                    this.aZX = this.aZP.bam;
                                } else {
                                    this.start = c45026f.getPosition() + ((long) i2);
                                    this.aZW = this.aZP.bam;
                                    if ((this.aZV - this.start) + ((long) i2) < 100000) {
                                        c45026f.mo59482dG(i2);
                                        j = -(this.aZW + 2);
                                    }
                                }
                                if (this.aZV - this.start < 100000) {
                                    this.aZV = this.start;
                                    j = this.start;
                                } else {
                                    if (j2 <= 0) {
                                        i = 2;
                                    }
                                    j = Math.min(Math.max((c45026f.getPosition() - ((long) (i * i2))) + ((j2 * (this.aZV - this.start)) / (this.aZX - this.aZW)), this.start), this.aZV - 1);
                                }
                            } else {
                                c45026f.mo59482dG(i2);
                                j = -(this.aZP.bam + 2);
                            }
                        } else if (this.start == position) {
                            IOException iOException = new IOException("No ogg page can be found.");
                            AppMethodBeat.m2505o(95022);
                            throw iOException;
                        } else {
                            j = this.start;
                        }
                    }
                    if (j >= 0) {
                        AppMethodBeat.m2505o(95022);
                        return j;
                    }
                    j2 = -(j + 2);
                    j = m27464a(c45026f, this.aZU, j2);
                }
                this.state = 3;
                j = -(j + 2);
                AppMethodBeat.m2505o(95022);
                return j;
            case 3:
                AppMethodBeat.m2505o(95022);
                return -1;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(95022);
                throw illegalStateException;
        }
        if (m27465a(c45026f, this.aXw)) {
            this.aZP.reset();
            while ((this.aZP.type & 4) != 4 && c45026f.getPosition() < this.aXw) {
                this.aZP.mo52324c(c45026f, false);
                c45026f.mo59482dG(this.aZP.aVG + this.aZP.bar);
            }
            this.aZS = this.aZP.bam;
            this.state = 3;
            j = this.aZT;
            AppMethodBeat.m2505o(95022);
            return j;
        }
        EOFException eOFException = new EOFException();
        AppMethodBeat.m2505o(95022);
        throw eOFException;
    }

    /* renamed from: S */
    public final long mo2549S(long j) {
        AppMethodBeat.m2504i(95023);
        boolean z = this.state == 3 || this.state == 2;
        C45039a.checkArgument(z);
        this.aZU = j == 0 ? 0 : this.aZR.mo52327U(j);
        this.state = 2;
        this.start = this.aZQ;
        this.aZV = this.aXw;
        this.aZW = 0;
        this.aZX = this.aZS;
        long j2 = this.aZU;
        AppMethodBeat.m2505o(95023);
        return j2;
    }

    /* renamed from: a */
    private boolean m27465a(C45026f c45026f, long j) {
        int i = 2048;
        AppMethodBeat.m2504i(95024);
        long min = Math.min(3 + j, this.aXw);
        byte[] bArr = new byte[2048];
        while (true) {
            if (c45026f.getPosition() + ((long) i) > min) {
                i = (int) (min - c45026f.getPosition());
                if (i < 4) {
                    AppMethodBeat.m2505o(95024);
                    return false;
                }
            }
            c45026f.mo59480b(bArr, 0, i, false);
            int i2 = 0;
            while (i2 < i - 3) {
                if (bArr[i2] == (byte) 79 && bArr[i2 + 1] == (byte) 103 && bArr[i2 + 2] == (byte) 103 && bArr[i2 + 3] == (byte) 83) {
                    c45026f.mo59482dG(i2);
                    AppMethodBeat.m2505o(95024);
                    return true;
                }
                i2++;
            }
            c45026f.mo59482dG(i - 3);
        }
    }

    /* renamed from: a */
    private long m27464a(C45026f c45026f, long j, long j2) {
        AppMethodBeat.m2504i(95025);
        this.aZP.mo52324c(c45026f, false);
        while (this.aZP.bam < j) {
            c45026f.mo59482dG(this.aZP.aVG + this.aZP.bar);
            j2 = this.aZP.bam;
            this.aZP.mo52324c(c45026f, false);
        }
        c45026f.mo59486qY();
        AppMethodBeat.m2505o(95025);
        return j2;
    }

    /* renamed from: rk */
    public final /* synthetic */ C37247l mo2553rk() {
        AppMethodBeat.m2504i(95026);
        if (this.aZS != 0) {
            C8653a c8653a = new C8653a(this, (byte) 0);
            AppMethodBeat.m2505o(95026);
            return c8653a;
        }
        AppMethodBeat.m2505o(95026);
        return null;
    }
}
