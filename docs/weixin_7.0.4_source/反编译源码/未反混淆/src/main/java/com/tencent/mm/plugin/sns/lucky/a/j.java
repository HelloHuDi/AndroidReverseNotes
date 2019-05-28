package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.util.Map;

public final class j implements a {
    public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";

    public final void a(e.a aVar) {
        AppMethodBeat.i(35888);
        ab.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
        b.kT(74);
        if (aVar == null || aVar.eAB == null) {
            ab.e(TAG, "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(35888);
            return;
        }
        i iVar = new i();
        Object a = aa.a(aVar.eAB.vED);
        iVar.jvt = new StringBuffer();
        Map z = br.z(a, "sysmsg");
        iVar.qHa.clear();
        if (z == null) {
            ab.i("MicroMsg.NewYearSnsTips", "errr for paser %s", a);
            b.kT(75);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                String str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr = new Object[2];
                objArr[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr[1] = "BeginTime";
                long anl = bo.anl((String) z.get(String.format(str, objArr)));
                iVar.jvt.append("BeginTime:" + anl + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr2 = new Object[2];
                objArr2[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr2[1] = "EndTime";
                long anl2 = bo.anl((String) z.get(String.format(str, objArr2)));
                iVar.jvt.append("EndTime:" + anl2 + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr3 = new Object[2];
                objArr3[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr3[1] = "ActionID";
                str = bo.bc((String) z.get(String.format(str, objArr3)), "");
                iVar.jvt.append("ActionID:" + str + ";");
                if (bo.isNullOrNil(str)) {
                    break;
                }
                String str2 = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr4 = new Object[2];
                objArr4[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr4[1] = "TipsMessage";
                String bc = bo.bc((String) z.get(String.format(str2, objArr4)), "");
                iVar.jvt.append("TipsMessage:" + bc + ";\n");
                h hVar = new h();
                hVar.qGX = str;
                hVar.fKn = anl;
                hVar.jCF = anl2;
                hVar.qGY = bc;
                iVar.qHa.add(hVar);
                i = i2 + 1;
            }
            if (iVar.qHa.size() == 0) {
                b.kT(76);
            }
        }
        ab.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + iVar.jvt.toString());
        g.RQ();
        g.RP().Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_TIP_STRING_SYNC, a);
        g.RQ();
        g.RP().Ry().dsb();
        AppMethodBeat.o(35888);
    }
}
