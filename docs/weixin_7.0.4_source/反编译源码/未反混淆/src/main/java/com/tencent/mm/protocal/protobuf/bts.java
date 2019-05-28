package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bts extends a {
    public String wVI;
    private boolean wVJ;

    public final /* bridge */ /* synthetic */ a validate() {
        return this;
    }

    public final bts alV(String str) {
        this.wVI = str;
        this.wVJ = true;
        return this;
    }

    public final int computeSize() {
        AppMethodBeat.i(51853);
        int i = 0;
        if (this.wVJ) {
            i = e.a.a.b.b.a.f(1, this.wVI) + 0;
        }
        i += 0;
        AppMethodBeat.o(51853);
        return i;
    }

    public final byte[] toByteArray() {
        AppMethodBeat.i(51854);
        byte[] toByteArray = super.toByteArray();
        AppMethodBeat.o(51854);
        return toByteArray;
    }

    public final void writeFields(e.a.a.c.a aVar) {
        AppMethodBeat.i(51855);
        if (this.wVJ) {
            aVar.e(1, this.wVI);
        }
        AppMethodBeat.o(51855);
    }

    public final boolean populateBuilderWithField(e.a.a.a.a aVar, a aVar2, int i) {
        AppMethodBeat.i(51856);
        bts bts = (bts) aVar2;
        boolean z = true;
        switch (i) {
            case 1:
                bts.alV(aVar.BTU.readString());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.o(51856);
        return z;
    }

    public final String toString() {
        return this.wVI;
    }

    public final /* synthetic */ a parseFrom(byte[] bArr) {
        AppMethodBeat.i(51857);
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
            if (!populateBuilderWithField(aVar, this, nextFieldNumber)) {
                aVar.ems();
            }
        }
        AppMethodBeat.o(51857);
        return this;
    }
}
