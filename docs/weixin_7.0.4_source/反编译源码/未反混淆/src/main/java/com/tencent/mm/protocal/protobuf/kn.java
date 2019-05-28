package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class kn extends bsr {
    public String ProductID;
    public int Scene;
    public LinkedList<String> vNF = new LinkedList();
    public String vNG;
    public double vNH;
    public double vNI;

    public kn() {
        AppMethodBeat.i(11711);
        AppMethodBeat.o(11711);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11712);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ProductID != null) {
                aVar.e(2, this.ProductID);
            }
            aVar.e(3, 1, this.vNF);
            aVar.iz(4, this.Scene);
            if (this.vNG != null) {
                aVar.e(5, this.vNG);
            }
            aVar.f(6, this.vNH);
            aVar.f(7, this.vNI);
            AppMethodBeat.o(11712);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ProductID != null) {
                ix += e.a.a.b.b.a.f(2, this.ProductID);
            }
            ix = (ix + e.a.a.a.c(3, 1, this.vNF)) + e.a.a.b.b.a.bs(4, this.Scene);
            if (this.vNG != null) {
                ix += e.a.a.b.b.a.f(5, this.vNG);
            }
            int fv = (ix + (e.a.a.b.b.a.fv(6) + 8)) + (e.a.a.b.b.a.fv(7) + 8);
            AppMethodBeat.o(11712);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNF.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11712);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kn knVar = (kn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        knVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11712);
                    return 0;
                case 2:
                    knVar.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(11712);
                    return 0;
                case 3:
                    knVar.vNF.add(aVar3.BTU.readString());
                    AppMethodBeat.o(11712);
                    return 0;
                case 4:
                    knVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(11712);
                    return 0;
                case 5:
                    knVar.vNG = aVar3.BTU.readString();
                    AppMethodBeat.o(11712);
                    return 0;
                case 6:
                    knVar.vNH = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(11712);
                    return 0;
                case 7:
                    knVar.vNI = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(11712);
                    return 0;
                default:
                    AppMethodBeat.o(11712);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11712);
            return -1;
        }
    }
}
