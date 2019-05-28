package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class g {
    private final String dataPath;
    private a fST = null;

    public static class a {
        public int cuu = 0;
        public String extraInfo = "";
        public int fSU = 0;
        boolean fSV = false;
        public String ispName = "";
    }

    public g(String str) {
        this.dataPath = str;
    }

    public final a aki() {
        a aVar = null;
        AppMethodBeat.i(78734);
        a aVar2;
        if (this.fST != null) {
            aVar2 = this.fST;
            AppMethodBeat.o(78734);
            return aVar2;
        }
        String str = this.dataPath + "mobileinfo.ini";
        File file = new File(str);
        if (file.exists()) {
            com.tencent.mm.sdk.e.a aVar3 = new com.tencent.mm.sdk.e.a(str);
            aVar2 = new a();
            aVar2.fSU = bo.h(aVar3.anE("ispCode"));
            aVar2.ispName = aVar3.getValue("ispName");
            aVar2.cuu = bo.h(aVar3.anE("subType"));
            aVar2.extraInfo = aVar3.getValue("extraInfo");
            long lastModified = file.lastModified();
            if (CdnLogic.kMediaTypeBeatificFile == ae.giz && ae.giA > 0) {
                lastModified = bo.anU() - ((long) ae.giA);
                ab.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", Integer.valueOf(ae.giA), Long.valueOf(lastModified));
                ae.giA = 0;
            }
            if (lastModified > 0 && bo.gb(lastModified) > 259200000) {
                ab.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", Long.valueOf(bo.gb(lastModified)), str);
                aVar2.fSV = true;
            }
            ab.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", Integer.valueOf(aVar2.cuu), Integer.valueOf(aVar2.fSU), aVar2.ispName, aVar2.extraInfo, Boolean.valueOf(aVar2.fSV));
        } else {
            ab.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", str);
            aVar2 = null;
        }
        this.fST = aVar2;
        if (this.fST == null || this.fST.fSV) {
            Context context = ah.getContext();
            if (context == null) {
                ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
                    } else if (activeNetworkInfo.getType() == 1) {
                        ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
                    } else {
                        aVar = new a();
                        aVar.cuu = activeNetworkInfo.getSubtype();
                        aVar.fSU = at.getISPCode(context);
                        aVar.ispName = at.getISPName(context);
                        aVar.extraInfo = activeNetworkInfo.getExtraInfo();
                        ab.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", Integer.valueOf(aVar.cuu), Integer.valueOf(aVar.fSU), aVar.ispName, aVar.extraInfo);
                    }
                }
            }
            if (aVar == null) {
                ab.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
                aVar2 = this.fST;
                AppMethodBeat.o(78734);
                return aVar2;
            }
            this.fST = aVar;
            aVar2 = this.fST;
            if (aVar2 == null) {
                ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
            } else if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
            } else {
                com.tencent.mm.sdk.e.a aVar4 = new com.tencent.mm.sdk.e.a(str);
                aVar4.ej("ispCode", aVar2.fSU);
                aVar4.hV("ispName", aVar2.ispName);
                aVar4.ej("subType", aVar2.cuu);
                aVar4.hV("extraInfo", aVar2.extraInfo);
            }
            aVar2 = this.fST;
            AppMethodBeat.o(78734);
            return aVar2;
        }
        ab.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
        aVar2 = this.fST;
        AppMethodBeat.o(78734);
        return aVar2;
    }
}
