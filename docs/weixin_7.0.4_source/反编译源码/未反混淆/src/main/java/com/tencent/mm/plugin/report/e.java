package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Map;

public enum e implements d {
    ;
    
    d pXb;

    static class a implements d {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(long j, long j2, long j3, boolean z) {
            AppMethodBeat.i(115101);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115101);
        }

        public final void hB(int i) {
            AppMethodBeat.i(115102);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115102);
        }

        public final void e(int i, Object... objArr) {
            AppMethodBeat.i(115103);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115103);
        }

        public final void X(int i, String str) {
            AppMethodBeat.i(115104);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115104);
        }

        public final void a(int i, String str, boolean z, boolean z2) {
            AppMethodBeat.i(115105);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115105);
        }

        public final void a(int i, boolean z, boolean z2, Object... objArr) {
            AppMethodBeat.i(115106);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115106);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            AppMethodBeat.i(115107);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115107);
        }

        public final void d(int i, int i2, int i3, int i4, boolean z) {
            AppMethodBeat.i(115108);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115108);
        }

        public final void g(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.i(115109);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115109);
        }

        public final void b(ArrayList<IDKey> arrayList, boolean z) {
            AppMethodBeat.i(115110);
            ab.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(115110);
        }
    }

    private e(String str) {
        AppMethodBeat.i(115113);
        this.pXb = new a();
        AppMethodBeat.o(115113);
    }

    static {
        AppMethodBeat.o(115125);
    }

    public final void e(int i, Object... objArr) {
        AppMethodBeat.i(115114);
        this.pXb.e(i, objArr);
        AppMethodBeat.o(115114);
    }

    public final void X(int i, String str) {
        AppMethodBeat.i(115115);
        this.pXb.X(i, str);
        AppMethodBeat.o(115115);
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        AppMethodBeat.i(115116);
        this.pXb.a(i, str, z, z2);
        AppMethodBeat.o(115116);
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        AppMethodBeat.i(115117);
        this.pXb.a(i, z, z2, objArr);
        AppMethodBeat.o(115117);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        AppMethodBeat.i(115118);
        ab.d("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        this.pXb.a(j, j2, j3, z);
        AppMethodBeat.o(115118);
    }

    public final void b(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.i(115119);
        this.pXb.b(arrayList, z);
        AppMethodBeat.o(115119);
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        AppMethodBeat.i(115120);
        ab.d("MicroMsg.ReportService", "idkeyGroupForPair [%d, %d] -> %d / [%d, %d] -> %d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i6));
        this.pXb.a(i, i2, i3, i4, i5, i6, z);
        AppMethodBeat.o(115120);
    }

    public final void d(int i, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(115121);
        ab.d("MicroMsg.ReportService", "idkeyGroupForPairAverger [%d, %d] -> %d / [%d, %d] -> 1", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3));
        this.pXb.d(i, i2, i3, i4, z);
        AppMethodBeat.o(115121);
    }

    public final void hB(int i) {
        AppMethodBeat.i(115122);
        this.pXb.hB(i);
        AppMethodBeat.o(115122);
    }

    public static Object a(int i, int[] iArr, Object[] objArr) {
        int i2 = 0;
        if (iArr.length <= 0 || iArr.length + 1 != objArr.length) {
            return null;
        }
        if (i <= iArr[0]) {
            return objArr[0];
        }
        while (i2 < iArr.length - 1) {
            if (iArr[i2] >= iArr[i2 + 1]) {
                return null;
            }
            if (i > iArr[i2] && i <= iArr[i2 + 1]) {
                return objArr[i2 + 1];
            }
            i2++;
        }
        return objArr[objArr.length - 1];
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(115123);
        Object valueOf;
        if (iArr == null || iArr.length <= 0 || i3 <= i2 || i3 > 255 || iArr.length != i3 - i2) {
            AppMethodBeat.o(115123);
            return null;
        } else if (i <= iArr[0]) {
            valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(115123);
            return valueOf;
        } else {
            while (i4 < iArr.length - 1) {
                if (iArr[i4] >= iArr[i4 + 1]) {
                    AppMethodBeat.o(115123);
                    return null;
                } else if (i <= iArr[i4] || i > iArr[i4 + 1]) {
                    i4++;
                } else {
                    valueOf = Integer.valueOf(i4 + (i2 + 1));
                    AppMethodBeat.o(115123);
                    return valueOf;
                }
            }
            valueOf = Integer.valueOf(i3);
            AppMethodBeat.o(115123);
            return valueOf;
        }
    }

    public final void g(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.i(115124);
        this.pXb.g(str, str2, map);
        AppMethodBeat.o(115124);
    }
}
