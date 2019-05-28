package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class asn extends a {
    public b wvY;
    public int wvZ;
    public LinkedList<asp> wwa = new LinkedList();
    public LinkedList<Integer> wwb = new LinkedList();

    public asn() {
        AppMethodBeat.i(5214);
        AppMethodBeat.o(5214);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5215);
        e.a.a.b bVar;
        int b;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wvY == null) {
                bVar = new e.a.a.b("Not all required fields were included: RawBuf");
                AppMethodBeat.o(5215);
                throw bVar;
            }
            if (this.wvY != null) {
                aVar.c(1, this.wvY);
            }
            aVar.iz(2, this.wvZ);
            aVar.e(3, 8, this.wwa);
            aVar.e(4, 2, this.wwb);
            AppMethodBeat.o(5215);
            return 0;
        } else if (i == 1) {
            if (this.wvY != null) {
                b = e.a.a.b.b.a.b(1, this.wvY) + 0;
            } else {
                b = 0;
            }
            int bs = ((b + e.a.a.b.b.a.bs(2, this.wvZ)) + e.a.a.a.c(3, 8, this.wwa)) + e.a.a.a.c(4, 2, this.wwb);
            AppMethodBeat.o(5215);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wwa.clear();
            this.wwb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            if (this.wvY == null) {
                bVar = new e.a.a.b("Not all required fields were included: RawBuf");
                AppMethodBeat.o(5215);
                throw bVar;
            }
            AppMethodBeat.o(5215);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asn asn = (asn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    asn.wvY = aVar3.BTU.emu();
                    AppMethodBeat.o(5215);
                    return 0;
                case 2:
                    asn.wvZ = aVar3.BTU.vd();
                    AppMethodBeat.o(5215);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asp asp = new asp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = asp.populateBuilderWithField(aVar4, asp, a.getNextFieldNumber(aVar4))) {
                        }
                        asn.wwa.add(asp);
                    }
                    AppMethodBeat.o(5215);
                    return 0;
                case 4:
                    asn.wwb.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(5215);
                    return 0;
                default:
                    AppMethodBeat.o(5215);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5215);
            return -1;
        }
    }
}
