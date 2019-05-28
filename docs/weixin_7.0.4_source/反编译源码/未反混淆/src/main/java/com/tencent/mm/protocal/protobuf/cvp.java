package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cvp extends a {
    public String Md5;
    public String vMJ;
    public int xrE;
    public int xrF;
    public cvs xrG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63696);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Md5 == null) {
                bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(63696);
                throw bVar;
            } else if (this.vMJ == null) {
                bVar = new b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.o(63696);
                throw bVar;
            } else {
                if (this.Md5 != null) {
                    aVar.e(1, this.Md5);
                }
                if (this.vMJ != null) {
                    aVar.e(2, this.vMJ);
                }
                aVar.iz(3, this.xrE);
                aVar.iz(4, this.xrF);
                if (this.xrG != null) {
                    aVar.iy(5, this.xrG.computeSize());
                    this.xrG.writeFields(aVar);
                }
                AppMethodBeat.o(63696);
                return 0;
            }
        } else if (i == 1) {
            if (this.Md5 != null) {
                f = e.a.a.b.b.a.f(1, this.Md5) + 0;
            } else {
                f = 0;
            }
            if (this.vMJ != null) {
                f += e.a.a.b.b.a.f(2, this.vMJ);
            }
            f = (f + e.a.a.b.b.a.bs(3, this.xrE)) + e.a.a.b.b.a.bs(4, this.xrF);
            if (this.xrG != null) {
                f += e.a.a.a.ix(5, this.xrG.computeSize());
            }
            AppMethodBeat.o(63696);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Md5 == null) {
                bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(63696);
                throw bVar;
            } else if (this.vMJ == null) {
                bVar = new b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.o(63696);
                throw bVar;
            } else {
                AppMethodBeat.o(63696);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvp cvp = (cvp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cvp.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(63696);
                    return 0;
                case 2:
                    cvp.vMJ = aVar3.BTU.readString();
                    AppMethodBeat.o(63696);
                    return 0;
                case 3:
                    cvp.xrE = aVar3.BTU.vd();
                    AppMethodBeat.o(63696);
                    return 0;
                case 4:
                    cvp.xrF = aVar3.BTU.vd();
                    AppMethodBeat.o(63696);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cvs cvs = new cvs();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cvs.populateBuilderWithField(aVar4, cvs, a.getNextFieldNumber(aVar4))) {
                        }
                        cvp.xrG = cvs;
                    }
                    AppMethodBeat.o(63696);
                    return 0;
                default:
                    AppMethodBeat.o(63696);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63696);
            return -1;
        }
    }
}
