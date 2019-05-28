package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.t.d;

public final class n implements e {
    public final int a(String str, c cVar) {
        int i = -1;
        AppMethodBeat.i(131628);
        AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.hYI;
        if (str == null || bo.isNullOrNil(str)) {
            ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
            AppMethodBeat.o(131628);
            return -1;
        }
        a aVar = new a();
        aVar.url = str;
        aVar.hYE = cVar;
        ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s", str);
        String genAdFileExist = appBrandVideoDownLoadMgr.genAdFileExist("gamead", aVar);
        if (bo.isNullOrNil(genAdFileExist)) {
            String genAdFilePath = appBrandVideoDownLoadMgr.genAdFilePath("gamead", aVar);
            if (bo.isNullOrNil(genAdFilePath)) {
                AppMethodBeat.o(131628);
                return -4;
            }
            d dVar = AppBrandVideoDownLoadMgr.hYJ;
            String str2 = aVar.url;
            if (d.ewX != null) {
                i = d.ewX.a(str2, genAdFilePath, dVar);
            }
            ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", genAdFilePath, Integer.valueOf(i));
            if (i != 0) {
                AppMethodBeat.o(131628);
                return -3;
            }
            AppBrandVideoDownLoadMgr.hYH.put(aVar.url, aVar);
        } else if (genAdFileExist.equalsIgnoreCase("downloading")) {
            AppMethodBeat.o(131628);
            return -2;
        } else {
            AppBrandVideoDownLoadMgr.hYH.put(aVar.url, aVar);
            AppBrandVideoDownLoadMgr.ak(aVar.url, true);
            aVar.hYE.cv(aVar.url, genAdFileExist);
        }
        AppMethodBeat.o(131628);
        return 0;
    }

    public final void report(String str) {
        AppMethodBeat.i(131629);
        AppBrandVideoDownLoadMgr.hYI.report(str);
        AppMethodBeat.o(131629);
    }

    public final String BR(String str) {
        AppMethodBeat.i(131630);
        AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.hYI;
        a aVar = new a();
        aVar.url = str;
        aVar.hYE = null;
        String genAdFileExist = appBrandVideoDownLoadMgr.genAdFileExist("gamead", aVar);
        if (bo.isNullOrNil(genAdFileExist)) {
            AppMethodBeat.o(131630);
            return null;
        } else if (genAdFileExist.equalsIgnoreCase("downloading")) {
            AppMethodBeat.o(131630);
            return null;
        } else {
            AppMethodBeat.o(131630);
            return genAdFileExist;
        }
    }
}
