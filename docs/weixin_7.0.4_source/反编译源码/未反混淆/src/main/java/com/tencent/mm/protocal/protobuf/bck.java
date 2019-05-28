package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bck extends a {
    public String wGA;
    public bkg wGw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28555);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wGA == null) {
                bVar = new b("Not all required fields were included: ContactUsername");
                AppMethodBeat.o(28555);
                throw bVar;
            } else if (this.wGw == null) {
                bVar = new b("Not all required fields were included: PhoneNumListInfo");
                AppMethodBeat.o(28555);
                throw bVar;
            } else {
                if (this.wGA != null) {
                    aVar.e(1, this.wGA);
                }
                if (this.wGw != null) {
                    aVar.iy(2, this.wGw.computeSize());
                    this.wGw.writeFields(aVar);
                }
                AppMethodBeat.o(28555);
                return 0;
            }
        } else if (i == 1) {
            if (this.wGA != null) {
                f = e.a.a.b.b.a.f(1, this.wGA) + 0;
            } else {
                f = 0;
            }
            if (this.wGw != null) {
                f += e.a.a.a.ix(2, this.wGw.computeSize());
            }
            AppMethodBeat.o(28555);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wGA == null) {
                bVar = new b("Not all required fields were included: ContactUsername");
                AppMethodBeat.o(28555);
                throw bVar;
            } else if (this.wGw == null) {
                bVar = new b("Not all required fields were included: PhoneNumListInfo");
                AppMethodBeat.o(28555);
                throw bVar;
            } else {
                AppMethodBeat.o(28555);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bck bck = (bck) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bck.wGA = aVar3.BTU.readString();
                    AppMethodBeat.o(28555);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bkg bkg = new bkg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bkg.populateBuilderWithField(aVar4, bkg, a.getNextFieldNumber(aVar4))) {
                        }
                        bck.wGw = bkg;
                    }
                    AppMethodBeat.o(28555);
                    return 0;
                default:
                    AppMethodBeat.o(28555);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28555);
            return -1;
        }
    }
}
