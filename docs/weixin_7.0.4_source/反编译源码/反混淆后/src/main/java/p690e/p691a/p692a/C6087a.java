package p690e.p691a.p692a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.p695b.p697b.C6091a;

/* renamed from: e.a.a.a */
public final class C6087a {
    /* renamed from: f */
    public static int m9555f(int i, String str) {
        AppMethodBeat.m2504i(138998);
        int f = C6091a.m9575f(i, str);
        AppMethodBeat.m2505o(138998);
        return f;
    }

    /* renamed from: ix */
    public static int m9557ix(int i, int i2) {
        AppMethodBeat.m2504i(51861);
        int fv = (C6091a.m9576fv(i) + C6091a.m9577fx(i2)) + i2;
        AppMethodBeat.m2505o(51861);
        return fv;
    }

    /* renamed from: c */
    public static int m9552c(int i, int i2, LinkedList<?> linkedList) {
        int i3;
        AppMethodBeat.m2504i(51862);
        if (linkedList != null) {
            int i4;
            switch (i2) {
                case 1:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = C6091a.m9575f(i, (String) linkedList.get(i4)) + i3;
                    }
                    break;
                case 2:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = C6091a.m9572bs(i, ((Integer) linkedList.get(i4)).intValue()) + i3;
                    }
                    break;
                case 3:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = C6091a.m9578o(i, ((Long) linkedList.get(i4)).longValue()) + i3;
                    }
                    break;
                case 4:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        ((Double) linkedList.get(i4)).doubleValue();
                        i4++;
                        i3 = (C6091a.m9576fv(i) + 8) + i3;
                    }
                    break;
                case 5:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        ((Float) linkedList.get(i4)).floatValue();
                        i4++;
                        i3 = (C6091a.m9576fv(i) + 4) + i3;
                    }
                    break;
                case 6:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = C6091a.m9571b(i, (C1332b) linkedList.get(i4)) + i3;
                    }
                    break;
                case 7:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        ((Boolean) linkedList.get(i4)).booleanValue();
                        i4++;
                        i3 = (C6091a.m9576fv(i) + 1) + i3;
                    }
                    break;
                case 8:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = C6087a.m9557ix(i, ((C1331a) linkedList.get(i4)).computeSize()) + i3;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i2)));
                    AppMethodBeat.m2505o(51862);
                    throw illegalArgumentException;
            }
        }
        i3 = 0;
        AppMethodBeat.m2505o(51862);
        return i3;
    }

    /* renamed from: d */
    public static int m9553d(int i, int i2, LinkedList<?> linkedList) {
        int i3 = 0;
        AppMethodBeat.m2504i(51863);
        if (linkedList != null) {
            int i4;
            int i5;
            switch (i2) {
                case 2:
                    if (linkedList.size() > 0) {
                        i4 = 0;
                        i5 = 0;
                        while (i5 < linkedList.size()) {
                            i5++;
                            i4 = C6091a.m9577fx(((Integer) linkedList.get(i5)).intValue()) + i4;
                        }
                        i3 = (C6091a.m9577fx(i4) + i4) + C6091a.m9576fv(i);
                        break;
                    }
                    break;
                case 3:
                    if (linkedList.size() > 0) {
                        i4 = 0;
                        i5 = 0;
                        while (i5 < linkedList.size()) {
                            i5++;
                            i4 = C6091a.m9570aw(((Long) linkedList.get(i5)).longValue()) + i4;
                        }
                        i3 = (C6091a.m9577fx(i4) + i4) + C6091a.m9576fv(i);
                        break;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i2)));
                    AppMethodBeat.m2505o(51863);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(51863);
        return i3;
    }

    /* renamed from: d */
    public static int m9554d(int i, LinkedList<?> linkedList) {
        int i2 = 0;
        AppMethodBeat.m2504i(51864);
        if (linkedList != null) {
            int i3;
            int i4;
            switch (i) {
                case 2:
                    if (linkedList.size() > 0) {
                        i3 = 0;
                        i4 = 0;
                        while (i4 < linkedList.size()) {
                            i4++;
                            i3 = C6091a.m9577fx(((Integer) linkedList.get(i4)).intValue()) + i3;
                        }
                        i2 = i3;
                        break;
                    }
                    break;
                case 3:
                    if (linkedList.size() > 0) {
                        i3 = 0;
                        i4 = 0;
                        while (i4 < linkedList.size()) {
                            i4++;
                            i3 = C6091a.m9570aw(((Long) linkedList.get(i4)).longValue()) + i3;
                        }
                        i2 = i3;
                        break;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i)));
                    AppMethodBeat.m2505o(51864);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(51864);
        return i2;
    }

    /* renamed from: iw */
    public static int m9556iw(int i, int i2) {
        AppMethodBeat.m2504i(138997);
        int bs = C6091a.m9572bs(i, i2);
        AppMethodBeat.m2505o(138997);
        return bs;
    }

    /* renamed from: Vg */
    public static int m9551Vg(int i) {
        AppMethodBeat.m2504i(51860);
        int fv = C6091a.m9576fv(i) + 1;
        AppMethodBeat.m2505o(51860);
        return fv;
    }
}
