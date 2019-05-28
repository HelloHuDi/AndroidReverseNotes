package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b {
    final a bzA;
    final int[] bzB;

    b(a aVar, int[] iArr) {
        AppMethodBeat.i(57201);
        if (iArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(57201);
            throw illegalArgumentException;
        }
        this.bzA = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.bzB = iArr;
            AppMethodBeat.o(57201);
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.bzB = new int[]{0};
            AppMethodBeat.o(57201);
            return;
        }
        this.bzB = new int[(length - i)];
        System.arraycopy(iArr, i, this.bzB, 0, this.bzB.length);
        AppMethodBeat.o(57201);
    }

    /* Access modifiers changed, original: final */
    public final boolean isZero() {
        return this.bzB[0] == 0;
    }

    private int fC(int i) {
        return this.bzB[(this.bzB.length - 1) - i];
    }

    private b a(b bVar) {
        AppMethodBeat.i(57202);
        if (!this.bzA.equals(bVar.bzA)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            AppMethodBeat.o(57202);
            throw illegalArgumentException;
        } else if (isZero()) {
            AppMethodBeat.o(57202);
            return bVar;
        } else if (bVar.isZero()) {
            AppMethodBeat.o(57202);
            return this;
        } else {
            int[] iArr;
            Object obj;
            Object obj2 = this.bzB;
            Object obj3 = bVar.bzB;
            if (obj2.length > obj3.length) {
                iArr = obj3;
                obj = obj2;
            } else {
                Object iArr2 = obj2;
                obj = obj3;
            }
            int[] iArr3 = new int[obj.length];
            int length = obj.length - iArr2.length;
            System.arraycopy(obj, 0, iArr3, 0, length);
            for (int i = length; i < obj.length; i++) {
                iArr3[i] = a.bC(iArr2[i - length], obj[i]);
            }
            bVar = new b(this.bzA, iArr3);
            AppMethodBeat.o(57202);
            return bVar;
        }
    }

    /* Access modifiers changed, original: final */
    public final b bE(int i, int i2) {
        AppMethodBeat.i(57203);
        b bVar;
        if (i < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(57203);
            throw illegalArgumentException;
        } else if (i2 == 0) {
            bVar = this.bzA.bzw;
            AppMethodBeat.o(57203);
            return bVar;
        } else {
            int length = this.bzB.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.bzA.bD(this.bzB[i3], i2);
            }
            bVar = new b(this.bzA, iArr);
            AppMethodBeat.o(57203);
            return bVar;
        }
    }

    /* Access modifiers changed, original: final */
    public final b[] b(b bVar) {
        AppMethodBeat.i(57204);
        IllegalArgumentException illegalArgumentException;
        if (!this.bzA.equals(bVar.bzA)) {
            illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            AppMethodBeat.o(57204);
            throw illegalArgumentException;
        } else if (bVar.isZero()) {
            illegalArgumentException = new IllegalArgumentException("Divide by 0");
            AppMethodBeat.o(57204);
            throw illegalArgumentException;
        } else {
            b bVar2 = this.bzA.bzw;
            int fC = bVar.fC(bVar.bzB.length - 1);
            a aVar = this.bzA;
            if (fC == 0) {
                ArithmeticException arithmeticException = new ArithmeticException();
                AppMethodBeat.o(57204);
                throw arithmeticException;
            }
            int i = aVar.bzu[(aVar.size - aVar.bzv[fC]) - 1];
            b bVar3 = this;
            b bVar4 = bVar2;
            while (bVar3.bzB.length - 1 >= bVar.bzB.length - 1 && !bVar3.isZero()) {
                int length = (bVar3.bzB.length - 1) - (bVar.bzB.length - 1);
                int bD = this.bzA.bD(bVar3.fC(bVar3.bzB.length - 1), i);
                b bE = bVar.bE(length, bD);
                a aVar2 = this.bzA;
                if (length < 0) {
                    illegalArgumentException = new IllegalArgumentException();
                    AppMethodBeat.o(57204);
                    throw illegalArgumentException;
                }
                if (bD == 0) {
                    bVar2 = aVar2.bzw;
                } else {
                    int[] iArr = new int[(length + 1)];
                    iArr[0] = bD;
                    bVar2 = new b(aVar2, iArr);
                }
                bVar4 = bVar4.a(bVar2);
                bVar3 = bVar3.a(bE);
            }
            b[] bVarArr = new b[]{bVar4, bVar3};
            AppMethodBeat.o(57204);
            return bVarArr;
        }
    }

    public final String toString() {
        AppMethodBeat.i(57205);
        StringBuilder stringBuilder = new StringBuilder((this.bzB.length - 1) * 8);
        for (int length = this.bzB.length - 1; length >= 0; length--) {
            int fC = fC(length);
            if (fC != 0) {
                if (fC < 0) {
                    stringBuilder.append(" - ");
                    fC = -fC;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (length == 0 || fC != 1) {
                    a aVar = this.bzA;
                    if (fC == 0) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                        AppMethodBeat.o(57205);
                        throw illegalArgumentException;
                    }
                    fC = aVar.bzv[fC];
                    if (fC == 0) {
                        stringBuilder.append('1');
                    } else if (fC == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(fC);
                    }
                }
                if (length != 0) {
                    if (length == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(length);
                    }
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(57205);
        return stringBuilder2;
    }
}
