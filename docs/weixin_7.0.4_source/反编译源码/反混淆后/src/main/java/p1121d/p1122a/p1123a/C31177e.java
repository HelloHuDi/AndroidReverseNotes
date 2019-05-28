package p1121d.p1122a.p1123a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: d.a.a.e */
public final class C31177e extends C1331a {
    public String BTG;
    public String BTH;
    public String BTI;
    public String BTJ;
    public String BTK;
    public int BTL;
    public C24578d BTM;
    public C1332b BTN;
    public C1332b BTO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(57010);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BTG != null) {
                c6093a.mo13475e(1, this.BTG);
            }
            if (this.BTH != null) {
                c6093a.mo13475e(2, this.BTH);
            }
            if (this.BTI != null) {
                c6093a.mo13475e(3, this.BTI);
            }
            if (this.BTJ != null) {
                c6093a.mo13475e(4, this.BTJ);
            }
            if (this.BTK != null) {
                c6093a.mo13475e(5, this.BTK);
            }
            c6093a.mo13480iz(6, this.BTL);
            if (this.BTM != null) {
                c6093a.mo13479iy(7, this.BTM.computeSize());
                this.BTM.writeFields(c6093a);
            }
            if (this.BTN != null) {
                c6093a.mo13473c(8, this.BTN);
            }
            if (this.BTO != null) {
                c6093a.mo13473c(9, this.BTO);
            }
            AppMethodBeat.m2505o(57010);
            return 0;
        } else if (i == 1) {
            if (this.BTG != null) {
                f = C6091a.m9575f(1, this.BTG) + 0;
            } else {
                f = 0;
            }
            if (this.BTH != null) {
                f += C6091a.m9575f(2, this.BTH);
            }
            if (this.BTI != null) {
                f += C6091a.m9575f(3, this.BTI);
            }
            if (this.BTJ != null) {
                f += C6091a.m9575f(4, this.BTJ);
            }
            if (this.BTK != null) {
                f += C6091a.m9575f(5, this.BTK);
            }
            f += C6091a.m9572bs(6, this.BTL);
            if (this.BTM != null) {
                f += C6087a.m9557ix(7, this.BTM.computeSize());
            }
            if (this.BTN != null) {
                f += C6091a.m9571b(8, this.BTN);
            }
            if (this.BTO != null) {
                f += C6091a.m9571b(9, this.BTO);
            }
            AppMethodBeat.m2505o(57010);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(57010);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C31177e c31177e = (C31177e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c31177e.BTG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57010);
                    return 0;
                case 2:
                    c31177e.BTH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57010);
                    return 0;
                case 3:
                    c31177e.BTI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57010);
                    return 0;
                case 4:
                    c31177e.BTJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57010);
                    return 0;
                case 5:
                    c31177e.BTK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57010);
                    return 0;
                case 6:
                    c31177e.BTL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(57010);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C24578d c24578d = new C24578d();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c24578d.populateBuilderWithField(c6086a3, c24578d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c31177e.BTM = c24578d;
                    }
                    AppMethodBeat.m2505o(57010);
                    return 0;
                case 8:
                    c31177e.BTN = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(57010);
                    return 0;
                case 9:
                    c31177e.BTO = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(57010);
                    return 0;
                default:
                    AppMethodBeat.m2505o(57010);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(57010);
            return -1;
        }
    }
}
