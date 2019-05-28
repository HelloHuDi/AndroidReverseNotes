package org.apache.commons.p703b.p705b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: org.apache.commons.b.b.a */
public final class C6123a implements Cloneable {
    private String BYC;
    protected char[] aLx;
    protected int size;

    public C6123a() {
        this(32);
    }

    public C6123a(int i) {
        AppMethodBeat.m2504i(116965);
        if (i <= 0) {
            i = 32;
        }
        this.aLx = new char[i];
        AppMethodBeat.m2505o(116965);
    }

    /* renamed from: Vm */
    private C6123a m9690Vm(int i) {
        AppMethodBeat.m2504i(116966);
        if (i > this.aLx.length) {
            char[] cArr = this.aLx;
            this.aLx = new char[(i * 2)];
            System.arraycopy(cArr, 0, this.aLx, 0, this.size);
        }
        AppMethodBeat.m2505o(116966);
        return this;
    }

    public final C6123a emT() {
        AppMethodBeat.m2504i(116967);
        if (this.BYC == null) {
            AppMethodBeat.m2505o(116967);
            return this;
        }
        this = awR(this.BYC);
        AppMethodBeat.m2505o(116967);
        return this;
    }

    public final C6123a awR(String str) {
        AppMethodBeat.m2504i(116968);
        if (str == null) {
            this = emT();
            AppMethodBeat.m2505o(116968);
            return this;
        }
        int length = str.length();
        if (length > 0) {
            int i = this.size;
            m9690Vm(i + length);
            str.getChars(0, length, this.aLx, i);
            this.size = length + this.size;
        }
        AppMethodBeat.m2505o(116968);
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C6123a)) {
            return false;
        }
        C6123a c6123a = (C6123a) obj;
        if (this != c6123a) {
            if (this.size != c6123a.size) {
                return false;
            }
            char[] cArr = this.aLx;
            char[] cArr2 = c6123a.aLx;
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
        AppMethodBeat.m2504i(116970);
        String str = new String(this.aLx, 0, this.size);
        AppMethodBeat.m2505o(116970);
        return str;
    }

    public final Object clone() {
        AppMethodBeat.m2504i(116971);
        C6123a c6123a = (C6123a) super.clone();
        c6123a.aLx = new char[this.aLx.length];
        System.arraycopy(this.aLx, 0, c6123a.aLx, 0, this.aLx.length);
        AppMethodBeat.m2505o(116971);
        return c6123a;
    }

    public final C6123a emU() {
        AppMethodBeat.m2504i(116969);
        m9690Vm(this.size + 1);
        char[] cArr = this.aLx;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = '#';
        AppMethodBeat.m2505o(116969);
        return this;
    }
}
