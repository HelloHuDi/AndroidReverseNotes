package com.tencent.p177mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.report.e */
public enum C7053e implements C3735d {
    ;
    
    C3735d pXb;

    /* renamed from: com.tencent.mm.plugin.report.e$a */
    static class C7052a implements C3735d {
        private C7052a() {
        }

        /* synthetic */ C7052a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo8378a(long j, long j2, long j3, boolean z) {
            AppMethodBeat.m2504i(115101);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115101);
        }

        /* renamed from: hB */
        public final void mo8383hB(int i) {
            AppMethodBeat.m2504i(115102);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115102);
        }

        /* renamed from: e */
        public final void mo8381e(int i, Object... objArr) {
            AppMethodBeat.m2504i(115103);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115103);
        }

        /* renamed from: X */
        public final void mo8374X(int i, String str) {
            AppMethodBeat.m2504i(115104);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115104);
        }

        /* renamed from: a */
        public final void mo8376a(int i, String str, boolean z, boolean z2) {
            AppMethodBeat.m2504i(115105);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115105);
        }

        /* renamed from: a */
        public final void mo8377a(int i, boolean z, boolean z2, Object... objArr) {
            AppMethodBeat.m2504i(115106);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115106);
        }

        /* renamed from: a */
        public final void mo8375a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            AppMethodBeat.m2504i(115107);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115107);
        }

        /* renamed from: d */
        public final void mo8380d(int i, int i2, int i3, int i4, boolean z) {
            AppMethodBeat.m2504i(115108);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115108);
        }

        /* renamed from: g */
        public final void mo8382g(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.m2504i(115109);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115109);
        }

        /* renamed from: b */
        public final void mo8379b(ArrayList<IDKey> arrayList, boolean z) {
            AppMethodBeat.m2504i(115110);
            C4990ab.m7416i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.m2505o(115110);
        }
    }

    private C7053e(String str) {
        AppMethodBeat.m2504i(115113);
        this.pXb = new C7052a();
        AppMethodBeat.m2505o(115113);
    }

    static {
        AppMethodBeat.m2505o(115125);
    }

    /* renamed from: e */
    public final void mo8381e(int i, Object... objArr) {
        AppMethodBeat.m2504i(115114);
        this.pXb.mo8381e(i, objArr);
        AppMethodBeat.m2505o(115114);
    }

    /* renamed from: X */
    public final void mo8374X(int i, String str) {
        AppMethodBeat.m2504i(115115);
        this.pXb.mo8374X(i, str);
        AppMethodBeat.m2505o(115115);
    }

    /* renamed from: a */
    public final void mo8376a(int i, String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(115116);
        this.pXb.mo8376a(i, str, z, z2);
        AppMethodBeat.m2505o(115116);
    }

    /* renamed from: a */
    public final void mo8377a(int i, boolean z, boolean z2, Object... objArr) {
        AppMethodBeat.m2504i(115117);
        this.pXb.mo8377a(i, z, z2, objArr);
        AppMethodBeat.m2505o(115117);
    }

    /* renamed from: a */
    public final void mo8378a(long j, long j2, long j3, boolean z) {
        AppMethodBeat.m2504i(115118);
        C4990ab.m7411d("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        this.pXb.mo8378a(j, j2, j3, z);
        AppMethodBeat.m2505o(115118);
    }

    /* renamed from: b */
    public final void mo8379b(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.m2504i(115119);
        this.pXb.mo8379b(arrayList, z);
        AppMethodBeat.m2505o(115119);
    }

    /* renamed from: a */
    public final void mo8375a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        AppMethodBeat.m2504i(115120);
        C4990ab.m7411d("MicroMsg.ReportService", "idkeyGroupForPair [%d, %d] -> %d / [%d, %d] -> %d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i6));
        this.pXb.mo8375a(i, i2, i3, i4, i5, i6, z);
        AppMethodBeat.m2505o(115120);
    }

    /* renamed from: d */
    public final void mo8380d(int i, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.m2504i(115121);
        C4990ab.m7411d("MicroMsg.ReportService", "idkeyGroupForPairAverger [%d, %d] -> %d / [%d, %d] -> 1", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3));
        this.pXb.mo8380d(i, i2, i3, i4, z);
        AppMethodBeat.m2505o(115121);
    }

    /* renamed from: hB */
    public final void mo8383hB(int i) {
        AppMethodBeat.m2504i(115122);
        this.pXb.mo8383hB(i);
        AppMethodBeat.m2505o(115122);
    }

    /* renamed from: a */
    public static Object m11772a(int i, int[] iArr, Object[] objArr) {
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

    /* renamed from: a */
    public static Object m11771a(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.m2504i(115123);
        Object valueOf;
        if (iArr == null || iArr.length <= 0 || i3 <= i2 || i3 > 255 || iArr.length != i3 - i2) {
            AppMethodBeat.m2505o(115123);
            return null;
        } else if (i <= iArr[0]) {
            valueOf = Integer.valueOf(i2);
            AppMethodBeat.m2505o(115123);
            return valueOf;
        } else {
            while (i4 < iArr.length - 1) {
                if (iArr[i4] >= iArr[i4 + 1]) {
                    AppMethodBeat.m2505o(115123);
                    return null;
                } else if (i <= iArr[i4] || i > iArr[i4 + 1]) {
                    i4++;
                } else {
                    valueOf = Integer.valueOf(i4 + (i2 + 1));
                    AppMethodBeat.m2505o(115123);
                    return valueOf;
                }
            }
            valueOf = Integer.valueOf(i3);
            AppMethodBeat.m2505o(115123);
            return valueOf;
        }
    }

    /* renamed from: g */
    public final void mo8382g(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.m2504i(115124);
        this.pXb.mo8382g(str, str2, map);
        AppMethodBeat.m2505o(115124);
    }
}
