package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bwr extends a {
    public String cvZ;
    public String eyr;
    public int fVJ;
    public int fXd;
    public int fgI;
    public int fgJ;
    public String qQm;
    public String url;
    public LinkedList<chk> wXc = new LinkedList();
    public int wXd;

    public bwr() {
        AppMethodBeat.i(51002);
        AppMethodBeat.o(51002);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51003);
        b bVar;
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.qQm == null) {
                bVar = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(51003);
                throw bVar;
            }
            aVar.e(1, 8, this.wXc);
            if (this.qQm != null) {
                aVar.e(2, this.qQm);
            }
            if (this.cvZ != null) {
                aVar.e(3, this.cvZ);
            }
            if (this.eyr != null) {
                aVar.e(4, this.eyr);
            }
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.iz(6, this.fXd);
            aVar.iz(7, this.fVJ);
            aVar.iz(8, this.wXd);
            aVar.iz(9, this.fgI);
            aVar.iz(10, this.fgJ);
            AppMethodBeat.o(51003);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wXc) + 0;
            if (this.qQm != null) {
                c += e.a.a.b.b.a.f(2, this.qQm);
            }
            if (this.cvZ != null) {
                c += e.a.a.b.b.a.f(3, this.cvZ);
            }
            if (this.eyr != null) {
                c += e.a.a.b.b.a.f(4, this.eyr);
            }
            if (this.url != null) {
                c += e.a.a.b.b.a.f(5, this.url);
            }
            c = ((((c + e.a.a.b.b.a.bs(6, this.fXd)) + e.a.a.b.b.a.bs(7, this.fVJ)) + e.a.a.b.b.a.bs(8, this.wXd)) + e.a.a.b.b.a.bs(9, this.fgI)) + e.a.a.b.b.a.bs(10, this.fgJ);
            AppMethodBeat.o(51003);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wXc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            if (this.qQm == null) {
                bVar = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(51003);
                throw bVar;
            }
            AppMethodBeat.o(51003);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwr bwr = (bwr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chk chk = new chk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = chk.populateBuilderWithField(aVar4, chk, a.getNextFieldNumber(aVar4))) {
                        }
                        bwr.wXc.add(chk);
                    }
                    AppMethodBeat.o(51003);
                    return 0;
                case 2:
                    bwr.qQm = aVar3.BTU.readString();
                    AppMethodBeat.o(51003);
                    return 0;
                case 3:
                    bwr.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(51003);
                    return 0;
                case 4:
                    bwr.eyr = aVar3.BTU.readString();
                    AppMethodBeat.o(51003);
                    return 0;
                case 5:
                    bwr.url = aVar3.BTU.readString();
                    AppMethodBeat.o(51003);
                    return 0;
                case 6:
                    bwr.fXd = aVar3.BTU.vd();
                    AppMethodBeat.o(51003);
                    return 0;
                case 7:
                    bwr.fVJ = aVar3.BTU.vd();
                    AppMethodBeat.o(51003);
                    return 0;
                case 8:
                    bwr.wXd = aVar3.BTU.vd();
                    AppMethodBeat.o(51003);
                    return 0;
                case 9:
                    bwr.fgI = aVar3.BTU.vd();
                    AppMethodBeat.o(51003);
                    return 0;
                case 10:
                    bwr.fgJ = aVar3.BTU.vd();
                    AppMethodBeat.o(51003);
                    return 0;
                default:
                    AppMethodBeat.o(51003);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51003);
            return -1;
        }
    }
}
