package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mf */
public final class C15360mf extends C1331a {
    public String Desc;
    public String ThumbUrl;
    public String Title;
    public C35935mi vPY;
    public C46565mj vPZ;
    public C46564mc vQa;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124292);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else if (this.Desc == null) {
                c6092b = new C6092b("Not all required fields were included: Desc");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else if (this.ThumbUrl == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else if (this.vPY == null) {
                c6092b = new C6092b("Not all required fields were included: DetailInfo");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else if (this.vQa == null) {
                c6092b = new C6092b("Not all required fields were included: ActionInfo");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else {
                if (this.Title != null) {
                    c6093a.mo13475e(1, this.Title);
                }
                if (this.Desc != null) {
                    c6093a.mo13475e(2, this.Desc);
                }
                if (this.ThumbUrl != null) {
                    c6093a.mo13475e(3, this.ThumbUrl);
                }
                if (this.vPY != null) {
                    c6093a.mo13479iy(4, this.vPY.computeSize());
                    this.vPY.writeFields(c6093a);
                }
                if (this.vPZ != null) {
                    c6093a.mo13479iy(5, this.vPZ.computeSize());
                    this.vPZ.writeFields(c6093a);
                }
                if (this.vQa != null) {
                    c6093a.mo13479iy(6, this.vQa.computeSize());
                    this.vQa.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(124292);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(2, this.Desc);
            }
            if (this.ThumbUrl != null) {
                f += C6091a.m9575f(3, this.ThumbUrl);
            }
            if (this.vPY != null) {
                f += C6087a.m9557ix(4, this.vPY.computeSize());
            }
            if (this.vPZ != null) {
                f += C6087a.m9557ix(5, this.vPZ.computeSize());
            }
            if (this.vQa != null) {
                f += C6087a.m9557ix(6, this.vQa.computeSize());
            }
            AppMethodBeat.m2505o(124292);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else if (this.Desc == null) {
                c6092b = new C6092b("Not all required fields were included: Desc");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else if (this.ThumbUrl == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else if (this.vPY == null) {
                c6092b = new C6092b("Not all required fields were included: DetailInfo");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else if (this.vQa == null) {
                c6092b = new C6092b("Not all required fields were included: ActionInfo");
                AppMethodBeat.m2505o(124292);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(124292);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15360mf c15360mf = (C15360mf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c15360mf.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124292);
                    return 0;
                case 2:
                    c15360mf.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124292);
                    return 0;
                case 3:
                    c15360mf.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124292);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35935mi c35935mi = new C35935mi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35935mi.populateBuilderWithField(c6086a3, c35935mi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15360mf.vPY = c35935mi;
                    }
                    AppMethodBeat.m2505o(124292);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46565mj c46565mj = new C46565mj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46565mj.populateBuilderWithField(c6086a3, c46565mj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15360mf.vPZ = c46565mj;
                    }
                    AppMethodBeat.m2505o(124292);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46564mc c46564mc = new C46564mc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46564mc.populateBuilderWithField(c6086a3, c46564mc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15360mf.vQa = c46564mc;
                    }
                    AppMethodBeat.m2505o(124292);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124292);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124292);
            return -1;
        }
    }
}
