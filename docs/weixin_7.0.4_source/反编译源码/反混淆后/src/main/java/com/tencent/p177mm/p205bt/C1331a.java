package com.tencent.p177mm.p205bt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p693a.p694a.C6085b;
import p690e.p691a.p692a.p693a.p694a.C7397a;
import p690e.p691a.p692a.p695b.C6090a;
import p690e.p691a.p692a.p695b.p696a.C6088a;
import p690e.p691a.p692a.p695b.p696a.C6089b;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.bt.a */
public class C1331a {
    protected static final int OPCODE_COMPUTESIZE = 1;
    protected static final int OPCODE_PARSEFROM = 2;
    protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
    protected static final int OPCODE_WRITEFIELDS = 0;
    public static C6085b unknownTagHandler = new C7397a();

    public byte[] toByteArray() {
        AppMethodBeat.m2504i(51816);
        validate();
        byte[] bArr = new byte[computeSize()];
        C6093a c6093a = new C6093a(bArr);
        writeFields(c6093a);
        if (c6093a.output != null) {
            c6093a.output.write(c6093a.BTW);
            c6093a.output.flush();
        }
        AppMethodBeat.m2505o(51816);
        return bArr;
    }

    /* Access modifiers changed, original: protected */
    public C1331a validate() {
        return this;
    }

    /* Access modifiers changed, original: protected|varargs */
    /* renamed from: op */
    public int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51818);
        Error error = new Error("Cannot use this method");
        AppMethodBeat.m2505o(51818);
        throw error;
    }

    public void writeFields(C6093a c6093a) {
        AppMethodBeat.m2504i(51819);
        mo4669op(0, c6093a);
        AppMethodBeat.m2505o(51819);
    }

    public int computeSize() {
        int i = 0;
        AppMethodBeat.m2504i(51820);
        try {
            i = mo4669op(1, new Object[0]);
            AppMethodBeat.m2505o(51820);
        } catch (Exception e) {
            AppMethodBeat.m2505o(51820);
        }
        return i;
    }

    public C1331a parseFrom(byte[] bArr) {
        AppMethodBeat.m2504i(51821);
        mo4669op(2, bArr);
        AppMethodBeat.m2505o(51821);
        return this;
    }

    public boolean populateBuilderWithField(C6086a c6086a, C1331a c1331a, int i) {
        AppMethodBeat.m2504i(51822);
        if (mo4669op(3, c6086a, c1331a, Integer.valueOf(i)) == 0) {
            AppMethodBeat.m2505o(51822);
            return true;
        }
        AppMethodBeat.m2505o(51822);
        return false;
    }

    static {
        AppMethodBeat.m2504i(51815);
        AppMethodBeat.m2505o(51815);
    }

    public static int getNextFieldNumber(C6086a c6086a) {
        int i = 0;
        AppMethodBeat.m2504i(51817);
        C6088a c6088a = c6086a.BTU;
        if (c6088a.bxm != c6088a.bufferSize || c6088a.mo13457sd(false)) {
            c6088a.bxn = c6088a.mo13458vd();
            if (c6088a.bxn == 0) {
                C6089b emy = C6089b.emy();
                AppMethodBeat.m2505o(51817);
                throw emy;
            }
            i = c6088a.bxn;
        } else {
            c6088a.bxn = 0;
        }
        c6086a.BTV = i;
        i = C6090a.m9569fz(c6086a.BTV);
        AppMethodBeat.m2505o(51817);
        return i;
    }
}
