package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class g extends a {
    public String BTP;
    public String BTQ;
    public String BTR;
    public String BTS;
    public String BTT;
    public String pia;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57012);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pia != null) {
                aVar.e(1, this.pia);
            }
            if (this.BTP != null) {
                aVar.e(2, this.BTP);
            }
            if (this.BTQ != null) {
                aVar.e(3, this.BTQ);
            }
            if (this.BTR != null) {
                aVar.e(4, this.BTR);
            }
            if (this.BTS != null) {
                aVar.e(5, this.BTS);
            }
            if (this.BTT != null) {
                aVar.e(6, this.BTT);
            }
            AppMethodBeat.o(57012);
            return 0;
        } else if (i == 1) {
            if (this.pia != null) {
                f = e.a.a.b.b.a.f(1, this.pia) + 0;
            } else {
                f = 0;
            }
            if (this.BTP != null) {
                f += e.a.a.b.b.a.f(2, this.BTP);
            }
            if (this.BTQ != null) {
                f += e.a.a.b.b.a.f(3, this.BTQ);
            }
            if (this.BTR != null) {
                f += e.a.a.b.b.a.f(4, this.BTR);
            }
            if (this.BTS != null) {
                f += e.a.a.b.b.a.f(5, this.BTS);
            }
            if (this.BTT != null) {
                f += e.a.a.b.b.a.f(6, this.BTT);
            }
            AppMethodBeat.o(57012);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(57012);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.pia = aVar3.BTU.readString();
                    AppMethodBeat.o(57012);
                    return 0;
                case 2:
                    gVar.BTP = aVar3.BTU.readString();
                    AppMethodBeat.o(57012);
                    return 0;
                case 3:
                    gVar.BTQ = aVar3.BTU.readString();
                    AppMethodBeat.o(57012);
                    return 0;
                case 4:
                    gVar.BTR = aVar3.BTU.readString();
                    AppMethodBeat.o(57012);
                    return 0;
                case 5:
                    gVar.BTS = aVar3.BTU.readString();
                    AppMethodBeat.o(57012);
                    return 0;
                case 6:
                    gVar.BTT = aVar3.BTU.readString();
                    AppMethodBeat.o(57012);
                    return 0;
                default:
                    AppMethodBeat.o(57012);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57012);
            return -1;
        }
    }
}
