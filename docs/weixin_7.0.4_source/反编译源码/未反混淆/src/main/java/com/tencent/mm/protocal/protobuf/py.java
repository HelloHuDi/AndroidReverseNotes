package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class py extends bsr {
    public String cBT;
    public String pPZ;
    public String pQe;
    public long pSg;
    public String vWF;
    public String vWY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48812);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.cBT == null) {
                bVar = new b("Not all required fields were included: req_key");
                AppMethodBeat.o(48812);
                throw bVar;
            } else if (this.vWY == null) {
                bVar = new b("Not all required fields were included: transfer_id");
                AppMethodBeat.o(48812);
                throw bVar;
            } else if (this.pQe == null) {
                bVar = new b("Not all required fields were included: transaction_id");
                AppMethodBeat.o(48812);
                throw bVar;
            } else if (this.pPZ == null) {
                bVar = new b("Not all required fields were included: receiver_openid");
                AppMethodBeat.o(48812);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.cBT != null) {
                    aVar.e(2, this.cBT);
                }
                if (this.vWY != null) {
                    aVar.e(3, this.vWY);
                }
                if (this.pQe != null) {
                    aVar.e(4, this.pQe);
                }
                if (this.pPZ != null) {
                    aVar.e(5, this.pPZ);
                }
                aVar.ai(6, this.pSg);
                if (this.vWF != null) {
                    aVar.e(7, this.vWF);
                }
                AppMethodBeat.o(48812);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.cBT != null) {
                ix += e.a.a.b.b.a.f(2, this.cBT);
            }
            if (this.vWY != null) {
                ix += e.a.a.b.b.a.f(3, this.vWY);
            }
            if (this.pQe != null) {
                ix += e.a.a.b.b.a.f(4, this.pQe);
            }
            if (this.pPZ != null) {
                ix += e.a.a.b.b.a.f(5, this.pPZ);
            }
            ix += e.a.a.b.b.a.o(6, this.pSg);
            if (this.vWF != null) {
                ix += e.a.a.b.b.a.f(7, this.vWF);
            }
            AppMethodBeat.o(48812);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.cBT == null) {
                bVar = new b("Not all required fields were included: req_key");
                AppMethodBeat.o(48812);
                throw bVar;
            } else if (this.vWY == null) {
                bVar = new b("Not all required fields were included: transfer_id");
                AppMethodBeat.o(48812);
                throw bVar;
            } else if (this.pQe == null) {
                bVar = new b("Not all required fields were included: transaction_id");
                AppMethodBeat.o(48812);
                throw bVar;
            } else if (this.pPZ == null) {
                bVar = new b("Not all required fields were included: receiver_openid");
                AppMethodBeat.o(48812);
                throw bVar;
            } else {
                AppMethodBeat.o(48812);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            py pyVar = (py) objArr[1];
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
                        pyVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48812);
                    return 0;
                case 2:
                    pyVar.cBT = aVar3.BTU.readString();
                    AppMethodBeat.o(48812);
                    return 0;
                case 3:
                    pyVar.vWY = aVar3.BTU.readString();
                    AppMethodBeat.o(48812);
                    return 0;
                case 4:
                    pyVar.pQe = aVar3.BTU.readString();
                    AppMethodBeat.o(48812);
                    return 0;
                case 5:
                    pyVar.pPZ = aVar3.BTU.readString();
                    AppMethodBeat.o(48812);
                    return 0;
                case 6:
                    pyVar.pSg = aVar3.BTU.ve();
                    AppMethodBeat.o(48812);
                    return 0;
                case 7:
                    pyVar.vWF = aVar3.BTU.readString();
                    AppMethodBeat.o(48812);
                    return 0;
                default:
                    AppMethodBeat.o(48812);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48812);
            return -1;
        }
    }
}
