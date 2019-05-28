package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bkj extends a {
    public String mZV;
    public cvr wNv;
    public cvu wNw;
    public cvn wNx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63690);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZV == null) {
                bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(63690);
                throw bVar;
            }
            if (this.mZV != null) {
                aVar.e(1, this.mZV);
            }
            if (this.wNv != null) {
                aVar.iy(2, this.wNv.computeSize());
                this.wNv.writeFields(aVar);
            }
            if (this.wNw != null) {
                aVar.iy(3, this.wNw.computeSize());
                this.wNw.writeFields(aVar);
            }
            if (this.wNx != null) {
                aVar.iy(4, this.wNx.computeSize());
                this.wNx.writeFields(aVar);
            }
            AppMethodBeat.o(63690);
            return 0;
        } else if (i == 1) {
            if (this.mZV != null) {
                f = e.a.a.b.b.a.f(1, this.mZV) + 0;
            } else {
                f = 0;
            }
            if (this.wNv != null) {
                f += e.a.a.a.ix(2, this.wNv.computeSize());
            }
            if (this.wNw != null) {
                f += e.a.a.a.ix(3, this.wNw.computeSize());
            }
            if (this.wNx != null) {
                f += e.a.a.a.ix(4, this.wNx.computeSize());
            }
            AppMethodBeat.o(63690);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.mZV == null) {
                bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(63690);
                throw bVar;
            }
            AppMethodBeat.o(63690);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkj bkj = (bkj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bkj.mZV = aVar3.BTU.readString();
                    AppMethodBeat.o(63690);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvr cvr = new cvr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvr.populateBuilderWithField(aVar4, cvr, a.getNextFieldNumber(aVar4))) {
                        }
                        bkj.wNv = cvr;
                    }
                    AppMethodBeat.o(63690);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvu cvu = new cvu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvu.populateBuilderWithField(aVar4, cvu, a.getNextFieldNumber(aVar4))) {
                        }
                        bkj.wNw = cvu;
                    }
                    AppMethodBeat.o(63690);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvn cvn = new cvn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvn.populateBuilderWithField(aVar4, cvn, a.getNextFieldNumber(aVar4))) {
                        }
                        bkj.wNx = cvn;
                    }
                    AppMethodBeat.o(63690);
                    return 0;
                default:
                    AppMethodBeat.o(63690);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63690);
            return -1;
        }
    }
}
