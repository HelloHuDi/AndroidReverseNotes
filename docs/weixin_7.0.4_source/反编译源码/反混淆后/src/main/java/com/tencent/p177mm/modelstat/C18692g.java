package com.tencent.p177mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.sdk.p603e.C4894a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.modelstat.g */
public final class C18692g {
    private final String dataPath;
    private C18693a fST = null;

    /* renamed from: com.tencent.mm.modelstat.g$a */
    public static class C18693a {
        public int cuu = 0;
        public String extraInfo = "";
        public int fSU = 0;
        boolean fSV = false;
        public String ispName = "";
    }

    public C18692g(String str) {
        this.dataPath = str;
    }

    public final C18693a aki() {
        C18693a c18693a = null;
        AppMethodBeat.m2504i(78734);
        C18693a c18693a2;
        if (this.fST != null) {
            c18693a2 = this.fST;
            AppMethodBeat.m2505o(78734);
            return c18693a2;
        }
        String str = this.dataPath + "mobileinfo.ini";
        File file = new File(str);
        if (file.exists()) {
            C4894a c4894a = new C4894a(str);
            c18693a2 = new C18693a();
            c18693a2.fSU = C5046bo.m7567h(c4894a.anE("ispCode"));
            c18693a2.ispName = c4894a.getValue("ispName");
            c18693a2.cuu = C5046bo.m7567h(c4894a.anE("subType"));
            c18693a2.extraInfo = c4894a.getValue("extraInfo");
            long lastModified = file.lastModified();
            if (CdnLogic.kMediaTypeBeatificFile == C1947ae.giz && C1947ae.giA > 0) {
                lastModified = C5046bo.anU() - ((long) C1947ae.giA);
                C4990ab.m7421w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", Integer.valueOf(C1947ae.giA), Long.valueOf(lastModified));
                C1947ae.giA = 0;
            }
            if (lastModified > 0 && C5046bo.m7566gb(lastModified) > 259200000) {
                C4990ab.m7421w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", Long.valueOf(C5046bo.m7566gb(lastModified)), str);
                c18693a2.fSV = true;
            }
            C4990ab.m7417i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", Integer.valueOf(c18693a2.cuu), Integer.valueOf(c18693a2.fSU), c18693a2.ispName, c18693a2.extraInfo, Boolean.valueOf(c18693a2.fSV));
        } else {
            C4990ab.m7417i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", str);
            c18693a2 = null;
        }
        this.fST = c18693a2;
        if (this.fST == null || this.fST.fSV) {
            Context context = C4996ah.getContext();
            if (context == null) {
                C4990ab.m7412e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    C4990ab.m7412e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        C4990ab.m7412e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
                    } else if (activeNetworkInfo.getType() == 1) {
                        C4990ab.m7412e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
                    } else {
                        c18693a = new C18693a();
                        c18693a.cuu = activeNetworkInfo.getSubtype();
                        c18693a.fSU = C5023at.getISPCode(context);
                        c18693a.ispName = C5023at.getISPName(context);
                        c18693a.extraInfo = activeNetworkInfo.getExtraInfo();
                        C4990ab.m7417i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", Integer.valueOf(c18693a.cuu), Integer.valueOf(c18693a.fSU), c18693a.ispName, c18693a.extraInfo);
                    }
                }
            }
            if (c18693a == null) {
                C4990ab.m7418v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
                c18693a2 = this.fST;
                AppMethodBeat.m2505o(78734);
                return c18693a2;
            }
            this.fST = c18693a;
            c18693a2 = this.fST;
            if (c18693a2 == null) {
                C4990ab.m7412e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
            } else if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
            } else {
                C4894a c4894a2 = new C4894a(str);
                c4894a2.mo10095ej("ispCode", c18693a2.fSU);
                c4894a2.mo10097hV("ispName", c18693a2.ispName);
                c4894a2.mo10095ej("subType", c18693a2.cuu);
                c4894a2.mo10097hV("extraInfo", c18693a2.extraInfo);
            }
            c18693a2 = this.fST;
            AppMethodBeat.m2505o(78734);
            return c18693a2;
        }
        C4990ab.m7418v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
        c18693a2 = this.fST;
        AppMethodBeat.m2505o(78734);
        return c18693a2;
    }
}
