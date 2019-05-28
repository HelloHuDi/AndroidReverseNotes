package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

final class a implements f {
    final long aXw;
    private final e aZP = new e();
    final long aZQ;
    final h aZR;
    long aZS;
    private long aZT;
    private long aZU;
    private long aZV;
    private long aZW;
    private long aZX;
    private long start;
    private int state;

    class a implements l {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final boolean qX() {
            return true;
        }

        public final long M(long j) {
            AppMethodBeat.i(95019);
            long j2;
            if (j == 0) {
                j2 = a.this.aZQ;
                AppMethodBeat.o(95019);
                return j2;
            }
            j2 = a.this.aZR.U(j);
            a aVar = a.this;
            j2 = (((j2 * (aVar.aXw - aVar.aZQ)) / aVar.aZS) - 30000) + a.this.aZQ;
            if (j2 < aVar.aZQ) {
                j2 = aVar.aZQ;
            }
            if (j2 >= aVar.aXw) {
                j2 = aVar.aXw - 1;
            }
            AppMethodBeat.o(95019);
            return j2;
        }

        public final long getDurationUs() {
            AppMethodBeat.i(95020);
            long T = a.this.aZR.T(a.this.aZS);
            AppMethodBeat.o(95020);
            return T;
        }
    }

    public a(long j, long j2, h hVar, int i, long j3) {
        AppMethodBeat.i(95021);
        boolean z = j >= 0 && j2 > j;
        com.google.android.exoplayer2.i.a.checkArgument(z);
        this.aZR = hVar;
        this.aZQ = j;
        this.aXw = j2;
        if (((long) i) == j2 - j) {
            this.aZS = j3;
            this.state = 3;
            AppMethodBeat.o(95021);
            return;
        }
        this.state = 0;
        AppMethodBeat.o(95021);
    }

    public final long i(f fVar) {
        long j;
        int i = 1;
        AppMethodBeat.i(95022);
        switch (this.state) {
            case 0:
                this.aZT = fVar.getPosition();
                this.state = 1;
                j = this.aXw - 65307;
                if (j > this.aZT) {
                    AppMethodBeat.o(95022);
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
                        long position = fVar.getPosition();
                        if (a(fVar, this.aZV)) {
                            this.aZP.c(fVar, false);
                            fVar.qY();
                            j2 -= this.aZP.bam;
                            int i2 = this.aZP.aVG + this.aZP.bar;
                            if (j2 < 0 || j2 > 72000) {
                                if (j2 < 0) {
                                    this.aZV = position;
                                    this.aZX = this.aZP.bam;
                                } else {
                                    this.start = fVar.getPosition() + ((long) i2);
                                    this.aZW = this.aZP.bam;
                                    if ((this.aZV - this.start) + ((long) i2) < 100000) {
                                        fVar.dG(i2);
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
                                    j = Math.min(Math.max((fVar.getPosition() - ((long) (i * i2))) + ((j2 * (this.aZV - this.start)) / (this.aZX - this.aZW)), this.start), this.aZV - 1);
                                }
                            } else {
                                fVar.dG(i2);
                                j = -(this.aZP.bam + 2);
                            }
                        } else if (this.start == position) {
                            IOException iOException = new IOException("No ogg page can be found.");
                            AppMethodBeat.o(95022);
                            throw iOException;
                        } else {
                            j = this.start;
                        }
                    }
                    if (j >= 0) {
                        AppMethodBeat.o(95022);
                        return j;
                    }
                    j2 = -(j + 2);
                    j = a(fVar, this.aZU, j2);
                }
                this.state = 3;
                j = -(j + 2);
                AppMethodBeat.o(95022);
                return j;
            case 3:
                AppMethodBeat.o(95022);
                return -1;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(95022);
                throw illegalStateException;
        }
        if (a(fVar, this.aXw)) {
            this.aZP.reset();
            while ((this.aZP.type & 4) != 4 && fVar.getPosition() < this.aXw) {
                this.aZP.c(fVar, false);
                fVar.dG(this.aZP.aVG + this.aZP.bar);
            }
            this.aZS = this.aZP.bam;
            this.state = 3;
            j = this.aZT;
            AppMethodBeat.o(95022);
            return j;
        }
        EOFException eOFException = new EOFException();
        AppMethodBeat.o(95022);
        throw eOFException;
    }

    public final long S(long j) {
        AppMethodBeat.i(95023);
        boolean z = this.state == 3 || this.state == 2;
        com.google.android.exoplayer2.i.a.checkArgument(z);
        this.aZU = j == 0 ? 0 : this.aZR.U(j);
        this.state = 2;
        this.start = this.aZQ;
        this.aZV = this.aXw;
        this.aZW = 0;
        this.aZX = this.aZS;
        long j2 = this.aZU;
        AppMethodBeat.o(95023);
        return j2;
    }

    private boolean a(f fVar, long j) {
        int i = 2048;
        AppMethodBeat.i(95024);
        long min = Math.min(3 + j, this.aXw);
        byte[] bArr = new byte[2048];
        while (true) {
            if (fVar.getPosition() + ((long) i) > min) {
                i = (int) (min - fVar.getPosition());
                if (i < 4) {
                    AppMethodBeat.o(95024);
                    return false;
                }
            }
            fVar.b(bArr, 0, i, false);
            int i2 = 0;
            while (i2 < i - 3) {
                if (bArr[i2] == (byte) 79 && bArr[i2 + 1] == (byte) 103 && bArr[i2 + 2] == (byte) 103 && bArr[i2 + 3] == (byte) 83) {
                    fVar.dG(i2);
                    AppMethodBeat.o(95024);
                    return true;
                }
                i2++;
            }
            fVar.dG(i - 3);
        }
    }

    private long a(f fVar, long j, long j2) {
        AppMethodBeat.i(95025);
        this.aZP.c(fVar, false);
        while (this.aZP.bam < j) {
            fVar.dG(this.aZP.aVG + this.aZP.bar);
            j2 = this.aZP.bam;
            this.aZP.c(fVar, false);
        }
        fVar.qY();
        AppMethodBeat.o(95025);
        return j2;
    }

    public final /* synthetic */ l rk() {
        AppMethodBeat.i(95026);
        if (this.aZS != 0) {
            a aVar = new a(this, (byte) 0);
            AppMethodBeat.o(95026);
            return aVar;
        }
        AppMethodBeat.o(95026);
        return null;
    }
}
