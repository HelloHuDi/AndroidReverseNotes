package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class uv extends bsr {
    public String Name;
    public int jBv;
    public String wcl;
    public String wcm;
    public axx wcn;
    public LinkedList<bts> wco = new LinkedList();
    public String wcp;
    public String wcq;

    public uv() {
        AppMethodBeat.i(28377);
        AppMethodBeat.o(28377);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28378);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wcn == null) {
                bVar = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(28378);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.wcl != null) {
                aVar.e(3, this.wcl);
            }
            if (this.wcm != null) {
                aVar.e(4, this.wcm);
            }
            if (this.wcn != null) {
                aVar.iy(5, this.wcn.computeSize());
                this.wcn.writeFields(aVar);
            }
            aVar.iz(6, this.jBv);
            aVar.e(7, 8, this.wco);
            if (this.wcp != null) {
                aVar.e(8, this.wcp);
            }
            if (this.wcq != null) {
                aVar.e(9, this.wcq);
            }
            AppMethodBeat.o(28378);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.Name != null) {
                ix += e.a.a.b.b.a.f(2, this.Name);
            }
            if (this.wcl != null) {
                ix += e.a.a.b.b.a.f(3, this.wcl);
            }
            if (this.wcm != null) {
                ix += e.a.a.b.b.a.f(4, this.wcm);
            }
            if (this.wcn != null) {
                ix += e.a.a.a.ix(5, this.wcn.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.jBv)) + e.a.a.a.c(7, 8, this.wco);
            if (this.wcp != null) {
                ix += e.a.a.b.b.a.f(8, this.wcp);
            }
            if (this.wcq != null) {
                ix += e.a.a.b.b.a.f(9, this.wcq);
            }
            AppMethodBeat.o(28378);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wco.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcn == null) {
                bVar = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(28378);
                throw bVar;
            }
            AppMethodBeat.o(28378);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            uv uvVar = (uv) objArr[1];
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
                        uvVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28378);
                    return 0;
                case 2:
                    uvVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(28378);
                    return 0;
                case 3:
                    uvVar.wcl = aVar3.BTU.readString();
                    AppMethodBeat.o(28378);
                    return 0;
                case 4:
                    uvVar.wcm = aVar3.BTU.readString();
                    AppMethodBeat.o(28378);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axx axx = new axx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axx.populateBuilderWithField(aVar4, axx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        uvVar.wcn = axx;
                    }
                    AppMethodBeat.o(28378);
                    return 0;
                case 6:
                    uvVar.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(28378);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        uvVar.wco.add(bts);
                    }
                    AppMethodBeat.o(28378);
                    return 0;
                case 8:
                    uvVar.wcp = aVar3.BTU.readString();
                    AppMethodBeat.o(28378);
                    return 0;
                case 9:
                    uvVar.wcq = aVar3.BTU.readString();
                    AppMethodBeat.o(28378);
                    return 0;
                default:
                    AppMethodBeat.o(28378);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28378);
            return -1;
        }
    }
}
