package org.apache.commons.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements Cloneable {
    private String BYC;
    protected char[] aLx;
    protected int size;

    public a() {
        this(32);
    }

    public a(int i) {
        AppMethodBeat.i(116965);
        if (i <= 0) {
            i = 32;
        }
        this.aLx = new char[i];
        AppMethodBeat.o(116965);
    }

    private a Vm(int i) {
        AppMethodBeat.i(116966);
        if (i > this.aLx.length) {
            char[] cArr = this.aLx;
            this.aLx = new char[(i * 2)];
            System.arraycopy(cArr, 0, this.aLx, 0, this.size);
        }
        AppMethodBeat.o(116966);
        return this;
    }

    public final a emT() {
        AppMethodBeat.i(116967);
        if (this.BYC == null) {
            AppMethodBeat.o(116967);
            return this;
        }
        this = awR(this.BYC);
        AppMethodBeat.o(116967);
        return this;
    }

    public final a awR(String str) {
        AppMethodBeat.i(116968);
        if (str == null) {
            this = emT();
            AppMethodBeat.o(116968);
            return this;
        }
        int length = str.length();
        if (length > 0) {
            int i = this.size;
            Vm(i + length);
            str.getChars(0, length, this.aLx, i);
            this.size = length + this.size;
        }
        AppMethodBeat.o(116968);
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this != aVar) {
            if (this.size != aVar.size) {
                return false;
            }
            char[] cArr = this.aLx;
            char[] cArr2 = aVar.aLx;
            for (int i = this.size - 1; i >= 0; i--) {
                if (cArr[i] != cArr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        char[] cArr = this.aLx;
        int i = 0;
        for (int i2 = this.size - 1; i2 >= 0; i2--) {
            i = (i * 31) + cArr[i2];
        }
        return i;
    }

    public final String toString() {
        AppMethodBeat.i(116970);
        String str = new String(this.aLx, 0, this.size);
        AppMethodBeat.o(116970);
        return str;
    }

    public final Object clone() {
        AppMethodBeat.i(116971);
        a aVar = (a) super.clone();
        aVar.aLx = new char[this.aLx.length];
        System.arraycopy(this.aLx, 0, aVar.aLx, 0, this.aLx.length);
        AppMethodBeat.o(116971);
        return aVar;
    }

    public final a emU() {
        AppMethodBeat.i(116969);
        Vm(this.size + 1);
        char[] cArr = this.aLx;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = '#';
        AppMethodBeat.o(116969);
        return this;
    }
}
