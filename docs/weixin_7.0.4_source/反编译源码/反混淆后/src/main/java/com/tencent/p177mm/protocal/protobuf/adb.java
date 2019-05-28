package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.adb */
public final class adb extends C1331a {
    public String Title;
    public int type;
    public LinkedList<acv> wkO = new LinkedList();
    public LinkedList<add> wkP = new LinkedList();
    public String wkQ;
    public String wkR;
    public LinkedList<adc> wkS = new LinkedList();
    public int wkT;
    public boolean wkU;

    public adb() {
        AppMethodBeat.m2504i(112430);
        AppMethodBeat.m2505o(112430);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(112431);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            c6093a.mo13480iz(2, this.type);
            c6093a.mo13474e(3, 8, this.wkO);
            c6093a.mo13474e(4, 8, this.wkP);
            if (this.wkQ != null) {
                c6093a.mo13475e(5, this.wkQ);
            }
            if (this.wkR != null) {
                c6093a.mo13475e(6, this.wkR);
            }
            c6093a.mo13474e(7, 8, this.wkS);
            c6093a.mo13480iz(8, this.wkT);
            c6093a.mo13471aO(9, this.wkU);
            AppMethodBeat.m2505o(112431);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f = ((f + C6091a.m9572bs(2, this.type)) + C6087a.m9552c(3, 8, this.wkO)) + C6087a.m9552c(4, 8, this.wkP);
            if (this.wkQ != null) {
                f += C6091a.m9575f(5, this.wkQ);
            }
            if (this.wkR != null) {
                f += C6091a.m9575f(6, this.wkR);
            }
            int c = ((f + C6087a.m9552c(7, 8, this.wkS)) + C6091a.m9572bs(8, this.wkT)) + (C6091a.m9576fv(9) + 1);
            AppMethodBeat.m2505o(112431);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wkO.clear();
            this.wkP.clear();
            this.wkS.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(112431);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            adb adb = (adb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    adb.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112431);
                    return 0;
                case 2:
                    adb.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(112431);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acv acv = new acv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = acv.populateBuilderWithField(c6086a3, acv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adb.wkO.add(acv);
                    }
                    AppMethodBeat.m2505o(112431);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        add add = new add();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = add.populateBuilderWithField(c6086a3, add, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adb.wkP.add(add);
                    }
                    AppMethodBeat.m2505o(112431);
                    return 0;
                case 5:
                    adb.wkQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112431);
                    return 0;
                case 6:
                    adb.wkR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112431);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        adc adc = new adc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = adc.populateBuilderWithField(c6086a3, adc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adb.wkS.add(adc);
                    }
                    AppMethodBeat.m2505o(112431);
                    return 0;
                case 8:
                    adb.wkT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(112431);
                    return 0;
                case 9:
                    adb.wkU = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(112431);
                    return 0;
                default:
                    AppMethodBeat.m2505o(112431);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(112431);
            return -1;
        }
    }
}
