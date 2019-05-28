package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class n extends a {
    public String ID;
    public long jBL;
    public long jBM;
    public long jBN;
    public m jBO;
    public long jBP;
    public int jBQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18061);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18061);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.ai(2, this.jBL);
            aVar.ai(3, this.jBM);
            aVar.ai(4, this.jBN);
            if (this.jBO != null) {
                aVar.iy(5, this.jBO.computeSize());
                this.jBO.writeFields(aVar);
            }
            aVar.ai(6, this.jBP);
            aVar.iz(7, this.jBQ);
            AppMethodBeat.o(18061);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                f = e.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                f = 0;
            }
            f = ((f + e.a.a.b.b.a.o(2, this.jBL)) + e.a.a.b.b.a.o(3, this.jBM)) + e.a.a.b.b.a.o(4, this.jBN);
            if (this.jBO != null) {
                f += e.a.a.a.ix(5, this.jBO.computeSize());
            }
            int o = (f + e.a.a.b.b.a.o(6, this.jBP)) + e.a.a.b.b.a.bs(7, this.jBQ);
            AppMethodBeat.o(18061);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18061);
                throw bVar;
            }
            AppMethodBeat.o(18061);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(18061);
                    return 0;
                case 2:
                    nVar.jBL = aVar3.BTU.ve();
                    AppMethodBeat.o(18061);
                    return 0;
                case 3:
                    nVar.jBM = aVar3.BTU.ve();
                    AppMethodBeat.o(18061);
                    return 0;
                case 4:
                    nVar.jBN = aVar3.BTU.ve();
                    AppMethodBeat.o(18061);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        m mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nVar.jBO = mVar;
                    }
                    AppMethodBeat.o(18061);
                    return 0;
                case 6:
                    nVar.jBP = aVar3.BTU.ve();
                    AppMethodBeat.o(18061);
                    return 0;
                case 7:
                    nVar.jBQ = aVar3.BTU.vd();
                    AppMethodBeat.o(18061);
                    return 0;
                default:
                    AppMethodBeat.o(18061);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18061);
            return -1;
        }
    }
}
