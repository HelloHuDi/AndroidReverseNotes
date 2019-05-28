package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class a {
    public static int f(int i, String str) {
        AppMethodBeat.i(138998);
        int f = e.a.a.b.b.a.f(i, str);
        AppMethodBeat.o(138998);
        return f;
    }

    public static int ix(int i, int i2) {
        AppMethodBeat.i(51861);
        int fv = (e.a.a.b.b.a.fv(i) + e.a.a.b.b.a.fx(i2)) + i2;
        AppMethodBeat.o(51861);
        return fv;
    }

    public static int c(int i, int i2, LinkedList<?> linkedList) {
        int i3;
        AppMethodBeat.i(51862);
        if (linkedList != null) {
            int i4;
            switch (i2) {
                case 1:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = e.a.a.b.b.a.f(i, (String) linkedList.get(i4)) + i3;
                    }
                    break;
                case 2:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = e.a.a.b.b.a.bs(i, ((Integer) linkedList.get(i4)).intValue()) + i3;
                    }
                    break;
                case 3:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = e.a.a.b.b.a.o(i, ((Long) linkedList.get(i4)).longValue()) + i3;
                    }
                    break;
                case 4:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        ((Double) linkedList.get(i4)).doubleValue();
                        i4++;
                        i3 = (e.a.a.b.b.a.fv(i) + 8) + i3;
                    }
                    break;
                case 5:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        ((Float) linkedList.get(i4)).floatValue();
                        i4++;
                        i3 = (e.a.a.b.b.a.fv(i) + 4) + i3;
                    }
                    break;
                case 6:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = e.a.a.b.b.a.b(i, (b) linkedList.get(i4)) + i3;
                    }
                    break;
                case 7:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        ((Boolean) linkedList.get(i4)).booleanValue();
                        i4++;
                        i3 = (e.a.a.b.b.a.fv(i) + 1) + i3;
                    }
                    break;
                case 8:
                    i3 = 0;
                    i4 = 0;
                    while (i4 < linkedList.size()) {
                        i4++;
                        i3 = ix(i, ((com.tencent.mm.bt.a) linkedList.get(i4)).computeSize()) + i3;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(51862);
                    throw illegalArgumentException;
            }
        }
        i3 = 0;
        AppMethodBeat.o(51862);
        return i3;
    }

    public static int d(int i, int i2, LinkedList<?> linkedList) {
        int i3 = 0;
        AppMethodBeat.i(51863);
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
                            i4 = e.a.a.b.b.a.fx(((Integer) linkedList.get(i5)).intValue()) + i4;
                        }
                        i3 = (e.a.a.b.b.a.fx(i4) + i4) + e.a.a.b.b.a.fv(i);
                        break;
                    }
                    break;
                case 3:
                    if (linkedList.size() > 0) {
                        i4 = 0;
                        i5 = 0;
                        while (i5 < linkedList.size()) {
                            i5++;
                            i4 = e.a.a.b.b.a.aw(((Long) linkedList.get(i5)).longValue()) + i4;
                        }
                        i3 = (e.a.a.b.b.a.fx(i4) + i4) + e.a.a.b.b.a.fv(i);
                        break;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(51863);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(51863);
        return i3;
    }

    public static int d(int i, LinkedList<?> linkedList) {
        int i2 = 0;
        AppMethodBeat.i(51864);
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
                            i3 = e.a.a.b.b.a.fx(((Integer) linkedList.get(i4)).intValue()) + i3;
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
                            i3 = e.a.a.b.b.a.aw(((Long) linkedList.get(i4)).longValue()) + i3;
                        }
                        i2 = i3;
                        break;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i)));
                    AppMethodBeat.o(51864);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(51864);
        return i2;
    }

    public static int iw(int i, int i2) {
        AppMethodBeat.i(138997);
        int bs = e.a.a.b.b.a.bs(i, i2);
        AppMethodBeat.o(138997);
        return bs;
    }

    public static int Vg(int i) {
        AppMethodBeat.i(51860);
        int fv = e.a.a.b.b.a.fv(i) + 1;
        AppMethodBeat.o(51860);
        return fv;
    }
}
