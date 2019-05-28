package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aer extends bsr {
    public String appId;
    public String cvO;
    public String mwU;
    public String mwV;
    public String mwW;
    public String sign;
    public String vAN;
    public int vAO;
    public dh wmv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28415);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            if (this.mwU != null) {
                aVar.e(3, this.mwU);
            }
            if (this.mwV != null) {
                aVar.e(4, this.mwV);
            }
            if (this.mwW != null) {
                aVar.e(5, this.mwW);
            }
            if (this.cvO != null) {
                aVar.e(6, this.cvO);
            }
            if (this.sign != null) {
                aVar.e(7, this.sign);
            }
            if (this.wmv != null) {
                aVar.iy(8, this.wmv.computeSize());
                this.wmv.writeFields(aVar);
            }
            if (this.vAN != null) {
                aVar.e(9, this.vAN);
            }
            aVar.iz(10, this.vAO);
            AppMethodBeat.o(28415);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.appId != null) {
                ix += e.a.a.b.b.a.f(2, this.appId);
            }
            if (this.mwU != null) {
                ix += e.a.a.b.b.a.f(3, this.mwU);
            }
            if (this.mwV != null) {
                ix += e.a.a.b.b.a.f(4, this.mwV);
            }
            if (this.mwW != null) {
                ix += e.a.a.b.b.a.f(5, this.mwW);
            }
            if (this.cvO != null) {
                ix += e.a.a.b.b.a.f(6, this.cvO);
            }
            if (this.sign != null) {
                ix += e.a.a.b.b.a.f(7, this.sign);
            }
            if (this.wmv != null) {
                ix += e.a.a.a.ix(8, this.wmv.computeSize());
            }
            if (this.vAN != null) {
                ix += e.a.a.b.b.a.f(9, this.vAN);
            }
            int bs = ix + e.a.a.b.b.a.bs(10, this.vAO);
            AppMethodBeat.o(28415);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28415);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aer aer = (aer) objArr[1];
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
                        aer.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28415);
                    return 0;
                case 2:
                    aer.appId = aVar3.BTU.readString();
                    AppMethodBeat.o(28415);
                    return 0;
                case 3:
                    aer.mwU = aVar3.BTU.readString();
                    AppMethodBeat.o(28415);
                    return 0;
                case 4:
                    aer.mwV = aVar3.BTU.readString();
                    AppMethodBeat.o(28415);
                    return 0;
                case 5:
                    aer.mwW = aVar3.BTU.readString();
                    AppMethodBeat.o(28415);
                    return 0;
                case 6:
                    aer.cvO = aVar3.BTU.readString();
                    AppMethodBeat.o(28415);
                    return 0;
                case 7:
                    aer.sign = aVar3.BTU.readString();
                    AppMethodBeat.o(28415);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dh dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.populateBuilderWithField(aVar4, dhVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aer.wmv = dhVar;
                    }
                    AppMethodBeat.o(28415);
                    return 0;
                case 9:
                    aer.vAN = aVar3.BTU.readString();
                    AppMethodBeat.o(28415);
                    return 0;
                case 10:
                    aer.vAO = aVar3.BTU.vd();
                    AppMethodBeat.o(28415);
                    return 0;
                default:
                    AppMethodBeat.o(28415);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28415);
            return -1;
        }
    }
}
