package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rh extends bsr {
    public String cvZ;
    public String fileid;
    public String vYy;
    public int vYz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135754);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fileid == null) {
                bVar = new b("Not all required fields were included: fileid");
                AppMethodBeat.o(135754);
                throw bVar;
            } else if (this.cvZ == null) {
                bVar = new b("Not all required fields were included: md5");
                AppMethodBeat.o(135754);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.fileid != null) {
                    aVar.e(2, this.fileid);
                }
                if (this.cvZ != null) {
                    aVar.e(3, this.cvZ);
                }
                if (this.vYy != null) {
                    aVar.e(4, this.vYy);
                }
                aVar.iz(5, this.vYz);
                AppMethodBeat.o(135754);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fileid != null) {
                ix += e.a.a.b.b.a.f(2, this.fileid);
            }
            if (this.cvZ != null) {
                ix += e.a.a.b.b.a.f(3, this.cvZ);
            }
            if (this.vYy != null) {
                ix += e.a.a.b.b.a.f(4, this.vYy);
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.vYz);
            AppMethodBeat.o(135754);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.fileid == null) {
                bVar = new b("Not all required fields were included: fileid");
                AppMethodBeat.o(135754);
                throw bVar;
            } else if (this.cvZ == null) {
                bVar = new b("Not all required fields were included: md5");
                AppMethodBeat.o(135754);
                throw bVar;
            } else {
                AppMethodBeat.o(135754);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rh rhVar = (rh) objArr[1];
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
                        rhVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(135754);
                    return 0;
                case 2:
                    rhVar.fileid = aVar3.BTU.readString();
                    AppMethodBeat.o(135754);
                    return 0;
                case 3:
                    rhVar.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(135754);
                    return 0;
                case 4:
                    rhVar.vYy = aVar3.BTU.readString();
                    AppMethodBeat.o(135754);
                    return 0;
                case 5:
                    rhVar.vYz = aVar3.BTU.vd();
                    AppMethodBeat.o(135754);
                    return 0;
                default:
                    AppMethodBeat.o(135754);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135754);
            return -1;
        }
    }
}
