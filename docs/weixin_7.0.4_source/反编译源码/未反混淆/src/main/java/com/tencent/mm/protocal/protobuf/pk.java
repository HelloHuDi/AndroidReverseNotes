package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pk extends bsr {
    public int nUf;
    public String vFb;
    public String vFc;
    public String vWF;
    public String vWG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56758);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vFb == null) {
                bVar = new b("Not all required fields were included: f2f_id");
                AppMethodBeat.o(56758);
                throw bVar;
            } else if (this.vFc == null) {
                bVar = new b("Not all required fields were included: trans_id");
                AppMethodBeat.o(56758);
                throw bVar;
            } else if (this.vWG == null) {
                bVar = new b("Not all required fields were included: receiver_open_id");
                AppMethodBeat.o(56758);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.vFb != null) {
                    aVar.e(2, this.vFb);
                }
                if (this.vFc != null) {
                    aVar.e(3, this.vFc);
                }
                if (this.vWF != null) {
                    aVar.e(4, this.vWF);
                }
                if (this.vWG != null) {
                    aVar.e(5, this.vWG);
                }
                aVar.iz(6, this.nUf);
                AppMethodBeat.o(56758);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFb != null) {
                ix += e.a.a.b.b.a.f(2, this.vFb);
            }
            if (this.vFc != null) {
                ix += e.a.a.b.b.a.f(3, this.vFc);
            }
            if (this.vWF != null) {
                ix += e.a.a.b.b.a.f(4, this.vWF);
            }
            if (this.vWG != null) {
                ix += e.a.a.b.b.a.f(5, this.vWG);
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.nUf);
            AppMethodBeat.o(56758);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vFb == null) {
                bVar = new b("Not all required fields were included: f2f_id");
                AppMethodBeat.o(56758);
                throw bVar;
            } else if (this.vFc == null) {
                bVar = new b("Not all required fields were included: trans_id");
                AppMethodBeat.o(56758);
                throw bVar;
            } else if (this.vWG == null) {
                bVar = new b("Not all required fields were included: receiver_open_id");
                AppMethodBeat.o(56758);
                throw bVar;
            } else {
                AppMethodBeat.o(56758);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pk pkVar = (pk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        pkVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56758);
                    return 0;
                case 2:
                    pkVar.vFb = aVar3.BTU.readString();
                    AppMethodBeat.o(56758);
                    return 0;
                case 3:
                    pkVar.vFc = aVar3.BTU.readString();
                    AppMethodBeat.o(56758);
                    return 0;
                case 4:
                    pkVar.vWF = aVar3.BTU.readString();
                    AppMethodBeat.o(56758);
                    return 0;
                case 5:
                    pkVar.vWG = aVar3.BTU.readString();
                    AppMethodBeat.o(56758);
                    return 0;
                case 6:
                    pkVar.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(56758);
                    return 0;
                default:
                    AppMethodBeat.o(56758);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56758);
            return -1;
        }
    }
}
