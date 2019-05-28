package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t */
public class SKBuiltinBuffer_t extends C1331a {
    private static final int fieldNumberBuffer = 2;
    private static final int fieldNumberILen = 1;
    private C1332b Buffer;
    private boolean hasBuffer;
    private boolean hasILen;
    private int iLen;

    private SKBuiltinBuffer_t setILen(int i) {
        this.iLen = i;
        this.hasILen = true;
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(byte[] bArr) {
        AppMethodBeat.m2504i(51833);
        C1332b bI = C1332b.m2847bI(bArr);
        setBuffer(bI);
        setILen(bI.f1226wR.length);
        AppMethodBeat.m2505o(51833);
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(51834);
        C1332b y = C1332b.m2848y(bArr, i, i2);
        setBuffer(y);
        setILen(y.f1226wR.length);
        AppMethodBeat.m2505o(51834);
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(C1332b c1332b) {
        AppMethodBeat.m2504i(51835);
        if (c1332b == null) {
            setBuffer(null);
        }
        this.Buffer = c1332b;
        this.hasBuffer = true;
        setILen(this.Buffer.f1226wR.length);
        AppMethodBeat.m2505o(51835);
        return this;
    }

    public int getILen() {
        return this.iLen;
    }

    public C1332b getBuffer() {
        return this.Buffer;
    }

    public byte[] getBufferToBytes() {
        return this.Buffer.f1226wR;
    }

    public boolean hasBuffer() {
        return this.hasBuffer;
    }

    public String toString() {
        AppMethodBeat.m2504i(51836);
        Object stringBuilder = new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("iLen = ").append(this.iLen).append("   ").toString();
        if (this.hasBuffer) {
            stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("Buffer = ").append(this.Buffer).append("   ").toString();
        }
        String stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder)).append(")").toString();
        AppMethodBeat.m2505o(51836);
        return stringBuilder2;
    }

    /* Access modifiers changed, original: protected */
    public SKBuiltinBuffer_t validate() {
        AppMethodBeat.m2504i(51837);
        if (this.hasILen) {
            AppMethodBeat.m2505o(51837);
            return this;
        }
        C6092b c6092b = new C6092b("Not all required fields were included (false = not included in message),  iLen:" + this.hasILen);
        AppMethodBeat.m2505o(51837);
        throw c6092b;
    }

    public int computeSize() {
        AppMethodBeat.m2504i(51838);
        int bs = C6091a.m9572bs(1, this.iLen) + 0;
        if (this.hasBuffer) {
            bs += C6091a.m9571b(2, this.Buffer);
        }
        bs += computeNestedMessageSize();
        AppMethodBeat.m2505o(51838);
        return bs;
    }

    private int computeNestedMessageSize() {
        return 0;
    }

    public byte[] toByteArray() {
        AppMethodBeat.m2504i(51839);
        validate();
        byte[] toByteArray = super.toByteArray();
        AppMethodBeat.m2505o(51839);
        return toByteArray;
    }

    public void writeFields(C6093a c6093a) {
        AppMethodBeat.m2504i(51840);
        c6093a.mo13480iz(1, this.iLen);
        if (this.hasBuffer) {
            c6093a.mo13473c(2, this.Buffer);
        }
        AppMethodBeat.m2505o(51840);
    }

    public final boolean populateBuilderWithField(C6086a c6086a, C1331a c1331a, int i) {
        AppMethodBeat.m2504i(51841);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = (SKBuiltinBuffer_t) c1331a;
        boolean z = true;
        switch (i) {
            case 1:
                sKBuiltinBuffer_t.setILen(c6086a.BTU.mo13458vd());
                break;
            case 2:
                sKBuiltinBuffer_t.setBuffer(c6086a.BTU.emu());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.m2505o(51841);
        return z;
    }

    public SKBuiltinBuffer_t parseFrom(byte[] bArr) {
        AppMethodBeat.m2504i(51842);
        C6086a c6086a = new C6086a(bArr, unknownTagHandler);
        for (int nextFieldNumber = C1331a.getNextFieldNumber(c6086a); nextFieldNumber > 0; nextFieldNumber = C1331a.getNextFieldNumber(c6086a)) {
            if (!populateBuilderWithField(c6086a, this, nextFieldNumber)) {
                c6086a.ems();
            }
        }
        SKBuiltinBuffer_t validate = validate();
        AppMethodBeat.m2505o(51842);
        return validate;
    }
}
