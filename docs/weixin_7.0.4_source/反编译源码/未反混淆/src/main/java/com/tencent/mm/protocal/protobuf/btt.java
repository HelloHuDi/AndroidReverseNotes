package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class btt extends a {
    public int wVK;
    private boolean wVL;

    public final /* synthetic */ a validate() {
        AppMethodBeat.i(51852);
        btt dmA = dmA();
        AppMethodBeat.o(51852);
        return dmA;
    }

    public final btt LQ(int i) {
        this.wVK = i;
        this.wVL = true;
        return this;
    }

    public final String toString() {
        AppMethodBeat.i(51845);
        String stringBuilder = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("uiVal = ").append(this.wVK).append("   ").toString())).append(")").toString();
        AppMethodBeat.o(51845);
        return stringBuilder;
    }

    private btt dmA() {
        AppMethodBeat.i(51846);
        if (this.wVL) {
            AppMethodBeat.o(51846);
            return this;
        }
        b bVar = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.wVL);
        AppMethodBeat.o(51846);
        throw bVar;
    }

    public final int computeSize() {
        AppMethodBeat.i(51847);
        int bs = (e.a.a.b.b.a.bs(1, this.wVK) + 0) + 0;
        AppMethodBeat.o(51847);
        return bs;
    }

    public final byte[] toByteArray() {
        AppMethodBeat.i(51848);
        dmA();
        byte[] toByteArray = super.toByteArray();
        AppMethodBeat.o(51848);
        return toByteArray;
    }

    public final void writeFields(e.a.a.c.a aVar) {
        AppMethodBeat.i(51849);
        aVar.iz(1, this.wVK);
        AppMethodBeat.o(51849);
    }

    public final boolean populateBuilderWithField(e.a.a.a.a aVar, a aVar2, int i) {
        AppMethodBeat.i(51850);
        btt btt = (btt) aVar2;
        boolean z = true;
        switch (i) {
            case 1:
                btt.LQ(aVar.BTU.vd());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.o(51850);
        return z;
    }

    public final /* synthetic */ a parseFrom(byte[] bArr) {
        AppMethodBeat.i(51851);
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
            if (!populateBuilderWithField(aVar, this, nextFieldNumber)) {
                aVar.ems();
            }
        }
        btt dmA = dmA();
        AppMethodBeat.o(51851);
        return dmA;
    }
}
