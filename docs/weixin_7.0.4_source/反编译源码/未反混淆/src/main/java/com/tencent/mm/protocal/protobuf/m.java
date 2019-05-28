package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class m extends btd {
    public int kCl = 268513600;
    public String kCm = "请求不成功，请稍候再试";
    public String kCx;
    public String kCy;
    public int vAa;
    public int vAb;
    public long vAc;
    public long vAd;
    public int vzZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56681);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56681);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kCl);
            if (this.kCm != null) {
                aVar.e(3, this.kCm);
            }
            aVar.iz(4, this.vzZ);
            aVar.iz(5, this.vAa);
            aVar.iz(6, this.vAb);
            aVar.ai(7, this.vAc);
            aVar.ai(8, this.vAd);
            if (this.kCx != null) {
                aVar.e(9, this.kCx);
            }
            if (this.kCy != null) {
                aVar.e(10, this.kCy);
            }
            AppMethodBeat.o(56681);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kCl);
            if (this.kCm != null) {
                ix += e.a.a.b.b.a.f(3, this.kCm);
            }
            ix = ((((ix + e.a.a.b.b.a.bs(4, this.vzZ)) + e.a.a.b.b.a.bs(5, this.vAa)) + e.a.a.b.b.a.bs(6, this.vAb)) + e.a.a.b.b.a.o(7, this.vAc)) + e.a.a.b.b.a.o(8, this.vAd);
            if (this.kCx != null) {
                ix += e.a.a.b.b.a.f(9, this.kCx);
            }
            if (this.kCy != null) {
                ix += e.a.a.b.b.a.f(10, this.kCy);
            }
            AppMethodBeat.o(56681);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56681);
                throw bVar;
            }
            AppMethodBeat.o(56681);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56681);
                    return 0;
                case 2:
                    mVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56681);
                    return 0;
                case 3:
                    mVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(56681);
                    return 0;
                case 4:
                    mVar.vzZ = aVar3.BTU.vd();
                    AppMethodBeat.o(56681);
                    return 0;
                case 5:
                    mVar.vAa = aVar3.BTU.vd();
                    AppMethodBeat.o(56681);
                    return 0;
                case 6:
                    mVar.vAb = aVar3.BTU.vd();
                    AppMethodBeat.o(56681);
                    return 0;
                case 7:
                    mVar.vAc = aVar3.BTU.ve();
                    AppMethodBeat.o(56681);
                    return 0;
                case 8:
                    mVar.vAd = aVar3.BTU.ve();
                    AppMethodBeat.o(56681);
                    return 0;
                case 9:
                    mVar.kCx = aVar3.BTU.readString();
                    AppMethodBeat.o(56681);
                    return 0;
                case 10:
                    mVar.kCy = aVar3.BTU.readString();
                    AppMethodBeat.o(56681);
                    return 0;
                default:
                    AppMethodBeat.o(56681);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56681);
            return -1;
        }
    }
}
