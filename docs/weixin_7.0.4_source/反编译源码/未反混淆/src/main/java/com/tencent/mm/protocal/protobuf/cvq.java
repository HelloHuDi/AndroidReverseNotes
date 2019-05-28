package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cvq extends a {
    public String wjQ;
    public String wjS;
    public cvp xrx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63697);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wjQ == null) {
                bVar = new b("Not all required fields were included: Rid");
                AppMethodBeat.o(63697);
                throw bVar;
            } else if (this.wjS == null) {
                bVar = new b("Not all required fields were included: MimeType");
                AppMethodBeat.o(63697);
                throw bVar;
            } else if (this.xrx == null) {
                bVar = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(63697);
                throw bVar;
            } else {
                if (this.wjQ != null) {
                    aVar.e(1, this.wjQ);
                }
                if (this.wjS != null) {
                    aVar.e(2, this.wjS);
                }
                if (this.xrx != null) {
                    aVar.iy(3, this.xrx.computeSize());
                    this.xrx.writeFields(aVar);
                }
                AppMethodBeat.o(63697);
                return 0;
            }
        } else if (i == 1) {
            if (this.wjQ != null) {
                f = e.a.a.b.b.a.f(1, this.wjQ) + 0;
            } else {
                f = 0;
            }
            if (this.wjS != null) {
                f += e.a.a.b.b.a.f(2, this.wjS);
            }
            if (this.xrx != null) {
                f += e.a.a.a.ix(3, this.xrx.computeSize());
            }
            AppMethodBeat.o(63697);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wjQ == null) {
                bVar = new b("Not all required fields were included: Rid");
                AppMethodBeat.o(63697);
                throw bVar;
            } else if (this.wjS == null) {
                bVar = new b("Not all required fields were included: MimeType");
                AppMethodBeat.o(63697);
                throw bVar;
            } else if (this.xrx == null) {
                bVar = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(63697);
                throw bVar;
            } else {
                AppMethodBeat.o(63697);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvq cvq = (cvq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cvq.wjQ = aVar3.BTU.readString();
                    AppMethodBeat.o(63697);
                    return 0;
                case 2:
                    cvq.wjS = aVar3.BTU.readString();
                    AppMethodBeat.o(63697);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cvp cvp = new cvp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cvp.populateBuilderWithField(aVar4, cvp, a.getNextFieldNumber(aVar4))) {
                        }
                        cvq.xrx = cvp;
                    }
                    AppMethodBeat.o(63697);
                    return 0;
                default:
                    AppMethodBeat.o(63697);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63697);
            return -1;
        }
    }
}
