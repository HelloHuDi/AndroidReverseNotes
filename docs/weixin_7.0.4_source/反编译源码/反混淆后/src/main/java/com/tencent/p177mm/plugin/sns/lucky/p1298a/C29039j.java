package com.tencent.p177mm.plugin.sns.lucky.p1298a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.lucky.a.j */
public final class C29039j implements C1837a {
    public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";

    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(35888);
        C4990ab.m7416i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
        C21904b.m33474kT(74);
        if (c1197a == null || c1197a.eAB == null) {
            C4990ab.m7412e(TAG, "onPreAddMessage cmdAM is null");
            AppMethodBeat.m2505o(35888);
            return;
        }
        C21906i c21906i = new C21906i();
        Object a = C1946aa.m4148a(c1197a.eAB.vED);
        c21906i.jvt = new StringBuffer();
        Map z = C5049br.m7595z(a, "sysmsg");
        c21906i.qHa.clear();
        if (z == null) {
            C4990ab.m7417i("MicroMsg.NewYearSnsTips", "errr for paser %s", a);
            C21904b.m33474kT(75);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                String str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr = new Object[2];
                objArr[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr[1] = "BeginTime";
                long anl = C5046bo.anl((String) z.get(String.format(str, objArr)));
                c21906i.jvt.append("BeginTime:" + anl + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr2 = new Object[2];
                objArr2[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr2[1] = "EndTime";
                long anl2 = C5046bo.anl((String) z.get(String.format(str, objArr2)));
                c21906i.jvt.append("EndTime:" + anl2 + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr3 = new Object[2];
                objArr3[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr3[1] = "ActionID";
                str = C5046bo.m7532bc((String) z.get(String.format(str, objArr3)), "");
                c21906i.jvt.append("ActionID:" + str + ";");
                if (C5046bo.isNullOrNil(str)) {
                    break;
                }
                String str2 = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr4 = new Object[2];
                objArr4[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr4[1] = "TipsMessage";
                String bc = C5046bo.m7532bc((String) z.get(String.format(str2, objArr4)), "");
                c21906i.jvt.append("TipsMessage:" + bc + ";\n");
                C29038h c29038h = new C29038h();
                c29038h.qGX = str;
                c29038h.fKn = anl;
                c29038h.jCF = anl2;
                c29038h.qGY = bc;
                c21906i.qHa.add(c29038h);
                i = i2 + 1;
            }
            if (c21906i.qHa.size() == 0) {
                C21904b.m33474kT(76);
            }
        }
        C4990ab.m7416i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + c21906i.jvt.toString());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_TIP_STRING_SYNC, a);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(35888);
    }
}
