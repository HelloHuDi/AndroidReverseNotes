package com.tencent.p177mm.plugin.fts.p419a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.fts.a.e */
public final class C3163e {
    public static final int[] mCK = new int[]{8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25, 26, 15, 28, 29};
    public static final C3164a mCL = new C3164a();
    public static String mCM = "";

    /* renamed from: com.tencent.mm.plugin.fts.a.e$a */
    public static final class C3164a {
        public long mCN = 0;
        public long mCO = 0;
        public long mCP = 0;
        public long mCQ = 0;
        public long mCR = 0;
    }

    static {
        AppMethodBeat.m2504i(114217);
        AppMethodBeat.m2505o(114217);
    }

    /* renamed from: i */
    public static final void m5422i(int i, long j, long j2) {
        AppMethodBeat.m2504i(114210);
        if (C3161d.m5414e(i, mCK)) {
            int i2;
            C1720g.m3534RN();
            long longValue = new C1183p(C1668a.m3383QF()).longValue();
            if (C7243d.vxp) {
                if (longValue % 100 != 1) {
                    AppMethodBeat.m2505o(114210);
                    return;
                }
            } else if (C7243d.vxq && longValue % 10 != 1) {
                AppMethodBeat.m2505o(114210);
                return;
            }
            String str = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
            Object[] objArr = new Object[11];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Long.valueOf(j);
            objArr[3] = Integer.valueOf(0);
            if (mCL.mCN >= 1536) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[4] = Integer.valueOf(i2);
            objArr[5] = Long.valueOf(mCL.mCN);
            objArr[6] = Long.valueOf(mCL.mCO);
            objArr[7] = Long.valueOf(mCL.mCP);
            objArr[8] = Long.valueOf(mCL.mCQ);
            objArr[9] = Long.valueOf(mCL.mCR);
            objArr[10] = Long.valueOf(j2);
            C4990ab.m7419v("MicroMsg.FTS.FTSReportApiLogic", "reportKVSearchTime: %d %s", Integer.valueOf(14175), String.format(str, objArr));
            C7053e.pXa.mo8374X(14175, r0);
            AppMethodBeat.m2505o(114210);
            return;
        }
        AppMethodBeat.m2505o(114210);
    }

    /* renamed from: K */
    public static void m5419K(int i, long j) {
        AppMethodBeat.m2504i(114211);
        if (i > 0) {
            int i2 = ((i - 1) * 2) + 1;
            C4990ab.m7419v("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d time=%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j));
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(601);
            iDKey.SetKey(i2);
            iDKey.SetValue((long) ((int) j));
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(601);
            iDKey.SetKey(i2 + 1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            C7053e.pXa.mo8379b(arrayList, false);
        }
        AppMethodBeat.m2505o(114211);
    }

    /* renamed from: L */
    public static void m5420L(int i, long j) {
        AppMethodBeat.m2504i(114212);
        if (i > 0) {
            int i2 = ((i - 1) * 4) + 1;
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(602);
            iDKey.SetKey(i2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            if (j <= 100) {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 1);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            } else if (j <= 500) {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 2);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            } else {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 3);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            }
            C7053e.pXa.mo8379b(arrayList, false);
        }
        AppMethodBeat.m2505o(114212);
    }

    /* renamed from: vV */
    public static void m5423vV(int i) {
        AppMethodBeat.m2504i(114213);
        IDKey iDKey = new IDKey();
        iDKey.SetID(146);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        if (i != 1) {
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(i);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        } else {
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        C7053e.pXa.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(114213);
    }

    /* renamed from: vW */
    public static final void m5424vW(int i) {
        AppMethodBeat.m2504i(114214);
        C4990ab.m7417i("MicroMsg.FTS.FTSReportApiLogic", "reportCommonChatroom: %d %d", Integer.valueOf(14731), Integer.valueOf(i));
        C7053e.pXa.mo8381e(14731, Integer.valueOf(i));
        AppMethodBeat.m2505o(114214);
    }

    public static final void bAj() {
        AppMethodBeat.m2504i(114215);
        C4990ab.m7417i("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeyFTSData %d %d %d %d %d", Long.valueOf(mCL.mCN), Long.valueOf(mCL.mCO), Long.valueOf(mCL.mCP), Long.valueOf(mCL.mCR), Long.valueOf(mCL.mCQ));
        ArrayList arrayList = new ArrayList();
        C3163e.m5421c(arrayList, 0);
        if (mCL.mCN > 1536) {
            C3163e.m5421c(arrayList, 1);
        }
        if (mCL.mCO >= 10000) {
            C3163e.m5421c(arrayList, 2);
        }
        if (mCL.mCP >= 5000) {
            C3163e.m5421c(arrayList, 3);
        }
        if (mCL.mCR >= 10000) {
            C3163e.m5421c(arrayList, 4);
        }
        if (mCL.mCQ >= 1000000) {
            C3163e.m5421c(arrayList, 5);
        }
        C7053e.pXa.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(114215);
    }

    /* renamed from: c */
    private static final void m5421c(ArrayList<IDKey> arrayList, int i) {
        AppMethodBeat.m2504i(114216);
        IDKey iDKey = new IDKey();
        iDKey.SetID(729);
        iDKey.SetKey(i);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        AppMethodBeat.m2505o(114216);
    }
}
