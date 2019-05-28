package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class fs extends a {
    public String ProductID;
    public String vBa;
    public EmotionPrice vHC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62509);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ProductID == null) {
                bVar = new b("Not all required fields were included: ProductID");
                AppMethodBeat.o(62509);
                throw bVar;
            } else if (this.vHC == null) {
                bVar = new b("Not all required fields were included: Price");
                AppMethodBeat.o(62509);
                throw bVar;
            } else {
                if (this.ProductID != null) {
                    aVar.e(1, this.ProductID);
                }
                if (this.vHC != null) {
                    aVar.iy(2, this.vHC.computeSize());
                    this.vHC.writeFields(aVar);
                }
                if (this.vBa != null) {
                    aVar.e(3, this.vBa);
                }
                AppMethodBeat.o(62509);
                return 0;
            }
        } else if (i == 1) {
            if (this.ProductID != null) {
                f = e.a.a.b.b.a.f(1, this.ProductID) + 0;
            } else {
                f = 0;
            }
            if (this.vHC != null) {
                f += e.a.a.a.ix(2, this.vHC.computeSize());
            }
            if (this.vBa != null) {
                f += e.a.a.b.b.a.f(3, this.vBa);
            }
            AppMethodBeat.o(62509);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ProductID == null) {
                bVar = new b("Not all required fields were included: ProductID");
                AppMethodBeat.o(62509);
                throw bVar;
            } else if (this.vHC == null) {
                bVar = new b("Not all required fields were included: Price");
                AppMethodBeat.o(62509);
                throw bVar;
            } else {
                AppMethodBeat.o(62509);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fs fsVar = (fs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fsVar.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(62509);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        EmotionPrice emotionPrice = new EmotionPrice();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emotionPrice.populateBuilderWithField(aVar4, emotionPrice, a.getNextFieldNumber(aVar4))) {
                        }
                        fsVar.vHC = emotionPrice;
                    }
                    AppMethodBeat.o(62509);
                    return 0;
                case 3:
                    fsVar.vBa = aVar3.BTU.readString();
                    AppMethodBeat.o(62509);
                    return 0;
                default:
                    AppMethodBeat.o(62509);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62509);
            return -1;
        }
    }
}
