package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

final class j {
    private double[] bDC = new double[4];
    final b bDD = new b();
    private final b bDE = new b();

    protected static class a {
        double bDF;
        double bDG;
        double bDH;
        double[] bDI = new double[2];
        double bDJ;
        double bDK;
        int bDL;
        double bDM;
        double bDN;
        int bDO;
        double bDP;
        double bDQ;
        double bDR;
        int mType;

        protected a(int i, double d, double d2, double d3, double d4, double d5, int i2, double d6, int i3, double d7, double d8) {
            AppMethodBeat.i(55616);
            this.mType = i;
            this.bDF = d;
            this.bDG = d2;
            this.bDH = d3;
            this.bDJ = d4;
            this.bDK = d5;
            this.bDL = i2;
            this.bDM = d6;
            this.bDN = 0.0d;
            this.bDO = i3;
            this.bDP = 0.0d;
            this.bDQ = d7;
            this.bDR = d8;
            AppMethodBeat.o(55616);
        }

        public final String toString() {
            AppMethodBeat.i(55617);
            String stringBuilder = new StringBuilder(String.valueOf(String.valueOf(this.mType))).append(',').append(this.bDF).append(',').append(this.bDG).append(',').append(this.bDH).append(',').append(this.bDJ).append(',').append(this.bDK).append(',').append(this.bDL).append(',').append(this.bDM).append(',').append(this.bDN).append(',').append(this.bDO).append(',').append(this.bDQ).append(',').append(this.bDR).toString();
            AppMethodBeat.o(55617);
            return stringBuilder;
        }
    }

    static class b {
        double bDF;
        double bDS;
        boolean bDT;
        double[] bDU;
        double bDV;
        boolean bDW;
        double[] bDX;
        double bDY;
        int bDZ;
        double[] bEA;
        boolean bEB;
        int bEa;
        boolean bEb;
        boolean bEc;
        double bEd;
        double bEe;
        double bEf;
        double bEg;
        double bEh;
        double bEi;
        double bEj;
        double[] bEk;
        private boolean bEl;
        boolean bEm;
        boolean bEn;
        double[] bEo;
        double[][] bEp;
        double bEq;
        double bEr;
        double bEs;
        boolean bEt;
        double bEu;
        double bEv;
        int bEw;
        int bEx;
        double bEy;
        double[] bEz;

        private b() {
            AppMethodBeat.i(55618);
            this.bDU = new double[2];
            this.bDX = new double[2];
            this.bEk = new double[2];
            this.bEo = new double[4];
            this.bEp = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
            this.bEz = new double[2];
            this.bEA = new double[2];
            AppMethodBeat.o(55618);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        static /* synthetic */ void a(b bVar, b bVar2) {
            AppMethodBeat.i(55620);
            bVar.a(bVar2);
            AppMethodBeat.o(55620);
        }

        private void a(b bVar) {
            AppMethodBeat.i(55619);
            this.bDS = bVar.bDS;
            this.bDT = bVar.bDT;
            this.bDU = (double[]) bVar.bDU.clone();
            this.bDV = bVar.bDV;
            this.bDW = bVar.bDW;
            this.bDX = (double[]) bVar.bDX.clone();
            this.bDY = bVar.bDY;
            this.bDZ = bVar.bDZ;
            this.bEa = bVar.bEa;
            this.bEb = bVar.bEb;
            this.bEc = bVar.bEc;
            this.bEd = bVar.bEd;
            this.bEe = bVar.bEe;
            this.bEf = bVar.bEf;
            this.bEg = bVar.bEg;
            this.bEh = bVar.bEh;
            this.bEi = bVar.bEi;
            this.bEj = bVar.bEj;
            this.bEk = (double[]) bVar.bEk.clone();
            this.bEl = bVar.bEl;
            this.bEm = bVar.bEm;
            this.bEn = bVar.bEn;
            this.bDF = bVar.bDF;
            this.bEo = (double[]) bVar.bEo.clone();
            this.bEp[0] = (double[]) bVar.bEp[0].clone();
            this.bEp[1] = (double[]) bVar.bEp[1].clone();
            this.bEp[2] = (double[]) bVar.bEp[2].clone();
            this.bEp[3] = (double[]) bVar.bEp[3].clone();
            this.bEq = bVar.bEq;
            this.bEr = bVar.bEr;
            this.bEs = bVar.bEs;
            this.bEt = bVar.bEt;
            this.bEu = bVar.bEu;
            this.bEv = bVar.bEv;
            this.bEw = bVar.bEw;
            this.bEx = bVar.bEx;
            this.bEy = bVar.bEy;
            this.bEz = (double[]) bVar.bEz.clone();
            this.bEA = (double[]) bVar.bEA.clone();
            this.bEB = bVar.bEB;
            AppMethodBeat.o(55619);
        }
    }

    j() {
        AppMethodBeat.i(55621);
        AppMethodBeat.o(55621);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(long j, double d, double d2, float f, boolean z, boolean z2) {
        int i;
        AppMethodBeat.i(55622);
        double d3 = (double) j;
        double[] dArr = new double[]{d, d2};
        double d4 = (double) (f * f);
        double[] dArr2 = new double[]{0.0d, 0.0d};
        if (z) {
            i = 3;
        } else {
            i = 5;
        }
        double[] dArr3 = new double[]{d, d2};
        this.bDD.bEt = true;
        this.bDD.bEA[0] = 3.0d;
        this.bDD.bEA[1] = 1.2d;
        this.bDD.bEy = 0.5d;
        this.bDD.bDS = 1.2d;
        this.bDD.bDY = 4.0d;
        this.bDD.bDZ = 0;
        this.bDD.bEb = true;
        this.bDD.bEa = i;
        this.bDD.bDT = false;
        this.bDD.bDW = false;
        this.bDD.bEh = 40.0d;
        this.bDD.bEi = 0.15707963267948966d;
        this.bDD.bEj = 1.0d;
        this.bDD.bEz[0] = 400.0d;
        this.bDD.bEz[1] = 1.0d;
        this.bDD.bEm = z2;
        this.bDD.bEn = false;
        this.bDD.bEc = true;
        this.bDD.bEd = 0.3333333333333333d;
        this.bDD.bEe = 5.0d;
        this.bDD.bEf = 0.5d;
        this.bDD.bEg = 1.0d;
        this.bDD.bEu = 0.5d;
        this.bDD.bEv = 1.0d;
        this.bDD.bEw = 0;
        this.bDD.bEx = 2;
        this.bDD.bEB = false;
        this.bDD.bEk[0] = dArr3[0];
        this.bDD.bEk[1] = dArr3[1];
        double[] dArr4 = new double[2];
        a(0, dArr, dArr4);
        this.bDD.bDF = d3;
        this.bDD.bEo[0] = dArr4[0];
        this.bDD.bEo[1] = dArr4[1];
        this.bDD.bEo[2] = dArr2[0];
        this.bDD.bEo[3] = dArr2[1];
        this.bDD.bEq = 0.0d;
        this.bDD.bEr = 1.0d;
        this.bDD.bEs = 1.005d;
        this.bDD.bEp[0][0] = d4;
        this.bDD.bEp[0][1] = 0.0d;
        this.bDD.bEp[0][2] = 0.0d;
        this.bDD.bEp[0][3] = 0.0d;
        this.bDD.bEp[1][0] = 0.0d;
        this.bDD.bEp[1][1] = d4;
        this.bDD.bEp[1][2] = 0.0d;
        this.bDD.bEp[1][3] = 0.0d;
        this.bDD.bEp[2][0] = 0.0d;
        this.bDD.bEp[2][1] = 0.0d;
        this.bDD.bEp[2][2] = 1.0d;
        this.bDD.bEp[2][3] = 0.0d;
        this.bDD.bEp[3][0] = 0.0d;
        this.bDD.bEp[3][1] = 0.0d;
        this.bDD.bEp[3][2] = 0.0d;
        this.bDD.bEp[3][3] = 1.0d;
        aW(z);
        AppMethodBeat.o(55622);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aW(boolean z) {
        AppMethodBeat.i(55623);
        aX(!z);
        AppMethodBeat.o(55623);
    }

    private void aX(boolean z) {
        AppMethodBeat.i(55624);
        if (this.bDD.bEt != z) {
            this.bDD.bEt = z;
            if (z) {
                this.bDD.bDS = this.bDD.bEA[1];
                this.bDD.bEj = this.bDD.bEz[1];
                b(this.bDD.bDF, true);
                AppMethodBeat.o(55624);
                return;
            }
            this.bDD.bDS = this.bDD.bEA[0];
            this.bDD.bEj = this.bDD.bEz[0];
            b(this.bDD.bDF, true);
        }
        AppMethodBeat.o(55624);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        AppMethodBeat.i(55625);
        if (aVar.bDK <= 0.0d) {
            AppMethodBeat.o(55625);
            return;
        }
        double d;
        if (this.bDD.bDT) {
            d = aVar.bDF - this.bDD.bDV;
            if (d < -10.0d) {
                AppMethodBeat.o(55625);
                return;
            } else if (d <= 0.0d) {
                aVar.bDF = this.bDD.bDV + 0.5d;
            }
        }
        r12 = new double[2];
        a(0, new double[]{aVar.bDG, aVar.bDH}, r12);
        aVar.bDI[0] = r12[0];
        aVar.bDI[1] = r12[1];
        double[][] dArr;
        double[] dArr2;
        double d2;
        double sqrt;
        double d3;
        Object obj;
        int i;
        if (this.bDD.bEt) {
            if (aVar.mType != 3 || this.bDD.bDT) {
                double d4;
                double d5;
                double[] dArr3;
                if (aVar.mType == 3) {
                    d4 = aVar.bDF - this.bDD.bDV;
                    if (d4 > 0.0d) {
                        dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                        dArr2 = new double[2];
                        d5 = r12[0] - this.bDD.bDU[0];
                        d2 = r12[1] - this.bDD.bDU[1];
                        if (this.bDD.bEm) {
                            d5 = (d5 * Math.cos(this.bDD.bEq)) - (Math.sin(this.bDD.bEq) * d2);
                            d2 = (d2 * Math.cos(this.bDD.bEq)) + (Math.sin(this.bDD.bEq) * d5);
                        }
                        sqrt = Math.sqrt((d5 * d5) + (d2 * d2));
                        d3 = sqrt / this.bDD.bEh;
                        d3 *= d3;
                        if (d3 <= 0.0625d) {
                            d3 = 0.0625d;
                        }
                        sqrt *= this.bDD.bEi;
                        sqrt *= sqrt;
                        if (sqrt <= 0.0625d) {
                            sqrt = 0.0625d;
                        }
                        d3 = (d3 + sqrt) / d4;
                        a(new double[]{this.bDD.bEp[2][2], this.bDD.bEp[2][3], this.bDD.bEp[3][2], this.bDD.bEp[3][3]}, this.bDC);
                        dArr[0][0] = this.bDC[0];
                        dArr[0][1] = this.bDC[1];
                        dArr[1][0] = this.bDC[2];
                        dArr[1][1] = this.bDC[3];
                        sqrt = (d5 / d4) - this.bDD.bEo[2];
                        double d6 = (d2 / d4) - this.bDD.bEo[3];
                        if (Math.sqrt((((sqrt * d6) * dArr[1][0]) + (((sqrt * sqrt) * dArr[0][0]) + ((sqrt * d6) * dArr[0][1]))) + ((d6 * d6) * dArr[1][1])) > 2.0d) {
                            this.bDD.bEp[2][2] = this.bDD.bEj;
                            this.bDD.bEp[2][3] = 0.0d;
                            this.bDD.bEp[3][2] = 0.0d;
                            this.bDD.bEp[3][3] = this.bDD.bEj;
                            dArr[0][0] = 1.0d / this.bDD.bEj;
                            dArr[0][1] = 0.0d;
                            dArr[1][0] = 0.0d;
                            dArr[1][1] = 1.0d / this.bDD.bEj;
                        }
                        dArr2[0] = (dArr[0][0] * this.bDD.bEo[2]) + (dArr[0][1] * this.bDD.bEo[3]);
                        dArr2[1] = (dArr[1][0] * this.bDD.bEo[2]) + (dArr[1][1] * this.bDD.bEo[3]);
                        dArr3 = dArr[0];
                        dArr3[0] = dArr3[0] + (1.0d / d3);
                        dArr3 = dArr[1];
                        dArr3[1] = dArr3[1] + (1.0d / d3);
                        dArr2[0] = (d5 / (d4 * d3)) + dArr2[0];
                        dArr2[1] = (d2 / (d3 * d4)) + dArr2[1];
                        a(new double[]{dArr[0][0], dArr[0][1], dArr[1][0], dArr[1][1]}, this.bDC);
                        this.bDD.bEp[2][2] = this.bDC[0];
                        this.bDD.bEp[2][3] = this.bDC[1];
                        this.bDD.bEp[3][2] = this.bDC[2];
                        this.bDD.bEp[3][3] = this.bDC[3];
                        this.bDD.bEo[2] = (this.bDD.bEp[2][2] * dArr2[0]) + (this.bDD.bEp[2][3] * dArr2[1]);
                        this.bDD.bEo[3] = (this.bDD.bEp[3][2] * dArr2[0]) + (this.bDD.bEp[3][3] * dArr2[1]);
                        b(aVar.bDF, false);
                    }
                } else {
                    d3 = 0.0d;
                    d5 = 0.0d;
                    dArr3 = new double[2];
                    double[] dArr4 = new double[2];
                    b(aVar.bDF, false);
                    if (this.bDD.bEc) {
                        Object i2;
                        if (this.bDD.bDW) {
                            dArr3[0] = this.bDD.bEo[0] - this.bDD.bDX[0];
                            dArr3[1] = this.bDD.bEo[1] - this.bDD.bDX[1];
                            dArr4[0] = r12[0] - this.bDD.bDX[0];
                            dArr4[1] = r12[1] - this.bDD.bDX[1];
                            d5 = Math.sqrt((dArr3[0] * dArr3[0]) + (dArr3[1] * dArr3[1]));
                            d3 = Math.sqrt((dArr4[0] * dArr4[0]) + (dArr4[1] * dArr4[1]));
                            if (d3 > this.bDD.bEe && d5 > this.bDD.bEe) {
                                d2 = d3 / d5;
                                d = d3 - d5;
                                d4 = Math.sqrt(this.bDD.bEp[0][0] + this.bDD.bEp[1][1]);
                                if (d5 > 3.0d * this.bDD.bEe) {
                                    if (d < 0.0d) {
                                        d = -d;
                                    }
                                    d2 = d / d4;
                                    d = Math.atan2(dArr4[1], dArr4[0]) - Math.atan2(dArr3[1], dArr3[0]);
                                    if (d > 3.141592653589793d) {
                                        d -= 6.283185307179586d;
                                    } else if (d < -3.141592653589793d) {
                                        d += 6.283185307179586d;
                                    }
                                    if (d < 0.0d) {
                                        d = -d;
                                    }
                                    d /= Math.sqrt(this.bDD.bEr);
                                    d = Math.sqrt((d * d) + (d2 * d2));
                                    if (d < this.bDD.bDY) {
                                        this.bDD.bEw = 0;
                                    } else if (d2 < this.bDD.bDY) {
                                        b bVar = this.bDD;
                                        int i3 = bVar.bEw + 1;
                                        bVar.bEw = i3;
                                        if (i3 >= this.bDD.bEx) {
                                            this.bDD.bEw = 0;
                                            d = d2;
                                        }
                                    }
                                    if (d > this.bDD.bDY) {
                                        obj = null;
                                        i2 = null;
                                    } else {
                                        obj = 1;
                                        i2 = 1;
                                    }
                                } else if (d2 < this.bDD.bEd || 1.0d / d2 < this.bDD.bEd) {
                                    obj = null;
                                    i2 = null;
                                } else {
                                    obj = 1;
                                    i2 = null;
                                }
                            } else if ((d3 >= this.bDD.bEe || aVar.mType != 2) && (d3 >= this.bDD.bEe * 0.5d || aVar.mType != 1)) {
                                obj = 1;
                                i2 = null;
                            } else {
                                obj = null;
                                i2 = null;
                            }
                        } else {
                            obj = 1;
                            i2 = 1;
                        }
                        if (obj != null) {
                            if (this.bDD.bDW) {
                                if (d3 < d5) {
                                    d = this.bDD.bEf;
                                } else {
                                    d = this.bDD.bEg;
                                }
                                d += (d5 / d3) * (1.0d - d);
                                r12[0] = this.bDD.bDX[0] + (dArr4[0] * d);
                                r12[1] = (d * dArr4[1]) + this.bDD.bDX[1];
                            }
                            if (i2 != null) {
                                b(r12);
                            } else {
                                this.bDD.bDX[0] = r12[0];
                                this.bDD.bDX[1] = r12[1];
                            }
                            this.bDD.bEo[0] = r12[0];
                            this.bDD.bEo[1] = r12[1];
                            this.bDD.bEp[0][0] = aVar.bDK * aVar.bDK;
                            this.bDD.bEp[0][1] = 0.0d;
                            this.bDD.bEp[1][0] = 0.0d;
                            this.bDD.bEp[1][1] = aVar.bDK * aVar.bDK;
                        }
                    } else {
                        b.a(this.bDE, this.bDD);
                        c(aVar.bDF, false);
                        if (!this.bDE.bEb) {
                            d2 = r12[0] - this.bDE.bEo[0];
                            d5 = r12[1] - this.bDE.bEo[1];
                            dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                            d3 = 1.0d / ((this.bDE.bEp[0][0] * this.bDE.bEp[1][1]) - (this.bDE.bEp[0][1] * this.bDE.bEp[1][0]));
                            dArr[0][0] = this.bDE.bEp[1][1] * d3;
                            dArr[1][1] = this.bDE.bEp[0][0] * d3;
                            dArr[0][1] = (-this.bDE.bEp[0][1]) * d3;
                            dArr[1][0] = d3 * (-this.bDE.bEp[1][0]);
                            d = Math.sqrt((dArr[1][1] * (d5 * d5)) + ((((d2 * 2.0d) * d5) * dArr[1][0]) + ((d2 * d2) * dArr[0][0])));
                        } else if (this.bDD.bDW) {
                            d = this.bDD.bDX[0] - this.bDE.bEo[0];
                            d2 = this.bDD.bDX[1] - this.bDE.bEo[1];
                            d5 = this.bDD.bDX[0] - r12[0];
                            d3 = this.bDD.bDX[1] - r12[1];
                            d = Math.sqrt((d * d) + (d2 * d2)) - Math.sqrt((d5 * d5) + (d3 * d3));
                            d = Math.abs(d) / Math.sqrt((this.bDD.bEp[0][0] * this.bDD.bEp[0][0]) + (this.bDD.bEp[1][1] * this.bDD.bEp[1][1]));
                        } else {
                            d = 0.0d;
                        }
                        if (d > this.bDD.bDY) {
                            b.a(this.bDE, this.bDD);
                            c(aVar.bDF, true);
                            if (this.bDD.bEb) {
                                d = this.bDD.bDX[0] - this.bDE.bEo[0];
                                d2 = this.bDD.bDX[1] - this.bDE.bEo[1];
                                d5 = this.bDD.bDX[0] - r12[0];
                                d3 = this.bDD.bDX[1] - r12[1];
                                d = Math.sqrt((d * d) + (d2 * d2)) - Math.sqrt((d5 * d5) + (d3 * d3));
                                d = Math.abs(d) / Math.sqrt((this.bDE.bEp[0][0] * this.bDE.bEp[0][0]) + (this.bDE.bEp[1][1] * this.bDE.bEp[1][1]));
                            } else {
                                d2 = r12[0] - this.bDE.bEo[0];
                                d5 = r12[1] - this.bDE.bEo[1];
                                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                                d3 = 1.0d / ((this.bDE.bEp[0][0] * this.bDE.bEp[1][1]) - (this.bDE.bEp[0][1] * this.bDE.bEp[1][0]));
                                dArr[0][0] = this.bDE.bEp[1][1] * d3;
                                dArr[1][1] = this.bDE.bEp[0][0] * d3;
                                dArr[0][1] = (-this.bDE.bEp[0][1]) * d3;
                                dArr[1][0] = d3 * (-this.bDE.bEp[1][0]);
                                d = Math.sqrt((dArr[1][1] * (d5 * d5)) + ((((d2 * 2.0d) * d5) * dArr[1][0]) + ((d2 * d2) * dArr[0][0])));
                            }
                            if (d <= this.bDE.bDY) {
                                b.a(this.bDD, this.bDE);
                                this.bDD.bDZ = 0;
                                b(r12);
                            } else if (this.bDD.bDZ < this.bDD.bEa) {
                                this.bDD.bDZ++;
                            } else {
                                b.a(this.bDD, this.bDE);
                                this.bDD.bDZ = 0;
                            }
                        } else {
                            b.a(this.bDD, this.bDE);
                            this.bDD.bDZ = 0;
                            b(r12);
                        }
                        this.bDD.bEo[0] = r12[0];
                        this.bDD.bEo[1] = r12[1];
                        this.bDD.bEp[0][0] = aVar.bDK * aVar.bDK;
                        this.bDD.bEp[0][1] = 0.0d;
                        this.bDD.bEp[1][0] = 0.0d;
                        this.bDD.bEp[1][1] = aVar.bDK * aVar.bDK;
                    }
                }
            }
            if (aVar.mType == 3) {
                this.bDD.bDU[0] = r12[0];
                this.bDD.bDU[1] = r12[1];
                this.bDD.bDV = aVar.bDF;
                this.bDD.bDT = true;
                AppMethodBeat.o(55625);
                return;
            }
        } else if (aVar.mType != 3) {
            Object obj2;
            obj = null;
            double[] dArr5 = new double[2];
            double[] dArr6 = new double[2];
            double[] dArr7 = new double[2];
            b(aVar.bDF, false);
            if (this.bDD.bDW) {
                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                dArr5[0] = aVar.bDI[0] - this.bDD.bEo[0];
                dArr5[1] = aVar.bDI[1] - this.bDD.bEo[1];
                a(new double[]{this.bDD.bEp[0][0], this.bDD.bEp[0][1], this.bDD.bEp[1][0], this.bDD.bEp[1][1]}, this.bDC);
                dArr[0][0] = this.bDC[0];
                dArr[0][1] = this.bDC[1];
                dArr[1][0] = this.bDC[2];
                dArr[1][1] = this.bDC[3];
                if (Math.sqrt((((dArr5[0] * dArr5[0]) * dArr[0][0]) + (((2.0d * dArr5[0]) * dArr5[1]) * dArr[1][0])) + ((dArr5[1] * dArr5[1]) * dArr[1][1])) > this.bDD.bDY) {
                    b bVar2 = this.bDD;
                    i2 = bVar2.bDZ + 1;
                    bVar2.bDZ = i2;
                    if (i2 >= this.bDD.bEa) {
                        obj2 = 1;
                        obj = null;
                        this.bDD.bDZ = 0;
                    } else {
                        obj2 = null;
                    }
                } else {
                    this.bDD.bDZ = 0;
                    obj2 = 1;
                    obj = 1;
                }
            } else {
                obj2 = 1;
                obj = null;
                this.bDD.bDZ = 0;
            }
            if (obj2 != null) {
                if (obj == null) {
                    this.bDD.bEo[0] = aVar.bDI[0];
                    this.bDD.bEo[1] = aVar.bDI[1];
                    this.bDD.bEo[2] = 0.0d;
                    this.bDD.bEo[3] = 0.0d;
                    this.bDD.bEp[0][0] = aVar.bDK * aVar.bDK;
                    this.bDD.bEp[0][1] = 0.0d;
                    this.bDD.bEp[0][2] = 0.0d;
                    this.bDD.bEp[0][3] = 0.0d;
                    this.bDD.bEp[1][0] = 0.0d;
                    this.bDD.bEp[1][1] = this.bDD.bEp[0][0];
                    this.bDD.bEp[1][2] = 0.0d;
                    this.bDD.bEp[1][2] = 0.0d;
                    this.bDD.bEp[2][0] = 0.0d;
                    this.bDD.bEp[2][1] = 0.0d;
                    this.bDD.bEp[2][2] = this.bDD.bEj;
                    this.bDD.bEp[2][3] = 0.0d;
                    this.bDD.bEp[3][0] = 0.0d;
                    this.bDD.bEp[3][1] = 0.0d;
                    this.bDD.bEp[3][2] = 0.0d;
                    this.bDD.bEp[3][3] = this.bDD.bEj;
                    this.bDD.bDX[0] = aVar.bDI[0];
                    this.bDD.bDX[1] = aVar.bDI[1];
                    this.bDD.bDW = true;
                    AppMethodBeat.o(55625);
                    return;
                }
                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
                double[] dArr8 = new double[]{this.bDD.bEo[0] - this.bDD.bDX[0], this.bDD.bEo[1] - this.bDD.bDX[1]};
                dArr7[0] = aVar.bDI[0] - this.bDD.bDX[0];
                dArr7[1] = aVar.bDI[1] - this.bDD.bDX[1];
                d3 = Math.sqrt((dArr7[0] * dArr7[0]) + (dArr7[1] * dArr7[1]));
                sqrt = Math.sqrt((dArr6[1] * dArr6[1]) + (dArr6[0] * dArr6[0]));
                if (d3 < sqrt) {
                    d2 = this.bDD.bEu;
                } else {
                    d2 = this.bDD.bEv;
                }
                if (a(this.bDD.bEp, dArr)) {
                    double d7 = 1.0d / (aVar.bDK * aVar.bDK);
                    double[] dArr9 = new double[4];
                    if (this.bDD.bEB) {
                        d2 += (sqrt / d3) * (1.0d - d2);
                        dArr8[0] = this.bDD.bDX[0] + (dArr7[0] * d2);
                        dArr8[1] = (d2 * dArr7[1]) + this.bDD.bDX[1];
                    } else {
                        dArr8[0] = (this.bDD.bEo[0] * (1.0d - d2)) + (aVar.bDI[0] * d2);
                        dArr8[1] = (d2 * aVar.bDI[1]) + (this.bDD.bEo[1] * (1.0d - d2));
                    }
                    int i4 = 0;
                    while (true) {
                        i2 = i4;
                        if (i2 >= 4) {
                            break;
                        }
                        dArr9[i2] = 0.0d;
                        for (i4 = 0; i4 < 4; i4++) {
                            dArr9[i2] = dArr9[i2] + (dArr[i2][i4] * this.bDD.bEo[i4]);
                        }
                        i4 = i2 + 1;
                    }
                    dArr2 = dArr[0];
                    dArr2[0] = dArr2[0] + d7;
                    dArr2 = dArr[1];
                    dArr2[1] = dArr2[1] + d7;
                    if (a(dArr, this.bDD.bEp)) {
                        dArr9[0] = dArr9[0] + (dArr8[0] * d7);
                        dArr9[1] = dArr9[1] + (dArr8[1] * d7);
                        int i5 = 0;
                        while (true) {
                            i4 = i5;
                            if (i4 >= 4) {
                                break;
                            }
                            this.bDD.bEo[i4] = 0.0d;
                            for (i5 = 0; i5 < 4; i5++) {
                                dArr5 = this.bDD.bEo;
                                dArr5[i4] = dArr5[i4] + (this.bDD.bEp[i4][i5] * dArr9[i5]);
                            }
                            i5 = i4 + 1;
                        }
                        this.bDD.bDX[0] = dArr8[0];
                        this.bDD.bDX[1] = dArr8[1];
                    }
                }
            }
        }
        AppMethodBeat.o(55625);
    }

    private void b(double d, boolean z) {
        double d2;
        double d3;
        double d4 = d - this.bDD.bDF;
        double d5 = d4 * d4;
        if (z) {
            this.bDD.bEp[2][2] = this.bDD.bEj;
            this.bDD.bEp[2][3] = 0.0d;
            this.bDD.bEp[3][2] = 0.0d;
            this.bDD.bEp[3][3] = this.bDD.bEj;
        } else {
            d2 = 1.0d;
            if (d4 > 0.5d) {
                for (d3 = 0.0d; d3 < d4; d3 += 1.0d) {
                    d2 *= this.bDD.bDS;
                }
            }
            double[] dArr = this.bDD.bEp[2];
            dArr[2] = dArr[2] * d2;
            dArr = this.bDD.bEp[2];
            dArr[3] = dArr[3] * d2;
            dArr = this.bDD.bEp[3];
            dArr[2] = dArr[2] * d2;
            dArr = this.bDD.bEp[3];
            dArr[3] = d2 * dArr[3];
        }
        if (d4 > 0.5d) {
            d3 = 1.0d;
            for (d2 = 0.0d; d2 < d4; d2 += 1.0d) {
                d3 *= this.bDD.bEs;
            }
            b bVar = this.bDD;
            bVar.bEr = d3 * bVar.bEr;
        }
        this.bDD.bEo[0] = this.bDD.bEo[0] + (this.bDD.bEo[2] * d4);
        this.bDD.bEo[1] = this.bDD.bEo[1] + (this.bDD.bEo[3] * d4);
        if (this.bDD.bEt) {
            this.bDD.bEp[0][0] = this.bDD.bEp[0][0] + (this.bDD.bEp[2][2] * d5);
            this.bDD.bEp[0][1] = this.bDD.bEp[0][1] + (this.bDD.bEp[2][3] * d5);
            this.bDD.bEp[1][0] = this.bDD.bEp[1][0] + (this.bDD.bEp[3][2] * d5);
            this.bDD.bEp[1][1] = this.bDD.bEp[1][1] + (this.bDD.bEp[3][3] * d5);
        } else {
            this.bDD.bEp[0][0] = (this.bDD.bEp[0][0] + ((this.bDD.bEp[0][2] + this.bDD.bEp[2][0]) * d4)) + (this.bDD.bEp[2][2] * d5);
            this.bDD.bEp[1][1] = (this.bDD.bEp[1][1] + ((this.bDD.bEp[1][3] + this.bDD.bEp[3][1]) * d4)) + (d5 * this.bDD.bEp[3][3]);
            this.bDD.bEp[0][2] = this.bDD.bEp[0][2] + (this.bDD.bEp[2][2] * d4);
            this.bDD.bEp[2][0] = this.bDD.bEp[2][0] + (this.bDD.bEp[2][2] * d4);
            this.bDD.bEp[1][3] = this.bDD.bEp[1][3] + (this.bDD.bEp[3][3] * d4);
            this.bDD.bEp[3][1] = this.bDD.bEp[3][1] + (d4 * this.bDD.bEp[3][3]);
        }
        this.bDD.bDF = d;
    }

    private void c(double d, boolean z) {
        double d2;
        double d3;
        double d4 = d - this.bDE.bDF;
        double d5 = d4 * d4;
        if (z) {
            this.bDE.bEp[2][2] = this.bDE.bEj;
            this.bDE.bEp[2][3] = 0.0d;
            this.bDE.bEp[3][2] = 0.0d;
            this.bDE.bEp[3][3] = this.bDE.bEj;
        } else {
            d2 = 1.0d;
            if (d4 > 0.5d) {
                for (d3 = 0.0d; d3 < d4; d3 += 1.0d) {
                    d2 *= this.bDE.bDS;
                }
            }
            double[] dArr = this.bDE.bEp[2];
            dArr[2] = dArr[2] * d2;
            dArr = this.bDE.bEp[2];
            dArr[3] = dArr[3] * d2;
            dArr = this.bDE.bEp[3];
            dArr[2] = dArr[2] * d2;
            dArr = this.bDE.bEp[3];
            dArr[3] = d2 * dArr[3];
        }
        if (d4 > 0.5d) {
            d3 = 1.0d;
            for (d2 = 0.0d; d2 < d4; d2 += 1.0d) {
                d3 *= this.bDE.bEs;
            }
            b bVar = this.bDE;
            bVar.bEr = d3 * bVar.bEr;
        }
        this.bDE.bEo[0] = this.bDE.bEo[0] + (this.bDE.bEo[2] * d4);
        this.bDE.bEo[1] = this.bDE.bEo[1] + (this.bDE.bEo[3] * d4);
        if (this.bDE.bEt) {
            this.bDE.bEp[0][0] = this.bDE.bEp[0][0] + (this.bDE.bEp[2][2] * d5);
            this.bDE.bEp[0][1] = this.bDE.bEp[0][1] + (this.bDE.bEp[2][3] * d5);
            this.bDE.bEp[1][0] = this.bDE.bEp[1][0] + (this.bDE.bEp[3][2] * d5);
            this.bDE.bEp[1][1] = this.bDE.bEp[1][1] + (this.bDE.bEp[3][3] * d5);
        } else {
            this.bDE.bEp[0][0] = (this.bDE.bEp[0][0] + ((this.bDE.bEp[0][2] + this.bDE.bEp[2][0]) * d4)) + (this.bDE.bEp[2][2] * d5);
            this.bDE.bEp[1][1] = (this.bDE.bEp[1][1] + ((this.bDE.bEp[1][3] + this.bDE.bEp[3][1]) * d4)) + (d5 * this.bDE.bEp[3][3]);
            this.bDE.bEp[0][2] = this.bDE.bEp[0][2] + (this.bDE.bEp[2][2] * d4);
            this.bDE.bEp[2][0] = this.bDE.bEp[2][0] + (this.bDE.bEp[2][2] * d4);
            this.bDE.bEp[1][3] = this.bDE.bEp[1][3] + (this.bDE.bEp[3][3] * d4);
            this.bDE.bEp[3][1] = this.bDE.bEp[3][1] + (d4 * this.bDE.bEp[3][3]);
        }
        this.bDE.bDF = d;
    }

    private void b(double[] dArr) {
        AppMethodBeat.i(55626);
        if (this.bDD.bEm && this.bDD.bDW) {
            double[] dArr2 = new double[2];
            r1 = new double[2];
            double d = this.bDD.bEy;
            dArr2[0] = this.bDD.bEo[0] - this.bDD.bDX[0];
            dArr2[1] = this.bDD.bEo[1] - this.bDD.bDX[1];
            r1[0] = dArr[0] - this.bDD.bDX[0];
            r1[1] = dArr[1] - this.bDD.bDX[1];
            double sqrt = Math.sqrt((dArr2[0] * dArr2[0]) + (dArr2[1] * dArr2[1]));
            double sqrt2 = Math.sqrt((r1[0] * r1[0]) + (r1[1] * r1[1]));
            if (sqrt > this.bDD.bEe && sqrt2 > this.bDD.bEe) {
                Object obj;
                double atan2 = Math.atan2(r1[1], r1[0]) - Math.atan2(dArr2[1], dArr2[0]);
                if (atan2 > 3.141592653589793d) {
                    atan2 -= 6.283185307179586d;
                } else if (atan2 < -3.141592653589793d) {
                    atan2 += 6.283185307179586d;
                }
                b bVar = this.bDD;
                bVar.bEq = (d * atan2) + bVar.bEq;
                if (atan2 * atan2 > 4.0d * this.bDD.bEr) {
                    obj = 1;
                } else {
                    obj = null;
                }
                d = Math.sqrt(this.bDD.bEp[0][0] + this.bDD.bEp[1][1]);
                if (sqrt >= sqrt2) {
                    sqrt = sqrt2;
                }
                sqrt = d / sqrt;
                if (obj != null) {
                    this.bDD.bEr = sqrt * sqrt;
                } else {
                    this.bDD.bEr = 1.0d / ((1.0d / (sqrt * sqrt)) + (1.0d / this.bDD.bEr));
                }
            }
        }
        this.bDD.bDX[0] = dArr[0];
        this.bDD.bDX[1] = dArr[1];
        this.bDD.bDW = true;
        AppMethodBeat.o(55626);
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, double[] dArr, double[] dArr2) {
        AppMethodBeat.i(55627);
        switch (i) {
            case 0:
                dArr2[0] = ((dArr[1] - this.bDD.bEk[1]) * 6378137.0d) * Math.cos(this.bDD.bEk[0]);
                dArr2[1] = (dArr[0] - this.bDD.bEk[0]) * 6378137.0d;
                AppMethodBeat.o(55627);
                return;
            case 1:
                dArr2[0] = (dArr[1] / 6378137.0d) + this.bDD.bEk[0];
                dArr2[1] = (dArr[0] / (Math.cos(this.bDD.bEk[0]) * 6378137.0d)) + this.bDD.bEk[1];
                break;
        }
        AppMethodBeat.o(55627);
    }

    private static void a(double[] dArr, double[] dArr2) {
        double d = 1.0d / ((dArr[0] * dArr[3]) - (dArr[1] * dArr[2]));
        dArr2[0] = dArr[3] * d;
        dArr2[3] = dArr[0] * d;
        dArr2[1] = (-dArr[1]) * d;
        dArr2[2] = d * (-dArr[2]);
    }

    private static boolean a(double[][] dArr, double[][] dArr2) {
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        dArr3[0][0] = ((((((dArr[1][1] * dArr[2][2]) * dArr[3][3]) - ((dArr[1][1] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][1] * dArr[1][2]) * dArr[3][3])) + ((dArr[2][1] * dArr[1][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[1][2]) * dArr[2][3])) - ((dArr[3][1] * dArr[1][3]) * dArr[2][2]);
        dArr3[1][0] = (((((((-dArr[1][0]) * dArr[2][2]) * dArr[3][3]) + ((dArr[1][0] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][0] * dArr[1][2]) * dArr[3][3])) - ((dArr[2][0] * dArr[1][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[1][2]) * dArr[2][3])) + ((dArr[3][0] * dArr[1][3]) * dArr[2][2]);
        dArr3[2][0] = ((((((dArr[1][0] * dArr[2][1]) * dArr[3][3]) - ((dArr[1][0] * dArr[2][3]) * dArr[3][1])) - ((dArr[2][0] * dArr[1][1]) * dArr[3][3])) + ((dArr[2][0] * dArr[1][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[1][1]) * dArr[2][3])) - ((dArr[3][0] * dArr[1][3]) * dArr[2][1]);
        dArr3[3][0] = (((((((-dArr[1][0]) * dArr[2][1]) * dArr[3][2]) + ((dArr[1][0] * dArr[2][2]) * dArr[3][1])) + ((dArr[2][0] * dArr[1][1]) * dArr[3][2])) - ((dArr[2][0] * dArr[1][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[1][1]) * dArr[2][2])) + ((dArr[3][0] * dArr[1][2]) * dArr[2][1]);
        dArr3[0][1] = (((((((-dArr[0][1]) * dArr[2][2]) * dArr[3][3]) + ((dArr[0][1] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][1] * dArr[0][2]) * dArr[3][3])) - ((dArr[2][1] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][1] * dArr[0][2]) * dArr[2][3])) + ((dArr[3][1] * dArr[0][3]) * dArr[2][2]);
        dArr3[1][1] = ((((((dArr[0][0] * dArr[2][2]) * dArr[3][3]) - ((dArr[0][0] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[3][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[2][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[2][2]);
        dArr3[2][1] = (((((((-dArr[0][0]) * dArr[2][1]) * dArr[3][3]) + ((dArr[0][0] * dArr[2][3]) * dArr[3][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[3][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[2][3])) + ((dArr[3][0] * dArr[0][3]) * dArr[2][1]);
        dArr3[3][1] = ((((((dArr[0][0] * dArr[2][1]) * dArr[3][2]) - ((dArr[0][0] * dArr[2][2]) * dArr[3][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[3][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[2][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[2][1]);
        dArr3[0][2] = ((((((dArr[0][1] * dArr[1][2]) * dArr[3][3]) - ((dArr[0][1] * dArr[1][3]) * dArr[3][2])) - ((dArr[1][1] * dArr[0][2]) * dArr[3][3])) + ((dArr[1][1] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[0][2]) * dArr[1][3])) - ((dArr[3][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][2] = (((((((-dArr[0][0]) * dArr[1][2]) * dArr[3][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[3][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[3][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[1][3])) + ((dArr[3][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][2] = ((((((dArr[0][0] * dArr[1][1]) * dArr[3][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[3][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[3][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[1][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][2] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[3][2]) + ((dArr[0][0] * dArr[1][2]) * dArr[3][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[3][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[1][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[1][1]);
        dArr3[0][3] = (((((((-dArr[0][1]) * dArr[1][2]) * dArr[2][3]) + ((dArr[0][1] * dArr[1][3]) * dArr[2][2])) + ((dArr[1][1] * dArr[0][2]) * dArr[2][3])) - ((dArr[1][1] * dArr[0][3]) * dArr[2][2])) - ((dArr[2][1] * dArr[0][2]) * dArr[1][3])) + ((dArr[2][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][3] = ((((((dArr[0][0] * dArr[1][2]) * dArr[2][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[2][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[2][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[2][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[1][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][3] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[2][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[2][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[2][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[2][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[1][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][3] = ((((((dArr[0][0] * dArr[1][1]) * dArr[2][2]) - ((dArr[0][0] * dArr[1][2]) * dArr[2][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[2][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[2][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[1][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[1][1]);
        double d = (((dArr[0][0] * dArr3[0][0]) + (dArr[0][1] * dArr3[1][0])) + (dArr[0][2] * dArr3[2][0])) + (dArr[0][3] * dArr3[3][0]);
        if (d == 0.0d) {
            return false;
        }
        double d2 = 1.0d / d;
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                dArr2[i][i2] = dArr3[i][i2] * d2;
            }
        }
        return true;
    }
}
