package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.e */
public final class C45998e extends C1331a {
    public String Desc;
    public String Name;
    public int Version;
    public int jBT;
    public boolean mZA;
    public boolean mZB;
    public boolean mZC;
    public boolean mZD;
    public C43165cg mZE;
    public int mZF;
    public C28187bx mZG;
    public LinkedList<String> mZH = new LinkedList();
    public String mZm;
    public String mZo;
    public String mZr;
    public String mZs;
    public String mZt;
    public String mZu;
    public int mZv;
    public C20958q mZw;
    public int mZx;
    public boolean mZy;
    public LinkedList<String> mZz = new LinkedList();

    public C45998e() {
        AppMethodBeat.m2504i(111545);
        AppMethodBeat.m2505o(111545);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111546);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZr == null) {
                c6092b = new C6092b("Not all required fields were included: AppID");
                AppMethodBeat.m2505o(111546);
                throw c6092b;
            } else if (this.mZs == null) {
                c6092b = new C6092b("Not all required fields were included: IconURL");
                AppMethodBeat.m2505o(111546);
                throw c6092b;
            } else {
                if (this.mZr != null) {
                    c6093a.mo13475e(1, this.mZr);
                }
                if (this.mZs != null) {
                    c6093a.mo13475e(2, this.mZs);
                }
                if (this.Name != null) {
                    c6093a.mo13475e(3, this.Name);
                }
                if (this.Desc != null) {
                    c6093a.mo13475e(4, this.Desc);
                }
                if (this.mZt != null) {
                    c6093a.mo13475e(5, this.mZt);
                }
                if (this.mZm != null) {
                    c6093a.mo13475e(6, this.mZm);
                }
                if (this.mZu != null) {
                    c6093a.mo13475e(7, this.mZu);
                }
                c6093a.mo13480iz(8, this.mZv);
                if (this.mZw != null) {
                    c6093a.mo13479iy(9, this.mZw.computeSize());
                    this.mZw.writeFields(c6093a);
                }
                c6093a.mo13480iz(10, this.jBT);
                c6093a.mo13480iz(11, this.mZx);
                if (this.mZo != null) {
                    c6093a.mo13475e(12, this.mZo);
                }
                c6093a.mo13471aO(13, this.mZy);
                c6093a.mo13474e(14, 1, this.mZz);
                c6093a.mo13471aO(15, this.mZA);
                c6093a.mo13480iz(16, this.Version);
                c6093a.mo13471aO(17, this.mZB);
                c6093a.mo13471aO(18, this.mZC);
                c6093a.mo13471aO(19, this.mZD);
                if (this.mZE != null) {
                    c6093a.mo13479iy(20, this.mZE.computeSize());
                    this.mZE.writeFields(c6093a);
                }
                c6093a.mo13480iz(21, this.mZF);
                if (this.mZG != null) {
                    c6093a.mo13479iy(22, this.mZG.computeSize());
                    this.mZG.writeFields(c6093a);
                }
                c6093a.mo13474e(23, 1, this.mZH);
                AppMethodBeat.m2505o(111546);
                return 0;
            }
        } else if (i == 1) {
            if (this.mZr != null) {
                f = C6091a.m9575f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.mZs != null) {
                f += C6091a.m9575f(2, this.mZs);
            }
            if (this.Name != null) {
                f += C6091a.m9575f(3, this.Name);
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(4, this.Desc);
            }
            if (this.mZt != null) {
                f += C6091a.m9575f(5, this.mZt);
            }
            if (this.mZm != null) {
                f += C6091a.m9575f(6, this.mZm);
            }
            if (this.mZu != null) {
                f += C6091a.m9575f(7, this.mZu);
            }
            f += C6091a.m9572bs(8, this.mZv);
            if (this.mZw != null) {
                f += C6087a.m9557ix(9, this.mZw.computeSize());
            }
            f = (f + C6091a.m9572bs(10, this.jBT)) + C6091a.m9572bs(11, this.mZx);
            if (this.mZo != null) {
                f += C6091a.m9575f(12, this.mZo);
            }
            f = ((((((f + (C6091a.m9576fv(13) + 1)) + C6087a.m9552c(14, 1, this.mZz)) + (C6091a.m9576fv(15) + 1)) + C6091a.m9572bs(16, this.Version)) + (C6091a.m9576fv(17) + 1)) + (C6091a.m9576fv(18) + 1)) + (C6091a.m9576fv(19) + 1);
            if (this.mZE != null) {
                f += C6087a.m9557ix(20, this.mZE.computeSize());
            }
            f += C6091a.m9572bs(21, this.mZF);
            if (this.mZG != null) {
                f += C6087a.m9557ix(22, this.mZG.computeSize());
            }
            int c = f + C6087a.m9552c(23, 1, this.mZH);
            AppMethodBeat.m2505o(111546);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mZz.clear();
            this.mZH.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.mZr == null) {
                c6092b = new C6092b("Not all required fields were included: AppID");
                AppMethodBeat.m2505o(111546);
                throw c6092b;
            } else if (this.mZs == null) {
                c6092b = new C6092b("Not all required fields were included: IconURL");
                AppMethodBeat.m2505o(111546);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111546);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45998e c45998e = (C45998e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c45998e.mZr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 2:
                    c45998e.mZs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 3:
                    c45998e.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 4:
                    c45998e.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 5:
                    c45998e.mZt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 6:
                    c45998e.mZm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 7:
                    c45998e.mZu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 8:
                    c45998e.mZv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20958q c20958q = new C20958q();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20958q.populateBuilderWithField(c6086a3, c20958q, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45998e.mZw = c20958q;
                    }
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 10:
                    c45998e.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 11:
                    c45998e.mZx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 12:
                    c45998e.mZo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 13:
                    c45998e.mZy = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 14:
                    c45998e.mZz.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 15:
                    c45998e.mZA = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 16:
                    c45998e.Version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 17:
                    c45998e.mZB = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 18:
                    c45998e.mZC = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 19:
                    c45998e.mZD = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43165cg c43165cg = new C43165cg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43165cg.populateBuilderWithField(c6086a3, c43165cg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45998e.mZE = c43165cg;
                    }
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 21:
                    c45998e.mZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28187bx c28187bx = new C28187bx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28187bx.populateBuilderWithField(c6086a3, c28187bx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45998e.mZG = c28187bx;
                    }
                    AppMethodBeat.m2505o(111546);
                    return 0;
                case 23:
                    c45998e.mZH.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(111546);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111546);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111546);
            return -1;
        }
    }
}
