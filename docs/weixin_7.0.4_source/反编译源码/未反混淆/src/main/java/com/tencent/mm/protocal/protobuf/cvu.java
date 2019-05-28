package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cvu extends a {
    public String Md5;
    public String vMJ;
    public String xql;
    public int xrE;
    public int xrF;
    public String xrK;
    public cvm xrL;
    public cvt xrM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63702);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xrK == null) {
                bVar = new b("Not all required fields were included: EntranceDomain");
                AppMethodBeat.o(63702);
                throw bVar;
            } else if (this.xql == null) {
                bVar = new b("Not all required fields were included: Charset");
                AppMethodBeat.o(63702);
                throw bVar;
            } else {
                if (this.xrK != null) {
                    aVar.e(4, this.xrK);
                }
                if (this.xql != null) {
                    aVar.e(12, this.xql);
                }
                if (this.xrL != null) {
                    aVar.iy(9, this.xrL.computeSize());
                    this.xrL.writeFields(aVar);
                }
                if (this.xrM != null) {
                    aVar.iy(10, this.xrM.computeSize());
                    this.xrM.writeFields(aVar);
                }
                if (this.Md5 != null) {
                    aVar.e(5, this.Md5);
                }
                if (this.vMJ != null) {
                    aVar.e(6, this.vMJ);
                }
                aVar.iz(7, this.xrE);
                aVar.iz(8, this.xrF);
                AppMethodBeat.o(63702);
                return 0;
            }
        } else if (i == 1) {
            if (this.xrK != null) {
                f = e.a.a.b.b.a.f(4, this.xrK) + 0;
            } else {
                f = 0;
            }
            if (this.xql != null) {
                f += e.a.a.b.b.a.f(12, this.xql);
            }
            if (this.xrL != null) {
                f += e.a.a.a.ix(9, this.xrL.computeSize());
            }
            if (this.xrM != null) {
                f += e.a.a.a.ix(10, this.xrM.computeSize());
            }
            if (this.Md5 != null) {
                f += e.a.a.b.b.a.f(5, this.Md5);
            }
            if (this.vMJ != null) {
                f += e.a.a.b.b.a.f(6, this.vMJ);
            }
            int bs = (f + e.a.a.b.b.a.bs(7, this.xrE)) + e.a.a.b.b.a.bs(8, this.xrF);
            AppMethodBeat.o(63702);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.xrK == null) {
                bVar = new b("Not all required fields were included: EntranceDomain");
                AppMethodBeat.o(63702);
                throw bVar;
            } else if (this.xql == null) {
                bVar = new b("Not all required fields were included: Charset");
                AppMethodBeat.o(63702);
                throw bVar;
            } else {
                AppMethodBeat.o(63702);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvu cvu = (cvu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 4:
                    cvu.xrK = aVar3.BTU.readString();
                    AppMethodBeat.o(63702);
                    return 0;
                case 5:
                    cvu.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(63702);
                    return 0;
                case 6:
                    cvu.vMJ = aVar3.BTU.readString();
                    AppMethodBeat.o(63702);
                    return 0;
                case 7:
                    cvu.xrE = aVar3.BTU.vd();
                    AppMethodBeat.o(63702);
                    return 0;
                case 8:
                    cvu.xrF = aVar3.BTU.vd();
                    AppMethodBeat.o(63702);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvm cvm = new cvm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvm.populateBuilderWithField(aVar4, cvm, a.getNextFieldNumber(aVar4))) {
                        }
                        cvu.xrL = cvm;
                    }
                    AppMethodBeat.o(63702);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvt cvt = new cvt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvt.populateBuilderWithField(aVar4, cvt, a.getNextFieldNumber(aVar4))) {
                        }
                        cvu.xrM = cvt;
                    }
                    AppMethodBeat.o(63702);
                    return 0;
                case 12:
                    cvu.xql = aVar3.BTU.readString();
                    AppMethodBeat.o(63702);
                    return 0;
                default:
                    AppMethodBeat.o(63702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63702);
            return -1;
        }
    }
}
