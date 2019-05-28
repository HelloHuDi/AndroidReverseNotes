package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public class SKBuiltinBuffer_t extends a {
    private static final int fieldNumberBuffer = 2;
    private static final int fieldNumberILen = 1;
    private b Buffer;
    private boolean hasBuffer;
    private boolean hasILen;
    private int iLen;

    private SKBuiltinBuffer_t setILen(int i) {
        this.iLen = i;
        this.hasILen = true;
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(byte[] bArr) {
        AppMethodBeat.i(51833);
        b bI = b.bI(bArr);
        setBuffer(bI);
        setILen(bI.wR.length);
        AppMethodBeat.o(51833);
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(51834);
        b y = b.y(bArr, i, i2);
        setBuffer(y);
        setILen(y.wR.length);
        AppMethodBeat.o(51834);
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(b bVar) {
        AppMethodBeat.i(51835);
        if (bVar == null) {
            setBuffer(null);
        }
        this.Buffer = bVar;
        this.hasBuffer = true;
        setILen(this.Buffer.wR.length);
        AppMethodBeat.o(51835);
        return this;
    }

    public int getILen() {
        return this.iLen;
    }

    public b getBuffer() {
        return this.Buffer;
    }

    public byte[] getBufferToBytes() {
        return this.Buffer.wR;
    }

    public boolean hasBuffer() {
        return this.hasBuffer;
    }

    public String toString() {
        AppMethodBeat.i(51836);
        Object stringBuilder = new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("iLen = ").append(this.iLen).append("   ").toString();
        if (this.hasBuffer) {
            stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("Buffer = ").append(this.Buffer).append("   ").toString();
        }
        String stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder)).append(")").toString();
        AppMethodBeat.o(51836);
        return stringBuilder2;
    }

    /* Access modifiers changed, original: protected */
    public SKBuiltinBuffer_t validate() {
        AppMethodBeat.i(51837);
        if (this.hasILen) {
            AppMethodBeat.o(51837);
            return this;
        }
        e.a.a.b bVar = new e.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.hasILen);
        AppMethodBeat.o(51837);
        throw bVar;
    }

    public int computeSize() {
        AppMethodBeat.i(51838);
        int bs = e.a.a.b.b.a.bs(1, this.iLen) + 0;
        if (this.hasBuffer) {
            bs += e.a.a.b.b.a.b(2, this.Buffer);
        }
        bs += computeNestedMessageSize();
        AppMethodBeat.o(51838);
        return bs;
    }

    private int computeNestedMessageSize() {
        return 0;
    }

    public byte[] toByteArray() {
        AppMethodBeat.i(51839);
        validate();
        byte[] toByteArray = super.toByteArray();
        AppMethodBeat.o(51839);
        return toByteArray;
    }

    public void writeFields(e.a.a.c.a aVar) {
        AppMethodBeat.i(51840);
        aVar.iz(1, this.iLen);
        if (this.hasBuffer) {
            aVar.c(2, this.Buffer);
        }
        AppMethodBeat.o(51840);
    }

    public final boolean populateBuilderWithField(e.a.a.a.a aVar, a aVar2, int i) {
        AppMethodBeat.i(51841);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = (SKBuiltinBuffer_t) aVar2;
        boolean z = true;
        switch (i) {
            case 1:
                sKBuiltinBuffer_t.setILen(aVar.BTU.vd());
                break;
            case 2:
                sKBuiltinBuffer_t.setBuffer(aVar.BTU.emu());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.o(51841);
        return z;
    }

    public SKBuiltinBuffer_t parseFrom(byte[] bArr) {
        AppMethodBeat.i(51842);
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
            if (!populateBuilderWithField(aVar, this, nextFieldNumber)) {
                aVar.ems();
            }
        }
        SKBuiltinBuffer_t validate = validate();
        AppMethodBeat.o(51842);
        return validate;
    }
}
