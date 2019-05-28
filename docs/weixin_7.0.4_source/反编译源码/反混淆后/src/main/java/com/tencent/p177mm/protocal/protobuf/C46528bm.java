package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bm */
public final class C46528bm extends bsr {
    public String bssid;
    public int cvd;
    public String qEg;
    public int scene;
    public String ssid;
    public int type;
    public C1332b vDA;
    public C1332b vDB;
    public int vDK;
    public C44104bl vDL;
    public C46529bo vDM;
    public int vDN;
    public int vDO;
    public int vDP;
    public String vDt;
    public long vDu;
    public int vDw;
    public String vDy;
    public int vDz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94497);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.qEg != null) {
                c6093a.mo13475e(2, this.qEg);
            }
            c6093a.mo13480iz(3, this.scene);
            c6093a.mo13480iz(4, this.type);
            c6093a.mo13480iz(5, this.vDK);
            if (this.ssid != null) {
                c6093a.mo13475e(6, this.ssid);
            }
            if (this.bssid != null) {
                c6093a.mo13475e(7, this.bssid);
            }
            c6093a.mo13472ai(8, this.vDu);
            if (this.vDL != null) {
                c6093a.mo13479iy(9, this.vDL.computeSize());
                this.vDL.writeFields(c6093a);
            }
            if (this.vDM != null) {
                c6093a.mo13479iy(10, this.vDM.computeSize());
                this.vDM.writeFields(c6093a);
            }
            c6093a.mo13480iz(11, this.vDw);
            if (this.vDt != null) {
                c6093a.mo13475e(12, this.vDt);
            }
            c6093a.mo13480iz(13, this.cvd);
            if (this.vDy != null) {
                c6093a.mo13475e(14, this.vDy);
            }
            c6093a.mo13480iz(15, this.vDN);
            c6093a.mo13480iz(16, this.vDO);
            c6093a.mo13480iz(17, this.vDP);
            c6093a.mo13480iz(18, this.vDz);
            if (this.vDA != null) {
                c6093a.mo13473c(19, this.vDA);
            }
            if (this.vDB != null) {
                c6093a.mo13473c(20, this.vDB);
            }
            AppMethodBeat.m2505o(94497);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.qEg != null) {
                ix += C6091a.m9575f(2, this.qEg);
            }
            ix = ((ix + C6091a.m9572bs(3, this.scene)) + C6091a.m9572bs(4, this.type)) + C6091a.m9572bs(5, this.vDK);
            if (this.ssid != null) {
                ix += C6091a.m9575f(6, this.ssid);
            }
            if (this.bssid != null) {
                ix += C6091a.m9575f(7, this.bssid);
            }
            ix += C6091a.m9578o(8, this.vDu);
            if (this.vDL != null) {
                ix += C6087a.m9557ix(9, this.vDL.computeSize());
            }
            if (this.vDM != null) {
                ix += C6087a.m9557ix(10, this.vDM.computeSize());
            }
            ix += C6091a.m9572bs(11, this.vDw);
            if (this.vDt != null) {
                ix += C6091a.m9575f(12, this.vDt);
            }
            ix += C6091a.m9572bs(13, this.cvd);
            if (this.vDy != null) {
                ix += C6091a.m9575f(14, this.vDy);
            }
            ix = (((ix + C6091a.m9572bs(15, this.vDN)) + C6091a.m9572bs(16, this.vDO)) + C6091a.m9572bs(17, this.vDP)) + C6091a.m9572bs(18, this.vDz);
            if (this.vDA != null) {
                ix += C6091a.m9571b(19, this.vDA);
            }
            if (this.vDB != null) {
                ix += C6091a.m9571b(20, this.vDB);
            }
            AppMethodBeat.m2505o(94497);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94497);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46528bm c46528bm = (C46528bm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46528bm.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 2:
                    c46528bm.qEg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 3:
                    c46528bm.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 4:
                    c46528bm.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 5:
                    c46528bm.vDK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 6:
                    c46528bm.ssid = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 7:
                    c46528bm.bssid = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 8:
                    c46528bm.vDu = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44104bl c44104bl = new C44104bl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44104bl.populateBuilderWithField(c6086a3, c44104bl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46528bm.vDL = c44104bl;
                    }
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46529bo c46529bo = new C46529bo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46529bo.populateBuilderWithField(c6086a3, c46529bo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46528bm.vDM = c46529bo;
                    }
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 11:
                    c46528bm.vDw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 12:
                    c46528bm.vDt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 13:
                    c46528bm.cvd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 14:
                    c46528bm.vDy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 15:
                    c46528bm.vDN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 16:
                    c46528bm.vDO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 17:
                    c46528bm.vDP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 18:
                    c46528bm.vDz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 19:
                    c46528bm.vDA = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                case 20:
                    c46528bm.vDB = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(94497);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94497);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94497);
            return -1;
        }
    }
}
