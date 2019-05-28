package com.tencent.mm.plugin.fts.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class e {
    public static final int[] mCK = new int[]{8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25, 26, 15, 28, 29};
    public static final a mCL = new a();
    public static String mCM = "";

    public static final class a {
        public long mCN = 0;
        public long mCO = 0;
        public long mCP = 0;
        public long mCQ = 0;
        public long mCR = 0;
    }

    static {
        AppMethodBeat.i(114217);
        AppMethodBeat.o(114217);
    }

    public static final void i(int i, long j, long j2) {
        AppMethodBeat.i(114210);
        if (d.e(i, mCK)) {
            int i2;
            g.RN();
            long longValue = new p(com.tencent.mm.kernel.a.QF()).longValue();
            if (d.vxp) {
                if (longValue % 100 != 1) {
                    AppMethodBeat.o(114210);
                    return;
                }
            } else if (d.vxq && longValue % 10 != 1) {
                AppMethodBeat.o(114210);
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
            ab.v("MicroMsg.FTS.FTSReportApiLogic", "reportKVSearchTime: %d %s", Integer.valueOf(14175), String.format(str, objArr));
            com.tencent.mm.plugin.report.e.pXa.X(14175, r0);
            AppMethodBeat.o(114210);
            return;
        }
        AppMethodBeat.o(114210);
    }

    public static void K(int i, long j) {
        AppMethodBeat.i(114211);
        if (i > 0) {
            int i2 = ((i - 1) * 2) + 1;
            ab.v("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d time=%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j));
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
            com.tencent.mm.plugin.report.e.pXa.b(arrayList, false);
        }
        AppMethodBeat.o(114211);
    }

    public static void L(int i, long j) {
        AppMethodBeat.i(114212);
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
            com.tencent.mm.plugin.report.e.pXa.b(arrayList, false);
        }
        AppMethodBeat.o(114212);
    }

    public static void vV(int i) {
        AppMethodBeat.i(114213);
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
        com.tencent.mm.plugin.report.e.pXa.b(arrayList, false);
        AppMethodBeat.o(114213);
    }

    public static final void vW(int i) {
        AppMethodBeat.i(114214);
        ab.i("MicroMsg.FTS.FTSReportApiLogic", "reportCommonChatroom: %d %d", Integer.valueOf(14731), Integer.valueOf(i));
        com.tencent.mm.plugin.report.e.pXa.e(14731, Integer.valueOf(i));
        AppMethodBeat.o(114214);
    }

    public static final void bAj() {
        AppMethodBeat.i(114215);
        ab.i("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeyFTSData %d %d %d %d %d", Long.valueOf(mCL.mCN), Long.valueOf(mCL.mCO), Long.valueOf(mCL.mCP), Long.valueOf(mCL.mCR), Long.valueOf(mCL.mCQ));
        ArrayList arrayList = new ArrayList();
        c(arrayList, 0);
        if (mCL.mCN > 1536) {
            c(arrayList, 1);
        }
        if (mCL.mCO >= 10000) {
            c(arrayList, 2);
        }
        if (mCL.mCP >= 5000) {
            c(arrayList, 3);
        }
        if (mCL.mCR >= 10000) {
            c(arrayList, 4);
        }
        if (mCL.mCQ >= 1000000) {
            c(arrayList, 5);
        }
        com.tencent.mm.plugin.report.e.pXa.b(arrayList, false);
        AppMethodBeat.o(114215);
    }

    private static final void c(ArrayList<IDKey> arrayList, int i) {
        AppMethodBeat.i(114216);
        IDKey iDKey = new IDKey();
        iDKey.SetID(729);
        iDKey.SetKey(i);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        AppMethodBeat.o(114216);
    }
}
