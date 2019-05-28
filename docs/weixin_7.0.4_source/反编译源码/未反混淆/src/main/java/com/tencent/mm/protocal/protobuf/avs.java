package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avs extends bsr {
    public String csB;
    public String cvO;
    public String signature;
    public String url;
    public String wzd;
    public String wzf;
    public String wzg;
    public b wzh;
    public int wzi;
    public LinkedList<awg> wzm = new LinkedList();

    public avs() {
        AppMethodBeat.i(10209);
        AppMethodBeat.o(10209);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10210);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.csB != null) {
                aVar.e(3, this.csB);
            }
            if (this.wzd != null) {
                aVar.e(4, this.wzd);
            }
            if (this.cvO != null) {
                aVar.e(5, this.cvO);
            }
            if (this.wzf != null) {
                aVar.e(6, this.wzf);
            }
            if (this.signature != null) {
                aVar.e(7, this.signature);
            }
            if (this.wzg != null) {
                aVar.e(8, this.wzg);
            }
            if (this.wzh != null) {
                aVar.c(9, this.wzh);
            }
            aVar.iz(10, this.wzi);
            aVar.e(11, 8, this.wzm);
            AppMethodBeat.o(10210);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(3, this.csB);
            }
            if (this.wzd != null) {
                ix += e.a.a.b.b.a.f(4, this.wzd);
            }
            if (this.cvO != null) {
                ix += e.a.a.b.b.a.f(5, this.cvO);
            }
            if (this.wzf != null) {
                ix += e.a.a.b.b.a.f(6, this.wzf);
            }
            if (this.signature != null) {
                ix += e.a.a.b.b.a.f(7, this.signature);
            }
            if (this.wzg != null) {
                ix += e.a.a.b.b.a.f(8, this.wzg);
            }
            if (this.wzh != null) {
                ix += e.a.a.b.b.a.b(9, this.wzh);
            }
            int bs = (ix + e.a.a.b.b.a.bs(10, this.wzi)) + e.a.a.a.c(11, 8, this.wzm);
            AppMethodBeat.o(10210);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10210);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avs avs = (avs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        avs.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(10210);
                    return 0;
                case 2:
                    avs.url = aVar3.BTU.readString();
                    AppMethodBeat.o(10210);
                    return 0;
                case 3:
                    avs.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(10210);
                    return 0;
                case 4:
                    avs.wzd = aVar3.BTU.readString();
                    AppMethodBeat.o(10210);
                    return 0;
                case 5:
                    avs.cvO = aVar3.BTU.readString();
                    AppMethodBeat.o(10210);
                    return 0;
                case 6:
                    avs.wzf = aVar3.BTU.readString();
                    AppMethodBeat.o(10210);
                    return 0;
                case 7:
                    avs.signature = aVar3.BTU.readString();
                    AppMethodBeat.o(10210);
                    return 0;
                case 8:
                    avs.wzg = aVar3.BTU.readString();
                    AppMethodBeat.o(10210);
                    return 0;
                case 9:
                    avs.wzh = aVar3.BTU.emu();
                    AppMethodBeat.o(10210);
                    return 0;
                case 10:
                    avs.wzi = aVar3.BTU.vd();
                    AppMethodBeat.o(10210);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awg awg = new awg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awg.populateBuilderWithField(aVar4, awg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avs.wzm.add(awg);
                    }
                    AppMethodBeat.o(10210);
                    return 0;
                default:
                    AppMethodBeat.o(10210);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10210);
            return -1;
        }
    }
}
