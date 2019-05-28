package e.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a {
    public final byte[] BTW;
    private final e.a.a.b.b.a BTX;
    public final OutputStream output = null;

    public a(byte[] bArr) {
        AppMethodBeat.i(51910);
        this.BTW = bArr;
        this.BTX = new e.a.a.b.b.a(bArr, bArr.length);
        AppMethodBeat.o(51910);
    }

    public final void aO(int i, boolean z) {
        AppMethodBeat.i(51911);
        this.BTX.aN(i, z);
        AppMethodBeat.o(51911);
    }

    public final void c(int i, b bVar) {
        AppMethodBeat.i(51912);
        this.BTX.a(i, bVar);
        AppMethodBeat.o(51912);
    }

    public final void f(int i, double d) {
        AppMethodBeat.i(51913);
        this.BTX.f(i, d);
        AppMethodBeat.o(51913);
    }

    public final void r(int i, float f) {
        AppMethodBeat.i(51914);
        this.BTX.r(i, f);
        AppMethodBeat.o(51914);
    }

    public final void iz(int i, int i2) {
        AppMethodBeat.i(51915);
        this.BTX.bq(i, i2);
        AppMethodBeat.o(51915);
    }

    public final void iA(int i, int i2) {
        AppMethodBeat.i(139001);
        iz(i, i2);
        AppMethodBeat.o(139001);
    }

    public final void ai(int i, long j) {
        AppMethodBeat.i(51917);
        this.BTX.m(i, j);
        AppMethodBeat.o(51917);
    }

    public final void e(int i, String str) {
        AppMethodBeat.i(51918);
        this.BTX.e(i, str);
        AppMethodBeat.o(51918);
    }

    public final void iy(int i, int i2) {
        AppMethodBeat.i(51919);
        this.BTX.iy(i, i2);
        AppMethodBeat.o(51919);
    }

    /* JADX WARNING: Missing block: B:5:0x0021, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:6:0x0025, code skipped:
            if (r1 < r8.size()) goto L_0x002b;
     */
    /* JADX WARNING: Missing block: B:7:0x0027, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51920);
     */
    /* JADX WARNING: Missing block: B:8:0x002b, code skipped:
            c(r6, (com.tencent.mm.bt.b) r8.get(r1));
            r0 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:9:0x0039, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:10:0x003d, code skipped:
            if (r1 < r8.size()) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:11:0x003f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51920);
     */
    /* JADX WARNING: Missing block: B:12:0x0043, code skipped:
            f(r6, ((java.lang.Double) r8.get(r1)).doubleValue());
            r0 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:13:0x0055, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:14:0x0059, code skipped:
            if (r1 < r8.size()) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:15:0x005b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51920);
     */
    /* JADX WARNING: Missing block: B:16:0x005f, code skipped:
            r(r6, ((java.lang.Float) r8.get(r1)).floatValue());
            r0 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:17:0x0071, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:18:0x0075, code skipped:
            if (r1 < r8.size()) goto L_0x007b;
     */
    /* JADX WARNING: Missing block: B:19:0x0077, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51920);
     */
    /* JADX WARNING: Missing block: B:20:0x007b, code skipped:
            iz(r6, ((java.lang.Integer) r8.get(r1)).intValue());
            r0 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:21:0x008d, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:22:0x0091, code skipped:
            if (r1 < r8.size()) goto L_0x0097;
     */
    /* JADX WARNING: Missing block: B:23:0x0093, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51920);
     */
    /* JADX WARNING: Missing block: B:24:0x0097, code skipped:
            ai(r6, ((java.lang.Long) r8.get(r1)).longValue());
            r0 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:25:0x00a9, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:26:0x00ad, code skipped:
            if (r1 < r8.size()) goto L_0x00b4;
     */
    /* JADX WARNING: Missing block: B:27:0x00af, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51920);
     */
    /* JADX WARNING: Missing block: B:28:0x00b4, code skipped:
            e(r6, (java.lang.String) r8.get(r1));
            r0 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:29:0x00c2, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:30:0x00c6, code skipped:
            if (r1 < r8.size()) goto L_0x00cd;
     */
    /* JADX WARNING: Missing block: B:31:0x00c8, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51920);
     */
    /* JADX WARNING: Missing block: B:32:0x00cd, code skipped:
            aO(r6, ((java.lang.Boolean) r8.get(r1)).booleanValue());
            r0 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:33:0x00df, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:34:0x00e3, code skipped:
            if (r1 < r8.size()) goto L_0x00ea;
     */
    /* JADX WARNING: Missing block: B:35:0x00e5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51920);
     */
    /* JADX WARNING: Missing block: B:36:0x00ea, code skipped:
            r0 = (com.tencent.mm.bt.a) r8.get(r1);
            iy(r6, r0.computeSize());
            r0.writeFields(r5);
            r0 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:47:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:48:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:49:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:51:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:52:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(int i, int i2, LinkedList<?> linkedList) {
        int i3 = 0;
        AppMethodBeat.i(51920);
        if (linkedList != null) {
            switch (i2) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(51920);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(51920);
    }

    public final void f(int i, int i2, LinkedList<?> linkedList) {
        int i3 = 0;
        AppMethodBeat.i(51921);
        if (linkedList != null) {
            int i4;
            switch (i2) {
                case 2:
                    if (linkedList.size() > 0) {
                        this.BTX.bu(i, 2);
                        this.BTX.fw(e.a.a.a.d(i2, linkedList));
                        while (true) {
                            i4 = i3;
                            if (i4 >= linkedList.size()) {
                                AppMethodBeat.o(51921);
                                return;
                            } else {
                                this.BTX.fw(((Integer) linkedList.get(i4)).intValue());
                                i3 = i4 + 1;
                            }
                        }
                    }
                    break;
                case 3:
                    if (linkedList.size() > 0) {
                        this.BTX.bu(i, 2);
                        this.BTX.fw(e.a.a.a.d(i2, linkedList));
                        while (true) {
                            i4 = i3;
                            if (i4 >= linkedList.size()) {
                                AppMethodBeat.o(51921);
                                return;
                            } else {
                                this.BTX.av(((Long) linkedList.get(i4)).longValue());
                                i3 = i4 + 1;
                            }
                        }
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(51921);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(51921);
    }
}
