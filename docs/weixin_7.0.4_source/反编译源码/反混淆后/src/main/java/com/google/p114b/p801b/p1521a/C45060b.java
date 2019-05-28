package com.google.p114b.p801b.p1521a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.b.a.b */
final class C45060b {
    final C41637a bzA;
    final int[] bzB;

    C45060b(C41637a c41637a, int[] iArr) {
        AppMethodBeat.m2504i(57201);
        if (iArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(57201);
            throw illegalArgumentException;
        }
        this.bzA = c41637a;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.bzB = iArr;
            AppMethodBeat.m2505o(57201);
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.bzB = new int[]{0};
            AppMethodBeat.m2505o(57201);
            return;
        }
        this.bzB = new int[(length - i)];
        System.arraycopy(iArr, i, this.bzB, 0, this.bzB.length);
        AppMethodBeat.m2505o(57201);
    }

    /* Access modifiers changed, original: final */
    public final boolean isZero() {
        return this.bzB[0] == 0;
    }

    /* renamed from: fC */
    private int m82674fC(int i) {
        return this.bzB[(this.bzB.length - 1) - i];
    }

    /* renamed from: a */
    private C45060b m82673a(C45060b c45060b) {
        AppMethodBeat.m2504i(57202);
        if (!this.bzA.equals(c45060b.bzA)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            AppMethodBeat.m2505o(57202);
            throw illegalArgumentException;
        } else if (isZero()) {
            AppMethodBeat.m2505o(57202);
            return c45060b;
        } else if (c45060b.isZero()) {
            AppMethodBeat.m2505o(57202);
            return this;
        } else {
            int[] iArr;
            Object obj;
            Object obj2 = this.bzB;
            Object obj3 = c45060b.bzB;
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
                iArr3[i] = C41637a.m72996bC(iArr2[i - length], obj[i]);
            }
            c45060b = new C45060b(this.bzA, iArr3);
            AppMethodBeat.m2505o(57202);
            return c45060b;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bE */
    public final C45060b mo72814bE(int i, int i2) {
        AppMethodBeat.m2504i(57203);
        C45060b c45060b;
        if (i < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(57203);
            throw illegalArgumentException;
        } else if (i2 == 0) {
            c45060b = this.bzA.bzw;
            AppMethodBeat.m2505o(57203);
            return c45060b;
        } else {
            int length = this.bzB.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.bzA.mo67033bD(this.bzB[i3], i2);
            }
            c45060b = new C45060b(this.bzA, iArr);
            AppMethodBeat.m2505o(57203);
            return c45060b;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final C45060b[] mo72813b(C45060b c45060b) {
        AppMethodBeat.m2504i(57204);
        IllegalArgumentException illegalArgumentException;
        if (!this.bzA.equals(c45060b.bzA)) {
            illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            AppMethodBeat.m2505o(57204);
            throw illegalArgumentException;
        } else if (c45060b.isZero()) {
            illegalArgumentException = new IllegalArgumentException("Divide by 0");
            AppMethodBeat.m2505o(57204);
            throw illegalArgumentException;
        } else {
            C45060b c45060b2 = this.bzA.bzw;
            int fC = c45060b.m82674fC(c45060b.bzB.length - 1);
            C41637a c41637a = this.bzA;
            if (fC == 0) {
                ArithmeticException arithmeticException = new ArithmeticException();
                AppMethodBeat.m2505o(57204);
                throw arithmeticException;
            }
            int i = c41637a.bzu[(c41637a.size - c41637a.bzv[fC]) - 1];
            C45060b c45060b3 = this;
            C45060b c45060b4 = c45060b2;
            while (c45060b3.bzB.length - 1 >= c45060b.bzB.length - 1 && !c45060b3.isZero()) {
                int length = (c45060b3.bzB.length - 1) - (c45060b.bzB.length - 1);
                int bD = this.bzA.mo67033bD(c45060b3.m82674fC(c45060b3.bzB.length - 1), i);
                C45060b bE = c45060b.mo72814bE(length, bD);
                C41637a c41637a2 = this.bzA;
                if (length < 0) {
                    illegalArgumentException = new IllegalArgumentException();
                    AppMethodBeat.m2505o(57204);
                    throw illegalArgumentException;
                }
                if (bD == 0) {
                    c45060b2 = c41637a2.bzw;
                } else {
                    int[] iArr = new int[(length + 1)];
                    iArr[0] = bD;
                    c45060b2 = new C45060b(c41637a2, iArr);
                }
                c45060b4 = c45060b4.m82673a(c45060b2);
                c45060b3 = c45060b3.m82673a(bE);
            }
            C45060b[] c45060bArr = new C45060b[]{c45060b4, c45060b3};
            AppMethodBeat.m2505o(57204);
            return c45060bArr;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(57205);
        StringBuilder stringBuilder = new StringBuilder((this.bzB.length - 1) * 8);
        for (int length = this.bzB.length - 1; length >= 0; length--) {
            int fC = m82674fC(length);
            if (fC != 0) {
                if (fC < 0) {
                    stringBuilder.append(" - ");
                    fC = -fC;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (length == 0 || fC != 1) {
                    C41637a c41637a = this.bzA;
                    if (fC == 0) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                        AppMethodBeat.m2505o(57205);
                        throw illegalArgumentException;
                    }
                    fC = c41637a.bzv[fC];
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
        AppMethodBeat.m2505o(57205);
        return stringBuilder2;
    }
}
