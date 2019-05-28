package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bky */
public final class bky extends btd {
    public String content;
    public String kdE;
    public boolean kep;
    public int status;
    public String vBF;
    public String vBG;
    public String wNR;
    public String wNS;
    public String wNT;
    public String wNU;
    public String wNV;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89122);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.vBF != null) {
                c6093a.mo13475e(2, this.vBF);
            }
            if (this.vBG != null) {
                c6093a.mo13475e(3, this.vBG);
            }
            c6093a.mo13480iz(4, this.status);
            if (this.content != null) {
                c6093a.mo13475e(5, this.content);
            }
            if (this.kdE != null) {
                c6093a.mo13475e(6, this.kdE);
            }
            if (this.wNR != null) {
                c6093a.mo13475e(7, this.wNR);
            }
            c6093a.mo13471aO(8, this.kep);
            if (this.wNS != null) {
                c6093a.mo13475e(9, this.wNS);
            }
            if (this.wNT != null) {
                c6093a.mo13475e(10, this.wNT);
            }
            if (this.wNU != null) {
                c6093a.mo13475e(11, this.wNU);
            }
            if (this.wNV != null) {
                c6093a.mo13475e(12, this.wNV);
            }
            AppMethodBeat.m2505o(89122);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vBF != null) {
                ix += C6091a.m9575f(2, this.vBF);
            }
            if (this.vBG != null) {
                ix += C6091a.m9575f(3, this.vBG);
            }
            ix += C6091a.m9572bs(4, this.status);
            if (this.content != null) {
                ix += C6091a.m9575f(5, this.content);
            }
            if (this.kdE != null) {
                ix += C6091a.m9575f(6, this.kdE);
            }
            if (this.wNR != null) {
                ix += C6091a.m9575f(7, this.wNR);
            }
            ix += C6091a.m9576fv(8) + 1;
            if (this.wNS != null) {
                ix += C6091a.m9575f(9, this.wNS);
            }
            if (this.wNT != null) {
                ix += C6091a.m9575f(10, this.wNT);
            }
            if (this.wNU != null) {
                ix += C6091a.m9575f(11, this.wNU);
            }
            if (this.wNV != null) {
                ix += C6091a.m9575f(12, this.wNV);
            }
            AppMethodBeat.m2505o(89122);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89122);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bky bky = (bky) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bky.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 2:
                    bky.vBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 3:
                    bky.vBG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 4:
                    bky.status = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 5:
                    bky.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 6:
                    bky.kdE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 7:
                    bky.wNR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 8:
                    bky.kep = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 9:
                    bky.wNS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 10:
                    bky.wNT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 11:
                    bky.wNU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                case 12:
                    bky.wNV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89122);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89122);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89122);
            return -1;
        }
    }
}
