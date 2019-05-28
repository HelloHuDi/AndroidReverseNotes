package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lf extends bsr {
    public int vAM;
    public String vAN;
    public String vMR;
    public ayu vOK;
    public buc vOL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28345);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vMR != null) {
                aVar.e(2, this.vMR);
            }
            if (this.vOK != null) {
                aVar.iy(3, this.vOK.computeSize());
                this.vOK.writeFields(aVar);
            }
            if (this.vOL != null) {
                aVar.iy(4, this.vOL.computeSize());
                this.vOL.writeFields(aVar);
            }
            aVar.iz(5, this.vAM);
            if (this.vAN != null) {
                aVar.e(6, this.vAN);
            }
            AppMethodBeat.o(28345);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vMR != null) {
                ix += e.a.a.b.b.a.f(2, this.vMR);
            }
            if (this.vOK != null) {
                ix += e.a.a.a.ix(3, this.vOK.computeSize());
            }
            if (this.vOL != null) {
                ix += e.a.a.a.ix(4, this.vOL.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.vAM);
            if (this.vAN != null) {
                ix += e.a.a.b.b.a.f(6, this.vAN);
            }
            AppMethodBeat.o(28345);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28345);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lf lfVar = (lf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        lfVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28345);
                    return 0;
                case 2:
                    lfVar.vMR = aVar3.BTU.readString();
                    AppMethodBeat.o(28345);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayu ayu = new ayu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayu.populateBuilderWithField(aVar4, ayu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        lfVar.vOK = ayu;
                    }
                    AppMethodBeat.o(28345);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buc buc = new buc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buc.populateBuilderWithField(aVar4, buc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        lfVar.vOL = buc;
                    }
                    AppMethodBeat.o(28345);
                    return 0;
                case 5:
                    lfVar.vAM = aVar3.BTU.vd();
                    AppMethodBeat.o(28345);
                    return 0;
                case 6:
                    lfVar.vAN = aVar3.BTU.readString();
                    AppMethodBeat.o(28345);
                    return 0;
                default:
                    AppMethodBeat.o(28345);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28345);
            return -1;
        }
    }
}
