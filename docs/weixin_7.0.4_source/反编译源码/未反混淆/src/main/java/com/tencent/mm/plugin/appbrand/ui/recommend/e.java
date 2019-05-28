package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Iterator;

public final class e {
    public static void a(long j, anl anl) {
        int i;
        AppMethodBeat.i(138150);
        if (anl == null || anl.wsl == null) {
            i = 0;
        } else {
            i = anl.wsl.size();
        }
        b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", "doReportCgiGet costTime:%d, list size:%d", Long.valueOf(j), Integer.valueOf(i));
        IDKey iDKey = new IDKey();
        iDKey.SetID(FilterEnum4Shaka.MIC_SHAKA_ADD2_8);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        if (anl == null) {
            iDKey = new IDKey();
            iDKey.SetID(FilterEnum4Shaka.MIC_SHAKA_ADD2_8);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        } else if (anl.wsl == null || anl.wsl.size() == 0) {
            iDKey = new IDKey();
            iDKey.SetID(FilterEnum4Shaka.MIC_SHAKA_ADD2_8);
            iDKey.SetKey(2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        } else {
            iDKey = new IDKey();
            iDKey.SetID(FilterEnum4Shaka.MIC_SHAKA_ADD2_8);
            iDKey.SetKey(3);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        iDKey = new IDKey();
        iDKey.SetID(FilterEnum4Shaka.MIC_SHAKA_ADD2_8);
        iDKey.SetKey(5);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(FilterEnum4Shaka.MIC_SHAKA_ADD2_8);
        iDKey.SetKey(gt(j));
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        h.pYm.b(arrayList, true);
        r(arrayList);
        AppMethodBeat.o(138150);
    }

    private static int gt(long j) {
        if (j <= 1) {
            return 6;
        }
        if (1 < j && j <= 3) {
            return 7;
        }
        if (3 < j && j <= 5) {
            return 8;
        }
        if (5 < j && j <= 10) {
            return 9;
        }
        if (10 >= j || j > 20) {
            return 11;
        }
        return 10;
    }

    public static void pX(int i) {
        AppMethodBeat.i(138151);
        b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", "doReportDataSource");
        IDKey iDKey = new IDKey();
        iDKey.SetID(FilterEnum4Shaka.MIC_SHAKA_ADD2_8);
        iDKey.SetKey(18);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(FilterEnum4Shaka.MIC_SHAKA_ADD2_8);
        if (i == 1) {
            iDKey.SetKey(19);
        } else {
            iDKey.SetKey(20);
        }
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        h.pYm.b(arrayList, true);
        r(arrayList);
        AppMethodBeat.o(138151);
    }

    private static void r(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(138152);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idkeyGroupStat:  id:1043");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            stringBuilder.append(", key:" + iDKey.GetKey() + " value:" + iDKey.GetValue());
        }
        b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", stringBuilder.toString());
        AppMethodBeat.o(138152);
    }
}
