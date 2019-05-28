package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cjl extends bsr {
    public String vMV;
    public String vNb;
    public kg xig;
    public kg xih;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11820);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vNb == null) {
                bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(11820);
                throw bVar;
            } else if (this.vMV == null) {
                bVar = new b("Not all required fields were included: bizchat_id");
                AppMethodBeat.o(11820);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.vNb != null) {
                    aVar.e(2, this.vNb);
                }
                if (this.vMV != null) {
                    aVar.e(3, this.vMV);
                }
                if (this.xig != null) {
                    aVar.iy(4, this.xig.computeSize());
                    this.xig.writeFields(aVar);
                }
                if (this.xih != null) {
                    aVar.iy(5, this.xih.computeSize());
                    this.xih.writeFields(aVar);
                }
                AppMethodBeat.o(11820);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vNb != null) {
                ix += e.a.a.b.b.a.f(2, this.vNb);
            }
            if (this.vMV != null) {
                ix += e.a.a.b.b.a.f(3, this.vMV);
            }
            if (this.xig != null) {
                ix += e.a.a.a.ix(4, this.xig.computeSize());
            }
            if (this.xih != null) {
                ix += e.a.a.a.ix(5, this.xih.computeSize());
            }
            AppMethodBeat.o(11820);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vNb == null) {
                bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(11820);
                throw bVar;
            } else if (this.vMV == null) {
                bVar = new b("Not all required fields were included: bizchat_id");
                AppMethodBeat.o(11820);
                throw bVar;
            } else {
                AppMethodBeat.o(11820);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cjl cjl = (cjl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            kg kgVar;
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
                        cjl.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11820);
                    return 0;
                case 2:
                    cjl.vNb = aVar3.BTU.readString();
                    AppMethodBeat.o(11820);
                    return 0;
                case 3:
                    cjl.vMV = aVar3.BTU.readString();
                    AppMethodBeat.o(11820);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        kgVar = new kg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kgVar.populateBuilderWithField(aVar4, kgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cjl.xig = kgVar;
                    }
                    AppMethodBeat.o(11820);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        kgVar = new kg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kgVar.populateBuilderWithField(aVar4, kgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cjl.xih = kgVar;
                    }
                    AppMethodBeat.o(11820);
                    return 0;
                default:
                    AppMethodBeat.o(11820);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11820);
            return -1;
        }
    }
}
