package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afv extends bsr {
    public String kmt;
    public String signature;
    public String tyv;
    public String vOV;
    public String wbO;
    public String wmY;
    public String wmZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11765);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wbO == null) {
                bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.wmY == null) {
                bVar = new b("Not all required fields were included: group_id");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.tyv == null) {
                bVar = new b("Not all required fields were included: time_stamp");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.kmt == null) {
                bVar = new b("Not all required fields were included: nonce_str");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.signature == null) {
                bVar = new b("Not all required fields were included: signature");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.vOV == null) {
                bVar = new b("Not all required fields were included: from_url");
                AppMethodBeat.o(11765);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wbO != null) {
                    aVar.e(2, this.wbO);
                }
                if (this.wmY != null) {
                    aVar.e(3, this.wmY);
                }
                if (this.tyv != null) {
                    aVar.e(4, this.tyv);
                }
                if (this.kmt != null) {
                    aVar.e(5, this.kmt);
                }
                if (this.signature != null) {
                    aVar.e(6, this.signature);
                }
                if (this.vOV != null) {
                    aVar.e(7, this.vOV);
                }
                if (this.wmZ != null) {
                    aVar.e(8, this.wmZ);
                }
                AppMethodBeat.o(11765);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbO != null) {
                ix += e.a.a.b.b.a.f(2, this.wbO);
            }
            if (this.wmY != null) {
                ix += e.a.a.b.b.a.f(3, this.wmY);
            }
            if (this.tyv != null) {
                ix += e.a.a.b.b.a.f(4, this.tyv);
            }
            if (this.kmt != null) {
                ix += e.a.a.b.b.a.f(5, this.kmt);
            }
            if (this.signature != null) {
                ix += e.a.a.b.b.a.f(6, this.signature);
            }
            if (this.vOV != null) {
                ix += e.a.a.b.b.a.f(7, this.vOV);
            }
            if (this.wmZ != null) {
                ix += e.a.a.b.b.a.f(8, this.wmZ);
            }
            AppMethodBeat.o(11765);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wbO == null) {
                bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.wmY == null) {
                bVar = new b("Not all required fields were included: group_id");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.tyv == null) {
                bVar = new b("Not all required fields were included: time_stamp");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.kmt == null) {
                bVar = new b("Not all required fields were included: nonce_str");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.signature == null) {
                bVar = new b("Not all required fields were included: signature");
                AppMethodBeat.o(11765);
                throw bVar;
            } else if (this.vOV == null) {
                bVar = new b("Not all required fields were included: from_url");
                AppMethodBeat.o(11765);
                throw bVar;
            } else {
                AppMethodBeat.o(11765);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afv afv = (afv) objArr[1];
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
                        afv.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11765);
                    return 0;
                case 2:
                    afv.wbO = aVar3.BTU.readString();
                    AppMethodBeat.o(11765);
                    return 0;
                case 3:
                    afv.wmY = aVar3.BTU.readString();
                    AppMethodBeat.o(11765);
                    return 0;
                case 4:
                    afv.tyv = aVar3.BTU.readString();
                    AppMethodBeat.o(11765);
                    return 0;
                case 5:
                    afv.kmt = aVar3.BTU.readString();
                    AppMethodBeat.o(11765);
                    return 0;
                case 6:
                    afv.signature = aVar3.BTU.readString();
                    AppMethodBeat.o(11765);
                    return 0;
                case 7:
                    afv.vOV = aVar3.BTU.readString();
                    AppMethodBeat.o(11765);
                    return 0;
                case 8:
                    afv.wmZ = aVar3.BTU.readString();
                    AppMethodBeat.o(11765);
                    return 0;
                default:
                    AppMethodBeat.o(11765);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11765);
            return -1;
        }
    }
}
