package com.tencent.mm.bt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.a.a.b;

public class a {
    protected static final int OPCODE_COMPUTESIZE = 1;
    protected static final int OPCODE_PARSEFROM = 2;
    protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
    protected static final int OPCODE_WRITEFIELDS = 0;
    public static b unknownTagHandler = new e.a.a.a.a.a();

    public byte[] toByteArray() {
        AppMethodBeat.i(51816);
        validate();
        byte[] bArr = new byte[computeSize()];
        e.a.a.c.a aVar = new e.a.a.c.a(bArr);
        writeFields(aVar);
        if (aVar.output != null) {
            aVar.output.write(aVar.BTW);
            aVar.output.flush();
        }
        AppMethodBeat.o(51816);
        return bArr;
    }

    /* Access modifiers changed, original: protected */
    public a validate() {
        return this;
    }

    /* Access modifiers changed, original: protected|varargs */
    public int op(int i, Object... objArr) {
        AppMethodBeat.i(51818);
        Error error = new Error("Cannot use this method");
        AppMethodBeat.o(51818);
        throw error;
    }

    public void writeFields(e.a.a.c.a aVar) {
        AppMethodBeat.i(51819);
        op(0, aVar);
        AppMethodBeat.o(51819);
    }

    public int computeSize() {
        int i = 0;
        AppMethodBeat.i(51820);
        try {
            i = op(1, new Object[0]);
            AppMethodBeat.o(51820);
        } catch (Exception e) {
            AppMethodBeat.o(51820);
        }
        return i;
    }

    public a parseFrom(byte[] bArr) {
        AppMethodBeat.i(51821);
        op(2, bArr);
        AppMethodBeat.o(51821);
        return this;
    }

    public boolean populateBuilderWithField(e.a.a.a.a aVar, a aVar2, int i) {
        AppMethodBeat.i(51822);
        if (op(3, aVar, aVar2, Integer.valueOf(i)) == 0) {
            AppMethodBeat.o(51822);
            return true;
        }
        AppMethodBeat.o(51822);
        return false;
    }

    static {
        AppMethodBeat.i(51815);
        AppMethodBeat.o(51815);
    }

    public static int getNextFieldNumber(e.a.a.a.a aVar) {
        int i = 0;
        AppMethodBeat.i(51817);
        e.a.a.b.a.a aVar2 = aVar.BTU;
        if (aVar2.bxm != aVar2.bufferSize || aVar2.sd(false)) {
            aVar2.bxn = aVar2.vd();
            if (aVar2.bxn == 0) {
                e.a.a.b.a.b emy = e.a.a.b.a.b.emy();
                AppMethodBeat.o(51817);
                throw emy;
            }
            i = aVar2.bxn;
        } else {
            aVar2.bxn = 0;
        }
        aVar.BTV = i;
        i = e.a.a.b.a.fz(aVar.BTV);
        AppMethodBeat.o(51817);
        return i;
    }
}
