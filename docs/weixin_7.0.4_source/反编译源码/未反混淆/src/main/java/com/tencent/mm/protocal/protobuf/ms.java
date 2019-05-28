package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ms extends a {
    public int kdC;
    public int state;
    public String text;
    public btr vCP;
    public String vJS;
    public int vQJ;
    public auj vQK;
    public ta vQL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48784);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.state);
            if (this.vCP != null) {
                aVar.iy(2, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            aVar.iz(3, this.vQJ);
            if (this.vQK != null) {
                aVar.iy(4, this.vQK.computeSize());
                this.vQK.writeFields(aVar);
            }
            if (this.text != null) {
                aVar.e(5, this.text);
            }
            if (this.vJS != null) {
                aVar.e(6, this.vJS);
            }
            aVar.iz(7, this.kdC);
            if (this.vQL != null) {
                aVar.iy(8, this.vQL.computeSize());
                this.vQL.writeFields(aVar);
            }
            AppMethodBeat.o(48784);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.state) + 0;
            if (this.vCP != null) {
                bs += e.a.a.a.ix(2, this.vCP.computeSize());
            }
            bs += e.a.a.b.b.a.bs(3, this.vQJ);
            if (this.vQK != null) {
                bs += e.a.a.a.ix(4, this.vQK.computeSize());
            }
            if (this.text != null) {
                bs += e.a.a.b.b.a.f(5, this.text);
            }
            if (this.vJS != null) {
                bs += e.a.a.b.b.a.f(6, this.vJS);
            }
            bs += e.a.a.b.b.a.bs(7, this.kdC);
            if (this.vQL != null) {
                bs += e.a.a.a.ix(8, this.vQL.computeSize());
            }
            AppMethodBeat.o(48784);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48784);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ms msVar = (ms) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    msVar.state = aVar3.BTU.vd();
                    AppMethodBeat.o(48784);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(aVar4, btr, a.getNextFieldNumber(aVar4))) {
                        }
                        msVar.vCP = btr;
                    }
                    AppMethodBeat.o(48784);
                    return 0;
                case 3:
                    msVar.vQJ = aVar3.BTU.vd();
                    AppMethodBeat.o(48784);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj auj = new auj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(aVar4, auj, a.getNextFieldNumber(aVar4))) {
                        }
                        msVar.vQK = auj;
                    }
                    AppMethodBeat.o(48784);
                    return 0;
                case 5:
                    msVar.text = aVar3.BTU.readString();
                    AppMethodBeat.o(48784);
                    return 0;
                case 6:
                    msVar.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48784);
                    return 0;
                case 7:
                    msVar.kdC = aVar3.BTU.vd();
                    AppMethodBeat.o(48784);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ta taVar = new ta();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = taVar.populateBuilderWithField(aVar4, taVar, a.getNextFieldNumber(aVar4))) {
                        }
                        msVar.vQL = taVar;
                    }
                    AppMethodBeat.o(48784);
                    return 0;
                default:
                    AppMethodBeat.o(48784);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48784);
            return -1;
        }
    }
}
