package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cjn extends bsr {
    public String vNb;
    public kd wku;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11822);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vNb == null) {
                bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(11822);
                throw bVar;
            } else if (this.wku == null) {
                bVar = new b("Not all required fields were included: chat");
                AppMethodBeat.o(11822);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.vNb != null) {
                    aVar.e(2, this.vNb);
                }
                if (this.wku != null) {
                    aVar.iy(3, this.wku.computeSize());
                    this.wku.writeFields(aVar);
                }
                AppMethodBeat.o(11822);
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
            if (this.wku != null) {
                ix += e.a.a.a.ix(3, this.wku.computeSize());
            }
            AppMethodBeat.o(11822);
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
                AppMethodBeat.o(11822);
                throw bVar;
            } else if (this.wku == null) {
                bVar = new b("Not all required fields were included: chat");
                AppMethodBeat.o(11822);
                throw bVar;
            } else {
                AppMethodBeat.o(11822);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cjn cjn = (cjn) objArr[1];
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
                        cjn.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11822);
                    return 0;
                case 2:
                    cjn.vNb = aVar3.BTU.readString();
                    AppMethodBeat.o(11822);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        kd kdVar = new kd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kdVar.populateBuilderWithField(aVar4, kdVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cjn.wku = kdVar;
                    }
                    AppMethodBeat.o(11822);
                    return 0;
                default:
                    AppMethodBeat.o(11822);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11822);
            return -1;
        }
    }
}
