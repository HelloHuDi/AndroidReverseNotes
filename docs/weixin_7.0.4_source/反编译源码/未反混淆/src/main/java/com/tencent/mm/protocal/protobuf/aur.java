package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class aur extends a {
    public String wyN;
    public String wyO;
    public wx wyP;
    public wx wyQ;
    public String wyR;
    public String wyS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48876);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyN != null) {
                aVar.e(1, this.wyN);
            }
            if (this.wyO != null) {
                aVar.e(2, this.wyO);
            }
            if (this.wyP != null) {
                aVar.iy(3, this.wyP.computeSize());
                this.wyP.writeFields(aVar);
            }
            if (this.wyQ != null) {
                aVar.iy(4, this.wyQ.computeSize());
                this.wyQ.writeFields(aVar);
            }
            if (this.wyR != null) {
                aVar.e(5, this.wyR);
            }
            if (this.wyS != null) {
                aVar.e(6, this.wyS);
            }
            AppMethodBeat.o(48876);
            return 0;
        } else if (i == 1) {
            if (this.wyN != null) {
                f = e.a.a.b.b.a.f(1, this.wyN) + 0;
            } else {
                f = 0;
            }
            if (this.wyO != null) {
                f += e.a.a.b.b.a.f(2, this.wyO);
            }
            if (this.wyP != null) {
                f += e.a.a.a.ix(3, this.wyP.computeSize());
            }
            if (this.wyQ != null) {
                f += e.a.a.a.ix(4, this.wyQ.computeSize());
            }
            if (this.wyR != null) {
                f += e.a.a.b.b.a.f(5, this.wyR);
            }
            if (this.wyS != null) {
                f += e.a.a.b.b.a.f(6, this.wyS);
            }
            AppMethodBeat.o(48876);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48876);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aur aur = (aur) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            wx wxVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    aur.wyN = aVar3.BTU.readString();
                    AppMethodBeat.o(48876);
                    return 0;
                case 2:
                    aur.wyO = aVar3.BTU.readString();
                    AppMethodBeat.o(48876);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        wxVar = new wx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wxVar.populateBuilderWithField(aVar4, wxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aur.wyP = wxVar;
                    }
                    AppMethodBeat.o(48876);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        wxVar = new wx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wxVar.populateBuilderWithField(aVar4, wxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        aur.wyQ = wxVar;
                    }
                    AppMethodBeat.o(48876);
                    return 0;
                case 5:
                    aur.wyR = aVar3.BTU.readString();
                    AppMethodBeat.o(48876);
                    return 0;
                case 6:
                    aur.wyS = aVar3.BTU.readString();
                    AppMethodBeat.o(48876);
                    return 0;
                default:
                    AppMethodBeat.o(48876);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48876);
            return -1;
        }
    }
}
